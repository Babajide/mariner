package ca.mariner.app.util;

import ca.mariner.app.Constants;
import ca.mariner.app.pojo.Event;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class EventUtils {

    private static final Logger logger = Logger.getLogger(EventUtils.class.getName());

    public static void computeStats(List<Event> list){

        Map<String, Long> counting = list.stream().collect(
                Collectors.groupingBy(Event::getServiceGuid, Collectors.counting()));
        StringBuilder builder = new StringBuilder();
        builder.append(System.lineSeparator());
        counting.forEach((s, aLong) -> {
            builder.append(String.format("Service GUID: %s  Total events: %s", s, aLong));
            builder.append(System.lineSeparator());
        });
        //print summary
        logger.info(builder.toString());
    }


    public static void write(List<Event> events, String path) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(Constants.CSV_HEADER);
        builder.append(System.lineSeparator());
        events.forEach(i->{
            builder.append(i.toString());
            builder.append(System.lineSeparator());
        });
       Files.write(Paths.get(path), builder.toString().getBytes(StandardCharsets.UTF_8));

    }
}
