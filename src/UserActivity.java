import org.json.simple.JSONArray;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


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

        System.out.println("Enter the Name of the  Category: ");
        name = br.readLine();
        System.out.println("Enter the Budget that you want to allocate ");
        amt = Float.parseFloat(br.readLine());

        Category =new Category(name,amt);
        man.createCategoryinfile(Category);
        System.out.println("\n\n\n\n");
        getKey();
    }

    public void addTransaction() throws IOException {
        String transaction_name;
        double amount;
        String description,categoryType;
        int typeid;


        System.out.println("Name of the transaction");
        transaction_name=br.readLine();
        System.out.println("Enter  the amount");
        amount=Double.parseDouble(br.readLine());
        System.out.println("Enter any Description or if you don't need this just press enter");
        description=br.readLine();
        System.out.print("Enter the Name of the Category");
        System.out.print("Select from this catagort   ");
        getUniqueCategoty();
        categoryType=br.readLine();
        System.out.println("Enter the Type of the transaction (1 for Incomr 2 for Expense)");
        typeid=Integer.parseInt(br.readLine());
        java.util.Date date=new java.util.Date();

        Transaction transaction =new Transaction(amount,description,typeid,categoryType,date,transaction_name);
        man.addTransaction(transaction);
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

    public void deleteTransaction(){
        System.out.println("Enter the Transaction ID that you want to delete ");
        int id=0;
        try {
            id = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        man.deleteTransaction(id);
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


    public void editTransaction() throws IOException {
        int id;
        String name;
        double amount;

        System.out.println("Enter the Transaction ID that you want to edit ");
        id=Integer.parseInt(br.readLine());

        System.out.println("Change the Name of the Transaction :");
        name = br.readLine();

        System.out.println("Enter the New Amount of that Transaction");
        amount = Double.parseDouble(br.readLine());

        System.out.println("Enter the Description");
        String Description= br.readLine();

        System.out.println("Enter the Category");
        String category=br.readLine();


        man.editTransaction(name,amount,id,Description,category);

        man.editCategory(name,amount,id);
        getKey();
    }




}
