package com.la.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.la.domain.CourseFile;
import com.la.service.CourseFileService;

@Controller

public class CourseFileController {
	@Autowired
	private CourseFileService courseFileService;
	
	@RequestMapping(value = "/uploadFile",method=RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file,
			String author , String comment) {
		CourseFile course = new CourseFile();
		course.setAuthor(author);
		course.setComment(comment);
		 String result = courseFileService.uploadFile(file,course);
		 
		if(result != null) {
			return "redirect:./showCourseList/10/1";
		}
		
		return "failure";
	}
	
	@RequestMapping(value = "/initUpload",method=RequestMethod.GET)
	public String initUpload() {
		
		return "upLoadTest";
	}
	
	@RequestMapping(value = "/tc_yunList",method=RequestMethod.GET)
	public String tc_yunList() {
		
		return "tc_yunList";
	}
	
	@RequestMapping(value = "/showCourseList/{pageNum}/{pageIndex}",method = RequestMethod.GET)
	public ModelAndView showCourseList(@PathVariable(value="pageNum") int pageNum,@PathVariable(value="pageIndex") int pageIndex){
		ModelAndView mv = null;
		System.out.println(pageNum);
		try {
			List<CourseFile> courseList = courseFileService.getList(pageNum,pageIndex);
			mv = new ModelAndView("/lookCourse");
			mv.addObject("vlist", courseList);
			return mv;
		} catch (Exception e) {
			mv = new ModelAndView("/leader/failed");
			e.printStackTrace();
			return mv;
		}	
	}
	
	@RequestMapping(value = "/download/{courseID}",method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(@PathVariable(value="courseID") int courseID) {
		CourseFile courseFile = new CourseFile();
		try {
			courseFile = courseFileService.getCourseFileByID(courseID);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String coursePath = courseFile.getPath();
		String courseName = courseFile.getFileName();
		File file = courseFileService.downloadFile(coursePath, courseName);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", courseName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		try {
			ResponseEntity<byte[]> result = new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
			if(file != null && file.exists()) {
				file.delete();
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/delete/{courseID}",method = RequestMethod.GET)
	public String delete(@PathVariable(value="courseID") int courseID) {
		try {
			courseFileService.delete(courseID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:../showCourseList/10/1";
	}
}
