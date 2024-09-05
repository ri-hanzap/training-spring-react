import React from 'react'

const Login = () => {

	return (
		<div>
			<h2>ログイン画面</h2>
			<form>
				<div>
					<label>ログインID</label>
					<input type="text" />
				</div>
				<div>
					<label>パスワード</label>
					<input type="password" />
				</div>
				<div>
					<input type="submit" value="ログイン" />
				</div>
			</form>
			<div>
				<a>会員登録はこちら</a>
			</div>
		</div >
	)
}

export default Login;