package generictablepackage;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.table.AbstractTableModel;

import annotationpackages.Coluna;
import servicespackage.AbstractDAO;

public class GenericTableModel<T> extends AbstractTableModel {
	AbstractDAO dao;
	List<T> dados;
	List<T> dados_selecionados;
	
	public GenericTableModel (AbstractDAO dao) {
		this.dao = dao;
		
		dados = dao.recupera();
		this.dados_selecionados=dados;
	}
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		Class c = dados.get(0).getClass();
		int conta = 0;
		for (Field f : c.getDeclaredFields()) {
			if (f.isAnnotationPresent(Coluna.class )) {
				conta++;
			}
		}
		return conta;
	}
	@Override
	public String getColumnName(int col) {
		Class c = dados.get(0).getClass();
		for (Field f : c.getDeclaredFields()) {
			if (f.isAnnotationPresent(Coluna.class )) {
				Coluna a = f.getAnnotation(Coluna.class );
				if (a.pos() == col) {
					return a.nome();
				}
			}
		}
		return null;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados_selecionados.size();
	}

	public void UpdateTable() {
		this.dados_selecionados=dao.recupera();
		fireTableDataChanged();
	}
	
	/* Pendente Implementação do Filtro pra Generic !!
	public void Filtro(Integer Integer_PK,Class c,String Nome) {
		if (Integer_PK != null){
			
		}
		dados_selecionados=dados.stream().filter((Object)->Object.getID_Prod() == ID)
				.collect(Collectors.toList());
		fireTableDataChanged();
		}
		*/

	@Override
	public Object getValueAt(int row, int col) {
		T obj = dados_selecionados.get(row);
		Class c = obj.getClass();
		
		for (Field f : c.getDeclaredFields()) {
			if (f.isAnnotationPresent(Coluna.class )) {
				Coluna a = f.getAnnotation(Coluna.class );
				if (a.pos() == col) {
					String nomefield = f.getName();
					String nomemethod = "get" 
					  + nomefield.substring(0,1).toUpperCase()
					  + nomefield.substring(1);
					//System.out.println(nomemethod);
					try {
						Method m = c.getMethod(nomemethod);
						return m.invoke(obj);
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
				
				}
			}
		}
		return null;
	}
	


}
