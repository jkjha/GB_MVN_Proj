
import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.matcher.RestAssuredMatchers.matchesXsd;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.ResponseSpecification;

public class TestNGSimpleTest1 {

	@Test
	public void testAdd() {
		//expect().
		//statusCode(400).
		//body("Status", equalTo("Success")).
		//when().
		//get("http://localhost:9000/dashboards/all/list/m1/p1/sch1");
	 	//System.out.println("Response received is ::" +res);	
		Response res = get("http://localhost:9000/dashboards/all/list/m1/p1/sch1");
		assertEquals(200,res.getStatusCode());
		String json = res.asString();
		System.out.println("Response received is :: " +json);
	}

/*	@Test
	public void testGetSingleUserProgrammatic() {
		Response res = get("/service/single-user");
		assertEquals(200, res.getStatusCode());
		String json = res.asString();
		JsonPath jp = new JsonPath(json);
		assertEquals("test@hascode.com", jp.get("email"));
		assertEquals("Tim", jp.get("firstName"));
		assertEquals("Testerman", jp.get("lastName"));
		assertEquals("1", jp.get("id"));
	}

	@Test
	public void testGetSingleUserAsXml() {
		expect().statusCode(200)
				.body("user.email", equalTo("test@hascode.com"),
						"user.firstName", equalTo("Tim"), "user.lastName",
						equalTo("Testerman"), "user.id", equalTo("1")).when()
				.get("/service/single-user/xml");
	}

	@Test
	public void testGetPersons() {
		expect().statusCode(200)
				.body(hasXPath("//person[@id='1']/email[.='test@hascode.com'] and firstName='Tim' and lastName='Testerman'"))
				.body(hasXPath("//person[@id='20']/email[.='dev@hascode.com'] and firstName='Sara' and lastName='Stevens'"))
				.body(hasXPath("//person[@id='1']/email[.='devnull@hascode.com'] and firstName='Mark' and lastName='Mustache'"))
				.when().get("/service/persons/xml");
	}

	@Test
	public void testFindUsingGroovyClosure() {
		String json = get("/service/persons/json").asString();
		JsonPath jp = new JsonPath(json);
		jp.setRoot("person");
		Map person = jp.get("find {e -> e.email =~ /test@/}");
		assertEquals("test@hascode.com", person.get("email"));
		assertEquals("Tim", person.get("firstName"));
		assertEquals("Testerman", person.get("lastName"));

	}

	@Test
	public void testGetSingleUserAgainstSchema() {
		InputStream xsd = getClass().getResourceAsStream("/user.xsd");
		assertNotNull(xsd);
		expect().statusCode(200).body(matchesXsd(xsd)).when()
				.get("/service/single-user/xml");
	}

	@Test
	public void testCreateuser() {
		final String email = "test@hascode.com";
		final String firstName = "Tim";
		final String lastName = "Tester";

		given().parameters("email", email, "firstName", firstName, "lastName",
				lastName).expect().body("email", equalTo(email))
				.body("firstName", equalTo(firstName))
				.body("lastName", equalTo(lastName)).when()
				.get("/service/user/create");
	}

	@Test
	public void testStatusNotFound() {
		expect().statusCode(404).when().get("/service/status/notfound");
	}

	@Test
	public void testAuthenticationWorking() {
		// we're not authenticated, service returns "401 Unauthorized"
		expect().statusCode(401).when().get("/service/secure/person");

		// with authentication it is working
		expect().statusCode(200).when().with().authentication()
				.basic("admin", "admin").get("/service/secure/person");
	}

	@Test
	public void testSetRequestHeaders() {
		expect().body(equalTo("TEST")).when().with().header("myparam", "TEST")
				.get("/service/header/print");
		expect().body(equalTo("foo")).when().with().header("myparam", "foo")
				.get("/service/header/print");
	}

	@Test
	public void testReturnedHeaders() {
		expect().headers("customHeader1", "foo", "anotherHeader", "bar").when()
				.get("/service/header/multiple");
	}

	@Test
	public void testAccessSecuredByCookie() {
		expect().statusCode(403).when()
				.get("/service/access/cookie-token-secured");
		given().cookie("authtoken", "abcdef").expect().statusCode(200).when()
				.get("/service/access/cookie-token-secured");
	}

	@Test
	public void testModifyCookie() {
		expect().cookie("userName", equalTo("Ted")).when().with()
				.param("name", "Ted").get("/service/cookie/modify");
		expect().cookie("userName", equalTo("Bill")).when().with()
				.param("name", "Bill").get("/service/cookie/modify");
	}

	@Test
	public void testFileUpload() {
		final File file = new File(getClass().getClassLoader()
				.getResource("test.txt").getFile());
		assertNotNull(file);
		assertTrue(file.canRead());
		given().multiPart(file).expect()
				.body(equalTo("This is an uploaded test file.")).when()
				.post("/service/file/upload");
	}

	@Test
	public void testRegisterParserForUnknownContentType() {
		RestAssured.registerParser("text/json", Parser.JSON);
		expect().body("test", equalTo(true)).when().get("/service/detail/json");
	}

	@Test
	public void testSpecReuse() {
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		builder.expectBody("email", equalTo("test@hascode.com"));
		builder.expectBody("firstName", equalTo("Tim"));
		builder.expectBody("lastName", equalTo("Testerman"));
		builder.expectBody("id", equalTo("1"));
		ResponseSpecification responseSpec = builder.build();

		// now we're able to use this specification for this test
		expect().spec(responseSpec).when().get("/service/single-user");

		// now re-use for another test that returns similar data .. you may
		// extend the specification with further tests as you wish
		final String email = "test@hascode.com";
		final String firstName = "Tim";
		final String lastName = "Testerman";

		expect().spec(responseSpec)
				.when()
				.with()
				.parameters("email", email, "firstName", firstName, "lastName",
						lastName).get("/service/user/create");
	}
*/
}


