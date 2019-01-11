package com.wsinger.iamhappy.data;

import com.wsinger.iamhappy.model.Quote;

import java.util.ArrayList;

//para saber si se trajo toda la lista, porque vamos a poblar el viewpager si y solo si los datos ya han sido traidos.
public interface QuoteListAsyncResponse{
    void processFinished(ArrayList<Quote> quotes);
}
