package com.fngeno.loans.controler;

import com.fngeno.loans.model.LoanApplication;
import com.fngeno.loans.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;

@Controller
public class LoanCalculatorController {
    @Autowired
    private LoanRepository data;

    @Autowired
    private JavaMailSender mailSender;

    private RestTemplate restTemplate =  new RestTemplate();

    //Render the form
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView renderNewLoanForm(){
        LoanApplication loan = new LoanApplication();
        return new ModelAndView("newApplication", "form", loan);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView processingNewLoanApplication(LoanApplication loan){

        data.save(loan);

        URI location = restTemplate.postForLocation("http://loans.virtualpairprogrammers.com/loanApplication", loan); //this line sends loans for approval request, which could take up to 24 hrs
        //TODO step #1
        BigDecimal applicableRate = loan.getInterestRate().divide(new BigDecimal("100")).multiply(new BigDecimal(loan.getTermInMonths())).divide(new BigDecimal("12"));
        applicableRate =  applicableRate.add(new BigDecimal("1"));
        //TODO step #2
        BigDecimal totalRepayable =  new BigDecimal(loan.getPrincipal() * Double.parseDouble(applicableRate.toString()));
        //TODO step #3
        BigDecimal repayment =  totalRepayable.divide(new BigDecimal("" + loan.getTermInMonths()), RoundingMode.UP);
        loan.setRepayment(repayment);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(loan.getName());
        message.setSubject("Thank you for your loan application");
        message.setText(" We're currently processing your request, and will" +
                " send you a further email when we have a decision");
        mailSender.send(message);

        return new ModelAndView("requestAccepted");
    }

    //TODO set methods used for testing only


    public void setData(LoanRepository data) {
        this.data = data;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
