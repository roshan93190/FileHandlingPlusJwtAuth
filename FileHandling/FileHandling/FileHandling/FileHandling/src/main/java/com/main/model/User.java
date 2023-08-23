package com.main.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
public class User implements UserDetails {

	@Id
	private String id;
	private String email;
	private String password;

	@OneToMany
	private List<Image> images;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<SimpleGrantedAuthority> roles = this.roles.stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

		return roles;
	}

	@Override
	public String getUsername() {
 		return this.email;
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
 		return true;
	}

}