package lemagasin.models;

/**
 * Modèle de l'application LeMagasin. Cette classe représente un article en
 * stock.
 * 
 * @author Mario Ramalho
 * @version 1.0.0
 */
public class ArticleStock {

    public static final String SEPARATOR = "\t";

    private int nbr;
    private Article article;

    /**
     * Constructeur de ArticleStock. Il reçoit deux argument, le nbr et un
     * article, instance de Article. Il ne fait que de les sauvegarder dans ces
     * attributs respectifs.
     *
     * @param nbr     : int le nbr d'article en stock.
     * @param article : Article l'article composé de son genre et de son prix
     *                unitaire.
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

    /**
     * Cette méthode retourne le nombre d'article en stock.
     * @return int le nombre d'article en stock.
     */
    public int getNbr() {
        return nbr;
    }

    /**
     * Cette méthode remplace le nombre d'article en stock par celui passé en
     * paramètre.
     * @param nbr : int le nouveau nombre d'article en stock.
     */
    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    /**
     * Cette méthode retourne l'article en stock.
     * @return Article l'article en stock.
     */
    public Article getArticle() {
        return article;
    }

    /**
     * Cette méthode remplace l'article en stock par celui passé en paramètre.
     * @param article : Article le nouvel article en stock.
     */
    public void setArticle(Article article) {
        this.article = article;
    }

}
