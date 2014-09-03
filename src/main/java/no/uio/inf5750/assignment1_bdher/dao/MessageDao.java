package no.uio.inf5750.assignment1_bdher.dao;

import no.uio.inf5750.assignment1_bdher.model.Message;

public interface MessageDao
{
    int save( Message message );
    Message get( int id );
    Message getLast();    
}