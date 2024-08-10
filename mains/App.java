package mains;

import da.UserDa;
import Entity.User;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserDa userDa = new UserDa();
        User user;
        String username, password;
        int option = 0;
        do {
            try {
                System.out.println("1)Add User");
                System.out.println("2)Edit User");
                System.out.println("3)Delete User");
                System.out.println("4)Show All Users");
                System.out.println("5)Check Is Duplicate Username");
                System.out.println("6)Login");
                System.out.println("0) Exit");

                System.out.print("Enter Choice :");
                option = Integer.parseInt(scanner.nextLine());

                System.out.println("-----------------------------------------");

                switch (option) {
                    case 1:
                        user = new User();
                        System.out.print("Enter username : ");
                        user.setUsername(scanner.nextLine());

                        System.out.print("Enter password : ");
                        user.setPassword(scanner.nextLine());

                        if (userDa.findByUsername(user.getUsername()) == null) {
                            userDa.save(user);
                            System.out.println("User Saved");
                        } else {
                            System.err.println("User name is duplicated, change It !!!");
                        }

                        break;

                    case 2:
                        user = new User();
                        System.out.print("Enter Id : ");
                        user.setId(Integer.parseInt(scanner.nextLine()));

                        System.out.print("Enter username : ");
                        user.setUsername(scanner.nextLine());

                        System.out.print("Enter password : ");
                        user.setPassword(scanner.nextLine());

                        userDa.edit(user);
                        System.out.println("User Edited");
                        break;

                    case 3:
                        System.out.print("Enter Id : ");
                        int id = Integer.parseInt(scanner.nextLine());

                        userDa.remove(id);
                        System.out.println("User Removed");
                        break;

                    case 4:
                        System.out.println("User List");
                        for (User u : userDa.findAll()) {
                            System.out.printf("User : %15s  Pass : ******** %n", u.getUsername());
                        }
                        break;

                    case 5:
                        System.out.print("Enter username : ");
                        username = scanner.nextLine();

                        if (userDa.findByUsername(username) == null) {
                            System.out.println("Username is not duplicate, Ok ");
                        } else {
                            System.err.println("Error : Username is duplicated !!!");
                        }
                        break;

                    case 6:
                        System.out.print("Enter username : ");
                        username = scanner.nextLine();

                        System.out.print("Enter password : ");
                        password = scanner.nextLine();

                        if (userDa.findByUsernameAndPassword(username, password) != null) {
                            System.out.println("Welcome");
                        } else {
                            System.out.println("Access Denied !!!");
                        }
                        break;

                    case 0:
                        System.out.println("By");
                        break;
                    default:
                        System.err.println("Invalid Choice");
                        ;
                }
                System.out.println("-----------------------------------------");
            } catch (Exception e) {
                System.err.println("Error : " + e.getMessage() + "Try again Later !!!");
            }
        } while (option != 0);
    }
}