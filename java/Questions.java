package com.example.multiplechoicegame;

public class Questions {
    //Questions object, this will store the questions and answers
    //qData: first element of the second dimension of the array is always the question and the second element of the second dimension is always the correct answer
    String[][] qData = {
            {"How many moons does Jupiter have?", "79", "13", "54", "39"},
            {"How many cervical vertebra does a giraffe have?", "7", "9", "17", "12"},
            {"Which is not a German language?", "Romanian", "Afrikaans", "Scots ", "Dutch"},
            {"Which is the world's most populated city?", "Tokyo", "Delhi", "Shanghai", "Sao Paulo"},
            {"When was America discovered?", "1492", "1526", "1494", "1514"},
            {"How many teeth does an adult have?", "32", "36", "28", "24"},
            {"'Namaste' is a traditional greeting in which Asian language?", "Hindi", "Mandarin", "Japanese", "Korean"},
            {"How many gas giants are there in our solar system?", "4", "3", "6", "2"},
            {"Where does the drink Metaxa originate from?", "Greece", "Turkey", "Spain", "France"},
            {"What is the code of 9 in the binary system?", "1001", "100", "1000", "1011"},
            {"What is the third number in Pi?", "4", "1", "3", "6"},
            {"Which is the world's longest river?", "River Nile", "Amazon River", "Mississippi", "River Thames"},
            {"How much is 3 factorial?", "6", "24", "9 ", "12"},
            {"Which continent has the most countries?", "Africa", "Europe", "Asia", "America"},
            {"What year was Napoleon Bonaparte exiled?", "1815", "1800", "1798", "1749"},
            {"How many sides does an octagon have?", "8", "9", "5", "6"},
            {"When was the Gregorian calendar introduced?", "1582", "1217", "1252", "1547"},
            {"How many strings does a standard bass guitar have?", "4", "6", "5", "7"},
            {"Which of these is not a suit in a normal deck of cards:", "Ace", "Spades", "Hearts", "Diamonds"},
            {"What is J.K. Rowling's first name?", "Joanne", "Jennifer", "Jane", "Jean"}
    };

    //getter method to get a set of the qData
    public String[][] getqData() { return qData; }
}
