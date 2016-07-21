/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguriboxltv.core.util;

import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Component;

/**
 *
 * @author IngGerman
 */
@Component
public class Util {

    public  String BytesToString(byte[] arrayByte, short codigo) {

        return new String(arrayByte, StandardCharsets.UTF_8);
    }

}
