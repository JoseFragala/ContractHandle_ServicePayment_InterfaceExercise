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

        contract.getInstallment().add(new Installment(LocalDate.of(2018, 7, 25), 206.04));
        contract.getInstallment().add(new Installment(LocalDate.of(2018, 8, 25), 208.88));

        

    }
}
