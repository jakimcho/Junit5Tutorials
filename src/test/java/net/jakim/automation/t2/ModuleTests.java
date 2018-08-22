package net.jakim.automation.t2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ModuleTests
{
    @DisplayName( "Test three module 2" )
    @Test
    void testModuleByTwo()
    {
        System.out.println( "Inside testModuleByTwo" );
        Assertions.assertEquals(1,
                               3 % 2 );
    }
}
