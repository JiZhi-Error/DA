package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Base64;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.iv;
import com.tencent.mm.g.b.a.iw;
import com.tencent.mm.g.b.a.ix;
import com.tencent.mm.g.b.a.iy;
import com.tencent.mm.g.b.a.iz;
import com.tencent.mm.g.b.a.jb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    ConcurrentHashMap<Long, Pair<String, String>> yfq = new ConcurrentHashMap<>();
    ConcurrentHashMap<Long, Boolean> yfr = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Long, a> yfs = new ConcurrentHashMap<>();
    ConcurrentHashMap<Long, b> yft = new ConcurrentHashMap<>();

    public d() {
        AppMethodBeat.i(110384);
        AppMethodBeat.o(110384);
    }

    public final void a(long j2, com.tencent.mm.plugin.groupsolitaire.c.a aVar, com.tencent.mm.plugin.groupsolitaire.c.a aVar2, boolean z, int i2) {
        AppMethodBeat.i(110385);
        if (j2 < 0 || aVar == null) {
            AppMethodBeat.o(110385);
            return;
        }
        this.yfq.put(Long.valueOf(j2), new Pair<>(aVar.field_username, aVar.field_key));
        this.yfr.put(Long.valueOf(j2), Boolean.valueOf(z));
        this.yft.put(Long.valueOf(j2), new b(aVar, aVar2, i2));
        AppMethodBeat.o(110385);
    }

    public final void Y(long j2, long j3) {
        AppMethodBeat.i(194434);
        Pair<String, String> remove = this.yfq.remove(Long.valueOf(j2));
        Boolean remove2 = this.yfr.remove(Long.valueOf(j2));
        if (remove != null) {
            this.yfq.put(Long.valueOf(j3), remove);
            this.yfr.put(Long.valueOf(j3), remove2);
        }
        AppMethodBeat.o(194434);
    }

    public static void b(com.tencent.mm.plugin.groupsolitaire.c.a aVar, String str) {
        AppMethodBeat.i(161735);
        if (aVar == null) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() groupSolitatire == null");
            AppMethodBeat.o(161735);
            return;
        }
        ca Hb = ((l) g.af(l.class)).eiy().Hb(aVar.field_firstMsgId);
        if (aVar.field_msgSvrId == 0) {
            aVar.field_msgSvrId = Hb.field_msgSvrId;
            ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().a(aVar, true);
        }
        a(aVar, true, str, aVar.field_msgSvrId);
        AppMethodBeat.o(161735);
    }

    static void a(com.tencent.mm.plugin.groupsolitaire.c.a aVar, boolean z, String str, long j2) {
        AppMethodBeat.i(110386);
        if (j2 == 0) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() MsgSvrId==0 key:%s", aVar.field_key);
            AppMethodBeat.o(110386);
            return;
        }
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "reportSolitaireActive() MsgSvrId==%s key:%s", Long.valueOf(j2), aVar.field_key);
        iw iwVar = new iw();
        iwVar.ww(aVar.field_key);
        iwVar.wt(aVar.field_username);
        iwVar.wu(aVar.field_creator);
        if (z) {
            iwVar.wv(str);
        } else {
            iwVar.wv(aVar.field_creator);
        }
        iwVar.eQm = j2;
        if (aVar.yfC == 1) {
            iwVar.eQn = (long) aVar.header.length();
        }
        iwVar.eQo = (long) aVar.xxN.length();
        iwVar.eQp = (long) aVar.yfB.length();
        if (z) {
            iwVar.eQq = 1;
        } else {
            iwVar.eQq = 2;
        }
        iwVar.bfK();
        AppMethodBeat.o(110386);
    }

    public final void a(final com.tencent.mm.plugin.groupsolitaire.c.a aVar, final com.tencent.mm.plugin.groupsolitaire.c.a aVar2, final int i2) {
        AppMethodBeat.i(110387);
        if (aVar == null) {
            AppMethodBeat.o(110387);
            return;
        }
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.groupsolitaire.b.d.AnonymousClass2 */

            public final void run() {
                int i2;
                int size;
                int i3;
                AppMethodBeat.i(110382);
                String str = "";
                if (aVar2 == null) {
                    i2 = aVar.yfE.size();
                    str = aVar.separator;
                    size = 0;
                } else {
                    HashSet hashSet = new HashSet();
                    HashMap hashMap = new HashMap();
                    for (int i4 = 1; i4 <= aVar2.yfE.size(); i4++) {
                        com.tencent.mm.plugin.groupsolitaire.c.b bVar = aVar2.yfE.get(Integer.valueOf(i4));
                        if (bVar != null && Util.isEqual(bVar.username, z.aTY())) {
                            hashSet.add(bVar);
                            hashMap.put(bVar.content, bVar);
                        }
                    }
                    int i5 = 1;
                    int i6 = 0;
                    i2 = 0;
                    while (i5 <= aVar.yfE.size()) {
                        com.tencent.mm.plugin.groupsolitaire.c.b bVar2 = aVar.yfE.get(Integer.valueOf(i5));
                        if (Util.isEqual(bVar2.username, z.aTY())) {
                            if (hashSet.contains(bVar2)) {
                                i3 = i6 + 1;
                            } else {
                                i2++;
                                if (Util.isNullOrNil(str)) {
                                    str = bVar2.separator;
                                    i3 = i6;
                                }
                            }
                            i5++;
                            i6 = i3;
                        }
                        i3 = i6;
                        i5++;
                        i6 = i3;
                    }
                    size = hashSet.size() - i6;
                }
                if (Util.isNullOrNil(str)) {
                    str = aVar.separator;
                }
                iv ivVar = new iv();
                ivVar.eQj = ivVar.x("Identifier", aVar.field_key, true);
                ivVar.emL = ivVar.x("ChatName", aVar.field_username, true);
                ivVar.eQe = ivVar.x("LaunchUserName", aVar.field_creator, true);
                ivVar.eQf = aVar.field_msgSvrId;
                ivVar.eQg = (long) size;
                ivVar.eQh = (long) i2;
                ivVar.eQi = (long) i2;
                ivVar.eQk = ivVar.x("Punctuation", Base64.encodeToString(str.getBytes(), 0), true);
                Log.d("MicroMsg.groupsolitaire.GroupSolitatireReportManager", "separator:%s base64:%s", str, Base64.encodeToString(str.getBytes(), 0));
                ivVar.bfK();
                AppMethodBeat.o(110382);
            }
        });
        AppMethodBeat.o(110387);
    }

    public static void x(List<com.tencent.mm.plugin.groupsolitaire.c.a> list, int i2) {
        AppMethodBeat.i(110388);
        if (list == null && list.size() == 0) {
            AppMethodBeat.o(110388);
            return;
        }
        for (com.tencent.mm.plugin.groupsolitaire.c.a aVar : list) {
            a(aVar, i2);
        }
        AppMethodBeat.o(110388);
    }

    public static void a(com.tencent.mm.plugin.groupsolitaire.c.a aVar, int i2) {
        AppMethodBeat.i(110389);
        if (aVar == null) {
            AppMethodBeat.o(110389);
            return;
        }
        iy iyVar = new iy();
        iyVar.wz(aVar.field_key);
        iyVar.wx(aVar.field_username);
        iyVar.wy(aVar.field_creator);
        iyVar.eQf = aVar.field_msgSvrId;
        iyVar.ekE = (long) i2;
        iyVar.bfK();
        AppMethodBeat.o(110389);
    }

    public static void a(com.tencent.mm.plugin.groupsolitaire.c.a aVar, int i2, int i3, boolean z) {
        AppMethodBeat.i(110390);
        iz izVar = new iz();
        izVar.wB(aVar.field_key);
        izVar.wA(aVar.field_username);
        izVar.eQf = aVar.field_msgSvrId;
        izVar.etp = (long) i2;
        izVar.ewL = (long) i3;
        if (z) {
            izVar.eQr = 2;
        } else {
            izVar.eQr = 1;
        }
        izVar.bfK();
        AppMethodBeat.o(110390);
    }

    public static void en(String str, int i2) {
        AppMethodBeat.i(110391);
        jb jbVar = new jb();
        jbVar.emL = jbVar.x("ChatName", str, true);
        jbVar.eQr = (long) i2;
        jbVar.bfK();
        AppMethodBeat.o(110391);
    }

    public static void a(com.tencent.mm.plugin.groupsolitaire.c.a aVar, int i2, int i3) {
        AppMethodBeat.i(110392);
        ix ixVar = new ix();
        ixVar.eQj = ixVar.x("Identifier", aVar.field_key, true);
        ixVar.emL = ixVar.x("ChatName", aVar.field_username, true);
        ixVar.eQf = aVar.field_msgSvrId;
        ixVar.esI = (long) i2;
        ixVar.eIW = (long) i3;
        ixVar.bfK();
        AppMethodBeat.o(110392);
    }

    public class a {
        public String gqV = "";
        public String key = "";
        public long yfx = 0;
        public long yfy = 0;

        public a() {
        }
    }

    class b {
        int scene;
        com.tencent.mm.plugin.groupsolitaire.c.a yfA;
        com.tencent.mm.plugin.groupsolitaire.c.a yfz;

        public b(com.tencent.mm.plugin.groupsolitaire.c.a aVar, com.tencent.mm.plugin.groupsolitaire.c.a aVar2, int i2) {
            this.yfz = aVar;
            this.yfA = aVar2;
            this.scene = i2;
        }
    }
}
