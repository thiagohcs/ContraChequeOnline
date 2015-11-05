package br.com.contracheque.ContrachequeOnline.security;

import java.security.Principal;

import br.com.contracheque.ContrachequeOnline.entity.Usuario;
import br.com.contracheque.ContrachequeOnline.persistence.UsuarioDAO;
import br.gov.frameworkdemoiselle.security.Credentials;
import br.gov.frameworkdemoiselle.security.InvalidCredentialsException;
import br.gov.frameworkdemoiselle.security.TokenAuthenticator;
import br.gov.frameworkdemoiselle.util.Beans;

public class AppAuthenticator extends TokenAuthenticator {

	private static final long serialVersionUID = 1L;

	@Override
	protected Principal customAuthentication() throws Exception {
		Principal user = null;
		final Credentials credentials = Beans.getReference(Credentials.class);
		final String username = credentials.getUsername();
		UsuarioDAO dao = new UsuarioDAO();

		Usuario userBD = dao.findUsuarioByLogin(credentials.getUsername(), credentials.getPassword());

		if (credentials.getUsername().equals(userBD.getLogin())
				&& credentials.getPassword().equals(userBD.getSenha())) {
			
			
			//REDIRECIONA PARA O ADM
			user = new Principal() {

				@Override
				public String getName() {
					return username;
				}
			};

		} else {
			throw new InvalidCredentialsException();
		}

		return user;
	}
}
