package ua.groxrmmm.BudgetCalculation.ForTest;

import ua.groxrmmm.BudgetCalculation.Logic.Travel;

import java.util.ArrayList;
import java.util.Map;


public class GrandTour implements Travel {

    private ArrayList<PersonDTO> participantsOfGrandTour = new ArrayList<>();
    private ArrayList<Event> eventsOfGrandTour = new ArrayList<>();
    private ArrayList<Event> eventsOfGrandTourEnd = new ArrayList<>();

    public void addParticipants(ArrayList<PersonDTO> participantsOfGrandTour)
    {
        this.participantsOfGrandTour = participantsOfGrandTour;
    }
    public void addParticipant(PersonDTO personDTO)
    {
        participantsOfGrandTour.add(personDTO);
    }
    public void addEvent(Event event)
    {
        eventsOfGrandTour.add(event);
    }
    public void endEvent(int id, Map<Integer, Float> whoHowPaid) throws IllegalArgumentException
    {
        boolean isException = true;
        for (int i = 0; i < eventsOfGrandTour.size() && isException; i++ ) {
            if(eventsOfGrandTour.get(i).getId() == id)
            {
                eventsOfGrandTour.get(i).end(whoHowPaid);
                eventsOfGrandTourEnd.add(eventsOfGrandTour.get(i));
                isException = false;
            }
        }
        if(isException)
            throw new IllegalArgumentException("События " + id + " нет в этом путишествии!");
    }
    public void start()
    {
        setCashNexusOfParticipants();
    }
    @Override
    public Event[] getEventOfTravel() {
        Event events[] = new Event[eventsOfGrandTourEnd.size()];
        return eventsOfGrandTourEnd.toArray(events);
    }
    @Override
    public PersonDTO[] getParticipantTravel() {
        PersonDTO people [] = new PersonDTO[participantsOfGrandTour.size()];
        return participantsOfGrandTour.toArray(people);
    }
    private void setCashNexusOfParticipants()
    {
        for(PersonDTO i : participantsOfGrandTour)
        {
            ArrayList<PersonDTO> arrayP = new ArrayList<>(participantsOfGrandTour.size()-1);
            for(PersonDTO j : participantsOfGrandTour)
            {
                if(!i.equals(j))
                    arrayP.add(j);
            }
            i.setCashNexus(arrayP);
        }
    }
}
