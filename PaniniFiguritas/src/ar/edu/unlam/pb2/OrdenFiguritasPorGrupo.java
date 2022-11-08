package ar.edu.unlam.pb2;

import java.util.Comparator;

public class OrdenFiguritasPorGrupo implements Comparator<Figurita>{

		
	@Override
	public int compare(Figurita o1, Figurita o2) {
		
		if (o1.getLetra().compareTo(o2.getLetra()) == 0) {
			return o2.getCodFigu().compareTo(o1.getCodFigu());
		}
		
		return o1.getLetra().compareTo(o2.getLetra());
	}

}
