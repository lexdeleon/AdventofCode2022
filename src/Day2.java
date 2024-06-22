import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Day2
    {
        /**
         *  Advent of Code, day 2: Figure out the outcomes and scores for rock, paper, scissors,
         *  given your moves, your opponents moves, scores for the shape selection and the scores
         *  for each outcome of the games.
         *  Rock=1, Paper=2, Scissors=3
         *  Lose=0, Draw=3, Won=6
         *  Then adjust to have game match desired outcome: X=lose, Y=draw, Z=win
         *
         */
        
        public static void main(String[] args)
            {
                
                String source = "C:\\scripts\\aoc2022\\day2.txt";
                List<String> lines = list(source);
                Integer shape=0;
                Integer shape2=0;
                Integer outcome=0;
                Integer outcome2=0;
                Integer score=0;
                Integer score2=0;
                Integer totalScore=0;
                Integer totalScore2=0;
                
                for (int i = 0; i<lines.size(); i++)
                    {
                        String game = lines.get(i);
                        switch (game)
                        {
                            case "A X":
                                shape=1;
                                outcome=3;
                                break;
                            case "A Y":
                                shape=2;
                                outcome=6;
                                break;
                            case "A Z":
                                shape=3;
                                outcome=0;
                                break;
                            case "B X":
                                shape=1;
                                outcome=0;
                                break;
                            case "B Y":
                                shape=2;
                                outcome=3;
                                break;
                            case "B Z":
                                shape=3;
                                outcome=6;
                                break;
                            case "C X":
                                shape=1;
                                outcome=6;
                                break;
                            case "C Y":
                                shape=2;
                                outcome=0;
                                break;
                            case "C Z":
                                shape=3;
                                outcome=3;
                                break;
                        }
                        score=shape+outcome;
//                        System.out.println(score);
                        totalScore+=score;
//                        System.out.println(totalScore);
                        //adjust outcome to match desired win lose or draw
                        String game2 = lines.get(i);
                        switch (game2)
                            {
                            case "A X": //rock, lose
                                shape2=3;
                                outcome2=0;
                                break;
                            case "A Y": //rock, draw
                                shape2=1;
                                outcome2=3;
                                break;
                            case "A Z": //rock, win
                                shape2=2;
                                outcome2=6;
                                break;
                            case "B X": //paper, lose
                                shape2=1;
                                outcome2=0;
                                break;
                            case "B Y": //paper, draw
                                shape2=2;
                                outcome2=3;
                                break;
                            case "B Z": //paper, win
                                shape2=3;
                                outcome2=6;
                                break;
                            case "C X": //scissors, lose
                                shape2=2;
                                outcome2=0;
                                break;
                            case "C Y": //scissors, draw
                                shape2=3;
                                outcome2=3;
                                break;
                            case "C Z": //scissors,win
                                shape2=1;
                                outcome2=6;
                                break;
                            }
                        score2=shape2+outcome2;
                        totalScore2+=score2;
                    }
                System.out.println(totalScore);
                System.out.println(totalScore2);
                //Rock1=a, Rock2=x x=lose 1=rock
                //Paper1=b, Paper2=y y=draw 2=paper
                //Scissors1=c, Scissors2=z z=win 3=scissors
                //paper beats rock, rock beats scissors, scissors beat paper
                
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
