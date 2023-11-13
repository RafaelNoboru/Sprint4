package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ProprietarioBo;
import br.com.fiap.entity.Proprietario;


@Path("/proprietario")
public class ProprietarioResource {
	
	private ProprietarioBo proprietarioBo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Proprietario> listar (){
		proprietarioBo = new ProprietarioBo();
		return proprietarioBo.buscarProprietarios();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Proprietario proprietario, @Context UriInfo uriInfo) {
		proprietarioBo = new ProprietarioBo();
		proprietarioBo.cadastrar(proprietario);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(proprietario.getIdProprietario()));
	
		return Response.created(builder.build()).build();
	}
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(Proprietario proprietario, @PathParam("id") int id ) {
		proprietarioBo = new ProprietarioBo();
		proprietarioBo.atualizar(proprietario);
		return Response.ok().build();
	}
}
