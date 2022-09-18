package com.dsproject.client.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private Integer status;
	private String error;
	private String massage;
	private String paht;
	
	public StandardError() {
		
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getPaht() {
		return paht;
	}

	public void setPaht(String paht) {
		this.paht = paht;
	}

}
