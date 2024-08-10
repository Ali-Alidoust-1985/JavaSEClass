package SE10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Filing {
    public static void main(String[] args) throws IOException {
        File myFile=new File("sample.txt");
        myFile.createNewFile();
        FileWriter fw=new FileWriter(myFile);
        fw.write("Hello World");
        fw.write("\nBye World");
        fw.close();
    }
}
