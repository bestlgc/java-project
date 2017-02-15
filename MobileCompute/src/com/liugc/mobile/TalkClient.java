package com.liugc.mobile;

import java.io.*;
import java.net.*;

import com.lgc.model.Address;
import com.lgc.model.ClientRequest;
import com.lgc.model.ClientInfo;
import com.lgc.model.Constraint;
import com.lgc.model.ServerResponse;
import com.liugc.util.ObjectUtil;

public class TalkClient {
	private static Address address;
	private static ClientInfo info;
	public TalkClient(){
		
	}
	static {
		 address = new Address();
		 address.setIpAddress("127.0.0.1");
		 address.setPort(4700);
		 
		 info = new ClientInfo();
		 info.setClientId("001");
		 info.setClientPublicKey("123456");
	}
	public TalkClient(Address address,ClientInfo info){
		TalkClient.address = address;
		TalkClient.info = info;
	}
	public static void main(String[] args) {
		try {
			start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void start() throws UnknownHostException, IOException  {
			Socket socket = new Socket(address.getIpAddress(),address.getPort());
			socket.setSoTimeout(6000);
			try {
				
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				connect(writer,reader);
				communicate(writer,reader);
				disconnect(writer,reader);
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				socket.close();
			}
	}
	
	public static boolean connect(PrintWriter writer,BufferedReader reader) throws  Exception {
		
		boolean isconnected = false;
		ClientRequest crq = new ClientRequest(address,info);
		crq.setContent(Constraint.ASKCON);
		crq.setRequestType(Constraint.REQUEST_TYPE_CON);
		
		String packet = ObjectUtil.reqToStr(crq);
		String in = null;
		
		for(int i=0;i<5;i++){
			writer.write(packet);
			writer.flush();
			in = reader.readLine();
			if (in==null||in.isEmpty()) {
				break;
			}
			ServerResponse sr = ObjectUtil.strToSr(in);
			if (in != null) {
				//read the response info and judge wether success;
				if (sr.getContent().equals(Constraint.ACCEPT)) {
					System.out.println(in);
					System.out.println("received server info");
					isconnected = true;
					break;
				}
				
			}
		}
		
		return isconnected;
	}
	public static void communicate(PrintWriter writer,BufferedReader reader) throws IOException{
		ClientRequest request = new ClientRequest(address, info);
		request.setCommand(Constraint.COMMAND_START);
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String content = sin.readLine();
			System.out.println("Client is sending: " + content);
			request.setContent(content);
			String string = ObjectUtil.reqToStr(request);
			writer.write(string);
			
			String answer =  reader.readLine();
			ServerResponse sr = ObjectUtil.strToSr(answer);
			System.out.println("received: "+answer);
			if (sr.getContent().equals(Constraint.CON_DISCONNECT)) {
				break;
			}
		}
		
	}
	/**
	 * 发送断开连接的请求
	 * @throws IOException 
	 */
	public static void disconnect(PrintWriter writer,BufferedReader reader) throws IOException {
		System.out.println("Is disconnecting...");
		reader.close();
		writer.close();
		System.out.println("success");
	}
	}
