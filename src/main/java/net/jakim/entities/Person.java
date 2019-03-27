package net.jakim.entities;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public class Person
{
    private static final Logger LOGGER = Logger.getLogger( "Person" );
    private String firsName;
    private String sirName;

    @MyCustomProp( age = 25 )
    private int age = 10;

    public String getFirsName()
    {
        return firsName;
    }

    public void setFirsName( String firsName )
    {
        this.firsName = firsName;
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
        return this.firsName + " " + this.getSirName();
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
}
