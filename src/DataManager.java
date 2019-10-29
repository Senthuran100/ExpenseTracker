import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import java.io.FileWriter;


public class DataManager {


    public void createCategoryinfile(Category category){
        JSONParser jsonParser = new JSONParser();
        JSONArray categoryList = new JSONArray();
        int id;

        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/employees.json"))
        {
            Object obj = jsonParser.parse(reader);
            categoryList = (JSONArray) obj;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        JSONObject categoryDetails = new JSONObject();
        categoryDetails.put("Id",categoryList.size());
        categoryDetails.put("Name",category.getName());
        categoryDetails.put("Amount",category.getAmount());
        categoryList.add(categoryDetails);
        try (FileWriter file = new FileWriter("/Users/senthuran/Downloads/BudgetApp/employees.json")) {

            file.write(categoryList.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayCategory(){
        JSONParser jsonParser = new JSONParser();
        JSONArray Categorylist=new JSONArray();

        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/employees.json"))
        {

            Object obj = jsonParser.parse(reader);
            Categorylist = (JSONArray) obj;
            for(int i = 0; i < Categorylist.size(); i++)
            {
               JSONObject objects = (JSONObject) Categorylist.get(i);
               System.out.println("Category ID :"+objects.get("Id")+"Category Name  :"+objects.get("Name")+"    Amount :"+objects.get("Amount"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void deleteCategory(int id){
        JSONParser jsonParser = new JSONParser();
        JSONArray Categorylist= new JSONArray();

        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/employees.json"))
        {
            Object obj = jsonParser.parse(reader);
            Categorylist = (JSONArray) obj;
            for(int i = 0; i < Categorylist.size(); i++)
            {
              JSONObject objects=(JSONObject) Categorylist.get(i);
              if((long)objects.get("Id")==id){
                  Categorylist.remove(i);
              }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try (FileWriter file = new FileWriter("/Users/senthuran/Downloads/BudgetApp/employees.json")) {
            file.write(Categorylist.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        displayCategory();
    }

    public void editCategory(String Name,double amount,int id){
        JSONParser jsonParser = new JSONParser();
        JSONArray Categorylist= new JSONArray();

        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/employees.json"))
        {
            Object obj = jsonParser.parse(reader);
            Categorylist = (JSONArray) obj;
            JSONObject objects=null;
            for(int i = 0; i < Categorylist.size(); i++)
            {
                 objects=(JSONObject) Categorylist.get(i);
                if((long)objects.get("Id")==id){
                    objects.put("Name",Name);
                    objects.put("Amount",amount);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try (FileWriter file = new FileWriter("/Users/senthuran/Downloads/BudgetApp/employees.json")) {
            file.write(Categorylist.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        displayCategory();
    }

    public void addTransaction(Transaction transaction){
        JSONParser jsonParser = new JSONParser();
        JSONArray transactionList = new JSONArray();
        int id;
        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/transaction.json"))
        {
            if (reader.read()!=-1) {
                Object obj = jsonParser.parse(reader);
                transactionList = (JSONArray) obj;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        JSONObject transactionDetails = new JSONObject();
        transactionDetails.put("transactionId",transactionList.size());
        transactionDetails.put("Name",transaction.getName());
        transactionDetails.put("Amount",transaction.getAmount());
        transactionDetails.put("Description",transaction.getDescription());
        transactionDetails.put("Category",transaction.getCategory());
        transactionDetails.put("Type",transaction.getType());
        transactionDetails.put("Date",transaction.getDate().toString());
        transactionList.add(transactionDetails);
        try (FileWriter file = new FileWriter("/Users/senthuran/Downloads/BudgetApp/transaction.json")) {

            file.write(transactionList.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayExpense(){
        JSONParser jsonParser = new JSONParser();
        JSONArray transactionList=new JSONArray();
        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/transaction.json"))
        {
//            if (reader.read()!=-1) {
                Object obj = jsonParser.parse(reader);
                transactionList = (JSONArray) obj;
                for (int i = 0; i < transactionList.size(); i++) {
                    JSONObject objects = (JSONObject) transactionList.get(i);
                    if ((long)objects.get("Type") == 2) {
                        System.out.println("Transaction ID :" + objects.get("transactionId") + "  Transaction Name  :" + objects.get("Name") + "  Amount :" + objects.get("Amount")+"  Description :"+objects.get("Description")+"   Category:"+objects.get("Category"));
                    }
                }
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void displayIncome(){
        JSONParser jsonParser = new JSONParser();
        JSONArray transactionList=new JSONArray();
        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/transaction.json"))
        {
                Object obj = jsonParser.parse(reader);
                transactionList = (JSONArray) obj;
                for (int i = 0; i < transactionList.size(); i++) {
                    JSONObject objects = (JSONObject) transactionList.get(i);
                    if ((long)objects.get("Type") == 1) {
                        System.out.println("Transaction ID :" + objects.get("transactionId") + "Transaction Name  :" + objects.get("Name") + "  Amount :" + objects.get("Amount")+"  Description :"+objects.get("Description")+"   Category:"+objects.get("Category"));
                    }
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
