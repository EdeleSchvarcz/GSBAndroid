package comee.example.binyamin.gsbapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class FraisHorsForfait extends AppCompatActivity {

    //  SQLHelper BDD;
    EditText Date;
    EditText Libelle;
    EditText Montant;
    DatePickerDialog picker;


    SQLHelper BDD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frais_hors_forfait);
        BDD = new SQLHelper(this);
        Libelle = findViewById(R.id.libelle);
        Montant = findViewById(R.id.montant);
        Date = findViewById(R.id.date);


    }

    public void save_DATA(View view) {
        String Libelle1 = Libelle.getText().toString();
        double Montant1 = Float.parseFloat(Montant.getText().toString());
        String Date1 = Date.getText().toString();
        if (BDD.insertData(null, null, Date1, Montant1, Libelle1)) {
            Libelle.setText("");
            Montant.setText("");
            Date.setText(" ");
            Toast.makeText(FraisHorsForfait.this, "Frais enregistré", Toast.LENGTH_LONG).show();

        }

    }

    public void picker(View vv) {
        picker = new DatePickerDialog(FraisHorsForfait.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, 2000, 05, 10);
        picker.show();

    }
}




