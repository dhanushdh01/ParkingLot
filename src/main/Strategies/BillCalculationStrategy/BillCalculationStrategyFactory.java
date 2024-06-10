package main.Strategies.BillCalculationStrategy;

public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getBill(){
        return new SimpleBillCalculationStrategy();
    }
}
