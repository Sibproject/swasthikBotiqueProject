package com.swasthik.swasthikboutique;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.swasthik.swasthikboutique.model.UserDetails;
import com.swasthik.swasthikboutique.repository.UserRepository;
import com.swasthik.swasthikboutique.service.UserService;

@SpringBootTest
class SwasthikboutiqueUserServicesTests {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	/*
	 * private Long id; private String firstName; private String lastName; private
	 * String fullName; private String phoneNumber; private String address; private
	 * String emailAddress;
	 */
	@Test
	void testSaveuserToServer() {
		
		UserDetails userDetails = userInformation();
		
		/*
		 * userDetails.setFirstName("sib"); userDetails.setLastName("wg");
		 * userDetails.setFullName("sib wg");
		 * userDetails.setEmailAddress("sib@gmail.com"); userDetails.setId(1L);
		 * userDetails.setPhoneNumber("8756789876");
		 * userDetails.setAddress("Lyndurst ave, TX");
		 */
		
		when(userRepository.save(userDetails)).thenReturn(userDetails);
		
		UserDetails savedUserDetails = userService.saveUser(userDetails);
		
		assertEquals(userDetails.getAddress(), savedUserDetails.getAddress());
		assertEquals(userDetails.getFirstName(), savedUserDetails.getFirstName());
		assertEquals(userDetails.getLastName(), savedUserDetails.getLastName());
		assertEquals(userDetails.getPhoneNumber(), savedUserDetails.getPhoneNumber());
		assertEquals(userDetails.getId(), savedUserDetails.getId());
		assertEquals(userDetails.getEmailAddress(), savedUserDetails.getEmailAddress());
		
		verify(userRepository, times(1)).save(userDetails);

	}
	
	@Test
	void getAllUsers() {
		UserDetails userDetails = userInformation();
		List<UserDetails> users = new ArrayList<>();
		users.add(userDetails);
		
		when(userRepository.findAll()).thenReturn(users);
		
		List<UserDetails> result = userService.getAllUsers();
		
		assertEquals(1, result.size());
		assertTrue(result.contains(userDetails));
		verify(userRepository, times(1)).findAll();
		
		
		
	}
	
	public static UserDetails userInformation() {
		UserDetails userDetails = new UserDetails();
		
		userDetails.setFirstName("sib");
		userDetails.setLastName("wg");
		userDetails.setFullName("sib wg");
		userDetails.setEmailAddress("sib@gmail.com");
		userDetails.setId(1L);
		userDetails.setPhoneNumber("8756789876");
		userDetails.setAddress("Lyndurst ave, TX");
		
		return userDetails;
	}
	
	
}
