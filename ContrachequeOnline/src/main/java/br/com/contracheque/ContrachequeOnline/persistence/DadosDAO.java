
package br.com.contracheque.ContrachequeOnline.persistence;

import java.util.List;
import javax.persistence.TypedQuery;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.com.contracheque.ContrachequeOnline.entity.Dados;

@PersistenceController
public class DadosDAO extends JPACrud<Dados, Long> {

	private static final long serialVersionUID = 1L;
	
	
	public List<Dados> find(String filter) {
		StringBuffer ql = new StringBuffer();
		ql.append("  from Dados p ");
// use where and or operator as filter		
//		ql.append(" where lower(p.attribute) like :attribute ");
//		ql.append("    or lower(p.anotherAttribute) like :anotherAttribute ");
// list of attributes

	//		folhaCompetencia 

	//		cpfFuncionario 

	//		nomeCompleto 

	//		tipoCodigo 

	//		descricao 

	//		salario 

	//		dtNascimento 

	//		cargo 

	//		folhaValor 

		TypedQuery<Dados> query = getEntityManager().createQuery(ql.toString(), Dados.class);
// use setParameter to fill attributes
//		query.setParameter("attribute", "%" + filter.toLowerCase() + "%");

		return query.getResultList();
	}
}
