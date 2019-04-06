package de.projects.janap.a05_kalender;

import android.content.Context;
import android.graphics.Color;
import android.nfc.Tag;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class Kalender_Adapter extends ArrayAdapter<Calendar> {

    //Darstellung eines Monats
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Attribute
    private LayoutInflater inflater;
    private Kalender_GUI strg;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Konstruktor
    public Kalender_Adapter(Context pContext, ArrayList<Calendar> pTage, Kalender_GUI pStrg){
        super(pContext, R.layout.zelle_aktueller_monat, pTage);
        inflater = LayoutInflater.from(pContext);
        strg = pStrg;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Methoden

    @Override
    public View getView(int position, View view, ViewGroup parent){
        try {
            Calendar tag = getItem(position);    //Aus dem Array der diesen Monat mit den jeweiligen Tagen beschreibt

            //wenn covertView = 0 ist, wird eine neue Zelle festgelegt
            if (view == null) {
                view = inflater.inflate(R.layout.zelle_aktueller_monat, parent, false);
            }

            TextView textView = view.findViewById(R.id.textview_tag);
            textView.setText(String.valueOf(tag.get(Calendar.DAY_OF_MONTH)));  //Das TextView bekommt die Zahl des jeweiligen Tages (tag weiß den Tag des Monats, durch Festlegung in der KalenderSteuerung) zugeteilt

            //Überprüfung ob es sich um den heutigen Tag handelt
            if ((tag.get(Calendar.DAY_OF_MONTH) == Kalender_Steuerung.heute.get(Calendar.DAY_OF_MONTH))
                    && (tag.get(Calendar.MONTH) == Kalender_Steuerung.heute.get(Calendar.MONTH))
                    && (tag.get(Calendar.YEAR) == Kalender_Steuerung.heute.get(Calendar.YEAR))) {
                String aktuelleFarbedesMonats = Kalender_Steuerung.FARBEN[Kalender_Steuerung.kalender.get(Calendar.MONTH)];
                textView.setTextColor(Color.parseColor(aktuelleFarbedesMonats));  //beim heutigen Tag soll es eingefärbt werden
            }

            //Überprüfung ob es Termine an diesem Tag gibt
            /*for (int i = 0; i < Kalender_Steuerung.termine.size(); i++) {
                if ((tag.getTagImMonat() == Kalender_Steuerung.termine.get(i).getStartTagImMonat())
                        && (tag.getInWelchemMonat()-1 == Kalender_Steuerung.termine.get(i).getStartTagInWelchemMonat()-1)
                        && (tag.getInWelchemJahr() == Kalender_Steuerung.termine.get(i).getStartTagInWelchemJahr())) {
                    textView.setTextColor(Color.parseColor("#960000"));  //bei einem Termin soll es eingefärbt werden
                }
            }*/

        return view;

    } catch (Exception e) {
        e.printStackTrace();
    }

     return view;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Ende der Klasse
}
