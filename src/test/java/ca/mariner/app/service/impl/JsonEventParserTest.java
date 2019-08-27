package ca.mariner.app.service.impl;

import ca.mariner.app.service.Parser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for JSONEventParser.
 */
public class JsonEventParserTest {

	private final Parser jsonParser = new JsonEventParser();

	@Test
	public void given_invalid_json_file_return_empty() throws Exception {
		assertTrue(jsonParser.parse("").isEmpty());
	}
	
	@Test
	public void given_xml_file_return_empty() throws Exception {
		assertTrue(jsonParser.parse("src/test/resources/reports.xml").isEmpty());
	}
	
	@Test
	public void given_csv_file_return_empty() throws Exception {
		assertTrue(jsonParser.parse("src/test/resources/reports.csv").isEmpty());
	}

	@Test
	public void given_valid_jsonfile_return_stream() throws Exception {
		assertTrue(!jsonParser.parse("src/test/resources/reports.json").isEmpty());
	}
}
