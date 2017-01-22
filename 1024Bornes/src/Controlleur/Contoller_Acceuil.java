package Controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Contoller_Acceuil implements Initializable{
	
	public static int nbj = 0;
	
	@FXML private TextField PtDepart;
	@FXML private TextField J1;
	@FXML private TextField J2;
	@FXML private TextField J3;
	@FXML private TextField J4;

	@FXML private Label NbJoueursL;
	@FXML private Label PtDepartL;
	@FXML private Label J1L;
	@FXML private Label J2L;
	@FXML private Label J3L;
	@FXML private Label J4L;

	@FXML private Button Start;
	@FXML private Button Quit;

	@FXML private ComboBox<String> NbJoueurs;

	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		
		 NbJoueurs.getItems().setAll( "deux joueurs", "trois joueurs","quatres joueurs");
		 NbJoueurs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> selected, String oldV, String newV) {
		    	if (newV != null) {
			        switch(newV) {
			            case "deux joueurs":{
			            	J1.setVisible(true);
			            	J2.setVisible(true);
			            	J3.setVisible(false);
			            	J4.setVisible(false);
			            	nbj = 2;
			            	break;
			            }
			            case "trois joueurs": {
			            	J1.setVisible(true);
			            	J2.setVisible(true);
			            	J3.setVisible(true);
			            	J4.setVisible(false);
			            	nbj = 3;
			            	break;
			            }
			            case "quatres joueurs": {
			            	J1.setVisible(true);
			            	J2.setVisible(true);
			            	J3.setVisible(true);
			            	J4.setVisible(true);
			            	nbj = 4;
			            	break;
			            }
			        }
			    }

			   }

	   });
	}
	
	@FXML
	protected void doStart(ActionEvent event) throws IOException {
		 System.out.println("doStart");
		 if (nbj != 0){
			 System.out.println(J1.getText());
			 String j1 = J1.getText();
			 String j2 = J2.getText();
			 String j3 = J3.getText();
			 String j4 = J4.getText();
			 
			 //fermeture de la fenetre de connection
		     Stage cStage = (Stage)Start.getScene().getWindow();
		     cStage.close();  
		        
		     //ouverture de la fenetre Client
		     final URL url = getClass().getResource("/view/InterfaceJoueur.fxml");
		     final FXMLLoader fxmlLoader = new FXMLLoader(url);
		     final AnchorPane root = (AnchorPane) fxmlLoader.load();
		     final Scene scene = new Scene(root);
		     scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
		     final Stage stage = new Stage();
		     stage.setScene(scene);
		     stage.show();
		     stage.requestFocus();
		     
		     Pane p = (Pane) root.getChildren().get(0);
		     Pane p1 = (Pane) p.getChildren().get(1);
		     Pane p2 = (Pane) p.getChildren().get(2);
		     Pane p3 = (Pane) p.getChildren().get(3);
		     Pane p4 = (Pane) p.getChildren().get(4);
		     Label n1 = (Label) p1.getChildren().get(6);n1.setText(j1);
		     Label n2 = (Label) p2.getChildren().get(6);n2.setText(j2);
		     Label n3 = (Label) p3.getChildren().get(6);n3.setText(j3);
		     Label n4 = (Label) p4.getChildren().get(6);n4.setText(j4);
		     switch(nbj) {
		     	case 2 :{
		     		p1.setVisible(true);
		     		p2.setVisible(true);
		     		p3.setVisible(false);
		     		p4.setVisible(false);
		     		break;
	         	}
	         	case 3 :{
	         		p1.setVisible(true);
		     		p2.setVisible(true);
		     		p3.setVisible(true);
		     		p4.setVisible(false);
	         		break;
			    }
				case 4 :{
					p1.setVisible(true);
		     		p2.setVisible(true);
		     		p3.setVisible(true);
		     		p4.setVisible(true);
					break;
				}
		     }
		 }
		 else{
			 Alert dialogE = new Alert(AlertType.ERROR);
	        	dialogE.setTitle("ERREUR");
	        	dialogE.setHeaderText("NOMBRE DE JOUEURS");
	        	dialogE.setContentText("Veillez choisir le nombre de joueurs !!!");
	        	dialogE.showAndWait();
		 }
	}
	
	@FXML
	protected void doQuit(ActionEvent event) throws IOException {
		 System.out.println("doQuit");
		 //fermeture de la fenetre de connection
	     Stage cStage = (Stage)Start.getScene().getWindow();
	     cStage.close();
	}

}

