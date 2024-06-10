package main.Strategies.BillCalculationStrategy;

import main.Models.Bill;
import main.Models.Ticket;

public interface BillCalculationStrategy {
    Bill generateBill(Ticket ticket);
}
