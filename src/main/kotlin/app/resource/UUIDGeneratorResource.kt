package app.resource

import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam

@Path("/uuid-generator")
class UUIDGeneratorResource {

	@GET
	fun get(
		@QueryParam("size") size: Int = 1,
		@QueryParam("delay") delay: Int = 0
	): Response {
		val uuid = (1..size).map { UUID.randomUUID() }

		val dateRequest = Date()
		val dateResponse = if (delay <= 0) dateRequest else {
			Thread.sleep(delay.toLong())
			Date()
		}

		return Response(
			uuid,
			size,
			delay,
			dateRequest,
			dateResponse
		)
	}

	data class Response(
		val uuid: List<UUID>,
		val size: Int,
		val delay: Int,
		val dateRequest: Date,
		val dateResponse: Date
	)
}
