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

    EditText edNTD;
    TextView us;
    TextView jp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
    }
    private void findview(){
        edNTD = findViewById(R.id.edNTD);
        us = findViewById(R.id.us);
        jp = findViewById(R.id.jp);
    }

    public void NTD_To_US(View view){
        String n = edNTD.getText().toString();
        Boolean nEmpty = n.isEmpty();
        Float NTD = Float.parseFloat(n);
        Float result_jp = NTD*3.56f;
        Float result_us = NTD/30.9f;
        //Confirm empty
        if(nEmpty) {
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount")
                    .setPositiveButton("OK",null)
                    .show();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("JPD is: " + result_jp + "\nUSD is: " + result_us)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            edNTD.setText("");
                        }
                    })
                    .show();
            DecimalFormat df = new DecimalFormat("##0.00");
            us.setText((df.format(result_us)).toString());
            jp.setText((df.format(result_jp)).toString());
        }

    }


}

