package exercise.jediGalaxy;

public class Galaxy {
  private int[][] stars;

  public Galaxy(int row, int col) {
    this.stars = new int[row][col];
    this.fillGalaxy();
  }

  public int getRows() {
    return this.stars.length;
  }

  public int getCols(int rows) {
    return this.stars[rows].length;
  }

  private void fillGalaxy() {
    int starValue = 0;

    for (int row = 0; row < this.stars.length; row++) {
      for (int col = 0; col < this.stars[row].length; col++) {
        this.stars[row][col] = starValue++;
      }
    }
  }

  public void setStar(int row, int col, int destroyedStarValue) {
    if (isInRange(row, col)) {
      this.stars[row][col] = destroyedStarValue;
    }
  }

  private boolean isInRange(int row, int col) {
    return row >= 0 && row < this.stars.length &&
            col >= 0 && col < this.stars[row].length;
  }

  public long getStarValue(int row, int col) {
    long result = 0;

    if (isInRange(row, col)) {
      result = this.stars[row][col];
    }
    return result;
  }
}
