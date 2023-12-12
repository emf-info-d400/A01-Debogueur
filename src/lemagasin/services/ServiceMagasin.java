/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lemagasin.services;

import lemagasin.models.ArticleStock;
import lemagasin.models.ArticleVente;
import lemagasin.models.Magasin;

/**
 * logus EMF Fribourg Suisse $(name)
 *
 * Description
 *
 * @author waeberla
 * @version $(1.0)
 * @date : $(date)
 */
public class ServiceMagasin {
    
    /**
     * Constructeur de Wrk. Ici il crée ses deux attributs leMagasin et wrkDate.
     */
    public ServiceMagasin() {
        leMagasin = new Magasin();
        wrkDate = new ServiceDate();
    }

    /**
     * Cette méthode demande à leMagasin d'ajouter un article. Elle récupère le retour
     * boolean de cette méthode et le transfert en retour à Ctrl.
     * @param unArticleStock instance d'ArticleStock représentant un article du stock à ajouter.
     * @return boolean, true si l'ajout c'est fait correctement sinon false.
     */
    public boolean ajouteArticleStock(ArticleStock unArticleStock) {
        boolean ajouteOk = leMagasin.ajouteUnArticleDansStock(unArticleStock);
        return ajouteOk;
    }

    /**
     * Cette méthode demande à leMagasin de lui donner la liste des articles du stock.
     * Elle récupère cette liste et la transmet à refCtrl
     * @return String[] la liste des articles du stock
     */
    public String[] sortLaListeDesArticlesStock() {
        String[] laListe = leMagasin.sortLaListeDesArticlesDuStock();
        return laListe;
    }
    
    /**
     * Cette méthode demande à leMagasin de lui retourner le nombre de genre d'article en stock.
     * Elle le retournera à ctrl directement.
     * @return int le nombre de genre d'article en stock.
     */
    public int donneNbrArticleStock(){
        int nbr = leMagasin.donneLeNombreArticleEnStock();
        return nbr;
    }
    
    /**
     * Cette méthode demande à leMagasin de lui retourner le nombre maximum de genre d'article du stock.
     * Elle le retournera à ctrl directement.
     * @return int le nombre maximum de genre d'article du stock.
     */
    public int donneNbrMaxArticleDuStock(){
        int nbr = leMagasin.donneLeNombreMaxArticlesEnStock();
        return nbr;
    }
    
    /**
     * Cette méthode demande à leMagasin de lui retourner le nombre d'éléments (articles)
     * que contient la facture. elle le retournera à ctrl directement.
     *
     * @return int le nombre d'élément dans la facture courante.
     */
    public int donneNbrElemFact(){
        int nbr = leMagasin.donneLeNombreArticleDansFacture();
        return nbr;
    }
    
    /**
     * Cette méthode demande à leMagasin de lui retourner le nombre maximum d'éléments 
     * qui peuvent être présents dans une facture.
     * @return int le nombre maximum d'éléments que peut contenir une facture.
     */
    public int donneNbrMaxElemFact(){
        int nbr = leMagasin.donneLeNombreMaxArticlesDansFacture();
        return nbr;
    }
    
    /**
     * Cette méthode demande à laMagasin de lui retourner tous les genres d'article du stock dans un tableau de String.
     * @return String [] tous les genres d'articles du stock.
     */
    public String[] donneLesGenresDuStock(){
        String[]lesGenres = leMagasin.donneLesGenresDuStock();
        return lesGenres;
    }
    
    /**
     * Cette méthode demande à leMagasin de contrôler si le stock est suffisant. 
     * Puis elle retournera le boolean reçu en réponse.
     * @param genre : String le genre de l'article du stock qu'il faut contrôler
     * @param nbr : int le nombre d'article du genre donné ci-dessus. 
     * @return boolean en retour de leMagasin.
     */
    public boolean controleSiStockDisponible(String genre, int nbr){
        boolean ok = leMagasin.controleSiStockDisponible(genre, nbr);
        return ok;
    }
    
    /**
     * Cette méthode demande à leMagasin de lui donner le prix de l'article dont 
     * le genre est passé en argument.
     * @param genre : String le genre de l'article qu'il faudra rechercher
     * @return :double le prix de l'article que leMagasin aura retourné.
     */
    public double donnePrixArticle(String genre){
        double prix = leMagasin.donnePrixArticle(genre);
        return prix;
    }
    
    /**
     * Cette méthode demande à leMagasin d'ajouter un article (instance d'ArticleVente) à la facture.<BR>
     * Ensuite elle demande à leMagasin de diminuer le stock en fonction du nombre d'article vendus.<BR>
     * elle retourne true si les deux actions ont bien été exécutés sinon false.
     * @param unArticle ArticleVente l'article vendu composé de deux attributs le 
     * nombre vendu (nbr) et un Article (composé lui même du genre et du prix unitaire).<BR>
     * 
     * @return true si l'opération s'est bien déroulée sinon false.
     */
    public boolean ajouteArticleFacture(ArticleVente unArticle){
        boolean ajouteOk = leMagasin.ajouteArticleFature(unArticle);
        ajouteOk = ajouteOk && leMagasin.diminueLeStock(unArticle);
        return ajouteOk;
    }
    
    /**
     * Cette méthode demande à leMagasin de lui donner l'état de la factureCourante. 
     * Elle la récupère et la transfert à son appelant (ici refCtrl).
     * @return String[] un tableau de String contenant pour chaque String une ligne de la facture.
     */
    public String[] termineFacture(){
        String[] laFacture = leMagasin.donneEtatFactureCourante();
        return laFacture;
    }
    
    /**
     * Cette méthode demande à wrkDate de lui retourner la date du jour (dateCourante)
     * et elle la retransmet à son appelat (ici refCtrl).
     * @return la date du jour formattée par wrkDate.
     */
    public String donneDateDuJour(){
        String laDateDuJour = wrkDate.donneDateCourante();
        return laDateDuJour;
    }
    
    /**
     * Cette méthode demande à leMagasin de creer une nouvelle facture. leMagasin
     * lui retournera alors le montant de la caisse, elle le récuperera et le transmettra 
     * à son appelant, ici refCtrl.
     * @return double le montant de la caisse.
     */
    public double creeNouvelleFacture(){
        double montantDeLaCaisse = leMagasin.creeNouvelleFacture();
        return montantDeLaCaisse;
    }
    
    /**
     * Attribut leMagasin instance de Magasin.
     */
    private Magasin leMagasin;
    
    /**
     * Attribut wrkDate spécialiste de la création et du formatage des dates
     */
    private ServiceDate wrkDate;
}
