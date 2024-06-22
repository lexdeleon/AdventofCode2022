import java.nio.charset.StandardCharsets;
import java.util.*;
import java.nio.file.*;
import java.io.*;

public class Day1
    {

    /**
        Advent of Code 2022, Day 1: figure out how many calories each elf is carrying and output
        the number of calories carried by the elf who is carrying the most. Then, find the totals
        from the top three elves and add them together.
         */
        
        public static void main(String[] args)
            {
                // Read input from file stored on local disk
                String source = "C:\\scripts\\aoc2022\\day1.txt";
                
                //initial list of data
                List<String> lines = list(source);
                //first array to hold the firs groups of integers
                List<Integer> subtotals = new ArrayList<>();
                //second array to hold the added together integers from the first array
                List<Integer> totals = new ArrayList<>();
                
                //iterate through file line by line
                for (int i = 0; i<lines.size(); i++)
                    {
                        //check for empty lines or the final line
                        if (lines.get(i).isEmpty() || lines.get(i).trim().equals("") || lines.get(i).trim().equals("\n") || (lines.size() - 1) == i)
                            {
                                //special case for the final line to make sure its captured
                                if (lines.size() - 1 == i)
                                    {
                                        Integer sub = Integer.parseInt(lines.get(i));
//                                    System.out.println("[line]sub::[" + i + "]" + sub);
                                        subtotals.add(sub);
                                    }
                                //add the subtotals to the totals array, then clear the subtotals array
                                //this lets us keep counting the next group of integers
                                Integer sum = subtotals.stream().mapToInt(Integer::valueOf).sum();
                                totals.add(sum);
//                            System.out.println("adding " + sum + " to totals collection");
                                subtotals.clear();
//                            System.out.println("clearing subtotals collection");
                            }
                        else
                            {
                                //add integers to array to be summed up later
                                Integer sub = Integer.parseInt(lines.get(i));
//                            System.out.println("[line]sub::[" + i + "]" + sub);
                                subtotals.add(sub);
                            }
                    }
                //find the highest number
                Integer highest = Collections.max(totals);
                System.out.println(highest);
                
                //sort array in descending order
                totals.sort(Collections.reverseOrder());
                //grab the three highest values
                Integer a = totals.get(0);
                Integer b = totals.get(1);
                Integer c = totals.get(2);
                //add the three highest values
                Integer last = a + b + c;
                
                System.out.println(last);
               
            }
      
        public static List<String> list(String fileName)
            {
                
                // add lines from file into collection
                List<String> listed = Collections.emptyList();
                try
                    {
                        listed = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
                    }
                catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                return listed;
                
            }
    }