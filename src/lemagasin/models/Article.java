package lemagasin.models;

import java.text.DecimalFormat;

/**
 * Modèle de l'application LeMagasin. Cette classe représente un article.
 * 
 * @author Mario Ramalho
 * @version 1.0.0
 */
public class Article {

    public static final String SEPARATOR = "\t";

    public static final String PATTERNPRIX = "##,##0.00 CHF";

    private String genre;
    private double prix;

    /**
     * Constructeur de Article. Ce constructeur reçoit ces deux paramètres et
     * les sauvegarde dans ces attributs.
     * 
     * @param genre : String le genre de l'article
     * @param prix  : double le prix unitaire de l'article.
     */
    public Article(String genre, double prix) {
        this.genre = genre;
        this.prix = prix;
    }

    /**
     * Cette méthode transforme en String un article. Pour ce faire elle concatène
     * ces attributs genre et prix en y insérant un SEPARATOR (Constante déclarée
     * ci-dessus).
     * 
     * @return String une représentation textuelle du bean.
     */
    @Override
    public String toString() {
        DecimalFormat formateur = new DecimalFormat(PATTERNPRIX);
        String prixUnitaire = formateur.format(prix);
        String info = genre + SEPARATOR + prixUnitaire;
        return info;
    }

    /**
     * Cette méthode retourne le genre de l'article.
     * 
     * @return String le genre de l'article.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Cette méthode remplace le genre de l'article par celui passé en paramètre.
     * @param genre : String le nouveau genre de l'article.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Cette méthode retourne le prix unitaire de l'article.
     * 
     * @return double le prix unitaire de l'article.
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Cette méthode remplace le prix unitaire de l'article par celui passé en
     * paramètre.
     * 
     * @param prix : double le nouveau prix unitaire de l'article.
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

}
