package controller;

import java.util.ArrayList;

public class AnaliseLexicaController {
	
	public static String lexicalAnalysis(String string){
        ArrayList<String> stringList = stringToArraylist(string);
        String result = "";
        for (String s: stringList) {
        	if ((locateSpecialSymbols(s) + locateDigit(s) + locateLetter(s)).equals(""))
        		result += "";
        	else
        		result += locateSpecialSymbols(s) + locateDigit(s) + locateLetter(s) + "\n";
        }
        return result;
    }

    public static ArrayList<String> stringToArraylist(String string){
        ArrayList<String> stringList = new ArrayList<>();
        String result = "";

        int i = 0;
        while(i<string.length()){
            if(string.charAt(i)==' '){
                stringList.add(result);
                result = "";
                i++;
            }
            if(i==string.length()-1) {
                result = result+string.charAt(i);
                stringList.add(result);
                i++;
            }
            else{
                result += string.charAt(i);
                i++;
            }
        }
        return stringList;
    }

    public static String locateSpecialSymbols(String sentence) {

        String result = "Simbolo Especial - " + locateRelationalOperators(sentence) + locateArithmeticOperators(sentence)
                        + locateAtribuition(sentence) + locateDelimiters(sentence) + locateKeyword(sentence)
                        + locateLogicalOperators(sentence);
        if(result.equals("Simbolo Especial - "))
            return "";
        return result;
    }

    public static String locateArithmeticOperators(String sentence){
        String[] operatorsList = {"+", "-", "*", "/", "div", "mod"};

        String result;
        for (String s: operatorsList) {
            if (s.equals(sentence)) {
                result = s;
                return "Operador Aritimetico : " + result;
            }
        }
        return "";
    }

    public static String locateAtribuition(String sentence){
        if (sentence.equals(":=")) {
            return "Atribuicao : " + sentence;
        }
        return "";
    }

    public static String locateRelationalOperators(String sentence) {
        String[] operatorsList = {"<>", "<", ">", "<=", ">=", "="};
        String result;
        for (String s: operatorsList) {
            if (s.equals(sentence)) {
                result = s;
                return "Operador Relacional : " + result;
            }
        }
        return "";
    }

    public static String locateLogicalOperators(String sentence) {
        String[] logicalOperatorList = {"or", "and", "not"};
        String result;
        for (String s: logicalOperatorList) {
            if (s.equals(sentence)) {
                result = s;
                return "Operator Logico : " + result;
            }
        }
        return "";
    }

    public static String locateDelimiters(String sentence){
        String[] specialSymbolsList = {"(", ")", "[", "]", ".", ",", ";", ":", ".."};
        String result;
        for (String s: specialSymbolsList) {
            if (s.equals(sentence)) {
                result = s;
                return "Delimitador : " + result;
            }
        }
        return "";
    }

    public static String locateKeyword(String sentence){
        String[] keywordsList = {"if", "then", "else", "of", "while", "do", "begin", "end", "read",
                "write", "var", "array", "function", "procedure", "program", "true", "false", "char", "integer", "boolean"};

        String result;
        for (String s: keywordsList) {
            if (s.equals(sentence)) {
                result = s;
                return "Palavra-Chave : " + result;
            }
        }
        return "";
    }
    public static String locateDigit(String sentence) {
        String[] digitsList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String result;
        for (String s : digitsList) {
            if (s.equals(sentence)) {
                result = s;
                return "Digito : " + result;
            }
        }
        return "";
    }

    public static String locateLetter(String sentence) {
        String[] lettersList = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
                "j","k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t","u", "v", "w", "x", "y", "z", "A", "B", "C",
                "D","E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "W", "V", "X",
                "Y", "Z"};

        String result;
        for (String s : lettersList) {
            if (s.equals(sentence)) {
                result = s;
                return "Letra : " + result;
            }
        }
        return "";
    }
}
