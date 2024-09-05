package com.example.demo.service;

import java.sql.Timestamp;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.form.RegisterForm;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RegisterService {

	private final UserRepository repository;

	// ユーザ情報検索
	public Optional<User> searchUserById(String userId) {

		return repository.findById(userId);
	}

	// ユーザ登録
	public User insertUser(RegisterForm form) {

		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		User userEntity = new User();
		userEntity.setUserId(form.getUserId());
		userEntity.setUserName(form.getUserName());
		userEntity.setPassword(form.getPassword());
		userEntity.setMaiAddress(form.getMailAddress());
		userEntity.setCreateTime(currentTime);
		userEntity.setCreateUser(form.getUserId());
		userEntity.setUpdateTime(currentTime);
		userEntity.setUpdateUser(form.getUserId());
		userEntity.setDeleteFlg(0);

		return repository.save(userEntity);
	}

}
