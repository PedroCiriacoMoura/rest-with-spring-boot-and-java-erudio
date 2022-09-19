package moura.pedro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import moura.pedro.model.Person;
import moura.pedro.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	@RequestMapping(value = "/list",
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return services.findAll();
		
	}
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById (@PathVariable (value = "id") Long id) throws Exception {
	
		return services.findById(id);
		
	}
	
	@RequestMapping(value = "/add",
			method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person create (@RequestBody Person person) {
		
		return services.create(person);
		
	}
	
	@RequestMapping(value = "/update",
			method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person update (@RequestBody Person person) {
		
		return services.update(person);
		
	}
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.DELETE)
	public void delete (@PathVariable (value = "id") Long id) throws Exception {
	
		services.delete(id);
	}
}
	
