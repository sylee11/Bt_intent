package com.gameloft.bt_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText eta, etb, etc;
    Button butkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Pattern pattern = Pattern.compile(".*[^0-9].*");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eta = (EditText)findViewById(R.id.eta);
        etb = (EditText)findViewById(R.id.etb);
        etc = (EditText)findViewById(R.id.etc);
        butkq = (Button)findViewById(R.id.butkq);
        butkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                try {
                    int a = Integer.parseInt(eta.getText().toString());
                    int b = Integer.parseInt(etb.getText().toString());
                    int c = Integer.parseInt(etc.getText().toString());

                    Bundle bundle = new Bundle();
                    bundle.putInt("soA", a);
                    bundle.putInt("soB", b);
                    bundle.putInt("soC", c);

                    myIntent.putExtra("My Package", bundle);
                   startActivity(myIntent);
                }catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Fail : Vui long nhap number ",Toast.LENGTH_LONG).show();
               }

            }
        });

    }



}
