package com.project.MVP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class CompteEpargneController {
	@Autowired
	private CompteEpargneRepository ceRepository;
	
	@Autowired
	private ClientRepository userRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewCe (@RequestParam String numero
			, @RequestParam String intitule, @RequestParam double solde, @RequestParam double interet, @RequestParam Integer id) {
		CompteEpargne n = new CompteEpargne();
		if (userRepository.findById(id) != null) {
		n.setNumero(numero);
		n.setIntitule(intitule);
		n.setSolde(solde);
		n.setInteret(interet);
		System.out.println(n.toString());
		ceRepository.save(n);
		return "Ce Saved";
		}
		return "Erreur pas de client existant pour cet id, Echec création CE";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<CompteEpargne> getAllCe() {
		// This returns a JSON or XML with the users
		return ceRepository.findAll();
	}
}
