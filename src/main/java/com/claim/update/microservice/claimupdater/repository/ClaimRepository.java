package com.claim.update.microservice.claimupdater.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.claim.update.microservice.claimupdater.model.Claim;

public interface ClaimRepository extends CrudRepository<Claim, BigDecimal> {
	public Claim save(Claim c);
	public Optional<Claim> findById(BigDecimal id);
	public List<Claim> findByStatus(String status);
}
