package module9.HomeWork.ExOne;

import java.io.*;


public class ValidPhoneNumber {

    private String path;

    public ValidPhoneNumber(String path) {
        this.path = path;
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
                if (validPhoneNumber(line)) {
                    System.out.println(line);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
           System.err.println(e.getMessage());
        }
    }

    private boolean validPhoneNumber (String line) {
        char[] charArray = line.toCharArray();
        boolean valid = false;

        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])){
                count++;
            }
        }

        if (charArray[0] == '(' && charArray[4] == ')' && charArray[5] == ' ' && charArray[9] == '-') {
                valid = true;
        }else if (charArray[3] == '-' && charArray[7] == '-') {
                valid = true;
        } else {
            valid =false;
        }
        if (count != 10) {
            valid = false;
        }


        return valid;

    }

}
