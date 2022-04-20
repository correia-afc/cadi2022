# Xpand-IT
## _Spring Boot REST API_

Welcome to the Spring Boot REST API exercise.

Follow the following steps to complete it.

1- Clone this repository and execute the City Service on your IDE or by executing (in the city-service folder):
```sh
.\mvnw spring-boot:run
```

2- Try the already implemented endpoints on your browser and/or REST client:
- GET - http://localhost:8080/cities
- GET - http://localhost:8080/cities/2
- POST - http://localhost:8080/cities
```sh
With the following request body
{"name": "Viseu"}
```

3- Implement the remaining CRUD methods on _CityController.java_ and _CityService.java_

4- Restart your City Service and test the new endpoints on you REST client

Congratulations, you've just built your first REST API using Spring Boot!


## Security

Not all API's need to be public. Like with most components with Spring Boot it is relatively simple to add security:

1- Add the following dependency on _pom.xml_
```sh
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

2- Restart City Service and try to access one of the GET endpoints using your browser. You are now prompted to enter credentials as your API is not public anymore.
```sh
The default username is: user
The password can be found on the console output. There should be a line similar to:
"Using generated security password: ....."
```

3- A custom username and password can be defined in the _application.properties_ file by adding the following properties:
```sh
spring.security.user.name=xxxxx
spring.security.user.password=xxxxx
```

Note 1: This is simply Basic Authentication, however is is just as simple to add a more secure option (such as OAuth).

Note 2: POST, PUT and DELETE endpoints will fail with a 403 response code because Spring security enables CSRF protection by default. To disable it (in a real life scenario this would require some thought), add the following code in _DemoApplication.java_

```sh
@Configuration
class SpringBootSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .httpBasic();
    }
}
```