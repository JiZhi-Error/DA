package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class h {

    /* renamed from: a  reason: collision with root package name */
    protected static final char[] f2249a = "0123456789abcdef".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static String f2250b = "";

    /* renamed from: c  reason: collision with root package name */
    private static byte[] f2251c = null;

    /* renamed from: f  reason: collision with root package name */
    private static h f2252f = null;

    /* renamed from: g  reason: collision with root package name */
    private static String f2253g;

    /* renamed from: d  reason: collision with root package name */
    private Cipher f2254d = null;

    /* renamed from: e  reason: collision with root package name */
    private Cipher f2255e = null;

    static {
        AppMethodBeat.i(54030);
        AppMethodBeat.o(54030);
    }

    private h() {
        AppMethodBeat.i(54023);
        f2253g = String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000) + String.valueOf(new Random().nextInt(89999999) + 10000000);
        String str = "00000000";
        for (int i2 = 0; i2 < 12; i2++) {
            str = str + String.valueOf(new Random().nextInt(89999999) + 10000000);
        }
        f2251c = (str + f2253g).getBytes();
        this.f2254d = Cipher.getInstance("RSA/ECB/NoPadding");
        this.f2254d.init(1, KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcEQ3TCNWPBqgIiY7WQ/IqTOTTV2w8aZ/GPm68FK0fAJBemZKtYR3Li46VJ+Hwnor7ZpQnblGWPFaLv5JoPqvavgB0GInuhm+T+syPs1mw0uPLWaqwvZsCfoaIvUuxy5xHJgmWARrK4/9pHyDxRlZte0PCIoR1ko5B8lVVH1X1dQIDAQAB".getBytes(), 0))));
        f2250b = b(this.f2254d.doFinal(f2251c));
        SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f2253g.getBytes()));
        this.f2255e = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        this.f2255e.init(1, generateSecret);
        AppMethodBeat.o(54023);
    }

    public static h a() {
        h hVar = null;
        AppMethodBeat.i(54024);
        try {
            if (f2252f == null) {
                f2252f = new h();
            }
            hVar = f2252f;
            AppMethodBeat.o(54024);
        } catch (Exception e2) {
            f2252f = null;
            AppMethodBeat.o(54024);
        }
        return hVar;
    }

    public byte[] a(byte[] bArr) {
        AppMethodBeat.i(54025);
        byte[] doFinal = this.f2255e.doFinal(bArr);
        AppMethodBeat.o(54025);
        return doFinal;
    }

    public static String b(byte[] bArr) {
        AppMethodBeat.i(54026);
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            cArr[i2 * 2] = f2249a[i3 >>> 4];
            cArr[(i2 * 2) + 1] = f2249a[i3 & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.o(54026);
        return str;
    }

    public byte[] c(byte[] bArr) {
        AppMethodBeat.i(54027);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(f2253g.getBytes()));
            Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(2, generateSecret);
            byte[] doFinal = instance.doFinal(bArr);
            AppMethodBeat.o(54027);
            return doFinal;
        } catch (Exception e2) {
            AppMethodBeat.o(54027);
            return null;
        }
    }

    public String b() {
        return f2250b;
    }

    public static byte[] a(byte[] bArr, String str) {
        AppMethodBeat.i(54028);
        SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
        Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        instance.init(1, generateSecret);
        byte[] doFinal = instance.doFinal(bArr);
        AppMethodBeat.o(54028);
        return doFinal;
    }

    public static byte[] b(byte[] bArr, String str) {
        AppMethodBeat.i(54029);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(str.getBytes()));
            Cipher instance = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            instance.init(2, generateSecret);
            byte[] doFinal = instance.doFinal(bArr);
            AppMethodBeat.o(54029);
            return doFinal;
        } catch (Exception e2) {
            AppMethodBeat.o(54029);
            return null;
        }
    }

    public static String c() {
        return f2253g;
    }
}
