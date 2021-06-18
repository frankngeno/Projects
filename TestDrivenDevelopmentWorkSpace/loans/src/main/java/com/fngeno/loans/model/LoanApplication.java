package com.fngeno.loans;


import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class LoanApplication {
    private int id;
	private String name;
	private int principal;
	private int termInMonths;
	private BigDecimal interestRate;
	private BigDecimal repayment;
	private Boolean approved;

		public int getPrincipal() {
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
		return "LoansApplication{" +
				"id=" + id +
				", name='" + name + '\'' +
				", principal=" + principal +
				", termInMonths=" + termInMonths +
				", interestRate=" + interestRate +
				", repayment=" + repayment +
				", approved=" + approved +
				'}';
	}
}
