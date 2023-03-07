package com.axis.repository;

import org.springframework.data.repository.CrudRepository;

import com.axis.entity.Admin;

public interface AdminRepo extends CrudRepository<Admin, Integer> {

	public Admin findByEmailAndPassword(String email, String password);
}
