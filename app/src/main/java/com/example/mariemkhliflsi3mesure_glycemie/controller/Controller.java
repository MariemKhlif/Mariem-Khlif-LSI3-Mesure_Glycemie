package com.example.mariemkhliflsi3mesure_glycemie.controller;

import com.example.mariemkhliflsi3mesure_glycemie.model.Patient;

public class Controller {
    private static Patient patient;

    // bich torbot
    private static Controller instance = null ;
    private Controller () {super();}


    public static Controller getInstance(){
        if(Controller.instance == null)
            instance=new Controller();
        return Controller.instance;
    }
   public void createPatient(int age ,float valeur_mesuree ,boolean isFasting)
   {
       patient = new Patient(age,valeur_mesuree,isFasting);
   }

   //bich tobot bil view w patient
   public String getResultat ()
   {return patient.getResultat();}



}
