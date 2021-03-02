package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Base64;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.d.a;
import com.tencent.mm.model.d.b;
import com.tencent.mm.model.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MainTabUI;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.n;
import com.tencent.recovery.wx.util.WXUtil;

public final class w {
    public static w dlV;
    public boolean dlW;
    public MMHandler dlX = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.app.w.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(19457);
            super.handleMessage(message);
            if (message.what == -1999) {
                if (!w.this.dlW) {
                    LauncherUI instance = LauncherUI.getInstance();
                    if (instance != null && instance.ODT) {
                        instance.ODR.getMainTabUI().blU("tab_main");
                        HomeUI homeUI = instance.getHomeUI();
                        if (homeUI.OCv) {
                            homeUI.OCx = true;
                        }
                        g gVar = o.DCM;
                        if (gVar != null) {
                            gVar.eZk();
                        }
                        for (MMFragment mMFragment : instance.ODR.getMainTabUI().OIl.values()) {
                            if (!(mMFragment instanceof MainUI)) {
                                ((n) mMFragment).gGD();
                            }
                        }
                    }
                    System.gc();
                    AppMethodBeat.o(19457);
                    return;
                }
            } else if (message.what == -2999) {
                if (w.this.dlW) {
                    AppMethodBeat.o(19457);
                    return;
                }
                LauncherUI instance2 = LauncherUI.getInstance();
                if (instance2 != null) {
                    MainTabUI mainTabUI = instance2.ODR.getMainTabUI();
                    if (mainTabUI.OIl.containsKey(0)) {
                        ((n) mainTabUI.OIl.get(0)).gGD();
                    }
                }
                if (com.tencent.mm.kernel.g.aAf().azp()) {
                    bg.aVz();
                    bd KG = cg.KG("plugin.emoji");
                    if (KG != null) {
                        KG.clearPluginData(0);
                    }
                    b aXA = b.aXA();
                    a aXx = a.aXx();
                    c aXD = c.aXD();
                    bg.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.model.d.b.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(20437);
                            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(b.iHS + "MMSQL.trace");
                            if (!oVar.exists()) {
                                Log.w("MicroMsg.SQLTraceManager", "SqlTrace file is not  exists");
                                AppMethodBeat.o(20437);
                            } else if (!com.tencent.mm.kernel.g.aAf().azp()) {
                                Log.w("MicroMsg.SQLTraceManager", "acc not ready ");
                                AppMethodBeat.o(20437);
                            } else {
                                long currentTimeMillis = System.currentTimeMillis();
                                long cQ = b.cQ(MMApplicationContext.getContext());
                                boolean z = false;
                                if (cQ > currentTimeMillis) {
                                    z = true;
                                } else if (currentTimeMillis - cQ > Util.MILLSECONDS_OF_DAY) {
                                    z = true;
                                } else if (currentTimeMillis - cQ > b.this.iIa && b.this.iHz) {
                                    z = true;
                                }
                                long length = oVar.length();
                                Log.i("MicroMsg.SQLTraceManager", "check need upload ,file size is %d,time out  %b", Long.valueOf(length), Boolean.valueOf(z));
                                if (z && length > b.this.iHZ) {
                                    b bVar = b.this;
                                    Context context = MMApplicationContext.getContext();
                                    String packageName = MMApplicationContext.getContext().getPackageName();
                                    try {
                                        PackageManager.class.getMethod("getPackageSizeInfo", String.class, IPackageStatsObserver.class).invoke(context.getPackageManager(), packageName, new IPackageStatsObserver.Stub() {
                                            /* class com.tencent.mm.model.d.b.AnonymousClass2 */

                                            @Override // android.content.pm.IPackageStatsObserver
                                            public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                                                AppMethodBeat.i(20438);
                                                b.this.dlF[0] = packageStats.cacheSize;
                                                b.this.dlF[1] = packageStats.dataSize;
                                                b.this.dlF[2] = packageStats.codeSize;
                                                Log.i("MicroMsg.SQLTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                                AppMethodBeat.o(20438);
                                            }
                                        });
                                    } catch (Exception e2) {
                                        bVar.dlF[0] = -1;
                                        bVar.dlF[1] = -1;
                                        bVar.dlF[2] = -1;
                                    }
                                    if (b.this.dlF[1] != 0 || b.this.iHy > 1) {
                                        Log.i("MicroMsg.SQLTraceManager", "start file upload ,file length is %d ", Long.valueOf(oVar.length()));
                                        if (oVar.length() > b.this.iHY) {
                                            Log.e("MicroMsg.SQLTraceManager", "log file invaild format");
                                        } else {
                                            String Lk = b.Lk(b.iHS + "MMSQL.trace");
                                            Log.i("MicroMsg.SQLTraceManager", "read content success");
                                            b.this.Lj(Lk);
                                        }
                                        Log.i("MicroMsg.SQLTraceManager", "set last Upload Time %d ", Long.valueOf(System.currentTimeMillis()));
                                        b.a(b.this, oVar);
                                        b.this.iHz = false;
                                        b.this.iHy = 0;
                                        b.c(MMApplicationContext.getContext(), System.currentTimeMillis());
                                        AppMethodBeat.o(20437);
                                        return;
                                    }
                                    Log.i("MicroMsg.SQLTraceManager", "wait for get packageStats");
                                    b.i(b.this);
                                }
                                AppMethodBeat.o(20437);
                            }
                        }
                    });
                    h.RTc.aX(new Runnable() {
                        /* class com.tencent.mm.model.d.a.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(179571);
                            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(a.iHx);
                            if (!oVar.exists()) {
                                Log.w("MicroMsg.HandlerTraceManager", "summer handler trace file is not exists");
                                AppMethodBeat.o(179571);
                            } else if (!com.tencent.mm.kernel.g.aAf().azp()) {
                                Log.w("MicroMsg.HandlerTraceManager", "summer acc not ready ");
                                AppMethodBeat.o(179571);
                            } else {
                                long j2 = a.this.sp.getLong("handler_report_lastUploadTime", 0);
                                long currentTimeMillis = System.currentTimeMillis();
                                boolean z = currentTimeMillis - j2 > a.this.iHF || j2 > currentTimeMillis;
                                if (a.this.iHz && z) {
                                    Log.i("MicroMsg.HandlerTraceManager", "summer check need upload ,file size is %d,time out %b", Long.valueOf(oVar.length()), Boolean.TRUE);
                                    a aVar = a.this;
                                    try {
                                        PackageManager.class.getMethod("getPackageSizeInfo", String.class, IPackageStatsObserver.class).invoke(MMApplicationContext.getContext().getPackageManager(), MMApplicationContext.getContext().getPackageName(), new IPackageStatsObserver.Stub() {
                                            /* class com.tencent.mm.model.d.a.AnonymousClass2 */

                                            @Override // android.content.pm.IPackageStatsObserver
                                            public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                                                AppMethodBeat.i(179573);
                                                a.this.dlF[0] = packageStats.cacheSize;
                                                a.this.dlF[1] = packageStats.dataSize;
                                                a.this.dlF[2] = packageStats.codeSize;
                                                Log.i("MicroMsg.HandlerTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize));
                                                AppMethodBeat.o(179573);
                                            }
                                        });
                                    } catch (Exception e2) {
                                        aVar.dlF[0] = -1;
                                        aVar.dlF[1] = -1;
                                        aVar.dlF[2] = -1;
                                    }
                                    if (a.this.dlF[1] != 0 || a.this.iHy > 1) {
                                        if (oVar.length() > a.this.iHE) {
                                            Log.e("MicroMsg.HandlerTraceManager", "summer log file invaild format");
                                        } else {
                                            String Li = a.Li(a.iHx);
                                            a aVar2 = a.this;
                                            Intent intent = new Intent();
                                            intent.setClassName(MMApplicationContext.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
                                            intent.setAction("uncatch_exception");
                                            intent.putExtra("exceptionPid", Process.myPid());
                                            String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
                                            if (Util.isNullOrNil(aA)) {
                                                aA = bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "never_login_crash");
                                            }
                                            intent.putExtra("userName", aA);
                                            intent.putExtra("tag", "handler");
                                            intent.putExtra("exceptionMsg", Base64.encodeToString((aVar2.aXy() + Li).getBytes(), 2));
                                            MMApplicationContext.getContext().sendBroadcast(intent);
                                        }
                                        a.a(a.this, oVar);
                                        a.this.iHz = false;
                                        a.this.iHy = 0;
                                        a.this.sp.edit().putLong("handler_report_lastUploadTime", System.currentTimeMillis()).commit();
                                        AppMethodBeat.o(179571);
                                        return;
                                    }
                                    a.i(a.this);
                                }
                                AppMethodBeat.o(179571);
                            }
                        }

                        public final String toString() {
                            AppMethodBeat.i(179572);
                            String str = super.toString() + "|checkAndUpload";
                            AppMethodBeat.o(179572);
                            return str;
                        }
                    });
                    aXD.a(aXA);
                    aXD.a(aXx);
                    bg.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.model.d.c.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(20463);
                            if (c.this.gYQ) {
                                Log.i("MicroMsg.TraceConfigUpdater", "summer update isUpdating and ret");
                                AppMethodBeat.o(20463);
                                return;
                            }
                            long j2 = c.this.sp.getLong("trace_config_last_update_time", 0);
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - j2 > Util.MILLSECONDS_OF_DAY || j2 > currentTimeMillis) {
                                c.c(c.this);
                                c.this.gYQ = true;
                                bg.azz().a(JsApiGetBackgroundAudioState.CTRL_INDEX, c.this);
                                bg.azz().a(160, c.this);
                                bg.azz().a(new com.tencent.mm.bb.n(21), 0);
                                AppMethodBeat.o(20463);
                                return;
                            }
                            Log.i("MicroMsg.TraceConfigUpdater", "summer last update time: " + j2 + " current time: " + currentTimeMillis + " in same day");
                            AppMethodBeat.o(20463);
                        }
                    });
                }
                System.gc();
            }
            AppMethodBeat.o(19457);
        }
    };

    public w() {
        AppMethodBeat.i(19458);
        AppMethodBeat.o(19458);
    }

    public static w WE() {
        AppMethodBeat.i(19459);
        if (dlV == null) {
            dlV = new w();
        }
        w wVar = dlV;
        AppMethodBeat.o(19459);
        return wVar;
    }

    public final void start() {
        AppMethodBeat.i(19460);
        this.dlW = false;
        this.dlX.removeMessages(-1999);
        this.dlX.removeMessages(-2999);
        this.dlX.sendEmptyMessageDelayed(-1999, 3000);
        this.dlX.sendEmptyMessageDelayed(-2999, 30000);
        AppMethodBeat.o(19460);
    }
}
