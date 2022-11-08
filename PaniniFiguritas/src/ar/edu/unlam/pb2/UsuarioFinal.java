package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class UsuarioFinal extends Usuario {

	 private ArrayList <Figurita> listFiguStock = new ArrayList<Figurita>();
	 private Set<Figurita> albumFiguritas = new HashSet<>();

//agregar esa figurita en el stock disponible para ese usuario. nueva figurita a su stock, pueden repetirse.
	 private void sacarFigurita(Figurita borrarFigurita) {
			listFiguStock.remove(borrarFigurita);
		}
	 
	 @Override
	public void agregarFigurita(Figurita figurita) {
		this.listFiguStock.add(figurita);
	}
	
	public Integer cantStock() {
		return listFiguStock.size();
	}
	
//	///////////////////////////////////////////////////////////////////////////////
	
	
		public void pegarFigurita(Figurita figurita) throws FiguritaRepetida {
		
			if (Estado.SIN_PEGAR == figurita.getEstadoFigurita()) {
			this.albumFiguritas.add(figurita); ///figurita pagada al album
		}else {
			if (albumFiguritas.contains(figurita) && Estado.PEGADA == figurita.getEstadoFigurita()) {
				 throw new FiguritaRepetida("Esta figurita está repetido");
			}
		}
	}
		
		public Integer cantFigusPegadasEnAlbum() {
			return albumFiguritas.size();
		}
	
	public Set<Figurita> obtenerFiguritasOrdenadosPorGrupo(){
		
		Set<Figurita> figuritasOrdenadasGrupo = new TreeSet<>(new OrdenFiguritasPorGrupo()); //crea un treeset y un objeto dentro
		figuritasOrdenadasGrupo.addAll(this.listFiguStock);
		
		return figuritasOrdenadasGrupo;
		
	}

	public Set<Figurita> figurasOrdenadasPorSeleccion() {

		Set<Figurita> ordenSeleccion = new TreeSet<>(new OrdenFiguritasPorSELECCION());
		
		ordenSeleccion.addAll(this.listFiguStock);
		
		return ordenSeleccion;
	}
	
	

	public Boolean IntercambiarFiguritas(UsuarioFinal braian, Figurita figuBraian, Figurita figuDiana,
			UsuarioFinal diana) throws FiguritaNoDisponible {
	
		
		for (Figurita figurita : listFiguStock) {
			
			if(listFiguStock.contains(figurita) && Estado.SIN_PEGAR == figurita.getEstadoFigurita()) {
			
			diana.sacarFigurita(figuDiana);
			braian.sacarFigurita(figuBraian);
			
			diana.agregarFigurita(figuBraian);
			braian.agregarFigurita(figuDiana);
			
			return true;
			
			}else {
				
				throw new FiguritaNoDisponible("no tiene figuritas para intercambiar");
			}
		
		}
		return false;
	}

	

	

	

	

}
