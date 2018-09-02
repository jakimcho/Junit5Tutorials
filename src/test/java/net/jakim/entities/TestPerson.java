package net.jakim.entities;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestPerson
{
    @MyCustomProp(age=12)
    private Person person;

    public TestPerson(){
        super();
        this.person = new Person();
        this.person.setFirsName( "Ivan" );
        this.person.setSirName( "Dimitrov" );
    }

    @Test
    public void verifyUserFirstName( ){
        Assertions.assertEquals( "Ivan", this.person.getFirsName(), "Wrong first name" );
    }

    @Test
    public void verifyUserSirName( ){
        Assertions.assertEquals( "Dimitrov", this.person.getSirName(), "Wrong sir name" );
    }

    @Test
    public void verifyUserAge( ){
        Assertions.assertEquals( 23, this.person.getAge(), "Wrong age" );
    }
}
