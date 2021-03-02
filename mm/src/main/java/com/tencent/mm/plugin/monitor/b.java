package com.tencent.mm.plugin.monitor;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Debug;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.dg;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.monitor.a;
import com.tencent.mm.plugin.report.kvdata.BDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.HeavyDetailInfo;
import com.tencent.mm.plugin.report.kvdata.SDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.SubDirInfo;
import com.tencent.mm.plugin.report.kvdata.TableInfo;
import com.tencent.mm.plugin.report.kvdata.WeChatSDInfo;
import com.tencent.mm.plugin.report.kvdata.log_14375;
import com.tencent.mm.plugin.report.service.e;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.c;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements bd {
    private static final long startTime = System.currentTimeMillis();
    private boolean cSX = false;
    private MStorage.IOnStorageChange iHr = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.monitor.b.AnonymousClass9 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(51508);
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", Util.getStack());
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                h.RTc.o(new Runnable() {
                    /* class com.tencent.mm.plugin.monitor.b.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(51507);
                        b.a(b.this);
                        AppMethodBeat.o(51507);
                    }
                }, 100);
            }
            AppMethodBeat.o(51508);
        }
    };
    private boolean pPV = true;
    private BroadcastReceiver pPW;
    private IListener yjg = new IListener<ps>() {
        /* class com.tencent.mm.plugin.monitor.b.AnonymousClass12 */

        {
            AppMethodBeat.i(160478);
            this.__eventId = ps.class.getName().hashCode();
            AppMethodBeat.o(160478);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ps psVar) {
            AppMethodBeat.i(51511);
            b.this.zFk.cancel();
            h.RTc.o(b.this.zFk, 3000);
            AppMethodBeat.o(51511);
            return false;
        }
    };
    private long zEU = 1024;
    private long zEV = 10;
    private long zEW = 1800;
    private long zEX = 3000000;
    private long zEY = 15000;
    private long zEZ = 100000;
    private long zFa = 10000;
    private long zFb = 1024;
    private long zFc = 1440;
    private long zFd = 15;
    private long zFe = 1440;
    private long zFf = 0;
    private com.tencent.f.i.b zFg;
    private a.C1484a zFh;
    private long zFi = 0;
    private i zFj = new i() {
        /* class com.tencent.mm.plugin.monitor.b.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(51500);
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(qVar == null ? -1 : qVar.getType());
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(i3);
            objArr[3] = str;
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv onIDKeyCallback onSceneEnd[%d][%d, %d, %s]", objArr);
            if (i2 == 0 && i3 == 0) {
                h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.monitor.b.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(51499);
                        e.eOE();
                        AppMethodBeat.o(51499);
                    }
                });
            }
            AppMethodBeat.o(51500);
        }
    };
    private com.tencent.f.i.b zFk = new com.tencent.f.i.b() {
        /* class com.tencent.mm.plugin.monitor.b.AnonymousClass10 */

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "reportAllRunnable";
        }

        public final void run() {
            AppMethodBeat.i(51509);
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
            if (!g.aAc()) {
                Log.w("MicroMsg.SubCoreBaseMonitor", "account has not initalized!");
                AppMethodBeat.o(51509);
                return;
            }
            b.b(b.this);
            b.c(b.this);
            b.d(b.this);
            b.e(b.this);
            b.f(b.this);
            b.this.zFl.cancel();
            h.RTc.o(b.this.zFl, 10000);
            AppMethodBeat.o(51509);
        }
    };
    private com.tencent.f.i.b zFl = new com.tencent.f.i.b() {
        /* class com.tencent.mm.plugin.monitor.b.AnonymousClass11 */

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "reportHeavyUser";
        }

        public final void run() {
            AppMethodBeat.i(51510);
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
            if (g.aAc()) {
                b.h(b.this);
            }
            AppMethodBeat.o(51510);
        }
    };
    private MTimerHandler zFm = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.monitor.b.AnonymousClass13 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(51512);
            b.e(b.this);
            AppMethodBeat.o(51512);
            return true;
        }
    }, true);
    private MTimerHandler zFn = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.monitor.b.AnonymousClass14 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(163489);
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.monitor.b.AnonymousClass14.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(163488);
                    g.aAh().azQ().set(ar.a.USERINFO_NEWER_RED_FLAVOR_URL_STRING, "");
                    g.aAh().azQ().set(ar.a.USERINFO_HAS_SHOW_NEWER_RED_FLAVOR_BOOLEAN, Boolean.FALSE);
                    AppMethodBeat.o(163488);
                }
            }, "name_thread_get_newer_flavor_red");
            AppMethodBeat.o(163489);
            return true;
        }
    }, true);

    public b() {
        AppMethodBeat.i(51518);
        AppMethodBeat.o(51518);
    }

    static /* synthetic */ a.C1484a a(b bVar, o oVar, a.C1484a aVar, Map map) {
        AppMethodBeat.i(51534);
        a.C1484a a2 = bVar.a(oVar, aVar, null, null, map, true, 0);
        AppMethodBeat.o(51534);
        return a2;
    }

    static /* synthetic */ void a(b bVar, int i2, long j2, long j3) {
        AppMethodBeat.i(51535);
        bVar.n(i2, j2, j3);
        AppMethodBeat.o(51535);
    }

    static /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(51525);
        boolean rq = bVar.rq(true);
        AppMethodBeat.o(51525);
        return rq;
    }

    static {
        AppMethodBeat.i(51537);
        AppMethodBeat.o(51537);
    }

    private boolean rq(boolean z) {
        boolean z2;
        AppMethodBeat.i(51519);
        c Fu = d.aXu().Fu("100212");
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", Boolean.valueOf(z), Fu, Boolean.valueOf(Fu.isValid()), Fu.gzz(), 1024L, 10L, 1800L, 3000000L, 15000L, 15000L, 100000L, 10000L, 1440L, 15L, 1440L);
        if (Fu.isValid()) {
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
            Map<String, String> gzz = Fu.gzz();
            long j2 = Util.getLong(gzz.get("sdsize"), 1024);
            long j3 = Util.getLong(gzz.get("sdratio"), 10);
            long j4 = Util.getLong(gzz.get("dbsize"), 1800);
            long j5 = Util.getLong(gzz.get("fdbsize"), 1024);
            long j6 = Util.getLong(gzz.get("msg"), 3000000);
            long j7 = Util.getLong(gzz.get("conv"), 15000);
            long j8 = Util.getLong(gzz.get("contact"), 100000);
            long j9 = Util.getLong(gzz.get("chatroom"), 10000);
            long j10 = Util.getLong(gzz.get("sditv"), 1440);
            long j11 = Util.getLong(gzz.get("sdwait"), 15);
            long j12 = Util.getLong(gzz.get("dbitv"), 1440);
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", Long.valueOf(this.zEU), Long.valueOf(j2), Long.valueOf(this.zEV), Long.valueOf(j3), Long.valueOf(this.zEW), Long.valueOf(j4), Long.valueOf(this.zFb), Long.valueOf(j5), Long.valueOf(this.zEX), Long.valueOf(j6), Long.valueOf(this.zEY), Long.valueOf(j7), Long.valueOf(this.zEZ), Long.valueOf(j8), Long.valueOf(this.zFa), Long.valueOf(j9), Long.valueOf(this.zFc), Long.valueOf(j10), Long.valueOf(this.zFd), Long.valueOf(j11), Long.valueOf(this.zFe), Long.valueOf(j12));
            if (this.zEU != j2) {
                this.zEU = j2;
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.zEV != j3) {
                this.zEV = j3;
                z2 = true;
            }
            if (this.zEW != j4) {
                this.zEW = j4;
                z2 = true;
            }
            if (this.zFb != j5) {
                this.zFb = j5;
                z2 = true;
            }
            if (this.zEX != j6) {
                this.zEX = j6;
                z2 = true;
            }
            if (this.zEY != j7) {
                this.zEY = j7;
                z2 = true;
            }
            if (this.zEZ != j8) {
                this.zEZ = j8;
                z2 = true;
            }
            if (this.zFa != j9) {
                this.zFa = j9;
                z2 = true;
            }
            if (this.zFc != j10) {
                this.zFc = j10;
                z2 = true;
            }
            if (this.zFd != j11) {
                this.zFd = j11;
                z2 = true;
            }
            if (this.zFe != j12) {
                this.zFe = j12;
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (z2) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 0, 1, true);
            if (z) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 18, 1, true);
            }
        }
        if (this.zEU <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 30, 1, true);
            this.zEU = 1024;
        }
        if (this.zEV <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 31, 1, true);
            this.zEV = 10;
        }
        if (this.zEW <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 32, 1, true);
            this.zEW = 1800;
        }
        if (this.zEX <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 33, 1, true);
            this.zEX = 3000000;
        }
        if (this.zEY <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 34, 1, true);
            this.zEY = 15000;
        }
        if (this.zEZ <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 35, 1, true);
            this.zEZ = 100000;
        }
        if (this.zFa <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 36, 1, true);
            this.zFa = 10000;
        }
        if (this.zFc <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 37, 1, true);
            this.zFc = 1440;
        }
        if (this.zFd <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 38, 1, true);
            this.zFd = 15;
        }
        if (this.zFe <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 39, 1, true);
            this.zFe = 1440;
        }
        if (this.zFb <= 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 40, 1, true);
            this.zFb = 1024;
        }
        AppMethodBeat.o(51519);
        return z2;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(51520);
        EventCenter.instance.add(this.yjg);
        d.aXu().add(this.iHr);
        boolean rq = rq(false);
        g.aAi();
        this.zFi = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_FLAG_LONG, (Object) 0L)).longValue();
        CrashReportFactory.setHeavyUserFlag(this.zFi);
        e.tM(this.zFi != 0);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", Long.valueOf(this.zFi), Boolean.valueOf(rq), this.iHr);
        g.aAi();
        g.aAg().hqi.a(dg.CTRL_INDEX, this.zFj);
        g.aAi();
        g.aAg().hqi.a(dh.CTRL_INDEX, this.zFj);
        g.aAi();
        g.aAg().hqi.a(987, this.zFj);
        g.aAi();
        g.aAg().hqi.a(986, this.zFj);
        g.aAi();
        this.zFf = ((Long) g.aAh().azQ().get(ar.a.USERINFO_WECHAT_FILE_SCAN_LAST_TIME_LONG, (Object) 0L)).longValue();
        Context context = MMApplicationContext.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.cSX = intExtra == 2 || intExtra == 5;
        } else {
            this.cSX = false;
        }
        this.pPV = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.pPW = new BroadcastReceiver() {
            /* class com.tencent.mm.plugin.monitor.b.AnonymousClass15 */

            public final void onReceive(Context context, Intent intent) {
                boolean z;
                AppMethodBeat.i(163492);
                String action = intent.getAction();
                char c2 = 65535;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1886648615:
                        if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        b.this.pPV = true;
                        break;
                    case 1:
                        b.this.pPV = false;
                        break;
                    case 2:
                        b.this.cSX = true;
                        break;
                    case 3:
                        b.this.cSX = false;
                        break;
                }
                Object[] objArr = new Object[5];
                objArr[0] = action;
                objArr[1] = Boolean.valueOf(b.this.pPV);
                objArr[2] = Boolean.valueOf(b.this.cSX);
                objArr[3] = Long.valueOf(b.this.zFf);
                if (b.this.zFg == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                Log.v("MicroMsg.SubCoreBaseMonitor", "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]", objArr);
                boolean hasDebuger = CrashReportFactory.hasDebuger() & false;
                if (b.this.zFg == null && ((b.this.cSX && !b.this.pPV) || hasDebuger)) {
                    if (CrashReportFactory.hasDebuger()) {
                        b.this.zFd = 0;
                    } else if (System.currentTimeMillis() - b.this.zFf < b.this.zFc * Util.MILLSECONDS_OF_MINUTE) {
                        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", Long.valueOf(b.this.zFc));
                        AppMethodBeat.o(163492);
                        return;
                    }
                    final AnonymousClass1 r0 = new a() {
                        /* class com.tencent.mm.plugin.monitor.b.AnonymousClass15.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.monitor.a
                        public final void a(int i2, a.C1484a aVar) {
                            AppMethodBeat.i(163490);
                            b.this.zFf = System.currentTimeMillis();
                            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", Integer.valueOf(i2), Long.valueOf(b.this.zFf), b.this.zFh, aVar);
                            b.this.zFh = null;
                            if (i2 == 0 && !aVar.jcC) {
                                g.aAi();
                                g.aAh().azQ().set(ar.a.USERINFO_WECHAT_FILE_SCAN_LAST_TIME_LONG, Long.valueOf(b.this.zFf));
                                g.aAi();
                                g.aAh().azQ().gBI();
                                try {
                                    b.b(b.this, aVar);
                                    AppMethodBeat.o(163490);
                                    return;
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e2, "doReportSDInfo err!", new Object[0]);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(418, 6, 1, true);
                                }
                            }
                            AppMethodBeat.o(163490);
                        }
                    };
                    b.this.zFg = new com.tencent.f.i.b() {
                        /* class com.tencent.mm.plugin.monitor.b.AnonymousClass15.AnonymousClass2 */

                        @Override // com.tencent.f.i.h, com.tencent.f.i.g
                        public final String getKey() {
                            return "autoScanRemove";
                        }

                        public final void run() {
                            AppMethodBeat.i(163491);
                            b.this.zFg = null;
                            int aVQ = bp.aVQ();
                            Log.i("MicroMsg.SubCoreBaseMonitor", "summerdel checkUnfinishedDeleteMsgTask ret[%s]", Integer.valueOf(aVQ));
                            if (aVQ > 0) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(418, 8, 1, true);
                            }
                            b.this.zFh = b.a(b.this, r0);
                            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", b.this.zFh);
                            AppMethodBeat.o(163491);
                        }
                    };
                    com.tencent.f.h.RTc.a(b.this.zFg, b.this.zFd * Util.MILLSECONDS_OF_MINUTE, "MicroMsg.SubCoreBaseMonitor");
                    Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", Long.valueOf(b.this.zFd));
                    AppMethodBeat.o(163492);
                } else if (b.this.zFg != null) {
                    b.this.zFg.cancel();
                    b.this.zFg = null;
                    Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", b.this.zFh);
                    AppMethodBeat.o(163492);
                } else {
                    if (b.this.zFh != null) {
                        b.this.zFh.jcC = true;
                        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", b.this.zFh);
                        b.this.zFh = null;
                    }
                    AppMethodBeat.o(163492);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        context.registerReceiver(this.pPW, intentFilter);
        Object[] objArr = new Object[6];
        objArr[0] = this.zFh != null ? "enabled" : "disabled";
        objArr[1] = this.pPV ? "" : " not";
        objArr[2] = this.cSX ? "" : " not";
        objArr[3] = Long.valueOf(this.zFf);
        objArr[4] = Long.valueOf(this.zFc * Util.MILLSECONDS_OF_MINUTE);
        objArr[5] = Long.valueOf(this.zFd * Util.MILLSECONDS_OF_MINUTE);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].", objArr);
        this.zFm.stopTimer();
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            this.zFn.startTimer(3000, 10800000);
        }
        AppMethodBeat.o(51520);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(51521);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()));
        if (this.pPW != null) {
            MMApplicationContext.getContext().unregisterReceiver(this.pPW);
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", this.pPW);
            this.pPW = null;
        }
        if (this.zFg != null) {
            this.zFg.cancel();
            this.zFg = null;
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", this.zFh);
        }
        if (this.zFh != null) {
            this.zFh.jcC = true;
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", this.zFh);
            this.zFh = null;
        }
        g.aAi();
        g.aAg().hqi.b(dg.CTRL_INDEX, this.zFj);
        g.aAi();
        g.aAg().hqi.b(dh.CTRL_INDEX, this.zFj);
        g.aAi();
        g.aAg().hqi.b(987, this.zFj);
        g.aAi();
        g.aAg().hqi.b(986, this.zFj);
        d.aXu().remove(this.iHr);
        EventCenter.instance.removeListener(this.yjg);
        AppMethodBeat.o(51521);
    }

    private static boolean aFs(String str) {
        AppMethodBeat.i(51522);
        g.aAi();
        if (g.aAh().hqG.equals(str + FilePathGenerator.ANDROID_DIR_SEP)) {
            AppMethodBeat.o(51522);
            return true;
        }
        AppMethodBeat.o(51522);
        return false;
    }

    private static boolean a(HashMap<String, LinkedList<String>> hashMap, Map<String, Integer> map, String str, int i2) {
        AppMethodBeat.i(214356);
        LinkedList<String> linkedList = hashMap.get(str);
        if (linkedList != null) {
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                map.put(it.next(), Integer.valueOf(i2));
            }
            AppMethodBeat.o(214356);
            return true;
        }
        AppMethodBeat.o(214356);
        return false;
    }

    private a.C1484a a(o oVar, a.C1484a aVar, a.b bVar, a.c cVar, Map<String, Integer> map, boolean z, int i2) {
        a.b bVar2;
        boolean z2;
        AppMethodBeat.i(51523);
        if (aVar.jcC) {
            Log.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", aVar, bVar);
            AppMethodBeat.o(51523);
        } else {
            if (aVar.bCe < i2) {
                aVar.bCe++;
            }
            if (oVar.isDirectory()) {
                String z3 = aa.z(oVar.her());
                if (bVar == null) {
                    if (map == null || map.size() <= 0 || map.get(z3) == null) {
                        if (com.tencent.mm.loader.j.b.aKJ().equals(oVar.getParent() + FilePathGenerator.ANDROID_DIR_SEP)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2 || aFs(z3)) {
                            if (aFs(oVar.getParent())) {
                                bVar2 = new a.b(z3, 203);
                            } else {
                                bVar2 = bVar;
                            }
                        } else if (Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", oVar.getName())) {
                            bVar2 = new a.b(z3, 202);
                        } else if (Pattern.matches("[a-fA-F0-9]{32}", oVar.getName())) {
                            bVar2 = new a.b(z3, 201);
                        } else {
                            bVar2 = new a.b(z3, 203);
                        }
                    } else {
                        bVar2 = new a.b(z3, map.get(z3).intValue());
                        map.remove(z3);
                    }
                    if (bVar2 != null) {
                        aVar.zER.add(bVar2);
                        Log.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", z3, aVar, bVar2);
                    }
                } else {
                    bVar2 = bVar;
                }
                aVar.zEP++;
                if (bVar2 != null) {
                    bVar2.zEP++;
                }
                if (cVar != null) {
                    cVar.zEP++;
                }
                if (i2 > 15) {
                    Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", Integer.valueOf(i2), aa.z(oVar.her()), aVar);
                    AppMethodBeat.o(51523);
                } else {
                    String[] list = oVar.list();
                    if (list == null) {
                        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", aa.z(oVar.her()));
                        AppMethodBeat.o(51523);
                    } else if (z) {
                        a.c cVar2 = cVar;
                        for (String str : list) {
                            if (!Util.isNullOrNil(str) && Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str)) {
                                cVar2 = new a.c(aa.z(oVar.her()) + FilePathGenerator.ANDROID_DIR_SEP + str);
                                aVar.zES.add(cVar2);
                            }
                            a(new o(aa.z(oVar.mUri) + FilePathGenerator.ANDROID_DIR_SEP + str), aVar, bVar2, cVar2, map, false, i2 + 1);
                        }
                    } else {
                        int length = list.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            a(new o(aa.z(oVar.her()) + FilePathGenerator.ANDROID_DIR_SEP + list[i3]), aVar, bVar2, cVar, map, false, i2 + 1);
                        }
                    }
                }
            } else {
                aVar.zEQ++;
                if (bVar != null) {
                    bVar.zEQ++;
                }
                if (cVar != null) {
                    cVar.zEQ++;
                }
                if (!oVar.exists()) {
                    Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", aa.z(oVar.her()), Long.valueOf(aVar.zEQ));
                    AppMethodBeat.o(51523);
                } else {
                    long length2 = oVar.length();
                    if (length2 <= 0 || length2 >= 2147483648L) {
                        aVar.fileLenInvalidCount++;
                        if (bVar != null) {
                            bVar.fileLenInvalidCount++;
                        }
                        if (cVar != null) {
                            cVar.zET++;
                        }
                    } else {
                        aVar.oJj += length2;
                        if (bVar != null) {
                            bVar.oJj += length2;
                        }
                        if (cVar != null) {
                            cVar.oJj = length2 + cVar.oJj;
                        }
                    }
                }
            }
            AppMethodBeat.o(51523);
        }
        return aVar;
    }

    private synchronized void n(int i2, final long j2, long j3) {
        final long j4;
        AppMethodBeat.i(51524);
        boolean z = j2 > j3;
        if (z) {
            j4 = this.zFi | ((long) i2);
        } else {
            j4 = this.zFi & ((long) (i2 ^ -1));
        }
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), Long.valueOf(this.zFi), Long.valueOf(j4), Long.valueOf(Thread.currentThread().getId()));
        if (j4 != this.zFi) {
            if (this.zFi == 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 1, 1, true);
            }
            if (j4 == 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 2, 1, true);
            }
        }
        final ar.a aVar = null;
        switch (i2) {
            case 1:
                ar.a aVar2 = ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG;
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, z ? 3 : 4, 1, true);
                aVar = aVar2;
                break;
            case 2:
                ar.a aVar3 = ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG;
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, z ? 5 : 6, 1, true);
                aVar = aVar3;
                break;
            case 4:
                ar.a aVar4 = ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG;
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, z ? 7 : 8, 1, true);
                aVar = aVar4;
                break;
            case 8:
                ar.a aVar5 = ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG;
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, z ? 9 : 10, 1, true);
                aVar = aVar5;
                break;
            case 16:
                ar.a aVar6 = ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG;
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, z ? 11 : 12, 1, true);
                aVar = aVar6;
                break;
            case 32:
                ar.a aVar7 = ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG;
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, z ? 13 : 14, 1, true);
                aVar = aVar7;
                break;
            case 64:
                ar.a aVar8 = ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG;
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, z ? 15 : 16, 1, true);
                aVar = aVar8;
                break;
            case 128:
                ar.a aVar9 = ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_FAV_DB_SIZE_LONG;
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, z ? 19 : 20, 1, true);
                aVar = aVar9;
                break;
        }
        this.zFi = j4;
        e.tM(j4 != 0);
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.monitor.b.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(51506);
                if (!g.aAc()) {
                    AppMethodBeat.o(51506);
                    return;
                }
                CrashReportFactory.setHeavyUserFlag(j4);
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(j4));
                if (aVar != null) {
                    g.aAi();
                    g.aAh().azQ().set(aVar, Long.valueOf(j2));
                }
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", Long.valueOf(j4), Long.valueOf(b.this.zFi), aVar, Long.valueOf(j2));
                AppMethodBeat.o(51506);
            }
        });
        AppMethodBeat.o(51524);
    }

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(51526);
        if (g.aAc()) {
            g.aAi();
            long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_REPORT_SD_STATUS_TIME_LONG, (Object) 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_REPORT_SD_STATUS_TIME_LONG, Long.valueOf(currentTimeMillis));
                com.tencent.f.h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.monitor.b.AnonymousClass6 */

                    public final void run() {
                        int i2;
                        int i3;
                        long j2;
                        long j3;
                        long j4;
                        long j5;
                        long j6;
                        int i4;
                        int i5;
                        AppMethodBeat.i(51505);
                        try {
                            o oVar = new o(ar.NSe + "SdcardInfo.cfg");
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(340, oVar.exists() ? 10 : 11, 1, true);
                            boolean hasUnRemovableStorage = SdcardUtil.hasUnRemovableStorage();
                            String path = com.tencent.mm.compatible.util.g.getDataDirectory().getPath();
                            String path2 = com.tencent.mm.compatible.util.g.getExternalStorageDirectory().getPath();
                            StatFs statFs = new StatFs(path);
                            long blockSize = (long) statFs.getBlockSize();
                            long blockCount = (long) statFs.getBlockCount();
                            long availableBlocks = (long) statFs.getAvailableBlocks();
                            long j7 = blockSize * blockCount;
                            long j8 = blockSize * availableBlocks;
                            if (blockCount > 0) {
                                i2 = Math.round((((float) availableBlocks) * 100.0f) / ((float) blockCount));
                            } else {
                                i2 = -1;
                            }
                            StatFs statFs2 = new StatFs(path2);
                            long blockSize2 = (long) statFs2.getBlockSize();
                            long blockCount2 = (long) statFs2.getBlockCount();
                            long availableBlocks2 = (long) statFs2.getAvailableBlocks();
                            long j9 = blockSize2 * blockCount2;
                            long j10 = blockSize2 * availableBlocks2;
                            int i6 = -1;
                            if (blockCount2 > 0) {
                                i6 = Math.round((((float) availableBlocks2) * 100.0f) / ((float) blockCount2));
                            }
                            boolean equals = com.tencent.mm.loader.j.b.aKE().equals(path2);
                            if (!equals) {
                                StatFs statFs3 = new StatFs(com.tencent.mm.loader.j.b.aKE());
                                j6 = (long) statFs3.getBlockSize();
                                j5 = (long) statFs3.getBlockCount();
                                long availableBlocks3 = (long) statFs3.getAvailableBlocks();
                                long j11 = j6 * j5;
                                long j12 = j6 * availableBlocks3;
                                if (j5 > 0) {
                                    i3 = Math.round((((float) availableBlocks3) * 100.0f) / ((float) j5));
                                    j2 = j12;
                                    j3 = j11;
                                    j4 = availableBlocks3;
                                } else {
                                    i3 = i6;
                                    j2 = j12;
                                    j3 = j11;
                                    j4 = availableBlocks3;
                                }
                            } else {
                                i3 = i6;
                                j2 = j10;
                                j3 = j9;
                                j4 = availableBlocks2;
                                j5 = blockCount2;
                                j6 = blockSize2;
                            }
                            String fileSystem = SdcardUtil.getFileSystem(com.tencent.mm.loader.j.b.aKE());
                            String fileSystem2 = SdcardUtil.getFileSystem(path);
                            Object[] objArr = new Object[26];
                            objArr[0] = path;
                            objArr[1] = path2;
                            objArr[2] = com.tencent.mm.loader.j.b.aKE();
                            objArr[3] = fileSystem;
                            objArr[4] = Boolean.valueOf(hasUnRemovableStorage);
                            objArr[5] = Long.valueOf(blockSize);
                            objArr[6] = Long.valueOf(blockCount);
                            objArr[7] = Long.valueOf(availableBlocks);
                            objArr[8] = Long.valueOf(j7);
                            objArr[9] = Long.valueOf(j8);
                            objArr[10] = Integer.valueOf(i2);
                            objArr[11] = Long.valueOf(blockSize2);
                            objArr[12] = Long.valueOf(blockCount2);
                            objArr[13] = Long.valueOf(availableBlocks2);
                            objArr[14] = Long.valueOf(j9);
                            objArr[15] = Long.valueOf(j10);
                            objArr[16] = Integer.valueOf(i6);
                            objArr[17] = Boolean.valueOf(equals);
                            objArr[18] = Long.valueOf(j6);
                            objArr[19] = Long.valueOf(j5);
                            objArr[20] = Long.valueOf(j4);
                            objArr[21] = Long.valueOf(j3);
                            objArr[22] = Long.valueOf(j2);
                            objArr[23] = Integer.valueOf(i3);
                            if (oVar.exists()) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            objArr[24] = Integer.valueOf(i4);
                            objArr[25] = fileSystem2;
                            Log.i("MicroMsg.SubCoreBaseMonitor", "summerStorage [%s, %s, %s] [%s] [%b] [%d,%d,%d,%d,%d,%d] [%d,%d,%d,%d,%d,%d] [%b] [%d,%d,%d,%d,%d,%d], [%d][%s]", objArr);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(340, 0, 1, true);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(340, hasUnRemovableStorage ? 1 : 2, 1, true);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(340, equals ? 3 : 4, 1, true);
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = 5000;
                            Object[] objArr3 = new Object[26];
                            objArr3[0] = path;
                            objArr3[1] = path2;
                            objArr3[2] = com.tencent.mm.loader.j.b.aKE();
                            objArr3[3] = fileSystem;
                            objArr3[4] = Integer.valueOf(hasUnRemovableStorage ? 1 : 0);
                            objArr3[5] = Long.valueOf(blockSize);
                            objArr3[6] = Long.valueOf(blockCount);
                            objArr3[7] = Long.valueOf(availableBlocks);
                            objArr3[8] = Long.valueOf(j7);
                            objArr3[9] = Long.valueOf(j8);
                            objArr3[10] = Integer.valueOf(i2);
                            objArr3[11] = Long.valueOf(blockSize2);
                            objArr3[12] = Long.valueOf(blockCount2);
                            objArr3[13] = Long.valueOf(availableBlocks2);
                            objArr3[14] = Long.valueOf(j9);
                            objArr3[15] = Long.valueOf(j10);
                            objArr3[16] = Integer.valueOf(i6);
                            objArr3[17] = Integer.valueOf(equals ? 1 : 0);
                            objArr3[18] = Long.valueOf(j6);
                            objArr3[19] = Long.valueOf(j5);
                            objArr3[20] = Long.valueOf(j4);
                            objArr3[21] = Long.valueOf(j3);
                            objArr3[22] = Long.valueOf(j2);
                            objArr3[23] = Integer.valueOf(i3);
                            if (oVar.exists()) {
                                i5 = 1;
                            } else {
                                i5 = 0;
                            }
                            objArr3[24] = Integer.valueOf(i5);
                            objArr3[25] = fileSystem2;
                            objArr2[1] = String.format("%s;%s;%s;%s;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%s", objArr3);
                            hVar.a(11098, objArr2);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 5001, path + ";" + fileSystem2);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 5002, com.tencent.mm.loader.j.b.aKE() + ";" + fileSystem);
                            com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                            Object[] objArr4 = new Object[2];
                            objArr4[0] = 5003;
                            objArr4[1] = Integer.valueOf(oVar.exists() ? 1 : 0);
                            hVar2.a(11098, objArr4);
                            com.tencent.mm.plugin.report.service.h hVar3 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                            Object[] objArr5 = new Object[2];
                            objArr5[0] = 5004;
                            objArr5[1] = Integer.valueOf(hasUnRemovableStorage ? 1 : 0);
                            hVar3.a(11098, objArr5);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(340, 7, 1, true);
                            AppMethodBeat.o(51505);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e2, "reportSDStatus err!", new Object[0]);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(340, 8, 1, true);
                            AppMethodBeat.o(51505);
                        }
                    }
                }, "reportSDStatus");
            }
        }
        AppMethodBeat.o(51526);
    }

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(51527);
        g.aAi();
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG, (Object) 0L)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue > bVar.zFe * Util.MILLSECONDS_OF_MINUTE || longValue > currentTimeMillis) {
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
            final long j2 = 1024 * bVar.zEW * 1024;
            final long j3 = bVar.zEX;
            final long j4 = 1024 * bVar.zFb * 1024;
            final long j5 = bVar.zEY;
            final long j6 = bVar.zEZ;
            final long j7 = bVar.zFa;
            com.tencent.f.h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.monitor.b.AnonymousClass3 */

                public final void run() {
                    String str;
                    AppMethodBeat.i(51502);
                    try {
                        log_14375 log_14375 = new log_14375();
                        log_14375.type_ = 1;
                        BDStatusInfo bDStatusInfo = new BDStatusInfo();
                        log_14375.dbStatusInfo_ = bDStatusInfo;
                        g.aAi();
                        long length = new o(g.aAh().azO()).length();
                        bDStatusInfo.mmDBSize_ = length;
                        StringBuilder sb = new StringBuilder();
                        g.aAi();
                        long length2 = new o(sb.append(g.aAh().cachePath).append("SnsMicroMsg.db").toString()).length();
                        bDStatusInfo.snsDBSize_ = length2;
                        StringBuilder sb2 = new StringBuilder();
                        g.aAi();
                        long length3 = new o(sb2.append(g.aAh().cachePath).append("enFavorite.db").toString()).length();
                        bDStatusInfo.favDBSize_ = length3;
                        b.a(b.this, 4, length, j2);
                        b.a(b.this, 128, length3, j4);
                        String str2 = length + ";" + length2 + ";" + length3;
                        g.aAi();
                        com.tencent.mm.storagebase.h hVar = g.aAh().hqL;
                        if (hVar == null || !hVar.isOpen()) {
                            Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo db is not open!");
                            str = str2;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            ArrayList arrayList = new ArrayList();
                            Cursor rawQuery = hVar.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null, 2);
                            if (rawQuery != null) {
                                int columnIndex = rawQuery.getColumnIndex("name");
                                while (rawQuery.moveToNext()) {
                                    arrayList.add(rawQuery.getString(columnIndex));
                                }
                                rawQuery.close();
                            }
                            String str3 = str2 + ";" + arrayList.size();
                            bDStatusInfo.mmDBTableCount_ = arrayList.size();
                            LinkedList<TableInfo> linkedList = new LinkedList<>();
                            bDStatusInfo.tableList_ = linkedList;
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                String str4 = (String) it.next();
                                Cursor rawQuery2 = hVar.rawQuery("select count(*) from ".concat(String.valueOf(str4)), null, 2);
                                long j2 = 0;
                                if (rawQuery2 != null) {
                                    if (rawQuery2.moveToFirst()) {
                                        j2 = rawQuery2.getLong(0);
                                    }
                                    rawQuery2.close();
                                }
                                String str5 = str3 + ";" + str4 + ":" + j2;
                                TableInfo tableInfo = new TableInfo();
                                tableInfo.name_ = str4;
                                tableInfo.count_ = j2;
                                linkedList.add(tableInfo);
                                if ("message".equals(str4)) {
                                    b.a(b.this, 8, j2, j3);
                                    str3 = str5;
                                } else if ("rconversation".equals(str4)) {
                                    b.a(b.this, 16, j2, j5);
                                    str3 = str5;
                                } else if ("rcontact".equals(str4)) {
                                    b.a(b.this, 32, j2, j6);
                                    str3 = str5;
                                } else {
                                    if ("chatroom".equals(str4)) {
                                        b.a(b.this, 64, j2, j7);
                                    }
                                    str3 = str5;
                                }
                            }
                            Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo dump all table count %d last %d", Integer.valueOf(arrayList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            str = str3;
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 1, 1, str);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 1, 2, Long.valueOf(length2));
                        com.tencent.mm.plugin.report.service.h.INSTANCE.c(14375, log_14375);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(418, 3, 1, true);
                        Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo result[%s]", str);
                        AppMethodBeat.o(51502);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e2, "reportDBInfo err!", new Object[0]);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(418, 4, 1, true);
                        AppMethodBeat.o(51502);
                    }
                }
            }, "reportDBInfo");
        }
        AppMethodBeat.o(51527);
    }

    static /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(51528);
        if (g.aAc()) {
            g.aAi();
            long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_INSTALL_LAST_REPORT_TIME_LONG, (Object) 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_INSTALL_LAST_REPORT_TIME_LONG, Long.valueOf(currentTimeMillis));
                com.tencent.f.h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.monitor.b.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(163485);
                        try {
                            g.aAi();
                            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, (Object) 0)).intValue();
                            g.aAi();
                            long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_INSTALL_FIRST_TIME_LONG, (Object) 0L)).longValue();
                            String str = intValue + ";" + com.tencent.mm.protocal.d.KyO + ";" + (intValue <= 0 || com.tencent.mm.protocal.d.KyO == intValue ? 1 : 0) + ";" + new SimpleDateFormat("yyyyMMdd").format(new Date(longValue)) + ";" + b.r(b.this);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(418, 1, 1, true);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 3, 1, str);
                            Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion install result[%s]", str);
                            AppMethodBeat.o(163485);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e2, "reportVersion err!", new Object[0]);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(418, 2, 1, true);
                            AppMethodBeat.o(163485);
                        }
                    }
                }, "reportVersion");
            }
        }
        AppMethodBeat.o(51528);
    }

    static /* synthetic */ void e(b bVar) {
        int i2;
        AppMethodBeat.i(51529);
        if (g.aAc()) {
            g.aAi();
            ao azQ = g.aAh().azQ();
            int intValue = ((Integer) azQ.get(ar.a.USERINFO_MM_LVFETIME_REPORT_PID_INT, (Object) 0)).intValue();
            long longValue = ((Long) azQ.get(ar.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, (Object) 0L)).longValue();
            int intValue2 = ((Integer) azQ.get(ar.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, (Object) 0)).intValue();
            int myPid = Process.myPid();
            int i3 = -1;
            Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getProcessMemoryInfo(new int[]{myPid});
            if (!(processMemoryInfo == null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null)) {
                i3 = processMemoryInfo[0].getTotalPss();
            }
            if (intValue == 0) {
                azQ.set(ar.a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(myPid));
                azQ.set(ar.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(System.currentTimeMillis() - startTime));
                ar.a aVar = ar.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT;
                if (i3 > 0) {
                    i2 = i3;
                } else {
                    i2 = 0;
                }
                azQ.set(aVar, Integer.valueOf(i2));
            } else if (intValue != myPid) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 5, 1, Long.valueOf(longValue));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 5, 2, Integer.valueOf(intValue2));
                azQ.set(ar.a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(myPid));
                long currentTimeMillis = System.currentTimeMillis() - startTime;
                if (i3 <= 0) {
                    i3 = 0;
                }
                azQ.set(ar.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(currentTimeMillis));
                azQ.set(ar.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(i3));
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportLifeTime lifeTime[%d -> %d]ms,  pss[%d -> %d], pid[%d -> %d]", Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Integer.valueOf(intValue2), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(myPid));
            } else {
                azQ.set(ar.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(System.currentTimeMillis() - startTime));
                if (i3 > intValue2) {
                    azQ.set(ar.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(i3));
                }
            }
            azQ.gBI();
            bVar.zFm.startTimer(180000);
        }
        AppMethodBeat.o(51529);
    }

    static /* synthetic */ void f(b bVar) {
        AppMethodBeat.i(51530);
        if (g.aAf().azp()) {
            g.aAi();
            long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_REPORT_ECDH_AUTH_TIME_LONG, (Object) 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > Util.MILLSECONDS_OF_DAY || longValue > currentTimeMillis) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_REPORT_ECDH_AUTH_TIME_LONG, Long.valueOf(currentTimeMillis));
                com.tencent.f.h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.monitor.b.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(163487);
                        Log.i("MicroMsg.SubCoreBaseMonitor", "reportECDHAuth USE_ECDH[%s] USE_ML[%b]", Boolean.valueOf(f.KyZ), Boolean.valueOf(f.Kza));
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(148, f.KyZ ? 100 : 101, 1, true);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(148, f.Kza ? 102 : 103, 1, true);
                        AppMethodBeat.o(163487);
                    }
                }, "reportECDHAuth");
            }
        }
        AppMethodBeat.o(51530);
    }

    static /* synthetic */ void h(b bVar) {
        AppMethodBeat.i(51531);
        if (bVar.zFi != 0) {
            g.aAi();
            long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_REPORT_TIME_LONG, (Object) 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > Util.MILLSECONDS_OF_DAY || longValue > currentTimeMillis) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(509, 17, 1, true);
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_HEAVY_USER_REPORT_TIME_LONG, Long.valueOf(currentTimeMillis));
                g.aAi();
                long longValue2 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_FLAG_LONG, (Object) 0L)).longValue();
                log_14375 log_14375 = new log_14375();
                log_14375.type_ = 4;
                HeavyDetailInfo heavyDetailInfo = new HeavyDetailInfo();
                log_14375.heavyDetailInfo_ = heavyDetailInfo;
                heavyDetailInfo.flag_ = longValue2;
                String valueOf = String.valueOf(longValue2);
                g.aAi();
                long longValue3 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG, (Object) 0L)).longValue();
                heavyDetailInfo.sdFileSize_ = longValue3;
                String str = valueOf + ";" + longValue3;
                g.aAi();
                long longValue4 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG, (Object) 0L)).longValue();
                heavyDetailInfo.sdFileRatio_ = longValue4;
                String str2 = str + ";" + longValue4;
                g.aAi();
                long longValue5 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG, (Object) 0L)).longValue();
                heavyDetailInfo.dbSize_ = longValue5;
                String str3 = str2 + ";" + longValue5;
                g.aAi();
                long longValue6 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG, (Object) 0L)).longValue();
                heavyDetailInfo.message_ = longValue6;
                String str4 = str3 + ";" + longValue6;
                g.aAi();
                long longValue7 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG, (Object) 0L)).longValue();
                heavyDetailInfo.conversation_ = longValue7;
                String str5 = str4 + ";" + longValue7;
                g.aAi();
                long longValue8 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG, (Object) 0L)).longValue();
                heavyDetailInfo.contact_ = longValue8;
                String str6 = str5 + ";" + longValue8;
                g.aAi();
                long longValue9 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG, (Object) 0L)).longValue();
                heavyDetailInfo.chatroom_ = longValue9;
                String str7 = str6 + ";" + longValue9;
                g.aAi();
                long longValue10 = ((Long) g.aAh().azQ().get(ar.a.USERINFO_HEAVY_USER_REPORT_TYPE_FAV_DB_SIZE_LONG, (Object) 0L)).longValue();
                heavyDetailInfo.favDbSize_ = longValue10;
                String str8 = str7 + ";" + longValue10;
                MMApplicationContext.getContext().getSharedPreferences("heavyDetailInfo", 0).edit().putLong("sdFileSize", heavyDetailInfo.sdFileSize_).putLong("sdFileRatio", heavyDetailInfo.sdFileRatio_).putLong("dbSize", heavyDetailInfo.dbSize_).putLong("message", heavyDetailInfo.message_).putLong("conversation", heavyDetailInfo.conversation_).putLong("contact", heavyDetailInfo.contact_).putLong("chatroom", heavyDetailInfo.chatroom_).putLong("favDbSize", heavyDetailInfo.favDbSize_).putLong("flag", heavyDetailInfo.flag_).apply();
                try {
                    byte[] bytes = new JSONObject().put("sdFileSize", heavyDetailInfo.sdFileSize_).put("sdFileRatio", heavyDetailInfo.sdFileRatio_).put("dbSize", heavyDetailInfo.dbSize_).put("message", heavyDetailInfo.message_).put("conversation", heavyDetailInfo.conversation_).put("contact", heavyDetailInfo.contact_).put("chatroom", heavyDetailInfo.chatroom_).put("favDbSize", heavyDetailInfo.favDbSize_).put("flag", heavyDetailInfo.flag_).toString().getBytes();
                    s.f(g.aAh().cachePath + "heavyDetailInfo", bytes, bytes.length);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.SubCoreBaseMonitor", "Failed to write heavyDetailInfo");
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 4, 1, str8);
                com.tencent.mm.plugin.report.service.h.INSTANCE.c(14375, log_14375);
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUser report heavy result[%s]", str8);
            }
        }
        AppMethodBeat.o(51531);
    }

    static /* synthetic */ void b(b bVar, a.C1484a aVar) {
        int i2;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        int i3;
        AppMethodBeat.i(51532);
        log_14375 log_14375 = new log_14375();
        log_14375.type_ = 2;
        SDStatusInfo sDStatusInfo = new SDStatusInfo();
        log_14375.sdStatusInfo_ = sDStatusInfo;
        a.c cVar = new a.c("total/temp/acc/");
        Iterator<a.c> it = aVar.zES.iterator();
        while (it.hasNext()) {
            a.c next = it.next();
            cVar.zEP += next.zEP;
            cVar.zEQ += next.zEQ;
            cVar.oJj += next.oJj;
            cVar.zET += next.zET;
        }
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo total tempAccDirResult[%d][%s]", Integer.valueOf(aVar.zES.size()), cVar);
        Collections.sort(aVar.zER, new Comparator<a.b>() {
            /* class com.tencent.mm.plugin.monitor.b.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(a.b bVar, a.b bVar2) {
                long j2 = (long) (bVar.tag - bVar2.tag);
                if (j2 > 0) {
                    return 1;
                }
                if (j2 == 0) {
                    return 0;
                }
                return -1;
            }
        });
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<a.b> it2 = aVar.zER.iterator();
        while (it2.hasNext()) {
            a.b next2 = it2.next();
            if (next2 != null) {
                if (next2.tag > 200) {
                    arrayList.add(next2);
                } else {
                    a.b bVar2 = (a.b) hashMap.get(Integer.valueOf(next2.tag));
                    if (bVar2 == null) {
                        hashMap.put(Integer.valueOf(next2.tag), next2);
                    } else {
                        bVar2.oJj += next2.oJj;
                        bVar2.wKP = new StringBuffer(bVar2.wKP).append(", ").append(next2.wKP).toString();
                    }
                }
            }
        }
        for (a.b bVar3 : hashMap.values()) {
            if (bVar3 != null && !bVar3.jcC) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 6, Integer.valueOf(bVar3.tag), Long.valueOf(bVar3.oJj), bVar3.wKP);
                Log.d("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo subDirResult[%d], totalSize[%d], root[%s]", Integer.valueOf(bVar3.tag), Long.valueOf(bVar3.oJj), bVar3.wKP);
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            a.b bVar4 = (a.b) it3.next();
            if (bVar4 != null && !bVar4.jcC) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 6, Integer.valueOf(bVar4.tag), Long.valueOf(bVar4.oJj), bVar4.wKP);
                Log.d("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo subDirResult[%d], totalSize[%d], root[%s]", Integer.valueOf(bVar4.tag), Long.valueOf(bVar4.oJj), bVar4.wKP);
            }
        }
        String str = aVar.oJj + ":" + aVar.zEP + ":" + aVar.zEQ + ":" + aVar.fileLenInvalidCount + ":" + aVar.zER.size() + ":" + aVar.dtZ + ":" + aVar.bCe + "|" + aVar.zES.size() + ":" + cVar.oJj + ":" + cVar.zEP + ":" + cVar.zEQ + ":" + cVar.zET;
        WeChatSDInfo weChatSDInfo = new WeChatSDInfo();
        sDStatusInfo.weChatSDInfo_ = weChatSDInfo;
        weChatSDInfo.totalSize_ = aVar.oJj;
        weChatSDInfo.fileCount_ = aVar.zEQ;
        weChatSDInfo.fileLenInvalidCount_ = aVar.fileLenInvalidCount;
        weChatSDInfo.subDirResultsSize_ = aVar.zER.size();
        weChatSDInfo.totalTime_ = aVar.dtZ;
        weChatSDInfo.depth_ = aVar.bCe;
        weChatSDInfo.tempAccTotalSize_ = cVar.oJj;
        weChatSDInfo.tempAccDirResultsSize_ = aVar.zES.size();
        weChatSDInfo.tempAccDirCount_ = cVar.zEP;
        weChatSDInfo.tempAccFileCount_ = cVar.zEQ;
        weChatSDInfo.tempAccFileLenInvalidCount_ = cVar.zET;
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 6, 1000, Long.valueOf(weChatSDInfo.totalSize_));
        long j7 = (weChatSDInfo.totalSize_ / 1024) / 1024;
        Log.d("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo weChatSDInfo totolSize[%d MB]", Long.valueOf(j7));
        if (j7 <= 512) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1035, 1, 1, false);
        } else if (j7 <= 1024) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1035, 2, 1, false);
        } else if (j7 <= 2048) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1035, 3, 1, false);
        } else if (j7 <= 4096) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1035, 4, 1, false);
        } else if (j7 <= 8192) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1035, 5, 1, false);
        } else if (j7 <= 16384) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1035, 6, 1, false);
        } else if (j7 <= 32768) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1035, 7, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1035, 8, 1, false);
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1035, 100, j7, false);
        LinkedList<SubDirInfo> linkedList = new LinkedList<>();
        weChatSDInfo.subDirList_ = linkedList;
        Iterator<a.b> it4 = aVar.zER.iterator();
        String str2 = str;
        while (it4.hasNext()) {
            a.b next3 = it4.next();
            String str3 = str2 + "|" + next3.tag + ":" + next3.oJj + ":" + next3.zEP + ":" + next3.zEQ + ":" + next3.fileLenInvalidCount;
            SubDirInfo subDirInfo = new SubDirInfo();
            linkedList.add(subDirInfo);
            subDirInfo.tag_ = next3.tag;
            subDirInfo.totalSize_ = next3.oJj;
            subDirInfo.dirCount_ = next3.zEP;
            subDirInfo.fileCount_ = next3.zEQ;
            subDirInfo.fileLenInvalidCount = next3.fileLenInvalidCount;
            if (next3.tag == 6 && next3.zEQ > 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(857, 16, 1);
            }
            str2 = str3;
        }
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo wechatResult[%d][%s]", Integer.valueOf(str2.length()), str2);
        String path = com.tencent.mm.compatible.util.g.getExternalStorageDirectory().getPath();
        boolean hasUnRemovableStorage = SdcardUtil.hasUnRemovableStorage();
        String fileSystem = SdcardUtil.getFileSystem(com.tencent.mm.loader.j.b.aKE());
        StatFs statFs = new StatFs(path);
        long blockSize = (long) statFs.getBlockSize();
        long blockCount = (long) statFs.getBlockCount();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        long j8 = blockSize * blockCount;
        long j9 = blockSize * availableBlocks;
        int round = blockCount > 0 ? Math.round((((float) availableBlocks) * 100.0f) / ((float) blockCount)) : -1;
        boolean equals = com.tencent.mm.loader.j.b.aKE().equals(path);
        if (!equals) {
            StatFs statFs2 = new StatFs(com.tencent.mm.loader.j.b.aKE());
            j6 = (long) statFs2.getBlockSize();
            j5 = (long) statFs2.getBlockCount();
            j4 = (long) statFs2.getAvailableBlocks();
            long j10 = j6 * j5;
            long j11 = j6 * j4;
            if (j5 > 0) {
                i2 = Math.round((((float) j4) * 100.0f) / ((float) j5));
                j2 = j11;
                j3 = j10;
            } else {
                i2 = round;
                j2 = j11;
                j3 = j10;
            }
        } else {
            i2 = round;
            j2 = j9;
            j3 = j8;
            j4 = availableBlocks;
            j5 = blockCount;
            j6 = blockSize;
        }
        int round2 = Math.round((((float) aVar.oJj) * 100.0f) / ((float) j3));
        sDStatusInfo.weChatPer_ = round2;
        bVar.n(1, aVar.oJj, bVar.zEU * 1024 * 1024);
        sDStatusInfo.sizeHeavy_ = aVar.oJj > (bVar.zEU * 1024) * 1024 ? 1 : 0;
        bVar.n(2, (long) round2, bVar.zEV);
        sDStatusInfo.ratioHeavy_ = ((long) round2) > bVar.zEV ? 1 : 0;
        StringBuilder append = new StringBuilder().append(round2).append(";").append(equals ? 1 : 0).append(";");
        if (hasUnRemovableStorage) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        String sb = append.append(i3).append(";").append(j6).append(":").append(j5).append(":").append(j4).append(":").append(j3).append(":").append(j2).append(":").append(i2).append("|").append(blockSize).append(":").append(blockCount).append(":").append(availableBlocks).append(":").append(j8).append(":").append(j9).append(":").append(round).append(";").append(path).append(";").append(com.tencent.mm.loader.j.b.aKE()).append(";").append(fileSystem).toString();
        sDStatusInfo.sBlockSize_ = j6;
        sDStatusInfo.sBlockCount_ = j5;
        sDStatusInfo.sAvailableBlockCount_ = j4;
        sDStatusInfo.sTotalSize_ = j3;
        sDStatusInfo.sAvailableSize_ = j2;
        sDStatusInfo.sAvailablePer_ = i2;
        sDStatusInfo.eBlockSize_ = blockSize;
        sDStatusInfo.eBlockCount_ = blockCount;
        sDStatusInfo.eAvailableBlockCount_ = availableBlocks;
        sDStatusInfo.eTotalSize_ = j8;
        sDStatusInfo.eAvailableSize_ = j9;
        sDStatusInfo.eAvailablePer_ = round;
        sDStatusInfo.ePath_ = path;
        sDStatusInfo.root_ = com.tencent.mm.loader.j.b.aKE();
        sDStatusInfo.fSystem_ = fileSystem;
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 2, 3, path);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 2, 4, com.tencent.mm.loader.j.b.aKE());
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[3];
        objArr[0] = 2;
        objArr[1] = 5;
        objArr[2] = Integer.valueOf(equals ? 1 : 0);
        hVar.a(13778, false, false, true, objArr);
        com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr2 = new Object[3];
        objArr2[0] = 2;
        objArr2[1] = 6;
        objArr2[2] = Integer.valueOf(hasUnRemovableStorage ? 1 : 0);
        hVar2.a(13778, false, false, true, objArr2);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 2, 7, fileSystem);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 2, 8, Long.valueOf(sDStatusInfo.sTotalSize_));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 2, 9, Long.valueOf(sDStatusInfo.sAvailableSize_));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 2, 10, Integer.valueOf(sDStatusInfo.sAvailablePer_));
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 6, 1001, Integer.valueOf(round2));
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo phoneResult[%d][%s]", Integer.valueOf(sb.length()), sb);
        String str4 = str2 + ";" + sb;
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo totalResult[%d][%s]", Integer.valueOf(str4.length()), str4);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(418, 5, 1, true);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13778, false, false, true, 2, 1, str4);
        com.tencent.mm.plugin.report.service.h.INSTANCE.c(14375, log_14375);
        AppMethodBeat.o(51532);
    }

    static /* synthetic */ a.C1484a a(b bVar, final a aVar) {
        AppMethodBeat.i(51533);
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan");
        g.aAi();
        if (!g.aAh().isSDCardAvailable()) {
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan failed as sdcard not available");
            aVar.a(-1, null);
            AppMethodBeat.o(51533);
            return null;
        }
        HashMap hashMap = new HashMap();
        for (k.a aVar2 : com.tencent.mm.vfs.g.hYQ().hYT().hek()) {
            String str = aVar2.basePath;
            String str2 = aVar2.Rdc;
            LinkedList linkedList = (LinkedList) hashMap.get(str2 + FilePathGenerator.ANDROID_DIR_SEP);
            if (linkedList == null) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(str);
                hashMap.put(str2 + FilePathGenerator.ANDROID_DIR_SEP, linkedList2);
            } else {
                linkedList.add(str);
            }
        }
        String aKJ = com.tencent.mm.loader.j.b.aKJ();
        final o oVar = new o(aKJ);
        if (!oVar.exists() || !oVar.isDirectory()) {
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan failed as path not exists[%s]", aKJ);
            aVar.a(-1, null);
            AppMethodBeat.o(51533);
            return null;
        }
        Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan root[%s] exist[%b], diretory[%b]", aKJ, Boolean.valueOf(oVar.exists()), Boolean.valueOf(oVar.isDirectory()));
        final HashMap hashMap2 = new HashMap(73);
        g.aAi();
        String str3 = g.aAh().hqG;
        if (!a(hashMap, hashMap2, "voice/", 1)) {
            String str4 = str3 + "voice/";
            hashMap2.put(str4.substring(0, str4.length() - 1), 1);
        }
        if (!a(hashMap, hashMap2, "voice2/", 2)) {
            String str5 = str3 + "voice2/";
            hashMap2.put(str5.substring(0, str5.length() - 1), 2);
        }
        if (!a(hashMap, hashMap2, "image/", 3)) {
            String str6 = str3 + "image/";
            hashMap2.put(str6.substring(0, str6.length() - 1), 3);
        }
        if (!a(hashMap, hashMap2, "image2/", 4)) {
            String str7 = str3 + "image2/";
            hashMap2.put(str7.substring(0, str7.length() - 1), 4);
        }
        if (!a(hashMap, hashMap2, "sfs/", 5)) {
            String str8 = str3 + "sfs/";
            hashMap2.put(str8.substring(0, str8.length() - 1), 5);
        }
        if (!a(hashMap, hashMap2, "avatar/", 6)) {
            hashMap2.put(com.tencent.mm.plugin.avatar.c.ceF().substring(0, com.tencent.mm.plugin.avatar.c.ceF().length() - 1), 6);
        }
        if (!a(hashMap, hashMap2, "emoji/", 7)) {
            String str9 = str3 + "emoji/";
            hashMap2.put(str9.substring(0, str9.length() - 1), 7);
        }
        if (!a(hashMap, hashMap2, "video/", 8)) {
            String str10 = str3 + "video/";
            hashMap2.put(str10.substring(0, str10.length() - 1), 8);
        }
        if (!a(hashMap, hashMap2, "package/", 9)) {
            hashMap2.put(com.tencent.mm.plugin.h.a.aTf().substring(0, com.tencent.mm.plugin.h.a.aTf().length() - 1), 9);
        }
        if (!a(hashMap, hashMap2, "mailapp/", 10)) {
            String str11 = str3 + "mailapp/";
            hashMap2.put(str11.substring(0, str11.length() - 1), 10);
        }
        if (!a(hashMap, hashMap2, "openapi/", 11)) {
            hashMap2.put(com.tencent.mm.plugin.r.a.eAO().substring(0, com.tencent.mm.plugin.r.a.eAO().length() - 1), 11);
        }
        if (!a(hashMap, hashMap2, "attachment/", 12)) {
            String str12 = str3 + "attachment/";
            hashMap2.put(str12.substring(0, str12.length() - 1), 12);
        }
        g.af(com.tencent.mm.al.q.class);
        if (!a(hashMap, hashMap2, "brandicon/", 13)) {
            hashMap2.put(((com.tencent.mm.al.q) g.af(com.tencent.mm.al.q.class)).aTh().substring(0, ((com.tencent.mm.al.q) g.af(com.tencent.mm.al.q.class)).aTh().length() - 1), 13);
        }
        if (!a(hashMap, hashMap2, "voiceremind/", 14)) {
            String str13 = str3 + "voiceremind/";
            hashMap2.put(str13.substring(0, str13.length() - 1), 14);
        }
        if (!a(hashMap, hashMap2, "recbiz/", 15)) {
            hashMap2.put(com.tencent.mm.plugin.record.b.aTb().substring(0, com.tencent.mm.plugin.record.b.aTb().length() - 1), 15);
        }
        hashMap2.put(com.tencent.mm.bg.b.bfO().substring(0, com.tencent.mm.bg.b.bfO().length() - 1), 16);
        if (!a(hashMap, hashMap2, "favorite/", 17)) {
            hashMap2.put(ap.aTc().substring(0, ap.aTc().length() - 1), 17);
        }
        if (!a(hashMap, hashMap2, "draft/", 18)) {
            String str14 = str3 + "draft/";
            hashMap2.put(str14.substring(0, str14.length() - 1), 18);
        }
        if (!a(hashMap, hashMap2, "record/", 19)) {
            String str15 = str3 + "record/";
            hashMap2.put(str15.substring(0, str15.length() - 1), 19);
        }
        if (!a(hashMap, hashMap2, "sns/", 20)) {
            hashMap2.put(((com.tencent.mm.plugin.sns.b.c) g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath().substring(0, ((com.tencent.mm.plugin.sns.b.c) g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath().length() - 1), 20);
        }
        if (!a(hashMap, hashMap2, "wenote/", 21)) {
            String str16 = str3 + "wenote/";
            hashMap2.put(str16.substring(0, str16.length() - 1), 21);
        }
        if (!a(hashMap, hashMap2, "remark/", 22)) {
            hashMap2.put(com.tencent.mm.plugin.w.a.eMT().substring(0, com.tencent.mm.plugin.w.a.eMT().length() - 1), 22);
        }
        if (!a(hashMap, hashMap2, "xlog/", 23)) {
            hashMap2.put(com.tencent.mm.loader.j.b.aKQ(), 23);
        }
        if (!a(hashMap, hashMap2, "Download/", 24)) {
            hashMap2.put(com.tencent.mm.loader.j.b.aKM().substring(0, com.tencent.mm.loader.j.b.aKM().length() - 1), 24);
        }
        if (!a(hashMap, hashMap2, "Game/", 25)) {
            hashMap2.put(com.tencent.mm.loader.j.b.aKO().substring(0, com.tencent.mm.loader.j.b.aKO().length() - 1), 25);
        }
        hashMap2.put(com.tencent.mm.loader.j.b.aKV().substring(0, com.tencent.mm.loader.j.b.aKV().length() - 1), 26);
        String str17 = str3 + "avatar/";
        hashMap2.put(str17.substring(0, str17.length() - 1), 27);
        if (!a(hashMap, hashMap2, "backupRecover/", 28)) {
            String str18 = str3 + "backupRecover/";
            hashMap2.put(str18.substring(0, str18.length() - 1), 28);
        }
        if (!a(hashMap, hashMap2, "bizimg/", 29)) {
            String str19 = str3 + "bizimg/";
            hashMap2.put(str19.substring(0, str19.length() - 1), 29);
        }
        String str20 = str3 + "bizmsg/";
        hashMap2.put(str20.substring(0, str20.length() - 1), 30);
        String str21 = str3 + "boots/";
        hashMap2.put(str21.substring(0, str21.length() - 1), 31);
        String str22 = str3 + "dbback/";
        hashMap2.put(str22.substring(0, str22.length() - 1), 32);
        String str23 = str3 + "locallog/";
        hashMap2.put(str23.substring(0, str23.length() - 1), 33);
        String str24 = str3 + "logcat/";
        hashMap2.put(str24.substring(0, str24.length() - 1), 34);
        if (!a(hashMap, hashMap2, "msgsynchronize/", 35)) {
            String str25 = str3 + "msgsynchronize/";
            hashMap2.put(str25.substring(0, str25.length() - 1), 35);
        }
        String str26 = str3 + "music/";
        hashMap2.put(str26.substring(0, str26.length() - 1), 36);
        if (!a(hashMap, hashMap2, "oneday/", 37)) {
            hashMap2.put(((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getAccStoryPath().substring(0, ((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getAccStoryPath().length() - 1), 37);
        }
        if (!a(hashMap, hashMap2, "openim/", 38)) {
            String str27 = str3 + "openim/";
            hashMap2.put(str27.substring(0, str27.length() - 1), 38);
        }
        String str28 = str3 + "story/";
        hashMap2.put(str28.substring(0, str28.length() - 1), 39);
        hashMap2.put(com.tencent.mm.loader.j.b.aKX().substring(0, com.tencent.mm.loader.j.b.aKX().length() - 1), 40);
        hashMap2.put(com.tencent.mm.loader.j.b.aKR().substring(0, com.tencent.mm.loader.j.b.aKR().length() - 1), 41);
        hashMap2.put(com.tencent.mm.plugin.downloader.model.b.qIb.substring(0, com.tencent.mm.plugin.downloader.model.b.qIb.length() - 1), 42);
        hashMap2.put(com.tencent.mm.loader.j.b.aLc().substring(0, com.tencent.mm.loader.j.b.aLc().length() - 1), 43);
        hashMap2.put(com.tencent.mm.loader.j.b.aKS().substring(0, com.tencent.mm.loader.j.b.aKS().length() - 1), 44);
        hashMap2.put(com.tencent.mm.loader.j.b.aLd().substring(0, com.tencent.mm.loader.j.b.aLd().length() - 1), 45);
        if (!a(hashMap, hashMap2, "CDNTemp/", 46)) {
            hashMap2.put(com.tencent.mm.loader.j.b.aKP().substring(0, com.tencent.mm.loader.j.b.aKP().length() - 1), 46);
        }
        hashMap2.put(com.tencent.mm.loader.j.b.aLe().substring(0, com.tencent.mm.loader.j.b.aLe().length() - 1), 47);
        hashMap2.put(com.tencent.mm.loader.j.b.aLf().substring(0, com.tencent.mm.loader.j.b.aLf().length() - 1), 48);
        hashMap2.put(com.tencent.mm.loader.j.b.aLg().substring(0, com.tencent.mm.loader.j.b.aLg().length() - 1), 49);
        hashMap2.put(com.tencent.mm.loader.j.b.aKZ().substring(0, com.tencent.mm.loader.j.b.aKZ().length() - 1), 50);
        hashMap2.put(com.tencent.mm.loader.j.b.aLh().substring(0, com.tencent.mm.loader.j.b.aLh().length() - 1), 51);
        hashMap2.put(com.tencent.mm.loader.j.b.aLi().substring(0, com.tencent.mm.loader.j.b.aLi().length() - 1), 52);
        hashMap2.put(com.tencent.mm.loader.j.b.aLj().substring(0, com.tencent.mm.loader.j.b.aLj().length() - 1), 53);
        hashMap2.put(com.tencent.mm.loader.j.b.aLk().substring(0, com.tencent.mm.loader.j.b.aLk().length() - 1), 54);
        hashMap2.put(com.tencent.mm.loader.j.b.aLa().substring(0, com.tencent.mm.loader.j.b.aLa().length() - 1), 55);
        hashMap2.put(com.tencent.mm.loader.j.b.aLl().substring(0, com.tencent.mm.loader.j.b.aLl().length() - 1), 56);
        hashMap2.put(com.tencent.mm.loader.j.b.aLm().substring(0, com.tencent.mm.loader.j.b.aLm().length() - 1), 57);
        hashMap2.put(com.tencent.mm.loader.j.b.aLn().substring(0, com.tencent.mm.loader.j.b.aLn().length() - 1), 58);
        if (!a(hashMap, hashMap2, "sns_ad_landingpages/", 59)) {
            hashMap2.put(com.tencent.mm.loader.j.b.aLp().substring(0, com.tencent.mm.loader.j.b.aLp().length() - 1), 59);
        }
        hashMap2.put(com.tencent.mm.loader.j.b.aLq().substring(0, com.tencent.mm.loader.j.b.aLq().length() - 1), 60);
        hashMap2.put(com.tencent.mm.loader.j.b.aLr().substring(0, com.tencent.mm.loader.j.b.aLr().length() - 1), 61);
        if (!a(hashMap, hashMap2, "vproxy/", 62)) {
            hashMap2.put(com.tencent.mm.loader.j.b.aLs().substring(0, com.tencent.mm.loader.j.b.aLs().length() - 1), 62);
        }
        hashMap2.put(com.tencent.mm.loader.j.b.aKN().substring(0, com.tencent.mm.loader.j.b.aKN().length() - 1), 63);
        hashMap2.put(com.tencent.mm.loader.j.b.aLt().substring(0, com.tencent.mm.loader.j.b.aLt().length() - 1), 64);
        if (!a(hashMap, hashMap2, "wallet/", 65)) {
            hashMap2.put(com.tencent.mm.loader.j.b.aLu().substring(0, com.tencent.mm.loader.j.b.aLu().length() - 1), 65);
        }
        hashMap2.put(com.tencent.mm.loader.j.b.aKY().substring(0, com.tencent.mm.loader.j.b.aKY().length() - 1), 66);
        hashMap2.put(com.tencent.mm.loader.j.b.aLb().substring(0, com.tencent.mm.loader.j.b.aLb().length() - 1), 67);
        hashMap2.put(com.tencent.mm.loader.j.b.aLv().substring(0, com.tencent.mm.loader.j.b.aLv().length() - 1), 68);
        hashMap2.put(com.tencent.mm.loader.j.b.aLw().substring(0, com.tencent.mm.loader.j.b.aLw().length() - 1), 69);
        hashMap2.put(com.tencent.mm.loader.j.b.aLx().substring(0, com.tencent.mm.loader.j.b.aLx().length() - 1), 70);
        hashMap2.put(com.tencent.mm.loader.j.b.aLy().substring(0, com.tencent.mm.loader.j.b.aLy().length() - 1), 71);
        hashMap2.put(com.tencent.mm.loader.j.b.aLz().substring(0, com.tencent.mm.loader.j.b.aLz().length() - 1), 72);
        String str29 = str3 + "scanner/";
        hashMap2.put(str29.substring(0, str29.length() - 1), 73);
        hashMap2.put(com.tencent.mm.loader.j.b.aKH().substring(0, com.tencent.mm.loader.j.b.aKH().length() - 1), 74);
        hashMap2.put(com.tencent.mm.loader.j.b.aKL().substring(0, com.tencent.mm.loader.j.b.aKL().length() - 1), 75);
        hashMap2.put(com.tencent.mm.loader.j.b.aLo().substring(0, com.tencent.mm.loader.j.b.aLo().length() - 1), 76);
        hashMap2.put(com.tencent.mm.loader.j.b.aLA().substring(0, com.tencent.mm.loader.j.b.aLA().length() - 1), 77);
        hashMap2.put(com.tencent.mm.loader.j.b.aLB().substring(0, com.tencent.mm.loader.j.b.aLB().length() - 1), 78);
        hashMap2.put(com.tencent.mm.loader.j.b.aLC().substring(0, com.tencent.mm.loader.j.b.aLC().length() - 1), 79);
        hashMap2.put(com.tencent.mm.loader.j.b.aLD().substring(0, com.tencent.mm.loader.j.b.aLD().length() - 1), 80);
        if (!a(hashMap, hashMap2, "favoffline/", 81)) {
            hashMap2.put(com.tencent.mm.loader.j.b.aLE().substring(0, com.tencent.mm.loader.j.b.aLE().length() - 1), 81);
        }
        if (!a(hashMap, hashMap2, "finder/", 82)) {
            String str30 = str3 + "finder/";
            hashMap2.put(str30.substring(0, str30.length() - 1), 82);
        }
        String str31 = str3 + "shakemusic/";
        hashMap2.put(str31.substring(0, str31.length() - 1), 83);
        String str32 = str3 + "recordPlugin/";
        hashMap2.put(str32.substring(0, str32.length() - 1), 84);
        String str33 = str3 + "audio/";
        hashMap2.put(str33.substring(0, str33.length() - 1), 85);
        final a.C1484a aVar3 = new a.C1484a(aa.z(oVar.her()));
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.monitor.b.AnonymousClass16 */
            final Map<String, Integer> zFC = hashMap2;

            {
                AppMethodBeat.i(163493);
                AppMethodBeat.o(163493);
            }

            public final void run() {
                AppMethodBeat.i(163494);
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan start fileScanResult[%s], subDirMap[%d]", aVar3, Integer.valueOf(hashMap2.size()));
                long currentTimeMillis = System.currentTimeMillis();
                b.a(b.this, oVar, aVar3, this.zFC);
                if (hashMap2.size() > 0) {
                    Iterator it = hashMap2.entrySet().iterator();
                    while (it != null && it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        aVar3.zER.add(new a.b((String) entry.getKey(), ((Integer) entry.getValue()).intValue()));
                    }
                }
                aVar3.dtZ = System.currentTimeMillis() - currentTimeMillis;
                Log.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan end takes[%d], emptySubDir[%d], fileScanResult[%s], tid[%d]", Long.valueOf(aVar3.dtZ), Integer.valueOf(hashMap2.values().size()), aVar3, Long.valueOf(Thread.currentThread().getId()));
                aVar.a(0, aVar3);
                AppMethodBeat.o(163494);
            }
        }, "summerhv_scanFile");
        AppMethodBeat.o(51533);
        return aVar3;
    }

    static /* synthetic */ long r(b bVar) {
        AppMethodBeat.i(51536);
        g.aAi();
        if (!g.aAh().isSDCardAvailable()) {
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as sdcard not available");
            AppMethodBeat.o(51536);
            return 0;
        }
        o oVar = new o(com.tencent.mm.loader.j.b.aKQ());
        if (!oVar.exists() || !oVar.isDirectory()) {
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as path not exist");
            AppMethodBeat.o(51536);
            return 0;
        }
        o[] het = oVar.het();
        if (het == null || het.length == 0) {
            Log.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as no files");
            AppMethodBeat.o(51536);
            return 0;
        }
        Arrays.sort(het, new Comparator<o>() {
            /* class com.tencent.mm.plugin.monitor.b.AnonymousClass5 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(o oVar, o oVar2) {
                AppMethodBeat.i(163486);
                long lastModified = oVar.lastModified() - oVar2.lastModified();
                if (lastModified > 0) {
                    AppMethodBeat.o(163486);
                    return 1;
                } else if (lastModified == 0) {
                    AppMethodBeat.o(163486);
                    return 0;
                } else {
                    AppMethodBeat.o(163486);
                    return -1;
                }
            }

            public final boolean equals(Object obj) {
                return true;
            }
        });
        long j2 = 0;
        for (o oVar2 : het) {
            String name = oVar2.getName();
            if (!Util.isNullOrNil(name) && name.endsWith(".xlog")) {
                j2 = Util.getLong(name.substring(name.length() - 13, name.length() - 5), 0);
                if (j2 > 0) {
                    break;
                }
            }
        }
        AppMethodBeat.o(51536);
        return j2;
    }
}
