package com.lgc.util;


import com.lgc.model.Address;
import com.lgc.model.ClientInfo;
import com.lgc.model.ClientRequest;
import com.lgc.model.Constraint;
import com.lgc.model.ServerResponse;

public class ObjectUtil {
	public static String reqToStr(ClientRequest clr) {
		String result = null;
		result = clr.getClientInfo().getClientId()+ Constraint.SPLIT_STRING + clr.getClientInfo().getClientPublicKey() +
				Constraint.SPLIT_STRING + clr.getAddress().getIpAddress() + Constraint.SPLIT_STRING + clr.getAddress().getPort()+
				Constraint.SPLIT_STRING + clr.getRequestType() + Constraint.SPLIT_STRING + clr.getCommand()+
				Constraint.SPLIT_STRING + clr.getContent() + Constraint.SPLIT_STRING + clr.getExtension() + "\r\n";
		return result;
	}
	public static ClientRequest strToReq(String str) {
		if (str == null) {
			return null;
		}
		String []list = str.split(Constraint.SPLIT_STRING);
		Address address = new Address(list[2],list[3]);
		
		ClientInfo ClientInfo = new ClientInfo(list[0],list[1]);
		ClientRequest clr = new ClientRequest(address, ClientInfo);
		clr.setRequestType(list[4]);
		clr.setCommand(list[5]);
		
		clr.setContent(list[6]);
		clr.setExtension(list[7]);
		return clr;
	}
	
	public static String srToStr(ServerResponse sr) {
		String str = null;
		if (sr==null) {
			return null;
		}
		
		str = sr.getResponseType() + Constraint.SPLIT_STRING + sr.getServerId() + Constraint.SPLIT_STRING + sr.getServerPublicKey() + 
				Constraint.SPLIT_STRING + sr.getContent() + Constraint.SPLIT_STRING + sr.getStatus()+"\r\n";
		
		return str;
	}
	public static ServerResponse strToSr(String str) {
		if (str==null||str.equals("")) {
			return null;
		}
		ServerResponse sr = new ServerResponse();
		String[] list = str.split(Constraint.SPLIT_STRING);
		if (list.length != 5) {
			return null;
		}
		sr.setResponseType(list[0]);

		sr.setServerPublicKey(list[2]);
		sr.setContent(list[3]);
		sr.setStatus(list[4]);
		
		return sr;
	}
	
}
