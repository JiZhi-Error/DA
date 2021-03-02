package com.tencent.midas.comm.log.util;

public class APBytesUtil {
    public static byte[] int2bytes(int i2) {
        return new byte[]{(byte) (i2 >> 24), (byte) (i2 >> 16), (byte) (i2 >> 8), (byte) i2};
    }
}
