package com.chainsys.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.Doctor;
import com.chainsys.springmvc.pojo.DoctorAppointmentDTO;
import com.chainsys.springmvc.pojo.Employee;
import com.chainsys.springmvc.services.DoctorServices;
import com.chainsys.springmvc.Dao.DoctorRepositories;
import com.chainsys.springmvc.Dao.EmployeeDao;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorRepositories repo;
	//@Bean
//	public void createrepo(DoctorRepositories repo) {
//		this.repo=repo;
//	}
//	@GetMapping("/getdoctor")
//	public Doctor getDoctor(int id)
//	{
//		return repo.findById(id);
//	}
	@Autowired
	DoctorServices drservices;
	@GetMapping("/list")
	public String getFindAll(Model model) {
		List<Doctor> dr = drservices.getDoctors();
		model.addAttribute("allDoctors", dr);
		return "list-doctor";
	}
	
	@GetMapping("/addform")
	public String showAddForm(Model model) {
		Doctor dr = new Doctor();
		model.addAttribute("adddoctor", dr);
		return "add-doctor-form";
	}

	@PostMapping("/add")
	public String addNewDoctor(@ModelAttribute("adddoctor") Doctor dr) {
		drservices.save(dr);
		return "redirect:/doctor/list";
	}
	
	@GetMapping("/updateform")
	public String showUpdateForm(@RequestParam("docid") int id, Model model ){
//		Doctor dr = new Doctor();
		Doctor dr=drservices.findById(id);
		model.addAttribute("updatedoctor", dr);
		return "update-doctor-form";
	}

	@PostMapping("/update")
	public String UpdateDoctor(@ModelAttribute("updatedoctor") Doctor dr) {
		drservices.save(dr);
		return "redirect:/doctor/list";
	}
	
	
	@GetMapping("/deletedoctor")
	public String deleteDoctor(@RequestParam("docid") int id) {
		drservices.deleteById(id);
		return "redirect:/doctor/list";
	}
	
	@GetMapping("/getdoctor")
	public String getDoctor(@RequestParam("docid") int id,Model model)
	{
		Doctor dr=repo.findById(id);
		model.addAttribute("finddoctorbyid",dr);
		return "find-doctor-by-id";
	}
	
	
	@GetMapping("/getdocapp")
    public String getAppointments(@RequestParam("id") int id,Model model)
    {
        DoctorAppointmentDTO dto=drservices.getDoctorAndAppointment(id);
        model.addAttribute("getdoc", dto.getDoctor());
        model.addAttribute("applist",dto.getAppointment() );
        return "list-doctor-appointment";
    }
	// http://localhost:8080/doctor/trans?id=?
	@GetMapping("/trans")
	public void testTransaction(@RequestParam("id") int id) {
		DoctorAppointmentDTO dto=new DoctorAppointmentDTO();
		Doctor dr=new Doctor();
		dr.setDoc_id(id);
		dr.setDoc_name("Dhiva");
		Date drdob=new Date(22,7,25);
		dr.setDob(drdob);
		dr.setCity("city");
		dr.setPhone_no(1234567890L);
		dr.setSpeciality("bone");
		dr.setFees(800);
		dto.setDoctor(dr);
		List<Appointment> applist=new ArrayList<Appointment>();
		int nextAppId=drservices.getNextAppointmentId();
		for(int i=200;i<=202;i++) {
			Appointment app=new Appointment();
			app.setApp_id(i);
			Date appdt=new Date(22,7,25);
			app.setApp_date(appdt);
			app.setDoc_id(id);
			app.setPatient_name("mukesh");
			app.setFees_collected(dr.getFees());
			dto.addAppointment(app);
		}
		drservices.addDoctorAndAppointment(dto);
		System.out.println("Successfully completed");
	}
}
