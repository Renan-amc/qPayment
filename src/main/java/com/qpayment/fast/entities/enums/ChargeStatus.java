package com.qpayment.fast.entities.enums;

public enum ChargeStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);

	private int code;
	
	private ChargeStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static ChargeStatus valueOf(int code) {
		for(ChargeStatus value: ChargeStatus.values()) {
			if(value.getCode() == code) return value;
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
