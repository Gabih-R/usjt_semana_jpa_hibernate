package br.usjt.usjt_semana_jpa_hibernate.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (((Object) request.getSession()).getAttribute("usuarioLogado") == null) {
			response.sendRedirect("login");
		}
		return true;
	}
}