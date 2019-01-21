package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import modelo.Colores;
import modelo.Lista;

public class ListaTest {

	Lista lista= new Lista( new LinkedList<Colores>());
	
	@Before
	public void rellenarLista(){
		lista.addLista(Colores.amarillo);
		lista.addLista(Colores.amarillo);
		lista.addLista(Colores.amarillo);
		lista.addLista(Colores.azul);
	}
	
	@Test
	public void testBorrarColores() {
		ArrayList<Integer> posiciones= new ArrayList<>();
		posiciones.add(0);
		posiciones.add(1);
		posiciones.add(2);
	//	assertEquals(3,lista.borrarColores(posiciones) );
	}
	
	@Test
	public void testRecorrerAutomatico() {
		ArrayList<Integer> posiciones= new ArrayList<>();
		posiciones.add(0);
		posiciones.add(1);
		posiciones.add(2);
	//	assertEquals(posiciones, lista.recorrerAutomatico());
	}
	
	@Test
	public void testBusquedaColor() {
		ArrayList<Integer>posiciones= new ArrayList<>();
		posiciones.add(3);
	//	assertEquals(posiciones, lista.busquedaColor(Colores.azul));
	}
	
}
