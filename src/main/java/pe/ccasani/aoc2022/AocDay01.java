package pe.ccasani.aoc2022;

import static pe.ccasani.aoc2022.Util.readInput;

import hu.akarnokd.rxjava3.math.MathFlowable;
import hu.akarnokd.rxjava3.operators.FlowableTransformers;
import io.reactivex.rxjava3.core.Flowable;
import java.util.Comparator;

public class AocDay01 {

  public static void PartOne() {

    Flowable.fromIterable(readInput("day01-1.txt"))
      .compose(FlowableTransformers.bufferSplit(""::equals))
      .flatMap(calories -> Flowable.fromIterable(calories)
        .map(Integer::valueOf)
        .to(MathFlowable::sumInt))
      .to(MathFlowable::max)
      .subscribe(System.out::println)
      .dispose();
  }

  public static void PartTwo() {
    Flowable.fromIterable(readInput("day01-1.txt"))
      .compose(FlowableTransformers.bufferSplit(""::equals))
      .flatMap(calories -> Flowable.fromIterable(calories)
        .map(Integer::valueOf)
        .to(MathFlowable::sumInt))
      .sorted(Comparator.reverseOrder())
      .take(3)
      .to(MathFlowable::sumInt)
      .subscribe(System.out::println)
      .dispose();
  }
}
