package com.project.MVP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/client")
public class ClientController {

		@Autowired
		private ClientRepository userRepository;
		
		@PostMapping(path="/add") // Map ONLY POST Requests
		public @ResponseBody String addNewUser (@RequestParam String nom
				, @RequestParam String prenom) {
			Client n = new Client();
			n.setNom(nom);
			n.setPrenom(prenom);
			System.out.println(n.toString());
			userRepository.save(n);
			return "Client Saved";
		}

		@GetMapping(path="/all")
		public @ResponseBody Iterable<Client> getAllUsers() {
			// This returns a JSON or XML with the users
			return userRepository.findAll();
		}
}
