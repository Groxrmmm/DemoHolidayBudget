package ua.groxrmmm.BudgetCalculation.Logic;

import java.util.ArrayList;

/**
 * Class {@code SingleEventCalculation} is a class which calculates monetary relations of participants of event.
 *
 * First is the average amount that is the amount that would, if all were paid equally.
 * The second step is to find those participants who have paid more than they should.
 * The third step is to find an overpayment that is the amount that a total overpaid creditors.
 * The fourth step is to find debtors.
 * The final step is to calculate the monetary relationship between creditors and debtors:
 * for each creditor will find his percentage of overpayment on the total overpayment,
 * and then each of the debtors will be added to the monetary relations with the creditor
 * the amount that is equal to the underpayment debtor multiplied by the percentage of creditor overpayments.
 * Add the amount to the creditor opposite
 *
 * @since 1.01
 */

public class SingleEventCalculation {

    private EventOfTravel mEvent;
    private ArrayList<ParticipantOfTravel> mParticipantsDebtors = new ArrayList<>();
    private ArrayList<ParticipantOfTravel> mParticipantsCreditors = new ArrayList<>();
    private float mOverpaymentOfCreditors;
    private float mAverage;

    public SingleEventCalculation(EventOfTravel event)
    {
        this.mEvent = event;
    }
    public void start()
    {
        findAverage();
        findCreditors();
        findOverpayment();
        findDebtors();
        calculationOfCashNexus();
    }
    private void findCreditors()
    {
        for (ParticipantOfTravel participant: mEvent.getParticipantsOfEvent()) {
            if (mEvent.getHowPaid(participant) > mAverage) {
                mParticipantsCreditors.add(participant);
            }
        }
    }
    private void findDebtors()
    {
        for (ParticipantOfTravel participant: mEvent.getParticipantsOfEvent())
        {
             if(mEvent.getHowPaid(participant)<mAverage)
                mParticipantsDebtors.add(participant);
        }
    }
    private void findOverpayment()
    {
        for(ParticipantOfTravel participant: mParticipantsCreditors)
            mOverpaymentOfCreditors+=mEvent.getHowPaid(participant)-mAverage;
    }
    private void findAverage()
    {
        mAverage = mEvent.getPrice() / mEvent.getParticipantsOfEvent().length;
    }
    private void calculationOfCashNexus()
    {
        for (ParticipantOfTravel participant_creditor: mParticipantsCreditors) {
            float percent = (mEvent.getHowPaid(participant_creditor)-mAverage)/mOverpaymentOfCreditors;
            for(ParticipantOfTravel participant_debtor : mParticipantsDebtors)
            {
                float cashNexus = participant_debtor.getCashNexusWith(participant_creditor);
                cashNexus += (mEvent.getHowPaid(participant_debtor) - mAverage)*percent;
                participant_debtor.setCashNexusWith(participant_creditor, cashNexus);
                participant_creditor.setCashNexusWith(participant_debtor, -cashNexus);
            }
        }
    }


}
