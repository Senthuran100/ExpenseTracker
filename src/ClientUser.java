

import java.io.IOException;
import java.util.Scanner;

public class ClientUser {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("############# Welcome to Budget Manager #############");

        UserActivity ua = new UserActivity();
        while (true) {
            System.out.println("            Menu");
            System.out.println("   -----------------------------------------------------");
            System.out.println("        Key       Description");
            System.out.println("   ----------------------------");
            System.out.println("        C      Create new Category");
            System.out.println("        I      Enter new Income");
            System.out.println("        T      Enter new Expense");
            System.out.println("        A      List All Categoty");
            System.out.println("        L      List Transaction");
            System.out.println("        D      Delete a  Category");
            System.out.println("        B      Delete an  Income");
            System.out.println("        S      Delete an  Expense");
            System.out.println("        E      Edit a  Category");
            System.out.println("        U      Show unique  Category");
            System.out.println("        R      Edit an  Expense");
            System.out.println("        N      Edit an  Income");
            System.out.println("        G      Show in Detail");
            System.out.println("        X      Exit Application");
            System.out.println("\n\n\n----------------------------------------------------");
            System.out.print("   Your option: ");

            char ch = ua.getOption();
            switch (ch) {
                case 'C':
                case 'c':
                    ua.createnewCategory();
                    break;
                case 'n':
                case 'N':
                    ua.editIncome();
                    break;
                case 's':
                case 'S':
                    ua.deleteExpense();
                    break;
                case 'A':
                case 'a':
                    ua.listCategory();
                    break;
                case 'D':
                case 'd':
                    ua.deleteCategory();
                    break;
                case 'E':
                case 'e':
                    ua.editCategory();
                    break;
                case 'T':
                case 't':
                    ua.addExpense();
                    break;
                case 'I':
                case 'i':
                    ua.addIncome();
                    break;
                case 'L':
                case 'l':
                    ua.ListTransaction();
                    break;
                case 'B':
                case 'b':
                    ua.deleteIncome();
                    break;
                case 'R':
                case 'r':
                    ua.editExpense();
                    break;
                case 'u':
                case 'U':
                    ua.getUniqueCategoty();
                case 'g':
                case 'G':
                    ua.showInDetail();
                case 'q':
                    System.out.println("You didn't input any value try entering a meaningful value");
                case 'X':
                default:
                    return;
            }
        }
    }
}


