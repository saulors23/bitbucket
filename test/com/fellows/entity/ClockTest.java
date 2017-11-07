package com.fellows.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClockTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @Test
    public void concepcion() {
        Clock clock = new Clock();

        assertTrue( clock != null );

        clock.setHour( 9 );
        clock.setMinute( 0 );

        assertEquals( "{\"angle\":90}", clock.toString() );

    }
    
    @Test
    public void test2() {
        Clock clock = new Clock();

        assertTrue( clock != null );

        clock.setHour(3 );
        clock.setMinute( 44 );

        assertEquals( "{\"angle\":152}", clock.toString() );

    }

}
