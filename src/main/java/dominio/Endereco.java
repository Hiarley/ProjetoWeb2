package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id_Endereco", nullable = false)
	private long id;
	
	@Column(name = "rua", nullable = false)
	private String rua;
	
	@Column(name = "bairro", nullable = false)
	private String bairro;
	
	@Column(name = "numero", nullable = false)
	private int numero;
	
	@Column(name = "complemento", nullable = false)
	private String complemento;
	
	@Column(name = "cep", nullable = false)
	private String cep;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	
}
