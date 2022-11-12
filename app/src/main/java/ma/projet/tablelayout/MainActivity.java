package ma.projet.tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText poids,Taille;
    RadioButton m,cm;
    CheckBox mf;
    Button calc,amn;
    TextView res;
    double tailleEnM;

    boolean allowed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layout);

        poids=findViewById(R.id.poids);
        Taille=findViewById(R.id.Taille);
        m=findViewById(R.id.m);
        cm=findViewById(R.id.cm);
        mf=findViewById(R.id.mf);
        calc=findViewById(R.id.calc);
        amn=findViewById(R.id.amn);
        res=findViewById(R.id.res);

       calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float p=Float.parseFloat(poids.getText().toString());
                float t=Float.parseFloat(Taille.getText().toString());
                res.setText(p/t+" kg/m²");
            }

        });
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcule();
            }
        });
      amn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              poids.setText("");
              Taille.setText("");
              res.setText("Vous denes cliquer sur le bouton Calculer l'IMCpour obtenir un résultat.");
          }
      });



    }
    public void isRadioActive(View view){
        Boolean checked = ((RadioButton)(view)).isChecked();

        switch (view.getId()){
            case R.id.cm:
                if(checked){
                    tailleEnM = Float.parseFloat(Taille.getText().toString()) * Math.pow(10,-2);
                }
                break;

            case R.id.m:
                if(checked){
                    tailleEnM = Float.parseFloat(Taille.getText().toString());
                }
                break;
        }
        allowed = true;
    }
    void calcule(){
        if(Integer.parseInt(poids.getText().toString()) == 0 || !allowed || Float.parseFloat(Taille.getText().toString()) == 0){
            Toast.makeText(this, "les champ doit etre non null", Toast.LENGTH_SHORT).show();
        }else{


            res.setText(String.valueOf( Integer.parseInt(poids.getText().toString()) / (tailleEnM*tailleEnM)));

        }

    }

}