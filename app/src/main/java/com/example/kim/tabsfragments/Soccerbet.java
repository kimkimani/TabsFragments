package com.example.kim.tabsfragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ListView;

        import com.android.volley.Request;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.example.kim.tabsfragments.Adapter.TipsAdapter;
        import com.example.kim.tabsfragments.Model.tips;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;

public class Soccerbet extends AppCompatActivity {

    ListView listView;
    List<tips> tipsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_soccerbet );


        listView =(ListView)findViewById ( R.id.list_tips );
        tipsList= new ArrayList<> ();
        showlist();

    }

    private void showlist()
    {

        StringRequest stringRequest= new StringRequest ( Request.Method.GET, " http://172.19.152.113/tipscoreJSON/dailytips.php",
                new Response.Listener<String> () {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject object= new JSONObject ( response );
                            JSONArray array= object.getJSONArray ( "data" );
                            for (int i =0;i <array.length ();i ++)
                            {
                                JSONObject tipsObj= array.getJSONObject(i);
                                tips p= new tips ( ("")+tipsObj.getString ( "Time" ),
                                        ("")+tipsObj.getString ( "league" ),
                                        ("")+tipsObj.getString ( "Match" ),
                                        ("Tip:")+tipsObj.getString ( "Tips" ),
                                        ("Odd:")+tipsObj.getString ( "Odds" ),
                                        ("Results:")+tipsObj.getString ( "Results" )




                                );

                                tipsList.add ( p );
                            }
                            TipsAdapter tipsAdapter= new TipsAdapter(tipsList,getApplicationContext ());
                            listView.setAdapter (tipsAdapter );

                        } catch (JSONException e) {
                            e.printStackTrace ();
                        }
                    }
                }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

        };
        Handler.getmInstance ( getApplicationContext ()).addToRequestQueue(stringRequest);
    }

}

