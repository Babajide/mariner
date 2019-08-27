package ca.mariner.app.service.impl;


import ca.mariner.app.service.Parser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CsvEventParserTest {

	private final Parser csvParser = new CsvEventParser();

	@Test
	public void given_invalid_csv_file_return_empty() throws Exception {
		assertTrue(csvParser.parse("").isEmpty());
	}
	
	@Test
	public void given_xml_file_return_empty() throws Exception {
		assertTrue(csvParser.parse("src/test/resources/reports.xml").isEmpty());
	}
	
	@Test
	public void given_json_file_return_empty() throws Exception {
		assertTrue(csvParser.parse("src/test/resources/reports.json").isEmpty());
	}

	@Test
	public void given_valid_csv_file_return_stream() throws Exception {
		assertTrue(!csvParser.parse("src/test/resources/reports.csv").isEmpty());
	}

}
