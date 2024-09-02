package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Member;

@Repository
public interface MemberRepository {
	
	List<Member> selectMember();

}
