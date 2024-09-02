import { useState, useEffect } from 'react';
// import axios from 'axios';
import './App.css';

function App() {

	const [members, setMembers] = useState([]);
	//	const [message, setMessage] = useState("");

	useEffect(() => {
		// APIを呼び出す(fetch)
		fetch('/api/reacttest', { method: 'GET' })
			//		fetch('https://jsonplaceholder.typicode.com/posts', { method: 'GET' })
			// レスポンスをテキストで受け取る
			.then(res => res.json())
			// APIから渡されるレスポンスデータ(data)をstateにセットする
			.then(data => {
				setMembers(data)
			})
	}, [])

	// //テキストのみ取得できるかお試し
	//	useEffect(() => {
	//		// APIを呼び出す(fetch)
	//		fetch('/api/reacttest', { method: 'GET' })
	//			//		fetch('https://jsonplaceholder.typicode.com/posts', { method: 'GET' })
	//			// レスポンスをテキストで受け取る
	//			.then(res => res.text())
	//			// APIから渡されるレスポンスデータ(data)をstateにセットする
	//			.then(data => {
	//				setMessage(data)
	//			})
	//	}, [])

	// axios使ってデータ取得できるかお試し
	//	try {
	//		axios.get("http://10.0.2.2:8080/api/reacttest")
	//			.then(res => {
	//				const text = res.data;
	//				this.setMessage({ text });
	//			})
	//
	//	} catch (e) {
	//		console.log(e);
	//	}


	return (
		<div>
			<table>
				<tr>
					<th>name</th>
					<th>address</th>
					<th>email</th>
				</tr>
				{
					members.map(member =>
						<tr>
							<td>{member.name}</td>
							<td>{member.address}</td>
							<td>{member.email}</td>
						</tr>
					)}
			</table>
		</div>

	);


	// //テキスト表示用
	//	return (
	//		<div>{message}</div>
	//	)

}

export default App;
