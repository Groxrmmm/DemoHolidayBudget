package ua.groxrmmm.BudgetCalculation.Logic;

/**
 * Class {@code Travel}  is a class that contains the data
 * for the calculation of monetary relations of the participants travel.
 *
 * @since 1.01
 */
public interface Travel {
    EventOfTravel[] getEventOfTravel();
    ParticipantOfTravel[] getParticipantTravel();

}
