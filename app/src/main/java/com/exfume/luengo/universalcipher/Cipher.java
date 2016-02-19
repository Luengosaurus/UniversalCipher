package com.exfume.luengo.universalcipher;

/**
 * Created by Javier on 19/02/2016.
 */
public class Cipher {

    private String text;
    private String key;
    char[] alphabet;
    public Cipher(String text, String key){
        new Cipher();
        this.text = text.toUpperCase();
        this.key = key.toUpperCase();

    }
    public Cipher(){
        this.alphabet = new char[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) (i+65);
        }
    }

    public void setText(String text){
        this.text = text.toUpperCase();
    }
    public void setKey(String key){
        this.key = key.toUpperCase();
    }
    public String Vigenere(){
        String result = "";
        int keyIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            int letteri = letter - 65;
            char keyC = key.charAt(keyIndex);
            int keyCi =  (keyC -65);
            letteri = (letteri + keyCi);
            letteri = (letteri%26);
            result += alphabet[letteri];
            keyIndex++;
            if (keyIndex >= key.length()) {
                keyIndex = 0;
            }
        }
        return result;
    }

}

