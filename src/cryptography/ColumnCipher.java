package cryptography;
import java.util.ArrayList;

/**
 * Created by irisgyq on 2017/2/6.
 */

public class ColumnCipher {
    public String ColumnEncrypt(String plainText, String key) {
        String ColumnCipher = "";
        String FinalKey = "";
        String tmp = "";
        char[] pt = plainText.toCharArray();
        ArrayList<Integer> pos = new ArrayList<>();
        int column = key.length();

        //create an arraylist which saves the text of each column.
        ArrayList<String> cCipher = new ArrayList<>(column);
        for (int IniI = 0; IniI < column; IniI++) {
            cCipher.add("");
        }

        //put texts in each column of arraylist.
        for (int tInt = 0; tInt < plainText.length(); tInt++) {
            for (int col = 0; col < column; col++) {
                if (tInt % column == col) {
                    cCipher.set(col, cCipher.get(col).concat(String.valueOf(plainText.charAt(tInt))));
                }
            }
        }

        //judge key. To observe whether key contains 0, if not, each number minus 1.
        if (!key.contains("0")) {
            for (int keyI = 0; keyI < key.length(); keyI++) {
                int tmpI = Integer.parseInt(String.valueOf(key.toCharArray()[keyI])) - 1;
                tmp = String.valueOf(tmpI);
                FinalKey += tmp;
            }

        } else {
            FinalKey = key;
        }

        //reorder the text
        for (int j = 0; j < FinalKey.length(); j++) {
            for (int keyJ = 0; keyJ < FinalKey.length(); keyJ++) {
                if (String.valueOf(FinalKey.charAt(keyJ)).equals(String.valueOf(j))) {
                    pos.add(keyJ);
                    break;
                }
            }
        }

        //output the cipher
        for (int k = 0; k < column; k++) {
            ColumnCipher += cCipher.get(pos.get(k));
        }
        return ColumnCipher;

    }
}
