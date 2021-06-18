package com.fngeno.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;

@SpringBootApplication
@Entity
public class LoanApplication {
	private int id;
	private String name;
	private int principal;
	private int termInMonths;
	private BigDecimal interestRate;
	private BigDecimal repayment;
	private Boolean approved;

		public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(int principal) {
		this.principal = principal;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public double getTermInMonths() {
		return termInMonths;
	}

	public void setTermInMonths(int termInMonths) {
		this.termInMonths = termInMonths;
	}

	public void setRepayment(BigDecimal repayment) {
		this.repayment = repayment;
	}

	public BigDecimal getRepayment() {
		return repayment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "LoanApplication{" +
				"id=" + id +
				", name='" + name + '\'' +
				", principal=" + principal +
				", termInMonths=" + termInMonths +
				", interestRate=" + interestRate +
				", repayment=" + repayment +
				", approved=" + approved +
				'}';
	}

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

}
