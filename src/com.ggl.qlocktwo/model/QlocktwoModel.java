package com.ggl.qlocktwo.model;
 
public class QlocktwoModel {
     
    private boolean testClock;
     
    private char[][] characters = 
        {{'I', 'T', 'L', 'I', 'S', 'A', 'S', 'T', 'I', 'M', 'E'},
         {'A', 'C', 'Q', 'U', 'A', 'R', 'T', 'E', 'R', 'D', 'C'},
         {'T', 'W', 'E', 'N', 'T', 'Y', 'X', 'F', 'I', 'V', 'E'},
         {'H', 'A', 'L', 'F', 'B', 'T', 'E', 'N', 'F', 'T', 'O'},
         {'P', 'A', 'S', 'T', 'E', 'R', 'U', 'N', 'I', 'N', 'E'},
         {'O', 'N', 'E', 'S', 'I', 'X', 'T', 'H', 'R', 'E', 'E'},
         {'F', 'O', 'U', 'R', 'F', 'I', 'V', 'E', 'T', 'W', 'O'},
         {'E', 'I', 'G', 'H', 'T', 'E', 'L', 'E', 'V', 'E', 'N'},
         {'S', 'E', 'V', 'E', 'N', 'T', 'W', 'E', 'L', 'V', 'E'},
         {'T', 'E', 'N', 'S', 'E', 'O', 'C', 'L', 'O', 'C', 'K'}};
     
    private int height;
    private int width;
     
    private ColorScheme colorScheme;
     
    private QlocktwoCharacter[][] characterArray;
     
    public QlocktwoModel() {
        this.width = characters[0].length;
        this.height = characters.length;
        this.colorScheme = new ColorScheme();
        this.characterArray = new QlocktwoCharacter[height][width];
        setCharacterArray();
    }
 
    private void setCharacterArray() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == 9) && (j == 5)) {
                    // O with an diacritical apostrophe
                    characterArray[i][j] = 
                            new QlocktwoCharacter((char) 0x01A0);
                } else {
                    characterArray[i][j] = new QlocktwoCharacter(
                            characters[i][j]);
                }
            }
        }
    }
 
    public ColorScheme getColorScheme() {
        return colorScheme;
    }
 
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
 
    public QlocktwoCharacter[][] getCharacterArray() {
        return characterArray;
    }
 
    public boolean isTestClock() {
        return testClock;
    }
 
    public void setTestClock(boolean testClock) {
        this.testClock = testClock;
    }
 
    public void clearClock() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                characterArray[i][j].setOn(false);
            }
        }
    }
 
    public void setItIs() {
        setCharacters(0, 0, 1, 3, 4);
    }
     
    public void setPast() {
        setCharacters(4, 0, 1, 2, 3);
    }
     
    public void setTo() {
        setCharacters(3, 9, 10);
    }
     
    public void setZero() {
        setCharacters(9, 5, 6, 7, 8, 9, 10);
    }
     
    public void setFive() {
        setCharacters(2, 7, 8, 9, 10);
    }
     
    public void setTen() {
        setCharacters(3, 5, 6, 7);
    }
     
    public void setFifteen() {
        setCharacters(1, 0, 2, 3, 4, 5, 6, 7, 8);
    }
     
    public void setTwenty() {
        setCharacters(2, 0, 1, 2, 3, 4, 5);
    }
     
    public void setTwentyFive() {
        setCharacters(2, 0, 1, 2, 3, 4, 5, 7, 8, 9, 10);
    }
     
    public void setThirty() {
        setCharacters(3, 0, 1, 2, 3);
    }
     
    public void setOneHour() {
        setCharacters(5, 0, 1, 2);
    }
     
    public void setTwoHour() {
        setCharacters(6, 8, 9, 10);
    }
     
    public void setThreeHour() {
        setCharacters(5, 6, 7, 8, 9, 10);
    }
     
    public void setFourHour() {
        setCharacters(6, 0, 1, 2, 3);
    }
     
    public void setFiveHour() {
        setCharacters(6, 4, 5, 6, 7);
    }
     
    public void setSixHour() {
        setCharacters(5, 3, 4, 5);
    }
     
    public void setSevenHour() {
        setCharacters(8, 0, 1, 2, 3, 4);
    }
     
    public void setEightHour() {
        setCharacters(7, 0, 1, 2, 3, 4);
    }
     
    public void setNineHour() {
        setCharacters(4, 7, 8, 9, 10);
    }
     
    public void setTenHour() {
        setCharacters(9, 0, 1, 2);
    }
     
    public void setElevenHour() {
        setCharacters(7, 5, 6, 7, 8, 9, 10);
    }
     
    public void setTwelveHour() {
        setCharacters(8, 5, 6, 7, 8, 9, 10);
    }
 
    private void setCharacters(int row, int... column) {
        for (int i = 0; i < column.length; i++) {
            characterArray[row][column[i]].setOn(true);
        }
    }
     
}
