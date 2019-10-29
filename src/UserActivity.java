import org.json.simple.JSONArray;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

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
        return line.charAt(0);
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
        String description;
        int id;

        System.out.println("Name of the transaction");
        transaction_name=br.readLine();
        System.out.println("Enter  the amount");
        amount=Double.parseDouble(br.readLine());
        System.out.println("Enter any Description or if you don't need this just press enter");
        description=br.readLine();
        System.out.println("Enter the Category ID");
        id=Integer.parseInt(br.readLine());
        System.out.println("Enter the Type of the transaction");
        int typeid=Integer.parseInt(br.readLine());

//        transaction =new Transaction(transaction_name,amount,description,id,);

    }

    public void listCategory() throws IOException, ClassNotFoundException {

       man.displayCategory();

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
    }

    public void editCategory() throws IOException {
        int id;
        String name;
        double amount;

        System.out.println("Enter the Category ID that you wnat to delete ");
        id=Integer.parseInt(br.readLine());

        System.out.println("Change the Name of the Category :");
        name = br.readLine();

        System.out.println("Enter the New Budget that you want to allocate ");
        amount = Double.parseDouble(br.readLine());

        man.editCategory(name,amount,id);
    }

    private void getKey(){
        try {
            System.out.println("\n\n\n\n\n\n\nPress any key to continue...");
            br.readLine();
        } catch (IOException e) {

        }
    }


}
