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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import upv.ipc.sportlib.SportActivityApp;
import upv.ipc.sportlib.User;

/**
 * FXML Controller class
 *
 * @author jrags
 */
public class MenuPrincipalController implements Initializable {
    
    private String nick;
    private SportActivityApp app;

    @FXML
    private BorderPane contenedorPrincipal;
    @FXML
    private Text helloText;
    @FXML
    private ImageView avatar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = SportActivityApp.getInstance();
        User u = app.getCurrentUser();
        
        helloText.setText("Hola, " + u.getNickName());
        Image img = new Image(u.getAvatarPath());
        avatar.setImage(img);
    }    

    @FXML
    private void modifyAccount(ActionEvent event) {
        
    }

    @FXML
    private void showHistory(ActionEvent event) {
    }
    
    public void setNickUsuario(String nick) {
        this.nick = nick;
    }

    @FXML
    private void handleMouseEntered(MouseDragEvent event) {
    }

    @FXML
    private void handleMouseExited(MouseDragEvent event) {
    }
    
}
