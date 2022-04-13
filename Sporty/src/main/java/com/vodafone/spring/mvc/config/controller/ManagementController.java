package com.vodafone.spring.mvc.config.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import SportyShoes.Ecommerce.database.CompanyDatabase;
import SportyShoes.Ecommerce.entity.Company;
import SportyShoes.Ecommerce.database.CategoryDatabase;
import SportyShoes.Ecommerce.entity.Category;
import SportyShoes.Ecommerce.database.DescriptiveOrderDatabase;
import SportyShoes.Ecommerce.entity.DescriptiveOrder;

@Controller
public class ManagementController {

	@Autowired
	CompanyDatabase db;
	
	@Autowired
	CategoryDatabase dbcat;
	
	@Autowired
	DescriptiveOrderDatabase dborders;

	
	
	@GetMapping("/browsecompanies")
	public String browsecompdashboard(HttpSession session, Map<String, String> map
			,Map<String, List<Company>> mapList)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			map.put("email", email);
			mapList.put("companies", db.getCompanies());
			//System.out.println(mapList);
			return "browsecompanies";
	}
		return "redirect:signin";
	}
	
	@GetMapping("/browsecategories")
	public String browsecatdashboard(HttpSession session, Map<String, String> map
			,Map<String, List<Category>> mapList)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			map.put("email", email);
			mapList.put("categories", dbcat.getCategories());
			//System.out.println(mapList);
			return "browsecategories";
	}
		return "redirect:signin";
	}
	
	@GetMapping("/managecompanies")
	public String managecomdashboard(@RequestParam(required = false)
	String error,HttpSession session, Map<String, String> map
			)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			map.put("email", email);
			if(error != null)
				map.put("error", error);
			return "managecompanies";
	}
		return "redirect:signin";
	}
	
	@PostMapping("/addcompany")
	public String addcompanydashboard(Company company,HttpSession session, Map<String, String> map
			)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			
				if(db.insertCompany(company)) {
					map.put("email", email);
					return "redirect:managecompanies?error=Success adding Company";
				}
			

			return "redirect:managecompanies?error=Error adding Company";
			
	}
		return "redirect:signin";
	}
	
	
	@GetMapping("/managecategories")
	public String managecatdashboard(@RequestParam(required = false)
	String error,HttpSession session, Map<String, String> map
			)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			map.put("email", email);
			if(error != null)
				map.put("error", error);
			return "managecategories";
	}
		return "redirect:signin";
	}
	
	@PostMapping("/addcategory")
	public String addcategorydashboard(Category category,HttpSession session, Map<String, String> map
			)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			
				if(dbcat.insertCategory(category)) {
					map.put("email", email);
					return "redirect:managecategories?error=Success adding Category";
				}
			

			return "redirect:managecategories?error=Error adding Category";
			
	}
		return "redirect:signin";
	}
	
	
	@GetMapping("/manageproducts")
	public String manageproddashboard(@RequestParam(required = false)
	String error,HttpSession session, Map<String, String> map
			,Map<String, List<Company>> mapList,Map<String, List<Category>> mapLista)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			map.put("email", email);
			mapList.put("companies", db.getCompanies());
			mapLista.put("categories", dbcat.getCategories());
			if(error != null)
				map.put("error", error);
			return "manageproducts";
	}
		return "redirect:signin";
	}
	
	
	@GetMapping("/purchasereports")
	public String reportsdashboard(@RequestParam(required = false)
	String error,HttpSession session, Map<String, String> map
			,Map<String, List<DescriptiveOrder>> mapList)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			map.put("email", email);
			mapList.put("orders", dborders.getorders());
			if(error != null)
				map.put("error", error);
			map.put("error", "Total Orders");
			return "purchasereports";
	}
		return "redirect:signin";
	}
	
	
	@PostMapping("/filterorderbycategory")
	public String filterordercatdashboard(Category category,HttpSession session, Map<String, String> map
			,Map<String, List<DescriptiveOrder>> mapList)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			
			    mapList.put("orders",dborders.getOrdersByCategory(category.getCategory())); 
				map.put("email", email);
				map.put("error", "Filtered results");
				return "purchasereports";
				
			

			//return "redirect:managecategories?error=Error adding Category";
			
	}
		return "redirect:signin";
	}
	
	@PostMapping("/filterorderbydate")
	public String filterorderdatedashboard(String date,HttpSession session, Map<String, String> map
			,Map<String, List<DescriptiveOrder>> mapList)
	{
		
		String email = (String)session.getAttribute("email");
		boolean admin = (boolean) session.getAttribute("admin");
		if(email != null && admin) {
			
			    mapList.put("orders",dborders.getOrdersByDate(date)); 
				map.put("email", email);
				map.put("error", "Filtered results");
				return "purchasereports";
				
			

			//return "redirect:managecategories?error=Error adding Category";
			
	}
		return "redirect:signin";
	}
	
	
	
	
}
