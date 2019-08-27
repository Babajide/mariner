package ca.mariner.app.pojo;


import ca.mariner.app.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonNaming(PropertyNamingStrategy.KebabCaseStrategy.class)
public class Event {

	
	private String clientAddress;
	private String clientGuid;
	//2016-06-29 03:58:24 ADT
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_FORMAT, locale = "en_CA")	
	private Date requestTime;
	private String serviceGuid;
	private int retriesRequest;
	private int packetsRequested;
	private int packetsServiced;
	private int maxHoleSize;

	public Event() {
		super();
	}

		
	/**
	 * @param clientAddress
	 * @param clientGuid
	 * @param requestTime
	 * @param serviceGuid
	 * @param retriesRequest
	 * @param packetsRequested
	 * @param packetsServiced
	 * @param maxHoleSize
	 */
	public Event(String clientAddress, String clientGuid, Date requestTime, String serviceGuid, int retriesRequest,
			int packetsRequested, int packetsServiced, int maxHoleSize) {
		super();
		this.clientAddress = clientAddress;
		this.clientGuid = clientGuid;
		this.requestTime = requestTime;
		this.serviceGuid = serviceGuid;
		this.retriesRequest = retriesRequest;
		this.packetsRequested = packetsRequested;
		this.packetsServiced = packetsServiced;
		this.maxHoleSize = maxHoleSize;
	}

	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getClientGuid() {
		return clientGuid;
	}
	public void setClientGuid(String clientGuid) {
		this.clientGuid = clientGuid;
	}
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	public String getServiceGuid() {
		return serviceGuid;
	}
	public void setServiceGuid(String serviceGuid) {
		this.serviceGuid = serviceGuid;
	}
	public int getRetriesRequest() {
		return retriesRequest;
	}
	public void setRetriesRequest(int retriesRequest) {
		this.retriesRequest = retriesRequest;
	}
	public int getPacketsRequested() {
		return packetsRequested;
	}
	public void setPacketsRequested(int packetsRequested) {
		this.packetsRequested = packetsRequested;
	}
	public int getPacketsServiced() {
		return packetsServiced;
	}
	public void setPacketsServiced(int packetsServiced) {
		this.packetsServiced = packetsServiced;
	}
	public int getMaxHoleSize() {
		return maxHoleSize;
	}
	public void setMaxHoleSize(int maxHoleSize) {
		this.maxHoleSize = maxHoleSize;
	}

	@Override
	public String toString() {

		return String.format("%s,%s,%s,%s,%s,%s,%s,%s", clientAddress, clientGuid, requestTime, serviceGuid,retriesRequest, packetsRequested, packetsServiced, maxHoleSize);

	}
}
