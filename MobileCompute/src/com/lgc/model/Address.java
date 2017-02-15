package com.lgc.model;

public class Address {
	private String ipAddress;
	private int port;
	public Address(String string, String string2) {
		this.ipAddress = string;
		this.port = Integer.parseInt(string2);
	}
	public Address() {
		
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	} 
	
}
