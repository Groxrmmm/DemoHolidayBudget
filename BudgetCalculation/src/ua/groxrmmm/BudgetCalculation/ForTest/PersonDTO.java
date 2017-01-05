package ua.groxrmmm.BudgetCalculation.ForTest;

import ua.groxrmmm.BudgetCalculation.Logic.ParticipantOfTravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PersonDTO implements ParticipantOfTravel {

    private final int ID;
    private Map<Integer, Float> cashNexus = new HashMap<>();

    public PersonDTO(int id) {
        ID = id;
    }
    public void setCashNexus(ArrayList<PersonDTO> participantsOfEvent) {
        for(int i = 0; i < participantsOfEvent.size(); i ++)
        {
            cashNexus.put(participantsOfEvent.get(i).getId(),(float) 0);
        }
    }
    @Override
    public int getId() {
        return ID;
    }
    @Override
    public void setCashNexusWith(ParticipantOfTravel participantOfEvent, float cash) {
        cashNexus.put(participantOfEvent.getId(),cash);
    }
    @Override
    public float getCashNexusWith(ParticipantOfTravel participantOfEvent) {
        return cashNexus.get(participantOfEvent.getId());
    }
    @Override
    public boolean equals(Object o) {
        if(o == null)
        {
            return false;
        }
        if (o == this)
        {
            return true;
        }
        if (getClass() != o.getClass())
        {
            return false;
        }
        PersonDTO e = (PersonDTO) o;
        return (this.getId() == e.getId());
    }
    @Override
    public int hashCode()
    {
        return 3*ID;
    }
}
