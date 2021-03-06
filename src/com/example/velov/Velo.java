package com.example.velov;

public class Velo {
	
	int depart = 0;
	int fin = 0;
	boolean age = false;
	
	//constructeur de la classe
	public Velo(String getDepart, String getFin, Boolean getAge){
		this.depart = Integer.parseInt(getDepart);
		this.fin = Integer.parseInt(getFin);
		this.age = getAge;
	}
	//fonction de calcul du prix
	public String calculatePrice(){
		int a = this.depart;
		int b = this.fin;
		int duree = b - a;
		double prix = 0;
		
		if (duree < 23) {
			if (a >= 7 && a <= 17) {
				if (b >=7 && b <= 17) {
					//a = tarif 1 et b = tarif 1
					prix = duree*1.5;
				}
				else if (b >= 0 && b <= 7) {
					prix = ((10-(a-7))*1.5) + (-(0-b)*1.25);
				} 
						
				else if (b >= 17 && b <= 24){
					//a = tarif 1 et b = tarif 2
					prix = ((10-(a-7))*1.5) + ((b-17)*1.25);
				}
			}

			else if ((a >= 0 && a <= 7) || (a >= 17 && a <= 24)) {
				if (b >=7 && b <= 17) {
					//a = tarif 2 et b = tarif 1
					prix = duree * 1.375; 
				}
				else if ((b >= 0 && b <= 7) || (b >= 17 && b <= 24)){
					//a = tarif 2 et b = tarif 2
					prix = duree * 1.25;
				}
			}
			
			//test si l'utilisateur � moins de 30 ans ou plus de 70 ans
			if(age) {
				prix = prix * 0.80;
			}
			
			//On arrondi le prix � 2 d�cimals
			double roundPrix = (double) Math.round(prix * 100) / 100;
			
			return roundPrix+" �";
		}
		
		else
			return "Erreur";
	}
	
	
}
