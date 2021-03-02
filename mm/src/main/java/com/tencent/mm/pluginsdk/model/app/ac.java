package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ac extends aa {
    private static final String[] JWy = {"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};

    public ac(List<String> list) {
        int i2 = 0;
        AppMethodBeat.i(151807);
        LinkedList linkedList = new LinkedList(list);
        d.a aVar = new d.a();
        aVar.iLN = new bid();
        aVar.iLO = new bie();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfolist";
        aVar.funcId = 451;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        bid bid = (bid) this.hhm.iLK.iLR;
        LinkedList<dqi> is = is(linkedList);
        bid.LSt = is;
        bid.oTz = is.size();
        bid.LSv = ir(linkedList);
        bid.LSu = bid.LSv != null ? bid.LSv.size() : i2;
        AppMethodBeat.o(151807);
    }

    private static LinkedList<dqi> ir(List<String> list) {
        boolean z;
        AppMethodBeat.i(151808);
        LinkedList linkedList = new LinkedList();
        LinkedList<dqi> linkedList2 = new LinkedList<>();
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(151808);
            return linkedList2;
        }
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("key_open_sdk_pkg");
        if (singleMMKV == null) {
            AppMethodBeat.o(151808);
            return linkedList2;
        }
        for (String str : list) {
            linkedList.add(singleMMKV.decodeString(str, ""));
        }
        Iterator it = linkedList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!Util.isNullOrNil((String) it.next())) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            AppMethodBeat.o(151808);
            return linkedList2;
        }
        LinkedList<dqi> is = is(linkedList);
        AppMethodBeat.o(151808);
        return is;
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final int getType() {
        return 7;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151809);
        Log.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + i3 + ", errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            LinkedList<nf> linkedList = ((bie) this.hhm.iLL.iLR).LSw;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator<nf> it = linkedList.iterator();
                while (it.hasNext()) {
                    nf next = it.next();
                    if (next != null) {
                        a(h.o(next.jfi, false, false), next);
                    }
                }
            }
            AppMethodBeat.o(151809);
            return;
        }
        Log.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + i3 + ", errCode = " + i4);
        AppMethodBeat.o(151809);
    }

    private static LinkedList<dqi> is(List<String> list) {
        AppMethodBeat.i(151810);
        LinkedList<dqi> linkedList = new LinkedList<>();
        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        for (String str : strArr) {
            if (!Util.isNullOrNil(str)) {
                linkedList.add(z.Su(str));
            }
        }
        AppMethodBeat.o(151810);
        return linkedList;
    }

    private static void a(g gVar, nf nfVar) {
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        boolean a2;
        int i2 = 0;
        AppMethodBeat.i(151811);
        if (gVar == null) {
            gVar = new g();
            gVar.field_appId = nfVar.jfi;
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", nfVar.jfi, Integer.valueOf(nfVar.xIN), Long.valueOf(nfVar.KSe));
        Log.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", gVar.field_appId, gVar.field_appName, Integer.valueOf(gVar.field_status), Integer.valueOf(gVar.field_appInfoFlag));
        if (!gVar.gmR() || Util.isNullOrNil(gVar.field_appName)) {
            gVar.field_appName = nfVar.Name;
        }
        if (!gVar.gmR() || Util.isNullOrNil(gVar.field_appName_en)) {
            gVar.field_appName_en = nfVar.KRP;
        }
        if (!gVar.gmR() || Util.isNullOrNil(gVar.field_appName_tw)) {
            gVar.field_appName_tw = nfVar.KRR;
        }
        gVar.field_appDiscription = nfVar.KHk;
        gVar.field_appDiscription_en = nfVar.KRQ;
        gVar.field_appDiscription_tw = nfVar.KRS;
        gVar.field_appWatermarkUrl = nfVar.KRW;
        gVar.field_packageName = nfVar.KFu;
        String str2 = nfVar.KRX;
        if (str2 == null || str2.length() == 0) {
            Log.e("MicroMsg.AppUtil", "getDbSignature, svrSign is null");
            str = null;
        } else {
            str = r.bdM(str2);
        }
        gVar.field_signature = str;
        Log.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s pkd: %s", nfVar.KRX, gVar.field_signature, nfVar.KFu);
        gVar.field_appType = nfVar.KRY;
        if (!Util.isNullOrNil(gVar.field_appType) && (gVar.field_appType.startsWith("1") || gVar.field_appType.startsWith("6"))) {
            gVar.field_appType = "," + gVar.field_appType;
        }
        gVar.field_appInfoFlag = nfVar.xIN;
        gVar.field_appVersion = nfVar.KSa;
        gVar.Bk(nfVar.KRZ);
        gVar.field_appWatermarkUrl = nfVar.KRW;
        if (!Util.isNullOrNil(nfVar.xuc) && !Util.isNullOrNil(nfVar.KSd)) {
            Log.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", gVar.field_appName, nfVar.xuc, nfVar.KSd);
            gVar.Bl(nfVar.xuc);
            gVar.Bo(nfVar.KSd);
        }
        gVar.Bp(nfVar.KFv);
        gVar.field_svrAppSupportContentType = nfVar.KSe;
        if (nfVar.KSb > gVar.fmF) {
            gVar.fmG = 1;
            gVar.fma = true;
        }
        gVar.fmF = nfVar.KSb;
        gVar.fma = true;
        String str3 = nfVar.KFu;
        String str4 = nfVar.KFu;
        if (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            Log.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + nfVar.KFu + "appid: " + gVar.field_appId);
        }
        if (gVar.NA()) {
            com.tencent.mm.pluginsdk.ui.tools.d.bfo(gVar.field_appId);
        }
        j eAS = a.eAS();
        if (z) {
            gVar.field_status = z2 ? 3 : 4;
            gVar.field_modifyTime = System.currentTimeMillis();
            gVar.field_appIconUrl = nfVar.KRU;
            if (gVar.field_appId != null) {
                while (true) {
                    if (i2 >= JWy.length) {
                        break;
                    } else if (gVar.field_appId.equals(JWy[i2])) {
                        gVar.field_status = -1;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            if (!eAS.r(gVar)) {
                Log.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
                AppMethodBeat.o(151811);
                return;
            }
            a.eAQ().gD(gVar.field_appId, 1);
            a.eAQ().gD(gVar.field_appId, 2);
            a.eAQ().gD(gVar.field_appId, 3);
            a.eAQ().gD(gVar.field_appId, 4);
            a.eAQ().gD(gVar.field_appId, 5);
            AppMethodBeat.o(151811);
            return;
        }
        gVar.field_status = z2 ? 3 : gVar.field_status;
        if (gVar.field_appId != null) {
            int i3 = 0;
            while (true) {
                if (i3 >= JWy.length) {
                    break;
                } else if (gVar.field_appId.equals(JWy[i3])) {
                    gVar.field_status = -1;
                    break;
                } else {
                    i3++;
                }
            }
        }
        if (gVar == null || gVar.field_appIconUrl == null || gVar.field_appIconUrl.length() == 0) {
            z3 = true;
        } else if (nfVar == null || nfVar.KSc == null || nfVar.KSc.length() == 0) {
            z3 = false;
        } else {
            z3 = !gVar.field_appIconUrl.equals(nfVar.KRU);
        }
        if (z3) {
            Log.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", gVar.field_appIconUrl, nfVar.KRU);
            gVar.field_appIconUrl = nfVar.KRU;
            a2 = eAS.a(gVar, new String[0]);
            a.eAQ().gD(gVar.field_appId, 1);
            a.eAQ().gD(gVar.field_appId, 2);
            a.eAQ().gD(gVar.field_appId, 3);
            a.eAQ().gD(gVar.field_appId, 4);
            a.eAQ().gD(gVar.field_appId, 5);
        } else {
            a2 = eAS.a(gVar, new String[0]);
        }
        Log.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + a2 + ", appid = " + nfVar.jfi);
        AppMethodBeat.o(151811);
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final byte[] gmB() {
        AppMethodBeat.i(151812);
        try {
            byte[] protoBuf = ((d.b) this.hhm.getReqObj()).toProtoBuf();
            AppMethodBeat.o(151812);
            return protoBuf;
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + e2.getMessage());
            AppMethodBeat.o(151812);
            return null;
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final void cB(byte[] bArr) {
        AppMethodBeat.i(151813);
        if (bArr == null) {
            Log.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
            AppMethodBeat.o(151813);
            return;
        }
        try {
            this.hhm.iLL.fromProtoBuf(bArr);
            AppMethodBeat.o(151813);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", e2, "", new Object[0]);
            AppMethodBeat.o(151813);
        }
    }
}
