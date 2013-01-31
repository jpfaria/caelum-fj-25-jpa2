package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaPesquisaConta {

	public static void main(String[] args) {
		
		long inicio = System.currentTimeMillis();
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		ContaDAO dao = new ContaDAO(em);
		
		em.getTransaction().begin();
		
		Conta encontrado = dao.busca(1);
		
		em.getTransaction().commit();
		
		System.out.println(encontrado.getTitular());
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Executado em: " + (fim-inicio));

		em.close();
		
		
	}

}
