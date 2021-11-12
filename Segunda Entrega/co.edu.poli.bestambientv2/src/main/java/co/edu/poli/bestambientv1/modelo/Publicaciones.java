package co.edu.poli.bestambientv1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Publicaciones")
public class Publicaciones {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Descripcion;
	private Boolean estado;


	
	 @ManyToOne
	    @JoinColumn(name = "Usuario_id")
	    	private Usuario usuarios;   
   
	public Publicaciones() {
		// TODO Auto-generated constructor stub
	}

	public Publicaciones(String descripcion, Boolean estado, long id, Usuario usuarios) {
		super();
		Descripcion = descripcion;
		this.estado = estado;
		this.id = id;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	
	

}
