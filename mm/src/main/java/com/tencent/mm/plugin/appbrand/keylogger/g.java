package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.keylogger.base.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class g implements c {
    private static final Map<Long, String> mPp = new HashMap();
    private static String mPq;
    private static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    static {
        AppMethodBeat.i(229920);
        AppMethodBeat.o(229920);
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.c
    public final void g(final String str, final String str2, final Object... objArr) {
        AppMethodBeat.i(229911);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.g.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(229908);
                g.ec(str, String.format(str2, objArr));
                AppMethodBeat.o(229908);
            }
        }, "MMTempKeyStepLogger");
        AppMethodBeat.o(229911);
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.c
    public final List<String> V(String str, long j2) {
        AppMethodBeat.i(229912);
        ArrayList arrayList = new ArrayList();
        String Bk = Bk(j2);
        if (Util.isNullOrNil(Bk)) {
            AppMethodBeat.o(229912);
            return arrayList;
        }
        File file = new File(Bk);
        if (!file.isDirectory()) {
            AppMethodBeat.o(229912);
            return arrayList;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            AppMethodBeat.o(229912);
            return arrayList;
        }
        Log.i("MicroMsg.DefaultKeyStepLogger", "collectLogPathsByProcessAndDate : %s", str);
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2].getName().startsWith(str)) {
                arrayList.add(listFiles[i2].getAbsolutePath());
            }
        }
        AppMethodBeat.o(229912);
        return arrayList;
    }

    private static String Bk(long j2) {
        AppMethodBeat.i(229913);
        if (mPp.containsKey(Long.valueOf(j2))) {
            String str = mPp.get(Long.valueOf(j2));
            AppMethodBeat.o(229913);
            return str;
        } else if (Util.isNullOrNil(bMR())) {
            AppMethodBeat.o(229913);
            return null;
        } else {
            String format = String.format("%s%s/", bMR(), sDateFormat.format(Long.valueOf(j2)));
            FilePathGenerator.checkMkdir(format);
            mPp.put(Long.valueOf(j2), format);
            AppMethodBeat.o(229913);
            return format;
        }
    }

    private static String bMR() {
        AppMethodBeat.i(229914);
        if (!Util.isNullOrNil(mPq)) {
            String str = mPq;
            AppMethodBeat.o(229914);
            return str;
        }
        String bMS = bMS();
        if (Util.isNullOrNil(bMS)) {
            AppMethodBeat.o(229914);
            return null;
        }
        if (!bMS.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            bMS = bMS + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String format = String.format("%skeystep/", bMS);
        mPq = format;
        AppMethodBeat.o(229914);
        return format;
    }

    private static String bMS() {
        AppMethodBeat.i(229915);
        if (!MMApplicationContext.isMMProcess()) {
            IPCString iPCString = (IPCString) XIPCInvoker.a(MMApplicationContext.getApplicationId(), new IPCVoid(), a.class);
            if (iPCString == null) {
                AppMethodBeat.o(229915);
                return null;
            }
            String str = iPCString.value;
            AppMethodBeat.o(229915);
            return str;
        } else if (!com.tencent.mm.kernel.g.aAc()) {
            Log.w("MicroMsg.DefaultKeyStepLogger", "doGetAccPath not accHasReady");
            AppMethodBeat.o(229915);
            return null;
        } else {
            String str2 = com.tencent.mm.kernel.g.aAh().cachePath;
            AppMethodBeat.o(229915);
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a implements k<IPCVoid, IPCString> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCString invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(229910);
            if (!com.tencent.mm.kernel.g.aAc()) {
                Log.w("MicroMsg.DefaultKeyStepLogger", "IPCGetAccPath not accHasReady");
                IPCString iPCString = new IPCString(null);
                AppMethodBeat.o(229910);
                return iPCString;
            }
            IPCString iPCString2 = new IPCString(com.tencent.mm.kernel.g.aAh().cachePath);
            AppMethodBeat.o(229910);
            return iPCString2;
        }
    }

    public static void bMT() {
        AppMethodBeat.i(229916);
        Log.d("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs enter");
        if (!MMApplicationContext.isMMProcess()) {
            AppMethodBeat.o(229916);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = MMApplicationContext.getDefaultPreference().getLong("MMTempKeyStepLogger-Last-Clean-Time", 0);
        Log.i("MicroMsg.DefaultKeyStepLogger", "cleanOldLogs now:%d lastCleanTime:%d", Long.valueOf(currentTimeMillis), Long.valueOf(j2));
        if (currentTimeMillis - j2 < 604800000) {
            AppMethodBeat.o(229916);
            return;
        }
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.g.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(229909);
                g.access$100();
                MMApplicationContext.getDefaultPreference().edit().putLong("MMTempKeyStepLogger-Last-Clean-Time", System.currentTimeMillis()).commit();
                AppMethodBeat.o(229909);
            }
        }, "MMTempKeyStepLogger#cleanOldLogs");
        AppMethodBeat.o(229916);
    }

    private static long abU(String str) {
        long j2 = 0;
        AppMethodBeat.i(229917);
        if (str == null) {
            AppMethodBeat.o(229917);
        } else {
            String[] split = str.split("-", -1);
            if (split == null || split.length != 3) {
                Log.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr invalid date:%s", str);
                AppMethodBeat.o(229917);
            } else {
                Calendar instance = Calendar.getInstance();
                try {
                    instance.set(Util.getInt(split[0], 0), Util.getInt(split[1], 0), Util.getInt(split[2], 0));
                    j2 = instance.getTimeInMillis();
                    AppMethodBeat.o(229917);
                } catch (Exception e2) {
                    Log.w("MicroMsg.DefaultKeyStepLogger", "getTimeFromDateFormatStr exp:%s", e2);
                    AppMethodBeat.o(229917);
                }
            }
        }
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c A[SYNTHETIC, Splitter:B:20:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b A[SYNTHETIC, Splitter:B:27:0x008b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void ec(java.lang.String r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 158
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.keylogger.g.ec(java.lang.String, java.lang.String):void");
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(229919);
        String bMR = bMR();
        if (Util.isNullOrNil(bMR)) {
            Log.w("MicroMsg.DefaultKeyStepLogger", "doCleanJob getKeyStepRootDir null");
            AppMethodBeat.o(229919);
            return;
        }
        long abU = abU(sDateFormat.format(Long.valueOf(Util.nowMilliSecond() - 604800000)));
        Log.i("MicroMsg.DefaultKeyStepLogger", "doCleanJob rootDir:%s expiredDateTime:%d", bMR, Long.valueOf(abU));
        File file = new File(bMR);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                Log.i("MicroMsg.DefaultKeyStepLogger", "doCleanJob no dirs");
                AppMethodBeat.o(229919);
                return;
            }
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (listFiles[i2].isDirectory()) {
                    long abU2 = abU(listFiles[i2].getName());
                    Log.i("MicroMsg.DefaultKeyStepLogger", "dateTimeOfDir:%d", Long.valueOf(abU2));
                    if (abU2 <= abU) {
                        Log.i("MicroMsg.DefaultKeyStepLogger", "doCleanJob expired dirPath:%s", listFiles[i2].getPath());
                        e.a(new o(listFiles[i2]));
                    }
                }
            }
        }
        AppMethodBeat.o(229919);
    }
}
