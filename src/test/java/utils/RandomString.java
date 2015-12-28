package utils;


import java.util.Random;

public class RandomString {
    private static String randomString(int size){
        Random random = new Random();
        String line = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(size);
        for( int i = 0; i < size; i++ )
            sb.append(line.charAt(random.nextInt(line.length())));
        return sb.toString();
    }

    public static String generateString(int size) {
        return randomString(size);
    }

}
