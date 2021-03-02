package com.tencent.mm.plugin.fts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.yn;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.g;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class PluginFTS extends f implements com.tencent.mm.kernel.a.b.b, c, n {
    public static boolean wUa;
    private volatile g wTS;
    private volatile d wTT;
    private volatile boolean wTU = false;
    private volatile boolean wTV = false;
    private boolean wTW = false;
    private boolean wTX = false;
    private Runnable wTY = new Runnable() {
        /* class com.tencent.mm.plugin.fts.PluginFTS.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(52563);
            if (PluginFTS.this.wTT != null) {
                PluginFTS.this.wTT.rollback();
            }
            AppMethodBeat.o(52563);
        }
    };
    private DatabaseErrorHandler wTZ = new DatabaseErrorHandler() {
        /* class com.tencent.mm.plugin.fts.PluginFTS.AnonymousClass3 */

        @Override // com.tencent.wcdb.DatabaseErrorHandler
        public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
            AppMethodBeat.i(52565);
            e.Nk(18);
            g.aAi();
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_TIME_INT_SYNC, (Object) 5)).intValue();
            Log.e("MicroMsg.FTS.PluginFTS", "DB onCorrupt dbCorruptRebuildTimes: %d", Integer.valueOf(intValue));
            if (intValue > 0) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_TIME_INT_SYNC, Integer.valueOf(intValue - 1));
                try {
                    PluginFTS.access$200(PluginFTS.this);
                    PluginFTS.access$300(PluginFTS.this);
                    if (PluginFTS.this.wTT != null) {
                        PluginFTS.this.wTT.close();
                        PluginFTS.this.wTT = null;
                    }
                    d.dOq();
                    g gVar = PluginFTS.this.wTS;
                    if (gVar.wTJ != null) {
                        gVar.wTJ.wTL.clear();
                    }
                    PluginFTS.this.wTS.a(-131072, new b());
                    PluginFTS.this.wTS.a(-131071, new a(PluginFTS.this, (byte) 0));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FTS.PluginFTS", e2, "onCorruption handle error", new Object[0]);
                }
                f fVar = new f("Throw FTSStopTaskException From FTSDatabaseErrorHandler");
                AppMethodBeat.o(52565);
                throw fVar;
            }
            e.Nk(23);
            AppMethodBeat.o(52565);
        }
    };
    private cm.a wUb = new cm.a() {
        /* class com.tencent.mm.plugin.fts.PluginFTS.AnonymousClass4 */

        @Override // com.tencent.mm.model.cm.a
        public final boolean aWC() {
            AppMethodBeat.i(52566);
            Log.w("MicroMsg.FTS.PluginFTS", "HERE UninitForUEH is called! stg:%s ", PluginFTS.this.wTT);
            PluginFTS.wUa = true;
            if (PluginFTS.this.wTT != null) {
                PluginFTS.this.wTT.rollback();
                PluginFTS.this.wTT.close();
            }
            AppMethodBeat.o(52566);
            return true;
        }
    };
    private IListener wUc = new IListener<co>() {
        /* class com.tencent.mm.plugin.fts.PluginFTS.AnonymousClass5 */

        {
            AppMethodBeat.i(160974);
            this.__eventId = co.class.getName().hashCode();
            AppMethodBeat.o(160974);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(co coVar) {
            AppMethodBeat.i(52567);
            if (coVar instanceof co) {
                PluginFTS.this.wUc.dead();
                PluginFTS.this.wTV = true;
                Log.i("MicroMsg.FTS.PluginFTS", "All account post reset");
                PluginFTS.access$1200(PluginFTS.this);
            }
            AppMethodBeat.o(52567);
            return false;
        }
    };
    private IListener wUd = new IListener<d>() {
        /* class com.tencent.mm.plugin.fts.PluginFTS.AnonymousClass6 */

        {
            AppMethodBeat.i(160975);
            this.__eventId = d.class.getName().hashCode();
            AppMethodBeat.o(160975);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(d dVar) {
            boolean z;
            AppMethodBeat.i(52568);
            d dVar2 = dVar;
            g gVar = PluginFTS.this.wTS;
            boolean z2 = dVar2.dBP.dBQ;
            if (gVar.wTJ != null) {
                gVar.wTJ.pt(z2);
            }
            PluginFTS pluginFTS = PluginFTS.this;
            if (!dVar2.dBP.dBQ) {
                z = true;
            } else {
                z = false;
            }
            pluginFTS.wTX = z;
            AppMethodBeat.o(52568);
            return false;
        }
    };
    private i wUe = new i() {
        /* class com.tencent.mm.plugin.fts.PluginFTS.AnonymousClass7 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(52569);
            g.aAi();
            if (Util.nullAsNil((Integer) g.aAh().azQ().get(15, (Object) null)) != 0) {
                g.azz().b(138, PluginFTS.this.wUe);
                PluginFTS.this.wTU = true;
                Log.i("MicroMsg.FTS.PluginFTS", "*** User has finished initializing.");
                PluginFTS.access$1200(PluginFTS.this);
            }
            AppMethodBeat.o(52569);
        }
    };
    private IListener wUf = new IListener<yn>() {
        /* class com.tencent.mm.plugin.fts.PluginFTS.AnonymousClass8 */

        {
            AppMethodBeat.i(160976);
            this.__eventId = yn.class.getName().hashCode();
            AppMethodBeat.o(160976);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yn ynVar) {
            AppMethodBeat.i(52572);
            PluginFTS.this.wTS.a(131072, new com.tencent.mm.plugin.fts.a.a.a() {
                /* class com.tencent.mm.plugin.fts.PluginFTS.AnonymousClass8.AnonymousClass1 */
                String wUp = "";

                @Override // com.tencent.mm.plugin.fts.a.a.a
                public final boolean execute() {
                    AppMethodBeat.i(52570);
                    this.wUp = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
                    PluginFTS.this.wTT.W(-3, (long) this.wUp.hashCode());
                    AppMethodBeat.o(52570);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(52571);
                    String str = "LanguageUpdate(\"" + this.wUp + "\")";
                    AppMethodBeat.o(52571);
                    return str;
                }
            });
            AppMethodBeat.o(52572);
            return false;
        }
    };
    private BroadcastReceiver wUg = new BroadcastReceiver() {
        /* class com.tencent.mm.plugin.fts.PluginFTS.AnonymousClass9 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(52573);
            if (intent == null || intent.getAction() == null) {
                AppMethodBeat.o(52573);
                return;
            }
            Log.i("MicroMsg.FTS.PluginFTS", "*** Charging notified: " + intent.getAction());
            if (intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                PluginFTS.this.wTW = true;
                AppMethodBeat.o(52573);
                return;
            }
            if (intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                PluginFTS.this.wTW = false;
            }
            AppMethodBeat.o(52573);
        }
    };
    private ConcurrentHashMap<Integer, com.tencent.mm.plugin.fts.a.i> wUh = new ConcurrentHashMap<>();
    private e wUi;
    private SparseArray<com.tencent.mm.plugin.fts.a.d.d> wUj = new SparseArray<>();
    private com.tencent.mm.plugin.fts.a.d.c wUk;
    private SparseArray<com.tencent.mm.plugin.fts.a.d.a.b> wUl = new SparseArray<>();
    private SparseArray<k> wUm = new SparseArray<>();
    private IListener wUn = new IListener<bn>() {
        /* class com.tencent.mm.plugin.fts.PluginFTS.AnonymousClass2 */

        {
            AppMethodBeat.i(160973);
            this.__eventId = bn.class.getName().hashCode();
            AppMethodBeat.o(160973);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bn bnVar) {
            AppMethodBeat.i(52564);
            PluginFTS.access$1700(PluginFTS.this);
            AppMethodBeat.o(52564);
            return false;
        }
    };

    public PluginFTS() {
        AppMethodBeat.i(52580);
        AppMethodBeat.o(52580);
    }

    static /* synthetic */ void access$1200(PluginFTS pluginFTS) {
        AppMethodBeat.i(52629);
        pluginFTS.waitAndStartDaemon();
        AppMethodBeat.o(52629);
    }

    static /* synthetic */ void access$1700(PluginFTS pluginFTS) {
        AppMethodBeat.i(52630);
        pluginFTS.addCheckLanguageTask();
        AppMethodBeat.o(52630);
    }

    static /* synthetic */ void access$200(PluginFTS pluginFTS) {
        AppMethodBeat.i(52623);
        pluginFTS.destroyNativeLogic();
        AppMethodBeat.o(52623);
    }

    static /* synthetic */ void access$300(PluginFTS pluginFTS) {
        AppMethodBeat.i(52624);
        pluginFTS.destroyStorage();
        AppMethodBeat.o(52624);
    }

    static /* synthetic */ void access$500(PluginFTS pluginFTS) {
        AppMethodBeat.i(52625);
        pluginFTS.registerStorage();
        AppMethodBeat.o(52625);
    }

    static /* synthetic */ void access$600(PluginFTS pluginFTS) {
        AppMethodBeat.i(52626);
        pluginFTS.registerSearchLogic();
        AppMethodBeat.o(52626);
    }

    static /* synthetic */ void access$700(PluginFTS pluginFTS) {
        AppMethodBeat.i(52627);
        pluginFTS.createIndexStorage();
        AppMethodBeat.o(52627);
    }

    static /* synthetic */ void access$800(PluginFTS pluginFTS) {
        AppMethodBeat.i(52628);
        pluginFTS.createNativeLogic();
        AppMethodBeat.o(52628);
    }

    public boolean isCharging() {
        return this.wTW;
    }

    public boolean isInBackground() {
        return this.wTX;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(52581);
        o oVar = new o(com.tencent.mm.plugin.fts.a.c.wUX);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        if (this.wTS != null) {
            this.wTS.quit();
        }
        initFTSTaskDaemon();
        Intent registerReceiver = MMApplicationContext.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.wTW = intExtra == 2 || intExtra == 5;
        } else {
            this.wTW = false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        MMApplicationContext.getContext().registerReceiver(this.wUg, intentFilter);
        g.aAj().a(this.wUb);
        this.wUd.alive();
        this.wUf.alive();
        this.wUc.alive();
        this.wUn.alive();
        g.azz().a(138, this.wUe);
        this.wTS.a(-131072, new b());
        this.wTS.a(-131071, new a(this, (byte) 0));
        this.wUk = new c();
        addCheckLanguageTask();
        if (cVar.hrc) {
            Log.i("MicroMsg.FTS.PluginFTS", "upgrade reset rebuild times to 3");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_TIME_INT_SYNC, (Object) 5);
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_UPDATE_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(52581);
            return;
        }
        g.aAi();
        long a2 = g.aAh().azQ().a(ar.a.USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_UPDATE_TIME_LONG_SYNC, 0);
        if (System.currentTimeMillis() - a2 > Util.MILLSECONDS_OF_DAY) {
            Log.i("MicroMsg.FTS.PluginFTS", "one day reset rebuild times to 3");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_TIME_INT_SYNC, (Object) 5);
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_FTS_MASTER_DB_CORRUPT_REBUILD_UPDATE_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(52581);
            return;
        }
        Log.i("MicroMsg.FTS.PluginFTS", "no need reset rebuild times to 3 %s preVersion %s", Long.valueOf(a2), Integer.valueOf(cVar.hrd));
        AppMethodBeat.o(52581);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(52582);
        destroyNativeLogic();
        destroyNativeUILogic();
        destroyItemClickHandler();
        destroyStorage();
        if (this.wTS != null) {
            this.wTS.quit();
            this.wTS = null;
        }
        if (this.wTT != null) {
            this.wTT.close();
            this.wTT = null;
        }
        if (this.wUk != null) {
            this.wUk.dOp();
            this.wUk = null;
        }
        try {
            MMApplicationContext.getContext().unregisterReceiver(this.wUg);
        } catch (Exception e2) {
        }
        this.wUd.dead();
        this.wUc.dead();
        this.wUn.dead();
        this.wUf.dead();
        g.azz().b(138, this.wUe);
        g.aAj().b(this.wUb);
        this.wTU = false;
        this.wTV = false;
        AppMethodBeat.o(52582);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(52583);
        if (gVar.aBb()) {
            g.b(au.class, new com.tencent.mm.plugin.fts.b.f());
        }
        AppMethodBeat.o(52583);
    }

    public void initFTSTaskDaemon() {
        AppMethodBeat.i(52584);
        if (this.wTS == null) {
            this.wTS = new g();
            g gVar = this.wTS;
            if (gVar.wTJ == null || !gVar.wTJ.isAlive()) {
                gVar.wTJ = new g.a();
                Log.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon initialized, waiting for starting.");
            } else {
                Log.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", new Throwable(), "Duplicated daemon initialization detected, working queue maybe dirty!", new Object[0]);
            }
            g gVar2 = this.wTS;
            Runnable runnable = this.wTY;
            if (gVar2.wTJ != null) {
                gVar2.wTJ.wTP = runnable;
            }
        }
        AppMethodBeat.o(52584);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public m getFTSTaskDaemon() {
        AppMethodBeat.i(52585);
        initFTSTaskDaemon();
        g gVar = this.wTS;
        AppMethodBeat.o(52585);
        return gVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public d getFTSIndexDB() {
        return this.wTT;
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public void parallelsDependency() {
        AppMethodBeat.i(52586);
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).bI(com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class));
        AppMethodBeat.o(52586);
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        b() {
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52579);
            com.tencent.mm.kernel.g.aAi();
            if (2 != ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_FTS_MASTER_DB_VERISON_INT_SYNC, (Object) 0)).intValue()) {
                d.dOq();
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_FTS_MASTER_DB_VERISON_INT_SYNC, (Object) 2);
            }
            com.tencent.mm.kernel.g.aAi();
            o oVar = new o(com.tencent.mm.kernel.g.aAh().cachePath, "IndexMicroMsg.db");
            if (oVar.exists()) {
                oVar.delete();
            } else {
                Log.i("MicroMsg.FTS.PluginFTS", "not exist fts3DBFile %s", aa.z(oVar.her()));
            }
            com.tencent.mm.kernel.g.aAi();
            o oVar2 = new o(com.tencent.mm.kernel.g.aAh().cachePath, "FTS5IndexMicroMsg.db");
            if (oVar2.exists()) {
                oVar2.delete();
            } else {
                Log.i("MicroMsg.FTS.PluginFTS", "not exist fts5DBUnEncrypt %s", aa.z(oVar2.her()));
            }
            b.a aVar = b.a.clicfg_fts_delete_repeated_msg_db_flag;
            com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, com.tencent.mm.util.c.hdd()) == 1) {
                com.tencent.mm.kernel.g.aAi();
                o oVar3 = new o(com.tencent.mm.kernel.g.aAh().cachePath, "FTS5IndexMicroMsg_encrypt.db");
                com.tencent.mm.kernel.g.aAi();
                o oVar4 = new o(com.tencent.mm.kernel.g.aAh().azO());
                StringBuilder sb = new StringBuilder();
                com.tencent.mm.kernel.g.aAi();
                o oVar5 = new o(sb.append(com.tencent.mm.kernel.g.aAh().cachePath).append("enFavorite.db").toString());
                Log.i("MicroMsg.FTS.PluginFTS", "ftsEncryptDB:%s mainEncryptDB:%s favEncryptDB:%s", Util.getSizeMB(oVar3.length()), Util.getSizeMB(oVar4.length()), Util.getSizeMB(oVar5.length()));
                if (((double) oVar3.length()) > 1.610612736E9d) {
                    if (oVar3.length() > (oVar5.length() + oVar4.length()) * 2) {
                        oVar3.delete();
                        Log.i("MicroMsg.FTS.PluginFTS", "try to delete old db and rebuild");
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(729, 14, 1, false);
                    }
                }
            }
            try {
                PluginFTS pluginFTS = PluginFTS.this;
                com.tencent.mm.kernel.g.aAi();
                pluginFTS.wTT = new d(com.tencent.mm.kernel.g.aAh().cachePath);
                PluginFTS.access$500(PluginFTS.this);
                PluginFTS.access$600(PluginFTS.this);
                PluginFTS.access$700(PluginFTS.this);
                PluginFTS.access$800(PluginFTS.this);
            } catch (f e2) {
                AppMethodBeat.o(52579);
                throw e2;
            } catch (Exception e3) {
                if (PluginFTS.wUa) {
                    AppMethodBeat.o(52579);
                } else {
                    Log.printErrStackTrace("MicroMsg.FTS.PluginFTS", e3, "Index database corruption detected", new Object[0]);
                    PluginFTS.this.wTZ.onCorruption(null);
                }
            }
            AppMethodBeat.o(52579);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "InitSearchTask";
        }
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private a() {
        }

        /* synthetic */ a(PluginFTS pluginFTS, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            String[] split;
            AppMethodBeat.i(52577);
            ayx("start");
            try {
                for (String str : new String(s.aW("assets:///fts/fts_t2s.txt", 0, -1)).split("\n")) {
                    String[] split2 = str.split(",");
                    com.tencent.mm.plugin.fts.a.g.jNI.put(split2[0], split2[1]);
                }
            } catch (Exception e2) {
                com.tencent.mm.plugin.fts.a.e.Nk(26);
                Log.printErrStackTrace("MicroMsg.FTS.PluginFTS", e2, e2.getMessage(), new Object[0]);
            }
            ayx("t2s");
            try {
                for (String str2 : new String(s.aW("assets:///fts/fts_py.txt", 0, -1)).split("\n")) {
                    String[] split3 = str2.split(",");
                    String str3 = split3[0];
                    String[] strArr = new String[(split3.length - 1)];
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        if (i2 + 1 < split3.length) {
                            strArr[i2] = split3[i2 + 1];
                        }
                    }
                    if (strArr.length > 0) {
                        for (String str4 : strArr) {
                            com.tencent.mm.plugin.fts.a.g.wVM.ayz(str4);
                        }
                        com.tencent.mm.plugin.fts.a.g.wVN.put(str3, strArr);
                    }
                }
            } catch (Exception e3) {
                com.tencent.mm.plugin.fts.a.e.Nk(27);
                Log.printErrStackTrace("MicroMsg.FTS.PluginFTS", e3, e3.getMessage(), new Object[0]);
            }
            ayx("py");
            com.tencent.mm.plugin.fts.a.e.wVl.wVo = d.dOr().length() / 1048576;
            com.tencent.mm.plugin.fts.a.e.wVl.wVp = PluginFTS.this.wTT.V(-301, 0);
            com.tencent.mm.plugin.fts.a.e.wVl.wVq = PluginFTS.this.wTT.V(-302, 0);
            com.tencent.mm.plugin.fts.a.e.wVl.wVs = PluginFTS.this.wTT.V(-303, 0);
            com.tencent.mm.plugin.fts.a.e.wVl.wVr = PluginFTS.this.wTT.V(-304, 0);
            long V = ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().V(-300, 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (!com.tencent.mm.plugin.fts.a.d.isSameDay(V, currentTimeMillis)) {
                com.tencent.mm.plugin.fts.a.e.dOx();
                ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().W(-300, currentTimeMillis);
            } else {
                Log.i("MicroMsg.FTS.PluginFTS", "not need to report fts data");
            }
            ayx("reportData");
            Log.i("MicroMsg.FTS.PluginFTS", "ftsDBSize: %s mainEnDBPath:%s", Util.getSizeMB(s.boW(com.tencent.mm.kernel.g.aAh().cachePath + "FTS5IndexMicroMsg_encrypt.db")), Util.getSizeMB(s.boW(com.tencent.mm.kernel.g.aAh().azO())));
            AppMethodBeat.o(52577);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52578);
            String format = String.format("{T2S: %d PY: %d}", Integer.valueOf(com.tencent.mm.plugin.fts.a.g.jNI.size()), Integer.valueOf(com.tencent.mm.plugin.fts.a.g.wVN.size()));
            AppMethodBeat.o(52578);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "InitResourceTask";
        }
    }

    private void registerSearchLogic() {
        AppMethodBeat.i(52587);
        registerNativeLogic(1, new com.tencent.mm.plugin.fts.b.e());
        registerNativeLogic(2, new com.tencent.mm.plugin.fts.b.a());
        registerNativeLogic(3, new com.tencent.mm.plugin.fts.b.c());
        registerNativeLogic(4, new com.tencent.mm.plugin.fts.b.b());
        registerNativeLogic(8, new com.tencent.mm.plugin.fts.b.d());
        registerNativeLogic(10000, new com.tencent.mm.plugin.fts.b.g());
        AppMethodBeat.o(52587);
    }

    private void registerStorage() {
        AppMethodBeat.i(52588);
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.e());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.a());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.b());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.c());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.d());
        AppMethodBeat.o(52588);
    }

    private void createNativeLogic() {
        AppMethodBeat.i(52589);
        Log.i("MicroMsg.FTS.PluginFTS", "Create Native Logic");
        for (int i2 = 0; i2 < this.wUm.size(); i2++) {
            k kVar = this.wUm.get(this.wUm.keyAt(i2));
            if (kVar != null) {
                try {
                    kVar.create();
                } catch (Exception e2) {
                    Log.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", kVar.getName(), Util.stackTraceToString(e2));
                }
            }
        }
        AppMethodBeat.o(52589);
    }

    private void destroyNativeLogic() {
        AppMethodBeat.i(52590);
        Log.i("MicroMsg.FTS.PluginFTS", "Destroy Native Logic");
        for (int i2 = 0; i2 < this.wUm.size(); i2++) {
            k kVar = this.wUm.get(this.wUm.keyAt(i2));
            if (kVar != null) {
                try {
                    kVar.destroy();
                } catch (Exception e2) {
                    Log.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", kVar.getName(), Util.stackTraceToString(e2));
                }
            }
        }
        AppMethodBeat.o(52590);
    }

    private void destroyNativeUILogic() {
        AppMethodBeat.i(52591);
        this.wUj.clear();
        AppMethodBeat.o(52591);
    }

    private void destroyItemClickHandler() {
        AppMethodBeat.i(52592);
        this.wUl.clear();
        AppMethodBeat.o(52592);
    }

    private void createIndexStorage() {
        AppMethodBeat.i(52593);
        Log.i("MicroMsg.FTS.PluginFTS", "Create Index Storage %d", Integer.valueOf(this.wUh.size()));
        LinkedList linkedList = new LinkedList();
        for (com.tencent.mm.plugin.fts.a.i iVar : this.wUh.values()) {
            linkedList.add(iVar);
        }
        Collections.sort(linkedList);
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            ((com.tencent.mm.plugin.fts.a.i) linkedList.get(i2)).create();
        }
        AppMethodBeat.o(52593);
    }

    private void destroyStorage() {
        AppMethodBeat.i(52594);
        Log.i("MicroMsg.FTS.PluginFTS", "Destroy Index Storage");
        for (com.tencent.mm.plugin.fts.a.i iVar : this.wUh.values()) {
            if (iVar != null) {
                iVar.destroy();
            }
        }
        AppMethodBeat.o(52594);
    }

    private void waitAndStartDaemon() {
        AppMethodBeat.i(52595);
        com.tencent.mm.kernel.g.aAi();
        this.wTU = Util.nullAsNil((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(15, null)) != 0;
        if (!this.wTU) {
            com.tencent.mm.kernel.g.azz().a(138, this.wUe);
            Log.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for account initialized");
        } else {
            Log.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon user is initialized.");
        }
        if (!this.wTV) {
            Log.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for all account post reset.");
        } else {
            Log.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon all account post reset.");
        }
        if (this.wTU && this.wTV) {
            startDaemon();
        }
        AppMethodBeat.o(52595);
    }

    private void startDaemon() {
        AppMethodBeat.i(52596);
        if (!this.wTS.isStart()) {
            g gVar = this.wTS;
            gVar.wTJ.start();
            Log.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon started with TID: " + gVar.wTJ.getId());
        }
        AppMethodBeat.o(52596);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public com.tencent.mm.plugin.fts.a.a.a search(int i2, j jVar) {
        AppMethodBeat.i(52597);
        if (!isFTSContextReady()) {
            b bVar = new b(jVar);
            ThreadPool.post(bVar, "FTSExceptionHandler");
            AppMethodBeat.o(52597);
            return bVar;
        } else if (this.wUm.indexOfKey(i2) >= 0) {
            k kVar = this.wUm.get(i2);
            if (kVar.isCreated()) {
                com.tencent.mm.plugin.fts.a.a.a a2 = kVar.a(jVar);
                AppMethodBeat.o(52597);
                return a2;
            }
            b bVar2 = new b(jVar);
            ThreadPool.post(bVar2, "FTSExceptionHandler");
            AppMethodBeat.o(52597);
            return bVar2;
        } else {
            Log.e("MicroMsg.FTS.PluginFTS", "Not Found Search Logic, LogicArraySize=%d", Integer.valueOf(this.wUm.size()));
            b bVar3 = new b(jVar);
            ThreadPool.post(bVar3, "FTSExceptionHandler");
            AppMethodBeat.o(52597);
            return bVar3;
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void cancelSearchTask(com.tencent.mm.plugin.fts.a.a.a aVar) {
        AppMethodBeat.i(52598);
        if (isFTSContextReady()) {
            g gVar = this.wTS;
            if (gVar.wTJ != null) {
                g.a aVar2 = gVar.wTJ;
                aVar.mCancelled = true;
                aVar2.wTL.remove(aVar);
                if (aVar2.wTN == aVar) {
                    aVar2.interrupt();
                }
            }
        }
        AppMethodBeat.o(52598);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void updateTopHitsRank(String str, com.tencent.mm.plugin.fts.a.a.m mVar, int i2) {
        AppMethodBeat.i(52599);
        if (isFTSContextReady() && this.wUm.indexOfKey(1) >= 0) {
            this.wUm.get(1).a(str, mVar, i2, com.tencent.mm.plugin.fts.a.d.dOw());
        }
        AppMethodBeat.o(52599);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void addSOSHistory(String str, String str2) {
        AppMethodBeat.i(52600);
        if (isFTSContextReady() && this.wUm.indexOfKey(8) >= 0) {
            this.wUm.get(8).addSOSHistory(str, str2);
        }
        AppMethodBeat.o(52600);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void deleteSOSHistory() {
        AppMethodBeat.i(52601);
        if (isFTSContextReady() && this.wUm.indexOfKey(8) >= 0) {
            this.wUm.get(8).deleteSOSHistory();
        }
        AppMethodBeat.o(52601);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void deleteSOSHistory(String str) {
        AppMethodBeat.i(52602);
        if (isFTSContextReady() && this.wUm.indexOfKey(8) >= 0) {
            this.wUm.get(8).deleteSOSHistory(str);
        }
        AppMethodBeat.o(52602);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void registerIndexStorage(com.tencent.mm.plugin.fts.a.i iVar) {
        AppMethodBeat.i(52603);
        this.wUh.put(Integer.valueOf(iVar.getType()), iVar);
        AppMethodBeat.o(52603);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void unregisterIndexStorage(int i2) {
        AppMethodBeat.i(52604);
        if (this.wUh.containsKey(Integer.valueOf(i2))) {
            com.tencent.mm.plugin.fts.a.i iVar = this.wUh.get(Integer.valueOf(i2));
            try {
                iVar.destroy();
            } catch (Exception e2) {
                Log.e("MicroMsg.FTS.PluginFTS", "Destroy Index Storage name=%s \nexception=%s", iVar.getName(), Util.stackTraceToString(e2));
            }
        }
        this.wUh.remove(Integer.valueOf(i2));
        AppMethodBeat.o(52604);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public com.tencent.mm.plugin.fts.a.i getFTSIndexStorage(int i2) {
        AppMethodBeat.i(52605);
        com.tencent.mm.plugin.fts.a.i iVar = this.wUh.get(Integer.valueOf(i2));
        AppMethodBeat.o(52605);
        return iVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public com.tencent.mm.plugin.fts.a.j getFTSMainDB() {
        AppMethodBeat.i(52606);
        if (this.wUi == null) {
            this.wUi = new e();
        }
        e eVar = this.wUi;
        AppMethodBeat.o(52606);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public int stringCompareUtfBinary(String str, String str2) {
        AppMethodBeat.i(52607);
        int stringCompareUtfBinary = FTSJNIUtils.stringCompareUtfBinary(str, str2);
        AppMethodBeat.o(52607);
        return stringCompareUtfBinary;
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void registerFTSUILogic(com.tencent.mm.plugin.fts.a.d.d dVar) {
        AppMethodBeat.i(52608);
        try {
            this.wUj.put(dVar.getType(), dVar);
            AppMethodBeat.o(52608);
        } catch (Exception e2) {
            AppMethodBeat.o(52608);
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void unregisterFTSUILogic(int i2) {
        AppMethodBeat.i(52609);
        try {
            this.wUj.remove(i2);
            AppMethodBeat.o(52609);
        } catch (Exception e2) {
            AppMethodBeat.o(52609);
        }
    }

    public void setFTSImageLoader(com.tencent.mm.plugin.fts.a.d.c cVar) {
        this.wUk = cVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public com.tencent.mm.plugin.fts.a.d.c getFTSImageLoader() {
        return this.wUk;
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public LinkedList<com.tencent.mm.plugin.fts.a.d.e> createFTSUIUnitList(HashSet<Integer> hashSet, Context context, e.b bVar, int i2) {
        AppMethodBeat.i(52610);
        LinkedList<com.tencent.mm.plugin.fts.a.d.e> linkedList = new LinkedList<>();
        LinkedList linkedList2 = new LinkedList();
        Iterator<Integer> it = hashSet.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.fts.a.d.d dVar = this.wUj.get(it.next().intValue());
            if (dVar != null) {
                linkedList2.add(dVar);
            }
        }
        Collections.sort(linkedList2);
        Iterator it2 = linkedList2.iterator();
        while (it2.hasNext()) {
            linkedList.add(((com.tencent.mm.plugin.fts.a.d.d) it2.next()).a(context, bVar, i2));
        }
        AppMethodBeat.o(52610);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public com.tencent.mm.plugin.fts.a.d.e createFTSUIUnit(int i2, Context context, e.b bVar, int i3) {
        AppMethodBeat.i(52611);
        com.tencent.mm.plugin.fts.a.d.d dVar = this.wUj.get(i2);
        if (dVar != null) {
            com.tencent.mm.plugin.fts.a.d.e a2 = dVar.a(context, bVar, i3);
            AppMethodBeat.o(52611);
            return a2;
        }
        AppMethodBeat.o(52611);
        return null;
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void registerItemClickHandler(int i2, com.tencent.mm.plugin.fts.a.d.a.b bVar) {
        AppMethodBeat.i(52612);
        this.wUl.put(i2, bVar);
        AppMethodBeat.o(52612);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void unregisterItemClickHandler(int i2) {
        AppMethodBeat.i(52613);
        this.wUl.remove(i2);
        AppMethodBeat.o(52613);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public com.tencent.mm.plugin.fts.a.d.a.b getItemClickHandler(int i2) {
        AppMethodBeat.i(52614);
        com.tencent.mm.plugin.fts.a.d.a.b bVar = this.wUl.get(i2);
        AppMethodBeat.o(52614);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void registerNativeLogic(int i2, k kVar) {
        AppMethodBeat.i(52615);
        this.wUm.put(i2, kVar);
        AppMethodBeat.o(52615);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public void unregisterNativeLogic(int i2) {
        AppMethodBeat.i(52616);
        if (this.wUm.indexOfKey(i2) >= 0) {
            k kVar = this.wUm.get(i2);
            try {
                kVar.destroy();
            } catch (Exception e2) {
                Log.e("MicroMsg.FTS.PluginFTS", "Destroy Native Logic name=%s \nexception=%s", kVar.getName(), Util.stackTraceToString(e2));
            }
        }
        this.wUm.remove(i2);
        AppMethodBeat.o(52616);
    }

    @Override // com.tencent.mm.plugin.fts.a.n
    public boolean isFTSContextReady() {
        AppMethodBeat.i(52617);
        boolean isStart = getFTSTaskDaemon().isStart();
        AppMethodBeat.o(52617);
        return isStart;
    }

    public com.tencent.mm.plugin.fts.b.e getTopHitsLogic() {
        AppMethodBeat.i(52619);
        com.tencent.mm.plugin.fts.b.e eVar = (com.tencent.mm.plugin.fts.b.e) this.wUm.get(1);
        AppMethodBeat.o(52619);
        return eVar;
    }

    public com.tencent.mm.plugin.fts.b.g getSearchTestLogic() {
        AppMethodBeat.i(52620);
        com.tencent.mm.plugin.fts.b.g gVar = (com.tencent.mm.plugin.fts.b.g) this.wUm.get(10000);
        AppMethodBeat.o(52620);
        return gVar;
    }

    private void addCheckLanguageTask() {
        AppMethodBeat.i(52621);
        ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSTaskDaemon().a(65536, new com.tencent.mm.plugin.fts.a.a.a() {
            /* class com.tencent.mm.plugin.fts.PluginFTS.AnonymousClass10 */
            boolean atW = false;
            String wUr = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());

            {
                AppMethodBeat.i(52574);
                AppMethodBeat.o(52574);
            }

            @Override // com.tencent.mm.plugin.fts.a.a.a
            public final boolean execute() {
                AppMethodBeat.i(52575);
                this.atW = ((int) ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexDB().V(-3, 0)) != this.wUr.hashCode();
                if (this.atW) {
                    EventCenter.instance.publish(new yn());
                }
                AppMethodBeat.o(52575);
                return true;
            }

            @Override // com.tencent.mm.plugin.fts.a.a.a
            public final String bCQ() {
                AppMethodBeat.i(52576);
                String format = String.format("{changed: %b}", Boolean.valueOf(this.atW));
                AppMethodBeat.o(52576);
                return format;
            }

            @Override // com.tencent.mm.plugin.fts.a.a.a
            public final String getName() {
                return "CheckLanguageUpdate";
            }
        });
        AppMethodBeat.o(52621);
    }

    public DatabaseErrorHandler getDatabaseErrorHandler() {
        return this.wTZ;
    }
}
