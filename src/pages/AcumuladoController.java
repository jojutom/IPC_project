/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pages;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author JSOLDEL
 */
public class AcumuladoController implements Initializable {

    @FXML
    private TextField dtotal;
    @FXML
    private TextField titot;
    @FXML
    private TextField subidatot;
    @FXML
    private TextField bajadatot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dtotal.setText(String.valueOf(NombreDeTuClaseGlobal.distanciaTotal));
        titot.setText(String.valueOf(NombreDeTuClaseGlobal.tiempoTotal));
        subidatot.setText(String.valueOf(NombreDeTuClaseGlobal.metrosSubida));
        bajadatot.setText(String.valueOf(NombreDeTuClaseGlobal.metrosBajada));
    }    
    
}
