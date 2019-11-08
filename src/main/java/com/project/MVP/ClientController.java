package com.project.MVP;

import java.util.Optional;

import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping(path="/client")
public class ClientController {

		@Autowired
		private ClientRepository userRepository;
		
		@PostMapping(path="/add") // Map ONLY POST Requests
		public @ResponseBody String addNewUser (@RequestParam String nom
				, @RequestParam String prenom) {
			Client n = new Client(nom, prenom);
			System.out.println(n.toString());
			userRepository.save(n);
			return "Client Saved";
		}

		@GetMapping(path="/all")
		public @ResponseBody Iterable<Client> getAllUsers() {
			// This returns a JSON or XML with the users
			return userRepository.findAll();
		}
		
		@RequestMapping(path="/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
		public ResponseEntity<Client> get(@PathVariable Integer id) {
			// This returns a JSON or XML with the users
			Optional<com.project.MVP.Client> client = userRepository.findById(id);
			if (userRepository.findById(id).isPresent()) {
			return ResponseEntity.ok(client.get());
			} else {
			    System.out.println(" Erreur lecture client ");
			    return null;
			    }
			}
		
		@RequestMapping(path="/del/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
		public @ResponseBody String deleteOneUser(@PathVariable Integer id) {
			String result = userRepository.findById(id).get().toString();
			userRepository.deleteById(id);
			System.out.println(" Suppression client " + id);
			return result;
		}
}
