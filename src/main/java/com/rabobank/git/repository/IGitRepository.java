package com.rabobank.git.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rabobank.git.model.PullReqResponse;
import com.rabobank.git.model.ReposResponse;

/**
 * Interface act as the FeignClient(used for intercommunication of microservices), here can call all
 * the API's available in Git
 * 
 * @author vinodhr
 *
 */
@FeignClient(name = "git-client-api", url = "${github.api.url}")
public interface IGitRepository {

	/**
	 * Git API - fetch all the repos for the given username.
	 * 
	 * @param username
	 * @return
	 */
	@GetMapping("/users/{username}/repos")
	public List<ReposResponse> fetchAllPublicRepos(@PathVariable("username") String username);

	/**
	 * Git API - fetch all the repo information for the given username/reponame
	 * 
	 * @param username
	 * @param reponame
	 * @return
	 */
	@GetMapping("/repos/{username}/{reponame}/pulls")
	public List<PullReqResponse> pullRequestDetails(@PathVariable("username") String username, @PathVariable("reponame") String reponame);

}
