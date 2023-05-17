package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	@Autowired
	@Setter(onMethod_ = { @Autowired })
	private BoardService service;
	@Test
	public void testEnroll() {
		BoardVO vo = new BoardVO();
		vo.setTitle("service Test");
		vo.setContent("service Test");
		vo.setWriter("service Test");
		service.enroll(vo);
	}
	
}
