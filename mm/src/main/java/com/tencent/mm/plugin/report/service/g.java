package com.tencent.mm.plugin.report.service;

import android.app.ActivityManager;
import android.os.StatFs;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class g {
    private static SparseArray<Long> Cyu = new SparseArray<>();
    private static SparseArray<HashMap<Integer, Integer>> Cyv = new SparseArray<>();
    private static boolean Cyw = true;
    private static long Cyx = 0;
    private static long Cyy = 0;
    private static long Cyz = 0;

    static {
        AppMethodBeat.i(143863);
        AppMethodBeat.o(143863);
    }

    public static void Wl(int i2) {
        AppMethodBeat.i(143857);
        if (!Cyw) {
            AppMethodBeat.o(143857);
            return;
        }
        Cyu.put(i2, Long.valueOf(Util.nowMilliSecond()));
        Log.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  time:%d", Integer.valueOf(i2), Long.valueOf(Util.nowMilliSecond()));
        AppMethodBeat.o(143857);
    }

    public static void Wm(int i2) {
        AppMethodBeat.i(143859);
        if (!Cyw) {
            AppMethodBeat.o(143859);
            return;
        }
        Long l = Cyu.get(i2);
        if (l == null) {
            AppMethodBeat.o(143859);
        } else if (l.longValue() == -1) {
            AppMethodBeat.o(143859);
        } else {
            Cyu.put(i2, -1L);
            long nowMilliSecond = Util.nowMilliSecond() - l.longValue();
            if (nowMilliSecond <= 0) {
                AppMethodBeat.o(143859);
                return;
            }
            switch (i2) {
                case 8:
                    if (!MMApplicationContext.sIsRevChange) {
                        aB(1, nowMilliSecond);
                        aA(TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, nowMilliSecond);
                        h.INSTANCE.b(23, 1, 2, (int) nowMilliSecond, false);
                        break;
                    } else {
                        h.INSTANCE.b(23, 4, 5, (int) nowMilliSecond, false);
                        break;
                    }
                case 9:
                    aB(3, nowMilliSecond);
                    aA(229, nowMilliSecond);
                    h.INSTANCE.b(27, 1, 2, (int) nowMilliSecond, false);
                    break;
                case 10:
                    aB(2, nowMilliSecond);
                    aA(228, nowMilliSecond);
                    h.INSTANCE.b(28, 1, 2, (int) nowMilliSecond, false);
                    break;
                case 12:
                    aB(6, nowMilliSecond);
                    break;
                case 13:
                    aB(7, nowMilliSecond);
                    break;
                case 14:
                    aB(8, nowMilliSecond);
                    break;
                case 18:
                    aB(10, nowMilliSecond);
                    break;
                case 19:
                    aB(9, nowMilliSecond);
                    break;
                case 20:
                    aB(12, nowMilliSecond);
                    break;
                case 21:
                    aB(11, nowMilliSecond);
                    break;
                case 22:
                    aB(13, nowMilliSecond);
                    break;
                case 23:
                    aB(16, nowMilliSecond);
                    break;
                case 24:
                    aB(15, nowMilliSecond);
                    break;
                case 25:
                    aB(14, nowMilliSecond);
                    break;
            }
            Log.i("MicroMsg.ReportLogInfo", "ReportLogInfo operationEnd eventID:%d  time:%d", Integer.valueOf(i2), Long.valueOf(nowMilliSecond));
            AppMethodBeat.o(143859);
        }
    }

    private static void aA(int i2, long j2) {
        AppMethodBeat.i(143860);
        if (j2 <= 0) {
            AppMethodBeat.o(143860);
        } else if (j2 < 1000) {
            h.INSTANCE.aw(i2, 0, 1);
            AppMethodBeat.o(143860);
        } else if (j2 < 2000) {
            h.INSTANCE.aw(i2, 0, 3);
            AppMethodBeat.o(143860);
        } else if (j2 < 5000) {
            h.INSTANCE.aw(i2, 0, 5);
            AppMethodBeat.o(143860);
        } else if (j2 < 10000) {
            h.INSTANCE.aw(i2, 0, 7);
            AppMethodBeat.o(143860);
        } else {
            h.INSTANCE.aw(i2, 0, 9);
            AppMethodBeat.o(143860);
        }
    }

    private static void aB(int i2, long j2) {
        AppMethodBeat.i(143861);
        if (i2 == 6) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < Cyx + Util.MILLSECONDS_OF_MINUTE) {
                AppMethodBeat.o(143861);
                return;
            }
            Cyx = currentTimeMillis;
        } else if (i2 == 7) {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (currentTimeMillis2 < Cyy + Util.MILLSECONDS_OF_MINUTE) {
                AppMethodBeat.o(143861);
                return;
            }
            Cyy = currentTimeMillis2;
        } else if (i2 == 8) {
            long currentTimeMillis3 = System.currentTimeMillis();
            if (currentTimeMillis3 < Cyz + Util.MILLSECONDS_OF_MINUTE) {
                AppMethodBeat.o(143861);
                return;
            }
            Cyz = currentTimeMillis3;
        }
        a eOH = a.eOH();
        if (eOH.hasInit) {
            h.INSTANCE.a(11335, true, false, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(eOH.CyB), Long.valueOf(eOH.CyA[0]), Long.valueOf(eOH.CyA[1]), Long.valueOf(eOH.CyD));
            AppMethodBeat.o(143861);
            return;
        }
        h.INSTANCE.a(11335, true, false, Integer.valueOf(i2), Long.valueOf(j2));
        AppMethodBeat.o(143861);
    }

    public static void Wn(int i2) {
        AppMethodBeat.i(143862);
        if (!Cyw) {
            AppMethodBeat.o(143862);
            return;
        }
        Log.d("MicroMsg.ReportLogInfo", "ReportLogInfo stopOperation stop eventID:%d", Integer.valueOf(i2));
        Cyu.put(i2, -1L);
        AppMethodBeat.o(143862);
    }

    public static final class a {
        public static a CyE;
        public long[] CyA;
        public int CyB;
        public String CyC;
        public long CyD;
        public volatile boolean hasInit;

        public static synchronized a eOH() {
            a aVar;
            synchronized (a.class) {
                AppMethodBeat.i(143854);
                if (CyE == null) {
                    a aVar2 = new a();
                    CyE = aVar2;
                    aVar2.CyB = getNumCores();
                    CyE.CyC = aop();
                    a aVar3 = CyE;
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryInfo(memoryInfo);
                    aVar3.CyD = memoryInfo.availMem >> 10;
                    a aVar4 = CyE;
                    StatFs statFs = new StatFs(com.tencent.mm.compatible.util.g.getDataDirectory().getPath());
                    long blockCount = (long) statFs.getBlockCount();
                    StatFs statFs2 = new StatFs(com.tencent.mm.compatible.util.g.getDataDirectory().getPath());
                    aVar4.CyA = new long[]{blockCount * ((long) statFs.getBlockSize()), ((long) statFs2.getBlockSize()) * ((long) statFs2.getAvailableBlocks())};
                    CyE.hasInit = true;
                }
                aVar = CyE;
                AppMethodBeat.o(143854);
            }
            return aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0058 A[SYNTHETIC, Splitter:B:23:0x0058] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x005d A[SYNTHETIC, Splitter:B:26:0x005d] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x008c A[SYNTHETIC, Splitter:B:36:0x008c] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0091 A[SYNTHETIC, Splitter:B:39:0x0091] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00b4 A[SYNTHETIC, Splitter:B:48:0x00b4] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00b9 A[SYNTHETIC, Splitter:B:51:0x00b9] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String aop() {
            /*
            // Method dump skipped, instructions count: 235
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.report.service.g.a.aop():java.lang.String");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.report.service.g$a$a  reason: collision with other inner class name */
        public class C1661a implements q {
            C1661a() {
            }

            @Override // com.tencent.mm.vfs.q
            public final boolean accept(o oVar) {
                AppMethodBeat.i(176169);
                if (Pattern.matches("cpu[0-9]", oVar.getName())) {
                    AppMethodBeat.o(176169);
                    return true;
                }
                AppMethodBeat.o(176169);
                return false;
            }
        }

        private static int getNumCores() {
            AppMethodBeat.i(143856);
            try {
                int length = new o("/sys/devices/system/cpu/").a(new C1661a()).length;
                AppMethodBeat.o(143856);
                return length;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.ReportLogInfo", e2, "", new Object[0]);
                AppMethodBeat.o(143856);
                return 1;
            }
        }
    }
}
