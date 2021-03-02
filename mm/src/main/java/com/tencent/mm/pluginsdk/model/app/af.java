package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.protocal.protobuf.br;
import com.tencent.mm.protocal.protobuf.bvv;
import com.tencent.mm.protocal.protobuf.bvw;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ffi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class af extends aa {
    LinkedList<g> JWA;
    private LinkedList<g> JWB;
    private LinkedList<String> JWC;
    private int appType;

    public af(String str, LinkedList<String> linkedList) {
        AppMethodBeat.i(151821);
        Log.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0, limit = 20, lang = " + str + "installedApp list size: " + linkedList.size());
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            Log.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", it.next());
        }
        this.appType = 3;
        d.a aVar = new d.a();
        aVar.iLN = new bvv();
        aVar.iLO = new bvw();
        aVar.uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
        aVar.funcId = 409;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        bvv bvv = (bvv) this.hhm.iLK.iLR;
        bvv.xIV = 3;
        bvv.xLV = 0;
        bvv.xLW = 20;
        bvv.xLl = str;
        LinkedList<dqi> bG = bG(linkedList);
        bvv.MbN = bG.size();
        bvv.xLF = bG;
        this.JWA = new LinkedList<>();
        this.JWB = new LinkedList<>();
        this.JWC = new LinkedList<>();
        this.JWC.addAll(linkedList);
        AppMethodBeat.o(151821);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151822);
        Log.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i3 + ", errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            bvw bvw = (bvw) this.hhm.iLL.iLR;
            if (bvw == null) {
                Log.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
                AppMethodBeat.o(151822);
                return;
            }
            Log.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", Integer.valueOf(bvw.MbO), Integer.valueOf(this.appType));
            j eAX = a.C1616a.eAZ().eAX();
            b(eAX, bvw.MbP);
            a(eAX, bvw.xME);
            AppMethodBeat.o(151822);
            return;
        }
        Log.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i3 + ", errCode = " + i4);
        AppMethodBeat.o(151822);
    }

    private void a(j jVar, LinkedList<br> linkedList) {
        AppMethodBeat.i(151823);
        if (linkedList != null && linkedList.size() > 0) {
            Iterator<br> it = linkedList.iterator();
            while (it.hasNext()) {
                br next = it.next();
                g o = h.o(next.hik, true, false);
                if (o != null) {
                    a(o, next);
                    jVar.a(o, new String[0]);
                } else {
                    o = new g();
                    o.field_appId = next.hik;
                    a(o, next);
                    jVar.r(o);
                }
                this.JWB.add(o);
            }
        }
        AppMethodBeat.o(151823);
    }

    private void b(j jVar, LinkedList<dje> linkedList) {
        g gVar;
        boolean z;
        boolean a2;
        boolean z2;
        AppMethodBeat.i(151824);
        if (linkedList != null && linkedList.size() > 0) {
            Iterator<dje> it = linkedList.iterator();
            while (it.hasNext()) {
                dje next = it.next();
                if (Util.isNullOrNil(next.hik)) {
                    Log.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
                } else {
                    boolean z3 = true;
                    boolean z4 = false;
                    g o = h.o(next.hik, true, false);
                    if (o != null) {
                        a(o, next);
                        if (this.appType == 3) {
                            o.field_status = 5;
                            if (Util.isNullOrNil(o.fmM) || Util.isNullOrNil(o.fmL)) {
                                Object[] objArr = new Object[2];
                                if (o.fmM != null) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                objArr[0] = Boolean.valueOf(z2);
                                objArr[1] = Boolean.valueOf(o.fmL != null);
                                Log.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params1, has IntroUrl %s, has IconUrl %s", objArr);
                                z3 = false;
                                a2 = false;
                                Log.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", next.hik, Boolean.valueOf(a2), Boolean.valueOf(z3));
                                gVar = o;
                            }
                        }
                        a2 = jVar.a(o, new String[0]);
                        Log.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", next.hik, Boolean.valueOf(a2), Boolean.valueOf(z3));
                        gVar = o;
                    } else {
                        g gVar2 = new g();
                        gVar2.field_appId = next.hik;
                        a(gVar2, next);
                        if (this.appType == 3) {
                            gVar2.field_status = 5;
                            if (Util.isNullOrNil(gVar2.fmM) || Util.isNullOrNil(gVar2.fmL)) {
                                Object[] objArr2 = new Object[2];
                                if (gVar2.fmM != null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                objArr2[0] = Boolean.valueOf(z);
                                objArr2[1] = Boolean.valueOf(gVar2.fmL != null);
                                Log.e("MicroMsg.NetSceneGetSuggestionAppList", "wrong suggestion params2, has IntroUrl %s, has IconUrl %s", objArr2);
                                z3 = false;
                                Log.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", next.hik, Boolean.valueOf(z4), Boolean.valueOf(z3));
                                gVar = gVar2;
                            }
                        }
                        z4 = jVar.r(gVar2);
                        Log.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", next.hik, Boolean.valueOf(z4), Boolean.valueOf(z3));
                        gVar = gVar2;
                    }
                    if (z3 && !this.JWC.contains(next.hik) && !this.JWA.contains(gVar)) {
                        this.JWA.add(gVar);
                    }
                }
            }
        }
        AppMethodBeat.o(151824);
    }

    private static LinkedList<dqi> bG(LinkedList<String> linkedList) {
        AppMethodBeat.i(151825);
        LinkedList<dqi> linkedList2 = new LinkedList<>();
        if (linkedList == null) {
            AppMethodBeat.o(151825);
            return linkedList2;
        }
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!Util.isNullOrNil(next)) {
                linkedList2.add(z.Su(next));
            }
        }
        AppMethodBeat.o(151825);
        return linkedList2;
    }

    private static void a(g gVar, dje dje) {
        AppMethodBeat.i(151826);
        gVar.Bl(dje.KFr);
        gVar.field_appIconUrl = dje.KFs;
        gVar.Bk(dje.MNg);
        gVar.field_appName = dje.xMq;
        gVar.Bm(dje.KFt);
        gVar.field_appType = dje.KRY;
        gVar.Bo(dje.xJM);
        gVar.field_packageName = dje.KFu;
        gVar.Bp(dje.KFv);
        if (!Util.isNullOrNil(dje.KFv)) {
            Log.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", dje.KFv, Integer.valueOf(dje.MNq));
            gVar.mZ(dje.MNq);
        }
        gVar.Bq(dje.MNn);
        gVar.Br(dje.MNo);
        a(gVar, dje.KFw);
        s(gVar);
        AppMethodBeat.o(151826);
    }

    private static void s(g gVar) {
        AppMethodBeat.i(151827);
        if (!Util.isNullOrNil(gVar.field_appType) && (gVar.field_appType.startsWith("1") || gVar.field_appType.startsWith("6"))) {
            if (!gVar.field_appType.endsWith(",")) {
                gVar.field_appType += ",";
            }
            gVar.field_appType = "," + gVar.field_appType;
        }
        AppMethodBeat.o(151827);
    }

    private static void a(g gVar, ffi ffi) {
        AppMethodBeat.i(151828);
        Log.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", gVar.field_appId);
        if (ffi != null) {
            gVar.mZ(ffi.NAD);
            gVar.Bu(ffi.xuc);
            gVar.Bv(ffi.xNS);
            gVar.Bs(ffi.NAE);
            gVar.Bt(ffi.xNU);
            gVar.Bw(ffi.xNV);
            gVar.na(ffi.xNW);
            Log.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", Integer.valueOf(ffi.NAD), ffi.xuc, ffi.xNS, ffi.NAE, ffi.xNU, ffi.xNV, Integer.valueOf(ffi.xNW));
        }
        AppMethodBeat.o(151828);
    }

    private static void a(g gVar, br brVar) {
        AppMethodBeat.i(151829);
        gVar.Bl(brVar.KFr);
        gVar.Bo(brVar.xJM);
        gVar.Bm(brVar.KFt);
        gVar.field_appName = brVar.xMq;
        gVar.field_appIconUrl = brVar.KFs;
        gVar.Bp(brVar.KFv);
        gVar.Bx(brVar.KFx);
        a(gVar, brVar.KFw);
        AppMethodBeat.o(151829);
    }

    public final int gnb() {
        return ((bvw) this.hhm.iLL.iLR).MbO;
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final byte[] gmB() {
        AppMethodBeat.i(151830);
        try {
            byte[] protoBuf = ((d.b) this.hhm.getReqObj()).toProtoBuf();
            AppMethodBeat.o(151830);
            return protoBuf;
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneGetSuggestionAppList", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", e2, "", new Object[0]);
            AppMethodBeat.o(151830);
            return null;
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final void cB(byte[] bArr) {
        AppMethodBeat.i(151831);
        if (bArr == null) {
            Log.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
            AppMethodBeat.o(151831);
            return;
        }
        try {
            this.hhm.iLL.fromProtoBuf(bArr);
            AppMethodBeat.o(151831);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneGetSuggestionAppList", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", e2, "", new Object[0]);
            AppMethodBeat.o(151831);
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final int getType() {
        return 4;
    }
}
