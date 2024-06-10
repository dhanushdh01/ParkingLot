package main.Services;

import main.Models.Bill;
import main.Strategies.BillCalculationStrategy.BillCalculationStrategy;
import main.Strategies.BillCalculationStrategy.BillCalculationStrategyFactory;

public class BillService {
    public Bill generateBill(int ticketId, int exitGateId) {
        BillCalculationStrategy billCalculationStrategy =
                BillCalculationStrategyFactory.getBill();
        /*
            fetch ticket object from the repository
            double amount = billCalculationStrategy.generateBill(ticket);
         */
        Bill bill = new Bill();
        // add all the details required to bill
        //release the spot -> spot details are present inside the ticket object
        return bill;
    }
}
