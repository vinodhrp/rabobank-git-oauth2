package com.rabobank.git.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rabobank.git.constant.APIConstant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Takes responsibility of converting Json properties of Git to custom pojo
 * properties. For getting given Repo information from Git
 * 
 * @author vinodhr
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "number", "state", "title", "body", "message", "documentation_url" })
@Getter
@Setter
public class PullReqResponse {

	@ApiModelProperty(notes = APIConstant.PULL_ID)
	@JsonProperty("id")
	private Integer id;

	@ApiModelProperty(notes = APIConstant.PULL_NUMBER)
	@JsonProperty("number")
	private String pullNumber;

	@ApiModelProperty(notes = APIConstant.PULL_STATUS)
	@JsonProperty("state")
	private String status;

	@ApiModelProperty(notes = APIConstant.PULL_TITLE)
	@JsonProperty("title")
	private String title;

	@ApiModelProperty(notes = APIConstant.MSG)
	@JsonProperty("message")
	private String message;

	@ApiModelProperty(notes = APIConstant.DOC_URL)
	@JsonProperty("documentation_url")
	private String documentationUrl;

}
