package com.company;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Harman {

    public static void main(String[] args) {
	// write your code here

        Scanner sc = new Scanner(System.in);
        int options;
        while(true) {

            System.out.println("1.Add the Product Details ");
            System.out.println("2.View All Product");
            System.out.println("3.Search a Product");
            System.out.println("4.Update Product details using Code");
            System.out.println("5.Delect a product ");
            System.out.println("6.Display all details of Product whose price is greater than 50000");
            System.out.println("7.Display the count of total number of product in the company");
            System.out.println("8.Display all the product details in alphabetical order");
            System.out.println("9.Exit");
            System.out.println("Select an option: ");
            options = sc.nextInt();
            switch (options){
                //Inserting records
                case 1:
                    String Productcode, ProductName, Brand, Price, Model, MfgYear, Expirydate;
                    System.out.println("Enter the productcode: ");
                    Productcode = sc.next();
                    System.out.println("Enter Product Name: ");
                    ProductName = sc.next();
                    System.out.println(" Enter Brand Name: ");
                    Brand = sc.next();
                    System.out.println(" Enter the Price of Product: ");
                    Price = sc.next();
                    System.out.println("Enter the Model: ");
                    Model = sc.next();
                    System.out.println("Enter the Manafacturing Year: ");
                    MfgYear = sc.next();
                    System.out.println("Enter the Expiry date: ");
                    Expirydate = sc.next();

                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/harmancompany?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("INSERT INTO `productdetails`(`Productcode`, `productname`, `Brand`, `Price`, `model`, `Mfgyear`, `expirydate`)VALUES("+Productcode+",'"+ProductName+"','"+Brand+"',"+Price+",'"+ Model+"',"+MfgYear+","+Expirydate+")");

                        System.out.println("Inserted done Succesfully");



                    }
                    catch(Exception e){
                        System.out.println(e);

                    }
                    break;

                //View All
                case 2:

                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/harmancompany?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `id`, `ProductCode`, `ProductName`, `Brand`, `Price`, `Model`, `MfgYear`, `Expirydate` FROM `productdetails` WHERE 1");
                        while(rs.next()){
                            System.out.println("ProductCode is: "+rs.getInt("ProductCode"));
                            System.out.println("ProductName is: "+rs.getString("ProductName"));
                            System.out.println("Brand : "+rs.getString("Brand"));
                            System.out.println("Price of Product: "+rs.getInt("Price"));
                            System.out.println("Model is: "+rs.getString("Model"));
                            System.out.println("MfgYear is: "+rs.getInt("MfgYear"));
                            System.out.println("Expirydate of product: "+rs.getInt("Expirydate"));



                        }


                    }
                    catch(Exception e){
                        System.out.println(e);


                    }

                    break;
                // Search by code
                case 3:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/harmancompany?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        int productcode;
                        System.out.println("Enter the productCode to be searched");
                        productcode = sc.nextInt();

                        ResultSet rs = stmt.executeQuery("SELECT `id`, `ProductCode`, `ProductName`, `Brand`, `Price`, `Model`, `MfgYear`, `Expirydate` FROM `productdetails` WHERE 1");
                        while(rs.next()){

                            if (rs.getInt("ProductCode")==productcode) {
                                System.out.println("ProductCode is: " + rs.getInt("ProductCode"));
                                System.out.println("ProductName is: " + rs.getString("ProductName"));
                                System.out.println("Brand : " + rs.getString("Brand"));
                                System.out.println("Price of Product: " + rs.getInt("Price"));
                                System.out.println("Model is: " + rs.getString("Model"));
                                System.out.println("MfgYear is: " + rs.getInt("MfgYear"));
                                System.out.println("Expirydate of product: " + rs.getInt("Expirydate"));
                                break;

                            }



                        }




                    }
                    catch(Exception e){
                        System.out.println(e);

                    }


                    break;

                //Update by code
                case 4:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/harmancompany?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        int prodcode,price,mfgyear,exprydate;
                        String prodName,brand,model;
                        System.out.println("Enter the ProductCode to be Updated: ");
                        prodcode = sc.nextInt();
                        System.out.println("Enter New product name: ");
                        prodName = sc.next();
                        System.out.println("Enter New Brand name: ");
                        brand = sc.next();
                        System.out.println("Enter New Price: ");
                        price = sc.nextInt();
                        System.out.println("Enter New model: ");
                        model = sc.next();
                        System.out.println("Enter new Manafacturing year: ");
                        mfgyear = sc.nextInt();
                        System.out.println("Enter new Expiry date: ");
                        exprydate = sc.nextInt();
                        stmt.executeUpdate(" UPDATE `productdetails` SET`ProductName`='"+prodName+"',`Brand`='"+ brand+"',`Price`="+price+",`Model`='"+model+"',`MfgYear`="+mfgyear+",`Expirydate`= "+exprydate+" WHERE `ProductCode` ="+prodcode);




                    }
                    catch(Exception e){
                        System.out.println(e);

                    }


                    break;
                //delect a record
                case 5:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/harmancompany?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        int productno;
                        System.out.println("Enter the product no to be deleted");
                        productno = sc.nextInt();
                        stmt.executeUpdate("DELETE FROM `productdetails` WHERE `ProductCode`="+productno);
                        System.out.println("Product deleted");



                    }
                    catch(Exception e){
                        System.out.println(e);
                    }

                    break;

                //
                case 6:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/harmancompany?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs3 = stmt.executeQuery("SELECT * FROM `productdetails` WHERE `Price` >50000");
                        while(rs3.next()) {
                            System.out.println("ProductCode is: " + rs3.getInt("ProductCode"));
                            System.out.println("ProductName is: " + rs3.getString("ProductName"));
                            System.out.println("Brand : " + rs3.getString("Brand"));
                            System.out.println("Price of Product: " + rs3.getInt("Price"));
                            System.out.println("Model is: " + rs3.getString("Model"));
                            System.out.println("MfgYear is: " + rs3.getInt("MfgYear"));
                            System.out.println("Expirydate of product: " + rs3.getInt("Expirydate"));


                        }
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }

                    break;

                // display count
                case 7:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/harmancompany?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs5 = stmt.executeQuery("SELECT COUNT(*) AS Rowcount FROM productdetails");
                        rs5.next();
                        int count = rs5.getInt("Rowcount") ;
                        rs5.close() ;

                        System.out.println("MyTable has " + count + " row(s).");



                    }
                    catch(Exception e){
                        System.out.println(e);

                    }


                    break;

                // display in Alphabetical order
                case 8:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/harmancompany?autoReconnect=true&useSSL=false","root","");
                        Statement stmt = con.createStatement();
                        ResultSet rs2 =stmt.executeQuery("SELECT * FROM `productdetails` ORDER BY `ProductName`");
                        while(rs2.next()) {
                            System.out.println("ProductCode is: " + rs2.getInt("ProductCode"));
                            System.out.println("ProductName is: " + rs2.getString("ProductName"));
                            System.out.println("Brand : " + rs2.getString("Brand"));
                            System.out.println("Price of Product: " + rs2.getInt("Price"));
                            System.out.println("Model is: " + rs2.getString("Model"));
                            System.out.println("MfgYear is: " + rs2.getInt("MfgYear"));
                            System.out.println("Expirydate of product: " + rs2.getInt("Expirydate"));

                        }
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }


                    break;


                case 9:
                    System.exit(0);


                default:
                    System.out.println("Invalid choice");











            }
        }
    }
}
