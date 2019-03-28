package net.jakim.entities;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public class Person
{
    private static final Logger LOGGER = Logger.getLogger( "Person" );
    private String firstName;
    private String sirName;

    //@MyCustomProp( age = 25 )
    private int age = 10;

    public String getFirstName( )
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getSirName()
    {
        return sirName;
    }

    public void setSirName( String sirName )
    {
        this.sirName = sirName;
    }

    public String getFullName()
    {
        return this.firstName + " " + this.getSirName( );
    }

    public int getAge()
    {
        Field ageField = null;
        try
        {
            ageField = this.getClass()
                           .getDeclaredField( "age" );
        } catch ( NoSuchFieldException e )
        {
            LOGGER.severe( e.getMessage() );
        }

        if ( null != ageField && ageField.isAnnotationPresent( MyCustomProp.class ) )
        {
            MyCustomProp ageAnnotation = ageField.getAnnotation( MyCustomProp.class );
            int res = ageAnnotation.age();
            LOGGER.info( "Got annotated field age value: " + res );
            return res;
        } else
        {
            return this.age;
        }


    }

    public void setAge( int i )
    {
        this.age = i;
    }
}
