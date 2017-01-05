package ua.groxrmmm.BudgetCalculation.ForTest;

import ua.groxrmmm.BudgetCalculation.Logic.EventOfTravel;
import ua.groxrmmm.BudgetCalculation.Logic.ParticipantOfTravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Event implements EventOfTravel {
    private final int ID;
    private float mPrice;
    private ArrayList<PersonDTO>  mParticipantsOfEvent = new ArrayList<>();
    private Map<Integer, Float> mWhoHowPaid = new HashMap<>();

    public Event(int id, ArrayList<PersonDTO> participantsOfEvent)
    {
        ID = id;
        this.mParticipantsOfEvent = participantsOfEvent;
    }
    public void end(Map<Integer, Float> whoHowPaid)
    {
        this.mWhoHowPaid = whoHowPaid;
        findPrice();
    }
    @Override
    public float getPrice() {
        return mPrice;
    }
    @Override
    public PersonDTO[] getParticipantsOfEvent() {
        PersonDTO people [] = new PersonDTO[mParticipantsOfEvent.size()];
        mParticipantsOfEvent.toArray(people);
        return  people;
    }
    @Override
    public float getHowPaid(ParticipantOfTravel pot) {
        return mWhoHowPaid.get(pot.getId());
    }
    public int getId() {
        return ID;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
        {
            return false;
        }
        if (obj == this)
        {
            return true;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Event e = (Event) obj;
        return (this.getId() == e.getId());
    }
    @Override
    public int hashCode() {
        return 2017*ID;
    }
    private void findPrice()
    {
        for(PersonDTO p : mParticipantsOfEvent)
        {
            mPrice += mWhoHowPaid.get(p.getId());
        }
    }
}
