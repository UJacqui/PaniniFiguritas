package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;


public class TestAlbumPanini {

	@Test
	public void queSePuedaCrearUnaFigurita() {
		
		Figurita figurita = new Figurita(01,'A', "argentina","Messi",50.0, Estado.SIN_PEGAR);
		
		assertNotNull(figurita);
		
	}
	@Test
	public void queSePuedaCrearUnAdministrador() {
		Usuario administrador = new Administrador();
		
		assertNotNull(administrador);

	}
	
	@Test
	public void queSePuedaCrearUnUsuarioFinal() {
		Usuario usuarioF = new UsuarioFinal();
		
		assertNotNull(usuarioF);

	}
	
	@Test
	public void queUnAdministradorPuedaAgregarUnaFigurita() {
				
		Administrador admi = new Administrador();

		Figurita figurita = new Figurita(01,'A', "argentina","Messi",50.0, Estado.SIN_PEGAR);

		
		admi.agregarFigurita(figurita);
		
		Integer cantidadEsperada = 1;
		
		assertEquals(cantidadEsperada, admi.cantFigusAptas());
		
		
	}
	
	@Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita() {
				
		UsuarioFinal usuarioF = new UsuarioFinal();

		Figurita figurita = new Figurita(01,'A', "argentina","Messi",50.0, Estado.SIN_PEGAR);

		
		usuarioF.agregarFigurita(figurita);
		
		Integer cantidadEsperada = 1;
		
		assertEquals(cantidadEsperada, usuarioF.cantStock());
		
		
	}
	@Test
	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadasGRUPO() {
		
		UsuarioFinal usuarioF = new UsuarioFinal();

		Figurita figurita1 = new Figurita(01,'A', "argentina","Messi",50.0, Estado.SIN_PEGAR);
		Figurita figurita2 = new Figurita(02,'C', "argentina","Messi",50.0, Estado.SIN_PEGAR);
		Figurita figurita3 = new Figurita(03,'B', "argentina","Messi",50.0, Estado.SIN_PEGAR);

		
		usuarioF.agregarFigurita(figurita1);
		usuarioF.agregarFigurita(figurita2);
		usuarioF.agregarFigurita(figurita3);
		
		
		
		Set<Figurita> figuritasOrdenados =  usuarioF.obtenerFiguritasOrdenadosPorGrupo();
		
		for (Figurita figurita : figuritasOrdenados) {
			System.out.println(figurita.getLetra());
			
		}
		
		usuarioF.agregarFigurita(new Figurita(01,'A', "Brasil","Messi",50.0, Estado.SIN_PEGAR));
		usuarioF.agregarFigurita(new Figurita(01,'A', "Argentina","Messi",50.0, Estado.SIN_PEGAR));
		usuarioF.agregarFigurita(new Figurita(01,'A', "Colombia","Messi",50.0, Estado.SIN_PEGAR));
		
		Set<Figurita> ordenxSeleccion = usuarioF.figurasOrdenadasPorSeleccion();
		
		for (Figurita figurita : ordenxSeleccion) {
			System.out.println(figurita.getSeleccion());
		}
		
	}
	
	@Test
	public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() {
		  
		Administrador admi = new Administrador();
		
		admi.agregarFigurita(new Figurita(01,'A', "argentina","Messi",50.0, Estado.SIN_PEGAR));
		admi.agregarFigurita(new Figurita(01,'A', "argentina","Messi",50.0, Estado.SIN_PEGAR));
		admi.agregarFigurita(new Figurita(04,'B', "brasil","ronaldo",50.0, Estado.SIN_PEGAR));

		
		Integer FiguNoDuplicada = 2;
		
		assertEquals(FiguNoDuplicada, admi.cantFigusExistentes());

	}
	@Test
	public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() {}
	
	
	
	
	@Test
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() throws FiguritaRepetida {
		
		UsuarioFinal usuarioF = new UsuarioFinal();
		
		Figurita figurita = new Figurita(01,'A', "Brasil","Messi",50.0, Estado.SIN_PEGAR);
				
		usuarioF.pegarFigurita(figurita);
		
		Integer figuritasPegadasEsperadas = 1;

		assertEquals(figuritasPegadasEsperadas, usuarioF.cantFigusPegadasEnAlbum());
		
	}
	
	@Test
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws FiguritaRepetida {
		UsuarioFinal usuarioF = new UsuarioFinal();
		
		Figurita figurita = new Figurita(01,'A', "Brasil","Messi",50.0, Estado.PEGADA);
		Figurita figuritarep = new Figurita(01,'A', "Brasil","Messi",50.0, Estado.SIN_PEGAR);
			
		usuarioF.pegarFigurita(figurita);
		usuarioF.pegarFigurita(figuritarep);

		Integer figuritasPegadasEsperadas = 1;

		assertEquals(figuritasPegadasEsperadas, usuarioF.cantFigusPegadasEnAlbum());
		
		
	}
	
	@Test
	public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() throws FiguritaNoDisponible {
		
		UsuarioFinal diana = new UsuarioFinal();
		UsuarioFinal braian = new UsuarioFinal();
		
		Figurita figuDiana = new Figurita(01,'A', "argentina","Messi",50.0, Estado.SIN_PEGAR);
		Figurita figuBraian = new Figurita(05,'B', "Brasil","ronaldo",50.0, Estado.SIN_PEGAR);
			
		diana.agregarFigurita(figuDiana);
		braian.agregarFigurita(figuBraian);
		
		Boolean intercambio = diana.IntercambiarFiguritas(braian,figuBraian, figuDiana,diana);
		
		assertTrue(intercambio);
		
	}
	
	
	@Test
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga() throws FiguritaNoDisponible {
		
		UsuarioFinal diana = new UsuarioFinal();
		UsuarioFinal braian = new UsuarioFinal();
		
		Figurita figuDiana = new Figurita(01,'A', "argentina","Messi",50.0, Estado.SIN_PEGAR);
		Figurita figuBraian = new Figurita(05,'B', "Brasil","ronaldo",50.0, Estado.SIN_PEGAR);
			
		
		braian.agregarFigurita(figuBraian);
		
		diana.IntercambiarFiguritas(braian,figuBraian, figuDiana,diana);
		
		Integer cantfiguritasencoleccion =1;
		
		
		assertEquals(cantfiguritasencoleccion, braian.cantStock());
		
		
	}
	
	@Test (expected = FiguritaNoDisponible.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado() throws FiguritaNoDisponible {
		
		UsuarioFinal diana = new UsuarioFinal();
		UsuarioFinal braian = new UsuarioFinal();
		
		Figurita figuDiana = new Figurita(01,'A', "argentina","Messi",50.0, Estado.PEGADA);
		Figurita figuBraian = new Figurita(05,'B', "Brasil","ronaldo",50.0, Estado.PEGADA);
			
		
		braian.agregarFigurita(figuBraian);
		
		diana.IntercambiarFiguritas(braian,figuBraian, figuDiana,diana);
		
		
		assertFalse(braian.IntercambiarFiguritas(braian, figuBraian, figuDiana, diana));
		
	}
	
	
	
	
		
	
	
	
	
	
	
	
		

}
