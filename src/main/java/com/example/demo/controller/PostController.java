package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostRepository repos;

	//全件取得
	@GetMapping
	public List<Post> getAllPosts() {

		return repos.findAll();
	}

	//1件取得
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable Long id) {

		Optional<Post> post = repos.findById(id);

		return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public Post createPost(@RequestBody Post newPost) {

		Timestamp currentTime = new Timestamp(System.currentTimeMillis());

		newPost.setPostTime(currentTime);
		newPost.setDeleteFlg(0);

		return repos.save(newPost);
	}

	// 投稿更新
	@PutMapping("/update/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post postdetails) {

		// 更新対象検索
		Optional<Post> targetPost = repos.findById(id);

		// 更新対象が存在する場合
		if (targetPost.isPresent()) {

			Post updatePost = targetPost.get();
			updatePost.setAuthor(postdetails.getAuthor());
			updatePost.setTitle(postdetails.getTitle());
			updatePost.setContent(postdetails.getContent());
			repos.save(updatePost);

			return ResponseEntity.ok(updatePost);

		} else {

			return ResponseEntity.notFound().build();
		}
	}

	// 投稿更新
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Post> deletePost(@PathVariable Long id) {

		// 更新対象が存在する場合
		if (repos.existsById(id)) {

			repos.deleteById(id);

			return ResponseEntity.noContent().build();

		} else {

			return ResponseEntity.notFound().build();
		}
	}
}
