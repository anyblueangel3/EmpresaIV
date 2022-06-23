package empresaiv;

import java.sql.*;

/**
 * @author Ronaldo R. Godoi, contibuição de Staroski
 */
public final class BD {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBNAME = "empresa";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
    private static final String LOGIN = "root";
    private static final String SENHA = "04latosensu10";
    public final Connection connection;
    
    /**
     * Única instância desta classe
     */
    private static BD instance;
    
    /**
     * Obtém a única instância desta classe
     */
    public static synchronized BD getInstance() {
        if (instance == null) {
            System.out.println("Criando objeto da classe BD");
            instance = new BD();
        }
        System.out.println("Retornando objeto existente da classe BD");
        return instance;
    }
    
    
    /**
     * Construtor privado
     */
    private BD() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, SENHA);
            System.out.println("Conectou! ");
        } catch (Throwable t) {
            throw new RuntimeException("Erro ao inicializar BD", t);
        }
    }

    /**
     * Fecha a conexão com o banco
     */
    public void close() {
        try {
            connection.close();
            instance = null;
            System.out.println("Desconectou...");
        } catch(Throwable t) {
            throw new RuntimeException("Erro ao fechar BD", t);
        }
    }
}