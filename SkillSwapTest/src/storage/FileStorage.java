package SkillSwap.src.storage;

import SkillSwap.src.service.ConsoleReportPrinter;
import SkillSwap.src.service.Exchange;
import SkillSwap.src.service.Review;
import SkillSwap.src.state.StateSkillSwap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class FileStorage implements Storage{
    
    @Override
    public StateSkillSwap loadState(StateSkillSwap e, ConsoleReportPrinter c) throws IllegalArgumentException {
        Path pathE = Paths.get("SkillSwap","storage","Exchange.csv");
        if (!Files.exists(pathE)) {
            throw new IllegalArgumentException("Exchange CSV file not found: " + pathE);
        }
        Path pathR = Paths.get("SkillSwap","storage","Review.csv");
        if (!Files.exists(pathR)) {
            throw new IllegalArgumentException("Review CSV file not found: " + pathR);
        }

        try {
            List<String> lines = Files.readAllLines(pathE);

            for (String line : lines) {
                if (line.isEmpty()){
                    continue;
                }
                Exchange exchange = new Exchange(line, e);
                e.addExchange(exchange.getID(), exchange);
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException("Failed to read Exchange CSV: " + ex.getMessage(), ex);
        }

        try {
            List<String> lines = Files.readAllLines(pathR);

            for (String line : lines) {
                if (line.isEmpty()){
                    continue;
                }
                Review review = new Review(line);
                e.addReview(review.getReviewID(), review);
            }
        } catch (IOException ex) {
            throw new IllegalArgumentException("Failed to read Review CSV: " + ex.getMessage(), ex);
        }

        for (Map.Entry<Integer, Exchange> entry : e.getExchange().entrySet()) {
            int id = entry.getKey();
            Exchange exchange = entry.getValue();
            Review review = e.getReviewById(String.valueOf(id));
            if (review != null) {
                c.addMatch(exchange, review);
            }
        }

        return e;
    }

    @Override
    public void saveState(StateSkillSwap skillSwapState) throws IOException{
        //carica gli exchange su csv (overwrite) (invece di studenti usa i loro id)
        Path pathE = Paths.get("SkillSwap","storage","Exchange.csv");
        Files.createDirectories(pathE.getParent());
        Path pathR = Paths.get("SkillSwap","storage","Review.csv");
        Files.createDirectories(pathR.getParent());
        List<String> lines = skillSwapState.getExchange().values()
        .stream()
        .map(Exchange:: parseToCsv)
        .collect(Collectors.toList());

        List<String> linesR = skillSwapState.getReview().values()
        .stream()
        .map(Review:: parseToCsv)
        .collect(Collectors.toList());
        Files.write(pathR, linesR);
        Files.write(pathE, lines);
        
    }
}