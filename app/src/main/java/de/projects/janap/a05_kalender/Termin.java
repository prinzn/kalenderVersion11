package de.projects.janap.a05_kalender;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Termin {
    public static long LETZTE_ID = 0;
    private long id;

    protected Boolean ganztaegig;
    protected String titel;
    private Calendar start, ende;

    private SimpleDateFormat datumFormat = new SimpleDateFormat("dd.MM.yyyy");
    private SimpleDateFormat zeitFormat = new SimpleDateFormat("HH:mm");

    public long getId() {
        return id;
    }
    public String getTitel() {
        return titel;
    }

    public Termin(long pId, String pTitel, Calendar pStart, Calendar pEnde, Boolean pGanztaegig) {
        id = pId;
        LETZTE_ID ++;
        titel = pTitel;
        start = pStart;
        ende = pEnde;
        ganztaegig  = pGanztaegig;
    }

    @Override
    public String toString(){
        String ausgabe =    titel + " findet am " +
                            datumFormat.format(start.getTime()) + " um " +
                            zeitFormat.format(start.getTime())  + " bis " +
                            datumFormat.format(ende.getTime()) + " um zum " +
                            zeitFormat.format(ende.getTime())  + " statt. ";

        return ausgabe;
    }

}
