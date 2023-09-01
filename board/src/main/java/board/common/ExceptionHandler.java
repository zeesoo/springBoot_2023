package board.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

//예외처리 클래스임을 알려주는 어노테이션
@ControllerAdvice
public class ExceptionHandler {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	//예시를 위해 모든 예외를 처리함. 실제 사용 시 모든 예외 처리를 한꺼번에 처리하면 안됨
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception exception) {
	
	//에러 발생 시 보여줄 화면 지정
	ModelAndView mv = new ModelAndView("/error/error_default");
	mv.addObject("exception", exception);
	
	//에러 로그 출력
	log.error("exception", exception);
	
	
	/* stackTrace 테스트
	 * StackTraceElement[] el = exception.getStackTrace(); System.out.println(el);
	 * StackTraceElement el1 = el[0]; System.out.println(el1);
	 * System.out.println(el1.toString());
	 */
	
	
	return mv;
	
	}
}
