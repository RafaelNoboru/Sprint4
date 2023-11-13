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

import br.com.fiap.bo.PlanosBo;
import br.com.fiap.entity.Planos;

@Path("/planos")
public class PlanosResource {

		private PlanosBo planosBo; 

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Planos> listar (){
			planosBo = new PlanosBo();
			return planosBo.buscarPlanos();
		}

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response cadastrar(Planos planos, @Context UriInfo uriInfo) {
			planosBo = new PlanosBo();
			planosBo.cadastrar(planos);
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			builder.path(Integer.toString(planos.getIdPlano()));
		
			return Response.created(builder.build()).build();
		}
	}

