package com.claim.update.microservice.claimupdater.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Claim_Tbl")
public class Claim {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigDecimal ID;
	private String name;
	private String status;
	
	
	public Claim() {
		super();
	}

	public Claim(String name, String status) {
		super();
		this.name = name;
		this.status = status;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getClaimId() {
		return ID;
	}
	
	@Override
	public String toString() {
		return "Claim [claimId=" + ID + ", name=" + name + ", status=" + status + "]";
	}
}
