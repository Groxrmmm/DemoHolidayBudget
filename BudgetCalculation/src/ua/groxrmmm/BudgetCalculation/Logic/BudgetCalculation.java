package ua.groxrmmm.BudgetCalculation.Logic;

/**
 * Class {@code BudgetCalculation}  is a class is a calculator which calculates all travel events
 * and allows setting cash nexus of travel participants .
 *
 * @since 1.01
 */

public class BudgetCalculation {
    private EventOfTravel[] mCalculatesEvents;
    public BudgetCalculation(Travel travel)
    {
        this.mCalculatesEvents = travel.getEventOfTravel();
    }
    public void start()
    {
        for (EventOfTravel event : mCalculatesEvents) {
            new SingleEventCalculation(event).start();
        }
    }
}
