/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package naveen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import test2.database;


public class NloginController implements Initializable {

    @FXML
    private PasswordField npsw;
    @FXML
    private TextField nuser;
    @FXML
    private Button nsubmit;
    @FXML
    private Button nclear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
   String username="naveen";
    String password="1234";
    Stage mystage;
    Scene scene;
    public void nsub(ActionEvent event) throws IOException {
    if(username.equals(nuser.getText()) && password.equals(npsw.getText())){
        
            Parent report;
         
            report= FXMLLoader.load(getClass().getResource("report.fxml"));
           
            mystage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(report);
            mystage.setTitle("placment report");
            mystage.setScene(scene);
            mystage.show();
        }
        else{
           System.out.println("failed");
        }
    }

    @FXML
    public void ncls(ActionEvent event) {
        nuser.setText("");
        npsw.setText("");
        
    }
    
}
