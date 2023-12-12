package lemagasin.models;

import java.text.DecimalFormat;

/**
 * Modèle de l'application LeMagasin. Cette classe représente un article en
 * vente.
 * 
 * @author Mario Ramalho
 * @version 1.0.0
 */
public class ArticleVente {

    public static final String SEPARATOR = "\t";
    public static final String MONTANTPATTERN = "#,###.00";

    private int nbr;
    private Article article;

    /**
     * Constructeur de ArticleVente. Il reçoit deux arguments, le nbr et un
     * article, instance de Article. Il ne fait que de les sauvegarder dans ces
     * attributs respectifs.
     *
     * @param nbr     : int le nbr d'article vendus ((présent sur la facture).
     * @param article : Article l'article composé de son genre et de son prix
     *                unitaire.
     */
    public ArticleVente(int nbr, Article article) {
        this.nbr = nbr;
        this.article = article;
    }

    /**
     * Cette méthode transforme en String un articleVente. Pour ce faire elle
     * concatène ces attributs nbr et article.toString() en y insérant un SEPARATOR
     * (Constante déclarée ci-dessus). Elle ajoute une troisième information qui est
     * le montant de la vente
     * et qui est représenté par la multiplication du nbr et du prix unitaire de
     * l'article.<BR>
     * Il serait agréable que le montant (le calcul soit arrondi à deux chiffres
     * après la virgule.<BR>
     * Ce qui donne : String info = nbr + SEPARATOR + article.toString() + SEPARATOR
     * + montant + " CHF";<BR>
     *
     * @return String une représentation textuelle du bean.
     */
    @Override
    public String toString() {
        double montant = nbr * article.getPrix();
        DecimalFormat formateur = new DecimalFormat(MONTANTPATTERN);
        String montantFormate = formateur.format(montant);
        String info = nbr + SEPARATOR + article.toString() + SEPARATOR + montantFormate + " CHF";
        return info;
    }

    /**
     * Cette méthode retourne le nombre d'article vendus.
     * 
     * @return int le nombre d'article vendus.
     */
    public int getNbr() {
        return nbr;
    }

    /**
     * Cette méthode remplace le nombre d'article vendus par celui passé en
     * paramètre.
     * 
     * @param nbr : int le nouveau nombre d'article vendus.
     */
    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    /**
     * Cette méthode retourne l'article vendus.
     * 
     * @return Article l'article vendus.
     */
    public Article getArticle() {
        return article;
    }

    /**
     * Cette méthode remplace l'article vendus par celui passé en paramètre.
     * 
     * @param article : Article le nouvel article vendus.
     */
    public void setArticle(Article article) {
        this.article = article;
    }

}
