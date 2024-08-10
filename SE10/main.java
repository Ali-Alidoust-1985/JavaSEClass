package SE10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        File myFile=new File("sample.txt");
        Scanner sc = new Scanner(myFile);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
