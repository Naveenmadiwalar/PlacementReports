/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package naveen;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import test2.database;

/**
 * FXML Controller class
 *
 * @author Naveen Madiwalar
 */
public class TableController extends database implements Initializable {

    @FXML
    private TableView<Details> table;
    @FXML
    private TableColumn<Details, String> usn;
    @FXML
    private TableColumn<Details, String> name;
    @FXML
    private TableColumn<Details, String> branch;
    @FXML
    private TableColumn<Details, Integer> sem;
    @FXML
    private TableColumn<Details, String> company;
    @FXML
    private TableColumn<Details, Integer> pkg;
    @FXML
    private Button back;
    @FXML
    private Button logout;
    @FXML
    private Button insert;
    @FXML
    private Button delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connect();
        try{
                sem.setCellValueFactory(new PropertyValueFactory <Details, Integer>("sem"));
                usn.setCellValueFactory(new PropertyValueFactory <Details, String>("usn"));
                name.setCellValueFactory(new PropertyValueFactory <Details, String>("name"));
                branch.setCellValueFactory(new PropertyValueFactory <Details, String>("branch"));
                company.setCellValueFactory(new PropertyValueFactory <Details, String>("company"));
                pkg.setCellValueFactory(new PropertyValueFactory <Details, Integer>("Package"));
               table.setItems(display());
        }catch(Exception e){
            System.out.println("initilization error");
        }
    }    

    Stage mystage;
    @FXML
    public void onBack(ActionEvent event) throws IOException {
         Parent report;
         
         report= FXMLLoader.load(getClass().getResource("report.fxml"));
           
         mystage=(Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(report);
         mystage.setTitle("placment report");
         mystage.setScene(scene);
         mystage.show();
    }

    Stage primaryStage;
    @FXML
    public void onLogout(ActionEvent event) throws IOException {
        Parent login;
                       
        login= FXMLLoader.load(getClass().getResource("nlogin.fxml"));
        
        Scene scene = new Scene(login);
        primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        primaryStage.setTitle("login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void onInsert(ActionEvent event) throws IOException {
        Parent login;
                       
        login= FXMLLoader.load(getClass().getResource("insert.fxml"));
        
        Scene scene = new Scene(login);
        primaryStage=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        primaryStage.setTitle("Insert ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void alert(String str){
        Alert alMSG=new Alert(Alert.AlertType.INFORMATION);
        alMSG.setContentText(str);
        alMSG.show();
    }
    @FXML
    public void onDelete(ActionEvent event) throws SQLException {
        int ch;
        Details d=table.getSelectionModel().getSelectedItem();
        Alert alMSG=new Alert(Alert.AlertType.CONFIRMATION);
        alMSG.setContentText("Do you want to delete?");
        Optional<ButtonType> result=alMSG.showAndWait();
        
        if(result.isPresent() && result.get()==ButtonType.OK){
            String str="DELETE FROM `placed` WHERE usn='"+d.getUsn()+"' and c_id = ( select c_id from company where cname='"+d.getCompany()+"')";
        ch=delete(str);
        if(ch==1){
            alert("Failed to delete");
        }else{
            alert("Deletion Successfull....");
            table.setItems(display());

        }
        System.out.println(str);
        }
        
        
    }
    
}
