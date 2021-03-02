package com.tencent.mm.plugin.secinforeport;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.normsg.c;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.ac;
import com.tencent.mm.protocal.protobuf.dnd;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;

enum c implements com.tencent.mm.plugin.secinforeport.a.c {
    INSTANCE;

    public static c valueOf(String str) {
        AppMethodBeat.i(89172);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(89172);
        return cVar;
    }

    static {
        AppMethodBeat.i(89181);
        AppMethodBeat.o(89181);
    }

    static final class a {
        private static final Map<Integer, Long> CWC = new HashMap();

        static {
            AppMethodBeat.i(89170);
            AppMethodBeat.o(89170);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0051 A[SYNTHETIC, Splitter:B:18:0x0051] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0077 A[SYNTHETIC, Splitter:B:29:0x0077] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00c1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static synchronized void vC() {
            /*
            // Method dump skipped, instructions count: 209
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.secinforeport.c.a.vC():void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0084 A[SYNTHETIC, Splitter:B:22:0x0084] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00b9 A[SYNTHETIC, Splitter:B:41:0x00b9] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00c3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static synchronized void save() {
            /*
            // Method dump skipped, instructions count: 212
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.secinforeport.c.a.save():void");
        }

        static synchronized boolean aF(int i2, long j2) {
            boolean z;
            synchronized (a.class) {
                AppMethodBeat.i(89169);
                if (j2 < 0) {
                    Log.w("MicroMsg.SecInfoReporterImpl", "bad interval: %s", Long.valueOf(j2));
                    AppMethodBeat.o(89169);
                    z = false;
                } else {
                    if (!CWC.containsKey(Integer.valueOf(i2))) {
                        vC();
                    }
                    Long l = CWC.get(Integer.valueOf(i2));
                    long currentTimeMillis = System.currentTimeMillis();
                    if (l == null || currentTimeMillis < l.longValue()) {
                        CWC.put(Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
                        save();
                        if (l == null) {
                            AppMethodBeat.o(89169);
                            z = true;
                        } else {
                            AppMethodBeat.o(89169);
                            z = false;
                        }
                    } else if (currentTimeMillis - l.longValue() > j2) {
                        CWC.put(Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
                        save();
                        AppMethodBeat.o(89169);
                        z = true;
                    } else {
                        AppMethodBeat.o(89169);
                        z = false;
                    }
                }
            }
            return z;
        }
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final boolean aF(int i2, long j2) {
        AppMethodBeat.i(89173);
        boolean aF = a.aF(i2, j2);
        Log.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReport called, res: %s", Boolean.valueOf(aF));
        AppMethodBeat.o(89173);
        return aF;
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final boolean aG(int i2, long j2) {
        boolean z;
        AppMethodBeat.i(89174);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(new StringBuilder("gsmron").reverse().append(new StringBuilder("atadtsurt_").reverse().toString()).toString());
        long j3 = mmkv.getLong(String.format("%s", Integer.valueOf(i2)), 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (j3 == 0 || currentTimeMillis < j3) {
            mmkv.putLong(String.format("%s", Integer.valueOf(i2)), currentTimeMillis).apply();
            z = j3 == 0;
        } else if (currentTimeMillis - j3 > j2) {
            mmkv.putLong(String.format("%s", Integer.valueOf(i2)), currentTimeMillis).apply();
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReport2 called, res: %s", Boolean.valueOf(z));
        AppMethodBeat.o(89174);
        return z;
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void eSt() {
        AppMethodBeat.i(89175);
        byte[] aa = c.p.aa(40, 0);
        if (aa != null) {
            try {
                ewf ewf = new ewf();
                ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(aa);
                Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d in yap", Integer.valueOf(aa.length)));
                r(540999683, ewf.toByteArray());
            } catch (Throwable th) {
            }
            Log.i("MicroMsg.SecInfoReporterImpl", "[+] report yap through cgi, type: sec");
            AppMethodBeat.o(89175);
            return;
        }
        Log.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
        AppMethodBeat.o(89175);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void Xi(int i2) {
        AppMethodBeat.i(214398);
        byte[] aa = c.p.aa(32, 0);
        if (aa != null) {
            try {
                ewf ewf = new ewf();
                ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(aa);
                Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d ctx=%d in finder", Integer.valueOf(aa.length), Integer.valueOf(i2)));
                r(i2, ewf.toByteArray());
            } catch (Throwable th) {
            }
            Log.i("MicroMsg.SecInfoReporterImpl", "[+] report finder through cgi, type: sec");
            AppMethodBeat.o(214398);
            return;
        }
        Log.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
        AppMethodBeat.o(214398);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void asyncReportPaySecurityInfoThroughCgi() {
        AppMethodBeat.i(89176);
        EventCenter.instance.publish(new ru());
        AppMethodBeat.o(89176);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void asyncReportFinderSecurityInfoThroughCgi(int i2) {
        AppMethodBeat.i(214399);
        rt rtVar = new rt();
        rtVar.dYo.dYp = i2;
        EventCenter.instance.publish(rtVar);
        AppMethodBeat.o(214399);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void u(String str, byte[] bArr) {
        AppMethodBeat.i(214400);
        if (str == null || bArr == null || bArr.length == 0) {
            Log.e("MicroMsg.SecInfoReporterImpl", "[-] behaviorID or data is null.");
            AppMethodBeat.o(214400);
            return;
        }
        try {
            ewf ewf = new ewf();
            ewf.NtV = new SKBuiltinBuffer_t().setBuffer(str.getBytes());
            ewf.NtW = new SKBuiltinBuffer_t().setBuffer(bArr);
            r(540999687, ewf.toByteArray());
            Log.i("MicroMsg.SecInfoReporterImpl", "[+] report sensor scene info through cgi, len: %d, type: sec", Integer.valueOf(bArr.length));
            AppMethodBeat.o(214400);
        } catch (Throwable th) {
            AppMethodBeat.o(214400);
        }
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void ca(byte[] bArr) {
        AppMethodBeat.i(214401);
        if (bArr == null || bArr.length == 0) {
            Log.w("MicroMsg.SecInfoReporterImpl", "[-] turingOwnerData is null.");
            AppMethodBeat.o(214401);
            return;
        }
        try {
            aaq aaq = new aaq();
            aaq.LlW = new b("".getBytes());
            aaq.type = 1;
            aaq.LlX = new b(bArr);
            aaq.dataType = 2;
            aaq.timestamp = System.currentTimeMillis() / 1000;
            aaq.status = 0;
            ewf ewf = new ewf();
            ewf.NtX = new SKBuiltinBuffer_t().setBuffer(aaq.toByteArray());
            r(0, ewf.toByteArray());
            Log.i("MicroMsg.SecInfoReporterImpl", "[+] report turing owner through cgi, len: %d, type: sec", Integer.valueOf(bArr.length));
            AppMethodBeat.o(214401);
        } catch (Throwable th) {
            Log.e("MicroMsg.SecInfoReporterImpl", "[-] report turing owner error");
            AppMethodBeat.o(214401);
        }
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void Xj(int i2) {
        String[] split;
        AppMethodBeat.i(89178);
        new StringBuilder();
        ac acVar = new ac();
        acVar.oUj = Build.MANUFACTURER;
        acVar.oTJ = Build.MODEL;
        acVar.KCm = Build.VERSION.RELEASE;
        acVar.KCn = Build.VERSION.INCREMENTAL;
        acVar.KCo = Build.DISPLAY;
        if (i2 == -2147483646) {
            acVar.KCp = Build.FINGERPRINT;
            String sv = d.INSTANCE.sv(false);
            if (!TextUtils.isEmpty(sv) && (split = sv.split(",")) != null) {
                for (String str : split) {
                    acVar.KCq.add(str);
                }
            }
        }
        try {
            byte[] byteArray = acVar.toByteArray();
            aaq aaq = new aaq();
            aaq.LlW = new b("".getBytes());
            aaq.type = 1;
            byte[] ab = ab(byteArray, byteArray.length);
            if (ab == null) {
                aaq.LlX = new b("compress data failed".getBytes());
                aaq.dataType = 1;
                aaq.timestamp = System.currentTimeMillis() / 1000;
                aaq.status = 1;
            } else {
                if (ab.length > 5120) {
                    h.INSTANCE.idkeyStat(633, 4, 1, false);
                    Log.d("MicroMsg.SecInfoReporterImpl", "compressed and base64 result is still too large with length " + ab.length);
                }
                aaq.LlX = new b(ab);
                aaq.dataType = 4;
                aaq.timestamp = System.currentTimeMillis() / 1000;
                aaq.status = 0;
            }
            ewf ewf = new ewf();
            ewf.NtS = new SKBuiltinBuffer_t().setBuffer(aaq.toByteArray());
            byte[] byteArray2 = ewf.toByteArray();
            Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] report di info msg: len = %d \n", Integer.valueOf(byteArray2.length)));
            r(i2, byteArray2);
            AppMethodBeat.o(89178);
        } catch (Throwable th) {
            AppMethodBeat.o(89178);
        }
    }

    private static byte[] ab(byte[] bArr, int i2) {
        AppMethodBeat.i(89179);
        if (bArr == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("dataIn is null.");
            AppMethodBeat.o(89179);
            throw illegalArgumentException;
        }
        Deflater deflater = new Deflater();
        deflater.setLevel(9);
        deflater.setInput(bArr, 0, i2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        deflater.finish();
        byte[] bArr2 = new byte[4096];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.SecInfoReporterImpl", e2, "exception when compressing dump maps", new Object[0]);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(89179);
        return byteArray;
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void r(final int i2, byte[] bArr) {
        AppMethodBeat.i(89180);
        if (bArr == null) {
            Log.e("MicroMsg.SecInfoReporterImpl", "data is null.");
            AppMethodBeat.o(89180);
            return;
        }
        d.a aVar = new d.a();
        aVar.uri = com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIJ("Q\u001e\u001b\u0012W\u001b\u0011\u0019Y\u0018\u001d\u0010\u0000\u001e\u001d\u001c\t@\u000e\u0002\u0004F\u001a\u0002\u0016\n\u0016\u0017\u0001\r\t:0)?3?:3");
        aVar.funcId = 771;
        aVar.iLN = new dnd();
        aVar.iLO = new dne();
        com.tencent.mm.ak.d aXF = aVar.aXF();
        dnd dnd = (dnd) aXF.iLK.iLR;
        dnd.dYp = i2;
        dnd.MQx = new b("".getBytes());
        dnd.KLQ = new SKBuiltinBuffer_t().setBuffer(bArr);
        e.INSTANCE.idkeyStat(416, 0, 1, false);
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.plugin.secinforeport.c.AnonymousClass1 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                AppMethodBeat.i(89166);
                if (i2 == 0 && i3 == 0) {
                    Log.i("MicroMsg.SecInfoReporterImpl", "cgireport succ, ctx: %d, stack: %s", Integer.valueOf(i2), Util.getStack().toString());
                    e.INSTANCE.idkeyStat(416, 1, 1, false);
                } else {
                    Log.w("MicroMsg.SecInfoReporterImpl", "cgireport failed, ctx: %d, err: %d:%d %s, stack: %s", Integer.valueOf(i2), Integer.valueOf(i2), Integer.valueOf(i3), str, Util.getStack().toString());
                    e.INSTANCE.idkeyStat(416, 2, 1, false);
                }
                AppMethodBeat.o(89166);
                return 0;
            }
        }, false);
        AppMethodBeat.o(89180);
    }

    @Override // com.tencent.mm.plugin.secinforeport.a.c
    public final void ik(int i2, int i3) {
        AppMethodBeat.i(89177);
        byte[] aa = c.p.aa(i3, 0);
        byte[] exK = com.tencent.mm.plugin.normsg.a.d.INSTANCE.exK();
        if (aa != null) {
            try {
                ewf ewf = new ewf();
                if (exK != null) {
                    aaq aaq = new aaq();
                    aaq.LlW = new b("".getBytes());
                    aaq.type = 1;
                    aaq.LlX = new b(exK);
                    aaq.dataType = 2;
                    aaq.timestamp = System.currentTimeMillis() / 1000;
                    aaq.status = 0;
                    byte[] byteArray = aaq.toByteArray();
                    Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] tur ccd data len = %d", Integer.valueOf(byteArray.length)));
                    ewf.NtT = new SKBuiltinBuffer_t().setBuffer(byteArray);
                } else {
                    Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] tur ccd data is null ", new Object[0]));
                }
                ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(aa);
                Log.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d", Integer.valueOf(aa.length)));
                r(i2, ewf.toByteArray());
            } catch (Throwable th) {
            }
            Log.i("MicroMsg.SecInfoReporterImpl", "[+] report through cgi, type: sec, ctx: %s", Integer.valueOf(i2));
            AppMethodBeat.o(89177);
            return;
        }
        Log.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
        AppMethodBeat.o(89177);
    }
}
