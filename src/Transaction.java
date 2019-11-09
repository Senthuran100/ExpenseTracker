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

import java.util.Date;

public class Transaction {


    private String Name;
    private double Amount;
    private String Description;
    private Date date;
    private int transactionID;

    Transaction(double Amount,String Description,Date date,String name) {
      this.Amount=Amount;
      this.Description=Description;
      this.date=date;
      this.Name=name;
    }

    public int getID() {
        return transactionID;
    }

    public void setID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Transaction(String name, double amount, String description,Date date) {
        Name = name;
        Amount = amount;
        Description = description;
        this.date = date;
    }
}
