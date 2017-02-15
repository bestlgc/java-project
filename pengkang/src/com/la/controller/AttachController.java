package com.la.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.la.view.ViewAttach;


@Controller
@RequestMapping("/attach")
public class AttachController {

	private static final String LOGO_ATTACH_ID = "logoAttachId";
	private static final long MAX_SIZE = 512 * 1024;
	@ResponseBody
	@RequestMapping(value = "/newAttachment", method = RequestMethod.POST)
	public String newAttachment(ViewAttach attach, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain; charset=UTF-8");
		System.out.println("haha");
		PrintWriter out = response.getWriter();
		if (attach.getAttach().isEmpty()) {
			return "1";
		} else if (attach.getAttach().getSize() > MAX_SIZE) {
			out.print("2");
			return "2";
		}
		byte[] data = attach.getAttach().getBytes();
		InputStream inputStream = attach.getAttach().getInputStream();
		
		
		String pathname = request.getSession().getServletContext().getRealPath("/") + "/image/partner";
//		String attachPath =request.getContextPath() + AttachService.excuteAttach(data, pathname, ID);
		
		return "0";
	}
}
