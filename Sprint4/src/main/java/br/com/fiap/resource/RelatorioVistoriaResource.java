package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.RelatorioVistoriaBo;
import br.com.fiap.entity.RelatorioVistoria;

@Path("/vistoria")
public class RelatorioVistoriaResource {
	
	private RelatorioVistoriaBo relatorioVistoriaBo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RelatorioVistoria> listar (){
		relatorioVistoriaBo = new RelatorioVistoriaBo();
		return relatorioVistoriaBo.buscarRelatorios();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(RelatorioVistoria relatorioVistoria, @Context UriInfo uriInfo) {
		relatorioVistoriaBo = new RelatorioVistoriaBo();
		relatorioVistoriaBo.cadastrar(relatorioVistoria);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(relatorioVistoria.getIdVistoria()));
	
		return Response.created(builder.build()).build();
	}
}
