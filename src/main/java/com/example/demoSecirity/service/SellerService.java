package com.example.demoSecirity.service;

import com.example.demoSecirity.entity.Seller;

import java.util.List;

public interface SellerService {

	List<Seller> findAll();

	Seller findById(int theId);
	
	void save(Seller theEmployee);
	
	void deleteById(int theId);
	
}
