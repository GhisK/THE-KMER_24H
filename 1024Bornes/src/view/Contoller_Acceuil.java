package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Contoller_Acceuil implements Initializable{

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

	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		 NbJoueurs.setEditable(true);
		NbJoueurs.getItems().setAll("un joueur", "deux joueurs", "trois joueurs","quatres joueurs");
		NbJoueurs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override    public void changed(ObservableValue<? extends String> selected, String oldV, String newV) {
		    	if (oldV != null) {
			        switch(oldV) {
			            case "un joueur": System.out.println("1"); break;
			            case "deux joueurs": System.out.println("2"); break;
			            case "trois joueurs": System.out.println("3"); break;
			            case "quatres joueurs": System.out.println("3"); break;

			        }
			    }

			   }

	   });
	}
	protected void doStart(ActionEvent event) throws IOException {
		 System.out.println("doStart");

}
	protected void doQuit(ActionEvent event) throws IOException {
		 System.out.println("doQuit");
}

}

