package de.projects.janap.a05_kalender;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TermineDatenbankHelfer extends SQLiteOpenHelper {

    public static final String DB_NAME = "termine.db";  //Name der Datenbank
    public static final int DB_VERSION = 1; //Versionsnummer der Datenbank

    public static final String TABLE_GANZTAEGIGE_TERMINE = "ganztaegige_termine";

    public static final String COLUMN_ID = "_id";   //späterer Primärschlüssel
    public static final String COLUMN_TITEL = "titel";  //Spaltenbezeichnung
    public static final String COLUMN_STARTTAG = "starttag";    //Spaltenbezeichnung

    //Datenbankeneigenschaften:
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_GANZTAEGIGE_TERMINE +
                    "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITEL + " TEXT NOT NULL, " +
                    COLUMN_STARTTAG + " INTEGER NOT NULL);";

    public TermineDatenbankHelfer(Context context) {
        super(context, DB_NAME, null, DB_VERSION);  //Konstruktor der Elternklasse (SQLiteOpenHelper)
    }

    // Die onCreate-Methode wird nur aufgerufen, falls die Datenbank noch nicht existiert
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.d("da", "Die Tabelle wird mit SQL-Befehl: " + SQL_CREATE + " angelegt.");
            db.execSQL(SQL_CREATE);
        }
        catch (Exception ex) {
            Log.e("da", "Fehler beim Anlegen der Tabelle: " + ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
