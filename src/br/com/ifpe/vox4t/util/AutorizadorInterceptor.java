package br.com.ifpe.vox4t.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
@Override
public boolean preHandle(HttpServletRequest request,
HttpServletResponse response, Object controller) throws
Exception {
	boolean retorno = false;
	String uri = request.getRequestURI();
	if (uri.contains("bootstrap") 
	|| uri.contains("css") 
	|| uri.contains("img") 
	|| uri.contains("js")
	|| uri.contains("google")
	|| uri.endsWith("admin")
	|| uri.endsWith("usuario/cadastro")
	|| uri.endsWith("usuario/save")
	|| uri.endsWith("disponivel")
	|| uri.endsWith("loginCheck")
	|| uri.endsWith("logout")
	|| uri.endsWith("loginAdminCheck")) {
	return true;
	}	
	
	
	
	if (uri.endsWith("admin/menu")
		||uri.endsWith("categoria/add")) {
		
		if (request.getSession().getAttribute("adminLogado") != null) {	 
			
			retorno = true;
		}else {
			response.sendRedirect("/VOX4T/admin");
			retorno = false;
				
		}

	}else {
		
		if (request.getSession().getAttribute("usuarioLogado") != null){
			uri.endsWith("exibir");
			retorno = true;
			}
		else {
			response.sendRedirect("/VOX4T");
			retorno = false;
		}
		
	}
	
	
	
	return retorno;
	
	

	
			
			
	}

}


