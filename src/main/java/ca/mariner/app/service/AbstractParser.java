package ca.mariner.app.service;


import ca.mariner.app.pojo.SourceFormat;
/**
 * 
 * @author prince
 * AbstractEventParser - common logic
 */
public abstract class AbstractParser {
	

	protected abstract SourceFormat format();
	
	protected boolean isSupport(final String fileName) {
		return fileName != null 
				&& fileName.toLowerCase().endsWith(format().name().toLowerCase());
	}
}
