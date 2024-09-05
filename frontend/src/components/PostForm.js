import React, { useState } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const PostForm = () => {

	const [author, setAuthor] = useState("");
	const [content, setContent] = useState("");
	const [title, setTitle] = useState("");
	const navigate = useNavigate();

	const handleSubmit = (event) => {

		// デフォルトのフォーム送信対策
		event.preventDefault();

		// フォーム送信
		axios.post('/api/posts', { author, title, content })
			.then(() => {
				setAuthor("");
				setTitle("");
				setContent("");
				alert('投稿完了！')
				navigate('/')
			})
			.catch(error => console.error('Error fetching posts:', error))
	}

	return (
		<div className='container'>
			<form onSubmit={handleSubmit}>
				<div className='form-group'>
					<label>タイトル</label>
					<input value={title} onChange={(e) => setTitle(e.target.value)} />
				</div>
				<div className='form-group'>
					<label>投稿内容</label>
					<textarea rows="10" value={content} onChange={(e) => setContent(e.target.value)} />
				</div>
				<div className='form-group'>
					<label>投稿者</label>
					<input value={author} onChange={(e) => setAuthor(e.target.value)} />
				</div>
				<button type="submit">送信</button>
			</form >
		</div>
	);
};

export default PostForm;