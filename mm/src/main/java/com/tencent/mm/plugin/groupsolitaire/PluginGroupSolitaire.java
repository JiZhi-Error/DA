package com.tencent.mm.plugin.groupsolitaire;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.groupsolitaire.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class PluginGroupSolitaire extends f implements a, c, a {
    private static HashMap<Integer, h.b> baseDBFactories;
    private IListener<ns> yeU = new IListener<ns>() {
        /* class com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire.AnonymousClass2 */

        {
            AppMethodBeat.i(161733);
            this.__eventId = ns.class.getName().hashCode();
            AppMethodBeat.o(161733);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ns nsVar) {
            com.tencent.mm.plugin.groupsolitaire.c.a r;
            AppMethodBeat.i(110297);
            ns nsVar2 = nsVar;
            if (nsVar2 != null && !Util.isNullOrNil(nsVar2.dTP.username) && !Util.isNullOrNil(nsVar2.dTP.key)) {
                Log.i("MicroMsg.groupsolitaire.PluginGroupSolitaire", "NotifyGroupSolitatireEvent %s %s %s %s %s", Integer.valueOf(nsVar2.dTP.type), nsVar2.dTP.username, nsVar2.dTP.key, Long.valueOf(nsVar2.dTQ.dTS), Long.valueOf(nsVar2.dTQ.msgId));
                if (nsVar2.dTP.type == 0 && nsVar2.dTQ.msgId != 0) {
                    com.tencent.mm.plugin.groupsolitaire.c.a r2 = PluginGroupSolitaire.this.getGroupSolitatireStorage().r(nsVar2.dTP.username, nsVar2.dTP.key, true);
                    if (r2 != null && r2.field_firstMsgId == 0) {
                        r2.field_firstMsgId = nsVar2.dTQ.msgId;
                        Log.i("MicroMsg.groupsolitaire.PluginGroupSolitaire", "NotifyGroupSolitatireEvent username:%s key:%s msgId:%s ret:%s", nsVar2.dTP.username, nsVar2.dTP.key, Long.valueOf(nsVar2.dTQ.msgId), Boolean.valueOf(PluginGroupSolitaire.this.getGroupSolitatireStorage().a(r2, true)));
                    }
                } else if (nsVar2.dTP.type == 1 && nsVar2.dTQ.dTS != 0 && (r = PluginGroupSolitaire.this.getGroupSolitatireStorage().r(nsVar2.dTP.username, nsVar2.dTP.key, true)) != null && r.field_msgSvrId == 0) {
                    r.field_msgSvrId = nsVar2.dTQ.dTS;
                    Log.i("MicroMsg.groupsolitaire.PluginGroupSolitaire", "NotifyGroupSolitatireEvent username:%s key:%s msgSvrId:%s ret:%s", nsVar2.dTP.username, nsVar2.dTP.key, Long.valueOf(nsVar2.dTQ.dTS), Boolean.valueOf(PluginGroupSolitaire.this.getGroupSolitatireStorage().a(r, true)));
                }
            }
            AppMethodBeat.o(110297);
            return true;
        }
    };
    private com.tencent.mm.plugin.groupsolitaire.b.c yeV = null;
    private com.tencent.mm.plugin.groupsolitaire.c.c yeW = null;
    private d yeX = null;

    public PluginGroupSolitaire() {
        AppMethodBeat.i(110298);
        AppMethodBeat.o(110298);
    }

    static {
        AppMethodBeat.i(110311);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("GROUPSOLITAIRE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.groupsolitaire.c.c.SQL_CREATE;
            }
        });
        AppMethodBeat.o(110311);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(110299);
        this.yeU.alive();
        AppMethodBeat.o(110299);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(110300);
        this.yeU.dead();
        AppMethodBeat.o(110300);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(110301);
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.b(j.class, new com.tencent.mm.plugin.groupsolitaire.a.a());
        }
        AppMethodBeat.o(110301);
    }

    public static boolean isSupportGroupSolitaireAnalyze() {
        int i2;
        AppMethodBeat.i(110302);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_android_solitaire_analyze_switch, i2) == 1) {
            AppMethodBeat.o(110302);
            return true;
        }
        AppMethodBeat.o(110302);
        return false;
    }

    public static boolean isSupportGroupSolitaireShow() {
        int i2;
        AppMethodBeat.i(110303);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_android_solitaire_entry_switch, i2) == 1) {
            AppMethodBeat.o(110303);
            return true;
        }
        AppMethodBeat.o(110303);
        return false;
    }

    public com.tencent.mm.plugin.groupsolitaire.b.c getGroupSolitatireManager() {
        AppMethodBeat.i(110304);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.yeV == null) {
            this.yeV = new com.tencent.mm.plugin.groupsolitaire.b.c();
        }
        com.tencent.mm.plugin.groupsolitaire.b.c cVar = this.yeV;
        AppMethodBeat.o(110304);
        return cVar;
    }

    public com.tencent.mm.plugin.groupsolitaire.c.c getGroupSolitatireStorage() {
        AppMethodBeat.i(110305);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.yeW == null) {
            com.tencent.mm.kernel.g.aAi();
            this.yeW = new com.tencent.mm.plugin.groupsolitaire.c.c(com.tencent.mm.kernel.g.aAh().hqK);
        }
        com.tencent.mm.plugin.groupsolitaire.c.c cVar = this.yeW;
        AppMethodBeat.o(110305);
        return cVar;
    }

    public d getGroupSolitatireReportManager() {
        AppMethodBeat.i(110306);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.yeX == null) {
            this.yeX = new d();
        }
        d dVar = this.yeX;
        AppMethodBeat.o(110306);
        return dVar;
    }

    public void sendGroupSolitatire(String str, String str2, com.tencent.mm.plugin.groupsolitaire.c.a aVar, com.tencent.mm.plugin.groupsolitaire.c.a aVar2, com.tencent.mm.plugin.groupsolitaire.c.a aVar3, boolean z) {
        AppMethodBeat.i(194418);
        if (aVar2 == null) {
            AppMethodBeat.o(194418);
            return;
        }
        k.b bVar = new k.b();
        bVar.title = str;
        bVar.type = 53;
        bVar.izx = new Pair<>(aVar2.field_key, com.tencent.mm.plugin.groupsolitaire.b.b.b(str, aVar2));
        Pair<Integer, Long> a2 = w.a.aSz().a(bVar, "", "", str2, "", null);
        if (z && a2 != null) {
            ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().a(((Long) a2.second).longValue(), aVar2, aVar3, true, 1);
        } else if (!z) {
            ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().a(aVar2, aVar3, 1);
        }
        if (a2 != null) {
            com.tencent.mm.plugin.groupsolitaire.b.b.a(((Long) a2.second).longValue(), z.aTY(), aVar);
        }
        Log.i("MicroMsg.groupsolitaire.PluginGroupSolitaire", "sendGroupSolitatire() content ret:%s", a2);
        AppMethodBeat.o(194418);
    }

    public Pair<Long, String> sendGroupSolitatire(String str, com.tencent.mm.plugin.groupsolitaire.c.a aVar, com.tencent.mm.plugin.groupsolitaire.c.a aVar2, boolean z, boolean z2) {
        long j2;
        AppMethodBeat.i(174558);
        if (aVar == null) {
            Pair<Long, String> pair = new Pair<>(-1L, "");
            AppMethodBeat.o(174558);
            return pair;
        }
        String g2 = com.tencent.mm.plugin.groupsolitaire.b.b.g(aVar);
        k.b bVar = new k.b();
        bVar.title = g2;
        bVar.type = 53;
        bVar.izx = new Pair<>(aVar.field_key, com.tencent.mm.plugin.groupsolitaire.b.b.a(g2, aVar, z2));
        Pair<Integer, Long> a2 = w.a.aSz().a(bVar, "", "", str, "", null);
        if (z && a2 != null) {
            ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().a(((Long) a2.second).longValue(), aVar, aVar2, false, 2);
        } else if (!z) {
            ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().a(aVar, aVar2, 2);
        }
        if (a2 != null) {
            com.tencent.mm.plugin.groupsolitaire.b.b.a(((Long) a2.second).longValue(), z.aTY(), aVar);
        }
        Log.i("MicroMsg.groupsolitaire.PluginGroupSolitaire", "sendGroupSolitatire() ret:%s", a2);
        if (a2 != null) {
            j2 = ((Long) a2.second).longValue();
        } else {
            j2 = -1;
        }
        Pair<Long, String> pair2 = new Pair<>(Long.valueOf(j2), g2);
        AppMethodBeat.o(174558);
        return pair2;
    }

    public Pair<Long, String> sendGroupSolitatireInCall(String str, com.tencent.mm.plugin.groupsolitaire.c.a aVar, com.tencent.mm.plugin.groupsolitaire.c.a aVar2, com.tencent.mm.plugin.groupsolitaire.c.a aVar3, boolean z, boolean z2) {
        long j2;
        AppMethodBeat.i(174559);
        if (aVar == null) {
            Pair<Long, String> pair = new Pair<>(-1L, "");
            AppMethodBeat.o(174559);
            return pair;
        }
        String g2 = com.tencent.mm.plugin.groupsolitaire.b.b.g(aVar2);
        k.b bVar = new k.b();
        bVar.title = g2;
        bVar.type = 53;
        bVar.izx = new Pair<>(aVar.field_key, com.tencent.mm.plugin.groupsolitaire.b.b.a(g2, aVar, z2));
        Pair<Integer, Long> a2 = w.a.aSz().a(bVar, "", "", str, "", null);
        if (z && a2 != null) {
            ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().a(((Long) a2.second).longValue(), aVar, aVar3, false, 2);
        } else if (!z) {
            ((PluginGroupSolitaire) com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager().a(aVar, aVar3, 2);
        }
        if (a2 != null) {
            com.tencent.mm.plugin.groupsolitaire.b.b.a(((Long) a2.second).longValue(), z.aTY(), aVar);
        }
        Log.i("MicroMsg.groupsolitaire.PluginGroupSolitaire", "sendGroupSolitatire() ret:%s", a2);
        if (a2 != null) {
            j2 = ((Long) a2.second).longValue();
        } else {
            j2 = -1;
        }
        Pair<Long, String> pair2 = new Pair<>(Long.valueOf(j2), g2);
        AppMethodBeat.o(174559);
        return pair2;
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return baseDBFactories;
    }

    public static MultiProcessMMKV getKV() {
        AppMethodBeat.i(110310);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("group_solitatire");
        AppMethodBeat.o(110310);
        return mmkv;
    }
}
