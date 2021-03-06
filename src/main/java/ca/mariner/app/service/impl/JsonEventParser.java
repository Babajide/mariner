package ca.mariner.app.service.impl;

import ca.mariner.app.pojo.Event;
import ca.mariner.app.pojo.SourceFormat;
import ca.mariner.app.service.AbstractParser;
import ca.mariner.app.service.Parser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonEventParser extends AbstractParser implements Parser {

	
	static {
		objectMapper = new ObjectMapper();
	}
	
	private final static ObjectMapper objectMapper;
	private final Logger logger = Logger.getLogger(getClass().getName());
	
	
	@Override
	public List<Event> parse(String path) throws  Exception {
		
		if (isSupport(path)) {
			logger.log(Level.INFO, String.format("Loading %s events from %s", format(), path)); 
			
			List<Event> events = objectMapper.readValue(
					new File(path), 
					new TypeReference<List<Event>>(){});
			logger.log(Level.INFO, String.format("Loaded total %s %s events", events.size(), format())); 
			return events;
		}
		return new ArrayList<>();
	}


	@Override
	protected SourceFormat format() {
		return SourceFormat.JSON;
	}

}
