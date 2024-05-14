package app.resource

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/ping")
class PingResource {

	@GET
	fun ping(): Response = Response.ok("pong!").build();

	@GET
	@Path("/unhealthy")
	fun pingUnhealthy(): Response = if (Math.random() <= 0.1) Response.serverError().build() else ping();
}
