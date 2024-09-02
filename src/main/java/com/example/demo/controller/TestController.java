package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

@RestController
public class TestController {

	@Autowired
	MemberService service;

	@GetMapping("/api/reacttest")
	@ResponseBody
	public List<Member> Hello(Model model) {

		List<Member> memberList = service.selectMember();

		return memberList;
	}

	//	  @GetMapping("/api/hello")
	//	  public String init() {
	//	
	//	      return "Hello World";
	//	  }
	//  
	//  @GetMapping("/page1")
	//  public String page1() {
	//
	//      return "Hello Japan";
	//  }

}