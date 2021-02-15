package com.spring.tour.controller;

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

import com.spring.tour.service.ChatService;



@Controller
@ServerEndpoint(value = "/echo1.do")
public class WebSocketChat1 {
	
	@Autowired
	private ChatService service;
	int cnt = 0;
	String username = "";
	private static final List<Session> sessionList = new ArrayList<Session>(); // hashmap Ű�� id ������ �̸�����?
	private static final Logger logger = LoggerFactory.getLogger(WebSocketChat1.class);
	public WebSocketChat1() {
		System.out.println("������(����) ��ü ����!");
	}
	
	@OnOpen
	public void onOpen(Session session) {
		cnt=0; // �Ź� ���ö����� �̸� �������� ����
		logger.info("Open Session id : " + session.getId());
		try {
			final Basic basic = session.getBasicRemote(); // ���� ������ �����Է�!
			basic.sendText("SYSTEM��ȭ�濡 ����Ǿ����ϴ�");
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
			for(Session session : WebSocketChat1.sessionList) {

				if(!self.getId().equals(session.getId())) { //������ ����� ���� �ƴϸ� 
					session.getBasicRemote().sendText(message); //���濡�� �������� �޼���
					//session.getBasicRemote().sendText(sender+""+message); //�̰� ���濡�� �������� �޼���
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
		if(cnt++==0) {
			username=message;
		}
		System.out.println("�޼���!! : "+message);
		
		String sender = message.split(",")[1];
		message=message.split(",")[0];	
		
		logger.info("Message From "+sender+":"+message);
		try {
			final Basic basic = session.getBasicRemote(); // ���� ������ �����Է�!
			basic.sendText("#$#"+message); // �����ڸ� ������� ���� ó�� ����
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		sendAllSessionToMessage(session, sender, message); // ��뿡�� ������
	}
	
	@OnError
	public void error(Throwable e, Session session) {
	}
	
	@OnClose
	public void onClose(Session session) {
		logger.info("Session "+session.getId()+ "has ended");
		sessionList.remove(session);
		service.isWaiting(username);
	}
	
}
