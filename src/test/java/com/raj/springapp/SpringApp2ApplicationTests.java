package com.raj.springapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.raj.springapp.dao.UserRespository;
import com.raj.springapp.model.CreditCard;
import com.raj.springapp.model.User;
import com.raj.springapp.service.CreditCardService;
import com.raj.springapp.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringApp2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringApp2ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int localServerPort;

	private String getProjectRootURL() {
		return "http://localhost:" + localServerPort;
	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CreditCardService creditCardService;
	
	@MockBean
	private UserRespository userRepository;

	@Test
	public void saveUserTest()
	{
		User user=new User("raj","10 Barrymore Road","raj@gmail.com");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.saveUser(user));
	}
	
	@Test
	public void testGetAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getProjectRootURL() + "/user/get",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}
	
	
	@Test
	public void getAllUserTestAlternative()
	{
		when(userRepository.findAll()).thenReturn(Stream.of(new User("raj","10 Barrymore Road","raj@gmail.com"),new User("raj","10 Barrymore Road","raj@gmail.com")).collect(Collectors.toList()));
		assertEquals(2,userService.getUserList().size());
	}
	
	@Test
	public void creditCardTest()
	{
		CreditCard creditCard=new CreditCard("123456789123123",new Date(),123, "10 Barrymore Road, Scarborough");
		assertEquals(creditCard, creditCardService.payByCreditCard(creditCard));
	}
	
	@Test
	public void deleteUserTest()
	{
		User user=new User("raj","10 Barrymore Road","raj@gmail.com");
		userService.removeUser(user);
		verify(userRepository,times(1)).delete(user);
	}
		
}
