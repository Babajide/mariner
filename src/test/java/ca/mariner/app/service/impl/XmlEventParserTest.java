package ca.mariner.app.service.impl;

import ca.mariner.app.service.Parser;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for XMLEventParserTest.
 */
public class XmlEventParserTest {

	
	private final Parser eventParser = new XmlEventParser();

	@Test
	public void given_invalid_xml_file_return_empty() throws Exception {
		assertTrue(eventParser.parse("").isEmpty());
	}
	
	@Test
	public void given_json_file_return_empty() throws Exception {
		assertTrue(eventParser.parse("src/test/resources/reports.json").isEmpty());
	}
	
	@Test
	public void given_csv_file_return_empty() throws Exception {
		assertTrue(eventParser.parse("src/test/resources/reports.csv").isEmpty());
	}

	@Test
	public void given_valid_xml_file_return_stream() throws Exception {
		assertTrue(!eventParser.parse("src/test/resources/reports.xml").isEmpty());
	}

}
