package com.bezkoder.springjwt.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bezkoder.springjwt.models.*;
import com.bezkoder.springjwt.models.timesheet;
import com.bezkoder.springjwt.repository.TimesheetRepository;
import com.bezkoder.springjwt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Autowired 
	TimesheetRepository timesheetRepository;
	                   
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}


         public User ajoutUser(User user, Long idTimesheet){
       timesheet Timesheet = timesheetRepository.findById(idTimesheet).get();
       List<timesheet> list=user.getTimesheet();
       list.add(Timesheet);
       user.setTimesheet(list);
       
            return userRepository.save(user);
}
         

}
