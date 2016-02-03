package org.testapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServerIdController {
	
	@RequestMapping("/serverId")
	public String identify(HttpServletRequest request, Model model){
		String serverName = request.getServerName();
		model.addAttribute("serverName", serverName);
		return "serverId";
	}

}
