/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author manoel.carvalho
 *
 */
public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/db_carrinhocompras?useTimeZone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "123456";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insertContact(JavaBeans product) {
		String create = "insert into produtos (nomeProd,valorProd, quantidade, total) values (?,?,?,?)";
		try {
			Connection con = conectar();
			// preparar query execução db
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, product.getNomeProd());
			pst.setDouble(2, Double.parseDouble(product.getValorProd()));
			pst.setInt(3, Integer.parseInt(product.getQuantidade()));
			pst.setDouble(4, Double.parseDouble(product.getTotal()));

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<JavaBeans> listProducts() {
		ArrayList<JavaBeans> products = new ArrayList<>();
		String read = "select * from produtos order by nomeProd";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idProd = rs.getString(1);
				String nomeProd = rs.getString(2);
				String valorProd = rs.getString(3);
				String quantidade = rs.getString(4);
				String total = rs.getString(5);

				products.add(new JavaBeans(idProd, nomeProd, valorProd, quantidade, total));
			}
			con.close();
			return products;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// update
	// selecionar o produto
	public void selectProduct(JavaBeans product) {
		String read2 = "select * from produtos where idProd = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, product.getIdProd());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				product.setIdProd(rs.getString(1));
				product.setNomeProd(rs.getString(2));
				product.setValorProd(rs.getString(3));
				product.setQuantidade(rs.getString(4));
				product.setTotal(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// editar o produto
	public void updateProduct(JavaBeans product) {
		String create = "update produtos set nomeProd=?,valorProd=?,quantidade=?,total=? where idProd=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, product.getNomeProd());
			pst.setDouble(2, Double.parseDouble(product.getValorProd()));
			pst.setInt(3, Integer.parseInt(product.getQuantidade()));
			pst.setDouble(4, Double.parseDouble(product.getTotal()));
			pst.setString(5, product.getIdProd());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// crud delete

	public void deleteProduct(JavaBeans product) {
		String delete = "delete from produtos where idProd=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, product.getIdProd());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
