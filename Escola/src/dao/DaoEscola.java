package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Escola;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoEscola {
    public static boolean inserir(Escola objeto) {
        String sql = "INSERT INTO Escola (nome, sigla, endereco, nr_alunos, area) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getSigla());
            ps.setString(3, objeto.getEndereco());
            ps.setInt(4, objeto.getNr_alunos());
            ps.setDouble(5, objeto.getArea());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static void main(String[] args) {
        Escola objeto = new Escola();
        objeto.setNome("Instituto Federal");
        objeto.setSigla("IF");
        objeto.setEndereco("Infernoo");
        objeto.setNr_alunos(200);
        objeto.setArea(558.68);
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
    public static boolean alterar(Escola objeto) {
        String sql = "UPDATE Escola SET nome = ?, sigla = ?, endereco = ?, nr_alunos = ?, area = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome()); 
            ps.setString(2, objeto.getSigla());
            ps.setString(3, objeto.getEndereco());
            ps.setInt   (4, objeto.getNr_alunos());
            ps.setDouble(5, objeto.getArea());
            ps.setInt   (6, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static boolean excluir(Escola objeto) {
        String sql = "DELETE FROM Escola WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static List<Escola> consultar() {
        List<Escola> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, sigla, endereco, nr_alunos, area FROM Escola";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Escola objeto = new Escola();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setSigla(rs.getString("sigla"));
                objeto.setEndereco(rs.getString("endereco"));
                objeto.setNr_alunos(rs.getInt("nr_alunos"));
                objeto.setArea(rs.getDouble("area"));
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
}
