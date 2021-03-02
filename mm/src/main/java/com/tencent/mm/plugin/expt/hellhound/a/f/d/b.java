package com.tencent.mm.plugin.expt.hellhound.a.f.d;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.g.a;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public static void a(cyl cyl, String str, int i2, long j2) {
        AppMethodBeat.i(220566);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(220566);
        } else if (cyl == null || !a.arb(cyl.sessionId)) {
            b(cyl, str, i2, j2);
            AppMethodBeat.o(220566);
        } else {
            Log.i("HABBYGE-MALI.HellPageFlowManager", "addpageFlow scan-session, need filter !!");
            AppMethodBeat.o(220566);
        }
    }

    public static void b(cyl cyl, String str, int i2, long j2) {
        cbm cbm;
        AppMethodBeat.i(220567);
        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
        cbl cQH = a.cQH();
        if (cyl == null) {
            if ("LauncherUI".equals(aoE) || "FinderHomeUI".equals(aoE) || "FinderConversationUI".equals(aoE)) {
                Log.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI/FinderHomeUI");
                AppMethodBeat.o(220567);
                return;
            }
        } else if ("LauncherUI".equals(aoE)) {
            Log.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI");
            AppMethodBeat.o(220567);
            return;
        } else if ("FinderHomeUI".equals(aoE) || "FinderConversationUI".equals(aoE)) {
            Fragment cOk = k.cOk();
            if (cOk != null) {
                aoE = cOk.getClass().getSimpleName();
            } else {
                aoE = "FinderFollowTabFragment";
            }
            Log.i("HABBYGE-MALI.HellPageFlowManager", "maybe invalidate Page: FinderHomeUI in %s, %s", cyl.sessionId, aoE);
        }
        cbm peekLast = cQH.Mhn.peekLast();
        if (peekLast != null) {
            if (peekLast.dMl.equals(aoE)) {
                if (cyl != null && !cyl.sessionId.equals(peekLast.dRM)) {
                    String str2 = peekLast.dRM;
                    peekLast.dRM = cyl.sessionId;
                    cQH.Mhn.set(cQH.Mhn.size() - 1, peekLast);
                    a(cQH, str2, cyl.sessionId, false);
                    a.a(cQH);
                }
                if (peekLast.aHK <= 0 && i2 > 0) {
                    peekLast.aHK = i2;
                    a.a(cQH);
                }
                Log.i("HABBYGE-MALI.HellPageFlowManager", "repeated page, no need to add this page: %s, %d, %s, %d", peekLast.dMl, Integer.valueOf(peekLast.aHK), aoE, Integer.valueOf(i2));
                AppMethodBeat.o(220567);
                return;
            }
            if (cyl != null && !peekLast.dRM.equals(cyl.sessionId)) {
                a(cQH, peekLast.dRM, cyl.sessionId, true);
            }
            int size = cQH.Mhn.size();
            if (size > 2 && (cbm = cQH.Mhn.get(size - 2)) != null) {
                if ("MsgRetransmitUI".equals(cbm.dMl) && "SelectConversationUI".equals(peekLast.dMl) && "MsgRetransmitUI".equals(aoE)) {
                    AppMethodBeat.o(220567);
                    return;
                } else if ("SelectConversationUI".equals(cbm.dMl) && "MsgRetransmitUI".equals(peekLast.dMl) && "SelectConversationUI".equals(aoE)) {
                    AppMethodBeat.o(220567);
                    return;
                }
            }
        }
        cbm cbm2 = new cbm();
        cbm2.dMl = aoE;
        cbm2.aHK = i2;
        cbm2.startTime = j2;
        if (cyl == null) {
            Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, Unknown Page: %s, %d", aoE, Integer.valueOf(i2));
            cbm2.dRM = null;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.k.cQB();
        } else {
            cbm2.dRM = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.j(cyl);
            Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, session: %s, %d, %s", aoE, Integer.valueOf(i2), cbm2.dRM);
            com.tencent.mm.plugin.expt.hellhound.a.f.c.k.a(cbm2);
        }
        cQH.Mhn.addLast(cbm2);
        a.a(cQH);
        AppMethodBeat.o(220567);
    }

    public static void x(String str, int i2, long j2) {
        AppMethodBeat.i(220568);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(220568);
            return;
        }
        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
        cbm cbm = new cbm();
        cbm.dMl = aoE;
        cbm.aHK = i2;
        cbm.startTime = j2;
        cyl cQo = c.cQo();
        if (cQo == null) {
            Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), Unknown Page: %s", aoE);
            cbm.dRM = null;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.k.cQB();
        } else {
            cbm.dRM = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.j(cQo);
            Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), session: %s, %s", aoE, cbm.dRM);
            com.tencent.mm.plugin.expt.hellhound.a.f.c.k.a(cbm);
        }
        cbl cQH = a.cQH();
        cQH.Mhn.addLast(cbm);
        a.a(cQH);
        AppMethodBeat.o(220568);
    }

    private static void a(cbl cbl, String str, String str2, boolean z) {
        AppMethodBeat.i(177397);
        int size = cbl.Mhn.size();
        if (!z) {
            size--;
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            cbm cbm = cbl.Mhn.get(i2);
            if (cbm != null) {
                if (!cbm.dRM.equals(str)) {
                    break;
                }
                com.tencent.mm.vending.j.c<String, String> aqp = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqp(str);
                String str3 = aqp != null ? (String) aqp.get(1) : null;
                com.tencent.mm.vending.j.c<String, String> aqp2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqp(str2);
                String str4 = aqp2 != null ? (String) aqp2.get(1) : null;
                if (str3 != null && str3.equals(str4)) {
                    cbm.dRM = str2;
                }
            }
        }
        AppMethodBeat.o(177397);
    }

    public static void ap(String str, long j2) {
        AppMethodBeat.i(122176);
        cbl cQH = a.cQH();
        if (cQH.Mhn.isEmpty()) {
            Log.e("HABBYGE-MALI.HellPageFlowManager", "setEndTimeOfPageWhenEvent8, pageFlow.items == NULL");
            AppMethodBeat.o(122176);
            return;
        }
        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
        if (aoE == null || aoE.isEmpty()) {
            AppMethodBeat.o(122176);
            return;
        }
        cbm last = cQH.Mhn.getLast();
        if (last == null) {
            AppMethodBeat.o(122176);
            return;
        }
        long j3 = j2 - last.startTime;
        if (j3 <= 0) {
            j3 = 0;
        }
        last.duration = j3;
        a.a(cQH);
        AppMethodBeat.o(122176);
    }

    public static com.tencent.mm.vending.j.c<cbm, Integer> gw(String str, String str2) {
        String aoE;
        AppMethodBeat.i(220569);
        if (str == null || str2 == null || str2.isEmpty()) {
            AppMethodBeat.o(220569);
            return null;
        }
        String aoE2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str2);
        Log.i("HABBYGE-MALI.HellPageFlowManager", "getPageFlowItemOfCurSession: %s, %s", aoE2, str);
        cbl cQH = a.cQH();
        for (int size = cQH.Mhn.size() - 1; size >= 0; size--) {
            cbm cbm = cQH.Mhn.get(size);
            if (cbm.dRM.equals(str) && (aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(cbm.dMl)) != null && aoE.equals(aoE2)) {
                com.tencent.mm.vending.j.c<cbm, Integer> Q = com.tencent.mm.vending.j.a.Q(cbm, Integer.valueOf(size));
                AppMethodBeat.o(220569);
                return Q;
            }
        }
        AppMethodBeat.o(220569);
        return null;
    }

    public static List<cbm> aqQ(String str) {
        AppMethodBeat.i(122178);
        if (str == null) {
            AppMethodBeat.o(122178);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cbl cQH = a.cQH();
        int size = cQH.Mhn.size();
        for (int i2 = 0; i2 < size; i2++) {
            cbm cbm = cQH.Mhn.get(i2);
            if (cbm.dRM.equals(str)) {
                arrayList.add(cbm);
            }
        }
        AppMethodBeat.o(122178);
        return arrayList;
    }

    public static void a(cbm cbm, int i2) {
        AppMethodBeat.i(220570);
        if (cbm == null) {
            AppMethodBeat.o(220570);
            return;
        }
        cbl cQH = a.cQH();
        try {
            cQH.Mhn.set(i2, cbm);
            a.a(cQH);
            AppMethodBeat.o(220570);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellPageFlowManager", e2, "updatePageFlow crash: %s", e2.getMessage());
            AppMethodBeat.o(220570);
        }
    }

    public static Pair<cbm, Integer> cQJ() {
        AppMethodBeat.i(220571);
        cbl cQH = a.cQH();
        if (cQH.Mhn.isEmpty()) {
            AppMethodBeat.o(220571);
            return null;
        }
        Pair<cbm, Integer> create = Pair.create(cQH.Mhn.getLast(), Integer.valueOf(cQH.Mhn.size() - 1));
        AppMethodBeat.o(220571);
        return create;
    }
}
