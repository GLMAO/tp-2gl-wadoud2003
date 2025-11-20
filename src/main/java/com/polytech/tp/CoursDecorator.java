package com.polytech.tp;

public abstract class CoursDecorator implements ICours {
    protected ICours coursDecorated;

    public CoursDecorator(ICours cours) {
        this.coursDecorated = cours;
    }
    
    // Délégation par défaut - les classes dérivées peuvent redéfinir
    @Override
    public String getDescription() {
        return coursDecorated.getDescription();
    }
    
    @Override
    public double getDuree() {
        return coursDecorated.getDuree();
    }
}