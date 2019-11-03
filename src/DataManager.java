import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;


public class DataManager {


    public void createCategoryinfile(Category category){
        JSONParser jsonParser = new JSONParser();
        JSONArray categoryList = new JSONArray();
        int maxid=-1;

        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/catagory1.json"))
        {
                Object obj = jsonParser.parse(reader);
                categoryList = (JSONArray) obj;

                if (!categoryList.isEmpty()) {
                    for (int i = 0; i < categoryList.size(); i++) {
                        JSONObject temp = (JSONObject) categoryList.get(i);
                        if (Long.valueOf((Long) temp.get("Id")).intValue() > maxid) {
                            maxid = Long.valueOf((Long) temp.get("Id")).intValue();
                        }
                    }
                }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        JSONObject categoryDetails = new JSONObject();
        categoryDetails.put("Id",maxid+1);
        categoryDetails.put("Name",category.getName());
        categoryDetails.put("Amount",category.getAmount());
        categoryList.add(categoryDetails);
        try (FileWriter file = new FileWriter("/Users/senthuran/Downloads/BudgetApp/catagory1.json")) {

            file.write(categoryList.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayCategory(){
        JSONParser jsonParser = new JSONParser();
        JSONArray Categorylist=new JSONArray();

        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/catagory1.json"))
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

        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/catagory1.json"))
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
        try (FileWriter file = new FileWriter("/Users/senthuran/Downloads/BudgetApp/catagory1.json")) {
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

        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/catagory1.json"))
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
        try (FileWriter file = new FileWriter("/Users/senthuran/Downloads/BudgetApp/catagory1.json")) {
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
        int maxid = -1;
        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/transaction.json"))
        {
                Object obj = jsonParser.parse(reader);
                transactionList = (JSONArray) obj;
            for (int i=0;i<transactionList.size();i++){
                JSONObject temp= (JSONObject) transactionList.get(i);
                if(Long.valueOf((Long) temp.get("transactionId")).intValue()>maxid) {
                    maxid=Long.valueOf((Long) temp.get("transactionId")).intValue();
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        JSONObject transactionDetails = new JSONObject();
        transactionDetails.put("transactionId",maxid+1);
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

                Object obj = jsonParser.parse(reader);
                transactionList = (JSONArray) obj;
                for (int i = 0; i < transactionList.size(); i++) {
                    JSONObject objects = (JSONObject) transactionList.get(i);
                    if ((long)objects.get("Type") == 2) {
                        System.out.println("Transaction ID :" + objects.get("transactionId") + "  Transaction Name  :" + objects.get("Name") + "  Amount :" + objects.get("Amount")+"  Description :"+objects.get("Description")+"   Category:"+objects.get("Category"));
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

    public void deleteTransaction(int id){
        JSONParser jsonParser = new JSONParser();
        JSONArray Transactionlist= new JSONArray();
        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/transaction.json"))
        {
            Object obj = jsonParser.parse(reader);
            Transactionlist = (JSONArray) obj;
            for(int i = 0; i < Transactionlist.size(); i++)
            {
                JSONObject objects=(JSONObject) Transactionlist.get(i);
                if((long)objects.get("Id")==id){
                    Transactionlist.remove(i);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try (FileWriter file = new FileWriter("/Users/senthuran/Downloads/BudgetApp/transaction.json")) {
            file.write(Transactionlist.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        displayCategory();
    }


    public void editTransaction(String Name,double amount,int id,String description,String Category){
        JSONParser jsonParser = new JSONParser();
        JSONArray Categorylist= new JSONArray();

        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/transaction.json"))
        {
            Object obj = jsonParser.parse(reader);
            Categorylist = (JSONArray) obj;
            JSONObject objects=null;
            for(int i = 0; i < Categorylist.size(); i++)
            {
                objects=(JSONObject) Categorylist.get(i);
                if((long)objects.get("transactionId")==id){
                    objects.put("Name",Name);
                    objects.put("Amount",amount);
                    objects.put("Category",Category);
                    objects.put("Description",description);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try (FileWriter file = new FileWriter("/Users/senthuran/Downloads/BudgetApp/transaction.json")) {
            file.write(Categorylist.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashSet<String> getUniqueCategory(){
        JSONParser jsonParser = new JSONParser();
        JSONArray Categorylist= new JSONArray();
        HashSet<String> uniqueCategory=new HashSet<>();

        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/catagory1.json"))
        {
                   Object obj = jsonParser.parse(reader);
                   Categorylist = (JSONArray) obj;
                   JSONObject objects = null;
                   for (int i = 0; i < Categorylist.size(); i++) {
                       objects = (JSONObject) Categorylist.get(i);
                       uniqueCategory.add(objects.get("Name").toString());
                   }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return uniqueCategory;
    }


    public double getTotalIncome(){
        JSONParser jsonParser = new JSONParser();
        JSONArray Transactionlist= new JSONArray();
        double income=0;
        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/transaction.json"))
        {
            Object obj = jsonParser.parse(reader);
            Transactionlist = (JSONArray) obj;
            JSONObject objects=null;
            for(int i = 0; i < Transactionlist.size(); i++)
            {

                objects=(JSONObject) Transactionlist.get(i);
                if((long)objects.get("Type")==1)
                    income+=(double)objects.get("Amount");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
      return income;
    }

    public double getTotalExpense(){
        JSONParser jsonParser = new JSONParser();
        JSONArray Transactionlist= new JSONArray();
        double expense=0;
        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/transaction.json"))
        {
            Object obj = jsonParser.parse(reader);
            Transactionlist = (JSONArray) obj;
            JSONObject objects=null;
            for(int i = 0; i < Transactionlist.size(); i++)
            {
                objects=(JSONObject) Transactionlist.get(i);
                if((long)objects.get("Type")==2)
                    expense+=(double)objects.get("Amount");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return expense;
    }

    public double getTotalBudget(){
        JSONParser jsonParser = new JSONParser();
        JSONArray Catagorylist= new JSONArray();
        double totalbudget=0;
        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/catagory1.json"))
        {
            Object obj = jsonParser.parse(reader);
            Catagorylist = (JSONArray) obj;
            JSONObject objects=null;
            for(int i = 0; i < Catagorylist.size(); i++)
            {
                objects=(JSONObject) Catagorylist.get(i);
                totalbudget+=(double)objects.get("Amount");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return totalbudget;
    }

    public LinkedHashMap<String, Double> getExpenseByCatagory(){
        HashSet<String> uniqueCategory=getUniqueCategory();
        LinkedHashMap<String, Double> categoryamount=new LinkedHashMap<String, Double>();
        JSONParser jsonParser = new JSONParser();
        JSONArray Catagorylist= new JSONArray();
        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/transaction.json"))
        {
            Object obj = jsonParser.parse(reader);
            Catagorylist = (JSONArray) obj;
            JSONObject objects=null;
            for(String s:uniqueCategory){
              double totalamount=0;
             for(int i = 0; i < Catagorylist.size(); i++)
            {
             objects=(JSONObject) Catagorylist.get(i);
             if(objects.get("Category").equals(s)&& (long)objects.get("Type")==2) {
                 totalamount+=(double)objects.get("Amount");
             }
             categoryamount.put(s,totalamount);
            }
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return categoryamount;
    }

    public LinkedHashMap<String, Double> getCatagoryAmount(){
        JSONParser jsonParser = new JSONParser();
        JSONArray Catagorylist= new JSONArray();
        LinkedHashMap<String, Double> categoryamount=new LinkedHashMap<String, Double>();
        try (FileReader reader = new FileReader("/Users/senthuran/Downloads/BudgetApp/catagory1.json"))
        {
            Object obj = jsonParser.parse(reader);
            Catagorylist = (JSONArray) obj;
            JSONObject objects=null;
            for(int i = 0; i < Catagorylist.size(); i++)
            {
                objects=(JSONObject) Catagorylist.get(i);
                categoryamount.put(objects.get("Name").toString(),(double)objects.get("Amount"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return categoryamount;
    }


}
