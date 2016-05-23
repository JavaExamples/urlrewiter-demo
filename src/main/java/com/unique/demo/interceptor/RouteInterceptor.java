package com.unique.demo.interceptor;

import org.unique.aop.annotation.After;
import org.unique.aop.annotation.Before;
import org.unique.aop.intercept.MethodInvocation;
import org.unique.web.interceptor.AbstractRouteInterceptor;

public class RouteInterceptor extends AbstractRouteInterceptor {
	
	@Before(expression = "@org.unique.web.annotation.Route")
	public void beforeAdvice() {
		System.out.println("beforeAdvice   ...");
	}

	@After(expression = "@org.unique.web.annotation.Route")
	public void afterAdvice() {
		System.out.println("afterAdvice   ...");
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;
		beforeAdvice();
		result = invocation.proceed();
		afterAdvice();
		return result;
	}
	
}
