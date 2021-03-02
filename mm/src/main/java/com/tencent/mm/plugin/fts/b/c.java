package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.os.Looper;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public final class c extends com.tencent.mm.plugin.fts.a.b implements i.a {
    private IListener gsS = new IListener<sx>() {
        /* class com.tencent.mm.plugin.fts.b.c.AnonymousClass1 */

        {
            AppMethodBeat.i(160981);
            this.__eventId = sx.class.getName().hashCode();
            AppMethodBeat.o(160981);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sx sxVar) {
            AppMethodBeat.i(52711);
            sx sxVar2 = sxVar;
            if (sxVar2 instanceof sx) {
                c.this.hgI.a(65576, new b(sxVar2.dZt.msgId));
            }
            AppMethodBeat.o(52711);
            return false;
        }
    };
    private IListener gsT = new IListener<sw>() {
        /* class com.tencent.mm.plugin.fts.b.c.AnonymousClass2 */

        {
            AppMethodBeat.i(160982);
            this.__eventId = sw.class.getName().hashCode();
            AppMethodBeat.o(160982);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sw swVar) {
            AppMethodBeat.i(52712);
            sw swVar2 = swVar;
            if (swVar2 instanceof sw) {
                c.this.hgI.a(65576, new b(swVar2.dZp.msgId));
            }
            AppMethodBeat.o(52712);
            return false;
        }
    };
    m hgI;
    com.tencent.mm.plugin.fts.a.j tbO;
    com.tencent.mm.plugin.fts.c.c wYQ;
    boolean wYR = false;
    private IListener wYS = new IListener<ur>() {
        /* class com.tencent.mm.plugin.fts.b.c.AnonymousClass3 */

        {
            AppMethodBeat.i(160983);
            this.__eventId = ur.class.getName().hashCode();
            AppMethodBeat.o(160983);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ur urVar) {
            AppMethodBeat.i(52714);
            c.this.hgI.a(65574, new com.tencent.mm.plugin.fts.a.a.a() {
                /* class com.tencent.mm.plugin.fts.b.c.AnonymousClass3.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.fts.a.a.a
                public final boolean execute() {
                    AppMethodBeat.i(52713);
                    c.this.wYQ.W(-200, MAlarmHandler.NEXT_FIRE_INTERVAL);
                    AppMethodBeat.o(52713);
                    return true;
                }

                public final String toString() {
                    return "ResetMessageCreateTimeCursor";
                }
            });
            AppMethodBeat.o(52714);
            return false;
        }
    };
    IListener wYT = new IListener<com.tencent.mm.g.a.d>() {
        /* class com.tencent.mm.plugin.fts.b.c.AnonymousClass4 */

        {
            AppMethodBeat.i(160984);
            this.__eventId = com.tencent.mm.g.a.d.class.getName().hashCode();
            AppMethodBeat.o(160984);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.d dVar) {
            AppMethodBeat.i(52715);
            if (!dVar.dBP.dBQ) {
                c.this.wYU.startTimer(Util.MILLSECONDS_OF_MINUTE);
            } else {
                c.this.wYU.stopTimer();
            }
            AppMethodBeat.o(52715);
            return false;
        }
    };
    MTimerHandler wYU = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.fts.b.c.AnonymousClass5 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(52716);
            if (!c.this.wYR) {
                c.this.wYR = true;
                if (c.this.hgI != null) {
                    c.this.hgI.a(131112, new a(c.this, (byte) 0));
                }
            }
            EventCenter.instance.removeListener(c.this.wYT);
            AppMethodBeat.o(52716);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(52717);
            String str = super.toString() + "|mBackgroundTimer";
            AppMethodBeat.o(52717);
            return str;
        }
    }, false);
    h.a wYV = new h.a() {
        /* class com.tencent.mm.plugin.fts.b.c.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.fts.a.a.h.a
        public final String[] split(String str) {
            AppMethodBeat.i(52718);
            if (((PluginFTS) com.tencent.mm.kernel.g.ah(PluginFTS.class)).getFTSIndexDB().wTE) {
                String[] listToStrings = Util.listToStrings(c.ayE(str));
                AppMethodBeat.o(52718);
                return listToStrings;
            }
            String[] split = c.a.wVe.split(str);
            AppMethodBeat.o(52718);
            return split;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.h.a
        public final String[] ayy(String str) {
            AppMethodBeat.i(52719);
            String[] split = c.a.wVe.split(str, 2);
            AppMethodBeat.o(52719);
            return split;
        }
    };

    public c() {
        AppMethodBeat.i(52735);
        AppMethodBeat.o(52735);
    }

    @Override // com.tencent.mm.plugin.fts.a.k, com.tencent.mm.plugin.fts.a.b
    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j jVar) {
        com.tencent.mm.plugin.fts.a.a.a jVar2;
        AppMethodBeat.i(52736);
        switch (jVar.kXb) {
            case 1:
                Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "total message count %d", Long.valueOf(com.tencent.mm.plugin.fts.a.e.wVl.wVr));
                if (com.tencent.mm.plugin.fts.a.e.wVl.wVr < TimeUtil.SECOND_TO_US) {
                    jVar2 = new i(jVar);
                    break;
                } else {
                    jVar2 = new g(jVar);
                    break;
                }
            case 3:
                jVar2 = new f(jVar);
                break;
            case 10:
                jVar2 = new h(jVar);
                break;
            case 11:
                jVar2 = new e(jVar);
                break;
            case 256:
                jVar2 = new j(jVar);
                break;
            default:
                jVar2 = new i(jVar);
                break;
        }
        com.tencent.mm.plugin.fts.a.a.a a2 = this.hgI.a(-65536, jVar2);
        AppMethodBeat.o(52736);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean onCreate() {
        AppMethodBeat.i(52737);
        if (!((n) com.tencent.mm.kernel.g.ah(n.class)).isFTSContextReady()) {
            Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
            AppMethodBeat.o(52737);
            return false;
        }
        Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
        this.wYQ = (com.tencent.mm.plugin.fts.c.c) ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexStorage(4);
        this.hgI = ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSTaskDaemon();
        this.tbO = ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSMainDB();
        this.wYT.alive();
        this.wYS.alive();
        this.gsT.alive();
        this.gsS.alive();
        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this, (Looper) null);
        AppMethodBeat.o(52737);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.b
    public final boolean axa() {
        AppMethodBeat.i(52738);
        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this);
        this.wYT.dead();
        this.wYS.dead();
        this.gsT.dead();
        this.gsS.dead();
        this.wYQ = null;
        this.hgI = null;
        this.wYU.stopTimer();
        AppMethodBeat.o(52738);
        return true;
    }

    @Override // com.tencent.mm.plugin.fts.a.k
    public final String getName() {
        return "FTS5SearchMessageLogic";
    }

    class i extends com.tencent.mm.plugin.fts.a.a.i {
        private int wZj = 0;
        private int wZk = 0;

        public i(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            AppMethodBeat.i(52733);
            ayx("start");
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.a(this.wWO.query, false, c.this.wYV);
            com.tencent.mm.plugin.fts.c.c cVar = c.this.wYQ;
            com.tencent.mm.plugin.fts.a.a.h hVar = kVar.wWd;
            int i2 = this.wWO.wWW;
            Cursor rawQuery = cVar.wUt.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (i2 != Integer.MAX_VALUE ? " LIMIT " + (i2 + 1) : "") + ";", cVar.dOt(), cVar.dOu(), cVar.dOt(), cVar.dOu(), cVar.dOu(), hVar.dOz()), null);
            kVar.wXb = new LinkedList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                mVar.type = rawQuery.getInt(0);
                mVar.wVW = rawQuery.getInt(1);
                mVar.wXe = rawQuery.getLong(2);
                mVar.wVX = rawQuery.getString(3);
                mVar.timestamp = rawQuery.getLong(4);
                int i3 = rawQuery.getInt(5);
                if (i3 == 1 && ab.JB(mVar.wVX)) {
                    i3 = 0;
                }
                mVar.userData = Integer.valueOf(i3);
                kVar.wXb.add(mVar);
                this.wZj = ((Integer) mVar.userData).intValue() + this.wZj;
                this.wZk++;
            }
            rawQuery.close();
            ayx("groupMessage");
            if (kVar.wWd.wWE.length > 1) {
                Cursor a2 = ((com.tencent.mm.plugin.fts.c.a) ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexStorage(3)).a(com.tencent.mm.plugin.fts.a.a.h.bE(kVar.wWd.wWE[0], true), null, com.tencent.mm.plugin.fts.a.c.wUL, com.tencent.mm.plugin.fts.a.c.wUP);
                if (a2.moveToNext()) {
                    com.tencent.mm.plugin.fts.a.a.m mVar2 = new com.tencent.mm.plugin.fts.a.a.m();
                    mVar2.wVX = "create_talker_message​";
                    kVar.wXb.add(0, mVar2);
                }
                a2.close();
                ayx("findTalkerConversation");
            }
            AppMethodBeat.o(52733);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52734);
            String format = String.format("{totalMsgCount: %d conversationCount: %d}", Integer.valueOf(this.wZj), Integer.valueOf(this.wZk));
            AppMethodBeat.o(52734);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchTopGroupMessageTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 15;
        }
    }

    class f extends com.tencent.mm.plugin.fts.a.a.i {
        f(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            AppMethodBeat.i(52730);
            ayx("start");
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.a(this.wWO.query, false, c.this.wYV);
            com.tencent.mm.plugin.fts.c.c cVar = c.this.wYQ;
            com.tencent.mm.plugin.fts.a.a.h hVar = kVar.wWd;
            String str = this.wWO.wWS;
            String format = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", cVar.dOt(), cVar.dOt(), cVar.dOu(), cVar.dOt(), cVar.dOu(), cVar.dOu(), hVar.dOz());
            Cursor rawQuery = cVar.wUt.rawQuery(format, new String[]{str});
            kVar.wXb = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n g2 = new com.tencent.mm.plugin.fts.a.a.n().g(rawQuery);
                g2.userData = 1;
                kVar.wXb.add(g2);
            }
            rawQuery.close();
            ayx("findConversationMessage");
            if (kVar.wWd.wWE.length > 1 && !this.wWO.wWX.contains("create_talker_message​")) {
                Cursor a2 = ((com.tencent.mm.plugin.fts.c.a) ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexStorage(3)).a(com.tencent.mm.plugin.fts.a.a.h.bE(kVar.wWd.wWE[0], true), null, com.tencent.mm.plugin.fts.a.c.wUL, com.tencent.mm.plugin.fts.a.c.wUP);
                if (a2.moveToNext()) {
                    com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                    mVar.wVX = "create_talker_message​";
                    kVar.wXb.add(0, mVar);
                }
                a2.close();
                ayx("findTalkerConversation");
            }
            AppMethodBeat.o(52730);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchConversationMessageTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 14;
        }
    }

    class e extends com.tencent.mm.plugin.fts.a.a.i {
        public e(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            List arrayList;
            AppMethodBeat.i(52729);
            ayx("start");
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.a(this.wWO.query, false, c.this.wYV);
            com.tencent.mm.plugin.fts.a.a.h bE = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.wWT, true);
            HashMap hashMap = new HashMap();
            Cursor a2 = ((com.tencent.mm.plugin.fts.c.a) ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexStorage(3)).a(bE, this.wWO.talker, com.tencent.mm.plugin.fts.a.c.wUL, com.tencent.mm.plugin.fts.a.c.wUP);
            while (a2.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n nVar = new com.tencent.mm.plugin.fts.a.a.n();
                nVar.wVX = a2.getString(0);
                nVar.type = a2.getInt(1);
                nVar.wVW = a2.getInt(2);
                nVar.wWd = bE;
                if (!hashMap.containsKey(nVar.wVX)) {
                    hashMap.put(nVar.wVX, nVar);
                }
                if (hashMap.size() > 100) {
                    break;
                }
            }
            a2.close();
            ayx("findHitContact");
            Cursor a3 = c.this.wYQ.a(kVar.wWd, this.wWO.wWS, hashMap.keySet());
            HashMap hashMap2 = new HashMap();
            while (a3.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n g2 = new com.tencent.mm.plugin.fts.a.a.n().g(a3);
                g2.wWd = kVar.wWd;
                g2.userData = 1;
                if (hashMap2.containsKey(g2.talker)) {
                    arrayList = (List) hashMap2.get(g2.talker);
                } else {
                    arrayList = new ArrayList();
                }
                arrayList.add(g2);
                hashMap2.put(g2.talker, arrayList);
            }
            a3.close();
            kVar.wXb = new ArrayList();
            for (Map.Entry entry : hashMap2.entrySet()) {
                com.tencent.mm.plugin.fts.a.a.m mVar = (com.tencent.mm.plugin.fts.a.a.m) hashMap.get(entry.getKey());
                if (mVar != null) {
                    Collections.sort((List) entry.getValue(), this.wWO.wWY);
                    mVar.userData = entry.getValue();
                    mVar.timestamp = ((com.tencent.mm.plugin.fts.a.a.m) ((List) entry.getValue()).get(0)).timestamp;
                    kVar.wXb.add(mVar);
                }
            }
            Collections.sort(kVar.wXb, this.wWO.wWY);
            ayx("findHitMessage");
            AppMethodBeat.o(52729);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchConvTalkerMessageTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 29;
        }
    }

    class h extends com.tencent.mm.plugin.fts.a.a.i {
        public h(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            HashMap hashMap;
            AppMethodBeat.i(52732);
            ayx("start");
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.a(this.wWO.query, false, c.this.wYV);
            com.tencent.mm.plugin.fts.a.a.h bE = com.tencent.mm.plugin.fts.a.a.h.bE(this.wWO.wWT, true);
            HashMap hashMap2 = new HashMap();
            Cursor a2 = ((com.tencent.mm.plugin.fts.c.a) ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexStorage(3)).a(bE, null, com.tencent.mm.plugin.fts.a.c.wUL, com.tencent.mm.plugin.fts.a.c.wUP);
            while (a2.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n nVar = new com.tencent.mm.plugin.fts.a.a.n();
                nVar.wVX = a2.getString(0);
                nVar.type = a2.getInt(1);
                nVar.wVW = a2.getInt(2);
                nVar.wWd = bE;
                nVar.userData = 1;
                if (!hashMap2.containsKey(nVar.wVX)) {
                    hashMap2.put(nVar.wVX, nVar);
                }
                if (hashMap2.size() > 100) {
                    break;
                }
            }
            a2.close();
            ayx("findHitContact");
            Cursor a3 = c.this.wYQ.a(kVar.wWd, (String) null, hashMap2.keySet());
            HashMap hashMap3 = new HashMap();
            while (a3.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.n g2 = new com.tencent.mm.plugin.fts.a.a.n().g(a3);
                g2.wWd = kVar.wWd;
                g2.userData = 1;
                if (hashMap3.containsKey(g2.talker)) {
                    hashMap = (HashMap) hashMap3.get(g2.talker);
                } else {
                    hashMap = new HashMap();
                }
                if (hashMap.containsKey(g2.wVX)) {
                    com.tencent.mm.plugin.fts.a.a.m mVar = (com.tencent.mm.plugin.fts.a.a.m) hashMap.get(g2.wVX);
                    int intValue = ((Integer) mVar.userData).intValue() + 1;
                    if (mVar.timestamp < g2.timestamp) {
                        g2.userData = Integer.valueOf(intValue);
                        hashMap.put(g2.wVX, g2);
                    } else {
                        mVar.userData = Integer.valueOf(intValue);
                        hashMap.put(mVar.wVX, mVar);
                    }
                } else {
                    hashMap.put(g2.wVX, g2);
                }
                hashMap3.put(g2.talker, hashMap);
            }
            a3.close();
            kVar.wXb = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.m mVar2 : hashMap2.values()) {
                if (hashMap3.containsKey(mVar2.wVX)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(((HashMap) hashMap3.get(mVar2.wVX)).values());
                    Collections.sort(arrayList, this.wWO.wWY);
                    mVar2.userData = arrayList;
                    mVar2.timestamp = ((com.tencent.mm.plugin.fts.a.a.m) arrayList.get(0)).timestamp;
                    kVar.wXb.add(mVar2);
                }
            }
            Collections.sort(kVar.wXb, this.wWO.wWY);
            ayx("findHitMessage");
            AppMethodBeat.o(52732);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchTalkerMessageTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 28;
        }
    }

    class j extends com.tencent.mm.plugin.fts.a.a.i {
        public j(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            AppMethodBeat.i(187310);
            ayx("start");
            kVar.wXb = new LinkedList();
            Cursor d2 = c.this.wYQ.d(this.wWO.wWV, this.wWO.wWS);
            while (d2.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                mVar.type = d2.getInt(0);
                mVar.wVW = d2.getInt(1);
                mVar.wXe = d2.getLong(2);
                mVar.wVX = d2.getString(3);
                mVar.timestamp = d2.getLong(4);
                mVar.talker = d2.getString(5);
                kVar.wXb.add(mVar);
            }
            d2.close();
            AppMethodBeat.o(187310);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchTypeMessage";
        }
    }

    class g extends com.tencent.mm.plugin.fts.a.a.i {
        public g(com.tencent.mm.plugin.fts.a.a.j jVar) {
            super(jVar);
        }

        class a {
            long timestamp;
            int type;
            int wVW;
            String wVX;
            long wXe;

            private a() {
            }

            /* synthetic */ a(g gVar, byte b2) {
                this();
            }
        }

        @Override // com.tencent.mm.plugin.fts.a.a.i
        public final void a(k kVar) {
            AppMethodBeat.i(52731);
            ayx("start");
            kVar.wWd = com.tencent.mm.plugin.fts.a.a.h.a(this.wWO.query, false, c.this.wYV);
            com.tencent.mm.plugin.fts.c.c cVar = c.this.wYQ;
            Cursor rawQuery = cVar.wUt.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", cVar.dOt(), cVar.dOu(), cVar.dOt(), cVar.dOu(), cVar.dOu(), kVar.wWd.dOz()), null);
            ArrayList<a> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(3);
                if (hashSet.add(string)) {
                    a aVar = new a(this, (byte) 0);
                    aVar.type = rawQuery.getInt(0);
                    aVar.wVW = rawQuery.getInt(1);
                    aVar.wXe = rawQuery.getLong(2);
                    aVar.wVX = rawQuery.getString(3);
                    aVar.timestamp = rawQuery.getLong(4);
                    arrayList.add(aVar);
                    arrayList2.add(string);
                }
                if (arrayList.size() > this.wWO.wWW) {
                    break;
                }
            }
            rawQuery.close();
            kVar.wXb = new LinkedList();
            ayx("findUsername");
            if (arrayList2.size() > 0) {
                Cursor a2 = c.this.wYQ.a(kVar.wWd, arrayList2);
                HashMap hashMap = new HashMap();
                if (a2.moveToNext()) {
                    String[] split = a2.getString(0).split(" ");
                    for (int i2 = 0; i2 < split.length; i2 += 2) {
                        hashMap.put(split[i2], Integer.valueOf(Util.getInt(split[i2 + 1], 0)));
                    }
                }
                a2.close();
                for (a aVar2 : arrayList) {
                    com.tencent.mm.plugin.fts.a.a.m mVar = new com.tencent.mm.plugin.fts.a.a.m();
                    mVar.type = aVar2.type;
                    mVar.wVW = aVar2.wVW;
                    mVar.wXe = aVar2.wXe;
                    mVar.wVX = aVar2.wVX;
                    mVar.timestamp = aVar2.timestamp;
                    int intValue = hashMap.containsKey(mVar.wVX) ? ((Integer) hashMap.get(mVar.wVX)).intValue() : 1;
                    if (ab.JB(mVar.wVX)) {
                        intValue = 0;
                    }
                    mVar.userData = Integer.valueOf(intValue);
                    kVar.wXb.add(mVar);
                }
                ayx("findCount");
            }
            if (kVar.wWd.wWE.length > 1 && kVar.wXb.size() <= 3) {
                Cursor a3 = ((com.tencent.mm.plugin.fts.c.a) ((n) com.tencent.mm.kernel.g.ah(n.class)).getFTSIndexStorage(3)).a(com.tencent.mm.plugin.fts.a.a.h.bE(kVar.wWd.wWE[0], true), null, com.tencent.mm.plugin.fts.a.c.wUL, com.tencent.mm.plugin.fts.a.c.wUP);
                if (a3.moveToNext()) {
                    com.tencent.mm.plugin.fts.a.a.m mVar2 = new com.tencent.mm.plugin.fts.a.a.m();
                    mVar2.wVX = "create_talker_message​";
                    kVar.wXb.add(mVar2);
                }
                a3.close();
                ayx("findTalkerConversation");
            }
            AppMethodBeat.o(52731);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "SearchLimitGroupMessage";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 24;
        }
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private long lhY;
        private int mFailedCount;
        private int tbV;
        private int tbW;
        private HashSet<Pair<Long, Long>> wYY;
        private ArrayList<Long> wYZ;
        private long wZa;
        private int wZb;

        private a() {
            this.wYY = null;
            this.wYZ = null;
            this.lhY = MAlarmHandler.NEXT_FIRE_INTERVAL;
            this.wZa = -1;
            this.wZb = 0;
            this.tbV = 0;
            this.tbW = 0;
            this.mFailedCount = 0;
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52720);
            this.lhY = c.this.wYQ.wUt.V(-200, MAlarmHandler.NEXT_FIRE_INTERVAL);
            this.wZa = ((l) com.tencent.mm.kernel.g.af(l.class)).aTq().aEk("");
            if (this.lhY > this.wZa) {
                c.this.wYQ.W(-310, System.currentTimeMillis());
                c.this.wYQ.W(-311, (long) com.tencent.mm.protocal.d.KyO);
            }
            Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: %s last from createTime: %s", Long.valueOf(this.lhY), Long.valueOf(this.wZa));
            if (this.wYY == null) {
                this.wYY = new HashSet<>();
                this.wYZ = new ArrayList<>();
                Cursor a2 = c.this.wYQ.a(com.tencent.mm.plugin.fts.a.c.wUC, true, true, false, true, true);
                while (a2.moveToNext()) {
                    long j2 = a2.getLong(0);
                    long j3 = a2.getLong(1);
                    long j4 = a2.getLong(2);
                    if (a2.getInt(3) == -1) {
                        this.wYZ.add(Long.valueOf(j2));
                    } else if (j4 <= this.lhY) {
                        this.wYY.add(new Pair<>(Long.valueOf(j3), Long.valueOf(j4)));
                    }
                }
                a2.close();
            }
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.o(52720);
                throw interruptedException;
            }
            int i2 = Integer.MAX_VALUE;
            String[] strArr = new String[3];
            ArrayList<d> arrayList = new ArrayList();
            while (i2 >= 50) {
                int i3 = 0;
                strArr[0] = Long.toString(this.lhY);
                strArr[1] = Long.toString(this.wZa);
                strArr[2] = Integer.toString(this.wZb);
                Cursor rawQuery = c.this.tbO.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime>? AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", strArr);
                long j5 = 0;
                while (true) {
                    i2 = i3;
                    if (!rawQuery.moveToNext()) {
                        break;
                    }
                    d dVar = new d(c.this, (byte) 0);
                    dVar.msgId = rawQuery.getLong(0);
                    dVar.talker = rawQuery.getString(1);
                    dVar.createTime = rawQuery.getLong(2);
                    dVar.content = rawQuery.getString(3);
                    dVar.msgType = rawQuery.getInt(4);
                    dVar.wZf = rawQuery.getInt(5);
                    dVar.wZe = 41;
                    if (c.a(dVar)) {
                        dVar.dOT();
                        if (dVar.isAvailable()) {
                            arrayList.add(dVar);
                        }
                    }
                    j5 = dVar.createTime;
                    i3 = i2 + 1;
                }
                rawQuery.close();
                if (Thread.interrupted()) {
                    InterruptedException interruptedException2 = new InterruptedException();
                    AppMethodBeat.o(52720);
                    throw interruptedException2;
                }
                int size = arrayList.size();
                if (size == 0) {
                    Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d offset %s", Integer.valueOf(size), Integer.valueOf(this.wZb));
                } else {
                    Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d Id FROM %d to %d Time FROM %s to %s offset %s", Integer.valueOf(size), Long.valueOf(((d) arrayList.get(0)).msgId), Long.valueOf(((d) arrayList.get(size - 1)).msgId), com.tencent.mm.pluginsdk.i.f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, ((d) arrayList.get(0)).createTime / 1000), com.tencent.mm.pluginsdk.i.f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, ((d) arrayList.get(size - 1)).createTime / 1000), Integer.valueOf(this.wZb));
                }
                if (size > 0) {
                    c.this.wYQ.beginTransaction();
                    for (d dVar2 : arrayList) {
                        long j6 = dVar2.msgId;
                        long j7 = dVar2.createTime;
                        if (j7 == this.lhY) {
                            this.wZb++;
                        } else {
                            this.lhY = j7;
                            this.wZb = 0;
                        }
                        if (!this.wYY.remove(new Pair(Long.valueOf(j6), Long.valueOf(j7)))) {
                            try {
                                c.this.wYQ.a(dVar2.wZe, j6, dVar2.talker, j7, dVar2.wZg, dVar2.wZh);
                                this.tbV++;
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", e2, "Build message index failed with exception. \n%s", dVar2.wZg);
                                this.mFailedCount++;
                            }
                        }
                    }
                    c.this.wYQ.commit();
                    c.this.wYQ.W(-200, this.lhY);
                } else {
                    this.lhY = j5;
                    this.wZb = 0;
                }
                arrayList.clear();
                if (Thread.interrupted()) {
                    InterruptedException interruptedException3 = new InterruptedException();
                    AppMethodBeat.o(52720);
                    throw interruptedException3;
                }
            }
            int i4 = 50;
            Iterator<Pair<Long, Long>> it = this.wYY.iterator();
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    c.this.wYQ.commit();
                    InterruptedException interruptedException4 = new InterruptedException();
                    AppMethodBeat.o(52720);
                    throw interruptedException4;
                }
                if (i4 >= 50) {
                    c.this.wYQ.commit();
                    c.this.wYQ.beginTransaction();
                    i4 = 0;
                }
                Pair<Long, Long> next = it.next();
                c.this.wYQ.a(com.tencent.mm.plugin.fts.a.c.wUC, ((Long) next.first).longValue(), ((Long) next.second).longValue());
                i4++;
                this.tbW++;
                it.remove();
            }
            c.this.wYQ.commit();
            int i5 = 50;
            ListIterator<Long> listIterator = this.wYZ.listIterator(this.wYZ.size());
            while (listIterator.hasPrevious()) {
                if (Thread.interrupted()) {
                    c.this.wYQ.commit();
                    InterruptedException interruptedException5 = new InterruptedException();
                    AppMethodBeat.o(52720);
                    throw interruptedException5;
                }
                if (i5 >= 50) {
                    c.this.wYQ.commit();
                    c.this.wYQ.beginTransaction();
                    i5 = 0;
                }
                c.this.wYQ.GC(listIterator.previous().longValue());
                i5++;
                this.tbW++;
                listIterator.remove();
            }
            c.this.wYQ.W(-200, this.lhY - 1);
            c.this.wYQ.commit();
            c.this.wYR = false;
            AppMethodBeat.o(52720);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52721);
            String format = String.format("{new: %d removed: %d failed: %d}", Integer.valueOf(this.tbV), Integer.valueOf(this.tbW), Integer.valueOf(this.mFailedCount));
            AppMethodBeat.o(52721);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final int getId() {
            return 4;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "BuildMessageIndexTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.c$c  reason: collision with other inner class name */
    class C1377c extends com.tencent.mm.plugin.fts.a.a.a {
        private List<ca> wZc = new ArrayList();
        private StringBuffer wZd;

        public C1377c(List<ca> list) {
            AppMethodBeat.i(52724);
            this.wZc.addAll(list);
            this.wZd = new StringBuffer();
            AppMethodBeat.o(52724);
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52725);
            ArrayList<d> arrayList = new ArrayList();
            for (ca caVar : this.wZc) {
                d dVar = new d(c.this, (byte) 0);
                dVar.msgId = caVar.field_msgId;
                dVar.talker = caVar.field_talker;
                dVar.createTime = caVar.field_createTime;
                dVar.content = caVar.field_content;
                dVar.msgType = caVar.getType();
                dVar.wZf = caVar.field_isSend;
                if (c.a(dVar)) {
                    dVar.dOT();
                    if (dVar.isAvailable()) {
                        arrayList.add(dVar);
                    }
                }
            }
            this.wZd.append("{MsgId: ");
            for (d dVar2 : arrayList) {
                this.wZd.append(dVar2.msgId);
                this.wZd.append(",");
                this.wZd.append(dVar2.talker);
                this.wZd.append(",");
                this.wZd.append(dVar2.createTime);
                this.wZd.append(" ");
            }
            this.wZd.append("count: ");
            this.wZd.append(arrayList.size());
            this.wZd.append("}");
            if (arrayList.size() > 0) {
                c.this.wYQ.beginTransaction();
                for (d dVar3 : arrayList) {
                    c.this.wYQ.a(dVar3.wZe, dVar3.msgId, dVar3.talker, dVar3.createTime, dVar3.wZg, dVar3.wZh);
                }
                c.this.wYQ.commit();
            }
            AppMethodBeat.o(52725);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "InsertMessageTask";
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52726);
            String stringBuffer = this.wZd.toString();
            AppMethodBeat.o(52726);
            return stringBuffer;
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private long gof;

        public b(long j2) {
            this.gof = j2;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final boolean execute() {
            AppMethodBeat.i(52722);
            c.this.wYQ.c(com.tencent.mm.plugin.fts.a.c.wUC, this.gof);
            AppMethodBeat.o(52722);
            return true;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String bCQ() {
            AppMethodBeat.i(52723);
            String format = String.format("{MsgId: %d}", Long.valueOf(this.gof));
            AppMethodBeat.o(52723);
            return format;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.a
        public final String getName() {
            return "DeleteMessageTask";
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
    public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i iVar, i.c cVar) {
        boolean z;
        AppMethodBeat.i(52739);
        if (cVar.zqn.equals("insert")) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < cVar.hIs.size(); i2++) {
                ca caVar = cVar.hIs.get(i2);
                if (caVar == null || Util.isNullOrNil(caVar.field_talker) || Util.isNullOrNil(caVar.field_content)) {
                    z = false;
                } else if (caVar.field_talker.contains("@bottle")) {
                    z = false;
                } else if (as.bjw(caVar.field_talker)) {
                    z = false;
                } else if (caVar.getType() == 1 || caVar.dOQ() || caVar.dOS()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    arrayList.add(caVar);
                }
            }
            if (arrayList.size() > 0) {
                this.hgI.a(65576, new C1377c(arrayList));
            }
        }
        AppMethodBeat.o(52739);
    }

    /* access modifiers changed from: package-private */
    public class d {
        String content;
        long createTime;
        long msgId;
        int msgType;
        String talker;
        int wZe;
        int wZf;
        String wZg;
        String wZh;

        private d() {
        }

        /* synthetic */ d(c cVar, byte b2) {
            this();
        }

        public final boolean dOQ() {
            return (this.msgType & 65535) == 49;
        }

        public final boolean dOR() {
            return this.msgType == 1;
        }

        public final boolean dOS() {
            return this.msgType == 48;
        }

        public final void dOT() {
            String str;
            AppMethodBeat.i(52727);
            if (dOR()) {
                this.wZe = 41;
                if (!ab.Eq(this.talker) || this.wZf != 0) {
                    this.wZg = this.content;
                } else {
                    this.wZg = bp.Kt(this.content);
                }
            } else if (dOQ()) {
                k.b HD = k.b.HD(this.content);
                if (HD != null) {
                    switch (HD.type) {
                        case 1:
                        case 53:
                        case com.tencent.mm.plugin.appbrand.jsapi.pay.n.CTRL_INDEX:
                            this.wZg = Util.nullAs(HD.getTitle(), "");
                            this.wZe = 52;
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 8:
                        case 10:
                        case 13:
                        case 15:
                        case 16:
                        case 20:
                        case 25:
                            this.wZg = Util.nullAs(HD.getTitle(), "");
                            this.wZe = 43;
                            break;
                        case 6:
                            this.wZg = Util.nullAs(HD.getTitle(), "");
                            this.wZe = 42;
                            break;
                        case 19:
                            this.wZg = Util.nullAs(HD.getDescription(), "");
                            if (this.wZg != null) {
                                this.wZg = this.wZg.replace(":", RecoveryFileLog.SPLITTER);
                            }
                            this.wZe = 44;
                            break;
                        case 24:
                            this.wZg = Util.nullAs(HD.getDescription(), "");
                            if (this.wZg != null) {
                                this.wZg = this.wZg.replace(":", RecoveryFileLog.SPLITTER);
                            }
                            this.wZe = 49;
                            break;
                        case 33:
                            this.wZg = Util.nullAs(HD.getTitle(), "");
                            this.wZe = 48;
                            break;
                        case 51:
                            this.wZg = Util.nullAs(((com.tencent.mm.plugin.i.a.f) HD.as(com.tencent.mm.plugin.i.a.f.class)).jlg.nickname, "");
                            this.wZe = 53;
                            break;
                        case 2000:
                            this.wZg = Util.nullAs(HD.title, "") + RecoveryFileLog.SPLITTER + Util.nullAs(HD.description, "");
                            this.wZe = 45;
                            break;
                        case 2001:
                            if (!"1001".equals(HD.iyq)) {
                                if ("1002".equals(HD.iyq)) {
                                    this.wZe = 46;
                                    if (this.wZf != 1) {
                                        this.wZg = Util.nullAs(HD.iyo, "") + RecoveryFileLog.SPLITTER + Util.nullAs(HD.iyk, "");
                                        break;
                                    } else {
                                        this.wZg = Util.nullAs(HD.iyo, "") + RecoveryFileLog.SPLITTER + Util.nullAs(HD.iyl, "");
                                        break;
                                    }
                                }
                            } else {
                                this.wZe = 47;
                                if (this.wZf != 1) {
                                    this.wZg = Util.nullAs(HD.iyo, "") + RecoveryFileLog.SPLITTER + Util.nullAs(HD.iyk, "");
                                    break;
                                } else {
                                    this.wZg = Util.nullAs(HD.iyo, "") + RecoveryFileLog.SPLITTER + Util.nullAs(HD.iyl, "");
                                    break;
                                }
                            }
                            break;
                    }
                }
            } else if (dOS()) {
                this.wZe = 50;
                if (ab.Eq(this.talker)) {
                    str = bp.Kt(this.content);
                } else {
                    str = this.content;
                }
                ca.b aEL = ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aEL(str);
                if (aEL.gEa()) {
                    this.wZg = aEL.kHV + RecoveryFileLog.SPLITTER + aEL.label;
                } else {
                    this.wZg = aEL.label;
                }
            }
            if (!Util.isNullOrNil(this.wZg)) {
                this.wZg = com.tencent.mm.plugin.fts.a.d.ayp(this.wZg);
            }
            if (as.HF(this.talker)) {
                this.wZh = this.talker;
                this.talker = "appbrandcustomerservicemsg";
                AppMethodBeat.o(52727);
            } else if (this.wZf == 1) {
                this.wZh = z.aTY();
                AppMethodBeat.o(52727);
            } else if (ab.Eq(this.talker)) {
                this.wZh = Util.nullAs(bp.Ks(this.content), this.talker);
                AppMethodBeat.o(52727);
            } else {
                this.wZh = this.talker;
                AppMethodBeat.o(52727);
            }
        }

        public final boolean isAvailable() {
            AppMethodBeat.i(52728);
            if (!Util.isNullOrNil(this.wZg)) {
                AppMethodBeat.o(52728);
                return true;
            }
            AppMethodBeat.o(52728);
            return false;
        }
    }

    public static List<String> ayE(String str) {
        AppMethodBeat.i(52740);
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        ArrayList arrayList = new ArrayList();
        String icuTokenizer = FTSJNIUtils.icuTokenizer(str);
        String[] split = icuTokenizer.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < split.length; i2 += 3) {
            try {
                int intValue = Integer.valueOf(split[i2]).intValue();
                int intValue2 = Integer.valueOf(split[i2 + 1]).intValue();
                int i3 = intValue2 - intValue;
                int intValue3 = Integer.valueOf(split[i2 + 2]).intValue();
                String substring = str.substring(intValue, intValue2);
                if (intValue3 < 400 || intValue3 >= 500) {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(stringBuffer.toString());
                        stringBuffer = new StringBuffer();
                    }
                    if (!substring.equals("*") && !substring.equals(" ")) {
                        arrayList.add(substring);
                    }
                } else {
                    if (i3 == 1) {
                        stringBuffer.append(substring);
                    } else {
                        if (stringBuffer.length() > 0) {
                            arrayList.add(stringBuffer.toString());
                            stringBuffer = new StringBuffer();
                        }
                        arrayList.add(substring);
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(stringBuffer.toString());
        }
        Log.i("MicroMsg.FTS.FTS5SearchMessageLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", arrayList, icuTokenizer);
        AppMethodBeat.o(52740);
        return arrayList;
    }

    static /* synthetic */ boolean a(d dVar) {
        AppMethodBeat.i(52741);
        if (Util.isNullOrNil(dVar.talker) || Util.isNullOrNil(dVar.content)) {
            AppMethodBeat.o(52741);
            return false;
        } else if (dVar.talker.endsWith("@bottle")) {
            AppMethodBeat.o(52741);
            return false;
        } else if (as.bjw(dVar.talker)) {
            AppMethodBeat.o(52741);
            return false;
        } else if (dVar.dOR() || dVar.dOQ() || dVar.dOS()) {
            AppMethodBeat.o(52741);
            return true;
        } else {
            AppMethodBeat.o(52741);
            return false;
        }
    }
}
