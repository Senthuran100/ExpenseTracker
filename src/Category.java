

import java.io.Serializable;

public class Category implements Serializable{
    private int id;
    private String Name;

    public int getId() {
        return id;
    }

    public Category(String name) {
        Name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    private float Amount;

    public Category(String Name,float Amount) {
        this.Name=Name;
        this.Amount=Amount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float amount) {
        Amount = amount;
    }
}
