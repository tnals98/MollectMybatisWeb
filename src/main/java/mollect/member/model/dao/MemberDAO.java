package mollect.member.model.dao;


import org.apache.ibatis.session.SqlSession;

import mollect.member.model.vo.Member;

public class MemberDAO {

	public int registerMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.registerMember", member);
		return result;
	}

	public int updateMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}

	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember", memberId);
		return result;
	}

	public Member selectCheckLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectCheckLogin", member);
		return mOne;
	}

	public Member selectOneById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}




}
