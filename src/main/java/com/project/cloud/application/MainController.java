package com.project.cloud.application;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MainController {
	
	@Autowired
	private UserService userv;
	
	@Autowired
	private PatientService pserv;
	
	
	

	 @GetMapping("/")
	    public String viewHomePage() {
	        return "Home";
	    }
	 
	 @GetMapping("/about")
	    public String viewAboutPage() {
	        return "About";
	    }
	 
	 @GetMapping("/contac")
	    public String viewContactPage() {
		   
	        return "ContactUs";
	    }
	     
	 @GetMapping("/our")
	    public String viewOurServicesPage() {
	        return "OurServices";
	    }
	 
	 @GetMapping("/stafflogin")
	    public String viewStaffLoginPage() {
	        return "StaffLogin";
	    }
	 
	 @GetMapping("/doctor/login")
	    public String viewdoctorLoginPage() {
		    
	        return "/doctor/DoctorLogin";
	        
	    }
	 
	 @GetMapping("/reception/login")
	    public String viewReceptionistLoginPage() {
	        return "reception/ReceptionistLogin";
	    }
	 
	 @GetMapping("/pharmacy/login")
	    public String viewPharmacistLoginPage() {
	        return "/pharmacy/PharmacistLogin";
	    }
	 
	 @GetMapping("/reception/home")
	    public String viewReceptionHomePage(Model model) {
		 List<Patient> listpatient = pserv.listAll();
	        model.addAttribute("listpatient", listpatient);
	        System.out.print("Get / ");
	        return "/reception/ReceptionHome";
	    }
	 
	
	 
	 @GetMapping("/doctor/home")
	    public String viewDoctorHomePage(Model model) {
		 List<Patient> listpatient = pserv.listAll();
	        
			model.addAttribute("listpatient", listpatient);
	        System.out.print("Get / ");
	        return "/doctor/DoctorHome";
	    }
	 @GetMapping("/pharmacy/home")
	    public String viewPharmacyHomePage(Model model) {
		 List<Patient> listpatient = pserv.listAll();
	        
			model.addAttribute("listpatient", listpatient);
	        System.out.print("Get / ");
	        return "/pharmacy/PharmacyHome";
	    }
	 
	 @GetMapping("/reception/register")
	    public String add(Model model) {
	        model.addAttribute("patient", new Patient());
	        return "/reception/ReceptionRegister";
	    }
	 
	 @RequestMapping(value ="/save", method = RequestMethod.POST)
	    public String savePatient(@ModelAttribute("patient") Patient pt) {
	        pserv.save(pt);
	        return "redirect:/reception/home";
	    }
	 @RequestMapping("/edit/{patid}")
	    public ModelAndView showEditStudentPage(@PathVariable(name = "patid") int patid) {
	        ModelAndView mav = new ModelAndView("reception/ReceptionRegister");
	        Patient pt = pserv.get(patid);
	        mav.addObject("patient", pt);
	        return mav;
	        
	    }
	 @RequestMapping("/prescription/{patid}")
	 public ModelAndView showPatientDetails(@PathVariable(name = "patid") int patid) {
	        ModelAndView mav = new ModelAndView("/doctor/DoctorPrescription");
	        Patient pt = pserv.get(patid);
	        mav.addObject("patient", pt);
	        return mav;
	        
	    }
	    @RequestMapping("/delete/{patid}")
	    public String deletepatient(@PathVariable(name = "patid") int patid) {
	        pserv.delete(patid);
	        return "redirect:/reception/home";
	    }
	    
	    @RequestMapping(value ="/savePrescription", method = RequestMethod.POST)
	    public String savePatientPrescription(@ModelAttribute("patient") Patient pt) {
	        pserv.save(pt);
	        return "redirect:/doctor/home";
	    }
	   
	    
	    
	  
}

