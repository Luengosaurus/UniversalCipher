package com.exfume.luengo.universalcipher;

import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button Submit;
    private EditText Message;
    private EditText Key;
    private Cipher Cipher;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Submit = (Button) findViewById(R.id.submit);
        Message = (EditText) findViewById(R.id.message);
        Key = (EditText) findViewById(R.id.key);
        Cipher = new Cipher();
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vigenere();

            }
        });


    }

    public void Vigenere(){

        TextView result = (TextView) findViewById(R.id.result);
        try {
            Cipher.setKey(Key.getText().toString());
            Log.i("VIGENERE", Message.getText().toString());
            Cipher.setText(Message.getText().toString());
            Log.i("VIGKEY", Key.getText().toString());
            Log.i("VIGRESULT", Cipher.Vigenere());
            result.setText(Cipher.Vigenere());


        }
        catch (Exception e){
            result.setText("Fill everthing, biatch");
            Message.setHighlightColor(0xFFFF33);
        }


    }
}
