package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Word {
    private String secretWord;

    List<String> usedLetters = new ArrayList<String>();
  

    public String getSecretWord() { // Gera uma palavra aleatória
        Random random = new Random();
        int index = random.nextInt(SecretWords.words.length-1);
        String secretWord = SecretWords.words[index];
        this.secretWord = secretWord;
        return secretWord;
    }

    public boolean tryLetter(String letter) { // adiciona a letra usada e faz as verificações
        this.usedLetters.add(letter);
        for (String letterInWord : this.secretWord.split("")) {
            if (letterInWord.equals(letter)) {
                return true;
            }
        } 
        return false;
    
       
    }

    public boolean isUsedLetter(String letter) { // Verifica se a letra já foi usada
        return this.usedLetters.contains(letter);
    }

    public String getUsedLettersToString() { // Retorna as letras usadas
        String usedLetters = "";
        for (String letter : this.usedLetters) {
            usedLetters += letter + ", ";
        }
        return usedLetters;
    }

    public String generateHits(){ // Gera a palavra com os traços e as letras acertadas
        String hits = "";
        for (String letter : this.secretWord.split("")) {
            if (this.usedLetters.contains(letter)) {
                hits += letter;
            } else {
                hits += "_";
            }
        }
        return hits;
    }
    
    
}
