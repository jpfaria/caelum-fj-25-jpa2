package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaListagemConta {

	public static void main(String[] args) {
		
		long inicio = System.currentTimeMillis();
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		ContaDAO dao = new ContaDAO(em);
		
		em.getTransaction().begin();
		
		List<Conta> lista = dao.lista();
		
		for (Conta conta : lista ) {
			
			System.out.println(conta.getNumero() + " : " + conta.getTitular());
			
		}
		
		em.getTransaction().commit();
		
		em.close();
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Executado em: " + (fim-inicio));
		System.out.println(1.92 - 1.02);
		
	}

}
