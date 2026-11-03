package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import service.ContractService;
import service.PaypalService;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);   
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");



        System.out.println("Enter the contract data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.print("Valor do contrato: ");
        double totalValue = sc.nextDouble();

        Contract obj = new Contract(number, date, totalValue);

        System.out.print("Enter the number of installment: ");
        int n = sc.nextInt();


        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(obj, n);


        System.out.println("Installments: ");

        for (Installment installment : obj.getInstallment()){
            System.out.println(installment);
        }






        sc.close();

    }
}
