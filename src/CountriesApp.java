import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountriesApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String directoryString = "resources"; // directory assigned name

        createDirectory(directoryString); //  call create directory method
        createFile(directoryString, "Countries.txt");// call create file method
        String country = null;


        String cont = "Y"; // loop condition
        while (cont.equalsIgnoreCase("y")) {
            System.out.print(" 1- display a list of countries. \n 2- enter a country. \n 3- Quit \n Pleas Choose an option: ");
            int input = scan.nextInt();
            if (input == 1) {
                // call reading method from ContriesTextFile class
                CountriesTextFile.readFromFile(directoryString, "Countries.txt");


            } else if (input == 2) {
                // loop to add multiple countries
                while (cont.equalsIgnoreCase("y")) {
                    System.out.println("Please enter a country: ");
                    country = scan.next();
                    // call reading method from ContriesTextFile class
                    CountriesTextFile.writeToFile(directoryString, "Countries.txt", country);
                    System.out.println("Do you want to add another country? (Y/N)");
                    String answer = scan.next();
                    if (answer.equalsIgnoreCase("y")) {
                        cont = "y";
                    } else {
                        cont = "n";
                    }
                }
            }
            // exit loop
            cont = "n";
        }
        System.out.println();
        System.out.println("Goodbye !");

    }
    // create directory method
    public static void createDirectory(String dirString) {
        Path dirPath = Paths.get(dirString);
        if (Files.notExists(dirPath)) {
            try {
                Files.createDirectory(dirPath);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("I'm not sure what happened, contact customer service");
            }
        }
    }
    // create file method
    public static void createFile(String dirString, String fileString) {
        Path filePath = Paths.get(dirString, fileString);
        if (Files.notExists(filePath)) {
            try {
                Files.createFile(filePath);
                } catch (IOException e) {
                System.out.println("Hey something went wrong with the file creation!");
                ;
            }
        }
    }
}
