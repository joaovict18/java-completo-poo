package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		
		double quota = contract.getTotalValue() / months;
		
		for (int i=1; i<=months; i++) {
			
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double interest = onlinePaymentService.interest(quota, i);
			double fee = onlinePaymentService.paymentFee(quota + interest);
			
			double amount = quota + interest + fee;
			
			contract.getList().add(new Installment(dueDate, amount));
		}
	}

}
