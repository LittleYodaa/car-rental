package pl.patrykkawula.carrental.util;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class DiscountCalculatorUtil {

  private DiscountCalculatorUtil() {
    throw new IllegalStateException("Can't be initialized");
  }

  /**
   * Calculates discount multiplayer for requested days number.
   * Value is calculated from Map<Integer, Double> where key is number of days and value is discount multiplayer
   */
  public static double getDiscountMultiplier(int numberOfDays) {
    // ta mape dobrze by bylo wydzielic wydzielic do konfiguracji. czyli w apllication.yml
    // wtedy jak się zmienia wartosci wystarczy zmienic konfiguracje a nie kod
    Map<Integer, Double> discountValues = new TreeMap<>();
    discountValues.put(3, .9);
    discountValues.put(5, .85);
    discountValues.put(7, .80);
    discountValues.put(10, .70);

    // TODO tu chyba nie bedzie dzialac ze jak ktos poda powyzej 10 dni to powinien dostac 30% znizki. tylko da mu 0%
    return discountValues.entrySet().stream()
        .filter(entry -> entry.getKey() <= numberOfDays)
        .map(Entry::getValue)
        .min(Double::compareTo)
        .orElse(1d);
  }
}
