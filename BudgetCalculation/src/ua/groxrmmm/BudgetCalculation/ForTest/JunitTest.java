package ua.groxrmmm.BudgetCalculation.ForTest;

import ua.groxrmmm.BudgetCalculation.Logic.BudgetCalculation;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;


public class JunitTest extends Assert {
    private ArrayList<PersonDTO> mPeople = new ArrayList<>(4);
    private GrandTour mGrandTour = new GrandTour();
    private Map<Integer, Float> mWhoHowPaid = new HashMap<>();
    private Map<Integer, Float> mWhoHowPaid2 = new HashMap<>();
    private Map<Integer, Float> mWhoHowPaid3 = new HashMap<>();
    Event mEvents[] = new Event[3];

    @Before
    public void before()
    {
        createPeople();
        createEvent1();
        createEvent2();
        createEvent3();
    }
    public void createPeople()
    {
        for(int i = 0; i < 4; i++)
        {
            PersonDTO person = new PersonDTO(i+1);
            mPeople.add(person);
            mWhoHowPaid.put(person.getId(), (float) (40*i));
        }
        mGrandTour.addParticipants(mPeople);
        mGrandTour.start();
    }
    public void createEvent1()
    {
        mEvents[0] = new Event(1, mPeople);
    }
    public void createEvent2()
    {
        ArrayList<PersonDTO> participantsTwo = new ArrayList<>(3);
        participantsTwo.add(mPeople.get(0));
        participantsTwo.add(mPeople.get(1));
        participantsTwo.add(mPeople.get(2));
        mWhoHowPaid2.put(mPeople.get(0).getId(),50F);
        mWhoHowPaid2.put(mPeople.get(1).getId(),10F);
        mWhoHowPaid2.put(mPeople.get(2).getId(),0F);
        mEvents[1] = new Event(2, participantsTwo);
    }
    public void createEvent3()
    {
        ArrayList<PersonDTO> participantsThree = new ArrayList<>(3);
        participantsThree.add(mPeople.get(3));
        participantsThree.add(mPeople.get(1));
        participantsThree.add(mPeople.get(2));
        mWhoHowPaid3.put(mPeople.get(3).getId(),0F);
        mWhoHowPaid3.put(mPeople.get(1).getId(),20F);
        mWhoHowPaid3.put(mPeople.get(2).getId(),100F);
        mEvents[2] = new Event(3, participantsThree);
    }

    @Test
    public void TEST()
    {
        mGrandTour.addEvent(mEvents[0]);
        mGrandTour.addEvent(mEvents[1]);
        mGrandTour.addEvent(mEvents[2]);

        mGrandTour.endEvent(1, mWhoHowPaid);
        mGrandTour.endEvent(2, mWhoHowPaid2);
        mGrandTour.endEvent(3, mWhoHowPaid3);

        new BudgetCalculation(mGrandTour).start();
        new PrintCashNexus(mGrandTour);

    }

}
