import org.json.simple.JSONArray;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashMap;


public class UserActivity {

    private BufferedReader br = null;
    private FileWriter writer=null;
    private Category Category;
    private DataManager man = null;
    private Transaction transaction=null;

    public UserActivity(){
        br = new BufferedReader(new InputStreamReader(System.in));
        man = new DataManager();
    }

    public char getOption(){
        String line = null;
        try {
            line=br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        line.toUpperCase();
        if(!line.equals("")){
            return line.charAt(0);
        }
        return 'q';
    }


    public void createnewCategory() throws IOException {
        String name;
        float amt;
        System.out.println("-------"+man.isUniqueCatagory("food"));
        System.out.println("Enter the Name of the  Category: ");
        name = br.readLine();
        System.out.println("Enter the Budget that you want to allocate ");
        amt = Float.parseFloat(br.readLine());

        Category =new Category(name,amt);
        man.createCategoryinfile(Category);
        System.out.println("\n\n\n\n");
        getKey();
    }

    public void addIncome() throws IOException {
        String transaction_name;
        double amount;
        String description,categoryType;
        System.out.println("Name of the Income");
        transaction_name=br.readLine();
        System.out.println("Enter  the amount");
        amount=Double.parseDouble(br.readLine());
        System.out.println("Enter any Description or if you don't need this just press enter");
        description=br.readLine();
        System.out.print("Select from this catagory   ");
        categoryType=br.readLine();

        java.util.Date date=new java.util.Date();

        Transaction transaction =new Income(amount,description,date,transaction_name);
        man.addIncome(transaction);
        getKey();
    }


    public void addExpense() throws IOException {
        String transaction_name;
        double amount;
        String description,categoryType;
        System.out.println("Name of the Expense");
        transaction_name=br.readLine();
        System.out.println("Enter  the amount");
        amount=Double.parseDouble(br.readLine());
        System.out.println("Enter any Description or if you don't need this just press enter");
        description=br.readLine();
        System.out.print("Enter the Name of the Category");
        categoryType=br.readLine();
        Category category=new Category(categoryType);
        java.util.Date date=new java.util.Date();
        Expense expense =new Expense(amount,description,date,transaction_name,category);
        man.addExpense(expense);
        getKey();
    }

    public void listCategory() throws IOException, ClassNotFoundException {

       man.displayCategory();
        getKey();
    }

    public void deleteCategory(){
        System.out.println("Enter the Category ID that you want to delete ");
        int id=0;
        try {
             id = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        man.deleteCategory(id);
        getKey();
    }

    public void editCategory() throws IOException {
        int id;
        String name;
        double amount;

        System.out.println("Enter the Category ID that you wnat to edit ");
        id=Integer.parseInt(br.readLine());

        System.out.println("Change the Name of the Category :");
        name = br.readLine();

        System.out.println("Enter the New Budget that you want to allocate ");
        amount = Double.parseDouble(br.readLine());

        man.editCategory(name,amount,id);
        getKey();
    }

    public void ListTransaction() throws IOException {
        System.out.println("Enter 1 for Income and 2 for Expense ");
        int id=Integer.parseInt(br.readLine());

        if(id==1){
            man.displayIncome();
        }
        if(id==2){
            man.displayExpense();
        }
        System.out.println("Your Total Expense  :"+man.getTotalExpense());
        System.out.println("Your Total Income  :"+man.getTotalIncome());
        getKey();
    }

    public void deleteIncome(){
        System.out.println("Enter the Income ID that you want to delete ");
        int id=0;
        try {
            id = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        man.deleteIncome(id);
        getKey();
    }

    public void deleteExpense(){
        System.out.println("Enter the Expense ID that you want to delete ");
        int id=0;
        try {
            id = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        man.deleteExpense(id);
        getKey();
    }

    private void getKey(){
        try {
            System.out.println("\n\n\nPress any key to continue...");
            br.readLine();
        } catch (IOException e) {

        }
    }

    public void getUniqueCategoty(){
        HashSet<String> uniqueCategory=new HashSet<>();
        uniqueCategory=man.getUniqueCategory();
        System.out.println(uniqueCategory);
        getKey();
    }

    public void showInDetail(){
        System.out.println("Total Expense : "+man.getTotalExpense()+"  Total Buget for this month : "+man.getTotalBudget() );
        LinkedHashMap<String,Double> getexpensebyCatagory =man.getExpenseByCatagory();
        LinkedHashMap<String,Double> getexpensebyBudget =man.getCatagoryAmount();
        HashSet<String> uniqueCategory=man.getUniqueCategory();
        for (String s:uniqueCategory){
           System.out.println("Catagory Name : "+s+" Expense : "+getexpensebyCatagory.get(s)+" Budget Allocated : "+getexpensebyBudget.get(s));
        }
        getKey();
    }


    public void editExpense() throws IOException {
        int id;
        String name;
        double amount;

        System.out.println("Enter the Expense ID that you want to edit ");
        id=Integer.parseInt(br.readLine());

        System.out.println("Change the Name of the Transaction :");
        name = br.readLine();

        System.out.println("Enter the New Amount of that Transaction");
        amount = Double.parseDouble(br.readLine());

        System.out.println("Enter the Description");
        String Description= br.readLine();

        System.out.println("Enter the Category");
        String category=br.readLine();

        man.editExpense(name,amount,id,Description,category);
        getKey();
    }

    public void editIncome() throws IOException {
        int id;
        String name;
        double amount;

        System.out.println("Enter the Income ID that you want to edit ");
        id=Integer.parseInt(br.readLine());

        System.out.println("Change the Name of the Income :");
        name = br.readLine();

        System.out.println("Enter the New Amount of that Income");
        amount = Double.parseDouble(br.readLine());

        System.out.println("Enter the Description");
        String Description= br.readLine();

        man.editIncome(name,amount,id,Description);
        getKey();
    }

}
