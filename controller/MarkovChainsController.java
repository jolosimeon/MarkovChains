package controller;

import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utilities.Markov;

import view.IMarkovChainsView;

public class MarkovChainsController {

        private IMarkovChainsView view;
        private Markov markov;
        private Multimap<String, String> map;
        private ArrayList<String> wordsArrayList;
       
        public MarkovChainsController(IMarkovChainsView view) {
            this.view = view;
            this.markov = new Markov();
               
        }
        public void CreateMarkovChains(String input)
        {
           map = markov.generateMarkovChain(input);
        }

        public void GenerateRandomText()
        {
           ArrayList<String> randomChoicesList = new ArrayList<>();
           String choicesTrimmed = null;
           String[] choicesArray = null;
           String word = null;
           String choices = null;
           String output;
           wordsArrayList = markov.getTokenizationByTwos();
           output = wordsArrayList.get(0);
          while(!"[]".equals(choices))
          {
          Pattern p = Pattern.compile("(([a-zA-Z0-9]+)\\s([a-zA-Z0-9]+))$");  
          Matcher m = p.matcher(output);
          while(m.find())
          {
          word = m.group(1);
          }
          choices = map.get(word).toString();
          System.out.println(choices);
          if(!"[]".equals(choices))
            choicesTrimmed = choices.substring(1, choices.length()-1);
            choicesArray = choicesTrimmed.split(",");
            int idx = new Random().nextInt(choicesArray.length);
            String random = (choicesArray[idx]);
            
            output = output.concat(" "+random);
          }
          
          System.out.println(output);
          
        }

       

}
