package com.lgc.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.lgc.model.ClientRequest;
import com.lgc.model.Constraint;
import com.lgc.model.ServerResponse;
import com.lgc.util.ObjectUtil;

public class TalkServer {
	
	public static boolean dealConnect(BufferedReader reader,PrintWriter writer) throws IOException {
		String line = reader.readLine();
		ServerResponse sr = new ServerResponse();
		
		sr.setContent(Constraint.ACCEPT);		
		sr.setResponseType("response_type");
		sr.setServerId("007");
		sr.setServerPublicKey("123456");
		sr.setStatus("good");
		
		String sendPactet = ObjectUtil.srToStr(sr);
		
		if (line==null||line.isEmpty()) {
			return true;
		}
		
		System.out.println("received connection request:  " + line);
		ClientRequest cr = ObjectUtil.strToReq(line);
		
		if (cr.getRequestType()==null) {
			return true;
		}else if (ValidateClient.validate(cr.getClientInfo())) {
			writer.write(sendPactet);
			System.out.println("validate access");
			writer.flush();
			return true;
		}else if (cr.getRequestType().equals(Constraint.REQUEST_TYPE_BYE)) {
			return false;
		}
		
		return false;
	}
	public static void dealCommunicate() {
		
	}
	public static void dealDisconnect() {
		
	}
	public static void start() throws Exception {
		
			ServerSocket server = null;
			Socket socket =null;
			try {
				server = new ServerSocket(4700);
				socket = server.accept();
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				while(true){
					dealConnect(reader,writer);
				}
						
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				server.close();
				socket.close();
			}
						
	}
	public static void main(String[] args) throws Exception {
		start();
	}
	public static void main1(String[] args) {
		try {
			ServerSocket server = null;
			try {
				server = new ServerSocket(4700);
				
			} catch (Exception e) {
				
			}
			
			Socket socket = null;
			try {
				socket = server.accept();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			String line;
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			line = sin.readLine();
			while(!line.equals("bye")){
				writer.println(line);
				writer.flush();
				System.out.println("Server"+line);
				System.out.println("Client"+is.readLine());
				line = sin.readLine();
			}
			writer.close();
			is.close();
			sin.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
