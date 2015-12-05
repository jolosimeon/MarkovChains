package utilities;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Markov
{
    private ArrayList<String> wordsArrayList = new ArrayList<>(); 
    private String twoWords;
    private Multimap<String, String> map = HashMultimap.create();
    
    
    public void generateMarkovChain(String input)
    {
        // parse through input
        // tokenize everything bu twos'
        
        String[] words = input.split("\\s+");
      
        for (int i = 0; i < words.length; i++) {
              if (i == words.length - 1)
                  twoWords = words[i]; 
              else if(i == words.length - 2)
                  twoWords = words[i] + " " + words[i + 1]; 
              else 
                  twoWords = words[i] + " " + words[i + 1];
                  wordsArrayList.add(twoWords);
              
    }
        for(int i = 0; i < wordsArrayList.size(); i++)
        {
          Pattern p = Pattern.compile(wordsArrayList.get(i)+" ([A-z]*)");  
          Matcher m = p.matcher(input);
          while(m.find())
          {
          String token = m.group(1);
          map.put(wordsArrayList.get(i),token);
          }
          
        }
        
        for(int i = 0; i < wordsArrayList.size(); i++)
        {
          System.out.println(wordsArrayList.get(i)+" = "+map.get(wordsArrayList.get(i)));
          
        }

    }

    
}