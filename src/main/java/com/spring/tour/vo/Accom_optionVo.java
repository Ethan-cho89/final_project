package com.spring.tour.vo;

public class Accom_optionVo {
	private int accom_option_number; // ���� �ɼǹ�ȣ
	private int accom_service_number; // ���� ���� ��ȣ
	private int accom_rooms_option; //���ҹ� �ɼ�
	private int accom_count; //���Һ�������
	private int accom_price; //���� ���
	public Accom_optionVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Accom_optionVo(int accom_option_number, int accom_service_number, int accom_rooms_option,
			int accom_count, int accom_price) { 
		super();
		this.accom_option_number = accom_option_number;
		this.accom_service_number = accom_service_number;
		this.accom_rooms_option = accom_rooms_option;
		this.accom_count = accom_count;
		this.accom_price = accom_price;
	}
	public int getAccom_option_number() {
		return accom_option_number;
	}
	public int getAccom_service_number() {
		return accom_service_number;
	}
	public int getAccom_rooms_option() {
		return accom_rooms_option;
	}
	public int getAccom_count() {
		return accom_count;
	}
	public int getAccom_price() {
		return accom_price;
	}
	public void setAccom_option_number(int accom_option_number) {
		this.accom_option_number = accom_option_number;
	}
	public void setAccom_service_number(int accom_service_number) {
		this.accom_service_number = accom_service_number;
	}
	public void setAccom_rooms_option(int accom_rooms_option) {
		this.accom_rooms_option = accom_rooms_option;
	}
	public void setAccom_count(int accom_count) {
		this.accom_count = accom_count;
	}
	public void setAccom_price(int accom_price) {
		this.accom_price = accom_price;
	}
	@Override
	public String toString() {
		return "Accom_roomsVo [accom_option_number=" + accom_option_number + ", accom_service_number="
				+ accom_service_number + ", accom_rooms_option=" + accom_rooms_option + ", accom_count=" + accom_count + ", accom_price=" + accom_price + "]";
	}
	
}
