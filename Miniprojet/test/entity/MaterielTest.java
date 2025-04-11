package entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaterielTest {

    private Mat instance;

    @Before
    public void setUp() {
        instance = new Mat("1", "192.168.1.1", "Marque1","Nom1");
    }

    @Test
    public void testGetIdmat() {
        assertEquals("1", instance.getId());
    }

    @Test
    public void testGetNom() {
        assertEquals("Nom1", instance.getNom());
    }

    @Test
    public void testGetIp() {
        assertEquals("192.168.1.1", instance.getIp());
    }

    @Test
    public void testGetMarque() {
        assertEquals("Marque1", instance.getMarque());
    }

    @Test
    public void testSetIdmat() {
        instance.setId("2");
        assertEquals("2", instance.getId());
    }

    @Test
    public void testSetNom() {
        instance.setNom("aya");
        assertEquals("aya", instance.getNom());
    }

    @Test
    public void testSetIp() {
        instance.setIp("192.168.2.1");
        assertEquals("192.168.2.1", instance.getIp());
    }

    @Test
    public void testSetMarque() {
        instance.setMarque("Dell");
        assertEquals("Dell", instance.getMarque());
    }

   
}
