package SkillSwap.src.service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class CsvReader{
    private CsvReader(){}

    public static List<String> readCsv(String nomeFile) throws IOException {
        Path path = Path.of(nomeFile);
        List<String> lines = Files.readAllLines(path);
        return lines.stream()
                    .skip(1)
                    .toList();
    }
}