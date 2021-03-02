package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.dt;
import com.tencent.mm.g.b.a.hc;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.z;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import kotlin.g.b.p;
import kotlin.n.n;
import org.json.JSONObject;

public final class j {
    public static final j vft = new j();

    static {
        AppMethodBeat.i(250627);
        AppMethodBeat.o(250627);
    }

    private j() {
    }

    public static /* synthetic */ void a(j jVar, String str, k kVar, bdo bdo, int i2) {
        AppMethodBeat.i(250623);
        a(str, kVar, bdo, i2, "", 0);
        AppMethodBeat.o(250623);
    }

    public static void a(String str, k kVar, bdo bdo, int i2, String str2, int i3) {
        AppMethodBeat.i(250622);
        p.h(str, "currUI");
        p.h(kVar, "ctrInfo");
        p.h(bdo, "showInfo");
        p.h(str2, "contextId");
        bbn bbn = new bbn();
        String cMD = ((c) g.af(c.class)).cMD();
        if (cMD == null) {
            cMD = "";
        }
        bbn.sessionId = cMD;
        bbn.sGQ = str2;
        bbn.sGE = "";
        a(str, kVar, bdo, i2, bbn, i3, 0, 64);
        AppMethodBeat.o(250622);
    }

    public static /* synthetic */ void a(String str, k kVar, bdo bdo, int i2, bbn bbn, int i3, int i4, int i5) {
        int i6 = 0;
        AppMethodBeat.i(250625);
        bbn bbn2 = (i5 & 16) != 0 ? null : bbn;
        int i7 = (i5 & 32) != 0 ? 0 : i3;
        if ((i5 & 64) == 0) {
            i6 = i4;
        }
        a(str, kVar, bdo, i2, bbn2, i7, i6);
        AppMethodBeat.o(250625);
    }

    public static void a(String str, k kVar, bdo bdo, int i2, bbn bbn, int i3, int i4) {
        AppMethodBeat.i(250624);
        p.h(str, "currUI");
        p.h(kVar, "ctrInfo");
        p.h(bdo, "showInfo");
        dt dtVar = new dt();
        dtVar.kA((long) kVar.field_ctrInfo.type);
        dtVar.pI(kVar.field_tipsId);
        dtVar.pJ(bdo.path);
        dtVar.pK(bdo.Bvg);
        dtVar.kB((long) bdo.xGz);
        dtVar.kC((long) bdo.count);
        dtVar.pL(bdo.title);
        JSONObject bN = com.tencent.mm.ac.g.bN(kVar.dbx());
        bN.put("object_id", d.zs(kVar.dbx().object_id));
        String jSONObject = bN.toString();
        p.g(jSONObject, "extInfo.toString()");
        dtVar.pM(n.j(jSONObject, ",", ";", false));
        dtVar.kD((long) i2);
        dtVar.pN(str);
        dtVar.pO(bbn != null ? bbn.sGQ : null);
        dtVar.pP(bbn != null ? bbn.sGE : null);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        dtVar.kE(com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1 ? 1 : 0);
        a ah = g.ah(aj.class);
        p.g(ah, "MMKernel.plugin(IPluginFinder::class.java)");
        z redDotManager = ((aj) ah).getRedDotManager();
        p.g(redDotManager, "MMKernel.plugin(IPluginF…class.java).redDotManager");
        dtVar.kF(redDotManager.daH() ? 1 : 0);
        dtVar.kG(i3 == 0 ? 1 : 0);
        dtVar.afg();
        dtVar.pQ(bbn != null ? bbn.sessionId : null);
        dtVar.kH(kVar.field_time);
        dtVar.pR(bdo.qGB);
        dtVar.kI((long) i4);
        y yVar = y.vXH;
        dtVar.kJ(y.dCB() ? 1 : 2);
        dtVar.kK(cl.aWA());
        dtVar.bfK();
        k kVar2 = k.vfA;
        k.a(dtVar);
        AppMethodBeat.o(250624);
    }

    public static /* synthetic */ void a(k kVar, bdo bdo, int i2, int i3, String str, String str2, int i4) {
        AppMethodBeat.i(250626);
        if ((i4 & 8) != 0) {
            i3 = 2;
        }
        if ((i4 & 16) != 0) {
            str = "";
        }
        if ((i4 & 32) != 0) {
            str2 = "";
        }
        p.h(kVar, "ctrInfo");
        p.h(bdo, "showInfo");
        p.h(str, "whiteListReddotList");
        p.h(str2, "overwriteTipsId");
        hc hcVar = new hc();
        hcVar.qI((long) kVar.field_ctrInfo.type);
        hcVar.qJ((long) bdo.xGz);
        hcVar.qK((long) i2);
        hcVar.uQ(kVar.field_tipsId);
        hcVar.uR(bdo.path);
        hcVar.qL((long) i3);
        hcVar.uS(str);
        hcVar.uT(str2);
        hcVar.qM(cl.aWA());
        JSONObject bN = com.tencent.mm.ac.g.bN(kVar.dbx());
        bN.put("object_id", d.zs(kVar.dbx().object_id));
        String jSONObject = bN.toString();
        p.g(jSONObject, "extInfo.toString()");
        hcVar.uU(n.j(jSONObject, ",", ";", false));
        hcVar.bfK();
        k kVar2 = k.vfA;
        k.a(hcVar);
        AppMethodBeat.o(250626);
    }
}
