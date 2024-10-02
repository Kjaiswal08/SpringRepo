package com.collegeproject.intrusiondetection;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController1 {
	
	@Autowired
	ServiceLayer servicelayer;
	
	@Autowired
	MalwareRepo repo;
	
	@GetMapping("/")
	public String home() {
			return "index";
	}
	
	@PostMapping("/upload")
	public String UploadedFile(@RequestParam("file") MultipartFile file,Model m) {
		String st="7419091482bffe6ddb3ae66608db0517";
		if (file.isEmpty()) {
            st="No file selected";
        }

        try {
            // Compute the SHA-256 hash
            String sha256Hash = servicelayer.computeSHA256(file.getInputStream());
            st=sha256Hash+",,,";

        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            st="Error processing file: " + e.getMessage();
        }	
        System.out.println(st);
        m.addAttribute("status", repo.findById(st));
		return "result";
	}

}
