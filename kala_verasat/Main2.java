package kala_verasat;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("which kind of product you wanna add? Electrical(1), not Electrical (0):");
        int option = Integer.parseInt(sc.nextLine());
        if (option == 1) {
            Electrical electrical = new Electrical();
            System.out.println("Enter Voltage:");
            electrical.setVoltage(Integer.parseInt(sc.nextLine()));
            System.out.println(electrical);
            System.out.println("Labtob(1), not mobile(0):");
            int option1 = Integer.parseInt(sc.nextLine());
            if (option1 == 1) {
                Laptop labtob = new Laptop();
                System.out.println("Enter Cputype:");
                labtob.setCpuType(sc.nextLine());
                System.out.println("Enter ram Level:");
                labtob.setRamLevel(Integer.parseInt(sc.nextLine()));
                System.out.println("Dell(0) Asus(1):");
                int option2 = Integer.parseInt(sc.nextLine());
                System.out.println(labtob);
                if (option2 == 1) {
                    labtob.setModel("Asus");
                    System.out.println(labtob);
                } else {
                    labtob.setModel("Dell");
                    System.out.println("Does support touch monitor?: Yes(1), No(0):");
                    Dell dell = new Dell();
                    dell.setTouch(Boolean.getBoolean(sc.nextLine()));
                    System.out.println(dell);
                }

            }

        } else if (option == 0) {
            System.out.println("Enter Mobl Weight:");
            Mobl mobl = new Mobl();
            mobl.setWeight(Integer.parseInt(sc.nextLine()));
            System.out.println(mobl);
        }


    }
}
