/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.ws;

import com.seguriboxltv.core.domain.AlgorithmSignSymm;
import com.seguriboxltv.core.service.AlgorithmCryptModuleService;
import com.seguriboxltv.core.service.AlgorithmHashService;
import com.seguriboxltv.core.service.AlgorithmSignSymmService;
import com.seguridata.crypto.bean.AssymetricAlgs;
import com.seguridata.crypto.bean.SymmetricAlgs;
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
//http://localhost:8080/SeguriboxLTVWebServices/algorithms/sdsymetric -presenta en JSON los hash de la apiCrypetmodule metodo-GET
//http://localhost:8080/SeguriboxLTVWebServices/algorithms/symetric -presenta en JSON los assymetricAlgorihm metodo-GET
//http://localhost:8080/SeguriboxLTVWebServices/algorithms/symetric/1 -presenta en JSON los assymetricAlgorihm por id metodo-GET
@RestController
@RequestMapping("/algorithms")
public class AlgorithmSymetricRest {
    @Autowired
    AlgorithmCryptModuleService algorithmCryptModuleService;

    @Autowired
    AlgorithmSignSymmService algorithmHashService;
    
    
    @RequestMapping(value = "/sdsymetric", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<List<SymmetricAlgs>> getAllSDSymetric() {

        List<SymmetricAlgs> list=null;
        try {
            list = algorithmCryptModuleService.GetSDSymmetricAlgs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/symetric", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<List<AlgorithmSignSymm>> getAllBDSymetric() {

        List<AlgorithmSignSymm> list=null;
        try {
            list = algorithmHashService.GetAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/symetric/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<AlgorithmSignSymm> getById(@PathVariable("id")int id) {

        AlgorithmSignSymm algorithmSignSymm=null;
        try {
            algorithmSignSymm = algorithmHashService.Get(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new ResponseEntity<>(algorithmSignSymm,HttpStatus.OK);
    }
    
    
}
