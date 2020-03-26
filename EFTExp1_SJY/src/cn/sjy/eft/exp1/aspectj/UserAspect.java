package cn.sjy.eft.exp1.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {
	// 定义切入点表达式
	@Pointcut("execution(* cn.sjy.eft.exp1.aspectj.*.*(..))")
	// 使用一个返回值为void、方法体为空的方法来命名切入点
	private void userPointCut(){}
	
	// 环绕通知	
		@Around("userPointCut()")
		public Object userAround(ProceedingJoinPoint proceedingJoinPoint) 
	            throws Throwable {
			// 开始
			System.out.println("环绕开始：执行目标方法之前，模拟校验操作");
			// 执行当前目标方法
			Object obj = proceedingJoinPoint.proceed();
			// 结束
			System.out.println("环绕结束：执行目标方法之后，模拟日志处理操作.");
			return obj;
		}
	
}
