package com.chainsys.springmvc.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.chainsys.springmvc.pojo.Doctor;

public interface DoctorRepositories extends CrudRepository<Doctor, Integer> {
	Doctor findById(int id);

	Doctor save(Doctor dr);

	// save doctor= adding or modifying doctor
	void deleteById(int id);

	List<Doctor> findAll();
}
