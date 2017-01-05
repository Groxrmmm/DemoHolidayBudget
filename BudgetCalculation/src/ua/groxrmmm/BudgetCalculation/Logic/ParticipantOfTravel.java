package ua.groxrmmm.BudgetCalculation.Logic;

/**
 * Class {@code ParticipantOfTravel}  is a class that contains the data
 * single travel participant such as ID,
 * which in this participant monetary relations with a
 * specified participant and allows to set monetary relations of the participants with a specified participant.
 *
 * @since 1.01
 */
public interface ParticipantOfTravel {
    int getId();
    void setCashNexusWith(ParticipantOfTravel participantOfEvent, float cash);
    float getCashNexusWith(ParticipantOfTravel participantOfEvent);

}
