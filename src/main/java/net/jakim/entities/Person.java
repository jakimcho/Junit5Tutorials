package net.jakim.entities;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

public class Person
{
    private String firsName;
    private String sirName;

    //@MyCustomProp( age = 23 )
    private int age = 10;

    public String getFirsName( )
    {
        return firsName;
    }

    public void setFirsName( String firsName )
    {
        this.firsName = firsName;
    }

    public String getSirName( )
    {
        return sirName;
    }

    public void setSirName( String sirName )
    {
        this.sirName = sirName;
    }

    public int getAge( )
    {
        Field ageField = null;
        try
        {
            ageField = this.getClass( )
                           .getDeclaredField( "age" );
        } catch( NoSuchFieldException e )
        {
            e.printStackTrace( );
        }

        if( ageField.isAnnotationPresent( MyCustomProp.class ) )
        {
            MyCustomProp ageAnnotation = ageField.getAnnotation( MyCustomProp.class );
            System.out.println( "Got annotated field age value:" + ageAnnotation.age( ) );
            return ageAnnotation.age( );
        } else
        {
            System.out.println( "Age field was not annotated" );
            return this.age;
        }


    }
}
