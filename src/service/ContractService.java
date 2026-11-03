package service;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {

    private OnlinePaymentService payService;

    

    public ContractService(OnlinePaymentService payService) {
        this.payService = payService;
    }



    public void processContract(Contract contract, Integer months){


    double basicQuota = contract.getTotalValue() / months;
        for (int i = 1; i<= months; i++){

            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interest = payService.interest(basicQuota, i);
            double fee = payService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            contract.getInstallment().add(new Installment(dueDate, quota));






        



        }

        

    }
}
