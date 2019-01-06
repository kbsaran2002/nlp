import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.Date;
import java.util.List;
import java.util.Properties;

public class NlpSample {

    public static void main(String[] args) {
    	
    	   Date date = new Date();

           // display time and date using toString()
           System.out.println(date.toString());
           

        // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // read some text in the text variable
        //String text = "What is the Weather in Bangalore right now?";
        // Instantiate a Date object
     
       // String text = "how far is madurai from here ?";
     //   String text = "I am experienced in Java,SQL Server and Scripting Languages."
       // 		+ "My projects include SAMI application where in we used Java,SYbase and Perl as technologies.";
        
        String text = "Asian equities have lost about $5 trillion in value and the benchmark is poised for its worst annual decline since 2011. "
        		+ "But look closely and it’s the only regional benchmark index globally to produce stocks whose values have increased several times "
        		+ "from the start of the year.\n" + 
        		"\n" + 
        		"The share prices of the top two gainers on the MSCI Asia Pacific Index have more than tripled this year "
        		+ "and seven others have doubled their stock values. This came at a time when the regional gauge entered "
        		+ "a bear market earlier this year, falling 22 percent from its January peak. U.S. and European benchmarks, "
        		+ "which have come close to entering bear territory, have had no such share performances.\n" + 
        		"Read more: All The Blows That Wiped $5 Trillion From Asia Stocks This Year\n" +  
        		"“As it is, 2018 has been pretty eventful,” said Christina Woon, Asian equities investment manager at "
        		+ "Aberdeen Standard Investments in Singapore. “The approach remains consistent in this environment, "
        		+ "where unwarranted and outsized reactions that belie underlying fundamentals can provide opportunities to capitalize on selectively.”\n" + 
        		"Stock-pickers galore? The so-called multibaggers in Asia may underscore the “bottom up” "
        		+ "approach to stock selection amid volatility caused by the U.S-China trade war and Federal Reserve’s interest-rate hikes.";

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);

        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

        for (CoreMap sentence : sentences) {
            // traversing the words in the current sentence
            // a CoreLabel is a CoreMap with additional token-specific methods
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // this is the text of the token
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                // this is the POS tag of the token
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                // this is the NER label of the token
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

                System.out.println(String.format("Print: word: [%s] pos: [%s] ne: [%s]", word, pos, ne));
            }
        }
        
 	   Date date1 = new Date();

        // display time and date using toString()
        System.out.println(date1.toString());
        
    }
}