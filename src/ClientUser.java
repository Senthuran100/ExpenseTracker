/*
 * Copyright (c) 2019 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.IOException;
import java.util.Scanner;

public class ClientUser {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String category = "";

        Scanner budgetCategory = new Scanner(System.in);
        System.out.println("############# Welcome to Budget Manager #############");

        UserActivity ua = new UserActivity();
        while (true) {
            System.out.println("            Menu");
            System.out.println("   -----------------------------------------------------");
            System.out.println("        Key       Description");
            System.out.println("   ----------------------------");
            System.out.println("        C      Create new Category");
            System.out.println("        T      Enter new Transaction");
            System.out.println("        A      List All Categoty");
            System.out.println("        L      List Transaction");
            System.out.println("        D      Delete a  Category");
            System.out.println("        B      Delete a  Transaction");
            System.out.println("        E      Edit a  Category");
            System.out.println("        R      Edit a  Transaction");
            System.out.println("        X      Exit Application");
            System.out.println("\n\n\n----------------------------------------------------");
            System.out.print("   Your option: ");

            char ch = ua.getOption();
            switch (ch) {
                case 'C':
                case 'c':
                    ua.createnewCategory();
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
                    ua.addTransaction();
                    break;
                case 'L':
                case 'l':
                    ua.ListTransaction();
                    break;
                case 'B':
                case 'b':
                    ua.deleteTransaction();
                    break;
                case 'R':
                case 'r':
                    ua.editTransaction();
                    break;
                case 'u':
                case 'U':
                    ua.getUniqueCategoty();
                case 'q':
                    System.out.println("You didn't input any value try entering a meaningful value");
                case 'X':
                default:
                    return;
            }
        }
    }
}


