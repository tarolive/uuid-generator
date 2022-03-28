package app.resource

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/ping")
class PingResource {

	@GET
	fun ping(): String = "pong";

	@GET
	@Path("/unhealthy")
	fun pingUnhealthy(): String = if (Math.random() <= 0.1) throw Exception("unhealthy") else ping();
}
