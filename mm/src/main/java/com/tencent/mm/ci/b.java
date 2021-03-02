package com.tencent.mm.ci;

import android.os.Debug;
import android.os.Environment;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public static final String OvV = (Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/memory/");

    static {
        AppMethodBeat.i(145591);
        AppMethodBeat.o(145591);
    }

    private static boolean gGj() {
        AppMethodBeat.i(145583);
        if (!c.apn()) {
            Log.i("MicroMsg.MemoryDumpManager", "Hprof sdcard is invalid");
            AppMethodBeat.o(145583);
            return false;
        }
        o oVar = new o(OvV);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        AppMethodBeat.o(145583);
        return true;
    }

    private static boolean ba(boolean z, boolean z2) {
        AppMethodBeat.i(145584);
        if (!gGj()) {
            AppMethodBeat.o(145584);
            return false;
        }
        o oVar = new o(OvV);
        o[] het = oVar.het();
        if (het.length == 0) {
            AppMethodBeat.o(145584);
            return true;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        long time = new Date().getTime();
        boolean z3 = true;
        for (o oVar2 : het) {
            String name = oVar2.getName();
            int indexOf = name.indexOf(".hprof");
            if (indexOf > 0) {
                String substring = name.substring(0, indexOf);
                try {
                    Date parse = simpleDateFormat.parse(substring);
                    if (parse == null) {
                        oVar2.delete();
                    } else {
                        long time2 = parse.getTime();
                        if (time2 >= time) {
                            oVar2.delete();
                        } else {
                            long j2 = (time - time2) / Util.MILLSECONDS_OF_DAY;
                            if (j2 >= 3) {
                                oVar2.delete();
                            } else if (z && j2 < 1) {
                                z3 = false;
                            }
                        }
                    }
                } catch (ParseException e2) {
                    Log.e("MicroMsg.MemoryDumpManager", "hprofFileCheck parse date fail %s", substring);
                    oVar2.delete();
                }
            } else {
                oVar2.delete();
            }
        }
        o[] het2 = oVar.het();
        if (het2.length > 5) {
            if (z2) {
                Toast.makeText(MMApplicationContext.getContext(), "dump fail, hprof file size exceed", 0).show();
            }
            Log.w("MicroMsg.MemoryDumpManager", "hprofFileCheck hprofFileDir.length() too large " + het2.length);
            AppMethodBeat.o(145584);
            return false;
        }
        AppMethodBeat.o(145584);
        return z3;
    }

    public static String bb(boolean z, boolean z2) {
        AppMethodBeat.i(145585);
        if (!ba(z, z2)) {
            AppMethodBeat.o(145585);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(OvV).append(format).append(".hprof");
        String stringBuffer2 = stringBuffer.toString();
        if (!ai(new o(stringBuffer2).heq())) {
            Log.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", stringBuffer2);
            AppMethodBeat.o(145585);
            return null;
        }
        try {
            gGk();
            Debug.dumpHprofData(stringBuffer2);
            if (z2) {
                Toast.makeText(MMApplicationContext.getContext(), stringBuffer2 + " hprof file has saved ", 0).show();
            }
            Log.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", format, Long.valueOf(Util.milliSecondsToNow(currentTimeMillis)));
            AppMethodBeat.o(145585);
            return stringBuffer2;
        } catch (Exception e2) {
            Log.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
            AppMethodBeat.o(145585);
            return null;
        }
    }

    public static String blE(String str) {
        AppMethodBeat.i(145586);
        if (!gGj()) {
            AppMethodBeat.o(145586);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(OvV).append(str).append(".hprof");
        String stringBuffer2 = stringBuffer.toString();
        if (!ai(new o(stringBuffer2).heq())) {
            Log.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", stringBuffer2);
            AppMethodBeat.o(145586);
            return null;
        }
        try {
            gGk();
            Debug.dumpHprofData(stringBuffer2);
            Toast.makeText(MMApplicationContext.getContext(), stringBuffer2 + " hprof file has saved ", 0).show();
            Log.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", str, Long.valueOf(Util.milliSecondsToNow(currentTimeMillis)));
            o oVar = new o(stringBuffer2);
            if (!oVar.exists()) {
                Log.e("MicroMsg.MemoryDumpManager", "Hprof dump file is not exist");
                AppMethodBeat.o(145586);
                return null;
            }
            String a2 = r.a(oVar, true, null);
            if (a2 == null) {
                Log.e("MicroMsg.MemoryDumpManager", "zip hprof file fail");
                AppMethodBeat.o(145586);
                return null;
            }
            AppMethodBeat.o(145586);
            return a2;
        } catch (Exception e2) {
            Log.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
            AppMethodBeat.o(145586);
            return null;
        }
    }

    private static boolean ai(o oVar) {
        AppMethodBeat.i(170137);
        if (oVar.exists()) {
            AppMethodBeat.o(170137);
            return true;
        } else if (!oVar.mkdirs()) {
            boolean exists = oVar.exists();
            AppMethodBeat.o(170137);
            return exists;
        } else {
            AppMethodBeat.o(170137);
            return true;
        }
    }

    public static void gGk() {
        AppMethodBeat.i(145588);
        Runtime.getRuntime().gc();
        System.runFinalization();
        AppMethodBeat.o(145588);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059 A[SYNTHETIC, Splitter:B:17:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e A[Catch:{ IOException -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d A[SYNTHETIC, Splitter:B:34:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0092 A[Catch:{ IOException -> 0x009a }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a6 A[SYNTHETIC, Splitter:B:44:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ab A[Catch:{ IOException -> 0x00b2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void gGl() {
        /*
        // Method dump skipped, instructions count: 200
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ci.b.gGl():void");
    }
}
