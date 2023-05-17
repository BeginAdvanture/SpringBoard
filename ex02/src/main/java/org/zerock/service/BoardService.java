package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.model.Criteria;

public interface BoardService {
	public void enroll(BoardVO board);

	public List<BoardVO> getList();

	public BoardVO getPage(int bno);

	public int modify(BoardVO board);

	public int delete(int bno);

	public List<BoardVO> getListPaging(Criteria cri);

	public int getTotal(Criteria cri);
	
	public int updateReadCount(int bno);
	
	
}
