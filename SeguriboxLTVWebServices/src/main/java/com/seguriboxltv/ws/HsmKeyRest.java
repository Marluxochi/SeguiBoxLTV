/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.ws;

import com.seguriboxltv.core.domain.Hsmkey;
import com.seguriboxltv.core.service.HsmKeyService;
import com.seguridata.hsm.bean.HSMKey;
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
//http://localhost:8080/SeguriboxLTVWebServices/hsmkeyapi/sdhsmkey -presenta en JSON los hash de la apiCrypetmodule metodo-GET
//http://localhost:8080/SeguriboxLTVWebServices/hsmkeyapi/hsmkey -presenta en JSON los hsmkeyAlgorihm metodo-GET
//http://localhost:8080/SeguriboxLTVWebServices/hsmkeyapi/hsmkey/1 -presenta en JSON los hsmkeyAlgorihm por id metodo-GET
@RestController
@RequestMapping("/hsmkeyapi")
public class HsmKeyRest {

    @Autowired
    HsmKeyService hsmKeyService;

    @RequestMapping(value = "/sdhsmkey", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<List<HSMKey>> getAllHsmKey() {
        List<HSMKey> list = null;

        try {
            list = hsmKeyService.SDGetAll();
        } catch (Exception e) {
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/hsmkey", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<List<Hsmkey>> getAllDBHsmKey() {
        List<Hsmkey> list = null;

        try {
            list = hsmKeyService.GetAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/hsmkey/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<Hsmkey> getById(@PathVariable("id") int id) {
        Hsmkey hsmkey = null;

        try {
            hsmkey = hsmKeyService.GetById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(hsmkey, HttpStatus.OK);
    }

}
