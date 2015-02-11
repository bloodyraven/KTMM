package test;

import org.junit.Test;

import bdd.BDD;
import static org.junit.Assert.*;

public class TestBDD {
	
	@Test
	public void testContient() {
		String[][] tab = {{"yann","ok"},{"yann","ok2"},{"bite","molle"}};
		String[][] tab3 = BDD.contient(tab, "yann", 0);
		String[][] tab2 = {{"yann","ok"},{"yann","ok2"}};
		assertArrayEquals(tab3, tab2);
	}
}