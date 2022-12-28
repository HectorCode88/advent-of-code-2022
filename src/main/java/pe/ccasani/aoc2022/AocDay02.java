package pe.ccasani.aoc2022;

import static pe.ccasani.aoc2022.Util.readInput;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import java.util.Arrays;
import java.util.Map;

public class AocDay02 {

  public static void partOne() {

    int WIN = 6, DRAW = 3, LOST = 0;
    var opponentScore = Map.of("A", "1", "B", "2", "C", "3");
    var ownScore = Map.of("X", "1", "Y", "2", "Z", "3");
    var resultScore = Map.of("11", (1 + DRAW), "12", (2 + WIN), "13", (3 + LOST),
      "21", (1 + LOST), "22", (2 + DRAW), "23", (3 + WIN),
      "31", (1 + WIN), "32", (2 + LOST), "33", (3 + DRAW));

    Flowable.fromIterable(readInput("day02.txt"))
      .map(line -> line.split(" "))
      .map(Arrays::asList)
      .flatMapMaybe(list -> Maybe.zip(
        Maybe.just(opponentScore.get(list.get(0))),
        Maybe.just(ownScore.get(list.get(1))),
        (a, b) -> resultScore.get(a.concat(b))))
      .reduce(Integer::sum)
      .subscribe(System.out::println)
      .dispose();
  }

  public static void partTwo() {

    int WIN = 6, DRAW = 3, LOST = 0;
    var opponentScore = Map.of("A", "1", "B", "2", "C", "3");
    var ownScore = Map.of("X", "1", "Y", "2", "Z", "3");
    var resultScore = Map.of("11", (3 + LOST), "12", (1 + DRAW), "13", (2 + WIN),
      "21", (1 + LOST), "22", (2 + DRAW), "23", (3 + WIN),
      "31", (2 + LOST), "32", (3 + DRAW), "33", (1 + WIN));

    Flowable.fromIterable(readInput("day02.txt"))
      .map(line -> line.split(" "))
      .map(Arrays::asList)
      .flatMapMaybe(list -> Maybe.zip(
        Maybe.just(opponentScore.get(list.get(0))),
        Maybe.just(ownScore.get(list.get(1))),
        (a, b) -> resultScore.get(a.concat(b))))
      .reduce(Integer::sum)
      .subscribe(System.out::println)
      .dispose();
  }
}
