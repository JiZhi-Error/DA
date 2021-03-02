package com.tencent.mm.plugin.appbrand.j;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    m hgI;
    c lqS;
    private MStorage.IOnStorageChange lqT = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.appbrand.j.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(45010);
            Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp storage change: event=%s | eventData=%s", str, mStorageEventData);
            switch (mStorageEventData.eventId) {
                case 2:
                case 3:
                    if (!MStorageEventData.EventType.BATCH.equals(str)) {
                        b.this.hgI.a(65616, new C0593b(mStorageEventData.obj.toString()));
                        AppMethodBeat.o(45010);
                        return;
                    } else if (mStorageEventData.obj != null && (mStorageEventData.obj instanceof List)) {
                        for (String str2 : (List) mStorageEventData.obj) {
                            b.this.hgI.a(65616, new C0593b(str2));
                        }
                        AppMethodBeat.o(45010);
                        return;
                    }
                case 5:
                    if (!MStorageEventData.EventType.BATCH.equals(str)) {
                        b.this.hgI.a(65616, new a(mStorageEventData.obj.toString()));
                        break;
                    } else if (mStorageEventData.obj != null && (mStorageEventData.obj instanceof List)) {
                        for (String str3 : (List) mStorageEventData.obj) {
                            b.this.hgI.a(65616, new a(str3));
                        }
                        AppMethodBeat.o(45010);
                        return;
                    }
            }
            AppMethodBeat.o(45010);
        }
    };

    public b() {
        AppMethodBeat.i(45018);
        AppMethodBeat.o(45018);
    }

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final com.tencent.mm.plugin.fts.a.a.a a(j jVar) {
        AppMethodBeat.i(45019);
        com.tencent.mm.plugin.fts.a.a.a a2 = this.hgI.a(-65536, new c(jVar));
        AppMethodBeat.o(45019);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean onCreate() {
        AppMethodBeat.i(45020);
        if (!((n) g.ah(n.class)).isFTSContextReady()) {
            Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Fail!");
            AppMethodBeat.o(45020);
            return false;
        }
        Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Success!");
        this.lqS = (c) ((n) g.ah(n.class)).getFTSIndexStorage(512);
        this.hgI = ((n) g.ah(n.class)).getFTSTaskDaemon();
        this.hgI.a(65616, new d());
        i.onCreate();
        i.c(this.lqT);
        AppMethodBeat.o(45020);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean axa() {
        AppMethodBeat.i(45021);
        i.onDestroy();
        i.d(this.lqT);
        this.lqS = null;
        this.hgI = null;
        AppMethodBeat.o(45021);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public final String getName() {
        return "FTS5SearchWeAppLogic";
    }

    class c extends i {
        c(j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchWeAppTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 21;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            AppMethodBeat.i(45015);
            kVar.wWd = h.bE(this.wWO.query, true);
            kVar.wXb = new ArrayList();
            HashSet hashSet = new HashSet();
            Cursor a2 = b.this.lqS.a(kVar.wWd, com.tencent.mm.plugin.fts.a.c.wUG, this.wWO.wWV, true, true);
            while (a2.moveToNext()) {
                try {
                    com.tencent.mm.plugin.fts.a.a.n nVar = new com.tencent.mm.plugin.fts.a.a.n();
                    nVar.i(a2);
                    if (!hashSet.contains(Long.valueOf(nVar.wXe)) && !this.wWO.wWX.contains(nVar.wVX)) {
                        nVar.dOC();
                        kVar.wXb.add(nVar);
                        hashSet.add(Long.valueOf(nVar.wXe));
                    }
                } catch (Throwable th) {
                    if (a2 != null) {
                        a2.close();
                    }
                    AppMethodBeat.o(45015);
                    throw th;
                }
            }
            if (a2 != null) {
                a2.close();
            }
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.o(45015);
                throw interruptedException;
            }
            if (this.wWO.wWY != null) {
                Collections.sort(kVar.wXb, this.wWO.wWY);
            }
            AppMethodBeat.o(45015);
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private int lqV;

        d() {
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(45016);
            List<AppBrandRecentTaskInfo> bCT = i.bCT();
            if (bCT.isEmpty()) {
                Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp recent usage list is nil.");
                AppMethodBeat.o(45016);
                return true;
            }
            this.lqV = bCT.size();
            b.this.lqS.beginTransaction();
            b.this.lqS.B(com.tencent.mm.plugin.fts.a.c.wUG);
            for (AppBrandRecentTaskInfo appBrandRecentTaskInfo : bCT) {
                String nullAsNil = Util.nullAsNil(appBrandRecentTaskInfo.gLc);
                int hashCode = nullAsNil.hashCode();
                long currentTimeMillis = System.currentTimeMillis();
                b.this.lqS.a(393216, 1, (long) hashCode, nullAsNil, currentTimeMillis, appBrandRecentTaskInfo.appName);
                b.this.lqS.a(393216, 2, (long) hashCode, nullAsNil, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.bB(appBrandRecentTaskInfo.appName, false));
                b.this.lqS.a(393216, 3, (long) hashCode, nullAsNil, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.bB(appBrandRecentTaskInfo.appName, true));
            }
            b.this.lqS.commit();
            AppMethodBeat.o(45016);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(45017);
            String format = String.format("{updateSize: %d}", Integer.valueOf(this.lqV));
            AppMethodBeat.o(45017);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "UpdateWeAppIndexTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.j.b$b  reason: collision with other inner class name */
    class C0593b extends com.tencent.mm.plugin.fts.a.a.a {
        private String id;
        private String name;

        public C0593b(String str) {
            this.id = str;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(45013);
            b.this.lqS.beginTransaction();
            b.this.lqS.a(com.tencent.mm.plugin.fts.a.c.wUG, this.id);
            AppBrandRecentTaskInfo YG = i.YG(this.id);
            if (YG != null) {
                long currentTimeMillis = System.currentTimeMillis();
                String nullAsNil = Util.nullAsNil(YG.gLc);
                int hashCode = nullAsNil.hashCode();
                b.this.lqS.a(393216, 1, (long) hashCode, nullAsNil, currentTimeMillis, YG.appName);
                b.this.lqS.a(393216, 2, (long) hashCode, nullAsNil, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.bB(YG.appName, false));
                b.this.lqS.a(393216, 3, (long) hashCode, nullAsNil, currentTimeMillis, com.tencent.mm.plugin.fts.a.d.bB(YG.appName, true));
                this.name = YG.appName;
                Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "inserted we app info id = %s", nullAsNil);
            }
            b.this.lqS.commit();
            AppMethodBeat.o(45013);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "InsertWeAppTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(45014);
            String format = String.format("{name: %s id: %s}", this.name, this.id);
            AppMethodBeat.o(45014);
            return format;
        }
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private String id;

        public a(String str) {
            this.id = str;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(45011);
            Log.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "delete we app info id=%s", this.id);
            b.this.lqS.a(com.tencent.mm.plugin.fts.a.c.wUG, this.id);
            AppMethodBeat.o(45011);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "DeleteWeAppTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(45012);
            String format = String.format("{id: %s}", this.id);
            AppMethodBeat.o(45012);
            return format;
        }
    }
}
