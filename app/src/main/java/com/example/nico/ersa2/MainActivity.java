package com.example.nico.ersa2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String ServerURL = "https://temerarious-fleet.000webhostapp.com/insert.php" ;
    EditText Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10;
    Button button;
    String TempQ1, TempQ2, TempQ3, TempQ4, TempQ5, TempQ6, TempQ7, TempQ8, TempQ9, TempQ10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Q1 = (EditText)findViewById(R.id.text1);
        Q2 = (EditText)findViewById(R.id.text2);
        Q3 = (EditText)findViewById(R.id.text3);
        Q4 = (EditText)findViewById(R.id.text4);
        Q5 = (EditText)findViewById(R.id.text5);
        Q6 = (EditText)findViewById(R.id.text6);
        Q7 = (EditText)findViewById(R.id.text7);
        Q8 = (EditText)findViewById(R.id.text8);
        Q9 = (EditText)findViewById(R.id.text9);
        Q10 = (EditText)findViewById(R.id.text10);
        button = (Button)findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetData();

                InsertData(TempQ1, TempQ2, TempQ3, TempQ4, TempQ5, TempQ6, TempQ7, TempQ8, TempQ9, TempQ10);

            }
        });
    }

    public void GetData(){

        TempQ1 = Q1.getText().toString();
        TempQ2 = Q2.getText().toString();
        TempQ3 = Q3.getText().toString();
        TempQ4 = Q4.getText().toString();
        TempQ5 = Q5.getText().toString();
        TempQ6 = Q6.getText().toString();
        TempQ7 = Q7.getText().toString();
        TempQ8 = Q8.getText().toString();
        TempQ9 = Q9.getText().toString();
        TempQ10 = Q10.getText().toString();

    }

    public void InsertData(final String Q1, final String Q2, final String Q3, final String Q4, final String Q5, final String Q6, final String Q7, final String Q8, final String Q9, final String Q10){

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String RQ1 = Q1 ;
                String RQ2 = Q2 ;
                String RQ3 = Q3 ;
                String RQ4 = Q4 ;
                String RQ5 = Q5 ;
                String RQ6 = Q6 ;
                String RQ7 = Q7 ;
                String RQ8 = Q8 ;
                String RQ9 = Q9 ;
                String RQ10 = Q10 ;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("Q1", RQ1));
                nameValuePairs.add(new BasicNameValuePair("Q2", RQ2));
                nameValuePairs.add(new BasicNameValuePair("Q3", RQ3));
                nameValuePairs.add(new BasicNameValuePair("Q4", RQ4));
                nameValuePairs.add(new BasicNameValuePair("Q5", RQ5));
                nameValuePairs.add(new BasicNameValuePair("Q6", RQ6));
                nameValuePairs.add(new BasicNameValuePair("Q7", RQ7));
                nameValuePairs.add(new BasicNameValuePair("Q8", RQ8));
                nameValuePairs.add(new BasicNameValuePair("Q9", RQ9));
                nameValuePairs.add(new BasicNameValuePair("Q10", RQ10));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(ServerURL);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Inserted Successfully";
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

                Toast.makeText(MainActivity.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10);
    }

}