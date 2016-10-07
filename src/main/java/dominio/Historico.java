package dominio;

import java.util.Date;

import javax.persistence.Entity;

/**
 *
 * @author hiarl
 */
@Entity
public class Historico {
	
    private long idDemanda;
    private long idHistorico;
    private Date dataModificaco;
    private String descricao;
    private Usuario usuarioDemandado;

    public Historico() {
    }

    public Historico(long idDemanda, long idHistorico, Date dataModificaco, String descricao, Usuario usuarioSolicitante) {
        this.idDemanda = idDemanda;
        this.idHistorico = idHistorico;
        this.dataModificaco = dataModificaco;
        this.descricao = descricao;
        this.usuarioDemandado = usuarioSolicitante;
    }

    public long getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(long idDemanda){
        this.idDemanda = idDemanda;
    }
    
    /**
     * @return the idHistorico
     */
    public long getIdHistorico() {
        return idHistorico;
    }

    /**
     * @param idHistorico the idHistorico to set
     */
    public void setIdHistorico(long idHistorico){
        this.idHistorico = idHistorico;
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
    public Usuario getUsuarioSolicitante() {
        return usuarioDemandado;
    }

    /**
     * @param usuarioSolicitante the usuarioDemandado to set
     */
    public void setUsuarioSolicitante(Usuario usuarioSolicitante){
        this.usuarioDemandado = usuarioSolicitante;
    }
    
}