package com.exfume.luengo.universalcipher.ciphers;


public class Vigenere extends Cipher {

    String key;

    public Vigenere(){

    }

    public Vigenere(String text , String key){
        setText(text);
        this.key = key.toUpperCase().replaceAll("\\s+","");
    }

    public void setParams(String text, String key){
        setText(text);
        this.key = key.toUpperCase().replaceAll("\\s+","");
    }

    @Override
    public String Cipher() {
        String result = "";
        int keyIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            int letteri = (letter - 65);
            char keyC = key.charAt(keyIndex);
            int keyCi =  (keyC - 65);
            letteri = (letteri + keyCi);
            letteri = (letteri%mod);
            result += alphabet[letteri];
            keyIndex++;
            if (keyIndex >= key.length()) {
                keyIndex = 0;
            }
        }
        return result;
    }

    @Override
    public String Decipher() {
        String Result = "";
        int keyIndex = 0;
        for (int ii = 0; ii < text.length(); ii++) {
            char letter = text.charAt(ii);
            int letteri = letter - 65;
            char keyC = key.charAt(keyIndex);
            int keyCi = (keyC - 65);
            letteri = (letteri - keyCi);
            letteri = (letteri%mod);
            if (letteri < 0){
                letteri += 26;
            }
            Result += alphabet[letteri];
            keyIndex++;
            if (keyIndex >= key.length()) {
                keyIndex = 0;
            }
        }
        return Result;
    }
}
