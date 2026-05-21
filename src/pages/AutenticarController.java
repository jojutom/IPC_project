/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pages;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mapademo.Main;
import upv.ipc.sportlib.SportActivityApp;

/**
 * FXML Controller class
 *
 * @author jrags
 */
public class AutenticarController implements Initializable {

    @FXML
    private TextField nickInput;
    @FXML
    private PasswordField passInput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void tryLogIn(ActionEvent event) {
        String nick = nickInput.getText();
        String pass = passInput.getText();
        if (nick.equals("") || pass.equals("")) return;
        SportActivityApp app = SportActivityApp.getInstance(); 
        boolean ok = app.login(nick, pass);
        if (ok) {
            Main.logInSuccesfull(nick);
            return;
        }
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("No se ha podido iniciar sesión");
        alerta.setHeaderText("Usuario o contraseña incorrectos");
        alerta.setContentText("Revise los datos introducidos e inténtelo de nuevo.");
        alerta.showAndWait();
    }

    @FXML
    private void register(ActionEvent event) {
        Main.registerShow();
    }
    
}
