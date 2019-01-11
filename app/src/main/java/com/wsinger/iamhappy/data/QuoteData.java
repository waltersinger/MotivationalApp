package com.wsinger.iamhappy.data;
import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.wsinger.iamhappy.MainActivity;
import com.wsinger.iamhappy.controller.AppController;
import com.wsinger.iamhappy.model.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//Aqui va los datos obtenidos de API en un arraylist. De json a lista
//JSON array request
public class QuoteData{
    ArrayList<Quote> quotesArrayList = new ArrayList<>();

    public void getQuotesFromApi(final QuoteListAsyncResponse callback){
        String url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20";
        //agrega json request
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //obtengo el array y lo paso a objeto quote de model
                for (int i = 0; i < response.length(); i++) {
                    //estamos operando sobre una coexion por eso el ide obliga a poner try catch
                    //Se va llenando el arraylist a medida que va obteniendo
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Quote aquote = new Quote();
                        aquote.setQuote(jsonObject.getString("quote"));
                        aquote.setName(jsonObject.getString("name"));

                        Log.d("STUFF", "onResponse: " + jsonObject.getString("name"));

                        quotesArrayList.add(aquote);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //Al final cuando se recuperen los datos recien envio arraylist de datos.
                if(callback != null) {callback.processFinished(quotesArrayList);}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }

}
