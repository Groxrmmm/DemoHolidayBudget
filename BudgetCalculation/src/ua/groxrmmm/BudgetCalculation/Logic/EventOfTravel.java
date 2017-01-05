package ua.groxrmmm.BudgetCalculation.Logic;

/**
 * Class {@code EventOfTravel}  is a class that contains the data
 * single travel event such as participants of this event,
 * price of this event and and how to paid the specified participant
 *
 * @since 1.01
 */
public interface EventOfTravel {

    float getPrice();
    ParticipantOfTravel[] getParticipantsOfEvent();
    float getHowPaid(ParticipantOfTravel pot);

}
