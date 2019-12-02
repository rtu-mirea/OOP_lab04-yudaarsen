//Parlay.java
import java.io.Serializable;

public class Parlay implements Serializable {
    private static final long serialVersionUID = 1L;
    private String horse;
    private int sum;

    public Parlay(String horse, int sum) throws IllegalArgumentException
    {
        if(horse.length() == 0 || sum <= 0) throw new IllegalArgumentException("Неверные параметры ставки");
        this.horse = horse;
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public String getHorse() {
        return horse;
    }
}