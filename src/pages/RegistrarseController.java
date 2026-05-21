/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pages;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import mapademo.Main;
import upv.ipc.sportlib.SportActivityApp;
import upv.ipc.sportlib.User;

/**
 * FXML Controller class
 *
 * @author jrags
 */
public class RegistrarseController implements Initializable {
    
    private boolean[] checks = new boolean[4];

    @FXML
    private TextField nicknameInput;
    @FXML
    private Text wrongNickLength;
    @FXML
    private Text wrongNickChars;
    @FXML
    private PasswordField passInput;
    @FXML
    private Text wrongPassLength;
    @FXML
    private Text wrongPassChars;
    @FXML
    private TextField mailInput;
    @FXML
    private Text wrongMail;
    @FXML
    private DatePicker dateInput;
    @FXML
    private Text wrongDate;
    @FXML
    private Button registerButton;
    @FXML
    private ImageView rightImg;
    @FXML
    private ImageView leftImg;
    @FXML
    private StackPane leftPane;
    @FXML
    private GridPane mainGrid;
    @FXML
    private ImageView imagePicked;
    @FXML
    private StackPane rightPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        registerButton.setDisable(true);
        
        nicknameInput.textProperty().addListener( (obs, _, nV) -> {
            int length = nV.length();
            if ( length < 6 || length > 15 ) {
                checkCanRegister(0, false);
                wrongNickLength.setStyle("-fx-fill: red;");
            } else { 
                checkCanRegister(0, true);
                wrongNickLength.setStyle("-fx-fill: green;"); 
            }
            if ( !nV.matches("^[a-zA-Z0-9_-]+$") ) {
                checkCanRegister(0, false);
                wrongNickChars.setStyle("-fx-fill: red;");
            } else {
                checkCanRegister(0, true);
                wrongNickChars.setStyle("-fx-fill: green;"); 
            }
        } );
        
        passInput.textProperty().addListener((obs, oldV, nV) -> {
            int length = nV.length();
            if (length < 8 || length > 20) {
                checkCanRegister(1, false);
                wrongPassLength.setStyle("-fx-fill: red;");
            } else {
                checkCanRegister(1, true);
                wrongPassLength.setStyle("-fx-fill: green;");
            }

            // al menos 1 minúscula, 1 mayúscula, 1 dígito, 1 símbolo de los permitidos
            // el regex ha sido pedido a la IA con el siguiente prompt:
            // dime q .matches debo usar para que cumpla lo siguiente con al menos una mayúscula, una minúscula, undígito y un símbolo (!@#$%&*()-+=)
            String passRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%&*()\\-+=]).+$";
            if (!nV.matches(passRegex)) {
                checkCanRegister(1, false);
                wrongPassChars.setStyle("-fx-fill: red;");
            } else {
                checkCanRegister(1, true);
                wrongPassChars.setStyle("-fx-fill: green;");
            }
        });
        
        mailInput.textProperty().addListener((obs, oldV, nV) -> {
            if (!User.checkEmail(nV)) {
                checkCanRegister(2, false);
                wrongMail.setStyle("-fx-fill: red;");
            } else {
                checkCanRegister(2, true);
                wrongMail.setStyle("-fx-fill: green;");
            }
        });
        
        dateInput.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null && User.isOlderThan(newDate, 12)) {
                checkCanRegister(3, true);
                wrongDate.setStyle("-fx-fill: green;");
            } else {
                checkCanRegister(3, false);
                wrongDate.setStyle("-fx-fill: red;");
            }
        });        
    }    
    
    private void checkCanRegister(int i, boolean state) {
        checks[i] = state;
        int ok = 0;
        if (!state) { registerButton.setDisable(true); return; }
        for (int j = 0; j < 4; j++) { if (checks[j]) ok++; }
        if (ok == 4 ) { registerButton.setDisable(false); } 
        else { registerButton.setDisable(true); }
    }

    @FXML
    private void alreadyAccount(ActionEvent event) {
        Main.logInShow();
    }

    @FXML
    private void register(ActionEvent event) {
        String name = nicknameInput.getText();
        String pass = passInput.getText();
        String mail = mailInput.getText();
        String avatar = imagePicked.getImage().getUrl();
        LocalDate birthDate = dateInput.getValue();
        SportActivityApp app = SportActivityApp.getInstance();
        if (app.nickNameExists(name)) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Usuario no disponible");
            alerta.setHeaderText("Por favor, cambie de usuario.");
            alerta.showAndWait();
            return;
        }
        if (app.registerUser(name, mail, pass, birthDate, avatar) && app.login(name, pass)) {
            Main.logInSuccesfull(name);
        }
    }

    @FXML
    private void cancelRegister(ActionEvent event) {
    }
    
}
