package net.jakim.entities;


import org.junit.jupiter.api.*;

import java.util.logging.Logger;

public class PersonTests
{
    private static final Logger LOGGER = Logger.getLogger( "PersonTests" );
    private Person person;

    public PersonTests( ){
        super();
        this.person = new Person();
        this.person.setFirstName( "Ivan" );
        this.person.setSirName( "Dimitrov" );
    }

    @Test
    public void testGetUserFirstName( ){
        LOGGER.info("Inside verifyUserFirstName" );
        Assertions.assertEquals( "Ivan", this.person.getFirstName( ), "Wrong first name" );
        LOGGER.info("Exiting verifyUserFirstName" );
    }

    @Test
    @Tag( "sanity" )
    public void getSirNameTest( ){
        LOGGER.info("Inside verifyUserSirName" );
        Assertions.assertEquals( "Dimitrov", this.person.getSirName(), "Wrong sir name" );
        LOGGER.info("Exiting verifyUserSirName" );
    }

    @Test
    public void verifyUserAge( ){
        LOGGER.info("Inside verifyUserAge" );
        Assertions.assertEquals( 25, this.person.getAge(), "Wrong age" );
        LOGGER.info("Exiting verifyUserAge" );
    }

    @BeforeAll
    public static void mainSetup(){
        LOGGER.info("This setup the system only once" );
    }

    @AfterAll
    public static void mainTearDown(){
        LOGGER.info("This needs to clean the system only once" );
    }

    @BeforeEach
    public void commonSetup(){
        LOGGER.info("this is setup before each method" );
    }

    @AfterEach()
    public void commonTearDown(){
        LOGGER.info("this is teardown after each method" );
    }

}
