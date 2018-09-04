package net.jakim.entities;

import net.jakim.net.jakim.services.LibraryServiceStub;
import net.jakim.services.LibraryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTests
{
    private Library library;


    @Test
    public void filterAuthorsByFirstLettersTest( )
    {
        LibraryService libraryServiceStub = new LibraryServiceStub( );
        this.library = new Library( libraryServiceStub );
        Set filteredAuthors = this.library.filterAuthorsByFirstLetters( "Iva" );
        Assertions.assertEquals( 5,
                                 filteredAuthors.size( ) );
        List expectedAuthors = new ArrayList( 5 );
        expectedAuthors.add( "ivailo" );
        expectedAuthors.add( "Iva" );
        expectedAuthors.add( "Ivar" );
        expectedAuthors.add( "Ivanushka" );
        expectedAuthors.add( "Ivan" );
        Assertions.assertTrue( filteredAuthors.containsAll( expectedAuthors ) );
    }


    @Test
    public void filterAuthorsByFirstLettersMockTest( )
    {

        LibraryService libraryServiceMock = mock( LibraryService.class );
        Set<String>    authors            = new HashSet<String>( );
        authors.add( "Ivan" );
        authors.add( "Ivanushka" );
        authors.add( "ivailo" );
        authors.add( "ivelina" );
        authors.add( "Iva" );
        authors.add( "Ivar" );
        authors.add( "Ioan" );
        when( libraryServiceMock.getAuthors( ) ).thenReturn( authors );
        this.library = new Library( libraryServiceMock );
        Set filteredAuthors = this.library.filterAuthorsByFirstLetters( "Iva" );
        Assertions.assertEquals( 5,
                                 filteredAuthors.size( ) );
        List expectedAuthors = new ArrayList( 5 );
        expectedAuthors.add( "ivailo" );
        expectedAuthors.add( "Iva" );
        expectedAuthors.add( "Ivar" );
        expectedAuthors.add( "Ivanushka" );
        expectedAuthors.add( "Ivan" );
        Assertions.assertTrue( filteredAuthors.containsAll( expectedAuthors ) );
    }

    @Test
    public void filterBooksByFirstLettersTest( )
    {
        LibraryService libraryServiceStub = new LibraryServiceStub( );
        this.library = new Library( libraryServiceStub );
        Set filteredTitle = this.library.filterBooksByFirstLetters( "pi" );
        Assertions.assertEquals( 3,
                                 filteredTitle.size( ) );
        List expectedTitle = new ArrayList( 3 );
        expectedTitle.add( "Pipi" );
        expectedTitle.add( "Piranyah" );
        expectedTitle.add( "pithon" );
        Assertions.assertTrue( filteredTitle.containsAll( expectedTitle ) );
    }
}
