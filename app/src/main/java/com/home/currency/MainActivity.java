package com.home.currency;

import java.text.DecimalFormat;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                    .setTitle(R.string.problem)
                    .setMessage(R.string.plz_enter_NTD)
                    .setPositiveButton(R.string.ok,null)
                    .show();
        }else {
            Float _ntd = Float.parseFloat(n);
            Float result_jp = _ntd*3.56f;
            Float result_us = _ntd/30.9f;
            Toast.makeText(this,getString(R.string.jpd_is) + result_jp + "\n" + getString(R.string.usd_is) + result_us,
                    Toast.LENGTH_LONG).show();
            new AlertDialog.Builder(this)
                    .setTitle(R.string.result)
                    .setMessage(getString(R.string.jpd_is) + result_jp + "\n" + getString(R.string.usd_is) + result_us)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
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

