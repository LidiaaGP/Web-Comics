package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ipartek.modelo.dto.Producto;


public class DB_Helper implements DAO_Constantes{
	
	public Connection Conectar() {
		
		Connection con=null;
		
		try {
			Class.forName(DRIVER);
			con= DriverManager.getConnection(RUTA,USUARIO,PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NO ENCONTRADO");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO SE PUDO CONECTAR A LA BD");
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	
	public List<Producto> obtenerTodosProductos(Connection con) {
		
		//1 crear una lista vacía para ir rellenando y cuando este, devolver
		List<Producto> lista=new ArrayList<Producto>();
		
		try {
			//2 preparar la sentencia SQL para lanzar la consulta
			CallableStatement cStmt=con.prepareCall(SP_OBTENER_PRODUCTOS);
			
			//3 ejecutar la sentencia para poder tener los resultados
			cStmt.execute();
			
			//4 el cStmt.getResultset lo guardamos en una variable
			//para poder trabajar comodamente
			ResultSet rs=cStmt.getResultSet();
			
			//5 el resultset siempre se recorre con un while
			while(rs.next()) {
				//5.1 creamos un objeto vacio para rellenarlo
				Producto prod=new Producto();
				
				//5.2 el objeto vacio se rellena con los set y
				//los datos del resultset
				//se obtienen TODOS LOS DATOS; aunque no los usemos luego
				prod.setId(rs.getInt(PRODUCTOS_ID));
				prod.setNombre(rs.getString(PRODUCTOS_NOMBRE));
				prod.setPrecio(rs.getDouble(PRODUCTOS_PRECIO));
				prod.setEditorial(rs.getString(PRODUCTOS_EDITORIAL));
				prod.setFk_categoria(rs.getInt(PRODUCTOS_FK_CATEGORIA));
				
				//5.3 el objeto relleno lo metemos en la lista
				lista.add(prod);
				
			}
			
			
		} catch (Exception e) {
			//6 si hay error la lista la vaciamos.
			System.out.println("NO SE PUDO OBETENR LA LISTA DE PRODUCTOS");
			lista=new ArrayList<Producto>();
			
			e.printStackTrace();
			
		}
		
		//7 devolvemos la lista, si esta vacia, es que no hay bocadillos o
		//hubo un error, si viene llena, se realizo la consulta ok
		return lista;
	}



	public void desconectar(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("NO SE PUDO DESCONECTAR");
			e.printStackTrace();
		}
	}
	
}
