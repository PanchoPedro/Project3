package com.vodafone.spring.mvc.config.controller;


import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import SportyShoes.Ecommerce.database.OrderDatabase;
import SportyShoes.Ecommerce.entity.Order;

@Controller
public class OrdersController {

	@Autowired
	OrderDatabase db;
	
	@PostMapping("/order")
	public String orderdashboard( HttpSession session, Map<String, String> map
			,Map<String, Order> mapList)
	{
		int counti=0;
		System.out.println(counti++);
		String email = (String)session.getAttribute("email");
		System.out.println(counti++);
		if(email != null) {
			String shid = (String)session.getAttribute("shid");
			System.out.println(counti++);
			String userid = String.valueOf(session.getAttribute("userid"));
			System.out.println(counti++);
			String numberofshoes = (String)session.getAttribute("numberofshoes");
			System.out.println(counti++);
			Order order = new Order();
			System.out.println(counti++);
			order.setUserid(Integer.valueOf(userid));
			System.out.println(counti++);
			order.setShoeid(Integer.valueOf(shid));
			System.out.println(counti++);
			order.setNumberofshoes(Integer.valueOf(numberofshoes));
			System.out.println(counti++);
			map.put("email", email);
			if(db.insertOrder(order)) {
				//session.setAttribute("email", user.getEmail());
				//session.setAttribute("userid", db.getUserByEmail(user.getEmail()).getId());
				//model.addAttribute("email", user.getEmail());
				System.out.println(counti++);
				return "Success";
			}
			else {
				return "Error";
			}
		}
		System.out.println(counti++);
		return "redirect:signin?error=Unable to purchase without Login";
	}
	

}
