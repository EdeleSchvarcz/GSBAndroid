package comee.example.binyamin.gsbapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //declaration des variables
    Button btnFF,btnFHF,btnSYN,btnENV,btnPARAM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void afficherMessage(String titre ,String message){
        AlertDialog.Builder Builder = new AlertDialog.Builder(this) ;
        Builder.setCancelable(true) ;
        Builder.setTitle(titre) ;
        Builder.setMessage(message) ;
        Builder.show() ;
    }
    //methode qui va initialiser les variables et les relier aux objets graphiques
    public void init(){
        btnFF=findViewById(R.id.btnFF);
        btnFHF=findViewById(R.id.btnFHF);
        btnSYN=findViewById(R.id.btnSYN);
        btnENV=findViewById(R.id.btnENV);
        btnPARAM=findViewById(R.id.btnPARAM);
        btnFF.setOnClickListener(this);
        btnFHF.setOnClickListener(this);
        btnSYN.setOnClickListener(this);
        btnENV.setOnClickListener(this);
        btnPARAM.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view. getId()){
                case R.id.btnFF:
                    Intent intent=new Intent(getApplicationContext(),FraisForfait.class);
                    startActivity(intent);
                    break;
                case R.id.btnFHF:
                    Intent intent1=new Intent(getApplicationContext(),FraisHorsForfait.class);
                    startActivity(intent1);
                    break;
                case R.id.btnSYN:
                    Intent intent2=new Intent(getApplicationContext(),SyntheseDuMois.class);
                    startActivity(intent2);
                    break;
                case R.id.btnENV:
                    Intent intent3=new Intent(getApplicationContext(),EnvoiDesDonneesVers.class);
                    startActivity(intent3);
                    break;
                case R.id.btnPARAM:
                    Intent intent4=new Intent(getApplicationContext(),Parametres.class);
                    startActivity(intent4);
                    break;
            case R.id.retour:
                finish();
                break;
        }

    }
}
