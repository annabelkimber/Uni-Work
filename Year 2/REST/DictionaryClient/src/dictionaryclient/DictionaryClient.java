/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionaryclient;


import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Annabel
 */

public class DictionaryClient {
    
   private static DictionaryResourceClient client = new DictionaryResourceClient();    
    
   /**
     * Main method invoking the question method which starts the if statement of
     * what the client would like to do.
     */
    public static void main(String[] args) {
        question();
      
        //Test data set, and hard coding entries into the dictionary
        Word testDictionary = new Word("Lemon", "Yellow citrus fruit");     
        System.out.println(testDictionary); 
        client.addWord(testDictionary);
            
        client.addWord(new Word("Orange", "Orange citrus fruit"));
        Word aWord = client.getDefinition("Orange");
        System.out.println(aWord);
       
        ArrayList<Word> dictList = client.getWords();
        for(Word elem : dictList){
            System.out.println(elem);
        }
    }
    
    /**
     * Question method.Asks the client which operations they would like to
     * perform.Depending on their answer, different methods are called upon.
     */
    public static void question() {
        
        System.out.println("'add', 'delete', 'update' 'definition' or 'all'? To exit, type 'bye'");
        Scanner in = new Scanner(System.in);
        String userinput = in.nextLine();
        if (userinput.equals("add")) {
            System.out.println("You're adding a word");
            addWord();
            System.out.println("Word added!");
        } else if (userinput.equals("delete")) {
            System.out.println("You're deleting a word");
            removeWord();
            System.out.println("Word deleted!");
        } else if (userinput.equals("update")) {
            System.out.println("You're updating a word");
            updateWord();
            System.out.println("Word updated!");
        } else if (userinput.equals("all")) {
            System.out.println("You're requesting to view all of the words and their definitions");
            allWords();
        } else if (userinput.equals("definition")) {
            System.out.println("You've requested a word definition");
            oneWord();
        } else if (userinput.equals("bye")) {
            System.out.println("Bye!");
            System.exit(0);
        } else {
            System.out.println("You need to make a choice!");
            question();
        }
    }
    
    
    /**
     * Add word method.Called upon when the user inputs 'add'.It allows the user
     * to input a word and definition.
     */
    public static void addWord() {
        System.out.println("Enter a word: ");
        Scanner x = new Scanner(System.in);
        String word = x.nextLine();
        System.out.println("Enter a definition");
        Scanner y = new Scanner(System.in);
        String definition = y.nextLine();
        Word newWord = new Word (word, definition);
        client.addWord(newWord);
        question();
    }

    /**
     * Remove word method.Called upon when the user inputs 'delete'.It allows
     * the user to delete a word and its definition.
     */
    public static void removeWord() {
        System.out.println("Enter a word you want to delete: ");
        Scanner x = new Scanner(System.in);
        String word = x.nextLine();
        client.deleteWord(word);
          ArrayList<Word> dictList = client.getWords();
         for(Word elem : dictList){
            System.out.println(elem);
        }
        question();
    }

    /**
     * Update word method.Allows the user to update the definition of a word.The
     * user enters the word, it's old definition and the one it would like to
     * change it to.
     */
    public static void updateWord() {
        System.out.println("Enter a word you want to update: ");
        Scanner x = new Scanner(System.in);
        String word = x.nextLine();
        System.out.println("Enter the new definition: ");
        Scanner z = new Scanner(System.in);
        String newDef = z.nextLine();
        Word updateWord = new Word (word, newDef);
        client.updateWord(updateWord);
        question();
    }

    /**
     * View all words method.Allows the user to view all the words and their definitions.
     */
     public static void allWords() {
         ArrayList<Word> dictList = client.getWords();
         for(Word elem : dictList){
            System.out.println(elem);
        }
        question();
    }
   
     /**
      * View one word method.Allows the user to view a the definition of the word they've 
      * entered.
      */
     public static void oneWord() {
        System.out.println("Enter a word you want to see the definition: ");
        Scanner x = new Scanner(System.in);
        String word = x.nextLine();
        Word aword = client.getDefinition(word);
        System.out.println(aword);
        question();
     }
     
    
     
    
}

