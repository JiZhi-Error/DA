package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static Map<String, a> DUD = new ConcurrentHashMap();
    private static volatile long DUE = 0;

    static {
        AppMethodBeat.i(96202);
        AppMethodBeat.o(96202);
    }

    private static void fcr() {
        AppMethodBeat.i(96197);
        synchronized (DUD) {
            try {
                if (Util.ticksToNow(DUE) > 120000) {
                    DUE = Util.currentTicks();
                    DUD.clear();
                    AppMethodBeat.o(96197);
                }
            } finally {
                AppMethodBeat.o(96197);
            }
        }
    }

    private static String aPP(String str) {
        AppMethodBeat.i(96198);
        int indexOf = str.indexOf(63);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        int indexOf2 = str.indexOf("://");
        if (indexOf2 >= 0) {
            str = str.substring(indexOf2 + 3);
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 >= 0) {
            String substring = str.substring(indexOf3 + 1);
            AppMethodBeat.o(96198);
            return substring;
        }
        AppMethodBeat.o(96198);
        return str;
    }

    public static void c(String str, String str2, int i2, int i3, int i4, long j2) {
        AppMethodBeat.i(96199);
        try {
            b bVar = new b((byte) 0);
            bVar.DUF = aPP(str);
            bVar.mMimeType = str2;
            bVar.mWidth = i2;
            bVar.mHeight = i3;
            bVar.DUH = i4;
            bVar.baM = j2;
            StringBuilder sb = new StringBuilder(1024);
            sb.append(bVar.DUF).append(',').append(bVar.mMimeType).append(',').append(bVar.mWidth).append(',').append(bVar.mHeight).append(',').append(bVar.DUH).append(',').append(bVar.baM);
            String sb2 = sb.toString();
            Log.i("MicroMsg.SnsImgStats", "report up: ".concat(String.valueOf(sb2)));
            h.INSTANCE.kvStat(13512, sb2);
            AppMethodBeat.o(96199);
        } catch (Exception e2) {
            AppMethodBeat.o(96199);
        }
    }

    public static void a(String str, String str2, int i2, String str3, int i3, int i4, int i5, long j2, long j3) {
        AppMethodBeat.i(96200);
        try {
            a aVar = new a((byte) 0);
            aVar.DUF = aPP(str2);
            aVar.DUG = i2;
            aVar.mMimeType = str3;
            aVar.mWidth = i3;
            aVar.mHeight = i4;
            aVar.DUH = i5;
            aVar.baM = j2;
            aVar.DUI = j3;
            DUD.put(str, aVar);
            AppMethodBeat.o(96200);
        } catch (Exception e2) {
            AppMethodBeat.o(96200);
        }
    }

    public static void bn(String str, long j2) {
        AppMethodBeat.i(96201);
        try {
            a remove = DUD.remove(str);
            if (remove != null) {
                remove.DUJ = j2;
                StringBuilder sb = new StringBuilder(1024);
                sb.append(remove.DUF).append(',').append(remove.DUG).append(',').append(remove.mMimeType).append(',').append(remove.mWidth).append(',').append(remove.mHeight).append(',').append(remove.DUH).append(',').append(remove.baM).append(',').append(remove.DUI).append(',').append(remove.DUJ);
                String sb2 = sb.toString();
                Log.i("MicroMsg.SnsImgStats", "report dl: ".concat(String.valueOf(sb2)));
                h.INSTANCE.kvStat(13513, sb2);
                fcr();
                AppMethodBeat.o(96201);
            }
        } catch (Exception e2) {
        } finally {
            fcr();
            AppMethodBeat.o(96201);
        }
    }

    static class b {
        String DUF;
        int DUH;
        long baM;
        int mHeight;
        String mMimeType;
        int mWidth;

        private b() {
            this.DUF = "";
            this.mMimeType = "";
            this.mWidth = -1;
            this.mHeight = -1;
            this.DUH = -1;
            this.baM = -1;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String DUF;
        int DUG;
        int DUH;
        long DUI;
        long DUJ;
        long baM;
        int mHeight;
        String mMimeType;
        int mWidth;

        private a() {
            this.DUF = "";
            this.DUG = 0;
            this.mMimeType = "";
            this.mWidth = -1;
            this.mHeight = -1;
            this.DUH = -1;
            this.baM = -1;
            this.DUI = -1;
            this.DUJ = -1;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
