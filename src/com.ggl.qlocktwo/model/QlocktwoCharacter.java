package com.ggl.qlocktwo.model;

public class QlocktwoCharacter {
     
    private boolean on;
     
    private char character;
 
    public QlocktwoCharacter(char character) {
        this.character = character;
    }
 
    public boolean isOn() {
        return on;
    }
 
    public void setOn(boolean on) {
        this.on = on;
    }
 
    public char getCharacter() {
        return character;
    }
 
}
