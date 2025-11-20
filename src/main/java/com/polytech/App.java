package com.polytech;

import com.polytech.tp.*;

/**
 * Application principale pour démontrer les trois patterns de conception :
 * - Builder Pattern
 * - Decorator Pattern  
 * - Observer Pattern
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("==========================================");
        System.out.println("TP - Patterns de Conception");
        System.out.println("==========================================\n");
        
        // ============================================================
        // EXERCICE 1 : BUILDER PATTERN
        // ============================================================
        System.out.println("1. BUILDER PATTERN");
        System.out.println("-------------------");
        
        Cours cours1 = new CoursBuilder()
                .setMatiere("Génie Logiciel")
                .setEnseignant("Mr Oussama")
                .setSalle("D23")
                .setDate("Lundi")
                .setHeureDebut("8h00")
                .setNiveau("2A")
                .setEstOptionnel(false)
                .setNecessiteProjecteur(true)
                .build();
        
        System.out.println("Cours créé avec le Builder :");
        System.out.println("  - " + cours1.getDescription());
        System.out.println();
        
        // ============================================================
        // EXERCICE 2 : DECORATOR PATTERN
        // ============================================================
        System.out.println("2. DECORATOR PATTERN");
        System.out.println("---------------------");
        
        ICours cours2 = new Cours("Assurance qualité logiciel", "Mr Omar", 
                                  "C15", "Mardi", "14h00", false, 
                                  "3A", false);
        
        System.out.println("Cours de base :");
        System.out.println("  - " + cours2.getDescription());
        
        ICours coursEnLigne = new CoursEnLigne(cours2);
        
        System.out.println("Cours décoré (en ligne) :");
        System.out.println("  - " + coursEnLigne.getDescription());
        System.out.println();
        
        // ============================================================
        // EXERCICE 3 : OBSERVER PATTERN
        // ============================================================
        System.out.println("3. OBSERVER PATTERN");
        System.out.println("--------------------");
        
        GestionnaireEmploiDuTemps gestionnaire = new GestionnaireEmploiDuTemps();
        
        // Création des observateurs
        Etudiant etudiant1 = new Etudiant("Ahmed");
        Etudiant etudiant2 = new Etudiant("Fatima");
        Responsable responsable = new Responsable("Dr. Mohamed");
        
        // Attachement des observateurs
        gestionnaire.attach(etudiant1);
        gestionnaire.attach(etudiant2);
        gestionnaire.attach(responsable);
        
        System.out.println("Observateurs attachés :");
        System.out.println("  - " + etudiant1.getClass().getSimpleName() + " : " + etudiant1);
        System.out.println("  - " + etudiant2.getClass().getSimpleName() + " : " + etudiant2);
        System.out.println("  - " + responsable.getClass().getSimpleName() + " : " + responsable);
        System.out.println();
        
        // Ajout d'un cours (déclenche une notification)
        System.out.println("Ajout d'un nouveau cours :");
        gestionnaire.ajouterCours(cours1);
        System.out.println();
        
        // Modification d'un cours (déclenche une notification)
        System.out.println("Modification d'un cours :");
        gestionnaire.modifierCours(cours2, "Changement de salle : D25");
        System.out.println();
        
        // Changement direct (déclenche une notification)
        System.out.println("Changement d'emploi du temps :");
        gestionnaire.setChangement("Changement de salle : C15-C16");
        System.out.println();
        
        // Détachement d'un observateur
        System.out.println("Détachement d'un observateur :");
        gestionnaire.detach(etudiant2);
        System.out.println();
        
        // Nouveau changement (etudiant2 ne sera plus notifié)
        System.out.println("Nouveau changement (etudiant2 détaché) :");
        gestionnaire.setChangement("Réunion urgente annulée");
        System.out.println();
        
        System.out.println("==========================================");
        System.out.println("Fin de la démonstration");
        System.out.println("==========================================");
    }
}
