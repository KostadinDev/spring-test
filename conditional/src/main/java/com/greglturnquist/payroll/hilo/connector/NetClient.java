package com.greglturnquist.payroll.hilo.connector;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NetClient {


    private static final Logger LOGGER = Logger.getLogger(NetClient.class.getName());

    public String callpost(String urlstring, String input, String bearer, String contentType) {

        StringBuffer jsonresult = new StringBuffer();

        try {

            URL url = new URL(urlstring);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            if (bearer != null) conn.setRequestProperty("Authorization", "Bearer " + bearer);
            conn.setRequestProperty("Content-Type", contentType);
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            //if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
            //	throw new RuntimeException("Failed : HTTP error code : "
            //	+ conn.getResponseCode());
            //}
            if (conn.getResponseCode() != 200)
                LOGGER.log(Level.INFO, "response code method post" + conn.getResponseCode());
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String output;
            while ((output = br.readLine()) != null) {
                jsonresult.append(output);
            }
            conn.disconnect();

        } catch (MalformedURLException e) {

            LOGGER.log(Level.SEVERE, e.getMessage());
            LOGGER.log(Level.SEVERE, "urlsting=" + urlstring);

        } catch (IOException e) {

            LOGGER.log(Level.SEVERE, e.getMessage());
            LOGGER.log(Level.SEVERE, "urlsting=" + urlstring);

        }

        return jsonresult.toString();
    }

    public String callput(String urlstring, String input) {
        StringBuffer jsonresult = new StringBuffer();

        try {

            URL url = new URL(urlstring);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes("UTF-8"));
            os.flush();

            //if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
            //	throw new RuntimeException("Failed : HTTP error code : "
            //	+ conn.getResponseCode());
            //}
            if (conn.getResponseCode() != 200)
                LOGGER.log(Level.INFO, "response code method put" + conn.getResponseCode());

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;

            while ((output = br.readLine()) != null) {
                jsonresult.append(output);
            }
            //	  LOGGER.log(Level.INFO, "jsonresult put="+jsonresult);
            conn.disconnect();

        } catch (MalformedURLException e) {

            LOGGER.log(Level.SEVERE, e.getMessage());
            LOGGER.log(Level.SEVERE, "urlsting=" + urlstring);

        } catch (IOException e) {

            LOGGER.log(Level.SEVERE, e.getMessage());
            LOGGER.log(Level.SEVERE, "urlsting=" + urlstring);

        }

        return jsonresult.toString();
    }


    public String callget(String urlstring) {
        StringBuffer sb = new StringBuffer();

        try {

            URL url = new URL(urlstring);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200)
                LOGGER.log(Level.INFO, "response code method get" + conn.getResponseCode());
		/*	if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
						if(conn.getResponseCode()!=200)
			}
		*/
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));

            String output;

            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            LOGGER.log(Level.SEVERE, e.getMessage());

        } catch (IOException e) {

            LOGGER.log(Level.SEVERE, e.getMessage());

        }
        return sb.toString();

    }

    public String calldelete(String urlstring) {
        StringBuffer sb = new StringBuffer();

        try {

            URL url = new URL(urlstring);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Accept", "application/json");

			/*if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			} */
            if (conn.getResponseCode() != 200)
                LOGGER.log(Level.INFO, "response code methos delete" + conn.getResponseCode());
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));

            String output;

            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            LOGGER.log(Level.SEVERE, e.getMessage());
            LOGGER.log(Level.SEVERE, "urlsting=" + urlstring);

        } catch (IOException e) {

            LOGGER.log(Level.SEVERE, e.getMessage());
            LOGGER.log(Level.SEVERE, "urlsting=" + urlstring);

        }
        return sb.toString();

    }


    public String callpostencoded(String urlstring) {
        StringBuffer sb = new StringBuffer();

        try {

            URL url = new URL(urlstring);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			/* if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			} */
            LOGGER.log(Level.INFO, "response code methos post post" + conn.getResponseCode());
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()), "UTF-8"));

            String output;

            while ((output = br.readLine()) != null) {
                sb.append(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            LOGGER.log(Level.SEVERE, e.getMessage());
        } catch (IOException e) {

            LOGGER.log(Level.SEVERE, e.getMessage());

        }
        return sb.toString();

    }


}