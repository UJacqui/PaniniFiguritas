package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Administrador extends Usuario  {
	

	//de hashSet cambio a TreeSet- los elemento del conjunto de ordenan de menor a mayor no admite duplicados
	
	private Set <Figurita> listFigusAptas = new TreeSet<Figurita>();

	
//	se encarga de dar de alta una nueva figurita con sus características

	@Override
	public void agregarFigurita(Figurita figurita) {
		this.listFigusAptas.add(figurita);
	}
	
	public Integer cantFigusAptas() {
		return listFigusAptas.size();
	}
	
	public Integer cantFigusExistentes() {
		return listFigusAptas.size();
	}

	

	
	
}
