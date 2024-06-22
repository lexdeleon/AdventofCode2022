import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.temporal.ValueRange;
import java.util.Collections;
import java.util.List;

public class Day4
    {
        public static void main(String[] args)
            {
                String source = "C:\\scripts\\aoc2022\\day4.txt";
                List<String> lines = list(source);
                
                List<Integer> contents = new java.util.ArrayList<>(Collections.emptyList());
                
                List<Boolean> trackResults = new java.util.ArrayList<>(Collections.emptyList());
                
                //compare string lengths, does longer contain substring of shorter
                for (String line : lines)
                    {
                        String[] halves = line.split("[,]");
                        String half1 = halves[0];
                        String half2 = halves[1];
                        Boolean result = false;
                        
                        String[] range1Values = half1.split("[-]");
                        
                        Integer start1 = Integer.parseInt(range1Values[0]);
                        Integer end1 = Integer.parseInt(range1Values[1]);
                        
                        ValueRange range1 = ValueRange.of(start1, end1);
                        
                        String[] range2Values = half2.split("[-]");
                        
                        Integer start2 = Integer.parseInt(range2Values[0]);
                        Integer end2 = Integer.parseInt(range2Values[1]);
                        
                        ValueRange range2 = ValueRange.of(start2, end2);
                        
                        // to check for full inclusion, change these statements to &&
                        // using || checks for any overlap
                        if (range1.isValidValue(start2) || range1.isValidValue(end2))
                            {
                                result = true;
                                trackResults.add(result);
                                continue;
                            }
                        if (range2.isValidValue(start1) || range2.isValidValue(end1))
                            {
                                result = true;
                                trackResults.add(result);
                                continue;
                            }
                     
                    }
                Integer totalResults = trackResults.size();
                System.out.println(totalResults);
                
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
