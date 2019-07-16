package com.rabobank.git.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rabobank.git.constant.APIConstant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Takes responsibility of converting Json properties of Git to custom pojo properties. For getting
 * Repo List information from Git
 * 
 * @author vinodhr
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "full_name", "description", "url", "message", "documentation_url" })
@Getter
@Setter
public class ReposResponse {

	@ApiModelProperty(notes = APIConstant.REPO_ID)
	@JsonProperty("id")
	private Integer id;

	@ApiModelProperty(notes = APIConstant.REPO_NAME)
	@JsonProperty("name")
	private String name;

	@ApiModelProperty(notes = APIConstant.REPO_PATH)
	@JsonProperty("full_name")
	private String fullName;

	@ApiModelProperty(notes = APIConstant.REPO_DESC)
	@JsonProperty("description")
	private String description;

	@ApiModelProperty(notes = APIConstant.REPO_URL)
	@JsonProperty("url")
	private String url;

	@JsonProperty("message")
	@ApiModelProperty(notes = APIConstant.MSG)
	private String message;

	@JsonProperty("documentation_url")
	@ApiModelProperty(notes = APIConstant.DOC_URL)
	private String documentationUrl;

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("documentation_url")
	public String getDocumentationUrl() {
		return documentationUrl;
	}

	@JsonProperty("documentation_url")
	public void setDocumentationUrl(String documentationUrl) {
		this.documentationUrl = documentationUrl;
	}

}
