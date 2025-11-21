package com.yg.microservices.product;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
// Use RANDOM_PORT to avoid port conflicts during parallel test execution: it may run on 8080
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
	
	@ServiceConnection
	 static MongoDBContainer mongoDBContainer =
	            new MongoDBContainer("mongo:7.0.5");

	    static {
	        mongoDBContainer.start();
	    }
	    
	    @LocalServerPort
	    private Integer port;
	    
	    @BeforeEach
	    void setup()
	    {
	    	RestAssured.baseURI = "http://localhost";
	    	RestAssured.port = port;
	    }
	@Test
	void shouldCreatProduct() {
		
		String productRequest = """
				{
	"name": "iphone 15",
	"description": "its an phone",
	"price": 3537647
}
				""";

		RestAssured.given()
				.contentType("application/json")
				.body(productRequest)
				.when()
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("iphone 15"))
				.body("description", Matchers.equalTo("its an phone"))
				.body("price", Matchers.equalTo(3537647));
		
	}

}
