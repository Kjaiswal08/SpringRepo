package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	private static List<Employee> arr;
	static {
		arr=new ArrayList<>();
	}
	@ModelAttribute
	public void ModelData(Model m) {
		m.addAttribute("visitor","Navin");
	}
	
	@RequestMapping("/")
	public String main() {System.out.println("Homepage requested");return "index";}
	
	/*@RequestMapping("add")
	public String result(HttpServletRequest req) {
		int nums1=Integer.parseInt(req.getParameter("nums1"));
		int nums2=Integer.parseInt(req.getParameter("nums2"));
		int num3=nums1+nums2;
		System.out.println("Result page requested");
		HttpSession session=req.getSession();
		session.setAttribute("num3", num3);
		return "result.jsp";
	}*/
	
	
	/*@RequestMapping("add")
	public String result(@RequestParam("nums1") int nums1,@RequestParam("nums2") int nums2,HttpSession session) {
		session.setAttribute("num3", nums1+nums2);
		return "result.jsp";
		
	}*/
	@RequestMapping("add")
	public ModelAndView result(@RequestParam("nums1") int nums1,@RequestParam("nums2") int nums2) {
		//You could replace ModelAndView with Model If you just want to store the details
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result");
		mv.addObject("num3", nums1+nums2);
		return mv;
		
	}
	/*@RequestMapping("employee")
	public String employee(@RequestParam("empid")int empid,@RequestParam("empname")String empname,Model m)
	{
		Employee emp=new Employee();
		emp.setEmpid(empid);emp.setEmpname(empname);
		
		m.addAttribute("employeedetails", emp.toString());
		return "result1";
	}*/
	
	
	@RequestMapping(value="employee",method=RequestMethod.POST)
	public String employee(@ModelAttribute("employeedetails")Employee e1)
	{
		arr.add(e1);
		empsRepo.save(e1);
		return "result1";
	}
	/*Instead of RequestMapping we can use PostMapping or GetMapping to specify which kind of request it should send or receive
	 * We could also write RequestMapping(value="employee", method=RequestMethod.POST) for this to work you also have to specify the method
	 * used in the jsp file where the action take place and calls this Mapping*/
	
	@GetMapping("getemployee")
	public String get_employess(Model m) {
		
		m.addAttribute("allemployee", arr);
		return "result2";
	}
	
	/*From Here we have started working with JSP and DB*/
	
	/* To work with DB and Not Internal memory we use this Object. For more see the EmployeeRepo Class*/
	@Autowired
	EmployeeRepo empsRepo;
	
	
	@GetMapping("getemployee1")
	public String get_employess1(Model m) {
		
		m.addAttribute("allemployee", empsRepo.findAll());
		return "result3";
	}
	
	@GetMapping("getoneemployee")
	public String get_one_employee(@RequestParam("empid") int empid,Model m) {
		
		m.addAttribute("allemployee", empsRepo.findById(empid));
		return "result3";
	}
	
	@GetMapping("getemployeebyname")
	public String get_employee_by_name(@RequestParam("empname") String empname,Model m) {
		
		//m.addAttribute("allemployee", empsRepo.findByEmpname(empname));
		m.addAttribute("allemployee",empsRepo.find(empname));
		return "result3";
	}
}
