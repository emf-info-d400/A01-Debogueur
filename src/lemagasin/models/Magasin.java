package lemagasin.models;

import java.text.DecimalFormat;

/**
 * Modèle de l'application LeMagasin. Cette classe représente un article en
 * vente.
 * 
 * @author Mario Ramalho
 * @version 1.0.0
 */
public class Magasin {

    /**
     * Constante définissant le nombre d'article maximum en stock.
     */
    public static final int NBR_MAX_ARTICLES_EN_STOCK = 10;
    /**
     * Constante définissat le nombre d'article maximum pour une facture.
     */
    public static final int NBR_MAX_ARTICLES_FACTURE = 5;
    /**
     * Constante définissant le texte pour le total de la facture.
     */
    public static final String TEXT_MONTANT_TOTAL = "Total de la facture : \t\t";
    /**
     * Constante définissant le pattern de formattage du montant (arrondi pour
     * éviter d'avoir des montant de 59.3333333)
     */
    public static final String MONTANTPATTERN = "#,###.00";

    /**
     * Attribut tableau contenant tous les articles du stock
     */
    private ArticleStock[] leStock;
    /**
     * Attribut tableau contenant tous les éléments de la facture en cours...
     */
    private ArticleVente[] laFactureCourante;

    /**
     * Attribut mémorisant le montant total de la caisse.
     */
    private double montantDeLaCaisse;

    /**
     * Attribut mémorisant le montant de la facture courante.
     */
    private double montantDeLaFacture;

    /**
     * Constructeur de la classe Magasin. Ici le constructeur ne fait que de
     * créer son attribut le Stock et initialise le montant de la caisse à 0.0
     */
    public Magasin() {
        leStock = new ArticleStock[NBR_MAX_ARTICLES_EN_STOCK];
    }

    /**
     * Cette méthode regarde si l'article passé en paramètre existe déjà dans le
     * stock. Pour ce faire elle doit: <BR>
     * Parcourir la structure de données leStock tant que les éléments du
     * tableau sont non null. A chaque article du stock (leStock[i] elle regarde
     * si l'attribut genre de son attribut article correspond au genre de
     * l'article passé en argument<BR>
     * Si l'article correspond elle devra retourner l'index de l'article car
     * l'article est
     * présent sinon elle passera à l'article suivant.<BR>
     * Elle contrôle que la boucle ne dépasse pas la capacité du tableau.<BR>
     *
     * @param unArticleStock ArticleStock contient l'article à contrôler avec
     *                       les éléments de la structure leStock.
     * @return int l'index de la case du tableau où se trouve l'article s'il est
     *         présent sinon la valeur "-1".
     */
    private int articlePresentEnStock(ArticleStock unArticleStock) {
        int index = -1;
        boolean encore = true;
        int compteur = 0;
        while (encore) {
            if (leStock[compteur] != null) {
                if (leStock[compteur].getArticle().getGenre()
                        .equalsIgnoreCase(unArticleStock.getArticle().getGenre())) {
                    index = compteur;
                    encore = false;
                }
            }
            compteur++;
            if (compteur >= leStock.length) {
                encore = false;
            }
        }
        return index;
    }

    /**
     * Cette méthode est appelée par une autre méthode et ne s'occupe que d'ajouter
     * un
     * article passé en argument à la méthode dans la structure leStock. Pour ce
     * faire elle doit :<BR>
     * Parcourir la structure leStock et sitôt une place null, elle doit
     * affecter à cette case nulle, l'article passé en argument. Attention à ne
     * pas dépasser la capacité de la structure (tableau d'article leStock).<BR>
     *
     * @param unArticleStock ArticleStock article qu'il faut ajouter.
     * @return boolean true si l'article a bien été ajouté sinon false
     *         plus de place
     */
    private boolean ajouteArticleDansStock(ArticleStock unArticleStock) {
        boolean ajouteOk = false;
        boolean encore = true;
        int compteur = 0;
        while (encore) {
            if (leStock[compteur] == null) {
                leStock[compteur] = unArticleStock;
                ajouteOk = true;
                encore = false;
            }
            compteur++;
            if (compteur >= leStock.length) {
                encore = false;
            }
        }
        return ajouteOk;
    }

    /**
     * Cette méthode est une composition de deux appels à des méthodes private.
     * Elle doit :<BR>
     * 1. Regarder si l'article passé en argument existe déjà dans leStock en
     * utilisant la méthode private articlePresentEnStock.<BR>
     * 2. si l'article n'est pas présent (index = -1) alors elle l'ajoute au stock
     * en
     * utilisant la méthode private ajouteArticleDansStock.<BR>
     * 3. si l'article est présent (index != -1) alors il s'agira non pas d'un ajout
     * mais d'une modification
     * et les informations nbr et prix de l'article seront modifié. L'article
     * concerné sera "pointé" par l'index retourné
     * de la méthode articlePresentEnStock.<BR>
     *
     * @param unArticleStock l'article à ajouter ou à modifier au stock (leStock)
     * @return true si l'ajout ou la modfication c'est bien déroulé sinon false.
     */
    public boolean ajouteUnArticleDansStock(ArticleStock unArticleStock) {
        boolean ajouteOk = false;
        int index = articlePresentEnStock(unArticleStock);
        if (index == -1) {
            ajouteOk = ajouteArticleDansStock(unArticleStock);
        } else {
            int leNombre = unArticleStock.getNbr();
            leNombre = leNombre + leStock[index].getNbr();
            leStock[index].setNbr(leNombre);
            leStock[index].getArticle().setPrix(unArticleStock.getArticle().getPrix());
            ajouteOk = true;
        }
        return ajouteOk;
    }

    /**
     * Cette méthode sort la liste en String de tous les articles du stock.<BR>
     * Pour ce faire elle doit : <BR>
     * 1. Déclarer et créer un tableau de String de la taille du stock.<BR>
     * 2. Parcourir le stock (leStock) et pour chaque élément non null elle doit
     * : <BR>
     * 2. a. Transformer le bean ArticleStock contenu dans chaque case du
     * tableau leStock en String en utilisant la méthode toString().<BR>
     * 2. b. placer ce String dans le tableau de String déclaré et créé juste
     * auparavant.<BR>
     * 3. retourner le tableau de String contenant une expression littérale des
     * attributs du bean ArticleStock.<BR>
     *
     * @return String[] un tableau de String contenant les informations des
     *         articles contenus dans le tableau leStock.
     */
    public String[] sortLaListeDesArticlesDuStock() {
        String[] laListe = new String[leStock.length];
        for (int i = 0; i < leStock.length; i++) {
            if (leStock[i] != null) {
                laListe[i] = leStock[i].toString();
            }
        }
        return laListe;
    }

    /**
     * Cette méthode recherche le nombre d'articles présents dans le stock (qui
     * n'est pas égal à la taille du tableau). <BR>
     * Pour ce faire elle doit : <BR>
     * Initialiser un compteur à 0. <BB>
     * Parcourir le tableau leStock et pour chaque élément non null elle
     * incrémente le compteur.<BR>
     * retourner ce compteur.<BR>
     *
     * @return int le nombre d'article présent dans leStock. Ce nombre variera
     *         entre 0 et leStock.length.
     */
    public int donneLeNombreArticleEnStock() {
        int nbr = 0;
        for (int i = 0; i < leStock.length; i++) {
            if (leStock[i] != null) {
                nbr++;
            }
        }
        return 0;
    }

    /**
     * Cette méthode recherche le nombre d'éléments présents dans la facture
     * courante
     * (qui n'est pas égal à la taille du tableau). <BR>
     * Pour ce faire elle doit : <BR>
     * Initialiser un compteur à 0. <BB>
     * Parcourir le tableau laFactureCourante et pour chaque élément non null elle
     * incrémente le compteur.<BR>
     * retourner ce compteur.<BR>
     *
     * @return int le nombre d'élément présent dans la facture courante. Ce nombre
     *         variera
     *         entre 0 et laFactureCourante.length.
     */
    public int donneLeNombreArticleDansFacture() {
        int nbr = 0;
        if (laFactureCourante != null) {
            for (int i = 0; i < laFactureCourante.length; i++) {
                if (laFactureCourante[i] != null) {
                    nbr++;
                }
            }
        }
        return nbr;
    }

    /**
     * Cette méthode ne fait que de retourner la taille du tableau du stock
     * (leStock).
     *
     * @return int le nombre de case du tableau leStock.
     */
    public int donneLeNombreMaxArticlesEnStock() {
        return NBR_MAX_ARTICLES_EN_STOCK;
    }

    /**
     * Cette méthode ne fait que de retourner la taille du tableau de la facture
     * (laFactureCourante).
     *
     * @return int le nombre de case du tableau laFactureCourante
     */
    public int donneLeNombreMaxArticlesDansFacture() {
        return NBR_MAX_ARTICLES_FACTURE;
    }

    /**
     * Cette méthode recherche dans la structure leStock tous les genres (article)
     * et les
     * regroupe dans un tableau de String. Pour ce faire elle parcourt le
     * tableau leStock et pour chaque élément non null du tableau, elle sauve le
     * genre de l'article dans le tableau de String de sortie. (le tableau de
     * sortie aura la taille du tableau leStock.
     *
     * @return String[] un tableau de String contenant tous les genres du stock.
     */
    public String[] donneLesGenresDuStock() {
        String[] lesGenres = new String[NBR_MAX_ARTICLES_EN_STOCK];
        for (int i = 0; i < leStock.length; i++) {
                lesGenres[i] = leStock[i].getArticle().getGenre();
        }
        return lesGenres;
    }

    /**
     * Cette méthode contrôle si le stock est suffisant. On lui passe comme
     * argument un genre ainsi que le nombre d'article et la méthode nous rend
     * comme information true s'il y a assez d'articles ou false si le nombre
     * demandé est plus grand que le nombre disponible.<BR>
     * Pour le test d'un String il est important d'utiliser une méthode et non pas
     * le "==". Si l'on désire faire un check d'égalité en ignorant la casse
     * (majuscule, minuscule)
     * on peut utiliser la méthode .equalsIgnoreCase en lieu et place à .equals
     *
     * @param genre String le genre d'article que l'on veut contrôler
     * @param nbr   int le nombre d'article qu'il fauzt contrôler
     * @return boolean true si le nombre en stock est suffisant (>= au nombre
     *         demandé) false sinon.
     */
    public boolean controleSiStockDisponible(String genre, int nbr) {
        boolean ok = false;
        boolean encore = true;
        int index = 0;
        while (encore) {
            if (leStock[index] != null) {
                if (leStock[index].getArticle().getGenre().equalsIgnoreCase(genre)) {
                    if (leStock[index].getNbr() >= nbr) {
                        ok = true;
                        encore = false;
                    }
                }
            }
            index++;
            if (index >= leStock.length) {
                encore = false;
            }
        }
        return ok;
    }

    /**
     * Cette méthode recherche l'article correspondant dans le tableau leStock
     * en le parcourant et en le comparant au genre donné en argument. Elle doit
     * le faire uniquement si l'élément du tableau leStock est non null. Une
     * fois l'article trouvé, elle récupèrera son prix et le retournera.
     * Pour le test d'un String il est important d'utiliser une méthode et non pas
     * le "==". Si l'on désire faire un check d'égalité en ignorant la casse
     * (majuscule, minuscule)
     * on peut utiliser la méthode .equalsIgnoreCase en lieu et place à .equals
     *
     * @param genre : String le genre de l'article pour lequel il faut
     *              rechercher le prix
     * @return double le prix de l'article recherché. Si aucun article n'est
     *         trouvé, le prix sera de 0.0.
     */
    public double donnePrixArticle(String genre) {
        double prix = 0.0;
        for (int i = 0; i < leStock.length; i++) {
            if (leStock[i] != null) {
                if (genre.equalsIgnoreCase(leStock[i].getArticle().getGenre())) {
                    prix = leStock[i].getArticle().getPrix();
                }
            }
        }
        return prix;
    }

    /**
     * Cette méthode diminue le stock en fonction des achats effectués.<BR>
     * Elle recoit en paramètre un article instance d'ArticleVente. Elle peut
     * donc trouver dans cet argument le nombre (nbr attribut de ArticleVente) le
     * genre (attribut de Article qui est un attribut d'ArticleVente).<BR>
     * Elle recherche un article en fonction du genre dans leStock.<BR>
     * Une fois l'article trouvé, elle décrémente le nombre du stock du nombre
     * vendu.<BR>
     * Pour le test d'un String il est important d'utiliser une méthode et non pas
     * le "==". Si l'on désire faire un check d'égalité en ignorant la casse
     * (majuscule, minuscule)
     * on peut utiliser la méthode .equalsIgnoreCase en lieu et place à .equals<BR>
     * 
     * A la fin si tout c'est bien passé et que le stock a été débité, elle
     * retournera true, sinon false.
     *
     * @param article: ArticleVente contenant le nombre d'articles vendus et une
     *                 instance d'Article.
     * @return : boolean true si la diminution a été effectuée sinon fase.
     */
    public boolean diminueLeStock(ArticleVente article) {
        boolean diminueOk = false;
        boolean encore = true;
        int i = 0;
        while (encore) {
            Article unArticle = leStock[i].getArticle();
            if (unArticle.getGenre().equalsIgnoreCase(article.getArticle().getGenre())) {
                int nbrEnStock = leStock[i].getNbr();
                int nbrVendu = article.getNbr();
                leStock[i].setNbr(nbrEnStock - nbrVendu);
                diminueOk = true;
                encore = false;
            }
            i++;
            if (i >= leStock.length) {
                encore = false;
            }
        }
        return diminueOk;
    }

    /**
     * Cette méthode ajoute un article (instance de ArticleVente) à la facture
     * courrante.<BR>
     * Pour ce faire elle doit dans un premier temps tester si l'objet
     * laFactureCourante est null ou non. S'il est null il faudra le créer,
     * sinon il n'y a rien à faire.<BR>
     * Ensuite il faut parcourir le tableau la factureCourante tant que
     * l'élément n'est pas null.<BR>
     * Au premier élément null, il faudra ajouter le bean ArticleFacture a
     * tableau.<BR>
     * Il faut aussi faire attention à la taille du tableau factureCourante...
     * ne pas dépasser sa capacité.<BR>
     *
     * @param unArticle : ArticleVente comprenant un attribut nbr représentant
     *                  le nombre d'article vendus et un attribut article contenant
     *                  le genre et
     *                  le prix unitaire.
     * @return true si l'ajout à la facture a pu être fait sinon false.
     */
    public boolean ajouteArticleFature(ArticleVente unArticle) {
        boolean ajouteOk = false;
        if (laFactureCourante == null) {
            laFactureCourante = new ArticleVente[NBR_MAX_ARTICLES_FACTURE];
        }
        boolean encore = true;
        int compteur = 0;
        while (encore) {
            if (laFactureCourante[compteur] == null) {
                laFactureCourante[compteur] = unArticle;
                encore = false;
                ajouteOk = true;
            } else {
                compteur++;
            }
            if (compteur >= laFactureCourante.length) {
                encore = false;
            }
        }
        return ajouteOk;
    }

    /**
     * Cette méthode donne une version String de la facture. Elle transforme le
     * tableau laFactureCourante qui est un tableau d'articleVente en tableau de
     * String. Chaque ligne représente une ligne de la facture.<BR>
     * Le tableau de String sera de la taille de laFactureCourante + 1 car sur
     * la dernière ligne il y aura le montant total de la facture.
     * Il ne faut pas oublier de mémoriser le montant de la facture dans l'attribut
     * montantDeLaFacture.
     * 
     * @return String[] une version String de laFactureCourante avec en plus le
     *         montant total de la facture.
     */
    public String[] donneEtatFactureCourante() {
        String[] laFacture = null;
        if (laFactureCourante != null) {
            laFacture = new String[NBR_MAX_ARTICLES_FACTURE + 1];
            montantDeLaFacture = 0.0;
            for (int i = 0; i < laFactureCourante.length; i++) {
                if (laFactureCourante[i] != null) {
                    laFacture[i] = laFactureCourante[i].toString();
                    montantDeLaFacture = montantDeLaFacture
                            + (laFactureCourante[i].getNbr() * laFactureCourante[i].getArticle().getPrix());
                }
            }
            DecimalFormat formateur = new DecimalFormat(MONTANTPATTERN);
            String montantFormate = formateur.format(montantDeLaFacture);
            laFacture[laFacture.length - 1] = TEXT_MONTANT_TOTAL + "\t" + montantFormate;
        }
        return laFacture;
    }

    /**
     * Cette méthode met simplement laFactureCourante à null et de ce fait
     * initialise totalement laFactureCourante. Auparavant elle mettra à jour le
     * montant de la caisse (attribut montantDeLaCaisse) en utilisant l'attribut
     * montantDeLaFacture qui mémorise le montant de la facture courante.
     * 
     * @return double le montant de la caisse.
     */
    public double creeNouvelleFacture() {
        montantDeLaCaisse = montantDeLaCaisse + montantDeLaFacture;
        laFactureCourante = null;
        return montantDeLaCaisse;
    }

}
