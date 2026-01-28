package com.learningSpringBoot.internalWorkingOfSpring;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "razorpay")
public class RazorPayPaymentService implements PaymentService{

    @Override //optional
    public  String pay(){
        String payment = "RazorPay payment";
        System.out.println("Payment done via: " + payment);
        return payment;
    }
}