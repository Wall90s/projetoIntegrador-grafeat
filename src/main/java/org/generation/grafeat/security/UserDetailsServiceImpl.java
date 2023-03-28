package org.generation.grafeat.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import org.generation.grafeat.model.Vendedor;
import org.generation.grafeat.repository.VendedorRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private VendedorRepository vendedorRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Vendedor> vendedor = vendedorRepository.findByUsuario(userName);

		if (vendedor.isPresent())
			return new UserDetailsImpl(vendedor.get());
		else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN);
	}
}
