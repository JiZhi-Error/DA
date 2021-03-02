package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.system.OsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.e;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.Field;
import java.util.List;

public final class a {
    private static String NLr;
    private static String NLs;
    private static o NLt;
    private static long NLu;
    @SuppressLint({"HandlerLeak"})
    private static Handler NLv = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.mm.splash.a.AnonymousClass1 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(40587);
            AbstractC2062a aVar = (AbstractC2062a) message.obj;
            if (a.access$000()) {
                if (!a.MI(a.NLu)) {
                    a.c(aVar);
                    AppMethodBeat.o(40587);
                    return;
                } else if (!a.jw(h.gNz)) {
                    h.gyq().idkey(675, 25, 1);
                    aVar.gye();
                    AppMethodBeat.o(40587);
                    return;
                } else {
                    if (!a.jB(h.gNz)) {
                        h.gyq().idkey(675, 18, 1);
                    }
                    h.gyq().idkey(675, 17, 1);
                    aVar.gyf();
                }
            } else if (!a.WA()) {
                h.gyq().idkey(675, 15, 1);
                aVar.gye();
            } else if (!a.jw(h.gNz)) {
                h.gyq().idkey(675, 26, 1);
                h.gyq().idkey(675, 15, 1);
                aVar.gye();
            } else {
                h.gyq().idkey(675, 16, 1);
                aVar.eZS();
            }
            long unused = a.NLu = 0;
            AppMethodBeat.o(40587);
        }
    };

    /* renamed from: com.tencent.mm.splash.a$a  reason: collision with other inner class name */
    public interface AbstractC2062a {
        void eZS();

        void gye();

        void gyf();
    }

    static /* synthetic */ boolean WA() {
        AppMethodBeat.i(40604);
        boolean gyc = gyc();
        AppMethodBeat.o(40604);
        return gyc;
    }

    static /* synthetic */ boolean access$000() {
        AppMethodBeat.i(40600);
        boolean gyb = gyb();
        AppMethodBeat.o(40600);
        return gyb;
    }

    static /* synthetic */ void c(AbstractC2062a aVar) {
        AppMethodBeat.i(40603);
        b(aVar);
        AppMethodBeat.o(40603);
    }

    static /* synthetic */ boolean jB(Context context) {
        AppMethodBeat.i(40602);
        boolean jz = jz(context);
        AppMethodBeat.o(40602);
        return jz;
    }

    public static void n(Application application) {
        AppMethodBeat.i(40588);
        NLr = aa.z(new o(application.getFilesDir(), "dexopt_service").her());
        AppMethodBeat.o(40588);
    }

    public static String gya() {
        AppMethodBeat.i(40589);
        if (NLr == null) {
            IllegalStateException illegalStateException = new IllegalStateException("data directory should not be null, give one.");
            AppMethodBeat.o(40589);
            throw illegalStateException;
        }
        o oVar = new o(NLr);
        if (!oVar.exists() && !oVar.mkdirs()) {
            h.c("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
        }
        String str = NLr;
        AppMethodBeat.o(40589);
        return str;
    }

    public static boolean jw(Context context) {
        AppMethodBeat.i(40590);
        boolean bS = h.NLF.bS(context);
        h.c("WxSplash.DexOpt", "if need dexopt %s", Boolean.valueOf(bS));
        AppMethodBeat.o(40590);
        return bS;
    }

    public static void jx(Context context) {
        boolean z;
        AppMethodBeat.i(40591);
        if (g.zF) {
            AppMethodBeat.o(40591);
            return;
        }
        h.gyq().idkey(675, 22, 1);
        try {
            z = h.NLF.bR(context);
        } catch (Throwable th) {
            h.a(th, "multidex install failed");
            z = false;
        }
        h.c("WxSplash.DexOpt", "install multidex result %s", Boolean.valueOf(z));
        if (!z) {
            h.c("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
            h.eCp();
        }
        AppMethodBeat.o(40591);
    }

    public static void jy(Context context) {
        boolean z;
        AppMethodBeat.i(40592);
        h.c("WxSplash.DexOpt", "start dex opt service", new Object[0]);
        String processNameByPid = Util.getProcessNameByPid(context, Process.myPid());
        processNameByPid.replace(':', '_');
        NLs = "DexOpt_Request_".concat(String.valueOf(processNameByPid));
        h.gyq().idkey(675, 14, 1);
        try {
            bij(NLs);
        } catch (Exception e2) {
            if (Build.VERSION.SDK_INT <= 19 && e2.getClass().getCanonicalName().equals("libcore.io.ErrnoException")) {
                try {
                    Field field = e2.getClass().getField("errno");
                    field.setAccessible(true);
                    if (((Integer) field.get(e2)).intValue() == OsConstants.ENOSPC) {
                        o oVar = new o(gya());
                        if (!oVar.exists()) {
                            z = true;
                        } else {
                            int length = oVar.het().length;
                            h.c("WxSplash.DexOpt", "check dexopt directory size %s.", Integer.valueOf(length));
                            z = length < 10000;
                        }
                        if (z) {
                            h.NLF.bT(context);
                        } else {
                            h.c("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
                            o oVar2 = new o(gya());
                            if (oVar2.exists()) {
                                e.a(oVar2);
                            }
                        }
                    }
                } catch (Exception e3) {
                    h.c("WxSplash.DexOpt", "%s, %s", e3.getMessage());
                }
            }
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(40592);
            throw runtimeException;
        }
        context.startService(new Intent(context, DexOptService.class));
        AppMethodBeat.o(40592);
    }

    private static synchronized void bij(String str) {
        synchronized (a.class) {
            AppMethodBeat.i(40593);
            String gya = gya();
            o oVar = new o(gya);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            o oVar2 = new o(gya + FilePathGenerator.ANDROID_DIR_SEP + str);
            if (oVar2.exists()) {
                oVar2.delete();
            }
            oVar2.createNewFile();
            NLt = oVar2;
            AppMethodBeat.o(40593);
        }
    }

    private static boolean jz(Context context) {
        AppMethodBeat.i(40594);
        ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (activityManager != null) {
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null) {
                h.c("WxSplash.DexOpt", "dexopt service may dead, get running services return null.", new Object[0]);
                AppMethodBeat.o(40594);
                return false;
            }
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if ("com.tencent.mm.splash.DexOptService".equals(runningServiceInfo.service.getClassName())) {
                    AppMethodBeat.o(40594);
                    return true;
                }
            }
        }
        h.c("WxSplash.DexOpt", "dexopt service may dead", new Object[0]);
        AppMethodBeat.o(40594);
        return false;
    }

    public static boolean jA(Context context) {
        AppMethodBeat.i(40595);
        long j2 = 0;
        long currentTimeMillis = System.currentTimeMillis();
        h.c("WxSplash.DexOpt", "block checking dex opt result.", new Object[0]);
        while (gyb()) {
            j2++;
            Thread.sleep(100);
            if (j2 >= 5) {
                j2 = 0;
                if (System.currentTimeMillis() - currentTimeMillis > 180000) {
                    h.c("WxSplash.DexOpt", "block checking dex opt timeout.", new Object[0]);
                    if (!jw(context)) {
                        h.gyq().idkey(675, 25, 1);
                        h.gyq().idkey(675, 15, 1);
                        AppMethodBeat.o(40595);
                        return true;
                    }
                    if (!jz(context)) {
                        h.gyq().idkey(675, 18, 1);
                    }
                    h.gyq().idkey(675, 17, 1);
                    AppMethodBeat.o(40595);
                    return false;
                }
            }
        }
        if (!gyc()) {
            h.gyq().idkey(675, 15, 1);
            AppMethodBeat.o(40595);
            return true;
        } else if (!jw(context)) {
            h.gyq().idkey(675, 26, 1);
            h.gyq().idkey(675, 15, 1);
            AppMethodBeat.o(40595);
            return true;
        } else {
            h.gyq().idkey(675, 16, 1);
            AppMethodBeat.o(40595);
            return false;
        }
    }

    public static void a(AbstractC2062a aVar) {
        AppMethodBeat.i(40596);
        b(aVar);
        AppMethodBeat.o(40596);
    }

    static {
        AppMethodBeat.i(40605);
        AppMethodBeat.o(40605);
    }

    private static void b(AbstractC2062a aVar) {
        AppMethodBeat.i(40597);
        if (NLu == 0) {
            NLu = System.currentTimeMillis();
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = aVar;
        NLv.sendMessageDelayed(obtain, 100);
        AppMethodBeat.o(40597);
    }

    private static boolean gyb() {
        AppMethodBeat.i(40598);
        if (NLt == null) {
            IllegalStateException illegalStateException = new IllegalStateException("tmp file field should not be null");
            AppMethodBeat.o(40598);
            throw illegalStateException;
        }
        boolean exists = NLt.exists();
        AppMethodBeat.o(40598);
        return exists;
    }

    private static boolean gyc() {
        AppMethodBeat.i(40599);
        boolean exists = new o(gya() + "/DexOpt_Failed").exists();
        AppMethodBeat.o(40599);
        return exists;
    }

    static /* synthetic */ boolean MI(long j2) {
        AppMethodBeat.i(40601);
        if (System.currentTimeMillis() - j2 > 180000) {
            AppMethodBeat.o(40601);
            return true;
        }
        AppMethodBeat.o(40601);
        return false;
    }
}
