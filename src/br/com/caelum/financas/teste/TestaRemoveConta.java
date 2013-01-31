package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaRemoveConta {

	public static void main(String[] args) {
		
		long inicio = System.currentTimeMillis();
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		ContaDAO dao = new ContaDAO(em);
		
		em.getTransaction().begin();
		
		Conta conta = dao.busca(1);
		dao.remove(conta);
		
		em.getTransaction().commit();
		
		System.out.println("Conta removida com sucesso!");
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Executado em: " + (fim-inicio));
		
		em.close();
		
		
	}
	
}
