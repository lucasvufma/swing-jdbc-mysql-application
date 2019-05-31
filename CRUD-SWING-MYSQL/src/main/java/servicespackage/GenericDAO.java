package servicespackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import produtopackage.Produto;

public class GenericDAO<T> implements AbstractDAO<T>{
	private Connection conn;
	private Class c;
	
	public GenericDAO (Class c) {
		this.conn=new ConnectionFactory().getConnection();
		this.c=c;
	}
	@Override
	public List<T> recupera() {
			List lista = new LinkedList();
			String tablename = c.getSimpleName().toLowerCase();
			String sql = "select * from "+tablename;
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs= stmt.executeQuery();
				while (rs.next()) {
					Object obj = c.getDeclaredConstructor().newInstance();
					for (Field f : c.getDeclaredFields() ) {
						String nomefield = f.getName();
						String nomemethod = "set" 
						  + nomefield.substring(0,1).toUpperCase()
						  + nomefield.substring(1);
						Method m = c.getMethod(nomemethod,f.getType());
						m.invoke(obj , rs.getObject(nomefield) );
					}
					lista.add(obj);
				}
				stmt.close();
			}
			catch(SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				throw new RuntimeException(e);
			}
			return lista;
	}

	@Override
	public void atualiza(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adiciona(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
	