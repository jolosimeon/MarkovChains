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
        private int outputLength = 5;
       
        public MarkovChainsController(IMarkovChainsView view) {
            this.view = view;
             this.markov = new Markov();
               
        }
        
        public void CreateMarkovChains(String input)
        {
            markov.generateMarkovChain(input);
        }

        public String getGeneratedMarkovChains()
        {
            return markov.getGeneratedMarkovChain(outputLength);
        }
        
        public int getLength()
        {
            return outputLength;
        }
        
        public void setLength(int outputLength)
        {
            this.outputLength = outputLength;
        }

}
