import java.util.Random;

public class RandomA {
    private int desde;
    private int hasta;
    Random r = new Random();

    public RandomA(int desde, int hasta) {
        this.desde = desde;
        this.hasta = (hasta-desde)+1;
        
    }

    public int getDesde() {
        return desde;
    }

    public void setDesde(int desde) {
        this.desde = desde;
    }

    public int getHasta() {
        return hasta;
    }

    public void setHasta(int hasta) {
        this.hasta = hasta;
    }

    public int getRandom() {
        int random = 0;
        random = r.nextInt(hasta) + desde;
        return random;
    }

    
}
