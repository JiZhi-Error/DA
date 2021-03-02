package com.tencent.mm.plugin.messenger.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.b.a.gv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a extends e {
    private static final Map<Long, C1473a> zqV = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.messenger.e.a$a  reason: collision with other inner class name */
    public static class C1473a {
        public String sessionId = "";
        public String zqW = "";
        public String zqX = "";
        public String zqY = "";
        public String zqZ = "";
    }

    static {
        AppMethodBeat.i(194507);
        AppMethodBeat.o(194507);
    }

    @Override // com.tencent.mm.plugin.messenger.d.e
    public final String eiU() {
        return "new_tmpl_type_succeed_contact";
    }

    @Override // com.tencent.mm.plugin.messenger.d.e
    public final void b(Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(194501);
        de deVar = aVar.heO;
        String a2 = z.a(deVar.KHl);
        ca aJ = ((l) g.af(l.class)).eiy().aJ(a2, deVar.Brn);
        String n = n(map, "new_link_succeed_contact");
        if (Util.isNullOrNil(n)) {
            Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onReceivedImp head is null.(%s %s)", a2, Long.valueOf(aJ.field_msgSvrId));
            AppMethodBeat.o(194501);
            return;
        }
        a(b(aJ.field_msgId, map, n), 1);
        AppMethodBeat.o(194501);
    }

    @Override // com.tencent.mm.plugin.messenger.d.e
    public final void c(String str, Map<String, String> map, Bundle bundle) {
        AppMethodBeat.i(194502);
        String n = n(map, "new_link_succeed_contact");
        if (Util.isNullOrNil(n)) {
            Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "onClickLinkImp head is null.");
            AppMethodBeat.o(194502);
            return;
        }
        long j2 = bundle.getLong("msg_id");
        C1473a aVar = zqV.get(Long.valueOf(j2));
        if (aVar == null) {
            aVar = b(j2, map, n);
        }
        if (Util.isEqual(str, "link_profile")) {
            a(aVar, 2);
            AppMethodBeat.o(194502);
            return;
        }
        if (Util.isEqual(str, "new_link_succeed_contact")) {
            a(aVar, 5);
        }
        AppMethodBeat.o(194502);
    }

    private static C1473a b(long j2, Map<String, String> map, String str) {
        AppMethodBeat.i(194503);
        String nullAs = Util.nullAs(map.get(str + ".origin_username"), "");
        String nullAs2 = Util.nullAs(map.get(str + ".heir_username"), "");
        String nullAs3 = Util.nullAs(map.get(str + ".succeed_ticket"), "");
        C1473a aVar = new C1473a();
        aVar.zqW = nullAs;
        aVar.zqX = nullAs2;
        as Kn = ((l) g.af(l.class)).aSN().Kn(nullAs);
        aVar.zqY = Kn.field_descWordingId;
        aVar.zqZ = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).bN(Kn.field_openImAppid, Kn.field_descWordingId);
        aVar.sessionId = nullAs3;
        zqV.put(Long.valueOf(j2), aVar);
        AppMethodBeat.o(194503);
        return aVar;
    }

    private static void a(C1473a aVar, int i2) {
        AppMethodBeat.i(194504);
        if (aVar == null) {
            Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(action:%s)", Integer.valueOf(i2));
            AppMethodBeat.o(194504);
            return;
        }
        gv gvVar = new gv();
        gvVar.uE(aVar.zqW);
        gvVar.uF(aVar.zqX);
        gvVar.uG(aVar.zqY);
        gvVar.uH(aVar.zqZ);
        gvVar.uI(aVar.sessionId);
        gvVar.ejA = (long) i2;
        gvVar.bfK();
        AppMethodBeat.o(194504);
    }

    public static void Q(long j2, int i2) {
        AppMethodBeat.i(194505);
        C1473a aVar = zqV.get(Long.valueOf(j2));
        if (aVar == null) {
            Log.e("MicroMsg.SysMsgTemp.HandlerNewSuccedContactWindowReceived", "openImDimissionSucceedReport info is null.(msgId:%s action:%s)", Long.valueOf(j2), Integer.valueOf(i2));
            AppMethodBeat.o(194505);
            return;
        }
        a(aVar, i2);
        AppMethodBeat.o(194505);
    }

    public static boolean Hh(long j2) {
        AppMethodBeat.i(194506);
        if (zqV.get(Long.valueOf(j2)) != null) {
            AppMethodBeat.o(194506);
            return true;
        }
        AppMethodBeat.o(194506);
        return false;
    }
}
