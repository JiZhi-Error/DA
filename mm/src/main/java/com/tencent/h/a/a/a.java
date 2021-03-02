package com.tencent.h.a.a;

import android.os.Build;
import android.text.TextUtils;
import com.qq.a.a.c;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import d.d;
import d.e;
import java.util.ArrayList;

public final class a {
    private static final byte[] SpK = new byte[1];

    /* renamed from: com.tencent.h.a.a.a$a  reason: collision with other inner class name */
    public static class C0140a {
        public String SpL;
        public String SpM;
        public long SpN;
        public String SpO;
        public String mProcessName;
        public String mThreadName;
    }

    public static class b {
        public String SpP;
        public String SpQ;
        public String mSdkVersion;
        public String rcD;
    }

    public static String p(Throwable th) {
        AppMethodBeat.i(214603);
        if (th == null) {
            AppMethodBeat.o(214603);
            return "";
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            AppMethodBeat.o(214603);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement != null) {
                sb.append(stackTraceElement.getClassName());
                sb.append("(");
                sb.append(stackTraceElement.getMethodName());
                sb.append(":");
                sb.append(stackTraceElement.getLineNumber());
                sb.append(")");
                sb.append("\n");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(214603);
        return sb2;
    }

    public static int bqY(String str) {
        AppMethodBeat.i(214604);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(214604);
            return -1;
        }
        int abs = Math.abs(str.hashCode());
        AppMethodBeat.o(214604);
        return abs;
    }

    public static byte[] bB(ArrayList<d> arrayList) {
        AppMethodBeat.i(214605);
        if (arrayList == null || arrayList.isEmpty()) {
            AppMethodBeat.o(214605);
            return null;
        }
        e eVar = new e();
        eVar.dtS = arrayList;
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        eVar.writeTo(jceOutputStream);
        byte[] byteArray = jceOutputStream.toByteArray();
        AppMethodBeat.o(214605);
        return byteArray;
    }

    public static byte[] a(b bVar, byte[] bArr) {
        AppMethodBeat.i(214606);
        if (TextUtils.isEmpty(bVar.rcD) || TextUtils.isEmpty(bVar.SpP) || bArr == null) {
            AppMethodBeat.o(214606);
            return null;
        }
        c cVar = new c();
        cVar.cz("analytics");
        cVar.IK();
        cVar.cy("uploadServer");
        b.a aVar = new b.a();
        aVar.SKS = 1;
        aVar.productId = bVar.rcD;
        aVar.SKU = bVar.SpP;
        aVar.sdkId = bVar.SpQ;
        aVar.dfy = bVar.mSdkVersion;
        aVar.EX = 206;
        try {
            byte[] zip = f.a.a.a.a.hPj().zip(bArr);
            if (zip != null) {
                aVar.SKX = 2;
            }
            f.a.a.b.a aVar2 = new f.a.a.b.a();
            aVar2.buV("*^@K#K@!");
            try {
                byte[] encode = aVar2.encode(zip);
                if (encode != null) {
                    aVar.SKQ = 1;
                }
                aVar.sBuffer = encode;
                aVar.SKR = Build.BRAND + "-" + Build.MODEL + ";Android " + Build.VERSION.RELEASE + ",level " + Build.VERSION.SDK_INT;
                aVar.qua = "";
                cVar.put("detail", aVar);
                byte[] IJ = cVar.IJ();
                AppMethodBeat.o(214606);
                return IJ;
            } catch (Throwable th) {
                byte[] bArr2 = SpK;
                AppMethodBeat.o(214606);
                return bArr2;
            }
        } catch (Throwable th2) {
            byte[] bArr3 = SpK;
            AppMethodBeat.o(214606);
            return bArr3;
        }
    }
}
