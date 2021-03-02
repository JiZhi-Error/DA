package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.protocal.protobuf.bwz;
import com.tencent.mm.protocal.protobuf.bxa;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class o extends aa {
    public String appID;

    public o(String str, LinkedList<String> linkedList) {
        AppMethodBeat.i(30993);
        Log.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", str);
        this.appID = str;
        d.a aVar = new d.a();
        aVar.iLN = new bwz();
        aVar.iLO = new bxa();
        aVar.uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
        aVar.funcId = 452;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        bwz bwz = (bwz) this.hhm.iLK.iLR;
        bwz.hik = str;
        LinkedList<dqi> linkedList2 = new LinkedList<>();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!Util.isNullOrNil(next)) {
                linkedList2.add(z.Su(next));
            }
        }
        bwz.KGP = linkedList2;
        bwz.LUu = linkedList.size();
        AppMethodBeat.o(30993);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(30994);
        Log.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i3 + ", errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            AppMethodBeat.o(30994);
            return;
        }
        Log.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i3 + ", errCode = " + i4);
        AppMethodBeat.o(30994);
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final byte[] gmB() {
        AppMethodBeat.i(30995);
        try {
            byte[] protoBuf = ((d.b) this.hhm.getReqObj()).toProtoBuf();
            AppMethodBeat.o(30995);
            return protoBuf;
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneGetUserInfoInApp", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", e2, "", new Object[0]);
            AppMethodBeat.o(30995);
            return null;
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final void cB(byte[] bArr) {
        AppMethodBeat.i(30996);
        if (bArr == null) {
            Log.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
            AppMethodBeat.o(30996);
            return;
        }
        try {
            this.hhm.iLL.fromProtoBuf(bArr);
            AppMethodBeat.o(30996);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneGetUserInfoInApp", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", e2, "", new Object[0]);
            AppMethodBeat.o(30996);
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.app.aa
    public final int getType() {
        return 14;
    }

    public final bxa gmC() {
        if (this.hhm == null) {
            return null;
        }
        return (bxa) this.hhm.iLL.iLR;
    }
}
