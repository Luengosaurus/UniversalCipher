package com.exfume.luengo.universalcipher.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.exfume.luengo.universalcipher.model.Key;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;


public class FileManager {

    private Context context;

    public FileManager(Context context){
        this.context = context;
    }

    public Key saveFile(String filename, byte[] contents ){
        File myDir = context.getFilesDir();
        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(contents);
            outputStream.close();
            return new Key(filename,getFileExt(filename),contents,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    public ArrayList<Key> getKeys(final String extension){
        File myDir = context.getFilesDir();
        FilenameFilter fileFilter = new FilenameFilter() {
            File f;
            public boolean accept(File dir, String name) {
                if(name.endsWith("."+extension)) {
                    return true;
                }
                f = new File(dir.getAbsolutePath()+"/"+name);

                return f.isDirectory();
            }
        };

        File files[] = myDir.listFiles(fileFilter);
        ArrayList<Key> keys = new ArrayList<>();
        for (int i = 1; i < files.length; i++) {
            File file = files[i];
            String name = file.getName();
            String ext = getFileExt(file.getName());
            byte[] contents = loadFile(file);
            Key key = new Key(name,ext,contents,file);
            keys.add(key);
        }
        return keys;
    }




    @NonNull
    public static String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
    }


    public byte[] loadFile(File file) {
        try {
            BufferedInputStream keyStream = new BufferedInputStream(new FileInputStream(file));
            int len = keyStream.available();
            byte[] keyHex = new byte[len];
            keyStream.read(keyHex, 0, len);
            return keyHex;
        } catch (Exception e) {
            return null;
        }
    }

}
