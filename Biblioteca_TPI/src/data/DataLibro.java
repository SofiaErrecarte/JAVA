package data;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import entities.*;

public class DataLibro {
	
	public LinkedList<Libro> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Libro> libros= new LinkedList<>();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from libro");
			if(rs!=null) {
				while(rs.next()) {
					Libro lib=new Libro();
					lib.setIdLibro(rs.getInt("idLibro"));
					lib.setTitulo(rs.getString("titulo"));
					lib.setIsbn(rs.getInt("isbn"));
					lib.setFechaEdicion(rs.getDate("fechaEdicion"));
					lib.setNroEdicion( rs.getInt("nroEdicion"));
					lib.setCantDiasMaxPrestamo(rs.getInt("cantDiasMaxPrestamo"));
					lib.setGenero(rs.getString("genero"));
					lib.setCUIT(rs.getString("cuit"));
					
					libros.add(lib);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return libros;
	}
	
	
	public Libro add(Libro lib) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"INSERT INTO `biblioteca`.`libro` ( `titulo`, `isbn`, `nroEdicion`, `cantDiasMaxPrestamo`, `genero`) VALUES(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, lib.getTitulo());
			stmt.setLong(2, lib.getIsbn());
			//stmt.setTimestamp(2, new java.sql.Timestamp(lib.getFechaEdicion().getTime()));
			//stmt.setDate(3, (java.sql.Date) (lib.getFechaEdicion()));
			stmt.setLong(3, lib.getNroEdicion());
			stmt.setLong(4, lib.getCantDiasMaxPrestamo());
			stmt.setString(5, lib.getGenero());			
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                lib.setIdLibro(keyResultSet.getInt(1));
            }
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
		return lib;
	}

	public Libro getById(Libro lib) {
		Libro l = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select * from libro where idLibro=?");
			stmt.setInt(1, lib.getIdLibro());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				l = new Libro();
				l.setIdLibro(rs.getInt("idLibro"));
				l.setIsbn(rs.getInt("isbn"));
				l.setTitulo(rs.getString("titulo"));
				//l.setFechaEdicion(rs.getString("fechaEdicion"));
				l.setNroEdicion(rs.getInt("nroEdicion"));
				l.setCantDiasMaxPrestamo(rs.getInt("cantDiasMaxPrestamo"));
				l.setGenero(rs.getString("genero"));
				l.setCUIT(rs.getString("cuit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return l;
	}

	public Libro editLibro(Libro lib) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE `biblioteca`.`libro` SET `titulo` = ?, `isbn` = ?, `nroEdicion` = ?, `cantDiasMaxPrestamo` = ?, `genero` = ? WHERE (`idLibro` = ?);",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, lib.getTitulo());
			stmt.setLong(2, lib.getIsbn());
			stmt.setLong(3, lib.getNroEdicion());
			stmt.setLong(4, lib.getCantDiasMaxPrestamo());
			stmt.setString(5, lib.getGenero());		
			stmt.setInt(6,  lib.getIdLibro());
			stmt.executeUpdate();
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		return lib;
	}

	public Libro deleteLibro(Libro lib) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE FROM `biblioteca`.`libro` WHERE (`idLibro` = ?);",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, lib.getIdLibro());
			stmt.executeUpdate();	
            
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		return lib;
	}
	
	
		
	

}
