package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unitins.tp1.aula2.model.Usuario;

public class TesteJPA {

	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Farmacia");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("Carlos Henrique");
		usuario.setLogin("carlos");
		usuario.setSenha("123");
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		System.out.println("Fim");
	}
}