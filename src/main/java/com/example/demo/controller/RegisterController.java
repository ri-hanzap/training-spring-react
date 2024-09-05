package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.form.RegisterForm;
import com.example.demo.service.RegisterService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegisterController {

	private final RegisterService service;

	@GetMapping("/register")
	public String init(Model model, RegisterForm form) {

		return "register";
	}

	@PostMapping("/register")
	public String login(RedirectAttributes redirectAttribute, Model model, RegisterForm form) {

		// 画面入力IDでDB検索
		var userInfo = service.searchUserById(form.getUserId());

		//ユーザIDの重複チェック
		if (userInfo.isPresent()) {

			model.addAttribute("errorMsg", "このユーザ名はすでに利用されています");

			return "register";

		} else {

			// 会員登録
			service.insertUser(form);

			return "redirect:/login";
		}

	}

}