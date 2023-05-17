package org.zerock.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.model.Criteria;
import org.zerock.model.PageMakerDTO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger log = Logger.getLogger(BoardController.class);

	@Autowired
	private BoardService bservice;

	@GetMapping("/list")
	public void boardListGET(Model model, Criteria cri) {
		
		model.addAttribute("list", bservice.getListPaging(cri));

		int total = bservice.getTotal(cri);
		
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
	
		model.addAttribute("pageMaker", pageMake);
		
		
		
		
	}

	@GetMapping("/enroll")
	public void boardEnrollGET() {
		log.info("게시판 등록 페이지 진입 ");
	}

	@PostMapping("/enroll")
	public String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
		log.info("BoardVo :  " + board);
		bservice.enroll(board);
		rttr.addFlashAttribute("result", "등록 성공");
		return "redirect:/board/list";
	}

	@GetMapping
	public void boardGetPageGET(int bno, Model model, Criteria cri) {
		model.addAttribute("pageInfo", bservice.getPage(bno));
		model.addAttribute("cri", cri);
		bservice.updateReadCount(bno);
		log.info("조회수 증가");
	}

	@GetMapping("/modify")
	public void boardModifyGET(int bno, Model model, Criteria cri) {

		model.addAttribute("pageInfo", bservice.getPage(bno));
		model.addAttribute("cri", cri);
		
	}

	/* 페이지 수정 */
	@PostMapping("/modify")
	public String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {

		bservice.modify(board);

		rttr.addFlashAttribute("result", "modify success");

		return "redirect:/board/list";

	}

	@PostMapping("/delete")
	public String boardDeletePOST(int bno, RedirectAttributes rttr) {

		bservice.delete(bno);

		rttr.addFlashAttribute("result", "delete success");

		return "redirect:/board/list";
	}

}
