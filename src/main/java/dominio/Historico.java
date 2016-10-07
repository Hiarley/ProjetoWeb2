package dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author hiarl
 */
@Entity
public class Historico {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
    private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", nullable = false)
	private long idPedido;
	
	@Column(name = "data", nullable = false)
    private Date dataModificaco;
	
	@Column(name = "descricao", nullable = false)
    private String descricao;
	
	@OneToOne
	@JoinColumn(name = "id_usuario", nullable = false)
    private long idUsuario;

    public Historico() {
    }

    public Historico(long idProduto, long idHistorico, Date dataModificaco, String descricao, long idUsuario) {
        this.idPedido = idProduto;
        this.dataModificaco = dataModificaco;
        this.descricao = descricao;
        this.idUsuario = idUsuario;
    }

    public long getIdPedido() {
        return idPedido;
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