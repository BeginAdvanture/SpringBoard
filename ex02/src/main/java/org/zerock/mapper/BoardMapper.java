package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.model.Criteria;

public interface BoardMapper {

	/*
	 * @Select("select * from tbl_board where bno > 0") public List<BoardVO>
	 * getList();
	 * 
	 * 
	 * public void insert(BoardVO board); public void insertSelectKey(BoardVO
	 * board);
	 * 
	 * public BoardVO read(Long bno);
	 * 
	 * public int delete(Long bno);
	 * 
	 * public int update(BoardVO board);
	 */

	public void enroll(BoardVO board);

	public List<BoardVO> getList();

	public List<BoardVO> getListPaging(Criteria cri);

	public BoardVO getPage(int bno);

	public int modify(BoardVO board);

	public int delete(int bno);
	
	public int getTotal(Criteria cri);
	 
	public int updateReadCount(int bno);
	
}
