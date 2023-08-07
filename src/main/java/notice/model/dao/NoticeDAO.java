package notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;

public class NoticeDAO {
	
	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	public List<Notice> selectNoticeList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
		return nList;
	}

	public Notice selectOneByNo(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}

	public int eraseNotice(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.eraseNotice", noticeNo);
		return result;
	}
	
	public int modifyNotice(SqlSession session, Notice notice) {
		int result = session.update("NoticeMapper.modifyNotice", notice);
		return result;
	}
	
	private int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("NoticeMapper.getTotalCount");
		return totalCount;
	}
	
	public String generatePageNavi(SqlSession session, int currentPage) {
		// 전체 게시물의 갯수
		int totalCount = getTotalCount(session);
		int recordCountPerPage = 10;
		int naviCountPerPage = 5;
		int totalNaviCount;
		totalNaviCount = totalCount / recordCountPerPage;
		if(totalCount % recordCountPerPage > 0) {
			totalNaviCount = totalCount / recordCountPerPage + 1;
		}else {
			totalNaviCount = totalCount / recordCountPerPage;
		}
		// currentPage         startNavi
		//  1,2,3,4,5              1
		//  6,7,8,9,10             5
		// 11,12,13,14,15          11
		
		// currntPage           endNavi
		//  1,2,3,4,5              5
		//  6,7,8,9,10             10
		// 11,12,13,14,15          15
		
		int startNavi = ((currentPage - 1)/naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > totalNaviCount) {
			endNavi = totalNaviCount;
		}
		StringBuffer result = new StringBuffer();
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi != 1) {
			result.append("<a href='/notice/list.do?currentPage="+(startNavi-1)+"'>[이전]</a> ");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			result.append("<a href='/notice/list.do?currentPage="+i+"'>"+i+"</a>&nbsp;&nbsp;");
		}
		if(endNavi != totalNaviCount) {
			result.append("<a href='/notice/list.do?currentPage="+(endNavi+1)+"'>[다음]</a>");
		}
		return result.toString();
	}


}
