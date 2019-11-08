package com.project.MVP;

import org.junit.Test;
import static org.junit.Assert.*;


public class ClientControllerTest{
    Client n = new Client("imad","ben");

    @Test
    public void testClient() {
        Client n = new Client("imad","ben");
        assertNotNull("L'instance n'est pas créée", n);
    }

    @Test
    public void testNewClient(){
        Client n = new Client("imad","ben");
        assertEquals("imad",n.getNom());
        assertEquals("ben",n.getPrenom());
    }

    @Test
    public void testDeleteClient(){
        Client arthur = new Client("arthhur","premier");
        //deleteOneUser(arthur.getId());
    }
}
