package ua.groxrmmm.BudgetCalculation.ForTest;

import ua.groxrmmm.BudgetCalculation.Logic.ParticipantOfTravel;
import ua.groxrmmm.BudgetCalculation.Logic.Travel;

public class PrintCashNexus {
    public PrintCashNexus(Travel travel)
    {
        System.out.println("На данный момент путишествия");
        for(ParticipantOfTravel pot : travel.getParticipantTravel())
        {
            for(ParticipantOfTravel pot2 : travel.getParticipantTravel())
            {
                if(!pot.equals(pot2))
                    System.out.println("Денежные отношения между " + pot.getId() + " и " + pot2.getId()
                            + " = " + pot.getCashNexusWith(pot2));
            }
        }
    }
}
