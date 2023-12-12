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
public class ArticleVente {

    public static final String SEPARATOR = "\t";
    public static final String MONTANTPATTERN = "#,###.00";

 /**
     * Constructeur de ArticleVente. Il reçoit deux arguments, le nbr et un
     * article, instance de Article. Il ne fait que de les sauvegarder dans ces
     * attributs respectifs. 
     *
     * @param nbr : int le nbr d'article vendus ((présent sur la facture).
     * @param article : Article l'article composé de son genre et de son prix unitaire.
     */   
    public ArticleVente(int nbr, Article article) {
        this.nbr = nbr;
        this.article = article;
    }

    /**
     * Cette méthode transforme en String un articleVente. Pour ce faire elle
     * concatène ces attributs nbr et article.toString() en y insérant un SEPARATOR
     * (Constante déclarée ci-dessus). Elle ajoute une troisième information qui est le montant de la vente
     * et qui est représenté par la multiplication du nbr et du prix unitaire de l'article.<BR>
     * Il serait agréable que le montant (le calcul soit arrondi à deux chiffres après la virgule.<BR>
     * Ce qui donne : String info = nbr + SEPARATOR + article.toString() + SEPARATOR + montant + " CHF";<BR>
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

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    private int nbr;
    private Article article;
}
