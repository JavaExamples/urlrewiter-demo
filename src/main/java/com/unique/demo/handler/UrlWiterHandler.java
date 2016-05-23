package com.unique.demo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.unique.Const;
import org.unique.ioc.annotation.Component;
import org.unique.web.handler.DefalutHandler;
import org.unique.web.handler.Handler;
import org.unique.web.render.Render;

@Component
public class UrlWiterHandler extends DefalutHandler implements Handler {

	private Logger logger = Logger.getLogger(UrlWiterHandler.class);
	
	@Override
	public boolean filterStatic(String target) {
		if (target.endsWith("/")) {
			target = target.substring(0, target.length() - 1);
		}
		// 伪静态
		if (target.endsWith(Render.suffix)) {
			target = target.substring(0,
					target.length() - Render.suffix.length());
		} else {
			// 不处理静态资源
			if (!target.endsWith(Const.ROUTE_SUFFIX)) {
				return false;
			}
		}
		return true;
	}

	public boolean handle(String target, HttpServletRequest request, HttpServletResponse response) {
		if (filterStatic(target)) {
			target = target.replaceAll(Const.ROUTE_SUFFIX, "");
			logger.info("reuqest:[" + target + "]");
			return exec(target, request, response);
		}
		return false;
	}
}
