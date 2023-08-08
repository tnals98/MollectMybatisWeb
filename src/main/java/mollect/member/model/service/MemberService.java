package mollect.member.model.service;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import mollect.member.model.dao.MemberDAO;
import mollect.member.model.vo.Member;

public class MemberService {

	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
	}

	public int registerMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.registerMember(session, member);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int updateMember(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.updateMember(session, member);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int deleteMember(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = mDao.deleteMember(session, memberId);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public Member selectCheckLogin(Member member) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member mOne = mDao.selectCheckLogin(session, member);
		session.close();
		return mOne;
	}

	public Member selectOneById(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member member = mDao.selectOneById(session, memberId);
		session.close();
		return member;
	}

}
