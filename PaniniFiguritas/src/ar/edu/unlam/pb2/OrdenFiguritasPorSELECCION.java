package ar.edu.unlam.pb2;

import java.util.Comparator;

public class OrdenFiguritasPorSELECCION implements Comparator<Figurita> {

	@Override
	public int compare(Figurita o1, Figurita o2) {
		if (o1.getSeleccion().compareTo(o2.getSeleccion()) == 0) {
			return o2.getCodFigu().compareTo(o1.getCodFigu());
		}
		
		return o1.getSeleccion().compareTo(o2.getSeleccion());
		
	}

}
