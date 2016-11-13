package controllers;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.testkiller.business.LoginFacebook;

@ManagedBean
public class LoginFacebookMB {
		
	@Autowired
	private LoginFacebook loginFacebook;

	/**
	 * M�todo que chama URL do facebook onde o usu�rio poder� autorizar a aplica��o
	 * a acessar seus recursos privados.
	 * @return
	 */
	@RequestMapping("/loginfb")
	public String logarComFacebook(){
		return "redirect:"+loginFacebook.getLoginRedirectURL();
	}

	/**
	 * Executado quando o Servidor de Autoriza��o fizer o redirect.
	 * @param 
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@RequestMapping("/loginfbresponse")
	public String logarComFacebook(String code) throws MalformedURLException, IOException{
		
		loginFacebook.obterUsuarioFacebook(code);
		
		return "redirect:/";
	}
	
}