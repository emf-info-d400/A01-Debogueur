/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lemagasin.app;

import lemagasin.ctrl.Ctrl;
import lemagasin.services.ServiceMagasin;
import lemagasin.views.View;

/**
 * Application LeMagasin contenant plusieurs bugs.
 * 
 * @author Mario Ramalho
 * @version 1.0.0
 */
public class LeMagasin {
 
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ctrl ctrl = new Ctrl();
        View ihm = new View();
        ServiceMagasin wrk = new ServiceMagasin();
        ctrl.setRefView(ihm);
        ctrl.setRefService(wrk);
        ihm.setRefCtrl(ctrl);
        ctrl.startUp();
    }

}
