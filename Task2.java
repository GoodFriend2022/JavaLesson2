import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        String taskFileName = "HomeWork.txt";
        String resultFileName = "Result.txt";
        String text = "Добрый день      Как дела    Все хорошо";

        CreateFile(taskFileName);
        WriteMessageToFile(taskFileName, text);
        String textFromFile = ReadFromFile(taskFileName);
        String[] words = ArrayWords(textFromFile);
        Dotting(words);
        String resultText = ArrayToString(words);
        WriteMessageToFile(resultFileName, resultText);
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
            FileWriter fw = new FileWriter(file, true);
            fw.write(message + "\n");
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

    static String[] ArrayWords(String text) {
        text = text.replaceAll("\\s+", " ");
        return text.split(" ");
    }   
    
    static String ArrayToString(String[] array) {
        return String.join(" ", array);
    }

    static void Dotting(String[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            if (Character.isUpperCase(array[i].charAt(0))) {
                array[i-1] = array[i-1] + ".";
            }
        }
        array[len - 1] = array[len - 1] + ".";
    }
}
