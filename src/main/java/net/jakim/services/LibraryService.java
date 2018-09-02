package net.jakim.services;

import java.util.Set;

public interface LibraryService
{
    Set<String> getAuthors();
    Set<String> getTitles();
}
