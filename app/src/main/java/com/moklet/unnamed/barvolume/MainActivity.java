package com.moklet.unnamed.barvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final  String STATE_HASIL = "state_hasil";

    private EditText edtLbr, edtPjg, edtTg;
    private Button btnHitung;
    private TextView txResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtLbr = (EditText) findViewById(R.id.edt_lbr);
        edtPjg = (EditText) findViewById(R.id.edt_pnjg);
        edtTg = (EditText) findViewById(R.id.edt_tg);
        btnHitung = (Button) findViewById(R.id.hitung);
        txResult = (TextView) findViewById(R.id.hasil);
        btnHitung.setOnClickListener(this);

        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            txResult.setText(hasil);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.hitung) {
            String panjang = edtPjg.getText().toString().trim();
            String lebar = edtLbr.getText().toString().trim();
            String tinggi = edtTg.getText().toString().trim();
            boolean cek = false;
            if (TextUtils.isEmpty(panjang)) {
                cek = true;
                edtPjg.setError("Isinen talah");
            }
            if (TextUtils.isEmpty(lebar)) {
                cek = true;
                edtLbr.setError("Isinen talah");
            }
            if (TextUtils.isEmpty(tinggi)) {
                cek = true;
                edtTg.setError("Isinen talah");
            }
            if (!cek){
                double p =Double.parseDouble(panjang);
                double l =Double.parseDouble(lebar);
                double t =Double.parseDouble(tinggi);
                double volume = p * l * t;
                txResult.setText(String.valueOf(volume));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(STATE_HASIL, txResult.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
