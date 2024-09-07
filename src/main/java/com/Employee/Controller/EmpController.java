package com.Employee.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.Employee.Entity.Employee;
import com.Employee.Service.EmpServices;

//import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {

	@Autowired
	private EmpServices services;

	@GetMapping("/")
	private String Index(Model model) {

		List<Employee> emp = services.getAllEmp();
		model.addAttribute("emp", emp);

		return "index";
	}

	@GetMapping("/add_Emp")
	private String addEmp() {
		return "header";
	}

	@GetMapping("edit/add_Emp")
	private String addEmpEdit() {
		return "header";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute Employee e, HttpSession session) {
		System.out.println(e);
		session.setAttribute("msg", "Employee Register Sucessfully...");
		services.addEmp(e);
		return "redirect:/";
	}

	@GetMapping("/clearMessage")
	@ResponseBody
	public void clearMessage(HttpSession session) {
		session.removeAttribute("msg");
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = services.getEmpById(id);
		m.addAttribute("emp", e);

		return "edit";
	}

	@PostMapping("/update")
	public String EmpUpdate(@ModelAttribute Employee e, HttpSession session) {
		services.addEmp(e);
		session.setAttribute("msg", "Employee Data Edit Successfully....");
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {

		services.DeleteEmp(id);
		session.setAttribute("msg", "Employee Data Deleted Successfully....");
		return "redirect:/";
	}

}
