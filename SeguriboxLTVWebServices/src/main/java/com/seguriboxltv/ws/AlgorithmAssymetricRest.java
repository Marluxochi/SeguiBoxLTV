/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.ws;

import com.seguriboxltv.core.domain.AlgorithmAsymmetric;
import com.seguriboxltv.core.service.AlgorithmAsymmetricService;
import com.seguriboxltv.core.service.AlgorithmCryptModuleService;
import com.seguridata.crypto.bean.AssymetricAlgs;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author IngGerman
 */

//Clase del webservice que presenta las siguientes rutas.
//http://localhost:8080/SeguriboxLTVWebServices/algorithms/sdassymetric -presenta en JSON los assymetricAlgorihm metodo-GET
//http://localhost:8080/SeguriboxLTVWebServices/algorithms/assymetric -presenta en JSON los assymetricAlgorihm metodo-GET
//http://localhost:8080/SeguriboxLTVWebServices/algorithms/assymetric/1 -presenta en JSON los assymetricAlgorihm por id metodo-GET

@RestController
@RequestMapping("/algorithms")
public class AlgorithmAssymetricRest {

    @Autowired
    AlgorithmCryptModuleService algorithmCryptModuleService;

    @Autowired
    AlgorithmAsymmetricService algorithmAsymmetricService;

    @RequestMapping(value = "/sdassymetric", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<List<AssymetricAlgs>> getAllSDAssymetric() {

        List<AssymetricAlgs> list=null;
        try {
            list = algorithmCryptModuleService.GetSDAssymetricAlgs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/assymetric", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<List<AlgorithmAsymmetric>> getAllDBAssymetric() {

        List<AlgorithmAsymmetric> list=null;
        try {
            list = algorithmAsymmetricService.GetAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/assymetric/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<AlgorithmAsymmetric> getById(@PathVariable("id") int id) {

        AlgorithmAsymmetric algorithmAsymmetric=null;
        try {
            algorithmAsymmetric = algorithmAsymmetricService.GetById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new ResponseEntity<>(algorithmAsymmetric,HttpStatus.OK);
    }
}
