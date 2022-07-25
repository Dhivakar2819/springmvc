package com.chainsys.springmvc.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation. Autowired; import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.Doctor;
import com.chainsys.springmvc.pojo.DoctorAppointmentDTO;
import com.chainsys.springmvc.Dao.AppointmentRepository;
import com.chainsys.springmvc.Dao.DoctorRepositories;
@Service
public class DoctorServices {
@Autowired
private DoctorRepositories repo;
@Autowired
private AppointmentRepository apprepo;
public List<Doctor> getDoctors() { 
	List<Doctor> listDr=repo.findAll();
	return listDr;
}
public Doctor save(Doctor dr)
{
return repo.save(dr);
}
public Doctor findById(int id) {

return repo.findById(id);
}
@Transactional
public void deleteById(int id) {
	repo.deleteById(id);
}
public DoctorAppointmentDTO getDoctorAndAppointment(int id) {
	Doctor dr=findById(id);
	DoctorAppointmentDTO dto=new DoctorAppointmentDTO();
	dto.setDoctor(dr);
	for(int i=0;i<=5;i++) {
		Appointment app=new Appointment();
		app.setApp_id(id);
		Date dt=new Date(22,7,25);
		app.setApp_date(dt);
		app.setDoc_id(id);
		app.setPatient_name("mukesh");
		app.setFees_collected(i*500);
		dto.addAppointment(app);
	}
	return dto;
}
@Transactional
public void addDoctorAndAppointment(DoctorAppointmentDTO dto) {
	Doctor dr=dto.getDoctor();
	save(dr);
	List<Appointment> appointmentList=dto.getAppointment();
	int count=appointmentList.size();
	for(int i=0;i<count;i++) {
		apprepo.save(appointmentList.get(i));
	}
	
}
public int getNextAppointmentId() {
	return apprepo.getNextId();
}
}

