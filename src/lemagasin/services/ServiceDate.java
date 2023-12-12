package lemagasin.services;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Service de l'application LeMagasin. Cette classe permet de donner la date
 * dans un format bien spécifique.
 * 
 * @author Mario Ramalho
 * @version 1.0.0
 */
public class ServiceDate {

    /**
     * Constante représentant le pattern dans lequel la date sera affichée.
     */
    public static final String PATTERNDATE = "dd-MMMM-yyyy hh:mm:ss";

    /**
     * Cette méthode donne la date courante. Elle prend la date du système,
     * crée un simpleDateFormat en lui passant le PATTERNDATE (Constante) en
     * argument
     * puis elle format la date saisie avec le formateur (instance de
     * SimpleDateFormat).
     * 
     * @return la date du jour (date courante) formatée en fonction du PATTERDATE.
     */
    public String donneDateCourante() {
        Date now = new Date();
        SimpleDateFormat formateur = new SimpleDateFormat(PATTERNDATE);
        String laDate = formateur.format(now);
        return laDate;
    }
}
