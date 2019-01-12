package com.wsinger.iamhappy;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.wsinger.iamhappy.data.QuoteData;
import com.wsinger.iamhappy.data.QuoteListAsyncResponse;
import com.wsinger.iamhappy.data.QuoteVpagerAdapter;
import com.wsinger.iamhappy.model.Quote;
import com.wsinger.iamhappy.view.QuoteFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    QuoteVpagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1) Creo el adapter, pasando el array de fragmentos para este adapter pueble
        //2) Agarro el viewpager
        //3) Asigno el adapter al viewpager

        adapterViewPager = new QuoteVpagerAdapter(getSupportFragmentManager(), getFragments());
        ViewPager viewPager = findViewById(R.id.view_pager);

        viewPager.setAdapter(adapterViewPager);
    }

    private List<Fragment> getFragments(){
        final List<Fragment> f = new ArrayList<>();
        QuoteData qd = new QuoteData();

        qd.getQuotesFromApi(new QuoteListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {

                for(int i = 0; i< quotes.size();i++){

                    QuoteFragment q = QuoteFragment.newInstance(quotes.get(i).getQuote(),quotes.get(i).getName());
                    f.add(q);
                }

                adapterViewPager.notifyDataSetChanged();
            }
        });
        /*
        for(int i =0;i<5;i++){

            QuoteFragment q = QuoteFragment.newInstance("Hola desde el "+i+" fragment","Yo mismo");
            f.add(q);

        }*/
        return f;
    }
}
