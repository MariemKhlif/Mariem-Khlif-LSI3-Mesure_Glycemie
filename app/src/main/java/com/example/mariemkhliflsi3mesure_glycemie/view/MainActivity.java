package com.example.mariemkhliflsi3mesure_glycemie.view;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.mariemkhliflsi3mesure_glycemie.R;
import com.example.mariemkhliflsi3mesure_glycemie.controller.Controller;
public class MainActivity extends AppCompatActivity {
    private SeekBar sbAge;
    private RadioButton  rboui ,rbnon;
    private EditText etValuer;
    private Button btnconsulter;
    private TextView tvAge,tvResultat;
    private Controller controller =Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //listener SeekBar
        sbAge.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        Log.i("Information","onProgressChanged"+i);
                        tvAge.setText("Votre Age:" +i);}
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {}
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {}
                }
        );
        btnconsulter.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             //controle de saisir

                                             int age;
                                             float valeur_mesuree;
                                             boolean verifAge = false ;
                                             boolean verifValeur =false ;
                                             if(sbAge.getProgress()!=0)
                                                 verifAge=true;
                                             else
                                                 Toast.makeText(MainActivity.this,"Veuillez verifier votre age ",Toast.LENGTH_SHORT).show();
                                             if (!etValuer.getText().toString().isEmpty())
                                                 verifValeur= true;
                                             else
                                                 Toast.makeText(MainActivity.this,"Veuillez verifier la valeur mesurée",Toast.LENGTH_SHORT).show();
                                             if (verifAge && verifValeur) {
                                                 age = sbAge.getProgress();
                                                 valeur_mesuree = Float.valueOf(etValuer.getText().toString());
                                                 boolean isFasting = rboui.isChecked();
                                                 //user action view-->controller
                                                 controller.createPatient(age,valeur_mesuree,isFasting);
                                             }
                                         }
                                     }
     );
     }
    public void init (){
    etValuer=(EditText) findViewById(R.id.etValuer) ;
    sbAge=(SeekBar)findViewById(R.id.sbAge);
    rboui=(RadioButton)findViewById(R.id.rboui);
    rbnon=(RadioButton)findViewById(R.id.rbnon);
    btnconsulter=(Button)findViewById(R.id.btnconsulter);
    tvAge=(TextView)findViewById(R.id.tvAge);
    tvResultat=(TextView)findViewById(R.id.tvResultat);}}








