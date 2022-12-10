package pe.ccasani.aoc2022;

import io.vavr.control.Try;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Util {

    public static List<String> readInput(String fileName)
    {
       return Try.of(() -> Files.readAllLines(Paths.get("src/main/resources/".concat(fileName))))
                .getOrElseThrow(throwable -> new RuntimeException(throwable.getCause()));
    }
}
