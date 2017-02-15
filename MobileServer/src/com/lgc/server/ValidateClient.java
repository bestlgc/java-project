package com.lgc.server;

import com.lgc.model.ClientInfo;

public class ValidateClient {
	public static boolean validate(ClientInfo info) {
		return info.getClientId().equals("001")&&info.getClientPublicKey().equals("123456");
	}
}
