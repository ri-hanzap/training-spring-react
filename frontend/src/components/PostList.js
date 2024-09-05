import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const PostList = () => {

	const [posts, setPosts] = useState([]);
	const [msg, setMsg] = useState([]);
	const navigate = useNavigate();

	// API呼び出し（取得）
	useEffect(() => {
		// APIを呼び出す(fetch)
		axios.get('/api/posts')
			// APIから渡されるレスポンスデータ(data)をstateにセットする
			.then(res => {
				console.log('Fetched posts:', res.data)
				setPosts(res.data);
			})
			.catch(error => {
				console.error('Error fetching posts:', error)
			});
	}, []);

	// API呼び出し（削除）
	const handleDelete = async (postId) => {

		console.log("deleteしますよ")

		try {
			// 削除API呼び出し
			await axios.delete(`/api/posts/delete/${postId}`);
			setPosts(posts.filter(post => post.id !== postId));
			navigate('/');
		} catch (error) {
			console.error('Error fetching posts:', error);
		}
	}

	return (
		<div className='container'>
			<p>{msg}</p>
			<h1>投稿一覧</h1>
			<ul>
				{posts.map(post => (
					<li key={post.id}>
						<h2>{post.title}</h2>
						<p className='author'>{post.author}</p>
						<p>{post.content}</p>
						<div className='list-btn'>
							<button className='m1' onClick={() => navigate(`/post/${post.id}`)}>詳細</button>
							<button className='m1' onClick={() => handleDelete(post.id)}>削除</button>
						</div>
					</li>
				))}
			</ul>
		</div>
	);
};

export default PostList;