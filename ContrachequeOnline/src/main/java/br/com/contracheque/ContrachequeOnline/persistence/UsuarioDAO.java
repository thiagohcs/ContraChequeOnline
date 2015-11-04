
package br.com.contracheque.ContrachequeOnline.persistence;

import java.util.List;
import javax.persistence.TypedQuery;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.contracheque.ContrachequeOnline.entity.Usuario;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {

	private static final long serialVersionUID = 1L;

	public List<Usuario> find(String filter) {
		StringBuffer ql = new StringBuffer();
		ql.append("  from Usuario p ");
		// use where and or operator as filter
		// ql.append(" where lower(p.attribute) like :attribute ");
		// ql.append(" or lower(p.anotherAttribute) like :anotherAttribute ");
		// list of attributes

		TypedQuery<Usuario> query = getEntityManager().createQuery(ql.toString(), Usuario.class);
		// use setParameter to fill attributes
		// query.setParameter("attribute", "%" + filter.toLowerCase() + "%");

		return query.getResultList();
	}

	public Usuario findUsuarioByLogin(String login, String senha) {
		StringBuffer ql = new StringBuffer();
		ql.append(" from Usuario u where u.login = :log and u.senha = :pass ");
		TypedQuery<Usuario> query = getEntityManager().createQuery(ql.toString(), Usuario.class);
		query.setParameter("log", login);
		query.setParameter("pass", senha);

		return query.getSingleResult();
	}
	
	public Usuario findUsuarioByPerfil(String login, String senha) {
		StringBuffer ql = new StringBuffer();
		ql.append(" from Usuario u where u.login = :log and u.senha = :pass and u.perfil = 1");
		TypedQuery<Usuario> query = getEntityManager().createQuery(ql.toString(), Usuario.class);
		query.setParameter("log", login);
		query.setParameter("pass", senha);

		return query.getSingleResult();
	}

	
}
