package comee.example.binyamin.gsbapplication;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class Outils  extends AppCompatActivity {
    EditText dateFrais;
    DatePickerDialog picker;
    Calendar calendrier = Calendar.getInstance();
    int aaaa = calendrier.get(Calendar.YEAR);
    int mm = calendrier.get(Calendar.MONTH);
    int jj = calendrier.get(Calendar.DAY_OF_MONTH);



    public void picker(View vv) {
        picker = new DatePickerDialog(Outils.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dateFrais.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, aaaa, mm, jj);
        picker.show();


    }





















}
