package it.dstech.formazione.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.dstech.formazione.modelli.Videogioco;
import it.dstech.formazione.service.GameStopService;

@Controller
public class GameStopController {

	@Autowired
	private GameStopService gameStopService;
	
	
	@RequestMapping("/")
	public String home(Map<String, Object> model ) {
		Videogioco videogioco = new Videogioco();
		List<Videogioco> listaVideogiochi = gameStopService.listAll();
		model.put("listaVideogiochi", listaVideogiochi);
		model.put("videogioco", videogioco);
		
	return "homepage";
	}
	
	
	
	@RequestMapping(value = "/creaVideogioco", method = RequestMethod.POST)
	public String creaVideogioco(@ModelAttribute("videogioco") Videogioco videogioco) {
		gameStopService.save(videogioco);
		return "redirect:/";
	}
	
	
	@RequestMapping("/modificaVideogioco")
	public ModelAndView editVideogioco(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("modificaVideogioco");
		Videogioco videogioco = gameStopService.get(id);
		mav.addObject("videogioco", videogioco);
		
		return mav;
	}
	
	@RequestMapping("/eliminaVideogioco")
	public String deleteVideogioco(@RequestParam long id) {
		gameStopService.delete(id);
		return "redirect:/";		
	}
	
	
	
	
	
	@RequestMapping("/ricercaVideogioco")
	public String ricercaVideogioco(@RequestParam("ordinamento") String ordinamento,@RequestParam("titolo") String titolo,@RequestParam("categoria") String categoria,@RequestParam("pegi") String pegi, Map<String, Object> model ) {
		List<Videogioco> listaVideogiochi = gameStopService.getByPegiOrCategoriaOrTitolo(pegi, categoria, titolo);
		Videogioco videogioco = new Videogioco();
		
		model.put("listaVideogiochi", listaVideogiochi);
		model.put("videogioco", videogioco);

		return "homepage";		
	
}
	
	@RequestMapping("/ordinaLista")
	public String ordinaLista(@RequestParam("ordinamento") String ordinamento,@ModelAttribute("listaVideogiochi") List<Videogioco> listaVideogioco, Map<String, Object> model ) {
		Videogioco videogioco = new Videogioco();
		if ("OrdAtk".equalsIgnoreCase(ordinamento)) {
			listaVideogioco=gameStopService.ordByCategoria(listaVideogioco);
		}else if ("OrdCateg".equalsIgnoreCase(ordinamento)) {
			listaVideogioco=gameStopService.ordByPegi(listaVideogioco);
		}else if ("OrdPrezzo".equalsIgnoreCase(ordinamento)) {
			listaVideogioco=gameStopService.ordByPrezzo(listaVideogioco);
		}else if ("OrdTitolo".equalsIgnoreCase(ordinamento)) {
			listaVideogioco=gameStopService.ordByTitolo(listaVideogioco);
		}
		model.put("listaVideogioco", listaVideogioco);
		model.put("videogioco", videogioco);

		return "redirect:/scegliAllenatore";		
	}

	
	}
