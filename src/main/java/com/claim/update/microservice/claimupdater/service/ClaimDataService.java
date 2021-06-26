package com.claim.update.microservice.claimupdater.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.update.microservice.claimupdater.model.Claim;
import com.claim.update.microservice.claimupdater.repository.ClaimRepository;

@Service
public class ClaimDataService {

	@Autowired
	ClaimRepository repo;
	
	public Claim save(Claim c) {
		Claim claim = repo.save(c);
		return claim;
	}
	
	public List<Claim> getAllClaims() {
		List<Claim> claims = new ArrayList<Claim>();
		
		repo.findAll().forEach(claim -> {
			claims.add(claim); 
		});
		return claims;
	}
	
	public Optional<Claim> findById(BigDecimal id) {
		return repo.findById(id);
	}
	
	public List<Claim> findByStatus(String s) {
		List<Claim> claims = new ArrayList<Claim>();
		
		List<Claim> records = repo.findByStatus(s);
		
		if(records != null && records.size() > 0) {
			records.forEach(claim -> claims.add(claim));
		}
		
		return claims;
	}

	public String updateClaim(BigDecimal ID, String name, String status) {
		Claim claim = repo.findById(ID).orElseThrow();
		
		if(claim != null) {
			Claim updatedClaim = claim;
			updatedClaim.setName(name);
			updatedClaim.setStatus(status);
			repo.save(updatedClaim);
			return updatedClaim.toString();
		}
		return null;
	}
	
	
}
