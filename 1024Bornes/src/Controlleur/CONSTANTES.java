package Controlleur;

import javafx.scene.image.Image;

public abstract class  CONSTANTES {

	public static final int Accident = 0;
	public static final int Panne_Essence = 1;
	public static final int Creve = 2;
	public static final int Limite_50 = 3;
	public static final int Stop = 4;
	
	public static final int Reparation = 5;
	public static final int Essence = 6;
	public static final int Secours = 7;
	public static final int Fin_limite = 8;
	public static final int Roulez = 9;
	
	public static final int As_Volant = 10;
	public static final int Citerne = 11;
	public static final int Increvable = 12;
	public static final int Prioritaire = 13;
	
	public static final int Speed25 = 14;
	public static final int Speed50 = 15;
	public static final int Speed75 = 16;
	public static final int Speed100 = 17;
	public static final int Speed200 = 18;
	
	public static final int VIDE = 19;
	
	public static final Image i0 = new Image("/cartes/Accident.jpg");
	public static final Image i1 = new Image("/cartes/Panne_Essence.jpg");
	public static final Image i2 = new Image("/cartes/Creve.jpg");
	public static final Image i3 = new Image("/cartes/Limite_50.jpg");
	public static final Image i4 = new Image("/cartes/Stop.jpg");
	
	public static final Image i5 = new Image("/cartes/Reparation.jpg");
	public static final Image i6 = new Image("/cartes/Essence.jpg");
	public static final Image i7 = new Image("/cartes/Secours.jpg");
	public static final Image i8 = new Image("/cartes/Fin_limite.jpg");
	public static final Image i9 = new Image("/cartes/Roulez.jpg");
	
	public static final Image i10 = new Image("/cartes/As_Volant.jpg");
	public static final Image i11 = new Image("/cartes/Citerne.jpg");
	public static final Image i12 = new Image("/cartes/Increvable.jpg");
	public static final Image i13 = new Image("/cartes/Prioritaire.jpg");
	
	public static final Image i14 = new Image("/cartes/Speed25.jpg");
	public static final Image i15 = new Image("/cartes/Speed50.jpg");
	public static final Image i16 = new Image("/cartes/Speed75.jpg");
	public static final Image i17 = new Image("/cartes/Speed100.jpg");
	public static final Image i18 = new Image("/cartes/Speed200.jpg");
	
	public static Image coresNumIm(int num){
		
		 switch(num) {
	     	case 0 :{return i0;}
	     	case 1 :{return i1;}
			case 2 :{return i2;}
			case 3 :{return i3;}
	     	case 4 :{return i4;}
			case 5 :{return i5;}
			case 6 :{return i6;}
	     	case 7 :{return i7;}
			case 8 :{return i8;}
			case 9 :{return i9;}
	     	case 10 :{return i10;}
			case 11 :{return i11;}
			case 12 :{return i12;}
	     	case 13 :{return i13;}
			case 14 :{return i14;}
			case 15 :{return i15;}
	     	case 16 :{return i16;}
			case 17 :{return i17;}
			case 18 :{return i18;}
	     }
		return null;
	}
	
}
