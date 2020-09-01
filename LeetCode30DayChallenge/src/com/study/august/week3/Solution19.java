package com.study.august.week3;

/**
 * Goat Latin
 *
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 * Example 1:
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 *
 * Notes:
 *
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 *
 */
public class Solution19 {
    public String toGoatLatin_6ms_2(String S) {

        String[] strArray = S.split(" ");
        StringBuilder sb = new StringBuilder();

        String appendDefault = "";

        for (String s : strArray) {
            appendDefault += "a";

            if (isVowel(s.charAt(0))) {
                sb.append(wordWithVowel(s));
            } else {
                sb.append(wordWithoutVowel(s));
            }

            sb.append(appendDefault).append(" ");
        }

        return sb.toString().trim();
    }

    public String toGoatLatin_15ms(String S) {

        StringBuilder sb = new StringBuilder();
        String[] strArray = S.split(" ");

        for(int i = 0; i < strArray.length; i ++){
            char ch = strArray[i].charAt(0);
            if(isVowel(ch)){
                strArray[i] = wordWithVowel(strArray[i], i + 1);
            } else {
                strArray[i] = wordWithoutVowel(strArray[i], i + 1);
            }

            sb.append(strArray[i]).append(" ");
        }

        return sb.toString().trim();
    }

    public String toGoatLatin_6ms_1(String S) {

        String[] strArray = S.split(" ");

        for(int i = 0; i < strArray.length; i ++){
            char ch = strArray[i].charAt(0);
            switch(ch){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    strArray[i] = wordWithVowel(strArray[i], i + 1);
                    break;
                default:
                    strArray[i] = wordWithoutVowel(strArray[i], i + 1);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strArray) {
            sb.append(s).append(" ");
        }

        return sb.toString().trim();
    }

    public String wordWithVowel(String word, int index){
        word += "ma";
        return appendA(word, index);
    }

    public String wordWithoutVowel(String word, int index){
        char ch = word.charAt(0);
        word = word.substring(1);
        word = word + ch + "ma";
        return appendA(word, index);
    }

    public String appendA(String word, int index){
        StringBuilder wordBuilder = new StringBuilder(word);
        while(index > 0){
            wordBuilder.append("a");
            index --;
        }
        word = wordBuilder.toString();

        return word;
    }

    public String wordWithVowel(String word){
        word += "ma";
        return word;
    }

    public String wordWithoutVowel(String word){
        char ch = word.charAt(0);
        word = word.substring(1);
        word = word + ch + "ma";
        return word;
    }

    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'I' || ch == 'E' || ch == 'O' || ch == 'U';
    }
}
