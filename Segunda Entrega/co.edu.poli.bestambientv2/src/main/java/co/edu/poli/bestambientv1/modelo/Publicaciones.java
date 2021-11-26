package co.edu.poli.bestambientv1.modelo;

import java.util.Date;

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
	private String Titulo;
	private String Descripcion;
	private Boolean estado;
	private Date fecha;


	
	 @ManyToOne
	    @JoinColumn(name = "Usuario_id")
	    	private Usuario usuarios;   
   
	public Publicaciones() {
		// TODO Auto-generated constructor stub
	}

	

	public Publicaciones(Long id, String titulo, String descripcion, Boolean estado, Date fecha, Usuario usuarios) {
		super();
		this.id = id;
		Titulo = titulo;
		Descripcion = descripcion;
		this.estado = estado;
		this.fecha = fecha;
		this.usuarios = usuarios;
	}



	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	

}
