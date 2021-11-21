package co.edu.poli.bestambientv1.services;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import co.edu.poli.bestambientv1.modelo.Usuario;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = -6855979919718350058L;

	private String nombre;

	private String password;

	private boolean active;

	private List<GrantedAuthority> authorities;

	public UserDetailsImpl(Usuario user) {
		this.nombre = user.getNombre();
		this.password = user.getContrasena();
		this.active = user.isActive();
		this.authorities = Arrays.stream(user.getDomainRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	public UserDetailsImpl() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return nombre;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

}
