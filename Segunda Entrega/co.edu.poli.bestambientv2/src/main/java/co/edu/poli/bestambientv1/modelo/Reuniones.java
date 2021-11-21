package co.edu.poli.bestambientv1.modelo;


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
	private boolean estado;
		
	
	@ManyToOne
	@JoinColumn(name = "usuario_fk")
	private Usuario usuario;
	
	public Reuniones() {
		// TODO Auto-generated constructor stub
	}

	public Reuniones(int id, String lugar_encuentro, boolean estado, Usuario usuario) {
		super();
		this.id = id;
		this.lugar_encuentro = lugar_encuentro;
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
