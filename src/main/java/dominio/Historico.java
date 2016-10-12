package dominio;

import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 *
 * @author hiarl
 */
@Entity
public class Historico {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_Historico", unique = true, nullable = false)
    private long id;
	
	@JoinColumn(name = "id_pedido", nullable = false)
	private long id_Pedido;
	
	@Column(name = "data", nullable = false)
    private Date dataModificaco;
	
	@Column(name = "descricao", nullable = false)
    private String descricao;
	
	
	@JoinColumn(name = "id_usuario", nullable = false)
    private long idUsuario;

    public Historico() {
    }

    public Historico(long idProduto, long idHistorico, Date dataModificaco, String descricao, long idUsuario) {
        this.id_Pedido = idProduto;
        this.dataModificaco = dataModificaco;
        this.descricao = descricao;
        this.idUsuario = idUsuario;
    }

    
    
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdPedido() {
        return id_Pedido;
    }

    
    /**
     * @return the idHistorico
     */
    public long getIdHistorico() {
        return id;
    }


    /**
     * @return the dataModificaco
     */
    public Date getDataModificaco() {
        return dataModificaco;
    }

    /**
     * @param dataModificaco the dataModificaco to set
     */
    public void setDataModificaco(Date dataModificaco){
        this.dataModificaco = dataModificaco;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    /**
     * @return the usuarioDemandado
     */
    public long getUsuario() {
        return idUsuario;
    }


    
}