package Controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ControlleurIJ implements Initializable {

	private int[] cartes = new int[19];
	int[] carteJoueur1 = new int[6];
	int[] carteJoueur2 = new int[6];
	int pioche;
	int laMain = 1;
	
	@FXML private Pane pj1;
	@FXML private Pane pj2;
	@FXML private Pane pj3;
	@FXML private Pane pj4;

	@FXML private Button bj11;
	@FXML private Button bj12;
	@FXML private Button bj13;
	@FXML private Button bj14;
	@FXML private Button bj15;
	@FXML private Button bj16;

	@FXML private Button bj21;
	@FXML private Button bj22;
	@FXML private Button bj23;
	@FXML private Button bj24;
	@FXML private Button bj25;
	@FXML private Button bj26;

	@FXML private Button bj31;
	@FXML private Button bj32;
	@FXML private Button bj33;
	@FXML private Button bj34;
	@FXML private Button bj35;
	@FXML private Button bj36;

	@FXML private Button bj41;
	@FXML private Button bj42;
	@FXML private Button bj43;
	@FXML private Button bj44;
	@FXML private Button bj45;
	@FXML private Button bj46;

	@FXML private Button bpp;
	@FXML private Button bpj;
	
	@FXML private Label nj1;
	@FXML private Label nj2;
	@FXML private Label nj3;
	@FXML private Label nj4;

	@FXML private Label lj11;
	@FXML private Label lj12;
	@FXML private Label lj13;
	@FXML private Label lj14;
	@FXML private Label lj15;
	@FXML private Label lj16;
	@FXML private Label lj17;

	@FXML private Label lj21;
	@FXML private Label lj22;
	@FXML private Label lj23;
	@FXML private Label lj24;
	@FXML private Label lj25;
	@FXML private Label lj26;
	@FXML private Label lj27;

	@FXML private Label lj31;
	@FXML private Label lj32;
	@FXML private Label lj33;
	@FXML private Label lj34;
	@FXML private Label lj35;
	@FXML private Label lj36;
	@FXML private Label lj37;

	@FXML private Label lj41;
	@FXML private Label lj42;
	@FXML private Label lj43;
	@FXML private Label lj44;
	@FXML private Label lj45;
	@FXML private Label lj46;
	@FXML private Label lj47;

	@FXML private ImageView cb;
	
	@FXML private ImageView c11;
	@FXML private ImageView c12;
	@FXML private ImageView c13;
	@FXML private ImageView c14;
	@FXML private ImageView c15;
	@FXML private ImageView c16;
	
	@FXML private ImageView c21;
	@FXML private ImageView c22;
	@FXML private ImageView c23;
	@FXML private ImageView c24;
	@FXML private ImageView c25;
	@FXML private ImageView c26;
	
	@FXML private WebView carteM;
	
	@Override
	 public void initialize(URL url, ResourceBundle rb) {
		carteM.getEngine().load("file:///D:/Devoirs/4eme_annee_ensim/PJ%2024H/THE-KMER_24H/1024Bornes/rsc/Mappy/api-ajax-mappy-5.4.1-12/dist/mappy.html");
		
		//initialisation des cartes
		cartes[CONSTANTES.Accident] = 3;
		cartes[CONSTANTES.Panne_Essence] =  3;
		cartes[CONSTANTES.Creve] = 3;
		cartes[CONSTANTES.Limite_50] = 4;
		cartes[CONSTANTES.Stop] = 5;
		
		cartes[CONSTANTES.Reparation] = 6;
		cartes[CONSTANTES.Essence] = 6;
		cartes[CONSTANTES.Secours] = 6;
		cartes[CONSTANTES.Fin_limite]= 6;
		cartes[CONSTANTES.Roulez] = 14;
		
		cartes[CONSTANTES.As_Volant] = 1;
		cartes[CONSTANTES.Citerne] = 1;
		cartes[CONSTANTES.Increvable] = 1;
		cartes[CONSTANTES.Prioritaire] = 1;
		
		cartes[CONSTANTES.Speed25] = 10;
		cartes[CONSTANTES.Speed50] = 10;
		cartes[CONSTANTES.Speed75] = 10;
		cartes[CONSTANTES.Speed100] = 12;
		cartes[CONSTANTES.Speed200] = 14;
		
		//if(Contoller_Acceuil.nbj == 2){
			int valAl,nbA1=0,nbA2=0;
			
			for(int i = 0 ;i < 6 ; i++){
				valAl = (int) (Math.random() * ( 18 - 0 ));
				while(cartes[valAl] == 0)
					valAl = (int) (Math.random() * ( 18 - 0 ));
				carteJoueur1[i] = valAl;
				
				if(valAl == CONSTANTES.Stop || valAl == CONSTANTES.Roulez )lj11.setText("True");else lj11.setText("False");
				if(valAl == CONSTANTES.Limite_50)lj12.setText("True");else lj12.setText("False");
				if(valAl == CONSTANTES.Accident) nbA1++;
			}
			lj13.setText(""+nbA1);
			
			valAl = 0;
			for(int i = 0 ;i < 6 ; i++){
				valAl = (int) (Math.random() * ( 18 - 0 ));
				while(cartes[valAl] == 0)
					valAl = (int) (Math.random() * ( 18 - 0 ));
				carteJoueur2[i] = valAl;
				
				if(valAl == CONSTANTES.Stop || valAl == CONSTANTES.Roulez )lj21.setText("True");else lj21.setText("False");
				if(valAl == CONSTANTES.Limite_50)lj22.setText("True");else lj22.setText("False");
				if(valAl == CONSTANTES.Accident) nbA2++;
			}
			lj23.setText(""+nbA2);
			
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			c12.setImage(CONSTANTES.coresNumIm(carteJoueur1[1]));
			c13.setImage(CONSTANTES.coresNumIm(carteJoueur1[2]));
			c14.setImage(CONSTANTES.coresNumIm(carteJoueur1[3]));
			c15.setImage(CONSTANTES.coresNumIm(carteJoueur1[4]));
			c16.setImage(CONSTANTES.coresNumIm(carteJoueur1[5]));
			
			cacheCartesJ2();
			
			cb.setImage(CONSTANTES.i19);
		//}
	}
	
	void cacheCartesJ1(){
		c11.setImage(CONSTANTES.i19);
		c12.setImage(CONSTANTES.i19);
		c13.setImage(CONSTANTES.i19);
		c14.setImage(CONSTANTES.i19);
		c15.setImage(CONSTANTES.i19);
		c16.setImage(CONSTANTES.i19);
	}
	
	void montreCartesJ1(int c0, int c1, int c2,int c3,int c4,int c5){
		c11.setImage(CONSTANTES.coresNumIm(c0));
		c12.setImage(CONSTANTES.coresNumIm(c1));
		c13.setImage(CONSTANTES.coresNumIm(c2));
		c14.setImage(CONSTANTES.coresNumIm(c3));
		c15.setImage(CONSTANTES.coresNumIm(c4));
		c16.setImage(CONSTANTES.coresNumIm(c5));
	}
	
	void cacheCartesJ2(){
		c21.setImage(CONSTANTES.i19);
		c22.setImage(CONSTANTES.i19);
		c23.setImage(CONSTANTES.i19);
		c24.setImage(CONSTANTES.i19);
		c25.setImage(CONSTANTES.i19);
		c26.setImage(CONSTANTES.i19);
	}
	
	void montreCartesJ2(int c0, int c1, int c2,int c3,int c4,int c5){
		c21.setImage(CONSTANTES.coresNumIm(c0));
		c22.setImage(CONSTANTES.coresNumIm(c1));
		c23.setImage(CONSTANTES.coresNumIm(c2));
		c24.setImage(CONSTANTES.coresNumIm(c3));
		c25.setImage(CONSTANTES.coresNumIm(c4));
		c26.setImage(CONSTANTES.coresNumIm(c5));
	}
	
	/**/
	@FXML
	protected void dobj11(ActionEvent event) throws IOException, InterruptedException {
		if(laMain == 1){
			carteJoueur1[0] = (int) (Math.random() * ( 18 - 0 ));
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			laMain = 2;
			cacheCartesJ1();
			Thread.sleep(1000);
			montreCartesJ2(carteJoueur2[0],carteJoueur2[1],carteJoueur2[2],carteJoueur2[3],carteJoueur2[4],carteJoueur2[5]);
		}
	}
	@FXML
	protected void dobj12(ActionEvent event) throws IOException, InterruptedException {
		if(laMain == 1){
			carteJoueur1[1] = (int) (Math.random() * ( 18 - 0 ));
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			laMain = 2;
			cacheCartesJ1();
			Thread.sleep(1000);
			montreCartesJ2(carteJoueur2[0],carteJoueur2[1],carteJoueur2[2],carteJoueur2[3],carteJoueur2[4],carteJoueur2[5]);
		}
	}
	@FXML
	protected void dobj13(ActionEvent event) throws IOException, InterruptedException {
		if(laMain == 1){
			carteJoueur1[2] = (int) (Math.random() * ( 18 - 0 ));
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			laMain = 2;
			cacheCartesJ1();
			Thread.sleep(1000);
			montreCartesJ2(carteJoueur2[0],carteJoueur2[1],carteJoueur2[2],carteJoueur2[3],carteJoueur2[4],carteJoueur2[5]);
		}
	}
	@FXML
	protected void dobj14(ActionEvent event) throws IOException, InterruptedException {
		if(laMain == 1){
			carteJoueur1[3] = (int) (Math.random() * ( 18 - 0 ));
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			laMain = 2;
			cacheCartesJ1();
			Thread.sleep(1000);
			montreCartesJ2(carteJoueur2[0],carteJoueur2[1],carteJoueur2[2],carteJoueur2[3],carteJoueur2[4],carteJoueur2[5]);
		}
	}
	@FXML
	protected void dobj15(ActionEvent event) throws IOException, InterruptedException {
		if(laMain == 1){
			carteJoueur1[4] = (int) (Math.random() * ( 18 - 0 ));
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			laMain = 2;
			cacheCartesJ1();
			Thread.sleep(1000);
			montreCartesJ2(carteJoueur2[0],carteJoueur2[1],carteJoueur2[2],carteJoueur2[3],carteJoueur2[4],carteJoueur2[5]);
		}
	}
	@FXML
	protected void dobj16(ActionEvent event) throws IOException, InterruptedException {
		if(laMain == 1){
			carteJoueur1[5] = (int) (Math.random() * ( 18 - 0 ));
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			laMain = 2;
			cacheCartesJ1();
			Thread.sleep(1000);
			montreCartesJ2(carteJoueur2[0],carteJoueur2[1],carteJoueur2[2],carteJoueur2[3],carteJoueur2[4],carteJoueur2[5]);
		}
	}


	/**/
	@FXML
	protected void dobj21(ActionEvent event) throws IOException, InterruptedException {
		if(laMain == 2){
			carteJoueur2[0] = (int) (Math.random() * ( 18 - 0 ));
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			laMain = 1;
			cacheCartesJ2();
			Thread.sleep(1000);
			montreCartesJ1(carteJoueur1[0],carteJoueur1[1],carteJoueur1[2],carteJoueur1[3],carteJoueur1[4],carteJoueur1[5]);
		}
	}
	@FXML
	protected void dobj22(ActionEvent event) throws IOException, InterruptedException {
		if(laMain == 2){
			carteJoueur2[1] = (int) (Math.random() * ( 18 - 0 ));
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			laMain = 1;
			cacheCartesJ2();
			Thread.sleep(1000);
			montreCartesJ1(carteJoueur1[0],carteJoueur1[1],carteJoueur1[2],carteJoueur1[3],carteJoueur1[4],carteJoueur1[5]);
		}
	}
	@FXML
	protected void dobj23(ActionEvent event) throws IOException, InterruptedException {
		if(laMain == 2){
			carteJoueur2[2] = (int) (Math.random() * ( 18 - 0 ));
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			laMain = 1;
			cacheCartesJ2();
			Thread.sleep(1000);
			montreCartesJ1(carteJoueur1[0],carteJoueur1[1],carteJoueur1[2],carteJoueur1[3],carteJoueur1[4],carteJoueur1[5]);
		}
	}
	@FXML
	protected void dobj24(ActionEvent event) throws IOException, InterruptedException {
		if(laMain == 2){
			carteJoueur2[3] = (int) (Math.random() * ( 18 - 0 ));
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			laMain = 1;
			cacheCartesJ2();
			Thread.sleep(1000);
			montreCartesJ1(carteJoueur1[0],carteJoueur1[1],carteJoueur1[2],carteJoueur1[3],carteJoueur1[4],carteJoueur1[5]);
		}
	}
	@FXML
	protected void dobj25(ActionEvent event) throws IOException, InterruptedException {
		if(laMain == 2){
			carteJoueur2[4] = (int) (Math.random() * ( 18 - 0 ));
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			laMain = 1;
			cacheCartesJ2();
			Thread.sleep(1000);
			montreCartesJ1(carteJoueur1[0],carteJoueur1[1],carteJoueur1[2],carteJoueur1[3],carteJoueur1[4],carteJoueur1[5]);
		}
	}
	@FXML
	protected void dobj26(ActionEvent event) throws IOException, InterruptedException {
		if(laMain == 2){
			carteJoueur2[5] = (int) (Math.random() * ( 18 - 0 ));
			c11.setImage(CONSTANTES.coresNumIm(carteJoueur1[0]));
			laMain = 1;
			cacheCartesJ2();
			Thread.sleep(1000);
			montreCartesJ1(carteJoueur1[0],carteJoueur1[1],carteJoueur1[2],carteJoueur1[3],carteJoueur1[4],carteJoueur1[5]);
		}
	}

	/**/
	@FXML
	protected void dobj31(ActionEvent event) throws IOException {

	}
	@FXML
	protected void dobj32(ActionEvent event) throws IOException {

	}
	@FXML
	protected void dobj33(ActionEvent event) throws IOException {

	}
	@FXML
	protected void dobj34(ActionEvent event) throws IOException {

	}
	@FXML
	protected void dobj35(ActionEvent event) throws IOException {

	}
	@FXML
	protected void dobj36(ActionEvent event) throws IOException {

	}

	/**/
	@FXML
	protected void dobj41(ActionEvent event) throws IOException {

	}
	@FXML
	protected void dobj42(ActionEvent event) throws IOException {

	}
	@FXML
	protected void dobj43(ActionEvent event) throws IOException {

	}
	@FXML
	protected void dobj44(ActionEvent event) throws IOException {

	}
	@FXML
	protected void dobj45(ActionEvent event) throws IOException {

	}
	@FXML
	protected void dobj46(ActionEvent event) throws IOException {

	}
	
	@FXML
	protected void dobk(ActionEvent event) throws IOException, InterruptedException {
		
		Stage cStage = (Stage)cb.getScene().getWindow();
		Scene sc = cStage.getScene();
		AnchorPane root = (AnchorPane) sc.getRoot();
		Pane p = (Pane) root.getChildren().get(0);
		Pane p0 = (Pane) p.getChildren().get(0);
		Pane sp = (Pane) p0.getChildren().get(2);
		sp.setVisible(true);
		
		pioche = (int) (Math.random() * ( 18 - 0 ));
		cb.setImage(CONSTANTES.coresNumIm(pioche));
	}
	
	@FXML
	protected void dopp(ActionEvent event) throws IOException, InterruptedException {
		Stage cStage = (Stage)cb.getScene().getWindow();
		Scene sc = cStage.getScene();
		AnchorPane root = (AnchorPane) sc.getRoot();
		Pane p = (Pane) root.getChildren().get(0);
		Pane p0 = (Pane) p.getChildren().get(0);
		Pane sp = (Pane) p0.getChildren().get(2);
		sp.setVisible(false);
		
		if(laMain == 1){
			laMain = 2;
			cacheCartesJ1();
			Thread.sleep(1000);
			montreCartesJ2(carteJoueur2[0],carteJoueur2[1],carteJoueur2[2],carteJoueur2[3],carteJoueur2[4],carteJoueur2[5]);
		}else{
			laMain = 1;
			cacheCartesJ2();
			Thread.sleep(1000);
			montreCartesJ1(carteJoueur1[0],carteJoueur1[1],carteJoueur1[2],carteJoueur1[3],carteJoueur1[4],carteJoueur1[5]);
		}
		cb.setImage(CONSTANTES.i19);
	}
	
	@FXML
	protected void dopj(ActionEvent event) throws IOException, InterruptedException {
		Stage cStage = (Stage)cb.getScene().getWindow();
		Scene sc = cStage.getScene();
		AnchorPane root = (AnchorPane) sc.getRoot();
		Pane p = (Pane) root.getChildren().get(0);
		Pane p0 = (Pane) p.getChildren().get(0);
		Pane sp = (Pane) p0.getChildren().get(2);
		sp.setVisible(false);
		
		if(laMain == 1){
			laMain = 2;
			cacheCartesJ1();
			Thread.sleep(1000);
			montreCartesJ2(carteJoueur2[0],carteJoueur2[1],carteJoueur2[2],carteJoueur2[3],carteJoueur2[4],carteJoueur2[5]);
		}else{
			laMain = 1;
			cacheCartesJ2();
			Thread.sleep(1000);
			montreCartesJ1(carteJoueur1[0],carteJoueur1[1],carteJoueur1[2],carteJoueur1[3],carteJoueur1[4],carteJoueur1[5]);
		}
		cb.setImage(CONSTANTES.i19);
	}
}
