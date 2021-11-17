package com.example.MyBookStore.controllers
;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	private Map<String, String> adminData = new HashMap<>(); 
	
	@GetMapping("/")
    public String home(){
        return "home";
    }
	
	@GetMapping("/user/data")
	@Secured("ROLE_USER")
    public String getUser(){
        return "user data etc.";
    }
	
	@GetMapping("/admin/data/add")
	@Secured("ROLE_ADMIN")
	public String addAdminData(){
        adminData.put("" + adminData.size(), adminData.size()+ "_randomX");
        return "ok";
    }
	
	
	@GetMapping("/admin/data/show")
	@Secured("ROLE_ADMIN")
	public Map<String, String> getAdminData(){
        return adminData;
    }
}
