package com.spring.tour.vo;

import java.sql.Date;

public class Service_questionVo { // ���񽺹��ǻ���
	private int service_question_number; //���񽺹��ǹ�ȣ
	private String user_id; //���̵�
	private int service_number;	//���� ������ȣ (����,���񽺰�����ȣ����.)
	private String service_question_content;	// ���� ���� ����
	private Date service_question_date;	// ���� ���� ��¥
	private int cate_number;	// ī�װ� ��ȣ
	private String service_title; //���� ���� ����
	public int getService_question_number() {
		return service_question_number;
	}
	public void setService_question_number(int service_question_number) {
		this.service_question_number = service_question_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getService_number() {
		return service_number;
	}
	public void setService_number(int service_number) {
		this.service_number = service_number;
	}
	public String getService_question_content() {
		return service_question_content;
	}
	public void setService_question_content(String service_question_content) {
		this.service_question_content = service_question_content;
	}
	public Date getService_question_date() {
		return service_question_date;
	}
	public void setService_question_date(Date service_question_date) {
		this.service_question_date = service_question_date;
	}
	public int getCate_number() {
		return cate_number;
	}
	public void setCate_number(int cate_number) {
		this.cate_number = cate_number;
	}
	public String getService_title() {
		return service_title;
	}
	public void setService_title(String service_title) {
		this.service_title = service_title;
	}
	@Override
	public String toString() {
		return "Service_questionVo [service_question_number=" + service_question_number + ", user_id=" + user_id
				+ ", service_number=" + service_number + ", service_question_content=" + service_question_content
				+ ", service_question_date=" + service_question_date + ", cate_number=" + cate_number
				+ ", service_title=" + service_title + "]";
	}
	public Service_questionVo(int service_question_number, String user_id, int service_number,
			String service_question_content, Date service_question_date, int cate_number, String service_title) {
		super();
		this.service_question_number = service_question_number;
		this.user_id = user_id;
		this.service_number = service_number;
		this.service_question_content = service_question_content;
		this.service_question_date = service_question_date;
		this.cate_number = cate_number;
		this.service_title = service_title;
	}
	public Service_questionVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}