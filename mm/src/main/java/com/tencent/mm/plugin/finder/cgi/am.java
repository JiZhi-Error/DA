package com.tencent.mm.plugin.finder.cgi;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.video.reporter.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/FinderBaseRequestFactory;", "", "()V", "create", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "reportData", "Lcom/tencent/mm/protocal/protobuf/MvReportData;", "generateClientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderClientStatus;", "plugin-finder_release"})
public final class am {
    public static final am tuw = new am();

    static {
        AppMethodBeat.i(242326);
        AppMethodBeat.o(242326);
    }

    private am() {
    }

    public static aov cXY() {
        AppMethodBeat.i(242322);
        aov aov = new aov();
        i iVar = i.vDq;
        i.a(aov);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aov.LAQ = aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_VERSION_INT_SYNC, 0);
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aov.Viq = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_LIVE_VISITOR_ROLE_INT_SYNC, 4);
        AppMethodBeat.o(242322);
        return aov;
    }

    public static aov a(bbn bbn) {
        AppMethodBeat.i(242323);
        aov aov = new aov();
        i iVar = i.vDq;
        i.a(aov);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aov.LAQ = aAh.azQ().getInt(ar.a.USERINFO_FINDER_USER_VERSION_INT_SYNC, 0);
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aov.Viq = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_LIVE_VISITOR_ROLE_INT_SYNC, 4);
        aov.LAT = new aas();
        if (bbn != null) {
            aov.scene = bbn.tCE;
            aov.LAT.sGQ = bbn.sGQ;
            aov.LAT.sGE = bbn.sGE;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sessionId", bbn.sessionId);
                if (!Util.isNullOrNil(bbn.extraInfo)) {
                    jSONObject.put("extraInfo", bbn.extraInfo);
                }
                if (!Util.isNullOrNil(bbn.sGH)) {
                    jSONObject.put("enterSourceInfo", bbn.sGH);
                }
            } catch (Exception e2) {
            }
            aov.LAT.Lma = jSONObject.toString();
        }
        aov.ulj = cl.aWz();
        AppMethodBeat.o(242323);
        return aov;
    }

    public static aov a(cst cst) {
        AppMethodBeat.i(242324);
        aov aov = new aov();
        if (cst != null) {
            aov.scene = cst.MxI;
            aov.ulj = cl.aWz();
        }
        AppMethodBeat.o(242324);
        return aov;
    }

    public static apc cXZ() {
        AppMethodBeat.i(242325);
        apc apc = new apc();
        apc.osName = d.KyL;
        apc.osVersion = d.KyM;
        apc.deviceBrand = d.KyI;
        apc.deviceModel = d.KyJ;
        apc.LBe = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        k kVar = k.vfA;
        apc.netType = k.dod();
        apc.LBf = CdnLogic.getRecentAverageSpeed(2);
        b.a aVar = b.whK;
        apc.LBg = b.dFY();
        apc.LBh.add("h264");
        if (com.tencent.mm.modelcontrol.e.sX(4)) {
            apc.LBh.add("h265");
        }
        AppMethodBeat.o(242325);
        return apc;
    }
}
