package HomeWork.ExOne;

import java.io.*;


public class ValidPhoneNumber {
/*    private String regOne = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
    private String regTwo = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";


    public ValidPhoneNumber(String path) {
        File file = new File(path);
        checkIfFileExists(file);
        readPrintValidNumbers(file);
    }


    private void checkIfFileExists(File file) {

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void readPrintValidNumbers (File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.matches(regOne) || line.matches(regTwo)) {
                    System.out.println(line);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
           System.err.println(e.getMessage());
        }
    }*/
}
