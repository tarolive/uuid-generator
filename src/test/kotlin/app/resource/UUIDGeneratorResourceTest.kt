package app.resource

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.apache.http.HttpStatus
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import java.util.*

@QuarkusTest
class UUIDGeneratorResourceTest {

	@Test
	fun testUUIDGenerator() {
		val size = (Math.random() * 1000).toInt()
		val delay = ((Math.random() * 1000) + 1000).toInt()

		given()
			.`when`().get("/uuid-generator?size=$size&delay=$delay")
			.then()
			.statusCode(HttpStatus.SC_OK)
			.body("uuid", hasSize<List<UUID>>(equalTo(size)))
			.body("size", equalTo(size))
			.body("delay", equalTo(delay))
			.body("dateRequest", notNullValue())
			.body("dateResponse", notNullValue())
	}
}
