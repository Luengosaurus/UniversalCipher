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
 * Created by Javier on 25/02/2016.
 */
public class affine_decipher extends Fragment{
    private Button mButton;
    private TextInputLayout mMessage;
    private TextInputLayout mA;
    private TextInputLayout mB;
    private TextView result;
    private Cipher cipher;

    public affine_decipher(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.affine_cipher, container, false);
        cipher = new Cipher();
        mButton = (Button) view.findViewById(R.id.aSubmit);
        mMessage = (TextInputLayout) view.findViewById(R.id.mMessage);
        mA = (TextInputLayout) view.findViewById(R.id.mA);
        mB = (TextInputLayout) view.findViewById(R.id.mB);
        result = (TextView) view.findViewById(R.id.aResult);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Affine();
            }
        });
        return view;
    }


    private void Affine(){
        int a = Integer.parseInt(mA.getEditText().getText().toString());
        int b = Integer.parseInt(mB.getEditText().getText().toString());
        try{
            cipher.AffineD(mMessage.getEditText().getText().toString(), a, b);
            result.setText(cipher.Result);
        }
        catch (Exception e) {
            result.setText(e.getMessage());
        }
    }

}
