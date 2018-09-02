package net.jakim.net.jakim.services;

import net.jakim.services.LibraryService;

import java.util.HashSet;
import java.util.Set;

public class LibraryServiceStub implements LibraryService
{
    @Override
    public Set<String> getAuthors( )
    {
        Set authors = new HashSet();
        authors.add( "Ivan" );
        authors.add( "Ivanushka" );
        authors.add( "ivailo" );
        authors.add( "ivelina" );
        authors.add( "Iva" );
        authors.add( "Ivar" );
        authors.add( "Ioan" );

        return authors;

    }

    @Override
    public Set<String> getTitles( )
    {
        Set titles = new HashSet();
        titles.add( "Pipi" );
        titles.add( "pithon" );
        titles.add( "Piranyah" );
        titles.add( "Parot" );
        titles.add( "Gogog" );

        return titles;
    }
}
