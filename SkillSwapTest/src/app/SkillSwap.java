package SkillSwap.src.app;

import SkillSwap.src.service.*;
import SkillSwap.src.state.*;
import SkillSwap.src.storage.*;
import java.io.IOException;
import java.util.Scanner;

public class SkillSwap {

    public static void main(String[] args) {
        StateSkillSwap state;
        try{
            state= new StateSkillSwap();
        } catch (IllegalArgumentException e){
            System.err.println("Problem during State Creation");
            return;
        }
        Scanner scanf = new Scanner(System.in);
        FileStorage store = new FileStorage();
        ConsoleReportPrinter crp = new ConsoleReportPrinter(state);
        MatchingService Mservices = new MatchingService(state);
        while (true)
        {
            if (!crp.getMatchesCreatedMap().isEmpty()) { System.out.println("Skill Swap \n\n 1 - show state\n 2 - match\n 3 - Check created matches\n 4 - Search Student (by student ID)\n 5 - print Leaderboards\n 6 - leave\n s - save Exchange and Reviews\n l - load Exchange and Reviews"); } else { System.out.println("Skill Swap \n\n 1 - show state\n 2 - match\n 3 - Search Student (by student ID)\n 4 - print Leaderboards\n 5 - Leave\n s - save Exchange and Reviews\n l - load Exchange and Reviews");}

            switch (scanf.nextLine()) {

                case "1":
                    System.out.println(state.toString() + "\n\n");
                    break;

                case "2":
                    while (true)
                    {
                        System.out.println("Insert request id\n");
                        String input = scanf.nextLine();   
                        System.out.println("1- Simple\n2- Swap (same subject)\n");   
                        switch (scanf.nextLine()) {
                            case "1":
                                try {
                                    Exchange exchange = Mservices.simpleMatching(state.getRequest().get(input));
                                    Review review = ReviewService.addReview(exchange);
                                    System.out.println("\n" + exchange.toString() + "\n" + review.toString());
                                    crp.addMatch(exchange, review.getReviewID());
                                } catch (IllegalArgumentException e)
                                {
                                    System.out.println("Match not found...\n");
                                    break;
                                }
                                break;
                            case "2":
                                try {
                                    Exchange exchange = Mservices.swapMatching(state.getRequest().get(input));
                                    Review review = ReviewService.addReview(exchange);
                                    System.out.println("\n" + exchange.toString() + "\n" + review.toString());
                                    crp.addMatch(exchange, review.getReviewID());
                                } catch (IllegalArgumentException e)
                                {
                                    System.out.println("Match not found...\n");
                                    break;
                                }
                                break;

                        }
                        break;
                    }
                    break;
                case "3":
                    if (crp.getMatchesCreatedMap().isEmpty())
                    {
                        System.out.println("Insert student Id");
                        String input = scanf.nextLine();
                        System.out.println(crp.printStudentProfile(input));
                        break;
                    }
                    else
                    {
                        System.out.println(crp.getMatchesCreatedMap().toString());
                        break;
                    }
                case "4":
                    if (crp.getMatchesCreatedMap().isEmpty())
                    {
                        System.out.println(crp.printLeaderboard());
                        break;
                    }
                    else
                    { System.out.println("Insert student Id");
                        String input = scanf.nextLine();
                        System.out.println(crp.printStudentProfile(input));
                        break;
                    }
                case "5":
                    if (crp.getMatchesCreatedMap().isEmpty())
                    {
                        return;
                    }
                    else
                    { 
                        System.out.println(crp.printLeaderboard());
                        break;
                    }
                case "6":
                    if (crp.getMatchesCreatedMap().isEmpty())
                        break;
                    else return;
                case "s":
                    try {
                        store.saveState(state);
                    } catch (IOException e) {
                        System.err.println("Problem during file writing " + e.getMessage());
                        return;
                    }
                    break;
                case "l":
                    try {
                        store.loadState(state, crp);
                        int maxId = state.getExchange().keySet().stream()
                            .mapToInt(Integer::intValue)
                            .max()
                            .orElse(0);
                        crp.setCounter(maxId);
                    } catch (IllegalArgumentException e) {
                        System.err.println("Problem during file reading " + e.getMessage());
                        break;
                    }
                    break;
            }
            System.out.println("\n\n\n\n\n\n");
        }

    }
}
