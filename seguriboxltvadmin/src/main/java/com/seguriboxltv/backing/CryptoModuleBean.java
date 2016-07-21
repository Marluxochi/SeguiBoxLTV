/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.backing;

import com.seguriboxltv.core.domain.AlgorithmAsymmetric;
import com.seguriboxltv.core.domain.AlgorithmHash;
import com.seguriboxltv.core.domain.AlgorithmSignSymm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 *
 * @author inggerman
 */
@Component
@ManagedBean
@ApplicationScoped
public class CryptoModuleBean {

    /**
     * Creates a new instance of CryptoModuleBean
     *
     * @return
     */
    public List<AlgorithmSignSymm> getAllSymSing() {
        String json = "";
        List<AlgorithmSignSymm> list = new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8080/seguriboxapi/algorithms/sdsymetric");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;

            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {

                json += output + "\n";
                System.out.println(json);

            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        try {
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                AlgorithmSignSymm ass = new AlgorithmSignSymm();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                byte[] name = jsonObject.getString("name").getBytes();
                byte[] binOid = jsonObject.getString("binOId").getBytes();
                byte[] hashBinAlg = jsonObject.getString("hashBinAlg").getBytes();
                byte[] asymmBinAlg = jsonObject.getString("asymmBinAlg").getBytes();
                ass.setAlgorithmName(jsonObject.getString("name"));
               
                ass.setStrOid(jsonObject.getString("strOId"));
                ass.setBinOid(name);
                ass.setHashBin(binOid);
                ass.setHashBin(hashBinAlg);
                ass.setAsymmBin(asymmBinAlg);
                list.add(ass);

            }

        } catch (JSONException ex) {
            Logger.getLogger(CryptoModuleBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<AlgorithmHash> getAllAlgorithmHash() {
        String json = "";
        List<AlgorithmHash> list = new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8080/seguriboxapi/algorithms/sdhash");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;

            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {

                json += output + "\n";
                System.out.println(json);

            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        try {
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                AlgorithmHash hash = new AlgorithmHash();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                byte[] name = jsonObject.getString("name").getBytes();
                byte[] binOid = jsonObject.getString("binOId").getBytes();
                hash.setAlgorithmName(jsonObject.getString("name"));
                hash.setStrOid(jsonObject.getString("strOId"));
                hash.setBinOid(binOid);
                hash.setBits(Integer.parseInt(jsonObject.getString("bits")));
                hash.setBytes(Integer.parseInt(jsonObject.getString("bytes")));
                hash.setSecure(Integer.parseInt(jsonObject.getString("secure")));
                list.add(hash);

            }

        } catch (JSONException ex) {
            Logger.getLogger(CryptoModuleBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<AlgorithmAsymmetric> getAllAsyme(){
        String json = "";
        List<AlgorithmAsymmetric> list = new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8080/seguriboxapi/algorithms/sdsymetric");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;

            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {

                json += output + "\n";
                System.out.println(json);

            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        try {
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                AlgorithmAsymmetric algorithmAsy = new AlgorithmAsymmetric();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                byte[] binOid = jsonObject.getString("binOId").getBytes();
 
                algorithmAsy.setAlgorithmName(jsonObject.getString("name"));
                algorithmAsy.setStringOid(jsonObject.getString("strOId"));
                algorithmAsy.setBinOid(binOid);
                algorithmAsy.setMinBits(Integer.parseInt(jsonObject.getString("minBits")));
                algorithmAsy.setMaxBits(Integer.parseInt(jsonObject.getString("maxBits")));
                algorithmAsy.setDeltaBits(Integer.parseInt(jsonObject.getString("deltaBits")));
                algorithmAsy.setMinSecureBits(Integer.parseInt(jsonObject.getString("minSecurebits")));
                algorithmAsy.setSecure(Integer.parseInt(jsonObject.getString("secure")));
                      
                
                list.add(algorithmAsy);

            }

        } catch (JSONException ex) {
            Logger.getLogger(CryptoModuleBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }

}
