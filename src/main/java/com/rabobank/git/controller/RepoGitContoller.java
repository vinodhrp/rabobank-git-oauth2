package com.rabobank.git.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rabobank.git.constant.APIConstant;
import com.rabobank.git.constant.MappingConstant;
import com.rabobank.git.model.PullReqResponse;
import com.rabobank.git.model.ReposResponse;
import com.rabobank.git.repository.IGitRepository;
import com.rabobank.git.util.CustomMessage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller hits the Git API's and fetch details depends upon the input.
 * 
 * @author vinodhr
 *
 */
@RestController
@RequestMapping(MappingConstant.ENTRY)
@Api(value = APIConstant.REPO_CNTRLR_DESC)
public class RepoGitContoller {

	public Logger logger = LoggerFactory.getLogger(RepoGitContoller.class);

	@Autowired
	private IGitRepository gitRepository;

	/**
	 * Get Method to fetch all the Public Repository available for the given Git User.
	 * 
	 * @param username
	 * @return ResponseEntity
	 */
	@ApiOperation(value = APIConstant.REPOS_DETAIL_DESC, httpMethod = APIConstant.API_GET, response = ReposResponse.class)
	@GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAllRepos(@PathVariable("username") String username) {
		logger.info("Given UserName  : {} ", username);
		List<ReposResponse> reposResponses = gitRepository.fetchAllPublicRepos(username);
		if (reposResponses.isEmpty()) {
			logger.error("No Repos Found for the given User.  : ", username);
			CustomMessage apiCustomMessage = new CustomMessage(HttpStatus.NOT_FOUND, "No Repos Found for the given User.  : " + username);
			return new ResponseEntity<CustomMessage>(apiCustomMessage, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ReposResponse>>(reposResponses, HttpStatus.OK);
	}

	/**
	 * Get Method to fetch all the Public Repository Information for the given username and reponame.
	 * 
	 * @param username
	 * @param reponame
	 * @return ResponseEntity
	 */
	@ApiOperation(value = APIConstant.PULL_DETAIL_DESC, httpMethod = APIConstant.API_GET, response = PullReqResponse.class)
	@RequestMapping(value = "/pulls/{username}/{reponame}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> pullRequestForRepo(@PathVariable("username") String username, @PathVariable("reponame") String reponame) {
		logger.info("Given UserName/RepoName {} : ", username, reponame);
		List<PullReqResponse> reposResponses = gitRepository.pullRequestDetails(username, reponame);
		if (reposResponses.isEmpty()) {
			logger.error("No Pull Requests Found for {} : ", username, reponame);
			CustomMessage apiCustomMessage = new CustomMessage(HttpStatus.NOT_FOUND, "No Pull Requests Found for : " + username + "/" + reponame);
			return new ResponseEntity<CustomMessage>(apiCustomMessage, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<PullReqResponse>>(reposResponses, HttpStatus.OK);
	}

}
