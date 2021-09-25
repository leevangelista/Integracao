/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.dao;

import compras.model.Compra;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0NN4 CRY
 */
public class compraDAOTest {
    
    public compraDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class compraDAO.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Compra compra = null;
        compraDAO instance = new compraDAO();
        instance.inserir(compra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdInserido method, of class compraDAO.
     */
    @Test
    public void testGetIdInserido() {
        System.out.println("getIdInserido");
        compraDAO instance = new compraDAO();
        int expResult = 0;
        int result = instance.getIdInserido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class compraDAO.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Compra compra = null;
        compraDAO instance = new compraDAO();
        instance.atualizar(compra);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaPorId method, of class compraDAO.
     */
    @Test
    public void testBuscaPorId() {
        System.out.println("buscaPorId");
        int id = 0;
        compraDAO instance = new compraDAO();
        Compra expResult = null;
        Compra result = instance.buscaPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class compraDAO.
     */
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        int id = 0;
        compraDAO instance = new compraDAO();
        instance.excluir(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
