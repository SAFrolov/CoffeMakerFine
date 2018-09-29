/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffemakerfine;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author safrolov
 */
public class FXMLDocumentController implements Initializable {
   public coffee c1=new coffee(2000, 1000, 100);
        
        //max and min
        public static int max_water=2000;
        public static int min_water=200;
        public static int max_milk=1000;
        public static int min_milk=150;
        public static int max_coffee_mg=100;
        public static int min_coffee_mg=20; 
       
        //capuchino
        public static int capuch_water=150;
        public static int capuch_milk=100;
        public static int capuch_coffee=15;
    
        //espresso
        public static int espresso_water=200;
        public static int espresso_milk=0;
        public static int espresso_coffee=20;        
        
        @FXML private Label message;    
        @FXML private Label amount;
        @FXML private TextField add;
        

    @FXML
    private void btnMake(ActionEvent event){
        message.setText(c1.prepare_coffee(capuch_water, capuch_milk, capuch_coffee));
        amount.setText(c1.toString());
    }

    @FXML
    private void btnMakeEx(ActionEvent event){
        message.setText(c1.prepare_coffee(espresso_water, espresso_milk, espresso_coffee));
        amount.setText(c1.toString());
    }
    
    @FXML
    private void btnAddWater(ActionEvent event){
        c1.add(0, Integer.parseInt(add.getText()));
        message.setText(c1.maxMin());
        amount.setText(c1.toString());
        System.out.println("added water");
    }    
    
    @FXML
    private void btnAddMilk(ActionEvent event){
        c1.add(1, Integer.parseInt(add.getText()));
        message.setText(c1.maxMin());
        amount.setText(c1.toString());       
    }      
    
    @FXML
    private void btnAddCoffee(ActionEvent event){
        c1.add(2, Integer.parseInt(add.getText()));
        message.setText(c1.maxMin());
        amount.setText(c1.toString());
    }  
    
    @FXML
    private void btnClean(ActionEvent event){
        c1.clean();
        message.setText("ready");
        amount.setText(c1.toString());
    }              
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c1.clean();
        c1.setMaxMin(min_water, max_water, min_milk, max_milk, min_coffee_mg, max_coffee_mg);
        message.setText(c1.maxMin());
        amount.setText(c1.toString());
    }    
    
}
