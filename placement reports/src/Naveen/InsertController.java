/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Naveen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import test2.database;

/**
 * FXML Controller class
 *
 * @author Naveen Madiwalar
 */
public class InsertController extends database implements Initializable {

    @FXML
    private TextField susn;
    @FXML
    private TextField sname;
    @FXML
    private TextField scgpa;
    @FXML
    private TextField scon;
    @FXML
    private TextField smail;
    @FXML
    private ChoiceBox<String> sbranch;
    @FXML
    private ChoiceBox<String> ssem;
    @FXML
    private Button insertStd;
    @FXML
    private TextField cid;
    @FXML
    private TextField cname;
    @FXML
    private TextField ccon;
    @FXML
    private TextField cmail;
    @FXML
    private TextField coffer;
    @FXML
    private Button insertCmp;
    @FXML
    private TextField pusn;
    @FXML
    private TextField pcid;
    @FXML
    private TextField Ppkg;
    @FXML
    private Button insertPlaced;
    @FXML
    private Button cancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int check=connect();
        if(check==1){
            alert("Data base is not connect");
        }
        
        String str[]={"CSE","ECE","CIVIL","MECH","EEE"};
        String in[]={"sem","7","8"};
        sbranch.setItems(FXCollections.observableArrayList(str));
        sbranch.setValue("Branch");
        ssem.setItems(FXCollections.observableArrayList(in));
        ssem.setValue("sem");
    }    

    
    void alert(String str){
        Alert alMSG=new Alert(Alert.AlertType.INFORMATION);
        alMSG.setContentText(str);
        alMSG.show();
    }
    
    String query;
    @FXML
    public void onInsertStudent(ActionEvent event) {
        
        query="insert into Student values ('"+susn.getText()+"',"+"'"+sname.getText()+"',"+"'"+sbranch.getValue()+"',"+ssem.getValue()+","+scgpa.getText()+",'"+scon.getText()+"',"+"'"+smail.getText()+"')";
        int ch=insert(query);
        if(ch==1){
            alert("Failed to insert");
        }else{
            alert("Insertion Successfull....");

        }
        System.out.println(query);
    
    }

    @FXML
    public void onInsertCmp(ActionEvent event) {
        query="insert into company values ('"+cid.getText()+"','"+cname.getText()+"','"+ccon.getText()+"','"+cmail.getText()+"',"+coffer.getText()+")";
        int ch=insert(query);
        if(ch==1){
            alert("Failed to insert");
        }else{
            alert("Insertion Successfull....");

        }
        System.out.println(query);
    }

    @FXML
    public void onInsertPlaced(ActionEvent event) {
        query="insert into placed values ('"+pusn.getText()+"','"+pcid.getText()+"',"+Ppkg.getText()+")";
        int ch=insert(query);
        if(ch==1){
            alert("Failed to insert");
        }else{
            alert("Insertion Successfull....");

        }
        System.out.println(query);
    }

    
    Stage mystage;
    @FXML
    public void onCancel(ActionEvent event) throws IOException {
         Parent report;
         
            report= FXMLLoader.load(getClass().getResource("Table.fxml"));
           
            mystage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(report);
            mystage.setTitle("placment report");
            mystage.setScene(scene);
            mystage.show();
    }
    
}
