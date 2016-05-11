package com.mybatis.shiro;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.junit.Test;
import org.slf4j.*; 
public class Tutorial {

	private static final transient Logger log = LoggerFactory.getLogger(Tutorial.class);  
	
	@Test
	public void testSecurityManager(){
		
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		
		SecurityManager securityManager = (SecurityManager) factory.getInstance();
		SecurityUtils.setSecurityManager((SecurityManager) securityManager);
		
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		session.setAttribute("someKey", "aValue");
		
		String value = (String) session.getAttribute("someKey");
		if(value.equals("aValue"))
			log.info("Retrieved the correct vlaue! [" + value + "]");
		
		if(!currentUser.isAuthenticated()){
			
			UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
			token.setRememberMe(true);
			
			try{
				currentUser.login(token);
			}catch(UnknownAccountException e){
				log.info("There is no user with username of " + token.getPrincipal()); 
			} catch(IncorrectCredentialsException ice) { 
				log.info("Password for account " + token.getPrincipal() + " was incorrect!"); 
			} catch(LockedAccountException lae) { 
				log.info("The account for username " + 
					token.getPrincipal() + " is locked. " +  
					"Please contact your administrator to unlock it.");
			}
			
		}
		
		if(currentUser.hasRole("schwartz")){
			log.info("May the Schwartz be with you!"); 
		}else{
			log.info("Hello, mere mortal."); 

		}
		
		if(currentUser.isPermitted("lightsaber:weild")){
			log.info("You may use a lightsaber ring. Use it wisely.");
		}else{
			
			log.info("Sorry, lightsaber rings are for schwartz masters only."); 
		}
		
		if (currentUser.isPermitted("winnerbago:drive:eagle5")) {
			
			log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5' .  "
			+  "Here are the keys - have fun!"); 
		}else{
			
			log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!"); 
		}
		
		
		
		
	}
	
}
