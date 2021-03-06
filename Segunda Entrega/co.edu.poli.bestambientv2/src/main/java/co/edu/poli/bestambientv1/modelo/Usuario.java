package co.edu.poli.bestambientv1.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String apellidos;
	private int edad;
	private String genero;
	private String correo_electronico;
	private String contrasena;
	private String celular;
	private boolean active;
	private boolean estado;
	private String domainRoles;
	
	@OneToOne
	@JoinColumn(name = "roles_id")
	private Roles roles;
	
	@OneToMany (mappedBy = "usuarios")
	@JsonIgnore
	private List<Publicaciones> publicaciones;

	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	private List<Reuniones> reuniones;
	
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nombre, String apellidos, int edad, String genero, String correo_electronico,
			String contrasena, String celular, boolean active, boolean estado, String domainRoles, Roles roles,
			List<Publicaciones> publicaciones, List<Reuniones> reuniones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.genero = genero;
		this.correo_electronico = correo_electronico;
		this.contrasena = contrasena;
		this.celular = celular;
		this.active = active;
		this.estado = estado;
		this.domainRoles = domainRoles;
		this.roles = roles;
		this.publicaciones = publicaciones;
		this.reuniones = reuniones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getDomainRoles() {
		return domainRoles;
	}

	public void setDomainRoles(String domainRoles) {
		this.domainRoles = domainRoles;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public List<Publicaciones> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicaciones> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public List<Reuniones> getReuniones() {
		return reuniones;
	}

	public void setReuniones(List<Reuniones> reuniones) {
		this.reuniones = reuniones;
	}

	
	

}
	