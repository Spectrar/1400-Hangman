package HangMan;

import java.util.ArrayList;

public class HangmanPhrase {

    /**
     *
     * @param category
     * @param difficulty
     * @return
     */
    public static String getPhrase(String category, String difficulty) {
        String phrase;

        phrase = DBConnect.getPhrase(category, difficulty);

        return phrase;

    }

    /**
     *
     * @param phrase
     * @return
     */
    public static ArrayList convertStrToArrayList(String phrase) {
        char[] _str = phrase.toCharArray();
        ArrayList<Character> _arr = new ArrayList<Character>();
        for (char c : _str) {
            _arr.add(c);
        }
        return _arr;

    }

    public static String convertStr(ArrayList<Character> word) {
        String strWord = "";
        int iLen = 0;
        for (Character elt : word) {
            if ( iLen > 7 && elt==' ')
            {
                strWord += "\n";
                iLen = 0;
            }
            else
                strWord += elt.toString()+" ";
            iLen++;
        }

        return strWord;
    }

}
