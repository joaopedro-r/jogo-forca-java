import java.util.Scanner;

import models.User;
import models.Word;
import utils.ScannerVerify;

public class App {
    public static void main(String[] args) {
        System.out.println("JOGO DA FORCA\n");
       
        Word word = new Word();
        String secretWord = word.getSecretWord();
        User team = new User();
        Scanner scanner = new Scanner(System.in);
        boolean win = false;

        while(team.getLifes()>0){

            System.out.println("+=".repeat(30));
            System.out.println("Vidas: "+team.getLifes());
            System.out.println("Letras usadas: "+word.getUsedLettersToString());
            System.out.println("Palavra: "+word.generateHits());
            System.out.print("Digite uma letra: ");
            String letter = scanner.nextLine();
            System.out.println("\n".repeat(40));
            
            if (new ScannerVerify(letter).isLetter()){
                letter = letter.toLowerCase();
            } else{
                System.out.println("Digite uma letra!".toUpperCase());
                continue;
            }

            if (word.isUsedLetter(letter)){
                System.out.println("Você já usou essa letra!".toUpperCase());
                continue;
                
            } 

            if (!word.tryLetter(letter)){
                team.reduceLife();
            } else{
                String[] hits = word.generateHits().split("");
                boolean hasUnderscore = false;
                for (String hit : hits) {
                    if (hit.equals("_")) {
                        hasUnderscore = true;
                    }
                }

                if (!hasUnderscore){
                    win = true;
                    break;
                }
            }
                       
        }
        if (!win){
            System.out.println("\n\n\nVocê perdeu!".toUpperCase());
            System.out.println("A palavra secreta era: "+secretWord);
            System.out.println("Você chegou a: "+word.generateHits());
        } else{
            System.out.println("\n\n\nVocê ganhou!".toUpperCase());
            System.out.println("A palavra secreta era: "+secretWord);
            System.out.println("Vidas restantes: "+team.getLifes());
        }

        System.out.print("\nDeseja jogar novamente? (s/n)");
        String playAgain = scanner.nextLine();
        System.out.println("\n".repeat(40));
        if (playAgain.equals("s")){
            main(null);
        } else{
            System.out.println("\nObrigado por jogar!");
        }

        
        scanner.close();
    }
}
