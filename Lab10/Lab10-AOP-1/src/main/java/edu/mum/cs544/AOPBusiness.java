package edu.mum.cs544;

import java.lang.annotation.Target;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
@Aspect
@Component
public class AOPBusiness {

	@After("execution(* edu.mum.cs544.EmailSender.sendEmail(..))")
	void afterSendMail(JoinPoint joinpoint){
//		CustomerDAO: saving customer Frank Brown
//		EmailSender: sending 'Welcome Frank Brown as a new customer' to
//		fbrown@acme.com
//		Fri Jun 05 14:09:47 GMT 2009 method= sendMail
		System.out.print("\r\n"+new Date());
		System.out.print(" method = " + joinpoint.getSignature().getName());
		
		


	}
	@Around("execution(* edu.mum.cs544.EmailSender.sendEmail(..))")
	void routeSendMail(ProceedingJoinPoint joinpoint){
//		CustomerDAO: saving customer Frank Brown
//		EmailSender: sending 'Welcome Frank Brown as a new customer' to
//		fbrown@acme.com
//		Fri Jun 05 14:17:31 GMT 2009 method= sendEmail address=fbrown@acme.com
//		message= Welcome Frank Brown as a new customer	
		Object[] args = joinpoint.getArgs();
		String email = (String) args[0];
		String msg = (String) args[1];
		System.out.print(new Date());
		System.out.print(" method = " + joinpoint.getSignature().getName());
		System.out.println(" address=" + email);
		System.out.println("message = "+msg);
		try {
			joinpoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		CustomerDAO: saving customer Frank Brown
//		EmailSender: sending 'Welcome Frank Brown as a new customer' to
//		fbrown@acme.com
//		Fri Jun 05 14:22:24 GMT 2009 method= sendEmail address=fbrown@acme.com
//		message= Welcome Frank Brown as a new customer
//		outgoing mail server = smtp.acme.com
		EmailSender target = (EmailSender)joinpoint.getTarget();
		System.out.print("outgoing mail server = "+target.getOutgoingMailServer());
	}
	@Around("execution(* edu.mum.cs544.CustomerDAO.save(..))")
	Object calDAO(ProceedingJoinPoint call){
		try {
			return invoke(call);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public Object invoke(ProceedingJoinPoint call ) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		// print the time to the console
		System.out.println("Time to execute save = "+totaltime);
			return retVal;
		}

}
