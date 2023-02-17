import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        CreateFile("HomeWork.txt");
        WriteMessageToFile("Homework.txt", "Добрый день      Как дела    Все хорошо");
        System.out.println(ReadFromFile("HomeWork.txt"));
    }

    static void CreateFile(String fileName) {
        try {
            File newFile = new File(fileName);
            if(!newFile.exists()) newFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    static void WriteMessageToFile(String fileName, String message) { 
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            fw.write(message);
            fw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    static String ReadFromFile(String fileName) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(fileName));
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            System.out.println(str);
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return sb.toString();
    }

    
}
