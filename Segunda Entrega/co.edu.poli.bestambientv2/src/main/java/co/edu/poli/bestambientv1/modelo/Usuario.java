package co.edu.poli.bestambientv1.modelo;

import java.util.List;

import javax.persistence.Entity;
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
	private  String id ;
	private String nombre;
	private String apellidos;
	private int edad;
	private String genero;
	private String correo_electronico;
	private String contraseña;
	private String celular;

	private boolean estado;
	
	@OneToOne
	@JoinColumn(name = "roles_id")
	private Roles roles;
	
	@OneToMany (mappedBy = "usuarios")
	@JsonIgnore
	private List<Publicaciones> publicaciones;
	
	public Usuario() {
		
	}

	public Usuario(String id, String nombre, String apellidos, int edad, String genero, String correo_electronico,
			String contraseña, String celular, boolean estado, Roles roles, List<Publicaciones> publicaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.genero = genero;
		this.correo_electronico = correo_electronico;
		this.contraseña = contraseña;
		this.celular = celular;
		this.estado = estado;
		this.roles = roles;
		this.publicaciones = publicaciones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
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

	

}
	