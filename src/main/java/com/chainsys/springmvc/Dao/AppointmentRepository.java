package com.chainsys.springmvc.Dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.Doctor;

public interface AppointmentRepository extends CrudRepository<Appointment,Integer>{

	Appointment findById(int id);

	Appointment save(Appointment app);

	// save doctor= adding or modifying doctor
	void deleteById(int id);

	List<Appointment> findAll();
	//define the native query for this method
	int getNextId();
}
