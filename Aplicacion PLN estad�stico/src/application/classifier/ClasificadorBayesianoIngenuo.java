package application.classifier;

import java.io.Serializable;
import com.syncleus.dann.classify.naive.bayes.SimpleLanguageNaiveBayesClassifier;

/**
 * Clase que extiende la clase perteneciente a la biblioteca que implementa el
 * clasificador bayesiano ingenuo
 * 
 * @author Alberto Rodríguez Peón
 * 
 */
public class ClasificadorBayesianoIngenuo extends
		SimpleLanguageNaiveBayesClassifier<String> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9131889514731131427L;

}
