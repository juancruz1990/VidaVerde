import java.sql.*;
import java.sql.Connection;

public class GenerarConeccion {
	/** Parametros de conexion */
	static String bd = "biogreen";
	static String login = "root";
	static String password = "1234";
	static String url = "jdbc:mysql://localhost/" + bd;

	Connection coneccion = null;

	/** Constructor de DbConnection */
	public GenerarConeccion() {
		try {
			// obtenemos el driver de para mysql
			Class.forName("com.mysql.jdbc.Driver");
			// obtenemos la conexión
			coneccion = DriverManager.getConnection(url, login, password);

			if (coneccion != null) {
				System.out.println("Conexión a base de datos " + bd + " OK\n");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** Permite retornar la conexión */
	public Connection getConeccion() {
		return coneccion;
	}

	public void desconectar() {
		coneccion = null;
	}
}


