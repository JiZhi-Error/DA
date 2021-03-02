package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class j {
    public static int Brw = 100;
    public String Brx = null;
    private int maxCount = Brw;

    public j(String str, int i2) {
        AppMethodBeat.i(122667);
        Log.i("Msg.Plugin.HttpRequestCache", "HttpRequestCache constructor, path = " + str + ", maxCount = " + i2);
        this.Brx = str;
        s.boN(this.Brx);
        this.maxCount = i2 <= 0 ? Brw : i2;
        AppMethodBeat.o(122667);
    }

    static String J(String str, Map<String, String> map) {
        AppMethodBeat.i(122670);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append(entry.getValue());
            }
        }
        String messageDigest = g.getMessageDigest(stringBuffer.toString().getBytes());
        AppMethodBeat.o(122670);
        return messageDigest;
    }

    static byte[] aKC(String str) {
        AppMethodBeat.i(122671);
        byte[] bytes = g.getMessageDigest(str.toString().getBytes()).substring(8, 16).getBytes();
        AppMethodBeat.o(122671);
        return bytes;
    }

    public final void eGm() {
        AppMethodBeat.i(122673);
        String[] list = new o(this.Brx).list();
        if ((list != null ? list.length : 0) < this.maxCount) {
            AppMethodBeat.o(122673);
            return;
        }
        o oVar = null;
        for (String str : new o(this.Brx).list()) {
            oVar = new o(str);
            oVar.lastModified();
        }
        if (oVar.exists()) {
            oVar.delete();
        }
        AppMethodBeat.o(122673);
    }

    static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        AppMethodBeat.i(122674);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, generateSecret, new IvParameterSpec("12345678".getBytes()));
            bArr3 = instance.doFinal(bArr);
        } catch (Exception e2) {
            Log.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
            bArr3 = null;
        }
        AppMethodBeat.o(122674);
        return bArr3;
    }

    static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        AppMethodBeat.i(122675);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec("12345678".getBytes()));
            bArr3 = instance.doFinal(bArr);
        } catch (Exception e2) {
            Log.printErrStackTrace("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
            bArr3 = null;
        }
        AppMethodBeat.o(122675);
        return bArr3;
    }

    public static byte[] readFromFile(String str) {
        AppMethodBeat.i(185979);
        byte[] aW = s.aW(str, 0, -1);
        AppMethodBeat.o(185979);
        return aW;
    }

    public static boolean writeToFile(String str, byte[] bArr) {
        AppMethodBeat.i(122677);
        if (Util.isEqual(s.f(str, bArr, bArr.length), 0)) {
            AppMethodBeat.o(122677);
            return true;
        }
        AppMethodBeat.o(122677);
        return false;
    }
}
