package cryptography;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by irisgyq on 2017/2/6.
 */

public class SubstitutionCipher {
    public String SubstitutionEncrypt(String plainText, String key) {
        String SubCipher = "";
        ArrayList<Integer> codeForP = new ArrayList<>();

        //Use hashmap to save the code of each character, from 0-25
        HashMap<Character, Integer> alphabet = new HashMap<Character, Integer>(26){{
            put('a',0);
            put('b',1);
            put('c',2);
            put('d',3);
            put('e',4);
            put('f',5);
            put('g',6);
            put('h',7);
            put('i',8);
            put('j',9);
            put('k',10);
            put('l',11);
            put('m',12);
            put('n',13);
            put('o',14);
            put('p',15);
            put('q',16);
            put('r',17);
            put('s',18);
            put('t',19);
            put('u',20);
            put('v',21);
            put('w',22);
            put('x',23);
            put('y',24);
            put('z',25);
        }};

        //Encode the plaintext using numbers in hashmap
        for(int intT =0;intT<plainText.length();intT++) {
            codeForP.add(alphabet.get(plainText.charAt(intT)));
        }

        //Encrypt the plaintext using numbers in hashmap
        for(int intC=0;intC<codeForP.size();intC++) {
            codeForP.set(intC,(codeForP.get(intC)+Integer.parseInt(key))%26);
        }

        //Encrypt the plaintext by changing the numbers into characters
        for(int posC=0; posC<codeForP.size();posC++) {
            for(char c:alphabet.keySet()) {
                if(alphabet.get(c).equals(codeForP.get(posC))) {
                    SubCipher+=String.valueOf(c);
                }
            }
        }

        return SubCipher;
    }
}
