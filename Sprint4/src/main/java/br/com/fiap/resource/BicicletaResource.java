package br.com.fiap.resource;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.fiap.bo.BicicletaBo;
import br.com.fiap.entity.Bicicleta;

@Path("/bicicleta")
public class BicicletaResource {
	
	private BicicletaBo bicicletaBo; 

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bicicleta> listar (){
		bicicletaBo = new BicicletaBo();
		return bicicletaBo.buscarBicicletas();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Bicicleta bicicleta, @Context UriInfo uriInfo) {
		bicicletaBo = new BicicletaBo();
		bicicletaBo.cadastrar(bicicleta);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(bicicleta.getIdBicicleta()));
	
		return Response.created(builder.build()).build();
	}
	@GET
	@Path("/{IdBicicleta}")
	@Produces(MediaType.APPLICATION_JSON)

	public Bicicleta buscarBicicletaPorId(@PathParam("id") int idBicicleta){
		bicicletaBo = new BicicletaBo();
		return bicicletaBo.buscarBicicletaPorId(idBicicleta);
	}
}