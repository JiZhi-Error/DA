package com.tencent.mm.booter;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class o {
    static long gmG = 0;

    public static void akW() {
        AppMethodBeat.i(19903);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("mm_proc_startup", 0);
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("mm_proc_startup");
        MultiProcessMMKV.transport2MMKV(sharedPreferences, singleMMKV);
        String[] split = singleMMKV.getString("startup_info", "").split("=");
        if (split != null && split.length > 0) {
            a aVar = new a();
            if (aVar.CT(split[split.length - 1])) {
                aVar.gmM = Process.myPid();
                split[split.length - 1] = aVar.toString();
            }
        }
        a aVar2 = new a();
        aVar2.gmI = 2;
        aVar2.gmK = Process.myPid();
        aVar2.gmL = (int) Util.nowSecond();
        String g2 = g(split);
        String aVar3 = aVar2.toString();
        if (g2.length() > 0) {
            aVar3 = g2 + "=" + aVar3;
        }
        Log.d("MicroMsg.ProcessReport", "startProc new info %s", aVar3);
        singleMMKV.edit().putString("startup_info", aVar3).commit();
        AppMethodBeat.o(19903);
    }

    public static void Xe() {
        AppMethodBeat.i(19904);
        CR("mm_proc_startup");
        CR("push_proc_startup");
        AppMethodBeat.o(19904);
    }

    private static void CR(String str) {
        AppMethodBeat.i(19905);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences(str, 0);
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV(str);
        MultiProcessMMKV.transport2MMKV(sharedPreferences, singleMMKV);
        String[] split = singleMMKV.getString("startup_info", "").split("=");
        if (split == null || split.length == 0) {
            AppMethodBeat.o(19905);
            return;
        }
        a aVar = new a();
        if (aVar.CT(split[split.length - 1])) {
            aVar.gmJ = 2;
            split[split.length - 1] = aVar.toString();
        }
        String g2 = g(split);
        Log.d("MicroMsg.ProcessReport", "uerExit new info %s", g2);
        singleMMKV.edit().putString("startup_info", g2).commit();
        AppMethodBeat.o(19905);
    }

    public static void report() {
        AppMethodBeat.i(19906);
        if (gmG == 0 || Util.ticksToNow(gmG) >= Util.MILLSECONDS_OF_HOUR) {
            final int intValue = ((Integer) bg.aVD().get(37, 0)).intValue();
            if (d.KyO != intValue) {
                bg.aVD().set(37, Integer.valueOf(d.KyO));
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.booter.o.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(19899);
                        h.INSTANCE.kvStat(10675, intValue + "," + ChannelUtil.channelId);
                        AppMethodBeat.o(19899);
                    }
                });
            }
            gmG = Util.currentTicks();
            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.booter.o.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(19900);
                    o.CS("mm_proc_startup");
                    o.CS("push_proc_startup");
                    AppMethodBeat.o(19900);
                }
            });
            AppMethodBeat.o(19906);
            return;
        }
        AppMethodBeat.o(19906);
    }

    private static String g(String[] strArr) {
        AppMethodBeat.i(19907);
        String str = "";
        boolean z = true;
        for (String str2 : strArr) {
            if (z) {
                z = false;
            } else {
                str = str + "=";
            }
            str = str + str2;
        }
        AppMethodBeat.o(19907);
        return str;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        int gmI;
        int gmJ = 1;
        int gmK;
        int gmL;
        int gmM;

        a() {
        }

        public final boolean CT(String str) {
            AppMethodBeat.i(19901);
            String[] split = str.split(",");
            if (split == null || split.length != 5) {
                Log.e("MicroMsg.ProcessReport", "error format");
                AppMethodBeat.o(19901);
                return false;
            }
            try {
                this.gmI = Util.getInt(split[0], 0);
                this.gmJ = Util.getInt(split[1], 0);
                this.gmK = Util.getInt(split[2], 0);
                this.gmL = Util.getInt(split[3], 0);
                this.gmM = Util.getInt(split[4], 0);
                AppMethodBeat.o(19901);
                return true;
            } catch (Exception e2) {
                Log.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
                Log.printErrStackTrace("MicroMsg.ProcessReport", e2, "", new Object[0]);
                AppMethodBeat.o(19901);
                return false;
            }
        }

        public final String toString() {
            AppMethodBeat.i(19902);
            String format = String.format("%d,%d,%d,%d,%d", Integer.valueOf(this.gmI), Integer.valueOf(this.gmJ), Integer.valueOf(this.gmK), Integer.valueOf(this.gmL), Integer.valueOf(this.gmM));
            AppMethodBeat.o(19902);
            return format;
        }
    }

    static /* synthetic */ void CS(String str) {
        AppMethodBeat.i(19908);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences(str, 0);
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV(str);
        MultiProcessMMKV.transport2MMKV(sharedPreferences, singleMMKV);
        String[] split = singleMMKV.getString("startup_info", "").split("=");
        if (split == null || split.length <= 1) {
            Log.i("MicroMsg.ProcessReport", "nothing to reprot");
            AppMethodBeat.o(19908);
            return;
        }
        for (int i2 = 0; i2 < split.length - 1; i2++) {
            Log.i("MicroMsg.ProcessReport", "reprot %s: %s", str, split[i2]);
            h.INSTANCE.kvStat(10667, split[i2]);
        }
        singleMMKV.edit().putString("startup_info", split[split.length - 1]).commit();
        AppMethodBeat.o(19908);
    }
}
