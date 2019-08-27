package ca.mariner.app;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class
 *
 */
public class Main {


	private final static Logger logger = Logger.getLogger(Main.class.getName());
	
    public static void main( String[] args ) throws Exception{
    	 List<String> paths = Arrays.asList(args);
    	 if(paths.isEmpty()) {
    		logger.log(Level.SEVERE, "Please enter data file location");
    		System.exit(Integer.MIN_VALUE);
    	}
		logger.log(Level.INFO, String.format("about to process %s", paths));
		new EventFilterProcessor().execute(paths);
		logger.log(Level.INFO,"Done");
    }
}
