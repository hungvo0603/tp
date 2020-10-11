package seedu.duke.wordlist;

import seedu.duke.words.Words;
import seedu.duke.words.Noun;
import seedu.duke.words.Verb;
import seedu.duke.words.Adjective;

import seedu.duke.ui.UI;
import java.util.ArrayList;

public class WordList {
    public static ArrayList<Words> wordList = new ArrayList<>();

    public static int getNumberOfWords() {
        return wordList.size();
    }

    /**
     * Function to add noun to word list.
     * @param input a string which contains
     *              the word and its definition
     */
    public static void addNoun(String input) {
        String[] word = input.split(" ", 2);
        String[] splitInput = word[1].split("d/");
        Words toAdd = new Noun(splitInput[0],splitInput[1]);
        wordList.add(toAdd);
        UI.addNounMessage(toAdd.getDescription());
    }

    /**
     * Function to add verb to word list.
     * @param input a string which contains
     *              the word and its definition
     */
    public static void addVerb(String input) {
        String[] word = input.split(" ", 2);
        String[] splitInput = word[1].split("d/");
        Words toAdd = new Verb(splitInput[0],splitInput[1]);
        wordList.add(toAdd);
        UI.addVerbMessage(toAdd.getDescription());
    }

    /**
     * Function to add adjective to word list.
     * @param input a string which contains
     *              the word and its definition
     */
    public static void addAdjective(String input) {
        String[] word = input.split(" ", 2);
        String[] splitInput = word[1].split("d/");
        Words toAdd = new Adjective(splitInput[0],splitInput[1]);
        wordList.add(toAdd);
        UI.addAdjectiveMessage(toAdd.getDescription());
    }

    public static void listWords() {
        UI.listWordsMessage();
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println((i + 1) + "." + wordList.get(i).getDescription());
        }
    }
}