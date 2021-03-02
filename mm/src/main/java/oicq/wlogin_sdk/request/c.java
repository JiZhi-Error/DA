package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public final class c {
    TreeMap<Long, WloginAllSigInfo> Uck = new TreeMap<>();
    Context _context;

    public c(Context context) {
        AppMethodBeat.i(88054);
        this._context = context;
        AppMethodBeat.o(88054);
    }

    public final synchronized int a(long j2, long j3, long j4, long j5, long j6, long j7, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[] bArr13, byte[] bArr14, byte[] bArr15, byte[] bArr16, byte[][] bArr17) {
        WloginAllSigInfo wloginAllSigInfo;
        byte[] bArr18;
        int put_siginfo;
        WloginSigInfo wloginSigInfo;
        AppMethodBeat.i(88055);
        WloginAllSigInfo wloginAllSigInfo2 = this.Uck.get(new Long(j2));
        if (wloginAllSigInfo2 == null) {
            wloginAllSigInfo = new WloginAllSigInfo();
        } else {
            wloginAllSigInfo = wloginAllSigInfo2;
        }
        byte[] bArr19 = new byte[0];
        WloginSigInfo wloginSigInfo2 = wloginAllSigInfo._tk_map.get(new Long(j3));
        if (wloginSigInfo2 == null || wloginSigInfo2._en_A1 == null) {
            bArr18 = bArr19;
        } else {
            bArr18 = (byte[]) wloginSigInfo2._en_A1.clone();
        }
        wloginAllSigInfo._useInfo = new WloginSimpleInfo(j2, bArr, bArr2, bArr3, bArr4);
        put_siginfo = wloginAllSigInfo.put_siginfo(j3, j4, j5, j6, j7, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17);
        util.buY("before put_siginfo, ret=".concat(String.valueOf(put_siginfo)));
        if (this._context != null) {
            TreeMap dd = dd(this._context, "tk_file");
            if (dd == null) {
                dd = new TreeMap();
            }
            util.buY("after loadTKTreeMap");
            dd.put(new Long(j2), wloginAllSigInfo.get_clone());
            put_siginfo = a(dd, "tk_file");
            util.buY("after refreshTKTreeMap, ret=".concat(String.valueOf(put_siginfo)));
        }
        if (!(put_siginfo == 0 || (wloginSigInfo = wloginAllSigInfo._tk_map.get(new Long(j3))) == null)) {
            wloginSigInfo._en_A1 = (byte[]) bArr18.clone();
        }
        this.Uck.put(new Long(j2), wloginAllSigInfo);
        AppMethodBeat.o(88055);
        return put_siginfo;
    }

    private synchronized WloginAllSigInfo Pt(long j2) {
        WloginAllSigInfo wloginAllSigInfo;
        AppMethodBeat.i(88056);
        util.oF("get_all_siginfo", "uin=".concat(String.valueOf(j2)));
        wloginAllSigInfo = this.Uck.get(new Long(j2));
        if (wloginAllSigInfo != null) {
            AppMethodBeat.o(88056);
        } else if (this._context == null) {
            AppMethodBeat.o(88056);
            wloginAllSigInfo = null;
        } else {
            TreeMap dd = dd(this._context, "tk_file");
            if (dd == null) {
                AppMethodBeat.o(88056);
                wloginAllSigInfo = null;
            } else {
                WloginAllSigInfo wloginAllSigInfo2 = (WloginAllSigInfo) dd.get(new Long(j2));
                if (wloginAllSigInfo2 == null) {
                    util.oF("get_all_siginfo", BuildConfig.COMMAND);
                    AppMethodBeat.o(88056);
                    wloginAllSigInfo = null;
                } else {
                    this.Uck.put(new Long(j2), wloginAllSigInfo2);
                    wloginAllSigInfo = wloginAllSigInfo2.get_clone();
                    AppMethodBeat.o(88056);
                }
            }
        }
        return wloginAllSigInfo;
    }

    public final synchronized WloginSigInfo aO(long j2, long j3) {
        WloginSigInfo wloginSigInfo;
        AppMethodBeat.i(209827);
        util.oF("get_siginfo", "uin=" + j2 + "appid=522017402");
        WloginAllSigInfo Pt = Pt(j2);
        if (Pt == null) {
            AppMethodBeat.o(209827);
            wloginSigInfo = null;
        } else {
            wloginSigInfo = Pt._tk_map.get(522017402L);
            if (wloginSigInfo == null) {
                AppMethodBeat.o(209827);
                wloginSigInfo = null;
            } else {
                AppMethodBeat.o(209827);
            }
        }
        return wloginSigInfo;
    }

    public final synchronized void q(Long l) {
        AppMethodBeat.i(88058);
        this.Uck.remove(l);
        if (this._context != null) {
            TreeMap dd = dd(this._context, "tk_file");
            if (dd == null) {
                AppMethodBeat.o(88058);
            } else {
                dd.remove(l);
                a(dd, "tk_file");
            }
        }
        AppMethodBeat.o(88058);
    }

    private synchronized int a(TreeMap treeMap, String str) {
        int i2;
        AppMethodBeat.i(88059);
        i2 = 0;
        if (str == "tk_file") {
            i2 = b(treeMap, str);
        }
        AppMethodBeat.o(88059);
        return i2;
    }

    private synchronized int b(TreeMap treeMap, String str) {
        int i2;
        AppMethodBeat.i(88060);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(i.UcM, "DESede");
            Cipher instance = Cipher.getInstance("DESede");
            instance.init(1, secretKeySpec);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new CipherOutputStream(byteArrayOutputStream, instance));
            objectOutputStream.writeObject(treeMap);
            objectOutputStream.close();
            i2 = a(this._context, str, byteArrayOutputStream.toByteArray());
        } catch (Exception e2) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
            e2.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            util.oG("exception", stringWriter.toString());
            i2 = -1022;
        }
        AppMethodBeat.o(88060);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0095 A[SYNTHETIC, Splitter:B:19:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d6 A[SYNTHETIC, Splitter:B:32:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0118 A[SYNTHETIC, Splitter:B:45:0x0118] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0159 A[SYNTHETIC, Splitter:B:54:0x0159] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.TreeMap dd(android.content.Context r7, java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: oicq.wlogin_sdk.request.c.dd(android.content.Context, java.lang.String):java.util.TreeMap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(android.content.Context r12, java.lang.String r13, byte[] r14) {
        /*
        // Method dump skipped, instructions count: 262
        */
        throw new UnsupportedOperationException("Method not decompiled: oicq.wlogin_sdk.request.c.a(android.content.Context, java.lang.String, byte[]):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] de(android.content.Context r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 184
        */
        throw new UnsupportedOperationException("Method not decompiled: oicq.wlogin_sdk.request.c.de(android.content.Context, java.lang.String):byte[]");
    }
}
