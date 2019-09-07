package exercise.jediGalaxy;

public class StarsManipulator {
  public static final int DESTROYED_STAR = 0;
  private Galaxy galaxy;

  public StarsManipulator(Galaxy galaxy) {
    this.galaxy = galaxy;
  }

  public void destroyStars(int[] sithPosition) {
    int sithRow = sithPosition[0];
    int sithCol = sithPosition[1];

    while (sithRow >= 0 && sithCol >= 0) {

      if (isInRange(sithRow, sithCol)) {
        this.galaxy.setStar(sithRow, sithCol, DESTROYED_STAR);
      }

      sithRow--;
      sithCol--;
    }
  }


  private boolean isInRange(int sithRow, int sithCol) {
    return sithRow >= 0 && sithRow < this.galaxy.getRows() &&
            sithCol >= 0 && sithCol < this.galaxy.getCols(sithRow);
  }

  public int sumOfStars(int[] jediPosition) {
    int jediRow = jediPosition[0];
    int jediCol = jediPosition[1];
    int sum = 0;


    while (jediRow >= 0 && jediCol < this.galaxy.getCols(0)) {

      if (isInRange(jediRow, jediCol)) {
        sum += this.galaxy.getStarValue(jediRow, jediCol);
      }

      jediRow--;
      jediCol++;
    }

    return sum;
  }
}