package com.spring.tour.vo;

public class Tour_infoVo {
	private int tour_info_number; //�������� ������ȣ
	private int service_number;//���� ���� ��ȣ
	private String tour_content;// �����
	private String tour_how; // �����̿� �ȳ�
	private String tour_rule; // ��� �� ȯ�� ����
	public Tour_infoVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tour_infoVo(int tour_info_number, int service_number, String tour_content, String tour_how,
			String tour_rule) {
		super();
		this.tour_info_number = tour_info_number;
		this.service_number = service_number;
		this.tour_content = tour_content;
		this.tour_how = tour_how;
		this.tour_rule = tour_rule;
	}
	public int getTour_info_number() {
		return tour_info_number;
	}
	public int getService_number() {
		return service_number;
	}
	public String getTour_content() {
		return tour_content;
	}
	public String getTour_how() {
		return tour_how;
	}
	public String getTour_rule() {
		return tour_rule;
	}
	public void setTour_info_number(int tour_info_number) {
		this.tour_info_number = tour_info_number;
	}
	public void setService_number(int service_number) {
		this.service_number = service_number;
	}
	public void setTour_content(String tour_content) {
		this.tour_content = tour_content;
	}
	public void setTour_how(String tour_how) {
		this.tour_how = tour_how;
	}
	public void setTour_rule(String tour_rule) {
		this.tour_rule = tour_rule;
	}
	@Override
	public String toString() {
		return "Tour_infoVo [tour_info_number=" + tour_info_number + ", service_number=" + service_number
				+ ", tour_content=" + tour_content + ", tour_how=" + tour_how + ", tour_rule=" + tour_rule + "]";
	}
}
