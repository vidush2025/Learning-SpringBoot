package com.learningSpringBoot.internalWorkingOfSpring;

import org.springframework.stereotype.Component;

@Component
public class StripePaymentService implements PaymentService{

    @Override
    public String pay(){
        String payment = "Stripe Payment";
        System.out.println("Paying from: Stripe Payment Service");
        return payment;
    }
}
