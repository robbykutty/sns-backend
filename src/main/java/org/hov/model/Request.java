package org.hov.model;

import java.net.URL;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hov.enums.RequestStatus;
import org.hov.enums.RequestType;

@Entity
@Table(name = "requests")
public class Request {
	@Id
	@GeneratedValue
	private UUID requestId;
	
	@Column(name = "request_type")
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private RequestType requestType; 

	@Column(name = "request_status")
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private RequestStatus requestStatus;
	
	//private User user;
	
	//private Admin admin;

	@Column(name = "request_title")
	private String requestTitle;

	@Column(name = "request_text")
	private String requestText;

	@Column(name = "request_image_url")
	private URL requestImage;
	
	public UUID getRequestId() {
		return requestId;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getRequestTitle() {
		return requestTitle;
	}

	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}

	public String getRequestText() {
		return requestText;
	}

	public void setRequestText(String requestText) {
		this.requestText = requestText;
	}

	public URL getRequestImage() {
		return requestImage;
	}

	public void setRequestImage(URL requestImage) {
		this.requestImage = requestImage;
	}
}