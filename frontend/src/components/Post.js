import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

const Post = () => {

	const { postId } = useParams();
	const [post, setPost] = useState(null);
	const [isEditting, setIsEditting] = useState(false);

	const [title, setTitle] = useState("");
	const [author, setAuthor] = useState("");
	const [content, setContent] = useState("");

	const navigate = useNavigate();


	// API呼び出し（取得）
	useEffect(() => {

		axios.get(`/api/posts/${postId}`)
			.then(res => {
				setPost(res.data);
				setTitle(res.data.title);
				setAuthor(res.data.author);
				setContent(res.data.content);
			})
			.catch(error => console.error('Error fetching post:', error));

	}, [postId]);



	// API呼び出し（更新）
	const handleUpdate = async (event) => {

		// デフォルトのフォーム送信対策
		event.preventDefault();

		try {

			// フォーム送信
			await axios.put(`/api/posts/update/${postId}`, { author, title, content })

			setIsEditting(false);
			setPost({ ...post, author, title, content });
			alert('更新したよ！')
			navigate('/')

		} catch (error) {
			console.error('Error fetching posts:', error);
		}
	}

	const handleEdit = () => {
		setIsEditting(true);
	}

	const handleCancel = () => {
		setIsEditting(false);
		setTitle(post.title);
		setAuthor(post.author);
		setContent(post.content);
	}

	const handleBack = () => {
		navigate('/');
	}


	if (!post) return <p>Loading...</p>

	return (
		<div className='container'>

			{isEditting ? (
				<form onSubmit={handleUpdate}>
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
					<div className='edit-btn'>
						<button className="m1" type="submit">更新</button>
						<button className="m1" type="button" onClick={handleCancel}>キャンセル</button>
					</div>
				</form >
			) : (
				<div>
					<h2>{post.title}</h2>
					<p className='author'>{post.author}</p>
					<p>{post.content}</p>
					<button onClick={handleEdit}>編集</button>
				</div>)}
			<div className="back-btn">
				<button onClick={handleBack}>戻る</button>
			</div>
		</div>
	);
}

export default Post;