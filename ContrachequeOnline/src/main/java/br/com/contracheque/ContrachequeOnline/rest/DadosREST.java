package br.com.contracheque.ContrachequeOnline.rest;

import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.contracheque.ContrachequeOnline.business.DadosBC;
import br.com.contracheque.ContrachequeOnline.entity.Dados;
import br.gov.frameworkdemoiselle.BadRequestException;
import br.gov.frameworkdemoiselle.NotFoundException;
import br.gov.frameworkdemoiselle.security.LoggedIn;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.Strings;
import br.gov.frameworkdemoiselle.util.ValidatePayload;



@Path("dados")
public class DadosREST {

	@Inject
	private DadosBC bc;

	@GET
	@Produces("application/json")
	public List<Dados> find(@QueryParam("q") String query) throws Exception {
		List<Dados> result;

		if (Strings.isEmpty(query)) {
			result = bc.findAll();
		} else {
			result = bc.find(query);
		}

		return result;
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public Dados load(@PathParam("id") Long id) throws Exception {
		Dados result = bc.load(id);

		if (result == null) {
			throw new NotFoundException();
		}

		return result;
	}

	@POST
	@LoggedIn
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public Response insert(Dados entity, @Context UriInfo uriInfo) throws Exception {
		checkId(entity);

		String id = bc.insert(entity).getId().toString();
		URI location = uriInfo.getRequestUriBuilder().path(id).build();

		return Response.created(location).entity(id).build();
	}

	@PUT
	@LoggedIn
	@Path("{id}")
	@Transactional
	@ValidatePayload
	@Produces("application/json")
	@Consumes("application/json")
	public void update(@PathParam("id") Long id, Dados entity) throws Exception {
		checkId(entity);
		load(id);

		entity.setId(id);
		bc.update(entity);
	}

	@DELETE
	@LoggedIn
	@Path("{id}")
	@Transactional
	public void delete(@PathParam("id") Long id) throws Exception {
		load(id);
		bc.delete(id);
	}

	@DELETE
	@LoggedIn
	@Transactional
	public void delete(List<Long> ids) throws Exception {
		bc.delete(ids);
	}

	private void checkId(Dados entity) throws Exception {
		if (entity.getId() != null) {
			throw new BadRequestException();
		}
	}
}