public class MyString {
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        char[] charsArr = str.toCharArray();
        for (int i = 0; i < charsArr.length; i++) {
            // Changes uppercase letters to lowercase.
            if ('A' <= charsArr[i] && charsArr[i] <= 'Z') {
                charsArr[i] = (char) (charsArr[i] + 32);
            }
        }
        return new String(charsArr);
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        // Finds the index in str1 where the first letter in str2 match.
        int startIndex = str1.indexOf(str2.charAt(0));
        // Returns false if one of the strings is empty, str2 is bigger than str1 or the
        // first letter of str2 doesn't exit in str1.
        Boolean isStrEmpty = str1.length() == 0 || str2.length() == 0;
        if (isStrEmpty || startIndex == -1 || str1.length() < str2.length()) {
            return false;
        }

        // Checks if all of the letters in str2 exists in a chronological order in str1.
        Boolean isContains = true;
        for (int i = 1; i < str2.length(); i++) {
            if (str1.charAt(startIndex + i) != str2.charAt(i)) {
                isContains = false;
            }
        }
        return isContains;
    }
}