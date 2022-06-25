package xyz.aaratprasadchopra.just_for_fun;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Finds All The occurences of a word in a file!
 */
public class FindAllOccupance {
    public static void replaceAll(File file) throws Exception {
        Scanner scan = new Scanner(file);
        StringBuilder appendStr = new StringBuilder();

        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
            // appendStr.append(scan.next());
            // appendStr.append(System.lineSeparator());
        }
        String replacedStr = appendStr.toString().replace("Delhi Daredevils", "Delhi Capitals");

        FileWriter writer = new FileWriter(file);
        writer.write(replacedStr);
        writer.close();
        scan.close();
        System.out.println("File Written");
    }
}
