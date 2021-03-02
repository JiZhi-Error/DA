package com.tencent.mm.plugin.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Looper;
import android.os.PowerManager;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.mj;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.f.a.a;
import com.tencent.mm.plugin.f.a.f;
import com.tencent.mm.plugin.f.c.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.smtt.sdk.TbsDownloader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class b implements c, com.tencent.mm.kernel.b.c {
    private static HashMap<Integer, h.b> kvw;
    private static b pPK;
    private boolean cSX = false;
    private i.a gsV = new i.a() {
        /* class com.tencent.mm.plugin.f.b.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
        public final void a(i iVar, final i.c cVar) {
            AppMethodBeat.i(22686);
            if (CrashReportFactory.isBackupMerge()) {
                AppMethodBeat.o(22686);
            } else if (iVar == null) {
                AppMethodBeat.o(22686);
            } else if (cVar == null || cVar.hIs == null) {
                AppMethodBeat.o(22686);
            } else {
                b.a(b.this, new Runnable() {
                    /* class com.tencent.mm.plugin.f.b.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        boolean z;
                        AppMethodBeat.i(22685);
                        Log.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", cVar.zqn, Integer.valueOf(cVar.hIs.size()));
                        if ("delete".equals(cVar.zqn)) {
                            AppMethodBeat.o(22685);
                            return;
                        }
                        int i2 = "delete".equals(cVar.zqn) ? 2 : 1;
                        Iterator<ca> it = cVar.hIs.iterator();
                        while (it.hasNext()) {
                            ca next = it.next();
                            if (next != null) {
                                b bVar = b.this;
                                long j2 = next.field_msgId;
                                if (bVar.pPO) {
                                    z = bVar.pPN.contains(Long.valueOf(j2));
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    Log.d("MicroMsg.CalcWxService", "it locked now [%d]", Long.valueOf(next.field_msgId));
                                } else {
                                    b.this.pPL.postToWorker(new com.tencent.mm.plugin.f.c.b(next, i2));
                                }
                            }
                        }
                        AppMethodBeat.o(22685);
                    }
                });
                AppMethodBeat.o(22686);
            }
        }
    };
    private HashMap<Integer, a> iLv = new HashMap<>();
    private r.a kvx;
    private com.tencent.mm.plugin.f.b.b pPJ;
    private MMHandler pPL;
    private d pPM = null;
    public HashSet<Long> pPN = new HashSet<>();
    public boolean pPO = false;
    private boolean pPP = false;
    public d pPQ = null;
    com.tencent.mm.plugin.f.c.c pPR = null;
    private d.a pPS = new d.a() {
        /* class com.tencent.mm.plugin.f.b.AnonymousClass8 */

        @Override // com.tencent.mm.plugin.f.c.d.a
        public final void finish() {
            AppMethodBeat.i(22697);
            b.a(b.this, new Runnable() {
                /* class com.tencent.mm.plugin.f.b.AnonymousClass8.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(22696);
                    b.this.pPQ = null;
                    b.this.kt(false);
                    AppMethodBeat.o(22696);
                }
            });
            AppMethodBeat.o(22697);
        }
    };
    private d.a pPT = new d.a() {
        /* class com.tencent.mm.plugin.f.b.AnonymousClass13 */

        @Override // com.tencent.mm.plugin.f.c.d.a
        public final void finish() {
            AppMethodBeat.i(22703);
            b.a(b.this, new Runnable() {
                /* class com.tencent.mm.plugin.f.b.AnonymousClass13.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(22702);
                    b.this.pPM = null;
                    b.i(b.this);
                    AppMethodBeat.o(22702);
                }
            });
            AppMethodBeat.o(22703);
        }
    };
    private IListener<cv> pPU = new IListener<cv>() {
        /* class com.tencent.mm.plugin.f.b.AnonymousClass3 */

        {
            AppMethodBeat.i(161311);
            this.__eventId = cv.class.getName().hashCode();
            AppMethodBeat.o(161311);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(cv cvVar) {
            AppMethodBeat.i(22688);
            final cv cvVar2 = cvVar;
            b.a(b.this, new Runnable() {
                /* class com.tencent.mm.plugin.f.b.AnonymousClass3.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(22687);
                    if (cvVar2 == null) {
                        AppMethodBeat.o(22687);
                    } else if (Util.isNullOrNil(cvVar2.dFX.talker)) {
                        AppMethodBeat.o(22687);
                    } else {
                        try {
                            com.tencent.mm.plugin.f.b.b crX = b.crW().crX();
                            long j2 = cvVar2.dFX.msgId;
                            String str = cvVar2.dFX.talker;
                            int i2 = cvVar2.dFX.msgType;
                            Log.i("MicroMsg.WxFileIndexStorage", "delete by msg [%d %d %s] result[%d]", Long.valueOf(j2), Integer.valueOf(i2), str, Integer.valueOf(crX.db.delete("WxFileIndex2", "msgId=? AND msgType=? AND username=? ", new String[]{String.valueOf(j2), String.valueOf(i2), str})));
                            AppMethodBeat.o(22687);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.CalcWxService", e2, "", new Object[0]);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(664, 6, 1, false);
                            AppMethodBeat.o(22687);
                        }
                    }
                }
            });
            AppMethodBeat.o(22688);
            return false;
        }
    };
    private boolean pPV = true;
    private BroadcastReceiver pPW;
    private Runnable pPX;
    private boolean pPY = false;
    private IListener<com.tencent.mm.g.a.ca> pPZ = new IListener<com.tencent.mm.g.a.ca>() {
        /* class com.tencent.mm.plugin.f.b.AnonymousClass5 */

        {
            AppMethodBeat.i(161312);
            this.__eventId = com.tencent.mm.g.a.ca.class.getName().hashCode();
            AppMethodBeat.o(161312);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.ca caVar) {
            AppMethodBeat.i(22693);
            boolean csf = csf();
            AppMethodBeat.o(22693);
            return csf;
        }

        private boolean csf() {
            AppMethodBeat.i(22692);
            Log.i("MicroMsg.CalcWxService", "%s clean wx file index event ", b.this.bgQ());
            b.this.pPY = true;
            try {
                g.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.f.b.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(22691);
                        g.aAh().azQ().set(ar.a.USERINFO_CALC_WX_SCAN_MAX_MSGID2_LONG, (Object) -1L);
                        g.aAh().azQ().set(ar.a.USERINFO_CALC_WX_SCAN_CURR_MSGID2_LONG, (Object) 0L);
                        g.aAh().azQ().gBI();
                        b.crW().crX().delete();
                        b.this.pPY = false;
                        AppMethodBeat.o(22691);
                    }
                });
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.CalcWxService", e2, "%s clean wx file error", b.this.bgQ());
            }
            AppMethodBeat.o(22692);
            return false;
        }
    };

    public b() {
        AppMethodBeat.i(22704);
        AppMethodBeat.o(22704);
    }

    static /* synthetic */ void a(b bVar, Runnable runnable) {
        AppMethodBeat.i(22722);
        bVar.post(runnable);
        AppMethodBeat.o(22722);
    }

    static /* synthetic */ void m(b bVar) {
        AppMethodBeat.i(22724);
        bVar.stopScan();
        AppMethodBeat.o(22724);
    }

    static {
        AppMethodBeat.i(22725);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        kvw = hashMap;
        hashMap.put(Integer.valueOf("WXFILEINDEX_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.f.b.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.f.b.b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(22725);
    }

    public static synchronized b crW() {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(22705);
            if (pPK == null) {
                pPK = new b();
            }
            bVar = pPK;
            AppMethodBeat.o(22705);
        }
        return bVar;
    }

    public final com.tencent.mm.plugin.f.b.b crX() {
        AppMethodBeat.i(22706);
        if (this.pPJ == null) {
            this.pPJ = new com.tencent.mm.plugin.f.b.b(this.kvx);
        }
        com.tencent.mm.plugin.f.b.b bVar = this.pPJ;
        AppMethodBeat.o(22706);
        return bVar;
    }

    public final void post(Runnable runnable) {
        AppMethodBeat.i(22707);
        try {
            if (this.pPL != null) {
                this.pPL.postToWorker(runnable);
                AppMethodBeat.o(22707);
                return;
            }
            Log.w("MicroMsg.CalcWxService", "%s post runnable but thread is null ", bgQ());
            AppMethodBeat.o(22707);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CalcWxService", e2, "post error: [%s]", e2.toString());
            AppMethodBeat.o(22707);
        }
    }

    public final void kt(final boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(22708);
        Object[] objArr = new Object[3];
        objArr[0] = bgQ();
        if (this.pPQ != null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        objArr[2] = Boolean.valueOf(z);
        Log.d("MicroMsg.CalcWxService", "%s manual scan now manualScanTask[%b] uiClick[%b]", objArr);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.f.b.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(22694);
                if (z) {
                    b.this.pPP = true;
                }
                if (!b.this.pPP) {
                    AppMethodBeat.o(22694);
                    return;
                }
                if (b.this.pPQ == null) {
                    mj mjVar = new mj();
                    if (b.this.csb()) {
                        b.this.pPP = false;
                        mjVar.dRJ.dgZ = true;
                        EventCenter.instance.publish(mjVar);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(664, 9, 1, false);
                        AppMethodBeat.o(22694);
                        return;
                    }
                    if (z) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(664, 7, 1, false);
                    }
                    mjVar.dRJ.progress = b.csd();
                    mjVar.dRJ.total = b.csa();
                    mjVar.dRJ.dgZ = false;
                    EventCenter.instance.publish(mjVar);
                    b.this.pPQ = new d("message", b.csd(), b.cse(), b.this.pPS);
                    b.this.pPL.postToWorker(b.this.pPQ);
                    if (((Long) g.aAh().azQ().get(ar.a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, (Object) 0L)).longValue() <= 0) {
                        g.aAh().azQ().set(ar.a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, Long.valueOf(Util.nowSecond()));
                    }
                }
                AppMethodBeat.o(22694);
            }
        });
        AppMethodBeat.o(22708);
    }

    public final void crY() {
        boolean z = false;
        AppMethodBeat.i(22709);
        final o[] a2 = new o(com.tencent.mm.loader.j.b.aKJ()).a(new q() {
            /* class com.tencent.mm.plugin.f.b.AnonymousClass9 */

            @Override // com.tencent.mm.vfs.q
            public final boolean accept(o oVar) {
                AppMethodBeat.i(22698);
                if (oVar.isDirectory()) {
                    AppMethodBeat.o(22698);
                    return false;
                } else if (oVar.getName().endsWith(".apk") || oVar.getName().endsWith(".temp")) {
                    AppMethodBeat.o(22698);
                    return true;
                } else {
                    AppMethodBeat.o(22698);
                    return false;
                }
            }
        });
        if (a2 != null && a2.length > 0) {
            Object[] objArr = new Object[2];
            objArr[0] = bgQ();
            if (this.pPQ != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            Log.i("MicroMsg.CalcWxService", "%s stop manual scan now manualScanTask[%b]", objArr);
            post(new Runnable() {
                /* class com.tencent.mm.plugin.f.b.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(22699);
                    if (a2 == null || a2.length == 0) {
                        Log.e("MicroMsg.CalcWxService", "apkList is null or 0");
                        AppMethodBeat.o(22699);
                        return;
                    }
                    o[] oVarArr = a2;
                    int i2 = 0;
                    o oVar = null;
                    o oVar2 = null;
                    for (o oVar3 : oVarArr) {
                        if (oVar3.getName().endsWith(".temp")) {
                            if (Util.milliSecondsToNow(oVar3.lastModified()) > Util.MILLSECONDS_OF_DAY) {
                                oVar3.delete();
                            } else if (oVar == null) {
                                oVar = oVar3;
                            } else if (oVar3.lastModified() > oVar.lastModified()) {
                                oVar.delete();
                                oVar = oVar3;
                            } else {
                                oVar3.delete();
                            }
                        } else if (oVar3.getName().endsWith(".apk")) {
                            PackageInfo packageArchiveInfo = MMApplicationContext.getContext().getPackageManager().getPackageArchiveInfo(aa.z(oVar3.her()), 128);
                            if (packageArchiveInfo != null) {
                                if (packageArchiveInfo.packageName == null || packageArchiveInfo.packageName.equals(MMApplicationContext.getApplicationId())) {
                                    ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                                    if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                                        int i3 = applicationInfo.metaData.getInt(TbsDownloader.TBS_METADATA);
                                        Log.d("MicroMsg.CalcWxService", "startCleanAPKFiles:%d, currentVersion;%d", Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.protocal.d.KyO));
                                        if (i3 <= com.tencent.mm.protocal.d.KyO) {
                                            oVar3.delete();
                                        } else if (oVar2 == null) {
                                            i2 = i3;
                                            oVar2 = oVar3;
                                        } else if (i3 > i2) {
                                            oVar2.delete();
                                            i2 = i3;
                                            oVar2 = oVar3;
                                        } else {
                                            oVar3.delete();
                                        }
                                    }
                                } else {
                                    oVar3.delete();
                                }
                            }
                            if (i2 != 0) {
                                oVar3.delete();
                            } else if (oVar2 == null) {
                                oVar2 = oVar3;
                            } else if (oVar3.lastModified() > oVar2.lastModified()) {
                                oVar2.delete();
                                oVar2 = oVar3;
                            } else {
                                oVar3.delete();
                            }
                        }
                    }
                    AppMethodBeat.o(22699);
                }
            });
        }
        AppMethodBeat.o(22709);
    }

    public static void crZ() {
        AppMethodBeat.i(231649);
        if (Util.getInt(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_delete_oversize_sns_db", AppEventsConstants.EVENT_PARAM_VALUE_NO, false, true), 0) > 0) {
            StringBuilder sb = new StringBuilder();
            g.aAi();
            long length = new o(sb.append(g.aAh().cachePath).append("SnsMicroMsg.db").toString()).length();
            long j2 = Util.getLong(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_clean_db_count", Long.toString(50000), false, true), 50000);
            long feV = aj.faO().feV();
            if (feV > j2) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(150, 101);
                aj.fbi();
                StringBuilder sb2 = new StringBuilder();
                g.aAi();
                long length2 = new o(sb2.append(g.aAh().cachePath).append("SnsMicroMsg.db").toString()).length();
                long feV2 = aj.faO().feV();
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(150, 102, feV - feV2);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(22134, 1, Long.valueOf(length), Long.valueOf(feV), Long.valueOf(length2), Long.valueOf(feV2));
                Log.i("MicroMsg.CalcWxService", "cleanSnsDb:%b, snsCount:%s, newSnsCount:%s, snsDbSize:%s, newSnsDbSize:%s", Boolean.TRUE, Long.valueOf(feV), Long.valueOf(feV2), Util.getSizeKB(length), Util.getSizeKB(length2));
                AppMethodBeat.o(231649);
                return;
            }
            Log.i("MicroMsg.CalcWxService", "cleanSnsDb:%b, snsCount:%s, snsDbSize:%s", Boolean.FALSE, Long.valueOf(feV), Util.getSizeKB(length));
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(22134, 0, Long.valueOf(length), Long.valueOf(feV), 0, 0);
        }
        AppMethodBeat.o(231649);
    }

    private void stopScan() {
        AppMethodBeat.i(22710);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.f.b.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(22701);
                if (b.this.pPM != null) {
                    b.this.pPM.cancel();
                    b.this.pPM.isStop = true;
                    b.this.pPM = null;
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(664, 2, 1, false);
                }
                if (b.this.pPR != null) {
                    b.this.pPR.isStop = true;
                }
                AppMethodBeat.o(22701);
            }
        });
        AppMethodBeat.o(22710);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(22711);
        Log.i("MicroMsg.CalcWxService", "%s CalcWxService Initialized", bgQ());
        if (this.pPL == null) {
            Log.i("MicroMsg.CalcWxService", "%s init calc wx thread", bgQ());
            this.pPL = new MMHandler("calc-wx");
            this.pPL.setLogging(false);
        }
        this.kvx = r.a(hashCode(), g.aAh().cachePath + "WxFileIndex.db", kvw, true);
        this.iLv.put(43, new com.tencent.mm.plugin.f.a.e());
        this.iLv.put(62, new com.tencent.mm.plugin.f.a.e());
        this.iLv.put(44, new com.tencent.mm.plugin.f.a.e());
        this.iLv.put(486539313, new com.tencent.mm.plugin.f.a.e());
        this.iLv.put(34, new f());
        this.iLv.put(3, new com.tencent.mm.plugin.f.a.d());
        this.iLv.put(49, new com.tencent.mm.plugin.f.a.c());
        this.iLv.put(268435505, new com.tencent.mm.plugin.f.a.b());
        csa();
        ((l) g.af(l.class)).eiy().a(this.gsV, (Looper) null);
        EventCenter.instance.add(this.pPU);
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
            /* class com.tencent.mm.plugin.f.b.AnonymousClass4 */

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(22690);
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
                if (!b.this.cSX || b.this.pPV) {
                    if (b.this.pPX != null) {
                        bg.aAk();
                        MMHandlerThread.removeRunnable(b.this.pPX);
                        b.this.pPX = null;
                    }
                    b.m(b.this);
                } else {
                    Log.i("MicroMsg.CalcWxService", "it is charging and screen off, 5 min to calc");
                    if (b.this.pPX == null) {
                        b.this.pPX = new Runnable() {
                            /* class com.tencent.mm.plugin.f.b.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(22689);
                                b.this.crY();
                                b.crZ();
                                Log.i("MicroMsg.CalcWxService", "start to calc");
                                if (b.this.csb()) {
                                    b bVar = b.this;
                                    long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_CALC_WX_SCAN_REPORT_TIME_LONG, (Object) 0L)).longValue();
                                    MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
                                    Log.i("MicroMsg.CalcWxService", "checkAndReport, midImgSize:%s, hevcSize:%s", Long.valueOf(mmkv.getLong("CleanCalcMidImg", 0)), Long.valueOf(mmkv.getLong("CleanCalcHevcImg", 0)));
                                    if (Util.milliSecondsToNow(longValue) >= 259200000) {
                                        if (bVar.pPR != null) {
                                            bVar.pPR.isStop = true;
                                        }
                                        bVar.pPR = new com.tencent.mm.plugin.f.c.c();
                                        bVar.post(bVar.pPR);
                                        g.aAh().azQ().set(ar.a.USERINFO_CALC_WX_SCAN_REPORT_TIME_LONG, Long.valueOf(Util.nowMilliSecond()));
                                    }
                                    AppMethodBeat.o(22689);
                                    return;
                                }
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(664, 1, 1, false);
                                b.i(b.this);
                                AppMethodBeat.o(22689);
                            }
                        };
                        bg.aAk().postToWorkerDelayed(b.this.pPX, 300000);
                        AppMethodBeat.o(22690);
                        return;
                    }
                }
                AppMethodBeat.o(22690);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.pPW, intentFilter);
        EventCenter.instance.add(this.pPZ);
        if (this.pPY) {
            EventCenter.instance.publish(new com.tencent.mm.g.a.ca());
        }
        AppMethodBeat.o(22711);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(22712);
        Log.i("MicroMsg.CalcWxService", "CalcWxService Release");
        this.pPN.clear();
        this.pPO = false;
        if (this.kvx != null) {
            this.kvx.uS(hashCode());
            this.kvx = null;
        }
        ((l) g.af(l.class)).eiy().a(this.gsV);
        EventCenter.instance.removeListener(this.pPU);
        this.iLv.clear();
        if (this.pPW != null) {
            MMApplicationContext.getContext().unregisterReceiver(this.pPW);
            this.pPW = null;
        }
        if (this.pPX != null) {
            bg.aAk();
            MMHandlerThread.removeRunnable(this.pPX);
            this.pPX = null;
        }
        stopScan();
        if (this.pPL != null) {
            Log.i("MicroMsg.CalcWxService", "%s quit calc wx thread", bgQ());
            this.pPL.quit();
        }
        this.pPL = null;
        EventCenter.instance.removeListener(this.pPZ);
        AppMethodBeat.o(22712);
    }

    public static long csa() {
        AppMethodBeat.i(22713);
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_CALC_WX_SCAN_MAX_MSGID2_LONG, (Object) -1L)).longValue();
        if (longValue <= -1) {
            longValue = ((l) g.af(l.class)).eiy().aEV("message");
            g.aAh().azQ().set(ar.a.USERINFO_CALC_WX_SCAN_MAX_MSGID2_LONG, Long.valueOf(longValue));
        }
        AppMethodBeat.o(22713);
        return longValue;
    }

    public final boolean csb() {
        AppMethodBeat.i(22714);
        long csa = csa();
        long csd = csd();
        boolean z = csd >= csa;
        Log.i("MicroMsg.CalcWxService", "%d scan finish [%d %d %b]", Integer.valueOf(hashCode()), Long.valueOf(csa), Long.valueOf(csd), Boolean.valueOf(z));
        if (z && ((Long) g.aAh().azQ().get(ar.a.USERINFO_CALC_WX_SCAN_FINISH_TIME_LONG, (Object) 0L)).longValue() <= 0) {
            g.aAh().azQ().set(ar.a.USERINFO_CALC_WX_SCAN_FINISH_TIME_LONG, Long.valueOf(Util.nowSecond()));
        }
        AppMethodBeat.o(22714);
        return z;
    }

    public final void csc() {
        AppMethodBeat.i(22715);
        this.pPO = false;
        this.pPN.clear();
        Log.d("MicroMsg.CalcWxService", "%d unlock msg change [%s]", Integer.valueOf(hashCode()), Util.getStack());
        AppMethodBeat.o(22715);
    }

    public final void an(ca caVar) {
        AppMethodBeat.i(22716);
        if (caVar == null) {
            AppMethodBeat.o(22716);
            return;
        }
        try {
            a aVar = this.iLv.get(Integer.valueOf(caVar.getType()));
            if (aVar != null) {
                aVar.ao(caVar);
            }
            AppMethodBeat.o(22716);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CalcWxService", e2, "", new Object[0]);
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(664, 5, 1, false);
            AppMethodBeat.o(22716);
        }
    }

    public static void M(int i2, long j2) {
        int i3;
        int i4 = 30;
        AppMethodBeat.i(22717);
        if (j2 <= 1000) {
            i3 = i2 + 5;
        } else {
            i3 = i2 - 5;
        }
        if (i3 <= 30) {
            i4 = i3;
        }
        if (i4 < 5) {
            i4 = 5;
        }
        g.aAh().azQ().set(ar.a.USERINFO_CALC_WX_SCAN_STEP_INT, Integer.valueOf(i4));
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(664, (long) ((Integer) com.tencent.mm.plugin.report.service.h.a(i4, new int[]{5, 10, 20, 25, 30}, 10, 15)).intValue(), 1, false);
        AppMethodBeat.o(22717);
    }

    public final void BU(long j2) {
        AppMethodBeat.i(22718);
        Log.d("MicroMsg.CalcWxService", "%d update scan msgid[%d]", Integer.valueOf(hashCode()), Long.valueOf(j2));
        g.aAh().azQ().set(ar.a.USERINFO_CALC_WX_SCAN_CURR_MSGID2_LONG, Long.valueOf(j2));
        AppMethodBeat.o(22718);
    }

    public static long csd() {
        AppMethodBeat.i(22719);
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_CALC_WX_SCAN_CURR_MSGID2_LONG, (Object) 0L)).longValue();
        AppMethodBeat.o(22719);
        return longValue;
    }

    public static int cse() {
        AppMethodBeat.i(22720);
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_CALC_WX_SCAN_STEP_INT, (Object) 5)).intValue();
        AppMethodBeat.o(22720);
        return intValue;
    }

    public final String bgQ() {
        AppMethodBeat.i(22721);
        String sb = new StringBuilder().append(hashCode()).toString();
        AppMethodBeat.o(22721);
        return sb;
    }

    static /* synthetic */ boolean e(b bVar) {
        return !bVar.pPP && bVar.cSX && !bVar.pPV;
    }

    static /* synthetic */ void i(b bVar) {
        AppMethodBeat.i(22723);
        bVar.post(new Runnable() {
            /* class com.tencent.mm.plugin.f.b.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(22700);
                if (!b.e(b.this)) {
                    if (b.this.pPM != null) {
                        b.this.pPM.isStop = true;
                        b.this.pPM = null;
                    }
                    AppMethodBeat.o(22700);
                } else if (b.this.csb()) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(664, 3, 1, false);
                    AppMethodBeat.o(22700);
                } else if (b.this.pPM != null) {
                    AppMethodBeat.o(22700);
                } else {
                    b.this.pPM = new d("message", b.csd(), b.cse(), b.this.pPT);
                    b.this.pPL.postDelayed(b.this.pPM, 2000);
                    if (((Long) g.aAh().azQ().get(ar.a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, (Object) 0L)).longValue() <= 0) {
                        g.aAh().azQ().set(ar.a.USERINFO_CALC_WX_SCAN_START_TIME_LONG, Long.valueOf(Util.nowSecond()));
                    }
                    AppMethodBeat.o(22700);
                }
            }
        });
        AppMethodBeat.o(22723);
    }
}
