package com.project.MVP;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClientControllerTest extends TestCase {
    n = new Client("imad","ben");

    @Test
    public void testClient() {
        assertNotNull("L'instance n'est pas créée", n);
    }

    @Test
    public void testNewClient() throws Exception {
        assertEquals("imad",n.getNom());
        assertEquals("ben",n.getPrenom());
        fail("pas bon")
    }
}