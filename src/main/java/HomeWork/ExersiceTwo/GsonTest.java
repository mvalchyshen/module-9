package HomeWork.ExersiceTwo;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class GsonTest {
    public static void main(String[] args) {
        new GsonTest(PATH_TXT, PATH_JSON);
    }

    public static final String PATH_TXT = "src/main/resources/user.txt";
    public static final String PATH_JSON = "src/main/resources/user.json";

    public GsonTest(String txtPath, String jsonPath) {
        File txtFile = new File(txtPath);
        File jsonFile = new File(jsonPath);
        checkIfFileExists(txtFile);
        checkIfFileExists(jsonFile);
        List<Person> persons = new LinkedList<>();
        readFromTxtFile(txtFile, persons);
        writeToJsonFile(jsonFile, persons);


    }

    private void checkIfFileExists(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeToJsonFile(File jsonFile, List<Person> persons) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(jsonFile))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(persons);
            bufferedWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromTxtFile(File txtFile, List<Person> persons) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(txtFile))) {
            String data = bufferedReader.readLine();
            while (data != null) {
                String[] lines = data.split(" ");
                if (!lines[0].equals("name") && !lines[1].equals("age")) {
                    persons.add(new Person(lines[0], Integer.parseInt(lines[1])));
                }
                data = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
