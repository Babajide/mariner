package ca.mariner.app;

import ca.mariner.app.pojo.Event;
import ca.mariner.app.service.Parser;
import ca.mariner.app.service.impl.CsvEventParser;
import ca.mariner.app.service.impl.JsonEventParser;
import ca.mariner.app.service.impl.XmlEventParser;
import ca.mariner.app.util.EventUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

final class EventFilterProcessor {


    private final  Logger logger = Logger.getLogger(getClass().getName());

      void execute(List<String> paths) throws Exception {

        // In the real world, we would inject these from a container.
        List<Parser> parsers = Arrays.asList(
                new XmlEventParser(),
                new JsonEventParser(),
                new CsvEventParser());

        final List<Event> events = new ArrayList<Event>();

        paths.forEach( path -> {
            parsers.forEach(parser -> {
                try {
                    //merge all events.
                    events.addAll(parser.parse(path));
                } catch (Exception e) {
                    logger.log(Level.SEVERE, e.getMessage());
                }
            });
        });

        logger.log(Level.INFO, String.format("Total count %s", events.size()));

        /*
         * - All report records with packets-serviced equal to zero should be excluded
         * - records should be sorted by request-time in ascending order
         */
       List<Event> filtered =  events.stream()
                .filter(s -> s.getPacketsServiced() > 0)
                .sorted(Comparator.comparing(Event::getRequestTime))
                .collect(Collectors.toList());

        EventUtils.write(filtered, "./out.csv");
        EventUtils.computeStats(filtered);

    }
}
