/**
 * 
 */
package model;

/**
 * @author manoel.carvalho
 *
 */
public class JavaBeans {
	
	private String idProd;
	private String nomeProd;
	private String valorProd;
	private String quantidade;
	private String total;
	
	
	public JavaBeans() {
		super();
		
	}
	
	
	public JavaBeans(String idProd, String nomeProd, String valorProd, String quantidade, String total) {
		super();
		this.idProd = idProd;
		this.nomeProd = nomeProd;
		this.valorProd = valorProd;
		this.quantidade = quantidade;
		this.total = total;
	}


	public String getIdProd() {
		return idProd;
	}
	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}
	public String getNomeProd() {
		return nomeProd;
	}
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	public String getValorProd() {
		return valorProd;
	}
	public void setValorProd(String valorProd) {
		this.valorProd = valorProd;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	

}
