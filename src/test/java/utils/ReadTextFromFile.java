package utils;


import java.io.*;

public class ReadTextFromFile {
    //reading from file
    public static String read(String fileName) {

        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();

        try {
            if (!file.exists()) {
                throw new FileNotFoundException(file.getName());
            }

            BufferedReader br = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s).append("\n");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
