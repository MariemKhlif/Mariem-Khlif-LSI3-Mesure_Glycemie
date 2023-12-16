package com.example.mariemkhliflsi3mesure_glycemie.view;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mariemkhliflsi3mesure_glycemie.R;

public class ConsultActivity extends AppCompatActivity {

    private Button btnReturn;
    private TextView tvReponse ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        init();
        // affichage resultat dans ConsultActivity
        Intent intent=getIntent();
        String reponse=intent.getStringExtra("Reponse");
        tvReponse.setText(reponse);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //
                if(reponse != null)
                    setResult(RESULT_OK,intent);
                else
                    setResult(RESULT_CANCELED ,intent);
                finish();
            }
        });
    }
    private void init()
    {
        btnReturn=(Button) findViewById(R.id.btnReturn);
        tvReponse=(TextView) findViewById(R.id.tvReponse);


    }

}