package com.example.demo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_name")
	private String userName;

	private String password;

	@Column(name = "mail_addresss")
	private String maiAddress;

	@Column(name = "create_user")
	private String createUser;

	@Column(name = "create_time")
	private Timestamp createTime;

	@Column(name = "update_user")
	private String updateUser;

	@Column(name = "update_time")
	private Timestamp updateTime;

	@Column(name = "delete_flg")
	private int deleteFlg;

}