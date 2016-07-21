/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.ws;

import com.seguriboxltv.core.domain.AlgorithmHash;
import com.seguriboxltv.core.service.AlgorithmCryptModuleService;
import com.seguriboxltv.core.service.AlgorithmHashService;
import com.seguridata.crypto.bean.HashAlgs;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//Clase del webservice que presenta las siguientes rutas.
//http://localhost:8080/SeguriboxLTVWebServices/algorithms/sdhash -presenta en JSON los hash de la apiCrypetmodule metodo-GET
//http://localhost:8080/SeguriboxLTVWebServices/algorithms/hash -presenta en JSON los assymetricAlgorihm metodo-GET
//http://localhost:8080/SeguriboxLTVWebServices/algorithms/hash/1 -presenta en JSON los assymetricAlgorihm por id metodo-GET
@RestController
@RequestMapping("/algorithms")
public class AlgorithmHashRest {

    @Autowired
    AlgorithmCryptModuleService algorithmCryptModuleService;

    @Autowired
    AlgorithmHashService algorithmHashService;

    @RequestMapping(value = "/sdhash", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<List<HashAlgs>> getAllSDHash() {
        List<HashAlgs> list = null;
        try {
            list = algorithmCryptModuleService.GetSDAlgorithmHash();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/hash", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<List<AlgorithmHash>> getAllDBHash() {

        List<AlgorithmHash> list = null;

        try {
            list = algorithmHashService.GetAll();
        } catch (Exception e) {
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/hash/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<AlgorithmHash> getById(@PathVariable("id") int id) {
        AlgorithmHash algorithmHash = null;
        try {
            algorithmHash = algorithmHashService.GetById(id);
        } catch (Exception e) {
        }

        return new ResponseEntity<>(algorithmHash,HttpStatus.OK);
    }

}
