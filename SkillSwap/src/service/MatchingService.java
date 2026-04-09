package SkillSwap.src.service;

import SkillSwap.src.state.StateSkillSwap;
import SkillSwap.src.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MatchingService {
    
    StateSkillSwap state;

    public MatchingService(StateSkillSwap state) { this.state = state;}
    public Match simpleMatching(Request request) throws IllegalArgumentException
    {
        Offer offer_matched = matchWith(request);
        if (offer_matched == null) {throw new IllegalArgumentException("No matching found");}
        return new Match(request.getStudentId(), offer_matched.getStudentId());
    }

    public Offer matchWith(Request other) {
        return state.getOffers().values().stream()
                .filter(o -> o.getSkillId().equals(other.getSkillId()))
                .findFirst()
                .orElse(null);
   }
}
