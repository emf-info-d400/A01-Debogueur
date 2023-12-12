/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lemagasin.ctrl;

import lemagasin.models.Article;
import lemagasin.models.ArticleStock;
import lemagasin.models.ArticleVente;
import lemagasin.services.ServiceMagasin;
import lemagasin.views.View;

/**
 * logus EMF Fribourg Suisse $(name)
 *
 * Description
 *
 * @author waeberla
 * @version $(1.0)
 * @date : $(date)
 */
public class Ctrl {


    public void startUp() {
        ArticleStock article1 = new ArticleStock(10, new Article("Pomme kg", 2.35));
        refWrk.ajouteArticleStock(article1);
        ArticleStock article2 = new ArticleStock(100, new Article("Poire kg", 2.55));
        refWrk.ajouteArticleStock(article2);
        ArticleStock article3 = new ArticleStock(9, new Article("Prune kg", 15.00));
        refWrk.ajouteArticleStock(article3);
        metAjourAffichage();
        refIhm.ouvreLeMagasin();
    }

    private void metAjourAffichage() {
        String[] laListe = refWrk.sortLaListeDesArticlesStock();
        refIhm.afficheLaListeDesArticlesEnStock(laListe);
        int nbrEnStock = refWrk.donneNbrArticleStock();
        int nbrMaxEnStock = refWrk.donneNbrMaxArticleDuStock();
        refIhm.metAJourInfoDuStock(nbrEnStock, nbrMaxEnStock);
        String[] lesGenres = refWrk.donneLesGenresDuStock();
        refIhm.afficheComboGenresFacture(lesGenres);
    }

    /**
     * Cette méthode ajoute un article identifié par son genre, son nombre en
     * stock et son prix unitaire. Ces trois informations lui sont pasées en
     * argument.<BR> Pour ce faire elle doit : <BR> 1. Créer un article instance
     * de Article en lui passant le genre et le prix en paramètre.<BR> 2. Créer
     * un articleStock en lui passant le nombre et l'article créé juste
     * auparvant.<BR> 3. demander à refWrk d'ajouter cet article par le bisias
     * de la méthode ajouteArticleStock. <BR> 4. Si l'ajout c'est bien passé :
     * <BR> 4. a. récupére la liste de String que lui retournera refWrk après
     * l'appel à la méthode sortLaListeDesArticlesStock().<BR> 4. b. demade à
     * refIhm d'afficher ces articles du stock par le biais de sa méthode
     * afficheLaListeDesArticlesEnStock.<BR>> 4. c. récupère le nombre d'article
     * en stock que lui retournera refWrk après l'appel à donneNbrArticleStock()
     * <BR> 4. d. récupère le nombre maximum d'article du stock que lui
     * retournera refWrk après l'appel à donneNbrMaxArticleDuStock()<BR> 4. e.
     * demande à refIhm, d'afficher les infos du stock par le biais de
     * metAJourInfoDuStock. <BR> 4. f. récupère le tableau de String que lui
     * retournera refWrk aprèsl'appel à donneLesGenresDuStock()<BR> 4. g.
     * demande à refIhm d'afficher le combo genre par le biais de
     * afficheComboGenresFacture.<BR>
     *
     * @param genre String le genre de la'rticle à ajouter au stock.
     * @param nbr int le nombre d'article du stock.
     * @param prix double le prix unitaire de l'article.
     */
    public void ajouteArticleStock(String genre, int nbr, double prix) {
        Article article = new Article(genre, prix);
        ArticleStock articleStock = new ArticleStock(nbr, article);
        boolean ajouteOk = refWrk.ajouteArticleStock(articleStock);
        if (ajouteOk) {
            metAjourAffichage();
        } else {
            refIhm.afficheErreur("Impossible d'ajouter cet article");
        }
    }

    /**
     * Cette méthode contrôle si l'article est dans le stock.<BR> Elle demade à
     * refWrk de contrôler et ensuite retourne l'inofrmation boolean à
     * l'appelant, ici Ihm.
     *
     * @param genre Stirng le genre à contrôler.
     * @param nbr int le nombre d'article que l'on voudrait (devra être <= au
     * nombre en stock. @return boolean true si disponible (nbr <= nombre du
     * stock) false sinon.
     */
    public boolean controleSiStockDisponible(String genre, int nbr) {
        boolean ok = refWrk.controleSiStockDisponible(genre, nbr);
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
     * @param nbr : int le nombre d'article vendu.
     */
    public void ajouteArticleFacture(String genre, int nbr) {
        boolean stockDispo = controleSiStockDisponible(genre, nbr);
        if (stockDispo) {
            double prix = refWrk.donnePrixArticle(genre);
            Article article = new Article(genre, prix);
            ArticleVente unArticle = new ArticleVente(nbr, article);
            boolean ok = refWrk.ajouteArticleFacture(unArticle);
            if (ok) {
                int nbrElemFact = refWrk.donneNbrElemFact();
                int nbrMaxElemFact = refWrk.donneNbrMaxElemFact();
                refIhm.metAJourInfoFacture(nbrElemFact, nbrMaxElemFact);
                String[] laListe = refWrk.sortLaListeDesArticlesStock();
                refIhm.afficheLaListeDesArticlesEnStock(laListe);
                termineFacture();
            }
        } else {
            refIhm.afficheErreur("Il n'y a pas assez d'article en Stock pour effectuer cet achat");
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
        String[] laFacture = refWrk.termineFacture();
        if (laFacture != null) {
            String dateCourante = refWrk.donneDateDuJour();
            refIhm.afficheTitreFacture(dateCourante);
            refIhm.afficheFacture(laFacture);
        } else {
            refIhm.afficheErreur("Pas de facture à afficher");
        }
    }

    /**
     * Cette méthode demande à refWrk de créer une nouvelle facture.
     */
    public void creeNouvelleFacture() {
        double montantDeLaCaisse = refWrk.creeNouvelleFacture();
        refIhm.afficheMontantDeLaCaisse(montantDeLaCaisse);
        refIhm.effaceFacture();
    }

    public View getRefIhm() {
        return refIhm;
    }

    public void setRefIhm(View refIhm) {
        this.refIhm = refIhm;
    }

    public ServiceMagasin getRefWrk() {
        return refWrk;
    }

    public void setRefWrk(ServiceMagasin refWrk) {
        this.refWrk = refWrk;
    }
    /**
     * Attribut référence sur l'Ihm
     */
    private View refIhm;
    /**
     * Attribut référence sur le Wrk
     */
    private ServiceMagasin refWrk;
}
