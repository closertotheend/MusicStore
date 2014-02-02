package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import model.Artist;
import service.abstractions.AbstractFacade;

/**
 * @author ilja
 * 
 */
@Stateless
@LocalBean
@Named
public class ArtistEJB extends AbstractFacade<Artist> {

	public ArtistEJB() {
		super(Artist.class);
	}

	/**
	 * @param c
	 * @return finds List of artists, whose name start with c
	 */
	public List<Artist> findByFirstLetter(char c) {
		TypedQuery<Artist> query = getEm().createQuery(
				"SELECT a FROM Artist a where LOWER(a.name) LIKE :pattern",
				Artist.class);
		query.setParameter("pattern", c + "%");
		return query.getResultList();

	}

}
