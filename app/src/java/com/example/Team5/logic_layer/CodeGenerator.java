package com.example.Team5.logic_layer;

/**
 * Created by SpeedGrapher on 7/18/2016.
 * Don't touch this class.
 */

import java.security.SecureRandom;
import java.math.BigInteger;

/**
 *
 */
public final class CodeGenerator {
    private SecureRandom random = new SecureRandom();

    public String getCode() {
        return new BigInteger(30, random).toString(32); //returns a code of length 6. 30 / 5 (32=2^5).
    }
}
