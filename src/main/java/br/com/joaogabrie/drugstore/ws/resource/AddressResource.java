package br.com.joaogabrie.drugstore.ws.resource;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.joaogabrie.drugstore.ws.payload.AddressResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/zip")
public class AddressResource {

	private final Logger logger = Logger.getLogger(AddressResource.class.getName());

	@GET
	@Path("/{cep}")
	@Produces(MediaType.APPLICATION_JSON)
	public AddressResponse getAddressByCep(@PathParam("cep") String cep) {
		logger.log(Level.INFO, "Getting Address by Cep: {0}", cep);
		try (Client client = ClientBuilder.newClient()) {
			Response response = client.target(String.format("https://viacep.com.br/ws/%s/json", cep))
					.request(MediaType.APPLICATION_JSON).get();
			logger.log(Level.INFO, "Http Status Code: {0}", response.getStatus());
			return response.readEntity(AddressResponse.class);
		}
	}

}
