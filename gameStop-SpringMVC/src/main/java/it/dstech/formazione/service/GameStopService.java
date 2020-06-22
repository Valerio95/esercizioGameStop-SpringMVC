package it.dstech.formazione.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.formazione.modelli.Videogioco;
import it.dstech.formazione.repository.GameStopRepository;

@Service
@Transactional
public class GameStopService {
	
	@Autowired GameStopRepository repo;

	public void save(Videogioco videogioco) {
		repo.save(videogioco);
		
	}
	
	public List<Videogioco> listAll() {
		return (List<Videogioco>) repo.findAll();
	}
	
	public Videogioco get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	public List<Videogioco> getByPegiOrCategoriaOrTitolo(String pegi,String categoria,String titolo) {
		return (List<Videogioco>) repo.findByPegiOrCategoriaOrTitolo(pegi, categoria, titolo);
	}
	
	/*
	 * public List<Videogioco> getByPegi(String pegi) { return (List<Videogioco>)
	 * repo.findByPegi(pegi); }
	 * 
	 * public List<Videogioco> getByPrezzo(double prezzo) { return
	 * (List<Videogioco>) repo.findByPrezzo(prezzo); }
	 * 
	 * public List<Videogioco> getByCategoria(String categoria) { return
	 * (List<Videogioco>) repo.findByCategoria(categoria); }
	 * 
	 * public Videogioco getByTitolo(String titolo) { return
	 * repo.findByTitolo(titolo); }
	 */
	
	public List<Videogioco> ordByTitolo(List<Videogioco> listaVideo) {
		return (List<Videogioco>) repo.orderByTitoloAsc(listaVideo);
	}
	public List<Videogioco> ordByCategoria(List<Videogioco> listaVideo) {
		return (List<Videogioco>) repo.orderByCategoriaAsc(listaVideo);
	}public List<Videogioco> ordByPrezzo(List<Videogioco> listaVideo) {
		return (List<Videogioco>) repo.orderByPrezzoAsc(listaVideo);
	}public List<Videogioco> ordByPegi(List<Videogioco> listaVideo) {
		return (List<Videogioco>) repo.orderByPegiAsc(listaVideo);
	}
}
