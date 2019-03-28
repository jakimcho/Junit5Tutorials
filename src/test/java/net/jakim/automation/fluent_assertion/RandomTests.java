package net.jakim.automation.fluent_assertion;

import net.jakim.automation.assertion.PeopleAssertions;
import net.jakim.entities.Person;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith( JUnitPlatform.class )
@SuiteDisplayName( "Some random tests using assert J" )
@DisplayName( "Some random tests using assert J" )
public class RandomTests
{
    Person person;

    @Test
    public void testFluentAssertCustomMessage( )
    {
        person = new Person( );
        person.setFirstName( "Ivan" );
        person.setSirName( "Ganev" );

        assertThat( person.getFullName( ) )
                .as( "User %s full name should contains Ganev",
                     person.getFullName( ) )
                .contains( "Ganev" );
    }

    @Test
    @DisplayName( "Test user with custom assertion" )
    public void testUserCanVote( )
    {
        // In order user to vote he/she should be between 18 and 75 years old;
        Person p1 = new Person( );
        p1.setFirstName( "Ivan" );
        p1.setSirName( "Petrov" );
        p1.setAge( 18 );
        Person p2 = new Person( );
        p2.setFirstName( "Maria" );
        p2.setSirName( "Antonieta" );
        p2.setAge( 75 );
        Person p3 = new Person( );
        p3.setFirstName( "Grigor" );
        p3.setSirName( "Dimitrov" );
        p3.setAge( 16 );

        PeopleAssertions.SoftAssertion softly = new PeopleAssertions.SoftAssertion( );


        softly.assertThat( p1 )
              .canVote( )
              .isMale( );
        softly.assertThat( p2 )
                        .canVote( )
                        .isMale( );
        softly.assertThat( p3 )
                        .canVote( )
                        .isMale( );

        softly.assertAll();

    }
}
