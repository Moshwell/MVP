package com.project.MVP;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/ce")
public class CompteEpargneController {
	@Autowired
	private CompteEpargneRepository ceRepository;
	
	@Autowired
	private ClientRepository userRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewCe (@RequestParam String numero
			, @RequestParam String intitule, @RequestParam double solde, @RequestParam double interet, @RequestParam Integer id) {
		CompteEpargne n = new CompteEpargne();
		if (userRepository.existsById(id) != false) {
		n.setNumero(numero);
		n.setIntitule(intitule);
		n.setSolde(solde);
		n.setInteret(interet);

		Optional<Client> client = userRepository.findById(id);
		if(client.isPresent()) {
			Client client_found = client.get();
			n.setClient(client_found);
		}
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
	
	@RequestMapping(path="/getinteret/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<Double> get(@PathVariable Integer id) {
		// This returns a JSON or XML with the users
		Optional<com.project.MVP.CompteEpargne> ce = ceRepository.findById(id);
		if (ceRepository.findById(id).isPresent()) {
		return ResponseEntity.ok(ce.get().calculInteret());
		} else {
		    System.out.println(" Erreur calcul intéret ");
		    return ResponseEntity.notFound().build();
		    }
		}
}
