package com.alexproject.ninjagoldgame.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String index(
			HttpSession session) 
	{
		
		
		if(session.getAttribute("totalGold")==null && session.getAttribute("activityLog")==null) 
		{
			ArrayList<String> logs = new ArrayList<String>();
			session.setAttribute("totalGold", 0);
			session.setAttribute("activityLog", logs);
			
		} 
//		session.setAttribute("totalGold", 0);
//		session.setAttribute("activityLog", new ArrayList<String>());
		
		return "index.jsp";
	}
	
	@PostMapping("/processClick")
	public String earnGold(
			Model model,
			HttpSession session,
			@RequestParam(value="selectB") String selection
			) 
	{
		// Generate gold within the range: Math.floor(Math.random() *(max - min + 1) + min)
		
		// farmGold - generates random integer from 10 to 20 gold
		int farmGold = (int) Math.floor(Math.random() * (20 - 10 + 1) + 10 );
		
		// caveGold - generates random integer from 5 to 10 gold
		int caveGold = (int) Math.floor(Math.random() * (10 - 5 + 1) + 5 );
		
		// houseGold - generates random integer from 2 to 5 gold
		int houseGold = (int) Math.floor(Math.random() * (5 - 2 + 1) + 2 );
		
		// houseGold - generates random integer from -50 to 50 gold
		int questGold = (int) Math.floor(Math.random() * (50 - (-50) + 1) + (-50) );
		
		// houseGold - generates random integer from -5 to -20 gold
		int spaGold = (int) Math.floor(Math.random() * (-5 - (-20) + 1) + (-20) );
				
		
		// Timestamp for logs
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("(MMMM d yyyy hh:mm a)");
		String formattedDate = now.format(format);
		
		
		// Keep a log including the timestamp for each submission
		
		@SuppressWarnings("unchecked")
		ArrayList<String> logs = (ArrayList<String>) session.getAttribute("activityLog");
		
		String farmLog = "You entered a farm and earned "+farmGold+" gold. "+formattedDate;
		String caveLog = "You entered a cave and earned "+caveGold+" gold. "+formattedDate;
		String houseLog = "You entered a cave and earned "+houseGold+" gold. "+formattedDate;
		String questLog = (questGold>0)?
					("You entered a quest and earned "+questGold+" gold. "+formattedDate):
					("You failed a quest and lost "+Math.abs(questGold)+" gold. Ouch Pain Pighati "+formattedDate);
		String spaLog = "You entered a spa and lose "+Math.abs(spaGold)+" gold. "+formattedDate;
		
		
		if(selection.equals("farm")) 
		{
			session.setAttribute("totalGold", (int) session.getAttribute("totalGold")+farmGold);
			session.setAttribute("activityLog", logs.add(farmLog));
		}
		else if(selection.equals("cave")) 
		{
			session.setAttribute("totalGold", (int) session.getAttribute("totalGold")+caveGold);
			session.setAttribute("activityLog", logs.add(caveLog));
		}
		else if(selection.equals("house")) {
			session.setAttribute("totalGold", (int) session.getAttribute("totalGold")+houseGold);
			session.setAttribute("activityLog", logs.add(houseLog));
		}
		else if(selection.equals("quest")) {
			session.setAttribute("totalGold", (int) session.getAttribute("totalGold")+questGold);
			session.setAttribute("activityLog", logs.add(questLog));
		}else if(selection.equals("spa")) 
		{
			session.setAttribute("totalGold", (int) session.getAttribute("totalGold")+spaGold);
			session.setAttribute("activityLog", logs.add(spaLog));
		}
		
		
//		if((int) session.getAttribute("totalGold")<-50)
//		{
//			return "redirect:/prison";
//		}
			
		session.setAttribute("activityLog", logs);
			
		if(selection.equals("reset")) {
			session.setAttribute("totalGold", 0);
			session.setAttribute("activityLog", logs.removeAll(logs));
			
		}
			return "redirect:/";
	}
	
//	@GetMapping("/prison")
//	public String prisonCell(
//			HttpSession session,
//			@RequestParam(value="selectC") String selection)
//	{
//		if(selection.equals("reset")) {
//			session.setAttribute("totalGold", 0);
//			session.setAttribute("activityLog", new ArrayList<String>());
//			
//		}
//		return "prisonPage.jsp";
//	}
	
	
	
}
