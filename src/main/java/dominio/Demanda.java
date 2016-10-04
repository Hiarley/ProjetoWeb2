package dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public abstract class Demanda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
    private long id;
    private String nome;
    private double preco;
    private String descricao;
    private Date prazo;

    public Demanda() {
    }

    public Demanda(String nome, double preco, String descricao, Date date) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        date.setMonth(date.getMonth() + 2);
        this.prazo = date;
    }

    /**
     * @return the idDemanda
     */
    public long getIdDemanda() {
        return id;
    }

    /**
     * @param idDemanda the idDemanda to set
     */
    public void setIdDemanda(long idDemanda){

        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {

        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco){
        this.preco = preco;
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

    
    
    public abstract boolean validar();

    /**
     * @return the prazo
     */
    public Date getPrazo() {
        return prazo;
    }

    /**
     * @param prazo the prazo to set
     */
    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }
}