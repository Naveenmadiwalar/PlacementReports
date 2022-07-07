/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package naveen;

import java.lang.Math;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import test2.database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportController extends database implements Initializable {

    @FXML
    private Label stno;
    @FXML
    private Label estd;
    @FXML
    private Label pstd;
    @FXML
    private Label npstd;
    @FXML
    private Label pp;
    @FXML
    private Label mo;
    @FXML
    private Label cv;
    @FXML
    private Button stdd;

    /**
     * Initializes the controller class.
     */
    
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connect();
        
    String st="SELECT count(*) count from student";
    ResultSet s1;
    s1=select(st);
    int ts=0;
    try {
            s1.next();
            ts=s1.getInt("count");
             stno.setText(String.valueOf(s1.getInt("count")));
    } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
    }
   
    int es = 0;
    st="select count(*) count from student where CGPA>=7.5";
    s1=select(st);
    try {
            s1.next();
            es=s1.getInt("count");
    } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    int np=0;
    st="select count(distinct usn) count from placed";
    s1=select(st);
    try {
            s1.next();
            np=s1.getInt("count");
    } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
 
        estd.setText(String.valueOf(es));
        pstd.setText(String.valueOf(np));
        npstd.setText(String.valueOf((es-np)));
      
        double s=(double)((np*100)/es);
        System.out.println(s);
       pp.setText(String.valueOf(s));
       
       
     //  st="";
       
    mo.setText("10");

    int nc=0;
    st="select count(distinct c_id) count from placed";
    s1=select(st);
    try {
            s1.next();
            nc=s1.getInt("count");
    } catch (SQLException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
    }
       cv.setText(String.valueOf(nc));
    }    
    Stage mystage;
    @FXML
    
    public void stdd(ActionEvent event) throws IOException {
       Parent report;
         
            report= FXMLLoader.load(getClass().getResource("Table.fxml"));
           
            mystage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(report);
            mystage.setTitle("placment report");
            mystage.setScene(scene);
            mystage.show();
    }
    
}
