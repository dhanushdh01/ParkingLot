package main.Strategies.BillCalculationStrategy;

import main.Models.Bill;
import main.Models.Enums.BillStatus;
import main.Models.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SimpleBillCalculationStrategy implements BillCalculationStrategy{
    // 1 sec is 1 Rs.
    @Override
    public Bill generateBill(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        long numberOfSeconds = ChronoUnit.SECONDS.between(exitTime,entryTime);
        double amount = (double) numberOfSeconds;
        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setTicket(ticket);
        bill.setId(exitTime.hashCode());
        bill.setExitTime(exitTime);
        bill.setStatus(BillStatus.UNPAID);
        return bill;
    }

}
