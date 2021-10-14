package co.edu.poli.bestambientv1.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="roles")
public class Roles {
	
	@Id
	private String id;
	private String desc_rol;
	private boolean estado;
	
	
	@OneToOne(mappedBy = "roles")
	@JsonIgnore
	private Usuario usuario;
	
	public Roles() {
		
	}

	public Roles(String id, String desc_rol, boolean estado, Usuario usuario) {
		super();
		this.id = id;
		this.desc_rol = desc_rol;
		this.estado = estado;
		this.usuario = usuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc_rol() {
		return desc_rol;
	}

	public void setDesc_rol(String desc_rol) {
		this.desc_rol = desc_rol;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}  
	
	


}
