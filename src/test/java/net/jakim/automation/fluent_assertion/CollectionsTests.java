package net.jakim.automation.fluent_assertion;

import net.jakim.entities.Person;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class CollectionsTests
{

    @Test
    @DisplayName( "Assert first names of people from a collection" )
    public void checkPeopleFirstNames( )
    {
        List<Person> people = new LinkedList<>( );
        Person p1 = new Person( );
        p1.setFirstName( "Ivan" );
        Person p2 = new Person( );
        p2.setFirstName( "Donko" );
        Person p3 = new Person( );
        p3.setFirstName( "Maria" );

        people.add( p1 );
        people.add( p2 );
        people.add( p3 );

        assertThat( people ).extracting( Person::getFirstName )
                            .as( "People collection should contain People with Specific first names" )
                            .contains( "Ivan",
                                       "Donkoasd",
                                       "Maria" );
    }
}
