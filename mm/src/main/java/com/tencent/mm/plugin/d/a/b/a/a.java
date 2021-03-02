package com.tencent.mm.plugin.d.a.b.a;

import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Serializable;

public abstract class a implements Serializable {
    private static final String TAG = a.class.getName();
    public long phx;
    public String pie;
    public int pif;

    public abstract byte[] ckM();

    public static a aX(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            Log.e(TAG, "data input error");
            return null;
        }
        Object bz = b.bz(bArr);
        if (bz != null && (bz instanceof a)) {
            return (a) bz;
        }
        Log.e(TAG, "bytes2object is not instanceof BaseProfileParser");
        return null;
    }
}
