package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

import javax.persistence.EntityManager;

public class TestaInsereMovimentacao {

	public static void main(String[] args) {
		
		long inicio = System.currentTimeMillis();
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		ContaDAO contaDAO = new ContaDAO(em);
		
		MovimentacaoDAO movDAO = new MovimentacaoDAO(em);
		
		em.getTransaction().begin();
		
		Conta conta = contaDAO.busca(3);
		
		Movimentacao mov = new Movimentacao();
		mov.setValor(new BigDecimal(10));
		mov.setConta(conta);
		
		movDAO.adiciona(mov);
		
		em.getTransaction().commit();
		
		System.out.println("Movimentacao gravada com sucesso!");
		
		long fim = System.currentTimeMillis();
		
		System.out.println("Executado em: " + (fim-inicio));
		
		em.close();
		
		
	}
	
}
