import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CountriesTextFile {
    private String country;

    public CountriesTextFile() {

    }

    public CountriesTextFile(String country) {
        this.country = country;
    }

    // Writing in file method
    public static void writeToFile(String dirString, String fileString, String country) {

        Path writeFile = Paths.get(dirString, fileString);

        File file = writeFile.toFile();

        try {

            PrintWriter printOut = new PrintWriter(new FileOutputStream(file, true));

            printOut.println(country);

            printOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // read file method
    public static void readFromFile(String dirString, String filePath) {
        Path readfile = Paths.get(dirString, filePath);
        File file = readfile.toFile();

        try {
            FileReader fr = new FileReader(file);

            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Something wrong with this!");
        }
    }
}
