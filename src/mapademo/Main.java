/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapademo;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pages.MenuPrincipalController;

/**
 *
 * @author jose
 */
public class Main extends Application {
    
    private Scene actScene;
    private static Stage mainStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/pages/Autenticar.fxml"));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logo.png")));
        actScene = new Scene(root);
        stage.setTitle("HortaRun, La Safor");
        stage.setScene(actScene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void logInShow() {
        try {
            Parent newRoot = FXMLLoader.load(Main.class.getResource("/pages/Autenticar.fxml"));
           
            mainStage.getScene().setRoot(newRoot);
            
        } catch (IOException e) {
        }
    }
    
    public static void logInSuccesfull(String nick) {
        try {
            Parent newRoot = FXMLLoader.load(Main.class.getResource("/pages/MenuPrincipal.fxml"));

            mainStage.getScene().setRoot(newRoot);
        } catch (IOException e) {}
    }
    
    public static void registerShow() {
        try {
            Parent newRoot = FXMLLoader.load(Main.class.getResource("/pages/Registrarse.fxml"));
           
            mainStage.getScene().setRoot(newRoot);
            
        } catch (IOException e) {
        }
    }
    
    
    
}
