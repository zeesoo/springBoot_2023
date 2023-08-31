package board.interceptor;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;


/** interceptor 구현방법: HandlerInterceptor를 상속받아 구현할 수 있다.
 * 메서드 종류
 *  1) preHanle(컨트롤러 실행 전 수행)
 *  2) postHandle(컨트롤러 수행 후 결과를 뷰로 보내기 전에 수행)
 *  3) afterCompletion(뷰의 작업까지 완료된 후 수행)
 */

//spring 5.3 version 이상에서는 HandlerInterceptorAdapter를 사용하는 대신 HandlerInterceptor를 implements해서 사용해야 함
@Slf4j
public class LoggerInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		log.debug("================================== START ==================================");
		log.debug(" Request URI \t " + request.getRequestURI());
		//기존 HandlerInterceptorAdapterㅇ를 사용할 때에는 extends해서 사용하므로 부모의 메소드를 반환할 수 있었으나, implements 방식에는 true만 반환할 수 있음
		//return super.preHandle(request, response, handler);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		log.debug("================================== END ==================================");
	}
	
	
}
