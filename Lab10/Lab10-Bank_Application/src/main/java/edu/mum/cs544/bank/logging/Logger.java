package edu.mum.cs544.bank.logging;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger implements ILogger{

	@Before("execution(* edu.mum.cs544.bank.dao.*.*(..))")
	void logPoint(JoinPoint jp){
		log(" -------  called: "+jp.getSignature().getName());
		
	}
	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
	}

	@Around("execution(* edu.mum.cs544.bank.jms.JMSSender.*(..))")
	Object logJMS(ProceedingJoinPoint jp){
		log(" -------  send JMS: "+ ((String)jp.getArgs()[0]));
		try {
			return jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
