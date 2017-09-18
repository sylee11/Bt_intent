package com.gameloft.bt_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    TextView et_kq;
    Button btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        et_kq = (TextView)findViewById(R.id.et_kq);
        btn_back = (Button)findViewById(R.id.btn_back);


        Intent callerIntent = getIntent();

        Bundle packBundle = callerIntent.getBundleExtra("My Package");

        final int a = packBundle.getInt("soA");
        final int b = packBundle.getInt("soB");
        final int c = packBundle.getInt("soC");

        giaiPTBH(a, b, c);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent back = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(back);
                Toast.makeText(getApplicationContext(), "Wellcome back to MainActivity !Your last edit text : a= "+ a + "  b= " + b + "  c = " + c , Toast.LENGTH_LONG).show();
            }
        });
    }


    public void giaiPTBH(int a, int b, int c){
    if (a == 0){
        if (b == 0){
            if (c == 0) et_kq.setText("PT co VSN");
            else if (c != 0) et_kq.setText("PT VN");
        }
        else et_kq.setText(String.valueOf((float) -b/a));
    }
    else{
        float denta = b*b-4*a*c;
        if (denta < 0) et_kq.setText("PT VN");
        else if (denta == 0) et_kq.setText(String.valueOf((float) -b/(2*a)));
        else et_kq.setText(String.valueOf((float) ((-b - Math.sqrt(denta))/(2*a)) + "   va  " + ((-b + Math.sqrt(denta))/(2*a))));
    }
}

}
