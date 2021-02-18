package com.spring.tour.webSocket;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import com.spring.tour.service.ChatService;


@ServerEndpoint(value = "/echo3.do", configurator = SpringConfigurator.class)
public class WebSocketChat3 {
	
	@Autowired
	private ChatService service;
	int cnt = 0;
	String username = "";
	
	private static final List<Session> sessionList = new ArrayList<Session>();
	private static final Logger logger = LoggerFactory.getLogger(WebSocketChat3.class);
	public WebSocketChat3() {
		System.out.println("������(����) ��ü ����!");
	}
	
	@OnOpen
	public void onOpen(Session session) {
		cnt=0; // �Ź� ���ö����� �̸� �������� ����
		logger.info("Open Session id : " + session.getId());
		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("SYSTEM��ȭ�濡 ���� �Ǿ����ϴ�");
		}catch(Exception e) {
			e.printStackTrace();
		}
		sessionList.add(session); // ä�ÿ� ���� ���� ��� ����
	}
	
	/*
	 * ��� ����ڿ��� �޼����� �����Ѵ�
	 * @param self
	 * @param sender
	 * @param message
	 */
	private void sendAllSessionToMessage(Session self, String sender, String message) {
		try {
			for(Session session : WebSocketChat3.sessionList) {
				if(!self.getId().equals(session.getId())) {
					session.getBasicRemote().sendText(message);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * ���� �Է��ϴ� �޼���
	 * @param message
	 * @param session
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		
		String sender = message.split(",")[1];
		message=message.split(",")[0];
		
		if(cnt++==0) {
			username=sender;
			sendAllSessionToMessage(session, "SYSTEM", "SYSTEM"+message);
			return;
		}
		
		logger.info("Message From "+sender+":"+message);
		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("#$#"+message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		sendAllSessionToMessage(session, sender, message);
	}
	
	@OnError
	public void error(Throwable e, Session session) {
		
	}
	
	@OnClose
	public void onClose(Session session) {
		logger.info("Session "+session.getId()+ "has ended");
		sessionList.remove(session);
		System.out.println(username);
		service.isWaiting(username);
	}
	
	
	
	
	
	
}
