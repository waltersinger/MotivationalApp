package com.wsinger.iamhappy.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wsinger.iamhappy.R;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {


    public QuoteFragment() {
        // Required empty public constructor
    }

    //Es como el viewHolder del recycler view. Guarda en un bundle los datos y en el evento de creacion de la vista (ultimo en llamarse
    //  ) se obtiene lo del bundle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);

       TextView textViewQuote = (TextView) quoteView.findViewById(R.id.textview_quote);
       TextView textViewAuthor = quoteView.findViewById(R.id.textview_author);

        //aqui obtengo los datos del bundle (parametros entre fragmentos)
        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");

        textViewQuote.setText(quote);
        textViewAuthor.setText("-"+author);

        return quoteView;
    }
    //para que llame al fragmento quotefragment antes de ser creado asi asigne valores que se pasan como parametros
    public static final QuoteFragment newInstance(String quote, String author){
        //aqui se va a instanciar el fragmento, en lugar de poner new ..... se llamara a newInstance pasando parametros y listo.

        QuoteFragment fragment = new QuoteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("quote", quote);
        bundle.putString("author",author);
        fragment.setArguments(bundle); // pasa el bundle con los datos al fragmento
        return fragment;
    }

}
