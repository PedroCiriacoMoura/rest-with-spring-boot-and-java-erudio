package moura.pedro.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import moura.pedro.data.vo.v1.PersonVO;
import moura.pedro.exceptions.RequiredObjectIsNullException;
import moura.pedro.model.Person;
import moura.pedro.repositories.PersonRepository;
import moura.pedro.services.PersonServices;
import moura.pedro.unittests.mapper.MockPerson;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {

	MockPerson input;
	
	@InjectMocks
	private PersonServices service;
	
	@Mock 
	PersonRepository repository;
	
	@BeforeEach
	void setUpMocks() throws Exception {
		input = new MockPerson();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindById() {
		Person person = input.mockEntity(1);
		person.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(person));
		
		var result = service.findById(1L);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}
	
	@Test
	void testFindAll() {
		List<Person> list = input.mockEntityList();
		
		when(repository.findAll()).thenReturn(list);
		
		var people = service.findAll();
		assertNotNull(people);
		assertEquals(14, people.size());
		
		var personOne = people.get(1);
		assertNotNull(personOne);
		assertNotNull(personOne.getKey());
		assertNotNull(personOne.getLinks());
		assertTrue(personOne.toString().contains("links: [</person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", personOne.getAddress());
		assertEquals("First Name Test1", personOne.getFirstName());
		assertEquals("Last Name Test1", personOne.getLastName());
		assertEquals("Female", personOne.getGender());
		
		var personFour = people.get(4);
		assertNotNull(personFour);
		assertNotNull(personFour.getKey());
		assertNotNull(personFour.getLinks());
		assertTrue(personFour.toString().contains("links: [</person/v1/4>;rel=\"self\"]"));
		assertEquals("Addres Test4", personFour.getAddress());
		assertEquals("First Name Test4", personFour.getFirstName());
		assertEquals("Last Name Test4", personFour.getLastName());
		assertEquals("Male", personFour.getGender());
		
		var personTen = people.get(10);
		assertNotNull(personTen);
		assertNotNull(personTen.getKey());
		assertNotNull(personTen.getLinks());
		assertTrue(personTen.toString().contains("links: [</person/v1/10>;rel=\"self\"]"));
		assertEquals("Addres Test10", personTen.getAddress());
		assertEquals("First Name Test10", personTen.getFirstName());
		assertEquals("Last Name Test10", personTen.getLastName());
		assertEquals("Male", personTen.getGender());
		
		var personThirteen = people.get(13);
		assertNotNull(personThirteen);
		assertNotNull(personThirteen.getKey());
		assertNotNull(personThirteen.getLinks());
		assertTrue(personThirteen.toString().contains("links: [</person/v1/13>;rel=\"self\"]"));
		assertEquals("Addres Test13", personThirteen.getAddress());
		assertEquals("First Name Test13", personThirteen.getFirstName());
		assertEquals("Last Name Test13", personThirteen.getLastName());
		assertEquals("Female", personThirteen.getGender());
	}

	@Test
	void testCreate() {
		Person entity = input.mockEntity(1);
		
		Person persisted = entity;
		entity.setId(1L);
		
		PersonVO vo = input.mockVO(1);
		vo.setKey(1L);
		
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.create(vo);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}
	
	@Test
	void testCreateWithNullPerson() {
		
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.create(null);
		});
		
		String expectedMessage = "It is not allowed to persist a null object!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testUpdate() {
		Person entity = input.mockEntity(1);
		entity.setId(1L);
		
		Person persisted = entity;
		persisted.setId(1L);
		
		PersonVO vo = input.mockVO(1);
		vo.setKey(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(entity));
		when(repository.save(entity)).thenReturn(persisted);
		
		var result = service.update(vo);
		assertNotNull(result);
		assertNotNull(result.getKey());
		assertNotNull(result.getLinks());
		assertTrue(result.toString().contains("links: [</person/v1/1>;rel=\"self\"]"));
		assertEquals("Addres Test1", result.getAddress());
		assertEquals("First Name Test1", result.getFirstName());
		assertEquals("Last Name Test1", result.getLastName());
		assertEquals("Female", result.getGender());
	}

	
	@Test
	void testUpdateWithNullPerson() {
		
		Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
			service.update(null);
		});
		
		String expectedMessage = "It is not allowed to persist a null object!";
		String actualMessage = exception.getMessage();
		
		assertTrue(actualMessage.contains(expectedMessage));
	}

	
	@Test
	void testDelete() {
		Person person = input.mockEntity(1);
		person.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(person));
		
		service.delete(1L);
	}

}
