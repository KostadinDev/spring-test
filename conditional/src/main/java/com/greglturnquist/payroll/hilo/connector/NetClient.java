package com.greglturnquist.payroll.hilo.connector;


import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.springframework.http.RequestEntity;

import java.io.*;
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

    public String  callMultiPatrtRequest(String urlString, String filename)
          {
              try {
                  URL url = new URL(urlString);
                  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                  conn.setReadTimeout(10000);
                  conn.setConnectTimeout(15000);
                  conn.setRequestMethod("POST");
                  conn.setUseCaches(false);
                  conn.setDoInput(true);
                  conn.setDoOutput(true);

                  conn.setRequestProperty("Connection", "Keep-Alive");
                  MultipartEntity reqEntity=getRequestEntity(filename);
                  conn.addRequestProperty("Content-length", reqEntity.getContentLength()+"");
                  conn.addRequestProperty(reqEntity.getContentType().getName(), reqEntity.getContentType().getValue());

                  OutputStream os = conn.getOutputStream();
                  reqEntity.writeTo(conn.getOutputStream());
                  os.close();
                  conn.connect();

                  if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                      return readStream(conn.getInputStream());
                  }

              } catch (Exception e) {
                  e.printStackTrace();
              }
              return null;
    }

    private static String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.toString();
    }

    public MultipartEntity getRequestEntity(String filename){


        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        ContentBody contentPart = new ByteArrayBody(bos.toByteArray(), filename);

        MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        reqEntity.addPart(filename, contentPart);
        return reqEntity;
    }


}