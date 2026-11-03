package service;

public class PaypalService implements OnlinePaymentService {

    
    public Double interest(Double amount, Integer month){
        return amount + (amount * 0.01) * month;
    }

    public Double paymentFee(Double amount){
        return amount + (amount * 0.02);
    }


    
}
