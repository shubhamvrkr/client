package com.cardroid.psl.obdcardroid.NetworkThreads;

import android.os.AsyncTask;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by shubham on 18/2/17.
 */
public class PostData extends AsyncTask<String,String,String> {


    private String engine_RPM,engine_Coolant,engine_Load,MAF_airflow,oil_temp,engine_fuelRate,ppm_sensorRate,dtc_Logged,latitude,longitude;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... fields) {

        engine_RPM = fields[0];
        engine_Coolant= fields[1];
        engine_Load= fields[2];
        MAF_airflow= fields[3];
        oil_temp= fields[4];
        engine_fuelRate= fields[5];
        ppm_sensorRate= fields[6];
        dtc_Logged= fields[7];
        latitude= fields[8];
        longitude= fields[9];

        String url = "https://api.thingspeak.com/update.json?api_key=UV0BCPWW94QWJWMM&field1="+engine_RPM+"&field2="+engine_Coolant+"&field3="+engine_Load+"&field4="+MAF_airflow+"&field5="+oil_temp+"&field6="+engine_fuelRate+"&field7="+ppm_sensorRate+"&field8="+dtc_Logged+"&lat="+latitude+"&long="+longitude;

        try {

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                Log.d("responseCodePost","success");
               /* BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();*/
            } else {
                Log.d("responseCodePost","faliure");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}