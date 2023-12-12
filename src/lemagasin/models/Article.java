/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lemagasin.models;

import java.text.DecimalFormat;

/**
 * logus EMF Fribourg Suisse $(name)
 *
 * Description
 *
 * @author waeberla
 * @version $(1.0)
 * @date : $(date)
 */
public class Article {

    public static final String SEPARATOR = "\t";
    
    public static final String PATTERNPRIX = "##,##0.00 CHF";

    /**
     * Constructeur de Article. Ce constructeur reçoit ces deux paramètres et 
     * les sauvegarde dans ces attributs.
     * @param genre : String le genre de l'article
     * @param prix : double le prix unitaire de l'article.
     */
    public Article(String genre, double prix) {
        this.genre = genre;
        this.prix = prix;
    }

    /**
     * Cette méthode transforme en String un article. Pour ce faire elle concatène
     * ces attributs genre et prix en y insérant un SEPARATOR (Constante déclarée ci-dessus).
     * @return String une représentation textuelle du bean.
     */
    @Override
    public String toString() {
        DecimalFormat formateur = new DecimalFormat(PATTERNPRIX);
        String prixUnitaire = formateur.format(prix);
        String info = genre + SEPARATOR + prixUnitaire;
        return info;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    private String genre;
    private double prix;
}
