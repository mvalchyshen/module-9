package module9.HomeWork.ExersiceThree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ExerciseThree {
    public static void main(String[] args) {
        new ExerciseThree("C:\\Users\\UAValchyMa\\IdeaProjects\\ATM\\src\\main\\resources" +
        "\\Module9Ex3\\words.txt");
    }

    public ExerciseThree(String path) {
        File file = new File(path);
        checkIfFileExists(file);
        String reader = reader(file);
        HashMap<String, Integer> wordsIntoHashMap = wordsIntoHashMap(reader);
        List<Map.Entry<String, Integer>> list = sortByValue(wordsIntoHashMap);
        print(list);
    }
    public void checkIfFileExists(File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private String reader(File file) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            if (line == null) {
                System.err.println("File is empty");
            }
            while (line != null) {
                result.append(line + "\n");
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return result.toString();
    }

    private HashMap<String, Integer> wordsIntoHashMap(String resultLine) {
        HashMap<String, Integer> words = new HashMap<>();
        String[] strings = resultLine.replace("\n", " ").toLowerCase().split(" ");

        for (String el1 : strings) {
            int counter = 0;
            for (String el : strings) {
                if (el.equals(el1)) {
                    counter++;
                }
            }
            words.put(el1, counter);
        }
        return words;
    }


    private List<Map.Entry<String, Integer>> sortByValue (HashMap<String, Integer> unsortedMap) {
        Set<Map.Entry<String,Integer>> setSortedMap = unsortedMap.entrySet();
        List<Map.Entry<String, Integer>> listSortedMap = new ArrayList<>(setSortedMap);
        listSortedMap.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        return listSortedMap;
    }

    private void print (List<Map.Entry<String, Integer>> sortedList) {
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " " +entry.getValue());
        }
    }
}
