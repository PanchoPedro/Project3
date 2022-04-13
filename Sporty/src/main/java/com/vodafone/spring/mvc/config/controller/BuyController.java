package com.vodafone.spring.mvc.config.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import SportyShoes.Ecommerce.database.ShoeDatabase;
import SportyShoes.Ecommerce.entity.Shoe;
import com.vodafone.spring.mvc.config.entity.ShoetoBuy;

@Controller
public class BuyController {

	@Autowired
	ShoeDatabase db;
	
	@PostMapping("/buy")
	public String dashboard(ShoetoBuy shtb, HttpSession session, Map<String, String> map
			,Map<String, Shoe> mapList)
	{
		//System.out.println(shid);
		System.out.println(session.getAttribute("userid"));
		session.setAttribute("shid", shtb.getSid());
		String email = (String)session.getAttribute("email");
		//if(email != null) {
			map.put("email", email);
			mapList.put("shoes", db.getShoeById(Integer.valueOf(shtb.getSid())));
			System.out.println(mapList);
			return "buy";
	//	}
		//return "redirect:signin";
	}
	
	@PostMapping("/purchase")
	public String purchase(ShoetoBuy shtb, HttpSession session, Map<String, String> map
			,Map<String, Shoe> mapList)
	{
		//System.out.println(shid);
		System.out.println(session.getAttribute("userid"));
		//session.setAttribute("shid", shtb.getSid());
		String email = (String)session.getAttribute("email");
		String shid = (String)session.getAttribute("shid");
		if(email != null) {
			map.put("email", email);
			mapList.put("shoes", db.getShoeById(Integer.valueOf(shid)));
			session.setAttribute("finalprice", (Integer.valueOf((String)shtb.getNshoes())*db.getShoeById(Integer.valueOf((String)session.getAttribute("shid"))).getSprice()));
			session.setAttribute("numberofshoes", ((String)shtb.getNshoes()));

			return "purchase";
	}
		return "redirect:signin?error=Unable to purchase without Login";
	}
}
