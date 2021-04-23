/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.AnagrammiModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	AnagrammiModel model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="bntCalcola"
    private Button bntCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtErrati"
    private TextArea txtErrati; // Value injected by FXMLLoader

    @FXML // fx:id="bntReset"
    private Button bntReset; // Value injected by FXMLLoader

    @FXML
    void doCalcola(ActionEvent event) {

    	String parola;
    	
    	txtCorretti.clear();
    	txtErrati.clear();
    	
    	parola =txtParola.getText();
    	
    	if(parola.length()<2) {
    		txtCorretti.setText("Parola troppo corta");
    		txtErrati.setText("Parola troppo corta");
    		return;
    	}
    	
    	if(parola.length()>8) {
    		txtCorretti.setText("Parola troppo lunga");
    		txtErrati.setText("Parola troppo lunga");
    		return;
    	}
    	
    	Set<String> anagrammi = this.model.calcolaAnagrammi(parola);
    	
    	for(String anagramma : anagrammi ) {
    		if(this.model.isCorrect(anagramma)) {
    			txtCorretti.appendText(anagramma + "\n");
    		}
    		else {
    			txtErrati.appendText(anagramma+"\n");
    		}
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	txtParola.clear();
    }
    
    public void setModel(AnagrammiModel model) {
   		this.model = model;
   	}

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bntCalcola != null : "fx:id=\"bntCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bntReset != null : "fx:id=\"bntReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

