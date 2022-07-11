package com.chainsys.application.doctor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
	Doctor findById(int id);//find by id la query generate agum
	Doctor save(Doctor dr);
	//used for adding a new doctor and modifying new doctor
	void deleteById(int dr_id);
	List<Doctor> findAll();
}
