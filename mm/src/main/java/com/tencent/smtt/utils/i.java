package com.tencent.smtt.utils;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.recovery.wx.util.EncryptUtil;
import com.tencent.smtt.sdk.c.a;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f2256a = "0123456789abcdef".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static i f2257b;

    /* renamed from: c  reason: collision with root package name */
    private String f2258c = (this.f2260e + String.valueOf(new Random().nextInt(89999999) + 10000000));

    /* renamed from: d  reason: collision with root package name */
    private String f2259d;

    /* renamed from: e  reason: collision with root package name */
    private String f2260e = String.valueOf(new Random().nextInt(89999999) + 10000000);

    static {
        AppMethodBeat.i(53880);
        AppMethodBeat.o(53880);
    }

    private i() {
        AppMethodBeat.i(53873);
        AppMethodBeat.o(53873);
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            AppMethodBeat.i(53874);
            if (f2257b == null) {
                f2257b = new i();
            }
            iVar = f2257b;
            AppMethodBeat.o(53874);
        }
        return iVar;
    }

    public void b() {
        AppMethodBeat.i(53875);
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
        AppMethodBeat.o(53875);
    }

    public String c() {
        AppMethodBeat.i(53876);
        if (this.f2259d == null) {
            byte[] bytes = this.f2258c.getBytes();
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e2) {
                try {
                    b();
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception e3) {
                }
            }
            cipher.init(1, KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.f2259d = b(cipher.doFinal(bytes));
        }
        String str = this.f2259d;
        AppMethodBeat.o(53876);
        return str;
    }

    public String a(String str) {
        AppMethodBeat.i(53877);
        byte[] bytes = str.getBytes();
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        } catch (Exception e2) {
            try {
                b();
                cipher = Cipher.getInstance("RSA/ECB/NoPadding");
            } catch (Exception e3) {
            }
        }
        cipher.init(1, KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
        String b2 = b(cipher.doFinal(bytes));
        AppMethodBeat.o(53877);
        return b2;
    }

    public byte[] a(byte[] bArr) {
        AppMethodBeat.i(53878);
        byte[] a2 = a.a(this.f2260e.getBytes(), bArr, 1);
        AppMethodBeat.o(53878);
        return a2;
    }

    private String b(byte[] bArr) {
        AppMethodBeat.i(53879);
        char[] cArr = new char[(bArr.length * 2)];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            cArr[i2 * 2] = f2256a[i3 >>> 4];
            cArr[(i2 * 2) + 1] = f2256a[i3 & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.o(53879);
        return str;
    }
}
