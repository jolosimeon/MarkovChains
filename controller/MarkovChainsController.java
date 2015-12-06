package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utilities.Markov;

import view.IMarkovChainsView;

public class MarkovChainsController {

        private IMarkovChainsView view;
        private Markov markov;
       
        public MarkovChainsController(IMarkovChainsView view) {
            this.view = view;
             this.markov = new Markov();
               
        }
        
        public void CreateMarkovChains(String input)
        {
            String[] inputSentences = input.split("\\. ");
            for(int i = 0; i < inputSentences.length; i++)
            markov.generateMarkovChain(inputSentences[i]);
        }

        public String getGeneratedMarkovChains(int nLength)
        {
            return markov.getGeneratedMarkovChain(nLength);
        }

}
