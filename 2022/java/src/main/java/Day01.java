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

        List<Integer> elveCalories = new ArrayList<>();
        int max = 0;
        int sumTopThree = 0;

        //1. read from input file
        elveCalories = readFromFile("java/src/main/resources/day1.txt", elveCalories);
        
        //2. sort the array list
        max = getMaxValue(elveCalories);

        //3. print the max value
        System.out.println(max);

        //4. sort list in ascending order
        Collections.sort(elveCalories, Collections.reverseOrder());

        //4. calculate top 3 total
        sumTopThree = sumTopThree(elveCalories);
        System.out.println(sumTopThree);

    }

    private static int sumTopThree(List<Integer> elveCalories) {
        int sum = 0;
        for(int i = 0; i < 3; i++){
            sum += elveCalories.get(i);
        }
        return sum;
    }

    private static int getMaxValue(List<Integer> elveCalories) {
        int value = 0;
        for(int i = 0; i < elveCalories.size(); i++){
            if(value < elveCalories.get(i)){
                value = elveCalories.get(i);
            }
        }
        return value;
    }

    public static List<Integer> readFromFile(String inputPath, List<Integer> elveCalories) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(inputPath));
        int sum = 0;

        try {
            String line = br.readLine();

            //while line is not null
            while (line != null) {
                if(line.trim().isEmpty()){
                    elveCalories.add(sum);
                    sum = 0;
                    line = br.readLine();
                }

                int number = Integer.parseInt(line);
                sum += number;
                
                // read next line
                line = br.readLine();
            }
            elveCalories.add(sum);
            sum = 0;

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elveCalories;
    }
    
}