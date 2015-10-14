package br.com.contracheque.ContrachequeOnline.business;


import java.util.List;

import br.com.contracheque.ContrachequeOnline.entity.Dados;
import br.com.contracheque.ContrachequeOnline.persistence.DadosDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;


@BusinessController
public class DadosBC extends DelegateCrud<Dados, Long, DadosDAO> {
	private static final long serialVersionUID = 1L;

	public List<Dados> find(String filter) {
		return getDelegate().find(filter);
	}

}
