package net.jakim.automation.assertion;

import net.jakim.entities.Person;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.AbstractStandardSoftAssertions;
import org.assertj.core.api.OptionalDoubleAssert;
import org.assertj.core.error.AssertionErrorCreator;

import java.util.List;
import java.util.OptionalDouble;

public class PeopleAssertions
        extends AbstractAssert<PeopleAssertions, Person>
{
    public PeopleAssertions( Person actualUser )
    {
        super( actualUser,
               PeopleAssertions.class );
    }

    public static PeopleAssertions assertThat( Person actualUser )
    {
        return new PeopleAssertions( actualUser );
    }

    public PeopleAssertions canVote( )
    {

        isNotNull( );

        // overrides the default error message with a more explicit one
        String assertjErrorMessage
                = "\nExpecting User <%s> to be between 18 and 75 years old in order to vote but was:\n  <%d> years old";

        if( actual.getAge( ) < 18 || actual.getAge( ) > 75 )
        {
            failWithMessage( assertjErrorMessage,
                             actual.getFullName( ),
                             actual.getAge( ) );
        }

        return this;
    }

    public PeopleAssertions isMale( )
    {
        isNotNull( );
        String assertjErrorMessage
                = "\nExpecting User <%s> to be Male";

        if( actual.getFullName( )
                  .endsWith( "a" ) )
        {
            failWithMessage( assertjErrorMessage,
                             actual.getSirName( ) );
        }

        return this;
    }

    public static class SoftAssertion
            extends AbstractStandardSoftAssertions
    {
        private AssertionErrorCreator assertionErrorCreator = new AssertionErrorCreator( );

        public SoftAssertion( )
        {

        }

        public void assertAll( )
        {
            List<Throwable> errors = this.errorsCollected( );
            if( !errors.isEmpty( ) )
            {
                throw this.assertionErrorCreator.multipleSoftAssertionsError( errors );
            }
        }

        public PeopleAssertions assertThat( Person actual )
        {
            return ( PeopleAssertions ) this.proxy( PeopleAssertions.class,
                                                    Person.class,
                                                    actual );
        }
    }
}
