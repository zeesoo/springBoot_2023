package board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
//자바 코드에서 AOP를 설정 (Aspect: 관점이라는 뜻으로 공통적으로 적용될 기능을 의미)
@Aspect
public class LoggerAspect {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	//기능이 실행될 시점(어드바이스)를 정의. 어드바이스는 다섯 종류가 있음
	//Around: 대상 메서드의 실행 전후 또는 예외 발생 시점에 사용 가능
	//excution: 포인트컷 표현식으로 적용할 메서드를 명시
	@Around("execution(* board..controller.*Controller.*(..)) or "
			+ "execution(* board..service.*Impl.*(..)) or "
			+ "execution(* board..mapper.*Mapper.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable{
		String type = "";
		String name= joinPoint.getSignature().getDeclaringTypeName();
		if(name.indexOf("Controller") > -1) {
			type = "Controller \t: ";
		}
		else if (name.indexOf("Service") > -1) {
			type = "ServiceImpl \t: ";
		}
		else if(name.indexOf("Mapper") > -1) {
			type = "Mapper \t\t: ";
		}
		log.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
		return joinPoint.proceed();
	
	}
}
