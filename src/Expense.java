import java.util.Date;

public class Expense extends Transaction{

    Category category;

    Expense(double Amount, String Description, Date date, String name,Category category) {
        super(Amount, Description, date, name);
        this.category=category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
