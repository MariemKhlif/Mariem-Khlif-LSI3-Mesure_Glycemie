package com.example.mariemkhliflsi3mesure_glycemie.model;
public class Patient {
    int age;
    float valeur_mesuree;
    boolean verifValeur =false ;
    boolean isFasting;
    private String Resultat ;
//Notify Controller -> Model
    public Patient( int age ,float valeur_mesuree ,  boolean isFasting  ) {
        this.valeur_mesuree = valeur_mesuree;
        this.age = age;
        this.isFasting = isFasting;
        Calculer();
    }
    public int getAge() {
        return age;
    }
    public float getValeur_mesuree() {
        return valeur_mesuree;
    }
    public boolean isFasting() {
        return isFasting;
    }
//update model->controller
    public String getResultat() {
        return Resultat;
    }
    private void Calculer()
    {
         if (isFasting)
            {
                if (age>=13)
                    if(valeur_mesuree<5)
                        Resultat = "Niveau de glycemie est bas";
                    else if (valeur_mesuree>=5 && valeur_mesuree>7.2)
                        Resultat="Niveau de glycemie est normale";
                    else
                        Resultat="Niveau de glycemie est élevé";

                else if (age >=6 && age <= 12)
                    if (valeur_mesuree<5)
                        Resultat="Niveau glycemie bas";
                    else if (valeur_mesuree>=5 && valeur_mesuree<10)
                        Resultat="Niveau normale ";
                    else
                        Resultat="Niveau élevé";

                else if (age<6)
                    if (valeur_mesuree<5.5)
                        Resultat="Niveau bas";
                    else if (valeur_mesuree >= 5.5 && valeur_mesuree<=10.0)
                        Resultat="Niveau normale";
                    else
                        Resultat="Niveau élevé";
            }
            else
            if (valeur_mesuree>10.5)
                Resultat="Niveau élevé";
            else
                Resultat="Niveau normale";
        }
    }



