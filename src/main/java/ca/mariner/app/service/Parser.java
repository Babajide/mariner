/**
 * 
 */
package ca.mariner.app.service;

import ca.mariner.app.pojo.Event;

import java.util.List;

/**
 * @author prince
 * A format agnostic event parser interface
 */
public interface Parser {
	
	List<Event> parse(final String path) throws Exception;
	
}
