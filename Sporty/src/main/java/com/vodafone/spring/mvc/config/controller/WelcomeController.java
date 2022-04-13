package com.vodafone.spring.mvc.config.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import SportyShoes.Ecommerce.database.ShoeDatabase;
import SportyShoes.Ecommerce.entity.Shoe;

@Controller
public class WelcomeController {

	@Autowired
	ShoeDatabase db;
	
	@GetMapping("/welcome")
	public String dashboard(HttpSession session, Map<String, String> map
			,Map<String, List<Shoe>> mapList)
	{
		
		String email = (String)session.getAttribute("email");
		//if(email != null) {
			map.put("email", email);
			mapList.put("shoes", db.getShoes());
			System.out.println(mapList);
			return "welcome";
	//	}
		//return "redirect:signin";
	}
	
	@GetMapping("/faq")
	public String faqdashboard(HttpSession session, Map<String, String> map)
	{
		
		String email = (String)session.getAttribute("email");
		//if(email != null) {
			map.put("email", email);
			return "faq";
	//	}
		//return "redirect:signin";
	}
	
	@GetMapping("/browseproducts")
	public String browsepdashboard(HttpSession session, Map<String, String> map
			,Map<String, List<Shoe>> mapList)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			map.put("email", email);
			mapList.put("shoes", db.getShoes());
			//System.out.println(mapList);
			return "browseproducts";
	}
		return "redirect:signin";
	}
	
	@PostMapping("/addproduct")
	public String addproductdashboard(Shoe shoe,HttpSession session, Map<String, String> map
			)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			
				if(db.insertShoe(shoe)) {
					map.put("email", email);
					return "redirect:manageproducts?error=Success adding Product";
				}
			

			return "redirect:manageproducts?error=Error adding Product";
			
	}
		return "redirect:signin";
	}
	
	@PostMapping("/deleteproduct")
	public String delproductdashboard(Shoe shoe,HttpSession session, Map<String, String> map
			)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			
				if(db.deleteShoe(shoe.getSid())) {
					map.put("email", email);
					return "redirect:manageproducts?error=Success Deleting Product";
				}
			

			return "redirect:manageproducts?error=Error Deleting Product";
			
	}
		return "redirect:signin";
	}
	
	
}
