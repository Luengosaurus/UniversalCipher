package com.exfume.luengo.universalcipher.fragments;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.exfume.luengo.universalcipher.R;
import com.exfume.luengo.universalcipher.ciphers.Vigenere;

/**
 * Created by Benjamin on 23/02/2016.
 */
public class vigenere_decipher extends Fragment {

    private Button mButton;
    private TextInputLayout mMessage;
    private TextInputLayout mKey;
    private TextView result;
    private Vigenere cipher;

    public vigenere_decipher(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vigenere_cipher, container, false);
        mButton = (Button) view.findViewById(R.id.submit);
        mMessage = (TextInputLayout) view.findViewById(R.id.mMessage);
        mKey = (TextInputLayout) view.findViewById(R.id.mKey);
        result = (TextView) view.findViewById(R.id.mResult);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vigenere();
            }
        });
        return view;
    }

    private void Vigenere(){
        try {
            String text = mMessage.getEditText().getText().toString();
            String key = mKey.getEditText().getText().toString();
            if (cipher == null){
                cipher = new Vigenere(text,key);
            }else{
                cipher.setParams(text,key);
            }
            result.setText(cipher.Decipher());
        }
        catch (Exception e){
            result.setText(e.getMessage());
            Log.e("UCipher" , "error",e );
        }
    }
}
