package comee.example.binyamin.gsbapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class FraisForfait extends AppCompatActivity  {
    //declaration des variables
    Spinner listederoulante;
    EditText txtQuantite;
    Button btnAjouter, btnModifier, btnSupprimer;
    SQLHelper BDD;
    TextView dateFrais;
    DatePickerDialog picker;
    Calendar calendrier = Calendar.getInstance();
    int aaaa= calendrier.get(Calendar.YEAR);
    int mm= calendrier.get(Calendar.MONTH);
    int jj= calendrier.get(Calendar.DAY_OF_MONTH);


    // Tableau montant des frais au forfait
    Double montantFrais[] = new Double[]{0.0,110.00, 0.62, 80.00, 25.00};
    //String typeFrais[] = new String[]{"ForfaitKm", "Forfaitétape", "ForfaitHotel", "ForfaitRestaurant"};public void afficherMessage(String titre ,String message){
    public void afficherMessage(String titre ,String message){
        AlertDialog.Builder Builder = new AlertDialog.Builder(this) ;
        Builder.setCancelable(true) ;
        Builder.setTitle(titre) ;
        Builder.setMessage(message) ;
        Builder.show() ;
    }

    //constructeur
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frais_forfait);
        init();
        BDD = new SQLHelper(this);
    }

    //initialisation des variables
    public void init() {
        listederoulante = findViewById(R.id.listederoulante);
        txtQuantite = findViewById(R.id.txtQuantite);
        btnAjouter = findViewById(R.id.btnAjouter);
        dateFrais=findViewById(R.id.txtDateFrais);

    }

    public void clique_btn(View view) {
        finish();

    }

    public void MonClick(View view) {
        switch (view.getId()) {
            case R.id.btnAjouter:
                String typeselectionner = listederoulante.getSelectedItem().toString();
                String MaDate = dateFrais.getText().toString();
                Integer quantite = Integer.parseInt("0"+txtQuantite.getText().toString());
                Integer position=listederoulante.getSelectedItemPosition();
                Double montant = quantite * montantFrais[position];
                if (txtQuantite.getText().toString().trim().length() == 0 || typeselectionner.length()==0 || MaDate.length()==0) { // si rien dans txtQTE
                    afficherMessage("ERREUR", "Champ vide");
                    return;

                 }else if(Integer.parseInt(txtQuantite.getText().toString())<1){
                         afficherMessage("ERREUR", "Quantité invalide");
                         return;
                     }else{
                        if(BDD.insertData(typeselectionner, quantite, MaDate, montant, typeselectionner)){
                            afficherMessage("succes", "valeur ajoutée" );
                            return;
                        }
                }
                        break;
                }

        }
    public void picker(View vv)
    {
        picker = new DatePickerDialog(FraisForfait.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                      dateFrais.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                },aaaa,mm,jj);
        picker.show();
    }

}
