/**   
 * Dit stuk code heeft een bepaalde functie, maar is nog niet helemaal af. Hier volgt een uitleg hoe je deze code kan gebruiken.
 * Omdat we nog geen UI hebben werkt zo: de vergelijking moet je als volgt zien:
 *  A0*X^B0 + A1*X^B1 + A2*X^B2 enz. = 0, behalve als er in toewijzen()  voor die bepaalde vergelijking een C staat, dan 0 --> C
 * Dit is zo behalve als de formule een log of een A^X bevat. Dan is de groep met de boolean ==true anders. 
 * Hierin is A0,1,2 = AScan[] & B0,1,2 = BScan[]. De log boolean = logArray en de A^X boolean = AtotX 
 * static int n is het aantal groepen, dit moet altijd gelijk zijn aan het aantal waardes in de arrays, anders werkt het niet
 * Als je het volgende voorbeeld neemt: A0*X^B0 + A1*X^B1 + A2*X^B2 = 0 dan is n gelijk aan 3.
 * om de vergelijking te veranderen moet je dus de waardes van AScan, BScan, AtotX en logArray veranderen.
 * De waardes van AScan, BScan, AtotX en logArray moet je van boven naar beneden veranderen. Dus als je een b van twee wilt hebben moet die bovenaan staan
 * Dit doen we, omdat we de UI de formule al op volgorde laten zetten.
 * 
 * We hebben niet heel veel tijd gehad om de code te testen. Er kunnen nog logical errors inzitten, deze halen wij er dan voor het volgende deel uit
 */


// groepen zijn bruikbaar als bij bijb, ax^2 a groter is dan 0 of a kleiner dan 0
public class VergelijkingenExactOplossen {
	
	static int n = 3;
	static double[] BwaardesVoorClass = Bwaardes(n); // hier komen public static arrays en variabelen, om de waardes van A, B, log en sin te ontvagen van de UI.
	static double[]	AwaardesVoorClass = Awaardes(n);
	
	public static boolean[] AtotX(int n){
		boolean Atotx[] = new boolean[n];	
		Atotx[0] = true;
		Atotx[1] = false;
		Atotx[2] = false;
		return Atotx;
	}
	public static boolean[] logArray(int n){
		boolean log[] = new boolean[n];
		log[0] = false;
		log[1] = false;
		log[2] = false;
		return log;
	}
	
	public static double[] Awaardes(int n){ 						// doorgegeven scans woorden aan de array toegewezen
		double[] AScan = new double[n];   		// AScan[] zijn de waardes die de UI heeft doorgestuurd voor de hierboven toegelichtte waardes van A
		AScan[0] = 2.0;						// De waardes in deze code voor: AScan, BScan, logArray en sinArray zijn tijdelijk. Gebruikt als steigers.
		AScan[1] = 6.0;		
		AScan[2] = 1.5;		
		return AScan;
	}
	
	public static double[] Bwaardes(int n){
		
		double[] BScan = new double[n];   	// BScan[] zijn de waardes die de UI heeft doorgestuurd voor de hierboven toegelichtte waardes van B 
		BScan[0] = 2.0;		
		BScan[1] = 1.0;	
		BScan[2] = 1.0;	
		return BScan;
	}
	// hoeveel groepen een loga ritme hebben
	public static int timesLog( boolean[] A){ // Tellen hoeveel groepen er van de doorgegeven groepen bruikbaar zijn
		int i= A.length-1;
		int aantal=0;
		int keer = A.length;
		while(keer>0){
			if(A[i]== true){
				aantal++;
			}
			i--;
			keer--;
		}
		return aantal;
	}
	public static int timesAtotX( boolean[] A){ // Tellen hoeveel groepen er van de doorgegeven groepen bruikbaar zijn
		int i= A.length-1;
		int aantal=0;
		int keer = A.length;
		while(keer>0){
			if(A[i]== true){
				aantal++;
			}
			i--;
			keer--;
		}
		return aantal;
	}
	// hoeveel groepen er werkelijk zijn(groepen met A=0 er uit halen)
	public static int timesA( double A[]){ // Tellen hoeveel groepen er van de doorgegeven groepen bruikbaar zijn
		int i= A.length-1;
		int aantal=0;
		int keer = A.length;
		while(keer>0){
			if(A[i]>0 || A[i]<0){
				aantal++;
			}
			i--;
			keer--;
		}
		return aantal;
	}
	// hoeveel van de groepen een macht hebben
	public static int timesB( double A[]){ // Tellen hoeveel groepen er van de doorgegeven groepen een macht hebben
		int i= A.length-1;
		int aantal=0;
		int keer = A.length;
		while(keer>0){
			if(A[i]>1.0 || A[i]<1.0){
				aantal++;					// aantal machten die aanders zijn dan 1 gaat 1 omhoog
			}
			i--;
			keer--;
		}
		return aantal;
	}
	//ax^b = c
    public static double eenTermOplossen(double a, double b, double c){
    	double xvinden;
    	xvinden = Math.pow((c/a),( 1/b));
    	return xvinden;
    }
    //ax^b + dx = 0
    public static void simpelOntbinden(double A, double kwadraat, double B){
 		double kwadraatAntwoord = 1/( kwadraat -1);
 		if (kwadraat >=1 && kwadraat <=-1)   {
 			if((kwadraat)%2 ==0){
 				double antwoord = -1 * Math.pow( B/A, kwadraatAntwoord);
 				System.out.println("De vergelijking lost op bij x= 0 & bij x= "+ antwoord );
 			}	
 			else{
 				double antwoord = -1 * Math.pow( B/A, kwadraatAntwoord); 
 				System.out.println("De vergelijking lost op bij x= 0 & bij x= "+ antwoord+ " & bij x= "+ -antwoord );
 			}
 			}
 			else {
 				double antwoord = -1 * Math.pow( B/A, kwadraatAntwoord);
 				System.out.println("De vergelijking is nul bij x= 0 & bij x= "+ antwoord );
 			}
 	}
  
    // kwadratischeformule1 & kwadratischeformule2 lossen ax^2 + bx + d = c op
    public static double kwadratischeformule1(double a, double b, double c){
    	double abcd1, abcd2;
        abcd1 = (-b + Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2*a);     // NOG TOEVOEGEN AAN TOEWIJZEN()
        abcd2 = (-b - Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2*a);
        return Math.max(abcd1,abcd2);
     }
    public static double kwadratischeformule2(double a, double b, double c){
        double abcd1, abcd2;
        abcd1 = (-b + Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2*a);
        abcd2 = (-b - Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2*a);
        return Math.min(abcd1,abcd2);
     }
	
     //a^log x = c hier wordt x berekent
    public static double logb(double a, double c){
        double answer2;
        answer2 = (Math.pow(a,c));
        return answer2;
     }
    
     //a^x = c hier wordt x berekent
    public static double Atotx(double a, double c){
        double x1;
        x1 = (Math.log10(c)) / (Math.log10(a));
        return x1;
    }
    
    //a^x + d = c hier wordt x berekent
    public static double AtotXPlusB(double a, double d, double c){
    	double x;
    	c= c-d;
    	x = (Math.log10(c)) / (Math.log10(a));
    	return x;
}

    public static void toewijzen(int A, int B, int log, int sin, int aantalAtotx){   	// Alle variabelen C, in dit stuk, moeten door de UI bepaald worden
		boolean[] Atotx = new boolean[n];
			Atotx = AtotX(n);	
		if(aantalAtotx <=1)	{
			if(Atotx[0] == false && B<=1){												
					if( A == 3 && B ==1 && log == 0 && sin ==0 && BwaardesVoorClass[0] == 2 ){			// hierbij moet die ene macht wel gelijk zijn aan 2, anders numeriek oplossen
						System.out.println("x = "  + kwadratischeformule1(AwaardesVoorClass[0],AwaardesVoorClass[1],AwaardesVoorClass[2]));
						System.out.println("&");
						System.out.println("x = " + kwadratischeformule2(AwaardesVoorClass[0],AwaardesVoorClass[1],AwaardesVoorClass[2]));
					}
					else if( A==2 && B==1 && log == 0 && sin ==0){
						simpelOntbinden(AwaardesVoorClass[0], BwaardesVoorClass[0], AwaardesVoorClass[1]);
					}	
					else if ( A==1 && B==1 && log == 0 && sin ==0){
						double C = 2.0;
						System.out.println("x = " + eenTermOplossen( AwaardesVoorClass[0], BwaardesVoorClass[0], C));
					}
					else if (A==1 && log == 1 ){
						double logBase = 2.0; 					
						double antwoord = 3.0;
						System.out.println(logb(logBase, antwoord ));
					}
			}
					else if(Atotx[0] == true){
						if (A==1 && log ==0){
							double C = 2.0;									
							System.out.println("x = " +Atotx( AwaardesVoorClass[0], C ));
					}
					else if (A==2  && log ==0){			
						if(Atotx[1] = true){
							double C = 12.0;
							System.out.println("x = " + AtotXPlusB( AwaardesVoorClass[0], AwaardesVoorClass[1], C ));
						}
					}
					}
		}
		else {
			System.out.println("numeriek oplossen");
		}
		if (aantalAtotx >= 1 && A>1) {
	      System.out.println("numeriek oplossen");
		}
	}

 	public static void main(String [] args){
    	int sin = 0;
		int timesLog =timesLog(logArray(n));
		int A = timesA(Awaardes(n));	
		int B = timesB(Bwaardes(n));
		int AtotX = timesAtotX(AtotX(n));
		toewijzen(A, B, timesLog, sin, AtotX);
 	}
}
