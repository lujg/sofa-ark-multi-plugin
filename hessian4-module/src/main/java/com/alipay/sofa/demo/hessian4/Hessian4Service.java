/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.sofa.demo.hessian4;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author qilong.zql
 */
public class Hessian4Service {

    public byte[] serialize(Object obj) throws IOException {
        if(obj==null) throw new NullPointerException();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(os);
        System.out.println("HessianOutput is from: " + ho.getClass().getProtectionDomain().getCodeSource().getLocation());
        ho.writeObject(obj);
        return os.toByteArray();
    }

    public Object deserialize(byte[] by) throws IOException {
        if(by==null) throw new NullPointerException();

        ByteArrayInputStream is = new ByteArrayInputStream(by);
        HessianInput hi = new HessianInput(is);
        System.out.println("HessianOutput is from: " + hi.getClass().getProtectionDomain().getCodeSource().getLocation());
        return hi.readObject();
    }

}