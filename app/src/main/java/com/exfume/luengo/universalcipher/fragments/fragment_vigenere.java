package com.exfume.luengo.universalcipher.fragments;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.exfume.luengo.universalcipher.Cipher;
import com.exfume.luengo.universalcipher.R;

/**
 * Created by Benjamin on 19/02/2016.
 */
public class fragment_vigenere extends Fragment {

    private Button mButton;
    private TextInputLayout mMessage;
    private TextInputLayout mKey;
    private TextView result;
    private Cipher cipher;

    public fragment_vigenere(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vigenere_cipher, container, false);
        cipher = new Cipher();
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
            cipher.VigenereC(mMessage.getEditText().getText().toString(),mKey.getEditText().getText().toString());
            result.setText(cipher.Result);
        }
        catch (Exception e){
            result.setText(e.getMessage());
        }
    }

}
