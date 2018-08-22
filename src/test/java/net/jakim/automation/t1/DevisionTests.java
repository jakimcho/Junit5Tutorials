package net.jakim.automation.t1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DevisionTests
{
    @DisplayName( "Test dividing three by 2" )
    @Test
    void testModuleByTwo()
    {
        System.out.println( "Inside testModuleByTwo" );
        Assertions.assertEquals( 1.5,
                                 3D / 2D );
    }
}
