import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import PostList from './components/PostList';
import PostForm from './components/PostForm';
import Post from './components/Post';
import Login from './components/Login';
import Navbar from './components/Navbar';

function App() {

	return (
		<Router>
			<Navbar />
			<Routes>
				<Route path="/" element={<PostList />} />
				<Route path="/login" element={<Login />} />
				<Route path="/create" element={<PostForm />} />
				<Route path="/post/:postId" element={<Post />} />
			</Routes>
		</Router>
	)
}

export default App;
