package de.projects.janap.a05_kalender;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TermineDataSource {

    private SQLiteDatabase database;
    private TermineDatenbankHelfer dbHelfer;


    public TermineDataSource(Context pContext) {
        dbHelfer = new TermineDatenbankHelfer(pContext);
    }

    public void open() {
        Log.d("da", "Eine Referenz auf die Datenbank wird jetzt angefragt.");
        database = dbHelfer.getWritableDatabase();
        Log.d("da", "Datenbank-Referenz erhalten. Pfad zur Datenbank: " + database.getPath());
    }

    public void close() {
        dbHelfer.close();
        Log.d("da", "Datenbank mit Hilfe des DbHelfers geschlossen.");
    }
}
