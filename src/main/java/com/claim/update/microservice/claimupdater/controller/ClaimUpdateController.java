package com.claim.update.microservice.claimupdater.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.claim.update.microservice.claimupdater.model.Claim;
import com.claim.update.microservice.claimupdater.service.ClaimDataService;

@Controller
@CrossOrigin(origins = "*")
public class ClaimUpdateController {
	
	@Autowired
	private ClaimDataService service;

	
	@GetMapping("/fetch/claims")
	public @ResponseBody List<Claim> fetchClaims() {
		List<Claim> claims = service.getAllClaims();
		return claims;
	}
	
	@PostMapping("/fetch/claim/id")
	public @ResponseBody Optional<Claim> fetchClaimById(@RequestParam BigDecimal id) {
		return service.findById(id);
	}
	
	@PostMapping("/fetch/claim/status")
	public @ResponseBody List<Claim> fetchClaimById(@RequestParam String status) {
		return service.findByStatus(status);
	}
	
	@PostMapping("/save/claim")
	public @ResponseBody String save(@RequestParam String name, @RequestParam String status) {
		Claim createdClaim = service.save(new Claim(name, status));
		return createdClaim.toString();
	}
	
	@PostMapping("/update/claim")
	public @ResponseBody String update(@RequestParam BigDecimal ID, @RequestParam String name, @RequestParam String status) {
		String updateStatus = service.updateClaim(ID, name, status);
		return updateStatus;
	}
}
