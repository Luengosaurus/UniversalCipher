package com.exfume.luengo.universalcipher.model;


import java.io.File;

public class Key {

    String name;
    String extension;
    byte[] contents;
    File file;


    public Key(String name, String extension, byte[] contents,File file) {
        this.name = name;
        this.extension = extension;
        this.contents = contents;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public byte[] getContents() {
        return contents;
    }


    public void delete(){
        file.delete();
    }
}
