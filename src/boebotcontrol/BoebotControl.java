/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boebotcontrol;

import com.mysql.cj.*;
import com.sun.*;
import com.mysql.*;
import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.json.JSONObject;

/**
 *
 * @author rutge
 */
public class BoebotControl extends Application {
    
    public Connection con;
    public Statement stmt;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        Label Xlbl = new Label("X: ");
        Label Ylbl = new Label("Y: ");
        Spinner Xspin = new Spinner(1, 30, 1);
        Spinner Yspin = new Spinner(1, 30, 1);
        btn.setText("Set grid");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String xout = Xspin.getValue().toString();
                String yout = Yspin.getValue().toString();
                JSONObject obj = new JSONObject();
                obj.put("x", xout);
                obj.put("y", yout);
                /*try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection(“jdbc:mysql://localhost:3306/boebot",“gebruiker",“wachtwoord");  
                    Statement stmt=con.createStatement(); 
                    stmt.execute("INSERT INTO route VALUES ( 0, 'LINKS', 'LINKS', 'RECHTS')");
                            }catch(Exception ex){
                                System.out.println("Database fout!");
        }*/

                

                System.out.println(obj);
            }
        });
        
        GridPane root = new GridPane();
        root.add(Xlbl, 0, 0);
        root.add(Xspin, 1, 0);
        root.add(Ylbl, 0, 1);
        root.add(Yspin, 1, 1);
        root.add(btn, 1, 2);
        
        Scene scene = new Scene(root, 150, 100);
        
        primaryStage.setTitle("BoeBot Controller");
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
