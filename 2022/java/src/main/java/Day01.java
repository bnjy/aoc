package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Day01
 */
public class Day01 {

    public static void main(String[] args) throws IOException {

        List<Integer> elvesCalories = new ArrayList<>();
        int max = 0;
        int sumTopThree = 0;

        //1. read from input file
        elvesCalories = readFromFile("java/src/main/resources/day1.txt", elvesCalories);
        
        //2. sort the array list
        max = getMaxValue(elvesCalories);

        //3. print the max value
        System.out.println(max);

        //4. sort list in ascending order
        // this is probably the laziest solution ever.
        // look if you can replace with some proper sorting algorithm
        // e g quicksort or mergesort
        Collections.sort(elvesCalories, Collections.reverseOrder());

        //4. calculate top 3 total
        sumTopThree = sumTopThree(elvesCalories);
        System.out.println(sumTopThree);

    }

    /**
     * 
     * @param elvesCalories
     * @return
     */
    private static int sumTopThree(List<Integer> elvesCalories) {
        int sum = 0;
        for(int i = 0; i < 3; i++){
            sum += elvesCalories.get(i);
        }
        return sum;
    }

    /**
     * 
     * @param elvesCalories
     * @return
     */
    private static int getMaxValue(List<Integer> elvesCalories) {
        int value = 0;
        for(int i = 0; i < elvesCalories.size(); i++){
            if(value < elvesCalories.get(i)){
                value = elvesCalories.get(i);
            }
        }
        return value;
    }

    /**
     * 
     * @param inputPath
     * @param elvesCalories
     * @return
     * @throws IOException
     */
    public static List<Integer> readFromFile(String inputPath, List<Integer> elvesCalories) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputPath));
        int sum = 0;

        try {
            String line = br.readLine();
            //while line is not null
            while (line != null) {
                //if line is empty (""), add sum to the Integer Array, reset sum variable and go to next line.
                if(line.trim().isEmpty()){
                    elvesCalories.add(sum);
                    sum = 0;
                    line = br.readLine();
                }

                int number = Integer.parseInt(line);
                sum += number;
                
                // read next line
                line = br.readLine();
            }
            elvesCalories.add(sum);
            sum = 0;

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elvesCalories;
    }
}