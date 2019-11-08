package com.project.MVP;
import src.main.java.com.project.MVP;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClientControllerTest{
    @Test
   public void testNewClient(){
        Client n = new Client("imad","ben");
        assertEquals("imad",n.getNom());
        assertEquals("ben",n.getPrenom());
   }

   @Test
    public void testDeleteClient(){
       ClientController cli = new ClientController();
       cli.deleteOneUser(19);
   }
}
