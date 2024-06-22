import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day3
    {
        public static void main (String[] args)
            {
                String source = "C:\\scripts\\aoc2022\\day3.txt";
                List<String> lines = list(source);
                
                List<Integer> contents = new ArrayList<>(Collections.emptyList());
                
                for (String storage : lines)
                    {
                        int middle = storage.length() / 2;
                        
                        String[] halves = {storage.substring(0, middle), storage.substring(middle)};
                        String half1 = halves[0];
                        String half2 = halves[1];
                        
                        for (int i = 0; i < half1.length(); i++)
                            {
                                char s = half1.charAt(i);
                                if (half2.contains(Character.toString(s)))
                                    {
                                        contents.add(findItemValue(s));
                                        break;
                                    }
                            }
                    }
                
                int counter = 3;
                List<List<String>> lines2 = null;
                List<Integer> results = new ArrayList<>(Collections.emptyList());
                
                lines2 = IntStream.range(0, (lines.size() + counter - 1) / counter)
                        .mapToObj(i -> lines.subList(i * counter, Math.min(counter * (i + 1), lines.size())))
                        .collect(Collectors.toList());
                
                
                for (List storage2 : lines2)
                    {
                        StringBuilder tempValue = null;
                        ArrayList<String> arraySet = null;
                        Integer valueResult;
                        ArrayList<String> firstList = new ArrayList<>();
                        ArrayList<String> secondList = new ArrayList<>();
                        ArrayList<String> thirdList = new ArrayList<>();
                        ArrayList<String> resultList = new ArrayList<>();
                        ArrayList<String> finalResult = new ArrayList<>();
                        
                        String[] temp = (String[]) storage2.toArray(new String[2]);
                        
                        for (int i = 0; i < temp[0].length(); i++)
                            {
                                firstList.add(String.valueOf(temp[0].charAt(i)));
                            }
                        
                        for (int i = 0; i < temp[1].length(); i++)
                            {
                                secondList.add(String.valueOf(temp[1].charAt(i)));
                            }
                        
                        for (int i = 0; i < temp[2].length(); i++)
                            {
                                thirdList.add(String.valueOf(temp[2].charAt(i)));
                            }
                        
                        // compare all values and only keep duplicates
                        secondList.retainAll(firstList);
                        thirdList.retainAll(secondList);
                        
                        // remove duplicate values
                        Set<String> finalList = new LinkedHashSet<String>(thirdList);
                        // return to easier iterative format
                        List<String> finalResults = new ArrayList<>(finalList);
                        
                        for (int i = 0; i < finalResults.size(); i++)
                            {
                                Character value = finalResults.get(i).charAt(0);
                                results.add(findItemValue(value));
                            }
                    }

                System.out.println(contents);
                int totalValue = contents.stream().mapToInt(Integer::intValue).sum();
                System.out.println("Total Value: " + totalValue);
                System.out.println(results);
                int totalResults = results.stream().mapToInt(Integer::intValue).sum();
                System.out.println("Total Results: " + totalResults);
            }
        
        private static Integer findItemValue(Character inValue)
            {
                // a-z 1-26 ascii 97-122
                // A-Z 27-52 ascii 65-90
                
                // create two string arrays, 1-26, then 1-26 PLUS 26 to each value, return value of matched string
                // iterate through each array until matching string value, return index number
                
                int returnValue = 0;
                
                if ((inValue - 91) < 0)
                    {
                        returnValue = inValue - 38;
                    }
                else if ((inValue - 91) > 0)
                    {
                        returnValue = inValue - 96;
                    }
                return returnValue;
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
