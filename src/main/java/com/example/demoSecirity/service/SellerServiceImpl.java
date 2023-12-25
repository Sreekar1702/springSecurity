package com.example.demoSecirity.service;

import com.example.demoSecirity.dao.SellerRepository;
import com.example.demoSecirity.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements SellerService {

	private SellerRepository sellerRepository;
	
	@Autowired
	public SellerServiceImpl(SellerRepository theSeller) {
		sellerRepository = theSeller;
	}
	
	@Override
	public List<Seller> findAll() {
		return sellerRepository.findAll();
	}

	@Override
	public Seller findById(int theId) {
		Optional<Seller> result = sellerRepository.findById(theId);

		Seller theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Seller theEmployee) {
		sellerRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		sellerRepository.deleteById(theId);
	}

}






