/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lemagasin.models;

/**
 * logus EMF Fribourg Suisse $(name)
 *
 * Description
 *
 * @author waeberla
 * @version $(1.0)
 * @date : $(date)
 */
public class ArticleStock {

    public static final String SEPARATOR = "\t";

    /**
     * Constructeur de ArticleStock. Il reçoit deux argument, le nbr et un
     * article, instance de Article. Il ne fait que de les sauvegarder dans ces
     * attributs respectifs.
     *
     * @param nbr : int le nbr d'article en stock.
     * @param article : Article l'article composé de son genre et de son prix unitaire.
     */
    public ArticleStock(int nbr, Article article) {
        this.nbr = nbr;
        this.article = article;
    }

    /**
     * Cette méthode transforme en String un articleStock. Pour ce faire elle
     * concatène ces attributs nbr et article.toString() en y insérant un
     * SEPARATOR (Constante déclarée ci-dessus). Ce qui donne : String info =
     * nbr + SEPARATOR + article.toString();<BR>
     *
     * @return String une représentation textuelle du bean.
     */
    @Override
    public String toString() {
        String info = nbr + SEPARATOR + article.toString();
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
