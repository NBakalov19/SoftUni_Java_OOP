package exercise.greedyTimes;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Bag {
  private long capacity;
  private long currentWeight;
  private long gold;
  private Map<String, Long> gems;
  private long totalGems;
  private Map<String, Long> cash;
  private long totalCash;
  private boolean isGoldAdded;

  public Bag(long capacity) {
    this.capacity = capacity;
    this.currentWeight = 0;
    this.gold = 0;
    this.gems = new HashMap<>();
    this.totalGems = 0;
    this.cash = new HashMap<>();
    this.totalCash = 0;
    this.isGoldAdded = false;
  }

  private boolean hasMoreGems(long quantity) {
    return this.totalGems >= this.totalCash + quantity;
  }

  private boolean hasFreeCapacity(long quantity) {
    return this.currentWeight + quantity <= this.capacity;
  }

  private boolean hasMoreGold(long quantity) {
    return this.gold >= this.totalGems + quantity;
  }

  private Comparator<Map.Entry<String, Long>> getEntryComparator() {
    return (f, s) -> {
      int result = s.getKey().compareTo(f.getKey());
      if (result == 0) {
        result = f.getValue().compareTo(s.getValue());
      }
      return result;
    };
  }

  public void addCash(String item, long quantity) {
    if (hasFreeCapacity(quantity) && hasMoreGems(quantity)) {
      if (!this.cash.containsKey(item)) {
        this.cash.put(item, quantity);
      } else {
        this.cash.put(item, this.cash.get(item) + quantity);
      }
      this.totalCash += quantity;
      this.currentWeight += quantity;
    }
  }

  public void addGem(String item, long quantity) {
    if (this.hasFreeCapacity(quantity) && hasMoreGold(quantity)) {
      if (!this.gems.containsKey(item)) {
        this.gems.put(item, quantity);
      } else {
        this.gems.put(item, this.gems.get(item) + quantity);
      }
      this.totalGems += quantity;
      this.currentWeight += quantity;
    }
  }

  public void addGold(long quantity) {
    if (hasFreeCapacity(quantity)) {
      this.isGoldAdded = true;
      this.gold += quantity;
      this.currentWeight += quantity;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (this.isGoldAdded) {
      sb.append("<Gold> $").append(this.gold).append(System.lineSeparator());
      sb.append("##Gold - ").append(this.gold).append(System.lineSeparator());
    }

    if (this.gems.size() > 0) {
      sb.append("<Gem> $").append(this.totalGems).append(System.lineSeparator());

      this.gems.entrySet()
              .stream()
              .sorted(getEntryComparator()).forEach(e ->
              sb.append("##").append(e.getKey())
                      .append(" - ").append(e.getValue()).append(System.lineSeparator()));
    }

    if (this.cash.size() > 0) {
      sb.append("<Cash> $").append(this.totalCash).append(System.lineSeparator());

      this.cash.entrySet()
              .stream()
              .sorted(getEntryComparator()).forEach(e ->
              sb.append("##").append(e.getKey())
                      .append(" - ").append(e.getValue()).append(System.lineSeparator()));
    }

    return sb.toString();
  }
}