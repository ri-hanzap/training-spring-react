package com.example.demo.service;

import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class LoginService {

	private final UserRepository repository;

	public Optional<User> searchUserById(String userId) {

		return repository.findById(userId);
	}

}
