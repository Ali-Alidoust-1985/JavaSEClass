package biomedical;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RadiographyDevice radiographyDevice = new RadiographyDevice();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radiography device name: "); //Angiography
        radiographyDevice.setName(sc.nextLine());
        System.out.println("Enter the radiography device serial number: ");//2165127
        radiographyDevice.setSerialNum(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the radiography device kV: ");
        radiographyDevice.setkV(Integer.parseInt(sc.nextLine())); //320
        System.out.println("Enter the radiography device mA: "); //50
        radiographyDevice.setmA(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the radiography device dose: "); //20
        radiographyDevice.setDose(Integer.parseInt(sc.nextLine()));
        System.out.println("Does this radiography device use Xray to form the image?: ");
        try {
            String s = sc.nextLine();
//            int option = Integer.parseInt(s);
            if (s=="yes" || s=="y" || s=="Y" || s=="Yes" || s=="YES") {
                radiographyDevice.setxRay(true);
            }
            else if (s=="no" || s=="n" || s=="N" || s=="No" || s=="NO"){
                radiographyDevice.setxRay(true);
            }else if(Integer.parseInt(s)==1) {
                radiographyDevice.setxRay(true);
            }
            else if (Integer.parseInt(s)==0) {
                radiographyDevice.setxRay(false);
            }
            //else if(option==0 || s=="no" || s=="n" || s=="N" || s=="No" || s=="NO")
//            else if (option == 0) {
//                radiographyDevice.setxRay(false);
//            }
        } catch (Exception e) {
            System.out.println("\n  لطفا فقط مقدار ۰ یا ۱ \n کنید وارد\n");
        }

        System.out.println(radiographyDevice);

        Sono sono = new Sono();
        System.out.println("Enter the sono name: "); // Portable Sono
        sono.setName(sc.nextLine());
        System.out.println("Enter the sono serial number: "); //321123
        sono.setSerialNum(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter the sono Application: "); // OB/GYN Diagnosis
        sono.setApplication(sc.nextLine());
        System.out.println("Is it a colour sono?");
        try {
            int option = Integer.parseInt(sc.nextLine());
            // if ( s1 == "yes" | s1 == "y" | s1 == "Y" | s1 == "Yes" | s1 == "YES") {
            if (option == 1) {
                sono.setColour(true);
            }
            //else if ( s1 == "no" | s1 == "n" | s1 == "N" | s1 == "No" | s1 == "NO") {
            else if (option == 0) {
                sono.setColour(false);
            }
        } catch (Exception e) {
            System.out.println("\n  لطفا فقط مقدار ۰ یا ۱ \n کنید وارد\n");
        }
        System.out.println("Whats is the sono output: "); //2D, 3D, 4D pics
        sono.setOutput(sc.nextLine());
        System.out.println("Is sono a X-Ray based device? ");

        try {
            String s = sc.nextLine();
            int option = Integer.parseInt(s);
            //if (option2 == 1 | s2 == "yes" | s2 == "y" | s2 == "Y" | s2 == "Yes" | s2 == "YES") {
            if (option == 1) {
                sono.setxRay(true);
            }
            //else if (option2 == 0 | s2 == "no" | s2 == "n" | s2 == "N" | s2 == "No" | s2 == "NO") {
            else if (option == 0) {
                sono.setColour(false);
            }
        } catch (Exception e) {
            System.out.println("\n  لطفا فقط مقدار ۰ یا ۱ \n کنید وارد\n");
        }
        System.out.println("Enter the dimension of the sono"); // 2 or 3 or 4
        sono.setDimension(Integer.parseInt(sc.nextLine()));
        System.out.println(sono);


        ElectroSurgery electrosurgery = new ElectroSurgery();
        System.out.println("Enter electrosurgury device name: "); // Cutter
        electrosurgery.setName(sc.nextLine());
        System.out.println("Enter electrosurgery Serial number "); // 324234
        electrosurgery.setSerialNum(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter electrosurgery frequency "); // 12000
        electrosurgery.setFrequency(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter electrosurgery temperature: "); //70
        electrosurgery.setTemperature(Integer.parseInt(sc.nextLine()));
        System.out.println("Enter Electrosurgery Technology: "); // RF
        electrosurgery.setTechnology(sc.nextLine());
        System.out.println("Enter the output of electrosurgery: "); //Therapy
        electrosurgery.setOutput(sc.nextLine());
        System.out.println("Enter the application of electrosurgery: "); // Cutting and Coagolation
        electrosurgery.setApplication(sc.nextLine());
        System.out.println(electrosurgery);

    }
}
