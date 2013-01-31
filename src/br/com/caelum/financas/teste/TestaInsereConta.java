package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) {
		
		long inicio = System.currentTimeMillis();
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("José Roberto");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-7");
		conta.setAgencia("0999");
		
		ContaDAO dao = new ContaDAO(em);
		
		em.getTransaction().begin();
		
		dao.adiciona(conta);
		
		em.getTransaction().commit();
		
		System.out.println("Conta gravada com sucesso!");
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Executado em: " + (fim-inicio));
		
		em.close();
		
		
	}
	
}
