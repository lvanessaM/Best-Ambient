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
@Table(name="reuniones")
public class Reuniones {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	private String lugar_encuentro ;
	private String descripciom_actividad;
	private boolean estado;
		
	
	@ManyToOne
	@JoinColumn(name = "usuario_fk")
	private Usuario usuario;
	
	public Reuniones() {
		// TODO Auto-generated constructor stub
	}

	public Reuniones(int id, String lugar_encuentro, String descripciom_actividad, boolean estado, Usuario usuario) {
		super();
		this.id = id;
		this.lugar_encuentro = lugar_encuentro;
		this.descripciom_actividad = descripciom_actividad;
		this.estado = estado;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLugar_encuentro() {
		return lugar_encuentro;
	}

	public void setLugar_encuentro(String lugar_encuentro) {
		this.lugar_encuentro = lugar_encuentro;
	}

	public String getDescripciom_actividad() {
		return descripciom_actividad;
	}

	public void setDescripciom_actividad(String descripciom_actividad) {
		this.descripciom_actividad = descripciom_actividad;
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
