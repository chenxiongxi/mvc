package com.sinosoft.one.mvc.mock.controllers.for_interceptors_test;

import com.sinosoft.one.mvc.web.ControllerInterceptorAdapter;
import com.sinosoft.one.mvc.web.Invocation;

public class AdvancedInterceptor extends ControllerInterceptorAdapter {

	public static final String RETURN = "returned-by-AdvancedInterceptor.after";
	public static final String AFTER_COMPLETION = "AdvancedInterceptor.afterCompletion";

	public AdvancedInterceptor() {
		setPriority(20);
	}

	@Override
	public Object after(Invocation inv, Object instruction)
			throws Exception {
		return RETURN;
	}

	@Override
	public void afterCompletion(Invocation inv, Throwable ex)
			throws Exception {
		inv.getRequest().setAttribute(AFTER_COMPLETION, true);
	}
}