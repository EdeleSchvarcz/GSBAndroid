package comee.example.binyamin.gsbapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class SQLHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "GSB.db";
    private static final String DB_TABLE = "Users_Tablefrais";
    private static final String ID = "ID";
    private static final String TypeFrais = "TypeFrais";
    private static final String Libelle = "Libelle ";
    private static final String Quantite = "Quantite ";
    private static final String Montant = "Montant ";
    private static final String DateFrais = "DateFrais";
    private static final String DateSaisie = "DateSaisie";
    private SQLHelper maBDDHelper;
    private SQLiteDatabase maBDD;
    private  Context monContexte;


    // private static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE +" ("+ ID + " INTE GER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT" + ")";
    private static final String CREATE_TABLE = "CREATE TABLE Users_tableFrais (ID INTEGER PRIMARY KEY AUTOINCREMENT, TypeFrais TEXT, Libelle TEXT, Quantite Integer, Montant Float, DateFrais Text ,DateSaisie  DATETIME DEFAULT CURRENT_TIMESTAMP)";
    private ContentValues contentValues;

    public SQLHelper(FraisHorsForfait context) {
        super(context, DB_NAME, null, 1);
    }

    public SQLHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.monContexte = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.w(TAG, CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String typeFrais1, Integer quantite1, String dateFrais1,String DateSaisie1, Double montant1, String libelle) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TypeFrais, typeFrais1);
        contentValues.put(Quantite, quantite1);
        contentValues.put(Montant, montant1);
        contentValues.put(DateFrais, dateFrais1);
        contentValues.put(DateSaisie, DateSaisie1);
        contentValues.put(Libelle, libelle);
        long result = db.insert(DB_TABLE, null, contentValues);
        return result != -1;
    }
        public Cursor viewData() {
            SQLiteDatabase db = this.getReadableDatabase();
            String query = "select * from " + DB_TABLE;
            Cursor pointeur = db.rawQuery(query, null);
            return pointeur;

        }
        /*Suppression d'une ligne
            *@param ID de type Integer
*/
    public boolean deleteData(Integer ID1) {
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(DB_TABLE, "ID=" + ID1, null);

        return result != -1;
    }

        public Cursor fetchAllFrais() {

            Cursor curseur = maBDD.query(DB_TABLE, new String[] {"rowid _id", ID, TypeFrais, Libelle,
                            Quantite, Montant, DateFrais, DateSaisie },
                    null, null, null, null, null, null);

            if (curseur != null) {
                curseur.moveToFirst();
            }
            return curseur;
        }





    public SQLHelper open() throws SQLException {
        maBDDHelper = new SQLHelper(monContexte);
        maBDD = maBDDHelper.getWritableDatabase();
        return this;
    }


    public void close() {
        if (maBDDHelper != null) {
            maBDDHelper.close();
        }
    }

}