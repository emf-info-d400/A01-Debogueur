package lemagasin.ctrl;

import lemagasin.models.Article;
import lemagasin.models.ArticleStock;
import lemagasin.models.ArticleVente;
import lemagasin.services.ServiceMagasin;
import lemagasin.views.View;

/**
 * Classe de contrôle de l'application LeMagasin.
 * 
 * @author Mario Ramalho
 * @version 1.0.0
 */
public class Ctrl {

    /**
     * Attribut référence sur l'Ihm
     */
    private View refView;
    /**
     * Attribut référence sur le Wrk
     */
    private ServiceMagasin refServiceMagasin;

    public void startUp() {
        ArticleStock article1 = new ArticleStock(10, new Article("Pomme kg", 2.35));
        refServiceMagasin.ajouteArticleStock(article1);
        ArticleStock article2 = new ArticleStock(100, new Article("Poire kg", 2.55));
        refServiceMagasin.ajouteArticleStock(article2);
        ArticleStock article3 = new ArticleStock(9, new Article("Prune kg", 15.00));
        refServiceMagasin.ajouteArticleStock(article3);
        metAjourAffichage();
        refView.ouvreLeMagasin();
    }

    private void metAjourAffichage() {
        String[] laListe = refServiceMagasin.sortLaListeDesArticlesStock();
        refView.afficheLaListeDesArticlesEnStock(laListe);
        int nbrEnStock = refServiceMagasin.donneNbrArticleStock();
        int nbrMaxEnStock = refServiceMagasin.donneNbrMaxArticleDuStock();
        refView.metAJourInfoDuStock(nbrEnStock, nbrMaxEnStock);
        String[] lesGenres = refServiceMagasin.donneLesGenresDuStock();
        refView.afficheComboGenresFacture(lesGenres);
    }

    /**
     * Cette méthode ajoute un article identifié par son genre, son nombre en
     * stock et son prix unitaire. Ces trois informations lui sont pasées en
     * argument.<BR>
     * Pour ce faire elle doit : <BR>
     * 1. Créer un article instance
     * de Article en lui passant le genre et le prix en paramètre.<BR>
     * 2. Créer
     * un articleStock en lui passant le nombre et l'article créé juste
     * auparvant.<BR>
     * 3. demander à refWrk d'ajouter cet article par le bisias
     * de la méthode ajouteArticleStock. <BR>
     * 4. Si l'ajout c'est bien passé :
     * <BR>
     * 4. a. récupére la liste de String que lui retournera refWrk après
     * l'appel à la méthode sortLaListeDesArticlesStock().<BR>
     * 4. b. demade à
     * refIhm d'afficher ces articles du stock par le biais de sa méthode
     * afficheLaListeDesArticlesEnStock.<BR>
     * > 4. c. récupère le nombre d'article
     * en stock que lui retournera refWrk après l'appel à donneNbrArticleStock()
     * <BR>
     * 4. d. récupère le nombre maximum d'article du stock que lui
     * retournera refWrk après l'appel à donneNbrMaxArticleDuStock()<BR>
     * 4. e.
     * demande à refIhm, d'afficher les infos du stock par le biais de
     * metAJourInfoDuStock. <BR>
     * 4. f. récupère le tableau de String que lui
     * retournera refWrk aprèsl'appel à donneLesGenresDuStock()<BR>
     * 4. g.
     * demande à refIhm d'afficher le combo genre par le biais de
     * afficheComboGenresFacture.<BR>
     *
     * @param genre String le genre de la'rticle à ajouter au stock.
     * @param nbr   int le nombre d'article du stock.
     * @param prix  double le prix unitaire de l'article.
     */
    public void ajouteArticleStock(String genre, int nbr, double prix) {
        Article article = new Article(genre, prix);
        ArticleStock articleStock = new ArticleStock(nbr, article);
        boolean ajouteOk = refServiceMagasin.ajouteArticleStock(articleStock);
        if (ajouteOk) {
            metAjourAffichage();
        } else {
            refView.afficheErreur("Impossible d'ajouter cet article");
        }
    }

    /**
     * Cette méthode contrôle si l'article est dans le stock.<BR>
     * Elle demade à
     * refWrk de contrôler et ensuite retourne l'inofrmation boolean à
     * l'appelant, ici Ihm.
     *
     * @param genre Stirng le genre à contrôler.
     * @param nbr   int le nombre d'article que l'on voudrait (devra être <= au
     *              nombre en stock. @return boolean true si disponible (nbr <=
     *              nombre du
     *              stock) false sinon.
     */
    public boolean controleSiStockDisponible(String genre, int nbr) {
        boolean ok = refServiceMagasin.controleSiStockDisponible(genre, nbr);
        return ok;
    }

    /**
     * Cette méthode ajoute un article à la facture.<BR>
     * Elle contrôle si le stock est suffisant par le biais de la méthode
     * controleSiStockDisponible. si le stock n'est pas suffisant elle affichera
     * un message d'erreur et si le stock est disponible alors <BR>
     * Elle va récupérer le prix de l'article en le demandant à refWrk par le
     * biais de la méthode donnePrixArticle(genre).<BR>
     * Elle crée un article, instance d'Article en lui donnant le genre et le
     * prix.<BR>
     * Elle crée un articleVente instance de la classe ArticleVente en lui
     * donnant le nbr et l'article créé auparavant.<BR>
     * Elle demande à refWrk d'ajouter cet article nouvellement créé à la
     * facture par le biais de la méthode ajouteArticleFacture <BR>
     * Elle récupère le retour de cet appel et le teste.<BR>
     * Si le retour est true:<BR>
     * . Elle demande à refWrk de lui fournir la nouvelle liste de String
     * contenant tout le stock (sortLaListeDesArticlesStock()).<BR>
     * . Elle transmet cette liste à l'ihm par le biais de refIhm avec la
     * méthode afficheLaListeDesArticlesEnStock <BR>
     * . Elle termine la facture par le biais de la méthode interne
     * termineFacture().
     *
     * @param genre : String le genre de l'article à ajouter à la facture
     * @param nbr   : int le nombre d'article vendu.
     */
    public void ajouteArticleFacture(String genre, int nbr) {
        boolean stockDispo = controleSiStockDisponible(genre, nbr);
        if (stockDispo) {
            double prix = refServiceMagasin.donnePrixArticle(genre);
            Article article = new Article(genre, prix);
            ArticleVente unArticle = new ArticleVente(nbr, article);
            boolean ok = refServiceMagasin.ajouteArticleFacture(unArticle);
            if (ok) {
                int nbrElemFact = refServiceMagasin.donneNbrElemFact();
                int nbrMaxElemFact = refServiceMagasin.donneNbrMaxElemFact();
                refView.metAJourInfoFacture(nbrElemFact, nbrMaxElemFact);
                String[] laListe = refServiceMagasin.sortLaListeDesArticlesStock();
                refView.afficheLaListeDesArticlesEnStock(laListe);
                termineFacture();
            }
        } else {
            refView.afficheErreur("Il n'y a pas assez d'article en Stock pour effectuer cet achat");
        }
    }

    /**
     * Cette méthode demande à refWrk de terminer la facture en appelant la
     * méthode termineFacture().<BR>
     * Si la facture (qui est un tableau de String (un String par ligne de
     * facture)) n'est pas null elle devra:<BR>
     * 1. demander à refWrk de lui forûrnir la date du jour<BR>
     * 2. demander à refIhm d'afficher le titre de la facture avec la date du
     * jour reçu auparavant<BR>
     * 3. demander à refIhm d'afficher la facture en lui passant la facture
     * reCue lors de l'appel à termineLaFacture de refWrk.<BR>
     * sinon elle demandera à refIhm d'afficher un message d'erreur "Pas de
     * facture à afficher".
     */
    public void termineFacture() {
        String[] laFacture = refServiceMagasin.termineFacture();
        if (laFacture != null) {
            String dateCourante = refServiceMagasin.donneDateDuJour();
            refView.afficheTitreFacture(dateCourante);
            refView.afficheFacture(laFacture);
        } else {
            refView.afficheErreur("Pas de facture à afficher");
        }
    }

    /**
     * Cette méthode demande à refWrk de créer une nouvelle facture.
     */
    public void creeNouvelleFacture() {
        double montantDeLaCaisse = refServiceMagasin.creeNouvelleFacture();
        refView.afficheMontantDeLaCaisse(montantDeLaCaisse);
        refView.effaceFacture();
    }

    /**
     * Getter de l'attribut refView
     * @return View l'attribut refView
     */
    public View getRefView() {
        return refView;
    }

    /**
     * Setter de l'attribut refView
     * @param refView View l'attribut refView
     */
    public void setRefView(View refView) {
        this.refView = refView;
    }

    /**
     * Getter de l'attribut refServiceMagasin
     * @return ServiceMagasin l'attribut refServiceMagasin
     */
    public ServiceMagasin getRefService() {
        return refServiceMagasin;
    }

    /**
     * Setter de l'attribut refServiceMagasin
     * @param refWrk ServiceMagasin l'attribut refServiceMagasin
     */
    public void setRefService(ServiceMagasin refWrk) {
        this.refServiceMagasin = refWrk;
    }

}
