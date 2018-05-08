package com.codingdojo.ninjagold.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gold")
public class Games {
	
	Random random = new Random();
	
	@RequestMapping("")
	public String index(HttpSession session) {
		Integer gold = (Integer) session.getAttribute("gold");
		ArrayList<String> history =(ArrayList<String>) session.getAttribute("history");
		if(gold == null) {
			session.setAttribute("gold", 0);
		}
		if(history == null) {
			session.setAttribute("history", new ArrayList<String>());
		}
		Boolean result = (Boolean) session.getAttribute("result");
		if(result == null) {
			session.setAttribute("result", true);
		}
		
		return "index.jsp";
	}
	
	@RequestMapping("/{place}")
	public String place(@PathVariable String place, HttpSession session, Model model) {
		Integer gold = (Integer) session.getAttribute("gold");
		session.setAttribute("result", true);
		String event = "";
		
		if(place.equals("farm")) {
			int output = random.nextInt((20-10)+1)+10;
			gold+=output;
			event = "You went to the farm and won "+output+" gold";

		}
		else if(place.equals("cave")) {
			int output = random.nextInt((10-5)+1) +5;
			System.out.println("new gold: "+output);
			gold+=output;
			event = "You went to the cave and won "+output+" gold";

		}
		else if(place.equals("house")) {
			int output = random.nextInt((5-2)+1) +2;
			System.out.println("new gold: "+output);
			gold+=output;
			event = "You went to the house and won "+output+" gold";

		}
		else if(place.equals("casino")) {
			int win = random.nextInt((1-0)+1)+0;
			int output = random.nextInt((50-0)+1) +0;

			if(win == 0) {
				System.out.println("lost gold: "+output);
				event = "You went to the casino and lost "+output+" gold";
				gold-=output;
				session.setAttribute("result", false);
			}
			else {
				System.out.println("new gold: "+output);
				event = "You went to the casino and won "+output+" gold";
				gold+=output;	
			}

		}
		
		else if(place.equals("spa")) {
			int output = random.nextInt((20-5)+1) +5;
			System.out.println("new gold: "+output);
			gold-=output;
			event = "You went to the spa and spent "+output+" gold";
			session.setAttribute("result", false);

		}
		
		DateFormat dateFormat = new SimpleDateFormat("MMM d yyyy h:mm a");
		Date date = new Date();
		event+=" ("+dateFormat.format(date)+")";
		ArrayList<String> history = (ArrayList<String>) session.getAttribute("history");
		history.add(event);
		session.setAttribute("history", history);
		session.setAttribute("gold", gold);
		
		return "redirect:/gold";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", 0);
		session.setAttribute("history", new ArrayList<String>());
		
		return "redirect:/gold";
	}
}


//int randomNum = rand.nextInt((max - min) + 1) + min;