package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Member;

@Repository
public class MemberDao implements MemberRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Member> selectMember() {

		// SQL作成
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT * "
				+ "FROM test");

		String sql = sqlBuilder.toString();

		// SQL実行
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		// return用のリスト
		List<Member> memberList = new ArrayList<Member>();

		for (Map<String, Object> result : resultList) {

			Member member = new Member();

			member.setId((int) result.get("id"));
			member.setName((String) result.get("name"));
			member.setAddress((String) result.get("address"));
			member.setEmail((String) result.get("email"));
			memberList.add(member);

		}

		return memberList;
	}

}
