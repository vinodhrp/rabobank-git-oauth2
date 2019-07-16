# Rabobank - Git API Invoker - Secured with OAuth2


## About the Application
* Java Web Application, which list out all the public repositories available of the logged Git User. 

## Install & Running
 
### Prerequisites
* [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)  - Programming language
* [Maven 3.5.0](https://maven.apache.org/download.cgi) - Build tool


### Pull from git 
```
$ git clone https://github.com/vinodhrp/rabobank-github-oauth2
$ cd rabobank-github-oauth2
```

### Build & run 

* Run test
```
$ mvn test
```

* Run the web server
```
$ mvn spring-boot:run
```


### API documentation
PCF -[https://rabobank-git-oauth2-io.cfapps.io/repos/vinodhrp](https://rabobank-git-oauth2-io.cfapps.io/repos/vinodhrp)
* Testing can be done only via Postman App.
* Testing Steps are available in root of Project [OAuth2-Postman.docx](https://github.com/vinodhrp/rabobank-git-oauth2/blob/master/OAuth2-Postman.docx) 




## Built With
* [Spring boot 1.5.19](https://projects.spring.io/spring-boot/) - Backed Framework
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Vinodh Ramamoorthy**

## License

This project is licensed under the MIT License

