package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberDao;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	MemberDao dao;
	
	
	public List<Member> selectMember(){
		return dao.selectMember();
	}
}
