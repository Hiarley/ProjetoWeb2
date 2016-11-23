package webService;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.sql.Result;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;

public class LoginFacebook
{
	private static Logger logger = Logger.getLogger(FacebookController.class);
	
	@Inject private Result result;
	@Inject private HttpServletRequest request;
	@Inject private HttpServletResponse response;
	@Inject private SessionObjects sessionObjects;
	

	public void index()
	{
		
	}
	

	public void initial()
	{
		
	}
	

	public void show()
	{
		
	}
	

	public void signin() throws IOException
	{
		Facebook facebook = new FacebookFactory().getInstance();
		
		
		sessionObjects.setFacebook(facebook);
		
        StringBuffer callbackURL = request.getRequestURL();
        callbackURL.replace(callbackURL.lastIndexOf("/"), callbackURL.length(), "").append("/callback");
        
        String authAuthorizationURL = facebook.getOAuthAuthorizationURL(callbackURL.toString());
        
        result.redirectTo(authAuthorizationURL);
	}
	

	public void callback(String code) throws FacebookException
	{
		sessionObjects.getFacebook().getOAuthAccessToken(code);
		result.redirectTo(this).show();
	}
	

	public void logout() throws IOException
	{
		String accessToken = sessionObjects.getFacebook().getOAuthAccessToken().getToken();
		

        request.getSession().invalidate();


        StringBuffer next = request.getRequestURL();
        next.replace((next.lastIndexOf("/") + 1), next.length(), "");
        result.redirectTo("http://www.facebook.com/logout.php?next=" + next.toString() + "&access_token=" + accessToken);
	}
	

	public void post(String message) throws FacebookException
	{
		sessionObjects.getFacebook().postStatusMessage(message);
		result.include("messageSuccess", "See your timeline! The message has been posted in your timeline!");
		
		result.redirectTo(this).show();
	}
}
