package Test;

import java.util.ArrayList;
import java.util.Scanner;

public class ListKala {

    public static void main(String[] args) {
        ArrayList<String> productName = new ArrayList<>();
        ArrayList<Integer> productPrice = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int option;
        int sum = 0;
        int i=0;


        do{
            System.out.println("1)Add Product");
            System.out.println("2)Sum");
            System.out.println("3)Name Products");
            System.out.println("0)Exit");

            System.out.print("Enter Option : ");
            option = Integer.parseInt(sc.nextLine());

            System.out.println("-----------------------------------------------");

            switch (option) {
                case 1:     //Add Product Name and Price
                    System.out.print("Enter Product name : ");
                    String x = sc.nextLine();
                    productName.add(x);
                    System.out.print("Enter Product Price : ");
                    int x1 = Integer.parseInt(sc.nextLine());
                    productPrice.add(x1);
                    System.out.println("Product name and Price Added To List");
                    sum = sum + productPrice.get(i);
                    i=i+1;
                    break;

                case 2:     //Sum Price

                    System.out.println("Sum of Costs : " + sum);
                    break;

                case 3:     //Name of Products
                    System.out.println("Name of all Products : " + productName);
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid Option !!!");
            }

            System.out.println("-----------------------------------------------");
        }while (option !=0);
    }
}

