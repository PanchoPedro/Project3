package com.vodafone.spring.mvc.config.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vodafone.spring.mvc.config.entity.LoginUser;
import SportyShoes.Ecommerce.entity.User;
import SportyShoes.Ecommerce.database.UserDatabase;

@Controller
public class HomeController {
	
	@Autowired
	UserDatabase db;

	@GetMapping("/signin")
	public String signInUser(@RequestParam(required = false)
	String error, Map<String, String> map)
	{
		System.out.println("sign in user "+error);
		// is the name of the view
		if(error != null)
			map.put("error", error);
		return "login";
	}
	
	@PostMapping("/login")
	// Model, map, ModelAndView
	public String loginUser(LoginUser user, Map<String, String> map,HttpSession session)
	{
		try {
		System.out.println("user details "+ user);
		System.out.println(db.getUserByEmail(user.getEmail()).getEmail());
		if(user.getEmail().equals(db.getUserByEmail(user.getEmail()).getEmail()) && user.getPassword().equals(db.getUserByEmail(user.getEmail()).getPassword()))
		{
			// success RequestDispacther
			//map.put("email",user.getEmail());
			
			session.setAttribute("email", user.getEmail());
			session.setAttribute("userid", db.getUserByEmail(user.getEmail()).getId());
			System.out.println(db.getUserByEmail(user.getEmail()).getType());
			if(db.getUserByEmail(user.getEmail()).getType() != null && ((String)db.getUserByEmail(user.getEmail()).getType()).equals("admin")) {
				map.put("email", user.getEmail());
				session.setAttribute("admin", true);
				return "adminHome";}
			session.setAttribute("admin", false);
			return "redirect:welcome";
		}}
		catch(EmptyResultDataAccessException e) {
	       
		// failure
		// response.sendredirect
		return "redirect:signin?error=Invalid Credentials";}
		return "redirect:signin?error=Invalid Credentials";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("email");
		session.invalidate();
		return "redirect:signin";
	}
	
	
	@PostMapping("/register")
	// Model, map, ModelAndView
	public String User(User user, Map<String, String> map,HttpSession session)
	{
		
		//System.out.println("user details "+ user);
		//System.out.println(db.getUserByEmail(user.getEmail()).getEmail());
		
			// success RequestDispacther
			//map.put("email",user.getEmail());
			if(db.insertUser(user)) {
			//session.setAttribute("email", user.getEmail());
			//session.setAttribute("userid", db.getUserByEmail(user.getEmail()).getId());
			//model.addAttribute("email", user.getEmail());
			return "redirect:signin?error=Registration Successful";
		}
	       
		// failure
		// response.sendredirect
		return "redirect:signin?error=Registration Failed";
	
		
		
	}
	
	@GetMapping("/adminhome")
	public String admindashboard(HttpSession session, Map<String, String> map)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			map.put("email", email);
			return "adminHome";
		}
		return "redirect:signin";
	}
	
	
	@GetMapping("/browseusers")
	public String browseudashboard(HttpSession session, Map<String, String> map
			,Map<String, List<User>> mapList)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			map.put("email", email);
			mapList.put("users", db.getUsers());
			//System.out.println(mapList);
			return "browseusers";
	}
		return "redirect:signin";
	}
	
	@GetMapping("/searchusers")
	public String searchudashboard(HttpSession session, Map<String, String> map
			)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			map.put("email", email);

			return "searchusers";
	}
		return "redirect:signin";
	}
	
	@PostMapping("/searchuser")
	public String searchuserdashboard(LoginUser user,HttpSession session, Map<String, String> map
			,Map<String, User> mapList)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			try {
			map.put("email", email);
			mapList.put("user",db.getUserByEmail(user.getEmail()));

			return "searchuser";
			}
			catch(EmptyResultDataAccessException e) {
				map.put("email", email);
				return "searchuser";
			}
	}
		return "redirect:signin";
	}
	
}
