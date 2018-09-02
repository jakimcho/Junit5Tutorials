package net.jakim.entities;

import net.jakim.services.LibraryService;

import java.util.HashSet;
import java.util.Set;

public class Library
{
    LibraryService libraryService;

    public Library( LibraryService libraryService )
    {
        super( );
        this.libraryService = libraryService;
    }

    public Set filterAuthorsByFirstLetters( final String letters )
    {
        Set result = new HashSet( );
        this.libraryService.getAuthors( )
                           .forEach( author->
                                     {
                                         if( author.toLowerCase( )
                                                   .startsWith( letters.toLowerCase( ) ) )
                                         {
                                             result.add( author );
                                         }
                                     } );
        return result;

    }

    public Set filterBooksByFirstLetters( String letters )
    {
        Set result = new HashSet( );
        this.libraryService.getTitles( )
                           .forEach( title->
                                     {
                                         if( title.toLowerCase( )
                                                  .startsWith( letters.toLowerCase( ) ) )
                                         {
                                             result.add( title );
                                         }
                                     } );
        return result;
    }
}
