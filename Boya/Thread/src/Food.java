import java.sql.Time;

public class Food {
    protected String name;
    protected int price;
    protected int costTime;

    public Food(String name, int price, int costTime) {
        this.name = name;
        this.price = price;
        this.costTime = costTime;
    }
}
