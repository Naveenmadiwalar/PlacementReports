/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package naveen;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class naveenmain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
         Parent report;
                       
            report= FXMLLoader.load(getClass().getResource("nlogin.fxml"));
        
        Scene scene = new Scene(report);
        
        primaryStage.setTitle("login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
