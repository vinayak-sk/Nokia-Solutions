package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class SortUniqueWords {


    public static void main(String[] args) {

        String input = "This is a test example.... A short example of a valid input.";

        try {
            for (Map.Entry<String, Integer> entry : new SortUniqueWords().printOccurencesOfWordsInString(input)) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * Takes path of the file as input, reads all lines from the file and prints unique words along with the number of occurrences
     *
     * @param path A valid path to the file
     * @throws IOException
     */
    public void printOccurencesOfWordsInFile(String path) throws IOException {

        Map<String, Integer> occurrences = new HashMap<>();

        //Put unique words in a map maintaining the count of occurrences
        for (String line : Files.readAllLines(Paths.get(path))) {
            //Lower case all words and remove all non-alphabet characters except space. Use "[^a-zA-Z0-9 ]+" to keep numbers as well.
            for (String s : line.toLowerCase().replaceAll("[^a-zA-Z ]+", "").split(" ")) {
                if (occurrences.containsKey(s)) {
                    occurrences.put(s, occurrences.get(s) + 1);
                } else {
                    occurrences.put(s, 1);
                }
            }
        }

        //Put all the entries in a list to sort
        List<Map.Entry<String, Integer>> sortedOccurrences = new LinkedList<>(occurrences.entrySet());

        //Custom comparator to sort the list first by number of occurrences and then by value. Complexity: O(nlogn)
        Collections.sort(sortedOccurrences, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().compareTo(o2.getValue()) == 0) {
                    return (o1.getKey().compareTo(o2.getKey()));
                } else {
                    return (o2.getValue().compareTo(o1.getValue()));
                }
            }
        });

        for (Map.Entry<String, Integer> entry : sortedOccurrences) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }


    /**
     * Function to test the code directly from string input (used by Junit test)
     *
     * @param input A string input to extract unique words from.
     * @return
     */
    public List<Map.Entry<String, Integer>> printOccurencesOfWordsInString(String input) {

        Map<String, Integer> countMap = new HashMap<String, Integer>();


        for (String s : input.toLowerCase().replaceAll("[^a-zA-Z ]+", "").split(" ")) {
            if (countMap.containsKey(s)) {
                countMap.put(s, countMap.get(s) + 1);
            } else {
                countMap.put(s, 1);
            }
        }

        List<Map.Entry<String, Integer>> lst = new LinkedList<>(countMap.entrySet());

        Collections.sort(lst, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().compareTo(o2.getValue()) == 0) {
                    return (o1.getKey().compareTo(o2.getKey()));
                } else {
                    return (o2.getValue().compareTo(o1.getValue()));
                }
            }
        });

        return lst;

    }
}
