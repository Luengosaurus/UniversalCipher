package com.exfume.luengo.universalcipher;

/**
 * Created by Javier on 19/02/2016.
 */
public class Cipher {

    char[] alphabet;
    public String Result;

    public Cipher(){
        Result = "";
        this.alphabet = new char[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) (i+65);
        }
    }

    public String VigenereC(String Message, String Key){
        Result = "";
        Message = Message.toUpperCase().replaceAll("\\s+","");
        Key = Key.toUpperCase().replaceAll("\\s+","");
        int keyIndex = 0;
        for (int i = 0; i < Message.length(); i++) {
            char letter = Message.charAt(i);
            int letteri = (letter - 65);
            char keyC = Key.charAt(keyIndex);
            int keyCi =  (keyC - 65);
            letteri = (letteri + keyCi);
            letteri = (letteri%26);
            this.Result += alphabet[letteri];
            keyIndex++;
            if (keyIndex >= Key.length()) {
                keyIndex = 0;
            }
        }
        return this.Result;
    }
    public String VigenereD(String Message, String Key){

        Result = "";
        Message = Message.toUpperCase().replaceAll("\\s+","");
        Key = Key.toUpperCase().replaceAll("\\s+","");
        int keyIndex = 0;
        for (int ii = 0; ii < Message.length(); ii++) {
            char letter = Message.charAt(ii);
            int letteri = letter - 65;
            char keyC = Key.charAt(keyIndex);
            int keyCi = (keyC - 65);
            letteri = (letteri - keyCi);
            letteri = (letteri%26);
            this.Result += alphabet[letteri];
            keyIndex++;
            if (keyIndex >= Key.length()) {
                keyIndex = 0;
            }
        }
        return this.Result;
    }
    public String AffineC(String Message, int A, int B){

        Result = "";
        Message = Message.toUpperCase().replaceAll("\\s+","");
        for(int ii = 0;ii < Message.length();ii++){
            char letter =Message.charAt(ii);
            int letteri = letter - 65;
            letteri = (letteri*A) + B;
            letteri = letteri%26;
            this.Result += alphabet[letteri];
        }
        return this.Result;
    }
    public String AffineD(String Message, int A, int B){

        Result = "";
        Message = Message.toUpperCase().replaceAll("\\s+","");
        for(int ii = 0;ii < Message.length();ii++){
            char letter =Message.charAt(ii);
            int letteri = letter - 65;
            letteri = (letteri-B)/A;
            letteri = letteri%26;
            this.Result += alphabet[letteri];
        }
        return this.Result;
    }
}

