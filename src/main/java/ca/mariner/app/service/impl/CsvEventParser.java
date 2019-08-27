package ca.mariner.app.service.impl;

import ca.mariner.app.Constants;
import ca.mariner.app.pojo.Event;
import ca.mariner.app.pojo.SourceFormat;
import ca.mariner.app.service.AbstractParser;
import ca.mariner.app.service.Parser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CsvEventParser extends AbstractParser implements Parser {

	private final Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public List<Event> parse(final String path) throws Exception {
		if (isSupport(path)) {
			logger.log(Level.INFO, String.format("Loading %s events from %s", format(), path));

				List<Event> events = Files.lines(Paths.get(path))
						.skip(1)
						.map(this::map)
						.collect(Collectors.toList());
				logger.log(Level.INFO, String.format("Loaded total %s %s events", events.size(), format()));
				return events;
		
		}
		return new ArrayList<>();
	}

	@Override
	protected SourceFormat format() {
		return SourceFormat.CSV;
	}

	private Event map(String csv)  {
		String[] columns = csv.split(",");
		try {
			return new Event(
					columns[0],
					columns[1],
					new SimpleDateFormat(Constants.DATE_FORMAT).parse(columns[2]),
					columns[3],
					Integer.valueOf(columns[4]),
					Integer.valueOf(columns[5]),
					Integer.valueOf(columns[6]),
					Integer.valueOf(columns[7]));
		} catch (ParseException e) {
			logger.severe(e.getMessage());
		}
		return null;
	}

}
