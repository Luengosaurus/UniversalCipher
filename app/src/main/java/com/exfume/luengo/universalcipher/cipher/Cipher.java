package com.exfume.luengo.universalcipher.cipher;

/**
 * Created by Benjamin on 03/05/2016.
 */
public abstract class Cipher implements CipherInterface {

    char[] alphabet;
    String text;
    int mod;

    public Cipher(){
        this.alphabet = new char[26];
        this.mod = 26;
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) (i+65);
        }
    }

    public Cipher(String text){
        this.alphabet = new char[26];
        this.mod = 26;
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) (i+65);
        }
        setText(text);
    }

    public void setText(String text) {
        this.text = text.toUpperCase().replaceAll("\\s+","");
    }
    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
        this.mod = alphabet.length;
    }
}
