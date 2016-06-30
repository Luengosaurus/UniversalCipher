package com.exfume.luengo.universalcipher.cipher;


public class Affine extends Cipher {

    int a;
    int b;

    public Affine(){

    }
    public Affine(String text, int a, int b){
        this.a = a;
        this.b = b;
        setText(text);
    }

    public void setParams(String text,int a,int b){
        setText(text);
        this.a = a;
        this.b = b;
    }

    @Override
    public String Cipher() {
        String Result = "";
        for(int ii = 0;ii < text.length();ii++){
            char letter  = text.charAt(ii);
            int letteri = letter - 65;
            letteri = (letteri*a) + b;
            letteri = letteri%mod;
            Result += alphabet[letteri];
        }
        return Result;
    }

    @Override
    public String Decipher() {
        String Result = "";
        for(int ii = 0;ii < text.length();ii++){
            char letter = text.charAt(ii);
            int letteri = letter - 65;
            letteri = (letteri-b)/a;
            letteri = letteri%mod;
            if (letteri < 0){
                letteri += 26;
            }
            Result += alphabet[letteri];
        }
        return Result;
    }
}
