package co.edu.poli.bestambientv1.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Publicaciones")
public class Publicaciones {
 
	
	private String Descripcion;
	private Boolean estado;
	@Id
	private String code;


	
	 @ManyToOne
	    @JoinColumn(name = "Usuario_id")
	    	private Usuario usuarios;   
   
	public Publicaciones() {
		// TODO Auto-generated constructor stub
	}

	public Publicaciones(String descripcion, Boolean estado, String code, Usuario usuarios) {
		super();
		Descripcion = descripcion;
		this.estado = estado;
		this.code = code;
		this.usuarios = usuarios;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	
	

}
