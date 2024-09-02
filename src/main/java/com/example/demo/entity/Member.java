package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Member {

	private int id;
	
	private String name;

	private String address;
	
	private String email;

	
}
