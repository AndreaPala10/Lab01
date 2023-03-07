package it.polito.tdp.Lab01;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.Lab01.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnCancella;
    
    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTempo;

    @FXML
    void doInsert(ActionEvent event) {
    	Long start=System.nanoTime();
    	
    	elenco.addParola(this.txtParola.getText());
    	
    	this.txtResult.clear();
    	for(String s: elenco.getElenco()) {
    		if(s!="")
    			this.txtResult.appendText(s+"\n");
    	}
    	this.txtParola.clear();
    	Long end=System.nanoTime();
    	this.txtTempo.setText(""+(end-start));
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	Long start=System.nanoTime();
    	
    	elenco.reset();
    	this.txtResult.clear();
    	
    	Long end=System.nanoTime();
    	this.txtTempo.setText(""+(end-start));
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	Long start=System.nanoTime();
    	
    	String daRimuovere=this.txtParola.getText();
    	elenco.cancella(daRimuovere);
    	
    	this.txtResult.clear();
    	for(String s: elenco.getElenco()) {
    		this.txtResult.appendText(s+"\n");
    	}
    	this.txtParola.clear();
    	Long end=System.nanoTime();
    	this.txtTempo.setText(""+(end-start));
    	
    	
    }
    

    @FXML
    void initialize() {
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }

}
