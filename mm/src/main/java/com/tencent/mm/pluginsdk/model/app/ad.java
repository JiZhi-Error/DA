package com.tencent.mm.pluginsdk.model.app;

import com.tencent.luggage.game.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.big;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad extends aa {
    List<String> JWz;

    public ad(List<String> list) {
        AppMethodBeat.i(151814);
        d.a aVar = new d.a();
        aVar.iLN = new bif();
        aVar.iLO = new big();
        aVar.uri = "/cgi-bin/micromsg-bin/getappsetting";
        aVar.funcId = c.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        this.JWz = list;
        Log.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + list.size());
        LinkedList<gk> linkedList = new LinkedList<>();
        for (String str : list) {
            if (str != null && str.length() > 0) {
                gk gkVar = new gk();
                gkVar.hik = str;
                linkedList.add(gkVar);
            }
        }
        if (linkedList.size() == 0) {
            Log.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
        }
        bif bif = (bif) this.hhm.iLK.iLR;
        bif.LSy = linkedList;
        bif.LSx = linkedList.size();
        AppMethodBeat.o(151814);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151815);
        Log.d("MicroMsg.NetSceneGetAppSetting", "errType = " + i3 + ", errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            big big = (big) this.hhm.iLL.iLR;
            Log.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + big.LSx);
            LinkedList<gj> linkedList = big.LSz;
            if (linkedList == null || linkedList.size() == 0) {
                Log.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
                AppMethodBeat.o(151815);
                return;
            }
            j eAS = a.eAS();
            Iterator<gj> it = linkedList.iterator();
            while (it.hasNext()) {
                gj next = it.next();
                g o = h.o(next.hik, false, false);
                if (o != null) {
                    o.field_authFlag = next.KKl;
                    o.field_openId = next.hio;
                    Log.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + eAS.a(o, new String[0]) + ", appId = " + next.hik);
                }
            }
            AppMethodBeat.o(151815);
            return;
        }
        Log.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + i3 + ", errCode = " + i4);
        AppMethodBeat.o(151815);
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final byte[] gmB() {
        AppMethodBeat.i(151816);
        try {
            byte[] protoBuf = ((d.b) this.hhm.getReqObj()).toProtoBuf();
            AppMethodBeat.o(151816);
            return protoBuf;
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e2, "", new Object[0]);
            AppMethodBeat.o(151816);
            return null;
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final void cB(byte[] bArr) {
        AppMethodBeat.i(151817);
        if (bArr == null) {
            Log.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
            AppMethodBeat.o(151817);
            return;
        }
        try {
            this.hhm.iLL.fromProtoBuf(bArr);
            AppMethodBeat.o(151817);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e2, "", new Object[0]);
            AppMethodBeat.o(151817);
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final int getType() {
        return 1;
    }
}
