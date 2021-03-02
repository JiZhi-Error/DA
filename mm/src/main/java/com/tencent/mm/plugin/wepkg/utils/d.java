package com.tencent.mm.plugin.wepkg.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class d {
    private static final Set<Object> lwZ = new HashSet();
    private static final Object ogA = new Object();
    private static volatile MMHandler xvA;

    static {
        AppMethodBeat.i(110824);
        AppMethodBeat.o(110824);
    }

    public static long currentTime() {
        AppMethodBeat.i(110810);
        long nowSecond = Util.nowSecond();
        AppMethodBeat.o(110810);
        return nowSecond;
    }

    public static <T> T cP(T t) {
        AppMethodBeat.i(110811);
        lwZ.add(t);
        AppMethodBeat.o(110811);
        return t;
    }

    public static void bs(Object obj) {
        AppMethodBeat.i(110812);
        lwZ.remove(obj);
        AppMethodBeat.o(110812);
    }

    public static void bZm() {
        AppMethodBeat.i(110813);
        if (xvA == null) {
            AppMethodBeat.o(110813);
            return;
        }
        synchronized (ogA) {
            try {
                if (xvA != null) {
                    xvA.quit();
                    xvA = null;
                }
            } finally {
                AppMethodBeat.o(110813);
            }
        }
    }

    public static MMHandler cyh() {
        AppMethodBeat.i(184500);
        if (xvA == null) {
            synchronized (ogA) {
                try {
                    if (xvA == null) {
                        xvA = new MMHandler("WebviewCache#WorkerThread");
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(184500);
                    throw th;
                }
            }
        }
        MMHandler mMHandler = xvA;
        AppMethodBeat.o(184500);
        return mMHandler;
    }

    public static void b(String str, final a aVar) {
        AppMethodBeat.i(110815);
        final long currentTimeMillis = System.currentTimeMillis();
        final WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.EX = 1001;
        wepkgCrossProcessTask.JNm = str;
        if (MMApplicationContext.isMMProcess()) {
            cyh().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.wepkg.utils.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(110808);
                    wepkgCrossProcessTask.bjj();
                    if (aVar != null) {
                        aVar.a(wepkgCrossProcessTask);
                    }
                    AppMethodBeat.o(110808);
                }
            });
            AppMethodBeat.o(110815);
            return;
        }
        wepkgCrossProcessTask.lyv = new Runnable() {
            /* class com.tencent.mm.plugin.wepkg.utils.d.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(110809);
                Log.i("MicroMsg.Wepkg.WepkgUtil", "bind service time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.bDK();
                AppMethodBeat.o(110809);
            }
        };
        wepkgCrossProcessTask.bDJ();
        AppBrandMainProcessService.a(wepkgCrossProcessTask);
        AppMethodBeat.o(110815);
    }

    public static String bcO(String str) {
        AppMethodBeat.i(110816);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110816);
            return "";
        }
        try {
            String nullAsNil = Util.nullAsNil(Uri.parse(str).getQueryParameter("wechat_pkgid"));
            AppMethodBeat.o(110816);
            return nullAsNil;
        } catch (UnsupportedOperationException e2) {
            Log.e("MicroMsg.Wepkg.WepkgUtil", e2.getMessage());
            AppMethodBeat.o(110816);
            return "";
        }
    }

    public static String bcP(String str) {
        AppMethodBeat.i(110817);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110817);
            return "";
        }
        String host = Uri.parse(str).getHost();
        AppMethodBeat.o(110817);
        return host;
    }

    public static String bcQ(String str) {
        String str2;
        AppMethodBeat.i(110818);
        if (Util.isNullOrNil(str) || !URLUtil.isNetworkUrl(str)) {
            AppMethodBeat.o(110818);
            return "";
        }
        try {
            str2 = str.replaceFirst(Uri.parse(str).getScheme() + "://", "");
            try {
                if (str2.contains("?")) {
                    str2 = str2.substring(0, str2.indexOf("?"));
                }
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
            str2 = str;
        }
        AppMethodBeat.o(110818);
        return str2;
    }

    public static boolean bcR(String str) {
        AppMethodBeat.i(110819);
        if (!Util.isNullOrNil(bcO(str))) {
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("we_pkg_sp", 4);
            if (sharedPreferences != null && sharedPreferences.getBoolean("disable_we_pkg", false)) {
                Log.i("MicroMsg.Wepkg.WepkgUtil", "disable wepkg");
                a.b("EnterWeb", str, bcO(str), null, 0, 0, a.ahr(11));
                AppMethodBeat.o(110819);
                return false;
            } else if (com.tencent.mm.plugin.game.commlib.a.dSV()) {
                Log.i("MicroMsg.Wepkg.WepkgUtil", "config wepkg disable");
                a.b("EnterWeb", str, bcO(str), null, 0, 0, a.ahr(12));
                AppMethodBeat.o(110819);
                return false;
            } else {
                AppMethodBeat.o(110819);
                return true;
            }
        } else {
            AppMethodBeat.o(110819);
            return false;
        }
    }

    public static String mv(String str, String str2) {
        AppMethodBeat.i(110820);
        String messageDigest = g.getMessageDigest((str + "_" + str2).getBytes());
        AppMethodBeat.o(110820);
        return messageDigest;
    }

    public static boolean checkMkdir(String str) {
        AppMethodBeat.i(110821);
        try {
            o oVar = new o(str);
            if (!oVar.exists() || !oVar.isDirectory()) {
                oVar.mkdirs();
            }
            AppMethodBeat.o(110821);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(110821);
            return false;
        }
    }

    public static boolean gkY() {
        AppMethodBeat.i(110822);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int i2 = gregorianCalendar.get(11);
        int i3 = gregorianCalendar.get(12);
        if (i2 < 12 || i2 >= 14) {
            if (i2 == 14) {
                if (i3 <= 30) {
                    AppMethodBeat.o(110822);
                    return true;
                }
            } else if (i2 >= 18 && i2 <= 24) {
                AppMethodBeat.o(110822);
                return true;
            }
            AppMethodBeat.o(110822);
            return false;
        }
        AppMethodBeat.o(110822);
        return true;
    }

    public static boolean isAppOnForeground(Context context) {
        AppMethodBeat.i(110823);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            AppMethodBeat.o(110823);
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId()) || runningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId() + ":tools") || runningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId() + ":toolsmp"))) {
                AppMethodBeat.o(110823);
                return true;
            }
        }
        AppMethodBeat.o(110823);
        return false;
    }
}
