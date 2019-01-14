package com.wsinger.iamhappy;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wsinger.iamhappy.data.QuoteData;
import com.wsinger.iamhappy.data.QuoteListAsyncResponse;
import com.wsinger.iamhappy.data.QuoteVpagerAdapter;
import com.wsinger.iamhappy.model.Quote;
import com.wsinger.iamhappy.view.QuoteFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    QuoteVpagerAdapter adapterViewPager;
    ViewPager viewPager;
    ShareActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1) Creo el adapter, pasando el array de fragmentos para este adapter pueble
        //2) Agarro el viewpager
        //3) Asigno el adapter al viewpager

        adapterViewPager = new QuoteVpagerAdapter(getSupportFragmentManager(), getFragments());
        viewPager = findViewById(R.id.view_pager);

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

    public void onClickSharedButton(View v){

        QuoteFragment fragment = (QuoteFragment) adapterViewPager.getItem( viewPager.getCurrentItem());
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,fragment.getArguments().getString("author"));
        intent.putExtra(Intent.EXTRA_TEXT, fragment.getArguments().getString("quote"));
        startActivity(Intent.createChooser(intent, "Choose sharing method"));

        //Toast.makeText(getApplicationContext(),"Compartir: "+fragment.getArguments().getString("quote"),Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_action_menu,menu);
        return true; //super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

    /*    switch (item.getItemId()){
            case R.id.sharebutton:

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "Check it out. Your message goes here";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
                return true;
            default: return super.onOptionsItemSelected(item);
        }
        */
        return super.onOptionsItemSelected(item);
    }

}
