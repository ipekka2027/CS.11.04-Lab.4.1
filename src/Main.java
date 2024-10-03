import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        System.out.println(reverseInteger(10239));
    }


    // 1. parenthesesCheck

    public static boolean parenthesesCheck(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == ')') {
                count--;
            }
        }
        return count == 0;
    }

    // 2. reverseInteger

    public static String reverseInteger(int number) {
        String strNum = Integer.toString(number);
        String reversed = "";

        for (int i = strNum.length() - 1; i >= 0; i--) {
            reversed += strNum.charAt(i);
        }
        return reversed;
    }

//    public static String reverseInteger(int number) {
//        String strNum = Integer.toString(number);
//        StringBuilder sb = new StringBuilder(strNum);
//        return sb.reverse().toString();
//    }


    // 3. encryptThis

    public static String encryptThis(String message) {
        StringBuilder sb = new StringBuilder();
        String[] words = message.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 0) {
                int charCode = (int) word.charAt(0);
                String charCodeStr = String.valueOf(charCode);
                if (word.length() > 2) {
                    String swapped = charCodeStr + word.charAt(word.length() - 1) +
                            word.substring(2, word.length() - 1) +
                            word.charAt(1);
                    sb.append(swapped).append(" ");
                } else {
                    sb.append(charCodeStr).append(word.substring(1)).append(" ");
                }
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }


// 4. decipherThis

    public static String decipherThis(String message) {
        StringBuilder sb = new StringBuilder();
        String[] words = message.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int charCodeLength = 0;

            while (charCodeLength < word.length() && Character.isDigit(word.charAt(charCodeLength))) {
                charCodeLength++;
            }

            int charCode = Integer.parseInt(word.substring(0, charCodeLength));
            char firstLetter = (char) charCode;
            String restOfWord = word.substring(charCodeLength);

            if (restOfWord.length() > 1) {
                restOfWord = restOfWord.charAt(restOfWord.length() - 1) +
                        restOfWord.substring(1, restOfWord.length() - 1) +
                        restOfWord.charAt(0);
            }

            sb.append(firstLetter).append(restOfWord).append(" ");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        return sb.toString();
    }
}