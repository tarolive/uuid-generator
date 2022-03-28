package app.resource

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.apache.http.HttpStatus
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class PingResourceTest {

	@Test
	fun testPing() {

		given()
			.`when`().get("/ping")
			.then()
			.statusCode(HttpStatus.SC_OK)
			.body(`is`("pong"));
	}
}
