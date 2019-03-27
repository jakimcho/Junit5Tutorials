package net.jakim.automation.fluent_assertion;

import net.jakim.entities.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTests
{
    Person person;

    @Test
    public void testFluentAssertCustomMessage()
    {
        person = new Person();
        person.setFirsName( "Ivan" );
        person.setSirName( "Ganev" );

        assertThat( person.getFullName() )
                .as( "User %s full name should contains Ganeva", person.getFullName() )
                .contains( "Ganeva" );
    }
}
