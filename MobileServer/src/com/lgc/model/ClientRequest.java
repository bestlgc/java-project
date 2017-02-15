package com.lgc.model;

public class ClientRequest {
	private String requestType;
	private String content;
	private Address address;
	private ClientInfo clientInfo;
	private String command;
	private String extension;
	
	
	public ClientRequest(Address address,ClientInfo clinetInfo) {
		this.address = address;
		this.clientInfo = clinetInfo;
	}
	
	public ClientRequest(String requestType,String content,Address address,ClientInfo clinetInfo,String command,String extension) {
		this.requestType = requestType;
		this.content = content;
		this.address = address;
		this.clientInfo = clinetInfo;
		this.command = command;
		this.extension = extension;
	}
	
	public String toString() {
		String result = null;
		
		return result;
	}
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public ClientInfo getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(ClientInfo clinetInfo) {
		this.clientInfo = clinetInfo;
	}
	
	
}
