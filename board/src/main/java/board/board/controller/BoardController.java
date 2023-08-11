package board.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.board.dto.BoardDto;
import board.service.BoardService;


//Spring MVC의 Controller를 지정하는 어노테이션
@Controller
public class BoardController {

	//비즈니스 로직을 처리하는 서비스 빈을 연결
	@Autowired
	private BoardService boardService;
	
	//웹브라우저에서 /board/openBoardList.do 라는 주소를 호출하면 스프링 디스패처가 호출된 주소와 어노테이션의 값이 동일한 메서드를 찾아 실행
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception {
		ModelAndView mv = new ModelAndView("board/boardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
}
