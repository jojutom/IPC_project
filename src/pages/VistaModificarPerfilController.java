/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pages;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import upv.ipc.sportlib.SportActivityApp;
import upv.ipc.sportlib.User;

/**
 * FXML Controller class
 *
 * @author jrags
 */
public class VistaModificarPerfilController implements Initializable {
    
    private SportActivityApp app;

    @FXML
    private ImageView avatar;
    @FXML
    private DatePicker birthInput;
    @FXML
    private TextField mailInput;
    @FXML
    private TextField passInput;
    @FXML
    private TextField nickInput;
    
    private String lastNick;
    private String lastMail;
    private String lastPass;
    private LocalDate lastBirth;
    private String lastAvatar;
    private boolean mustChange = false;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        app = SportActivityApp.getInstance();
        User u = app.getCurrentUser();
        Image img = new Image(u.getAvatarPath());
        avatar.setImage(img);
        lastNick = u.getNickName();
        lastMail = u.getEmail();
        lastPass = u.getPassword();
        lastBirth = u.getBirthDate();
        lastAvatar = u.getAvatarPath();
        nickInput.setText(u.getNickName());
        passInput.setText(u.getPassword());
        mailInput.setText(u.getEmail());
        birthInput.setValue(u.getBirthDate());
    }    

    @FXML
    private void selectAvatar(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Avatar");

        FileChooser.ExtensionFilter filtroImagenes = new FileChooser.ExtensionFilter(
                "Archivos de Imagen (*.png, *.jpg, *.jpeg)", "*.png", "*.jpg", "*.jpeg");
        fileChooser.getExtensionFilters().add(filtroImagenes);

        Node nodoFuente = (Node) event.getSource();
        Window ventanaActual = nodoFuente.getScene().getWindow();

        File archivoSeleccionado = fileChooser.showOpenDialog(ventanaActual);

        if (archivoSeleccionado != null) {
            System.out.println(archivoSeleccionado.getAbsolutePath());
            Image img = new Image(archivoSeleccionado.getAbsolutePath());
            avatar.setImage(img);
        }
    }

    @FXML
    private void save(ActionEvent event) {
        String newNick = nickInput.getText();
        String newPass = passInput.getText();
        String newEmail = mailInput.getText();
        LocalDate newBirth = birthInput.getValue();
        String newAvatar = avatar.getImage().getUrl();
        if (!Objects.equals(newNick, lastNick) || !Objects.equals(newNick, "")) {
            lastNick = newNick;
        }
        if (!Objects.equals(newPass, lastPass) || !Objects.equals(newPass, "")) {
            lastPass = newPass;
            mustChange = true;
        }

        if (!Objects.equals(newEmail, lastMail)) {
            lastMail = newEmail;
            mustChange = true;
        }

        if (!Objects.equals(newBirth, lastBirth) && newBirth == null) {
            lastBirth = newBirth;
            mustChange = true;
        }

        if (!Objects.equals(newAvatar, lastAvatar)) {
            lastAvatar = newAvatar;
            mustChange = true;
        }
        if (mustChange) {
            app.updateCurrentUser(lastMail, lastNick, lastBirth, lastAvatar);
            
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        mustChange = false;
    }
    
}
