public class Main {
  public static void main(String[] args) {
    RandomA r = new RandomA(-999, 29312);
    for (int i = 0; i < 9999999; i++) {
      int random;
      random = r.getRandom();
      if (random == -1000) {
        System.out.println(random);
        i = 9999998;
      }
    }
    
  }
}
