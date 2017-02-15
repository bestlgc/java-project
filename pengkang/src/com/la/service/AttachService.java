package com.la.service;

//import javax.servlet.http.HttpSession;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class AttachService {
	private static String prefix = "";
	private static int length = 8;
	private static String appSeqName = "EOP_SEQ.nextVal";
	private static String imageBasePath = "/partner/image/partner";

	public static String excuteAttach(byte[] data, String path,String ID) throws IOException {
		try {
			String result = "/image/partner/" + ID + ".jpg";
			path = path + "/" + ID + ".jpg";
			File file = new File(path);
			if(!file.getParentFile().exists()){
				file.getParentFile().mkdirs();
			}
			OutputStream out = new FileOutputStream(file);
			InputStream in = new ByteArrayInputStream(data);  
		    int len = 0;  
		    byte[] buf = new byte[1024];  
		    while ((len = in.read(buf, 0, 1024)) != -1) {  
		    	out.write(buf, 0, len);  
		    }  
		    out.flush();
			out.close();  
			in.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/*
	public static String getID(){
		String ID = dpc.HttpSeqExerciser().getCode(prefix, appSeqName, length);
		return ID;
	}
	
	public static String getImagePath(String logoAttachId,String contextPath,HttpServletRequest request) throws Exception {
		String filePath = contextPath + "/image/partner/" + logoAttachId + ".jpg";
		File file = new File(filePath);
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		if (file.exists()) {
			return request.getContextPath()+"/image/partner" + "/" + logoAttachId + ".jpg";
		}else {
			byte data[] = dpc.getHttpAttachExerciser().getAttach(logoAttachId);
			if (data==null) {
				return "";
			}
			OutputStream out = new FileOutputStream(file);
			InputStream in = new ByteArrayInputStream(data);  
		    int len = 0;  
		    byte[] buf = new byte[1024];  
		    while ((len = in.read(buf, 0, 1024)) != -1) {  
		    	out.write(buf, 0, len);  
		    }  
		    out.flush();
			out.close();  
			in.close();
		}
		return imageBasePath + "/" + logoAttachId + ".jpg";
	}
	*/
	
}
