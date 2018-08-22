package net.jakim.automation;

import org.junit.jupiter.api.*;

public class MyJunit5Test
{

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - executes before each test method in this class");
    }

    @DisplayName( "Single test successful" )
    @Test
    void testSingleSuccessTest()
    {
        System.out.println( "Inside testSingleSuccessTest" );
        Assertions.assertTrue( "Gogogo".contains( "go" ),
                               "Failed" );
    }

    @Test
    @Disabled( "Not implemented yet" )
    void testShowSomething()
    {
    }

    @DisplayName( "Test the correctness of summing two numbers" )
    @Test
    void testSumOfTwoNumbers()
    {
        System.out.println( "Inside testSumOfTwoNumbers" );
        Assertions.assertEquals( 7.4,
                                 3.1 + 4.3 );
    }

    @DisplayName( "Test the correctness of two numbers multiplication" )
    @Test
    void testMultiplication()
    {
        System.out.println( "Inside testMultiplication" );
        Assertions.assertEquals( 12D,
                                 3 * 4 );

    }
}
