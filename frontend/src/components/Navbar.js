import React from 'react'
import { Link } from 'react-router-dom';

const Navbar = () => {

	return (
		<nav>
			<ul>
				<li><Link to='/'>HOME</Link></li>
				<li><Link to='/create'>新規投稿</Link></li>
			</ul>

		</nav>
	)
}

export default Navbar;