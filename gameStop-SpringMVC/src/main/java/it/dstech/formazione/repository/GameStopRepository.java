package it.dstech.formazione.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.dstech.formazione.modelli.Videogioco;



public interface GameStopRepository extends CrudRepository<Videogioco, Long>{

	public List<Videogioco> findByPegiOrCategoriaOrTitolo(String pegi,String categoria,String titolo);
	public Videogioco findByTitolo(String titolo);
	public List<Videogioco> findByPegi(String pegi);
	public List<Videogioco> findByCategoria(String categoria);
	public List<Videogioco> findByPrezzo(double prezzo);
	public List<Videogioco> orderByPegiAsc(List<Videogioco> listaVide);
	public List<Videogioco> orderByTitoloAsc(List<Videogioco> listaVide);
	public List<Videogioco> orderByCategoriaAsc(List<Videogioco> listaVide);
	public List<Videogioco> orderByPrezzoAsc(List<Videogioco> listaVide);

}
