/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/VistaModificarPerfil.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Modificar perfil");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); 
            stage.showAndWait();

            

        } catch (IOException e) {
        }
    }

    @FXML
    private void showHistory(ActionEvent event) {
    }

    @FXML
    private void handleMouseEntered(MouseDragEvent event) {
    }

    @FXML
    private void handleMouseExited(MouseDragEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void importGPX(ActionEvent event) {
    }

    @FXML
    private void importMap(ActionEvent event) {
    }

    @FXML
    private void showActivies(ActionEvent event) {
    }

    @FXML
    private void seeHistory(ActionEvent event) {
    }
    
}
