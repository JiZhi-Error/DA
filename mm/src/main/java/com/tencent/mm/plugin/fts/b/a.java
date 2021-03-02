package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.yn;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.recovery.log.RecoveryFileLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.AssertionFailedError;

public final class a extends com.tencent.mm.plugin.fts.a.b {
    private static Set<String> wYj = new HashSet();
    private com.tencent.mm.plugin.fts.a.m hgI;
    private com.tencent.mm.plugin.fts.a.j tbO;
    private com.tencent.mm.plugin.fts.c.a wXV;
    private HashSet<String> wXW;
    private HashMap<String, List<Long>> wXX;
    private HashMap<String, String[]> wXY;
    private HashMap<String, List<Long>> wXZ;
    private Method wYa;
    private MStorageEx.IOnStorageChange wYb = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.plugin.fts.b.a.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(52631);
            String str = (String) obj;
            if (!a.ayB(str)) {
                Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", str);
                AppMethodBeat.o(52631);
                return;
            }
            as bjF = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjF(str);
            if (bjF == null || (a.U(bjF) && !bjF.gBM())) {
                switch (i2) {
                    case 2:
                    case 5:
                        if (!a.this.wXX.containsKey(str)) {
                            a.this.hgI.a(65556, new h(str));
                            AppMethodBeat.o(52631);
                            return;
                        }
                        break;
                    case 3:
                        if (!a.this.wXW.contains(str) && !a.this.wXX.containsKey(str)) {
                            a.this.hgI.a(65556, new i(str));
                            break;
                        }
                }
                AppMethodBeat.o(52631);
                return;
            }
            Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", str);
            AppMethodBeat.o(52631);
        }
    };
    private MStorageEx.IOnStorageChange wYc = new MStorageEx.IOnStorageChange() {
        /* class com.tencent.mm.plugin.fts.b.a.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(52632);
            String str = (String) obj;
            if (!a.ayB(str)) {
                Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", str);
                AppMethodBeat.o(52632);
                return;
            }
            as bjF = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjF(str);
            if (bjF == null || a.U(bjF)) {
                switch (i2) {
                    case 2:
                        a.this.hgI.a(65556, new e(str));
                        AppMethodBeat.o(52632);
                        return;
                    case 3:
                    case 4:
                        if (!a.this.wXX.containsKey(str)) {
                            a.this.hgI.a(65556, new h(str));
                            AppMethodBeat.o(52632);
                            return;
                        }
                        break;
                    case 5:
                        a.this.hgI.a(65556, new d(str));
                        break;
                }
                AppMethodBeat.o(52632);
                return;
            }
            Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", str);
            AppMethodBeat.o(52632);
        }
    };
    private MStorage.IOnStorageChange wYd = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.fts.b.a.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(52633);
            if (str.equals("*") || str.equals("chatroomname")) {
                AppMethodBeat.o(52633);
                return;
            }
            if (!a.this.wXX.containsKey(str)) {
                a.this.hgI.a(65556, new h(str));
            }
            AppMethodBeat.o(52633);
        }
    };
    private MStorage.IOnStorageChange wYe = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.fts.b.a.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(52634);
            String[] split = str.split(" ");
            if (split == null || split.length == 0) {
                AppMethodBeat.o(52634);
                return;
            }
            if (split[0].equals("update")) {
                for (int i2 = 1; i2 < split.length; i2++) {
                    a.this.hgI.a(65554, new w(Util.getLong(split[i2], 0)));
                }
                a.this.hgI.a(65556, new v(a.this, (byte) 0));
            }
            AppMethodBeat.o(52634);
        }
    };
    private IListener wYf = new IListener<yr>() {
        /* class com.tencent.mm.plugin.fts.b.a.AnonymousClass5 */

        {
            AppMethodBeat.i(160977);
            this.__eventId = yr.class.getName().hashCode();
            AppMethodBeat.o(160977);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yr yrVar) {
            AppMethodBeat.i(52635);
            yr yrVar2 = yrVar;
            if (yrVar2.eeW.gY <= 0) {
                a.this.hgI.a(131093, new v(a.this, (byte) 0));
            } else if (a.this.wYi.stopped()) {
                a.this.wYi.startTimer(yrVar2.eeW.gY);
                Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "* Update contact at once triggered.");
            }
            AppMethodBeat.o(52635);
            return false;
        }
    };
    private IListener wYg = new IListener<yn>() {
        /* class com.tencent.mm.plugin.fts.b.a.AnonymousClass6 */

        {
            AppMethodBeat.i(160978);
            this.__eventId = yn.class.getName().hashCode();
            AppMethodBeat.o(160978);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yn ynVar) {
            AppMethodBeat.i(52636);
            a.this.hgI.a(65556, new g(com.tencent.mm.plugin.fts.a.c.wUL));
            a.this.hgI.a(131093, new v(a.this, (byte) 0));
            AppMethodBeat.o(52636);
            return false;
        }
    };
    private MTimerHandler wYh = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.fts.b.a.AnonymousClass7 */
        private int wYl = 0;

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(52637);
            PluginFTS pluginFTS = (PluginFTS) com.tencent.mm.kernel.g.ah(PluginFTS.class);
            if (!(pluginFTS.isCharging() || !pluginFTS.isInBackground())) {
                int i2 = this.wYl + 1;
                this.wYl = i2;
                if (i2 < 6) {
                    AppMethodBeat.o(52637);
                    return true;
                }
            }
            a.this.hgI.a(131093, new v(a.this, (byte) 0));
            this.wYl = 0;
            AppMethodBeat.o(52637);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(52638);
            String str = super.toString() + "|delayIndexTimer";
            AppMethodBeat.o(52638);
            return str;
        }
    }, true);
    private MTimerHandler wYi = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.fts.b.a.AnonymousClass8 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(52639);
            a.this.hgI.a(131093, new v(a.this, (byte) 0));
            AppMethodBeat.o(52639);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(52640);
            String str = super.toString() + "|atOnceIndexTimer";
            AppMethodBeat.o(52640);
            return str;
        }
    }, false);

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j jVar) {
        com.tencent.mm.plugin.fts.a.a.a nVar;
        AppMethodBeat.i(52676);
        switch (jVar.kXb) {
            case 5:
                nVar = new l(jVar);
                break;
            case 6:
                nVar = new k(jVar);
                break;
            case 7:
                nVar = new m(jVar);
                break;
            case 8:
                nVar = new p(jVar);
                break;
            case 9:
                nVar = new q(jVar);
                break;
            case 12:
                nVar = new n(jVar);
                break;
            case 16:
                nVar = new r(jVar);
                break;
            case 32:
                nVar = new o(jVar);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                nVar = new u(jVar);
                break;
            case 64:
                nVar = new t(jVar);
                break;
            case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                nVar = new s(jVar);
                break;
            default:
                nVar = new j(jVar);
                break;
        }
        com.tencent.mm.plugin.fts.a.a.a a2 = this.hgI.a(-65536, nVar);
        AppMethodBeat.o(52676);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean onCreate() {
        AppMethodBeat.i(52677);
        if (!((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady()) {
            Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
            AppMethodBeat.o(52677);
            return false;
        }
        Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
        this.wXV = (com.tencent.mm.plugin.fts.c.a) ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(3);
        this.hgI = ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
        this.tbO = ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB();
        this.wXW = new HashSet<>();
        this.wXX = new HashMap<>();
        this.wXY = new HashMap<>();
        this.wXZ = new HashMap<>();
        try {
            this.wYa = ax.class.getDeclaredMethod("parseBuff", new Class[0]);
            this.wYa.setAccessible(true);
            this.hgI.a(131072, new f(this, (byte) 0));
            this.hgI.a(131082, new C1375a(this, (byte) 0));
            this.hgI.a(131092, new b(this, (byte) 0));
            this.hgI.a(Integer.MAX_VALUE, new c(this, (byte) 0));
            ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().add(this.wYd);
            ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().add(this.wYc);
            ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().add(this.wYb);
            MStorage.IOnStorageChange iOnStorageChange = this.wYe;
            if (com.tencent.mm.ax.b.jcc != null) {
                com.tencent.mm.ax.b.jcc.a(iOnStorageChange);
            }
            this.wYh.startTimer(600000);
            this.wYf.alive();
            this.wYg.alive();
            AppMethodBeat.o(52677);
            return true;
        } catch (NoSuchMethodException e2) {
            AssertionFailedError assertionFailedError = new AssertionFailedError("Can't find BaseContact.parseBuff method, class prototype has changed.");
            assertionFailedError.initCause(e2);
            AppMethodBeat.o(52677);
            throw assertionFailedError;
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean axa() {
        AppMethodBeat.i(52678);
        this.wYf.dead();
        this.wYg.dead();
        this.wYi.stopTimer();
        this.wYh.stopTimer();
        ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().remove(this.wYc);
        ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().remove(this.wYd);
        ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().remove(this.wYb);
        MStorage.IOnStorageChange iOnStorageChange = this.wYe;
        if (com.tencent.mm.ax.b.jcc != null) {
            com.tencent.mm.ax.b.jcc.b(iOnStorageChange);
        }
        if (this.wXX != null) {
            this.wXX.clear();
        }
        if (this.wXW != null) {
            this.wXW.clear();
        }
        this.wXV = null;
        this.hgI = null;
        AppMethodBeat.o(52678);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public final String getName() {
        return "FTS5SearchContactLogic";
    }

    class k extends com.tencent.mm.plugin.fts.a.a.i {
        public k(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(com.tencent.mm.plugin.fts.a.a.k kVar) {
            AppMethodBeat.i(52662);
            super.a(kVar);
            com.tencent.mm.plugin.fts.c.a aVar = a.this.wXV;
            String str = this.wWO.query;
            String format = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", aVar.dOt());
            Cursor rawQuery = aVar.wUt.rawQuery(format, new String[]{str});
            kVar.wXb = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                mVar.wVX = rawQuery.getString(0);
                kVar.wXb.add(mVar);
            }
            rawQuery.close();
            kVar.resultCode = 0;
            AppMethodBeat.o(52662);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchChatroomByMemberTask";
        }
    }

    class m extends com.tencent.mm.plugin.fts.a.a.i {
        public m(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(com.tencent.mm.plugin.fts.a.a.k kVar) {
            AppMethodBeat.i(52664);
            super.a(kVar);
            com.tencent.mm.plugin.fts.c.a aVar = a.this.wXV;
            String str = this.wWO.wWS;
            Cursor rawQuery = aVar.wUt.rawQuery(String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", aVar.dOu(), aVar.dOt(), aVar.dOu(), aVar.dOu(), kVar.wWd.dOz()), new String[]{str});
            HashSet hashSet = new HashSet();
            kVar.wXb = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                mVar.wVX = rawQuery.getString(0);
                if (hashSet.add(mVar.wVX)) {
                    kVar.wXb.add(mVar);
                }
            }
            rawQuery.close();
            kVar.resultCode = 0;
            AppMethodBeat.o(52664);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchChatroomInMemberTask";
        }
    }

    class l extends com.tencent.mm.plugin.fts.a.a.i {
        public l(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(com.tencent.mm.plugin.fts.a.a.k kVar) {
            int i2 = 0;
            AppMethodBeat.i(52663);
            super.a(kVar);
            com.tencent.mm.plugin.fts.c.a aVar = a.this.wXV;
            String str = this.wWO.query;
            String format = String.format("SELECT count(aux_index) FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075", aVar.dOt());
            Cursor rawQuery = aVar.wUt.rawQuery(format, new String[]{str});
            if (rawQuery.moveToNext()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
            mVar.userData = Integer.valueOf(i2);
            kVar.wXb = new ArrayList();
            kVar.wXb.add(mVar);
            AppMethodBeat.o(52663);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchChatroomCountTask";
        }
    }

    class r extends com.tencent.mm.plugin.fts.a.a.i {
        public r(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchContactTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 20;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(com.tencent.mm.plugin.fts.a.a.k kVar) {
            AppMethodBeat.i(52668);
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
            com.tencent.mm.plugin.fts.c.a aVar = a.this.wXV;
            com.tencent.mm.plugin.fts.a.a.h hVar = kVar.wWd;
            int[] iArr = this.wWO.wWU;
            String dOz = hVar.dOz();
            Cursor rawQuery = aVar.wUt.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + ((iArr == null || iArr.length <= 0) ? "" : " AND type IN " + com.tencent.mm.plugin.fts.a.d.C(iArr)) + " AND status >= 0 ORDER BY subtype;", aVar.dOt(), aVar.dOu(), Long.valueOf((long) hVar.wWF.size()), aVar.dOt(), aVar.dOu(), aVar.dOt(), aVar.dOu(), aVar.dOu(), dOz), null);
            ArrayList<com.tencent.mm.plugin.fts.a.a.n> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.wWO.wWX);
            int i2 = 0;
            while (rawQuery.moveToNext()) {
                if (hashSet.add(rawQuery.getString(3))) {
                    com.tencent.mm.plugin.fts.a.a.n i3 = new com.tencent.mm.plugin.fts.a.a.n().i(rawQuery);
                    if (i2 < i3.wVW) {
                        if (arrayList.size() > this.wWO.wWW) {
                            break;
                        }
                        i2 = i3.wVW;
                        arrayList.add(i3);
                    } else {
                        arrayList.add(i3);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        InterruptedException interruptedException = new InterruptedException("Task is Cancel: " + this.wWO.query);
                        AppMethodBeat.o(52668);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            kVar.wXb = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.n nVar : arrayList) {
                nVar.dOC();
                nVar.a(kVar.wWd);
                kVar.wXb.add(nVar);
            }
            if (this.wWO.wWY != null) {
                Collections.sort(kVar.wXb, this.wWO.wWY);
            }
            AppMethodBeat.o(52668);
        }
    }

    class u extends com.tencent.mm.plugin.fts.a.a.i {
        public u(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchTopContactTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 22;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(com.tencent.mm.plugin.fts.a.a.k kVar) {
            int i2 = 0;
            AppMethodBeat.i(52671);
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
            com.tencent.mm.plugin.fts.c.a aVar = a.this.wXV;
            com.tencent.mm.plugin.fts.a.a.h hVar = kVar.wWd;
            Cursor rawQuery = aVar.wUt.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", aVar.dOt(), aVar.dOu(), Long.valueOf((long) hVar.wWF.size()), Long.valueOf(System.currentTimeMillis() - 1105032704), aVar.dOt(), aVar.dOu(), aVar.dOt(), aVar.dOu(), aVar.dOu(), hVar.dOz()), null);
            ArrayList<com.tencent.mm.plugin.fts.a.a.n> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.wWO.wWX);
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n i3 = new com.tencent.mm.plugin.fts.a.a.n().i(rawQuery);
                if (hashSet.add(i3.wVX)) {
                    if (i2 < i3.wVW) {
                        if (arrayList.size() > this.wWO.wWW) {
                            break;
                        }
                        i2 = i3.wVW;
                        arrayList.add(i3);
                    } else {
                        arrayList.add(i3);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        InterruptedException interruptedException = new InterruptedException("Task is Cancel: " + this.wWO.query);
                        AppMethodBeat.o(52671);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            kVar.wXb = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.n nVar : arrayList) {
                nVar.dOC();
                nVar.a(kVar.wWd);
                kVar.wXb.add(nVar);
            }
            if (this.wWO.wWY != null) {
                Collections.sort(kVar.wXb, this.wWO.wWY);
            }
            AppMethodBeat.o(52671);
        }
    }

    class t extends com.tencent.mm.plugin.fts.a.a.i {
        public t(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchTopContactInnerRankTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 26;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(com.tencent.mm.plugin.fts.a.a.k kVar) {
            AppMethodBeat.i(52670);
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
            com.tencent.mm.plugin.fts.c.a aVar = a.this.wXV;
            com.tencent.mm.plugin.fts.a.a.h hVar = kVar.wWd;
            int[] iArr = this.wWO.wWU;
            String dOz = hVar.dOz();
            long size = (long) hVar.wWF.size();
            String format = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type IN " + com.tencent.mm.plugin.fts.a.d.C(iArr) + " ORDER BY Rank ;", aVar.dOt(), aVar.dOu(), Long.valueOf(size), aVar.dOu(), Long.valueOf(System.currentTimeMillis() - 1105032704), Long.valueOf(size), aVar.dOt(), aVar.dOu(), aVar.dOt(), aVar.dOu(), aVar.dOu(), dOz);
            Cursor rawQuery = aVar.wUt.rawQuery(format, new String[]{hVar.wWC});
            ArrayList<com.tencent.mm.plugin.fts.a.a.n> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.wWO.wWX);
            long j2 = 0;
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n h2 = new com.tencent.mm.plugin.fts.a.a.n().h(rawQuery);
                if (hashSet.add(h2.wVX)) {
                    if (j2 < h2.wXm) {
                        if (arrayList.size() > this.wWO.wWW) {
                            break;
                        }
                        j2 = h2.wXm;
                        arrayList.add(h2);
                    } else {
                        arrayList.add(h2);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        InterruptedException interruptedException = new InterruptedException("Task is Cancel: " + this.wWO.query);
                        AppMethodBeat.o(52670);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            kVar.wXb = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.n nVar : arrayList) {
                nVar.dOC();
                nVar.a(kVar.wWd);
                kVar.wXb.add(nVar);
            }
            if (this.wWO.wWY != null) {
                Collections.sort(kVar.wXb, this.wWO.wWY);
            }
            AppMethodBeat.o(52670);
        }
    }

    class s extends com.tencent.mm.plugin.fts.a.a.i {
        public s(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(com.tencent.mm.plugin.fts.a.a.k kVar) {
            AppMethodBeat.i(52669);
            ayx("start");
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
            com.tencent.mm.plugin.fts.c.a aVar = a.this.wXV;
            com.tencent.mm.plugin.fts.a.a.h hVar = kVar.wWd;
            String dOz = hVar.dOz();
            long size = (long) hVar.wWF.size();
            String format = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", aVar.dOt(), aVar.dOu(), Long.valueOf(size), aVar.dOu(), Long.valueOf(System.currentTimeMillis() - 1209600000), Long.valueOf(size), aVar.dOt(), aVar.dOu(), aVar.dOt(), aVar.dOu(), aVar.dOu(), dOz);
            Cursor rawQuery = aVar.wUt.rawQuery(format, new String[]{hVar.wWC});
            ArrayList<com.tencent.mm.plugin.fts.a.a.n> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.wWO.wWX);
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n h2 = new com.tencent.mm.plugin.fts.a.a.n().h(rawQuery);
                if (hashSet.add(h2.wVX)) {
                    if (arrayList.size() > this.wWO.wWW) {
                        break;
                    }
                    arrayList.add(h2);
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        InterruptedException interruptedException = new InterruptedException("Task is Cancel: " + this.wWO.query);
                        AppMethodBeat.o(52669);
                        throw interruptedException;
                    }
                }
            }
            rawQuery.close();
            if (Thread.interrupted()) {
                InterruptedException interruptedException2 = new InterruptedException();
                AppMethodBeat.o(52669);
                throw interruptedException2;
            }
            ayx("orm");
            kVar.wXb = new ArrayList(arrayList.size());
            for (com.tencent.mm.plugin.fts.a.a.n nVar : arrayList) {
                nVar.dOC();
                nVar.a(kVar.wWd);
                kVar.wXb.add(nVar);
            }
            if (Thread.interrupted()) {
                InterruptedException interruptedException3 = new InterruptedException();
                AppMethodBeat.o(52669);
                throw interruptedException3;
            }
            if (this.wWO.wWY != null) {
                Collections.sort(kVar.wXb, this.wWO.wWY);
            }
            ayx("calOffsets");
            if (kVar.wWd.wWF.size() > 1 && a.this.wXV.b(kVar.wWd)) {
                com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                mVar.wVX = "create_chatroom​";
                if (kVar.wXb.size() > 3) {
                    kVar.wXb.add(3, mVar);
                } else {
                    kVar.wXb.add(mVar);
                }
            }
            ayx("checkChatroom");
            AppMethodBeat.o(52669);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchTopChatroomInnerRankTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 25;
        }
    }

    class o extends com.tencent.mm.plugin.fts.a.a.i {
        public o(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchChatroomTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 19;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(com.tencent.mm.plugin.fts.a.a.k kVar) {
            AppMethodBeat.i(52665);
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
            Cursor a2 = a.this.wXV.a(kVar.wWd, new int[]{131075}, null, true, true);
            HashMap hashMap = new HashMap();
            while (a2.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n i2 = new com.tencent.mm.plugin.fts.a.a.n().i(a2);
                if (!this.wWO.wWX.contains(i2.wVX)) {
                    com.tencent.mm.plugin.fts.a.a.m mVar = (com.tencent.mm.plugin.fts.a.a.m) hashMap.get(i2.wVX);
                    if (mVar == null || com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.wUV, i2.wVW, mVar.wVW) < 0) {
                        hashMap.put(i2.wVX, i2);
                    }
                    if (Thread.interrupted()) {
                        a2.close();
                        InterruptedException interruptedException = new InterruptedException();
                        AppMethodBeat.o(52665);
                        throw interruptedException;
                    }
                }
            }
            a2.close();
            ArrayList arrayList = new ArrayList(hashMap.size());
            for (com.tencent.mm.plugin.fts.a.a.n nVar : hashMap.values()) {
                nVar.dOC();
                nVar.a(kVar.wWd);
                arrayList.add(nVar);
                if (Thread.interrupted()) {
                    InterruptedException interruptedException2 = new InterruptedException();
                    AppMethodBeat.o(52665);
                    throw interruptedException2;
                }
            }
            if (this.wWO.wWY != null) {
                Collections.sort(arrayList, this.wWO.wWY);
            }
            kVar.wXb = new ArrayList(hashMap.size());
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                com.tencent.mm.plugin.fts.a.a.m mVar2 = (com.tencent.mm.plugin.fts.a.a.m) arrayList.get(i3);
                stringBuffer.append(mVar2.wWz);
                stringBuffer.append("|");
                stringBuffer.append(mVar2.timestamp);
                stringBuffer.append(" ");
                kVar.wXb.add(mVar2);
                if (i3 >= this.wWO.wWW) {
                    break;
                }
            }
            if (kVar.wWd.wWF.size() > 1 && a.this.wXV.b(kVar.wWd)) {
                com.tencent.mm.plugin.fts.a.a.m mVar3 = new com.tencent.mm.plugin.fts.a.a.m();
                mVar3.wVX = "create_chatroom​";
                kVar.wXb.add(0, mVar3);
                stringBuffer.append(" needCreateChatroom");
            }
            Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", stringBuffer.toString());
            AppMethodBeat.o(52665);
        }
    }

    class j extends com.tencent.mm.plugin.fts.a.a.i {
        public j(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchContactLogic.SearchTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 11;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(com.tencent.mm.plugin.fts.a.a.k kVar) {
            com.tencent.mm.plugin.fts.a.a.m mVar;
            AppMethodBeat.i(52661);
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
            Cursor a2 = a.this.wXV.a(kVar.wWd, this.wWO.wWU, this.wWO.wWV, true, true);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (a2.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n i2 = new com.tencent.mm.plugin.fts.a.a.n().i(a2);
                if (!this.wWO.wWX.contains(i2.wVX)) {
                    if (com.tencent.mm.plugin.fts.a.d.k(com.tencent.mm.plugin.fts.a.c.wUK, i2.type)) {
                        com.tencent.mm.plugin.fts.a.a.m mVar2 = (com.tencent.mm.plugin.fts.a.a.m) hashMap.get(i2.wVX);
                        if (mVar2 == null || com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.wUV, i2.wVW, mVar2.wVW) < 0) {
                            hashMap.put(i2.wVX, i2);
                        }
                    } else if (com.tencent.mm.plugin.fts.a.d.k(com.tencent.mm.plugin.fts.a.c.wUM, i2.type) && ((mVar = (com.tencent.mm.plugin.fts.a.a.m) hashMap2.get(Long.valueOf(i2.wXe))) == null || com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.wUV, i2.wVW, mVar.wVW) < 0)) {
                        hashMap2.put(Long.valueOf(i2.wXe), i2);
                    }
                    if (Thread.interrupted()) {
                        a2.close();
                        InterruptedException interruptedException = new InterruptedException();
                        AppMethodBeat.o(52661);
                        throw interruptedException;
                    }
                }
            }
            a2.close();
            if (Thread.interrupted()) {
                InterruptedException interruptedException2 = new InterruptedException();
                AppMethodBeat.o(52661);
                throw interruptedException2;
            }
            kVar.wXb = new ArrayList(hashMap.size());
            for (com.tencent.mm.plugin.fts.a.a.n nVar : hashMap.values()) {
                nVar.dOC();
                nVar.a(kVar.wWd);
                kVar.wXb.add(nVar);
            }
            kVar.wXb.addAll(hashMap2.values());
            if (Thread.interrupted()) {
                InterruptedException interruptedException3 = new InterruptedException();
                AppMethodBeat.o(52661);
                throw interruptedException3;
            }
            if (this.wWO.wWY != null) {
                Collections.sort(kVar.wXb, this.wWO.wWY);
            }
            AppMethodBeat.o(52661);
        }
    }

    public class p extends com.tencent.mm.plugin.fts.a.a.i {
        public p(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchCommonChatroomTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(com.tencent.mm.plugin.fts.a.a.k kVar) {
            List arrayList;
            AppMethodBeat.i(52666);
            ArrayList<String> stringsToList = Util.stringsToList(this.wWO.query.split(","));
            com.tencent.mm.plugin.fts.c.a aVar = a.this.wXV;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("member IN (");
            for (int i2 = 0; i2 < stringsToList.size(); i2++) {
                stringBuffer.append("'");
                stringBuffer.append(stringsToList.get(i2));
                stringBuffer.append("'");
                if (i2 != stringsToList.size() - 1) {
                    stringBuffer.append(",");
                }
            }
            stringBuffer.append(")");
            Cursor rawQuery = aVar.wUt.rawQuery(String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", aVar.dOt(), stringBuffer.toString()), null);
            HashMap hashMap = new HashMap();
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                if (hashMap.containsKey(string)) {
                    arrayList = (List) hashMap.get(string);
                } else {
                    arrayList = new ArrayList();
                }
                com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                mVar.wVX = rawQuery.getString(1);
                mVar.wXe = rawQuery.getLong(2);
                arrayList.add(mVar);
                hashMap.put(string, arrayList);
            }
            rawQuery.close();
            kVar.wXb = new ArrayList();
            com.tencent.mm.plugin.fts.a.a.m mVar2 = new com.tencent.mm.plugin.fts.a.a.m();
            mVar2.userData = hashMap;
            kVar.wXb.add(mVar2);
            AppMethodBeat.o(52666);
        }
    }

    public class q extends com.tencent.mm.plugin.fts.a.a.i {
        public q(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchContactSmallerTimestampTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(com.tencent.mm.plugin.fts.a.a.k kVar) {
            AppMethodBeat.i(52667);
            long longValue = Long.valueOf(this.wWO.query).longValue();
            com.tencent.mm.plugin.fts.c.a aVar = a.this.wXV;
            Cursor rawQuery = aVar.wUt.rawQuery(String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", aVar.dOt(), Long.valueOf(longValue), 131072), null);
            kVar.wXb = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                mVar.wVX = rawQuery.getString(0);
                kVar.wXb.add(mVar);
            }
            rawQuery.close();
            AppMethodBeat.o(52667);
        }
    }

    public class n extends com.tencent.mm.plugin.fts.a.a.i {
        public n(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchChatroomMemberTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(com.tencent.mm.plugin.fts.a.a.k kVar) {
            AppMethodBeat.i(187308);
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.query, true);
            kVar.wXb = new ArrayList();
            com.tencent.mm.plugin.fts.c.a aVar = a.this.wXV;
            String str = this.wWO.wWS;
            String format = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, entity_id, type, subtype) AS Offsets FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 AND subtype = 38 AND aux_index = ? ;", aVar.dOt(), aVar.dOu(), aVar.dOu(), aVar.dOt(), aVar.dOt(), aVar.dOu(), aVar.dOu(), kVar.wWd.dOz());
            Cursor rawQuery = aVar.wUt.rawQuery(format, new String[]{str});
            if (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n i2 = new com.tencent.mm.plugin.fts.a.a.n().i(rawQuery);
                i2.dOC();
                kVar.wXb.add(i2);
            }
            rawQuery.close();
            AppMethodBeat.o(187308);
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private HashSet<String> wYm;
        private HashMap<String, as> wYn;
        private long wYo;
        private long wYp;
        private int wYq;
        private int wYr;
        private int wYs;
        private int wYt;
        private int wYu;
        private int wYv;
        private int wYw;
        private int wYx;

        private b() {
            AppMethodBeat.i(52645);
            this.wYn = new HashMap<>();
            this.wYo = -1;
            this.wYp = -1;
            this.wYq = 0;
            this.wYr = 0;
            this.wYs = 0;
            this.wYt = 0;
            this.wYu = 0;
            AppMethodBeat.o(52645);
        }

        /* synthetic */ b(a aVar, byte b2) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:136:0x02a3 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0326  */
        @Override // com.tencent.mm.plugin.fts.a.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean execute() {
            /*
            // Method dump skipped, instructions count: 965
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.b.a.b.execute():boolean");
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52647);
            String format = String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, failContact: %d, failChatroom}", Integer.valueOf(this.wYx), Integer.valueOf(this.wYr), Integer.valueOf(this.wYq), Integer.valueOf(this.wYs), Integer.valueOf(this.wYv), Integer.valueOf(this.wYw), Integer.valueOf(this.wYt), Integer.valueOf(this.wYu));
            AppMethodBeat.o(52647);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "BuildContactIndexTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(String str, as asVar, String[] strArr, byte[] bArr, HashMap<String, as> hashMap) {
        AppMethodBeat.i(52679);
        int i2 = 0;
        String str2 = asVar.field_nickname;
        String str3 = asVar.field_conRemark;
        String bB = com.tencent.mm.plugin.fts.a.d.bB(str3, false);
        String bB2 = com.tencent.mm.plugin.fts.a.d.bB(str3, true);
        String bB3 = com.tencent.mm.plugin.fts.a.d.bB(str2, false);
        String bB4 = com.tencent.mm.plugin.fts.a.d.bB(str2, true);
        long j2 = 0;
        long ayl = this.tbO.ayl(str);
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            j2 = (long) strArr.length;
            HashMap hashMap2 = new HashMap();
            com.tencent.mm.k.a.a.a aVar = new com.tencent.mm.k.a.a.a();
            try {
                aVar.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e2, "parse chatroom data", new Object[0]);
            }
            Iterator<com.tencent.mm.k.a.a.b> it = aVar.gCs.iterator();
            while (it.hasNext()) {
                com.tencent.mm.k.a.a.b next = it.next();
                if (!Util.isNullOrNil(next.gCv)) {
                    hashMap2.put(next.userName, next.gCv);
                }
            }
            for (String str4 : strArr) {
                as asVar2 = hashMap.get(str4);
                if (asVar2 != null) {
                    String str5 = asVar2.field_conRemark;
                    String str6 = asVar2.field_nickname;
                    String bB5 = com.tencent.mm.plugin.fts.a.d.bB(str5, false);
                    String bB6 = com.tencent.mm.plugin.fts.a.d.bB(str5, true);
                    stringBuffer.append(Util.nullAs(str5, " ")).append("‌");
                    stringBuffer.append(Util.nullAs(bB5, " ")).append("‌");
                    stringBuffer.append(Util.nullAs(bB6, " ")).append("‌");
                    String bB7 = com.tencent.mm.plugin.fts.a.d.bB(str6, false);
                    String bB8 = com.tencent.mm.plugin.fts.a.d.bB(str6, true);
                    stringBuffer.append(Util.nullAs(str6, " ")).append("‌");
                    stringBuffer.append(Util.nullAs(bB7, " ")).append("‌");
                    stringBuffer.append(Util.nullAs(bB8, " ")).append("‌");
                    stringBuffer.append(Util.nullAs((String) hashMap2.get(str4), " ")).append("‌");
                    T(asVar2);
                    stringBuffer.append(Util.nullAs(asVar2.fuR, " ")).append("‌");
                    stringBuffer.append(Util.nullAs(com.tencent.mm.plugin.fts.a.d.hw(str4, asVar2.ajx()), " ")).append("‌");
                    stringBuffer.append(RecoveryFileLog.SPLITTER);
                }
            }
        }
        if (!Util.isNullOrNil(str2)) {
            this.wXV.a(131075, 5, j2, str, ayl, str2);
            if (!Util.isNullOrNil(bB3)) {
                this.wXV.a(131075, 6, j2, str, ayl, bB3);
                i2 = 2;
            } else {
                i2 = 1;
            }
            if (!Util.isNullOrNil(bB4)) {
                this.wXV.a(131075, 7, j2, str, ayl, bB4);
                i2++;
            }
        }
        if (!Util.isNullOrNil(str3)) {
            this.wXV.a(131075, 1, j2, str, ayl, str3);
            i2++;
            if (!Util.isNullOrNil(bB3)) {
                this.wXV.a(131075, 2, j2, str, ayl, bB);
                i2++;
            }
            if (!Util.isNullOrNil(bB4)) {
                this.wXV.a(131075, 3, j2, str, ayl, bB2);
                i2++;
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
            this.wXV.a(131075, 38, j2, str, ayl, stringBuffer.toString());
            i2++;
        }
        AppMethodBeat.o(52679);
        return i2;
    }

    class e extends com.tencent.mm.plugin.fts.a.a.a {
        private String goe;
        private boolean hgZ = false;

        public e(String str) {
            this.goe = str;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52651);
            Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", this.goe);
            as ayj = a.this.tbO.ayj(this.goe);
            if (ayj == null || ayj.field_username.length() <= 0 || !a.this.V(ayj)) {
                this.hgZ = true;
            } else {
                a.this.W(ayj);
            }
            a.this.wXX.remove(this.goe);
            a.this.wXW.remove(this.goe);
            AppMethodBeat.o(52651);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52652);
            String format = String.format("{username: %s isSkipped: %b}", this.goe, Boolean.valueOf(this.hgZ));
            AppMethodBeat.o(52652);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "InsertContactTask";
        }
    }

    class i extends com.tencent.mm.plugin.fts.a.a.a {
        private String username;
        private boolean wYF;

        public i(String str) {
            this.username = str;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52659);
            if (a.this.wXX.containsKey(this.username)) {
                this.wYF = true;
                AppMethodBeat.o(52659);
            } else if (!a.this.wXW.add(this.username)) {
                this.wYF = true;
                AppMethodBeat.o(52659);
            } else {
                as ayj = a.this.tbO.ayj(this.username);
                if (ayj == null || a.this.V(ayj)) {
                    com.tencent.mm.plugin.fts.c.a aVar = a.this.wXV;
                    String str = this.username;
                    aVar.wUz.bindLong(1, 2);
                    aVar.wUz.bindString(2, str);
                    aVar.wUz.bindLong(3, 0);
                    aVar.wUz.execute();
                    AppMethodBeat.o(52659);
                } else {
                    this.wYF = true;
                    AppMethodBeat.o(52659);
                }
            }
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52660);
            String format = String.format("{username: %s isSkipped: %b}", this.username, Boolean.valueOf(this.wYF));
            AppMethodBeat.o(52660);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "MarkContactTimestampTask";
        }
    }

    class h extends com.tencent.mm.plugin.fts.a.a.a {
        private String goe;
        private boolean hgZ = false;
        private boolean wYE = false;

        public h(String str) {
            this.goe = str;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52657);
            Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", this.goe);
            if (a.this.wXX.containsKey(this.goe)) {
                this.wYE = true;
                AppMethodBeat.o(52657);
            } else {
                a.this.wXV.ayn(this.goe);
                List<Long> b2 = a.this.wXV.b(com.tencent.mm.plugin.fts.a.c.wUK, this.goe);
                a.this.wXX.put(this.goe, b2);
                if (b2.isEmpty()) {
                    this.hgZ = true;
                    a.this.hgI.a(65556, new e(this.goe));
                    AppMethodBeat.o(52657);
                } else {
                    Cursor ayH = a.this.wXV.ayH(this.goe);
                    HashSet hashSet = new HashSet();
                    while (ayH.moveToNext()) {
                        hashSet.add(ayH.getString(0));
                    }
                    ayH.close();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        a.this.wXV.ayn(str);
                        if (!a.this.wXX.containsKey(str)) {
                            a.this.wXX.put(str, a.this.wXV.b(com.tencent.mm.plugin.fts.a.c.wUK, str));
                        }
                    }
                    a.this.wXW.remove(this.goe);
                    ((PluginFTS) com.tencent.mm.kernel.g.ah(PluginFTS.class)).getTopHitsLogic().ayF(this.goe);
                    AppMethodBeat.o(52657);
                }
            }
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52658);
            String format = String.format("{username: %s cached: %b isSkipped: %b}", this.goe, Boolean.valueOf(this.wYE), Boolean.valueOf(this.hgZ));
            AppMethodBeat.o(52658);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "MarkContactDirtyTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 17;
        }
    }

    class c extends com.tencent.mm.plugin.fts.a.a.a {
        private c() {
        }

        /* synthetic */ c(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52648);
            a.this.wXV.B(com.tencent.mm.plugin.fts.a.c.wUI);
            AppMethodBeat.o(52648);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "DeleteAllFriendTask";
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private String goe;
        private int wYz = 0;

        public d(String str) {
            this.goe = str;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52649);
            Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", this.goe);
            a.this.wXV.a(com.tencent.mm.plugin.fts.a.c.wUK, this.goe);
            ((PluginFTS) com.tencent.mm.kernel.g.ah(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.wUK, this.goe);
            Cursor ayH = a.this.wXV.ayH(this.goe);
            HashSet hashSet = new HashSet();
            while (ayH.moveToNext()) {
                hashSet.add(ayH.getString(0));
            }
            ayH.close();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!a.this.wXX.containsKey(str)) {
                    a.this.wXX.put(str, a.this.wXV.b(com.tencent.mm.plugin.fts.a.c.wUK, str));
                    ((PluginFTS) com.tencent.mm.kernel.g.ah(PluginFTS.class)).getTopHitsLogic().ayF(str);
                    this.wYz++;
                }
            }
            AppMethodBeat.o(52649);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52650);
            String format = String.format("{username: %s mDirtyCount: %d}", this.goe, Integer.valueOf(this.wYz));
            AppMethodBeat.o(52650);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "DeleteContactTask";
        }
    }

    class v extends com.tencent.mm.plugin.fts.a.a.a {
        private int wYG;
        private int wYH;
        private int wYI;

        private v() {
            this.wYG = 0;
            this.wYH = 0;
            this.wYI = 0;
        }

        /* synthetic */ v(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            int i2;
            int i3;
            AppMethodBeat.i(52672);
            ayx("start");
            Iterator it = a.this.wXX.entrySet().iterator();
            int i4 = 50;
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    a.this.wXV.commit();
                    InterruptedException interruptedException = new InterruptedException();
                    AppMethodBeat.o(52672);
                    throw interruptedException;
                }
                if (i4 >= 50) {
                    a.this.wXV.commit();
                    a.this.wXV.beginTransaction();
                    i3 = 0;
                } else {
                    i3 = i4;
                }
                Map.Entry entry = (Map.Entry) it.next();
                for (Long l : (List) entry.getValue()) {
                    a.this.wXV.GC(l.longValue());
                    i3++;
                }
                String str = (String) entry.getKey();
                as ayj = a.this.tbO.ayj(str);
                if (ayj != null && ayj.field_username.length() > 0 && a.this.V(ayj)) {
                    i3 += a.this.W(ayj);
                }
                it.remove();
                a.this.wXW.remove(str);
                this.wYG++;
                i4 = i3;
            }
            ayx("dirtyContact");
            Iterator it2 = a.this.wXW.iterator();
            while (it2.hasNext()) {
                if (Thread.interrupted()) {
                    a.this.wXV.commit();
                    InterruptedException interruptedException2 = new InterruptedException();
                    AppMethodBeat.o(52672);
                    throw interruptedException2;
                }
                if (i4 >= 50) {
                    a.this.wXV.commit();
                    a.this.wXV.beginTransaction();
                    i2 = 0;
                } else {
                    i2 = i4;
                }
                String str2 = (String) it2.next();
                long ayl = a.this.tbO.ayl(str2);
                as ayj2 = a.this.tbO.ayj(str2);
                if (ayj2 == null || ayj2.field_username.length() <= 0 || !a.this.V(ayj2)) {
                    i4 = i2;
                } else {
                    a.this.wXV.av(str2, ayl);
                    i4 = i2 + 1;
                }
                it2.remove();
                this.wYH++;
            }
            a.this.wXV.commit();
            ayx("timestampContact");
            e topHitsLogic = ((PluginFTS) com.tencent.mm.kernel.g.ah(PluginFTS.class)).getTopHitsLogic();
            topHitsLogic.wZo.clear();
            this.wYI = topHitsLogic.wZn.dOZ();
            ayx("topHits");
            AppMethodBeat.o(52672);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52673);
            String format = String.format("{Dirty: %d Timestamp: %d tophitsCount: %d}", Integer.valueOf(this.wYG), Integer.valueOf(this.wYH), Integer.valueOf(this.wYI));
            AppMethodBeat.o(52673);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "UpdateDirtyAndTimestampContactTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 16;
        }
    }

    class g extends com.tencent.mm.plugin.fts.a.a.a {
        private int tkX = 0;
        private int[] wYC;
        private int wYD = 0;

        public g(int[] iArr) {
            this.wYC = iArr;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52655);
            List<com.tencent.mm.plugin.fts.a.a.b> j2 = a.this.wXV.j(this.wYC, 1);
            this.tkX = j2.size();
            HashMap hashMap = new HashMap();
            for (com.tencent.mm.plugin.fts.a.a.b bVar : j2) {
                String str = bVar.wVX;
                if (!a.this.wXX.containsKey(str)) {
                    List list = (List) hashMap.get(str);
                    if (list == null) {
                        list = new ArrayList(16);
                        hashMap.put(str, list);
                    }
                    list.add(Long.valueOf(bVar.wVV));
                }
            }
            a.this.wXX.putAll(hashMap);
            this.wYD = hashMap.size();
            AppMethodBeat.o(52655);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52656);
            String format = String.format("{touched: %d users: %d}", Integer.valueOf(this.tkX), Integer.valueOf(this.wYD));
            AppMethodBeat.o(52656);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "MarkAllContactDirtyTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.a$a  reason: collision with other inner class name */
    class C1375a extends com.tencent.mm.plugin.fts.a.a.a {
        private int tbV;
        private int tbW;

        private C1375a() {
            this.tbV = 0;
            this.tbW = 0;
        }

        /* synthetic */ C1375a(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52642);
            Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
            HashSet hashSet = new HashSet();
            Cursor rawQuery = a.this.wXV.wUt.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
            while (rawQuery.moveToNext()) {
                hashSet.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Cursor i2 = a.this.tbO.i("SELECT chatroomname, memberlist FROM chatroom;", null);
            int i3 = 5;
            while (i2.moveToNext()) {
                if (Thread.interrupted()) {
                    i2.close();
                    a.this.wXV.commit();
                    InterruptedException interruptedException = new InterruptedException();
                    AppMethodBeat.o(52642);
                    throw interruptedException;
                }
                String string = i2.getString(0);
                String string2 = i2.getString(1);
                if (!Util.isNullOrNil(string2) && !Util.isNullOrNil(string) && a.ayC(string2)) {
                    String[] split = c.a.wUY.split(string2);
                    a.this.wXY.put(string, split);
                    if (!hashSet.remove(string)) {
                        if (i3 >= 5) {
                            a.this.wXV.commit();
                            a.this.wXV.beginTransaction();
                            i3 = 0;
                        }
                        a.this.wXV.k(string, split);
                        i3++;
                        this.tbV++;
                    }
                }
            }
            i2.close();
            a.this.wXV.commit();
            Iterator it = hashSet.iterator();
            int i4 = 5;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (i4 >= 5) {
                    a.this.wXV.commit();
                    a.this.wXV.beginTransaction();
                    i4 = 0;
                }
                a.this.wXV.ayI(str);
                this.tbW++;
                i4++;
            }
            a.this.wXV.commit();
            AppMethodBeat.o(52642);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "BuildChatroomIndexTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52643);
            String format = String.format("{new: %d removed: %d}", Integer.valueOf(this.tbV), Integer.valueOf(this.tbW));
            AppMethodBeat.o(52643);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 3;
        }
    }

    public final int j(String str, String[] strArr) {
        int i2;
        AppMethodBeat.i(52680);
        String[] strArr2 = this.wXY.get(str);
        this.wXV.beginTransaction();
        if (strArr2 == null) {
            this.wXV.ayI(str);
            i2 = ((int) this.wXV.wZG.simpleQueryForLong()) + 0;
            if (strArr != null) {
                this.wXV.k(str, strArr);
                this.wXY.put(str, strArr);
                i2 += strArr.length;
            }
        } else if (strArr == null) {
            this.wXV.ayI(str);
            i2 = ((int) this.wXV.wZG.simpleQueryForLong()) + 0;
            this.wXY.remove(str);
        } else {
            HashSet hashSet = new HashSet(Arrays.asList(strArr2));
            int i3 = 0;
            for (String str2 : strArr) {
                if (!hashSet.remove(str2)) {
                    com.tencent.mm.plugin.fts.c.a aVar = this.wXV;
                    aVar.wZA.bindString(1, str);
                    aVar.wZA.bindString(2, str2);
                    aVar.wZA.execute();
                    i3++;
                }
            }
            Iterator it = hashSet.iterator();
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mm.plugin.fts.c.a aVar2 = this.wXV;
                aVar2.wZB.bindString(1, str);
                aVar2.wZB.bindString(2, (String) it.next());
                aVar2.wZB.execute();
                i3 = i2 + 1;
            }
            this.wXY.put(str, strArr);
        }
        this.wXV.commit();
        AppMethodBeat.o(52680);
        return i2;
    }

    class f extends com.tencent.mm.plugin.fts.a.a.a {
        private int wYA;
        private int wYB;

        private f() {
            this.wYA = 0;
            this.wYB = 0;
        }

        /* synthetic */ f(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52653);
            Cursor rawQuery = a.this.wXV.wUt.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                long j2 = rawQuery.getLong(1);
                List list = (List) a.this.wXZ.get(string);
                if (list == null) {
                    list = new ArrayList(16);
                    a.this.wXZ.put(string, list);
                    this.wYA++;
                }
                list.add(Long.valueOf(j2));
                this.wYB++;
            }
            rawQuery.close();
            AppMethodBeat.o(52653);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52654);
            String format = String.format("{users: %d labels: %d}", Integer.valueOf(this.wYA), Integer.valueOf(this.wYB));
            AppMethodBeat.o(52654);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "LoadLabelCacheTask";
        }
    }

    class w extends com.tencent.mm.plugin.fts.a.a.a {
        private long wYJ;
        private int wYK = 0;

        public w(long j2) {
            this.wYJ = j2;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52674);
            ArrayList arrayList = new ArrayList(32);
            com.tencent.mm.plugin.fts.c.a aVar = a.this.wXV;
            long j2 = this.wYJ;
            Cursor rawQuery = aVar.wUt.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[]{Long.toString(j2)});
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!a.this.wXX.containsKey(str)) {
                    a.this.wXX.put(str, a.this.wXV.b(com.tencent.mm.plugin.fts.a.c.wUL, str));
                }
            }
            AppMethodBeat.o(52674);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52675);
            String format = String.format("{mLabelId: %d mContactCount: %d}", Long.valueOf(this.wYJ), Integer.valueOf(this.wYK));
            AppMethodBeat.o(52675);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "UpdateLabelTask";
        }
    }

    public a() {
        AppMethodBeat.i(52681);
        AppMethodBeat.o(52681);
    }

    /* access modifiers changed from: package-private */
    public final void T(as asVar) {
        AppMethodBeat.i(52682);
        try {
            this.wYa.invoke(asVar, new Object[0]);
            AppMethodBeat.o(52682);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e2, "Failed parsing RContact LVBuffer.", new Object[0]);
            AppMethodBeat.o(52682);
        }
    }

    static boolean ayB(String str) {
        AppMethodBeat.i(52683);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(52683);
            return false;
        } else if (str.endsWith("@stranger")) {
            AppMethodBeat.o(52683);
            return false;
        } else if (str.endsWith("@qqim")) {
            AppMethodBeat.o(52683);
            return false;
        } else if (str.endsWith("@app")) {
            AppMethodBeat.o(52683);
            return false;
        } else if (str.startsWith("fake_")) {
            AppMethodBeat.o(52683);
            return false;
        } else if (str.endsWith("@gamelifesess") || str.endsWith("@gamelife") || str.endsWith("@gamelifehistory")) {
            AppMethodBeat.o(52683);
            return false;
        } else {
            AppMethodBeat.o(52683);
            return true;
        }
    }

    static boolean U(as asVar) {
        AppMethodBeat.i(52684);
        if (asVar.isHidden() && !"notifymessage".equals(asVar.field_username)) {
            AppMethodBeat.o(52684);
            return false;
        } else if (asVar.ary()) {
            AppMethodBeat.o(52684);
            return false;
        } else if (asVar.field_deleteFlag != 0) {
            AppMethodBeat.o(52684);
            return false;
        } else {
            if (!com.tencent.mm.contact.c.oR(asVar.field_type)) {
                if (asVar.arx()) {
                    AppMethodBeat.o(52684);
                    return false;
                } else if (asVar.gBM()) {
                    AppMethodBeat.o(52684);
                    return false;
                }
            }
            AppMethodBeat.o(52684);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final int X(as asVar) {
        int i2;
        long j2;
        String str;
        int i3;
        int i4;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i5;
        String str8;
        String str9;
        AppMethodBeat.i(52687);
        long j3 = asVar.gMZ;
        String str10 = asVar.field_username;
        String ajx = asVar.ajx();
        String str11 = asVar.field_nickname;
        String bB = com.tencent.mm.plugin.fts.a.d.bB(str11, false);
        String bB2 = com.tencent.mm.plugin.fts.a.d.bB(str11, true);
        String str12 = asVar.field_conRemark;
        String bB3 = com.tencent.mm.plugin.fts.a.d.bB(str12, false);
        String bB4 = com.tencent.mm.plugin.fts.a.d.bB(str12, true);
        String str13 = asVar.fuR;
        String str14 = asVar.field_contactLabelIds;
        String str15 = asVar.fuX;
        int i6 = asVar.field_verifyFlag;
        long currentTimeMillis = System.currentTimeMillis();
        if ((i6 & as.gBP()) != 0) {
            str = Util.listToString(((com.tencent.mm.api.n) com.tencent.mm.kernel.g.af(com.tencent.mm.api.n.class)).fE(str10), RecoveryFileLog.SPLITTER);
            i2 = 0;
            j2 = currentTimeMillis;
            i3 = 131076;
        } else if (as.bjp(str10)) {
            i2 = 0;
            j2 = currentTimeMillis;
            str = "";
            i3 = 131081;
        } else {
            long ayl = this.tbO.ayl(str10);
            if (str14 == null || str14.length() <= 0) {
                i2 = 0;
                j2 = ayl;
                str = "";
                i3 = 131072;
            } else {
                i2 = a(j3, str10, str14, ayl) + 0;
                j2 = ayl;
                str = "";
                i3 = 131072;
            }
        }
        String hw = com.tencent.mm.plugin.fts.a.d.hw(str10, ajx);
        if (hw == null || hw.length() == 0) {
            i4 = i2;
        } else {
            this.wXV.a(i3, 15, j3, str10, j2, hw);
            i4 = i2 + 1;
        }
        if (str12 == null || str12.length() == 0) {
            str3 = null;
            str6 = null;
            str7 = bB2;
            str5 = bB;
            str4 = str11;
            str2 = null;
        } else {
            str7 = bB4;
            str5 = bB3;
            str4 = str12;
            str6 = bB2;
            str3 = bB;
            str2 = str11;
        }
        if (!(str4 == null || str4.length() == 0)) {
            if (str4.equalsIgnoreCase(str5)) {
                str9 = null;
            } else {
                str9 = str5;
            }
            if (str9 == null || str9.length() == 0 || str9.equalsIgnoreCase(str7)) {
                str7 = null;
            }
            this.wXV.a(i3, 1, j3, str10, j2, str4);
            if (!(str9 == null || str9.length() == 0)) {
                this.wXV.a(i3, 2, j3, str10, j2, str9);
            }
            if (!(str7 == null || str7.length() == 0)) {
                this.wXV.a(i3, 3, j3, str10, j2, str7);
            }
            i4 += 3;
        }
        if (str2 == null || str2.length() == 0) {
            i5 = i4;
        } else {
            if (str2.equalsIgnoreCase(str3)) {
                str3 = null;
            }
            if (str3 == null || str3.length() == 0 || str3.equalsIgnoreCase(str6)) {
                str8 = null;
            } else {
                str8 = str6;
            }
            this.wXV.a(i3, 5, j3, str10, j2, str2);
            if (!(str3 == null || str3.length() == 0)) {
                this.wXV.a(i3, 6, j3, str10, j2, str3);
            }
            if (!(str8 == null || str8.length() == 0)) {
                this.wXV.a(i3, 7, j3, str10, j2, str8);
            }
            i5 = i4 + 3;
        }
        if (str13 != null && str13.length() > 0) {
            this.wXV.a(i3, 4, j3, str10, j2, str13);
            i5++;
        }
        if (i3 == 131072) {
            if (!Util.isNullOrNil(str15)) {
                this.wXV.a(i3, 16, j3, str10, j2, str15.replace(com.tencent.mm.contact.a.d(asVar), RecoveryFileLog.SPLITTER));
                i5++;
            } else {
                Cursor i7 = this.tbO.i("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[]{str10});
                if (i7.moveToFirst()) {
                    this.wXV.a(i3, 16, j3, str10, j2, i7.getString(0));
                    i5++;
                }
                i7.close();
            }
            String It = It(asVar.getProvince());
            if (!(It == null || It.length() == 0)) {
                this.wXV.a(i3, 18, j3, str10, j2, It);
                i5++;
            }
            String city = asVar.getCity();
            if (!(city == null || city.length() == 0)) {
                this.wXV.a(i3, 17, j3, str10, j2, city);
                i5++;
            }
        }
        if (i3 == 131076 && !Util.isNullOrNil(str)) {
            this.wXV.a(i3, 19, j3, str10, j2, str);
            i5++;
            String bB5 = com.tencent.mm.plugin.fts.a.d.bB(str, false);
            if (!Util.isNullOrNil(bB5)) {
                this.wXV.a(i3, 20, j3, str10, j2, bB5);
                i5++;
            }
            String bB6 = com.tencent.mm.plugin.fts.a.d.bB(str, true);
            if (!Util.isNullOrNil(bB6)) {
                this.wXV.a(i3, 21, j3, str10, j2, bB6);
                i5++;
            }
        }
        if (i3 == 131081) {
            i5 += a(asVar, j2);
        }
        AppMethodBeat.o(52687);
        return i5;
    }

    private void hx(String str, String str2) {
        ArrayList<Long> arrayList;
        AppMethodBeat.i(52689);
        String[] split = c.a.wVf.split(str2);
        if (split.length != 0) {
            ArrayList arrayList2 = new ArrayList(split.length);
            for (String str3 : split) {
                arrayList2.add(Long.valueOf(Util.getLong(str3, 0)));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        List<Long> list = this.wXZ.get(str);
        if (list == null) {
            this.wXV.ayG(str);
            if (arrayList != null && !arrayList.isEmpty()) {
                this.wXV.u(str, arrayList);
                this.wXZ.put(str, arrayList);
                AppMethodBeat.o(52689);
                return;
            }
        } else if (arrayList == null || arrayList.isEmpty()) {
            this.wXV.ayG(str);
            this.wXZ.remove(str);
            AppMethodBeat.o(52689);
            return;
        } else {
            HashSet hashSet = new HashSet(list);
            for (Long l2 : arrayList) {
                long longValue = l2.longValue();
                if (!hashSet.remove(Long.valueOf(longValue))) {
                    com.tencent.mm.plugin.fts.c.a aVar = this.wXV;
                    aVar.wZD.bindString(1, str);
                    aVar.wZD.bindLong(2, longValue);
                    aVar.wZD.execute();
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                long longValue2 = ((Long) it.next()).longValue();
                com.tencent.mm.plugin.fts.c.a aVar2 = this.wXV;
                aVar2.wZE.bindString(1, str);
                aVar2.wZE.bindLong(2, longValue2);
                aVar2.wZE.execute();
            }
            this.wXZ.put(str, arrayList);
        }
        AppMethodBeat.o(52689);
    }

    private int a(long j2, String str, String str2, long j3) {
        AppMethodBeat.i(52690);
        if (str2 != null) {
            if (str2.endsWith("\u0000")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            if (str2.length() == 0) {
                AppMethodBeat.o(52690);
                return 0;
            }
            hx(str, str2);
            List<String> aym = this.tbO.aym(str2);
            if (aym.size() == 0) {
                AppMethodBeat.o(52690);
                return 0;
            }
            this.wXV.a(131072, 11, j2, str, j3, Util.listToString(aym, RecoveryFileLog.SPLITTER));
            AppMethodBeat.o(52690);
            return 1;
        }
        AppMethodBeat.o(52690);
        return 0;
    }

    static {
        AppMethodBeat.i(52693);
        String[] split = MMApplicationContext.getContext().getString(R.string.bja).split(";");
        if (split != null) {
            for (String str : split) {
                wYj.add(str);
            }
        }
        AppMethodBeat.o(52693);
    }

    private static String It(String str) {
        AppMethodBeat.i(52691);
        if (wYj.contains(str)) {
            AppMethodBeat.o(52691);
            return "";
        }
        AppMethodBeat.o(52691);
        return str;
    }

    public static boolean ayC(String str) {
        AppMethodBeat.i(52692);
        boolean contains = Util.nullAs(str, "").contains(z.aTY());
        AppMethodBeat.o(52692);
        return contains;
    }

    /* access modifiers changed from: package-private */
    public final boolean V(as asVar) {
        AppMethodBeat.i(52685);
        String str = asVar.field_username;
        if (!U(asVar)) {
            AppMethodBeat.o(52685);
            return false;
        } else if (!ayB(str)) {
            AppMethodBeat.o(52685);
            return false;
        } else if (as.bjt(str) || as.bjs(str)) {
            AppMethodBeat.o(52685);
            return false;
        } else if (com.tencent.mm.contact.c.oR(asVar.field_type)) {
            AppMethodBeat.o(52685);
            return true;
        } else if (asVar.arx() || asVar.gBM()) {
            AppMethodBeat.o(52685);
            return false;
        } else if (this.tbO.ayk(str)) {
            AppMethodBeat.o(52685);
            return true;
        } else {
            AppMethodBeat.o(52685);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final int W(as asVar) {
        byte[] bArr;
        String str;
        AppMethodBeat.i(52686);
        if (ab.Eq(asVar.field_username)) {
            Cursor i2 = this.tbO.i(String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", "chatroom"), new String[]{asVar.field_username});
            try {
                if (i2.moveToNext()) {
                    str = i2.getString(0);
                    bArr = i2.getBlob(1);
                } else {
                    bArr = null;
                    str = null;
                }
                if (i2 != null) {
                    i2.close();
                }
                if (Util.isNullOrNil(str) || bArr == null || !ayC(str)) {
                    Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", asVar.field_username);
                    int j2 = j(asVar.field_username, null);
                    if (j2 > 0) {
                        Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", asVar.field_username, Integer.valueOf(j2));
                    }
                    AppMethodBeat.o(52686);
                    return 0;
                }
                String[] split = c.a.wUY.split(str);
                Arrays.sort(split, new Comparator<String>() {
                    /* class com.tencent.mm.plugin.fts.b.a.AnonymousClass9 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(String str, String str2) {
                        AppMethodBeat.i(52641);
                        int stringCompareUtfBinary = FTSJNIUtils.stringCompareUtfBinary(str, str2);
                        AppMethodBeat.o(52641);
                        return stringCompareUtfBinary;
                    }
                });
                int j3 = j(asVar.field_username, split);
                if (j3 > 0) {
                    Log.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", asVar.field_username, Integer.valueOf(j3));
                }
                HashMap<String, as> hashMap = new HashMap<>();
                i2 = this.tbO.i("SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + com.tencent.mm.plugin.fts.a.d.J(split) + ";", null);
                while (i2.moveToNext()) {
                    try {
                        as asVar2 = new as();
                        asVar2.gMZ = i2.getLong(0);
                        asVar2.setUsername(i2.getString(1));
                        asVar2.BC(i2.getString(2));
                        asVar2.BD(i2.getString(3));
                        asVar2.setNickname(i2.getString(4));
                        asVar2.Z(i2.getBlob(5));
                        hashMap.put(asVar2.field_username, asVar2);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i2 != null) {
                    i2.close();
                }
                int a2 = a(asVar.field_username, asVar, split, bArr, hashMap);
                AppMethodBeat.o(52686);
                return a2;
            } finally {
                if (i2 != null) {
                    i2.close();
                }
                AppMethodBeat.o(52686);
            }
        } else {
            int X = X(asVar);
            AppMethodBeat.o(52686);
            return X;
        }
    }

    private int a(as asVar, long j2) {
        int i2 = 0;
        AppMethodBeat.i(52688);
        String str = asVar.fvb;
        if (!Util.isNullOrNil(str)) {
            com.tencent.mm.openim.a.b bVar = new com.tencent.mm.openim.a.b();
            bVar.Sa(str);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = 0; i3 < bVar.jGV.size(); i3++) {
                for (b.C0498b bVar2 : bVar.jGV.get(i3).jGW) {
                    String Sb = bVar2.Sb(asVar.field_openImAppid);
                    if (!Util.isNullOrNil(Sb)) {
                        stringBuffer.append(Sb);
                        stringBuffer.append("‌");
                    }
                }
                stringBuffer.append(RecoveryFileLog.SPLITTER);
            }
            if (!Util.isNullOrNil(stringBuffer.toString())) {
                this.wXV.a(131081, 51, asVar.gMZ, asVar.field_username, j2, stringBuffer.toString());
                i2 = 1;
            }
        }
        AppMethodBeat.o(52688);
        return i2;
    }
}
