package br.com.contracheque.ContrachequeOnline.business;


import java.util.List;

import br.com.contracheque.ContrachequeOnline.entity.Usuario;
import br.com.contracheque.ContrachequeOnline.persistence.UsuarioDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;


@BusinessController
public class UsuarioBC extends DelegateCrud<Usuario, Long, UsuarioDAO> {
	private static final long serialVersionUID = 1L;

	public List<Usuario> find(String filter) {
		return getDelegate().find(filter);
	}

}
