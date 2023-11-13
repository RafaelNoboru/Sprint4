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


import br.com.fiap.bo.PecasBicicletaBo;
import br.com.fiap.entity.PecasBicicleta;

@Path("/pecas")
public class PecasBicicletaResource {

	private PecasBicicletaBo pecasBicicletaBo; 

@GET
@Produces(MediaType.APPLICATION_JSON)
		public List<PecasBicicleta> listar (){
			pecasBicicletaBo = new PecasBicicletaBo();
			return pecasBicicletaBo.buscarPecas();
		}

@POST
@Consumes(MediaType.APPLICATION_JSON)
		public Response cadastrar(PecasBicicleta pecasbicicleta, @Context UriInfo uriInfo) {
			pecasBicicletaBo = new PecasBicicletaBo();
			pecasBicicletaBo.cadastrar(pecasbicicleta);
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			builder.path(Integer.toString(pecasbicicleta.getIdPecaBicicleta()));
		
			return Response.created(builder.build()).build();
		}
}
