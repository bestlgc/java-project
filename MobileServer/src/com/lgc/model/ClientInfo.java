package com.lgc.model;

public class ClientInfo {
	private String clientId;
	private String clientPublicKey;
	public String getClientId() {
		return clientId;
	}
	public ClientInfo(String string, String string2) {
		this.clientId = string;
		this.clientPublicKey = string2;
		
	}
	public ClientInfo() {
		
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientPublicKey() {
		return clientPublicKey;
	}
	public void setClientPublicKey(String clientPublicKey) {
		this.clientPublicKey = clientPublicKey;
	}
	
	
	
}
