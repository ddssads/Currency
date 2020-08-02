package com.home.currency;

import java.text.DecimalFormat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ntd;
    TextView us;
    TextView jp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
    }
    private void findview(){
        ntd = findViewById(R.id.ntd);
        us = findViewById(R.id.us);
        jp = findViewById(R.id.jp);
    }

    public void NTD_To_US(View view){
        String n = ntd.getText().toString();
        Boolean nEmpty = n.isEmpty();
        //Confirm empty
        if(nEmpty) {
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount")
                    .setPositiveButton("OK",null)
                    .show();
        }else {
            Float _ntd = Float.parseFloat(n);
            Float result_jp = _ntd*3.56f;
            Float result_us = _ntd/30.9f;
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("JPD is: " + result_jp + "\nUSD is: " + result_us)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ntd.setText("");
                        }
                    })
                    .show();
            DecimalFormat df = new DecimalFormat("##0.00");
            us.setText((df.format(result_us)).toString());
            jp.setText((df.format(result_jp)).toString());
        }

    }


}

