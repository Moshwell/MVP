package com.project.MVP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/cc")
public class CompteCourantController {
	@Autowired
	private CompteCourantRepository ccRepository;
	
	@Autowired
	private ClientRepository userRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewCc (@RequestParam String numero
			, @RequestParam String intitule, @RequestParam double solde, @RequestParam double decouvert, @RequestParam Integer id) {
		CompteCourant n = new CompteCourant();
		if (userRepository.findById(id) != null) {
		n.setNumero(numero);
		n.setIntitule(intitule);
		n.setSolde(solde);
		n.setDecouvert(decouvert);
		System.out.println(n.toString());
		ccRepository.save(n);
		return "Cc Saved";
		}
		return "Erreur pas de client existant pour cet id, Echec création CE";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<CompteCourant> getAllCc() {
		// This returns a JSON or XML with the users
		return ccRepository.findAll();
	}
}
