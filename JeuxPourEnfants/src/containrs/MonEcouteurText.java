/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containrs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alixia
 */
public class MonEcouteurText implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        String composant = ae.getActionCommand();
        System.out.println(composant);

    }

}
