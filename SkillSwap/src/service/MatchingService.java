package SkillSwap.src.service;

import SkillSwap.src.state.StateSkillSwap;

import SkillSwap.src.domain.*;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MatchingService {

    StateSkillSwap state;

    public MatchingService(StateSkillSwap state) {
        this.state = state;
    }

    public Match simpleMatching(Request request) throws IllegalArgumentException

    {
        if (request == null) { throw new IllegalArgumentException();}
        Offer offer_matched = matchWith(request);

        if (offer_matched == null) {
            throw new IllegalArgumentException("No matching found");
        }
        System.out.println("Offer matched: " + offer_matched.toString() + "\nRequest requested: " + request.toString());
        return new Match(request.getStudentId(), offer_matched.getStudentId());

    }

    public Match swapMatching(Request request) throws IllegalArgumentException

    {
        if (request == null) { throw new IllegalArgumentException();}
        Offer offer_matched = matchSwapWith(request);
        if (offer_matched == null) {
            throw new IllegalArgumentException("No matching found");
        }
        return new Match(request.getStudentId(), offer_matched.getStudentId());

    }
    public Offer matchWith(Request other) throws IllegalArgumentException {
        List<Offer> refused = new ArrayList<>();

        while (true)
        {
            Offer offer_found = state.getOffers().values().stream()

                    .filter(o -> o.getSkillId().equals(other.getSkillId()) && (!refused.contains(o)))

                    .findFirst()

                    .orElse(null);
            if (offer_found == null) {throw new IllegalArgumentException();}
            System.out.println("Offer matched: " + offer_found.toString() + "\nRequest requested: " + other.toString());
            System.out.println("Accept?\n1- Yes\n2- No");
            boolean result = choose();
            if (result != true)
            {
                refused.add(offer_found);
            }
            else
            {
                return offer_found;
            }
        }

    }

    public Offer matchSwapWith(Request other) throws IllegalArgumentException {
        List<Offer> refused = new ArrayList<>();

        while (true)
        {
            Offer offer_found = state.getOffers().values().stream()

                    .filter(o -> o.getSkillId().equals(other.getSkillId()) && (!refused.contains(o)) && o.getSubject().equals(other.getSubject()))

                    .findFirst()

                    .orElse(null);
            if (offer_found == null) {throw new IllegalArgumentException();}
            System.out.println("Offer matched: " + offer_found.toString() + "\nRequest requested: " + other.toString());
            System.out.println("Accept?\n1- Yes\n2- No");
            boolean result = choose();
            if (result != true)
            {
                refused.add(offer_found);
            }
            else
            {
                return offer_found;
            }
        }

    }
    public Boolean choose()
    {
        while(true)
        {
            Scanner scanf = new Scanner(System.in);
            switch (scanf.nextLine()) 
            {

                case "1":
                    return true;

                case "2":
                    return false;
                default:
                    break;

            }
        }
    }

}