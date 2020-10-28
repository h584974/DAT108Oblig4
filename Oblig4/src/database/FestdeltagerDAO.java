package database;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FestdeltagerDAO {
	
	@PersistenceContext(name = "festPU")
	EntityManager em;
	
	public void lagreFestdeltager(Festdeltager nyFestdeltager) {
		em.persist(nyFestdeltager);
	}
	
	public List<Festdeltager> hentAlleFestdeltagere() {
		return em.createQuery("SELECT f FROM Festdeltager f",Festdeltager.class).getResultList();
	}
	
	public Festdeltager hentFestdeltager(Integer mobil) {
		return em.find(Festdeltager.class, mobil);
	}

}
