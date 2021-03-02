package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;

public final class c extends a {
    private String mAppId;
    private f ymY;

    public c(String str, String str2, String str3, f fVar) {
        AppMethodBeat.i(196779);
        this.mAppId = str;
        this.ymY = fVar;
        this.type = "liteappconfig_".concat(String.valueOf(str));
        this.ymP = str2;
        this.ymQ = str3;
        this.mScene = 0;
        this.ymR.addAll(e.dZe());
        AppMethodBeat.o(196779);
    }

    @Override // com.tencent.mm.plugin.hp.net.a, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        g gVar;
        AppMethodBeat.i(196780);
        Log.i("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "errType:%d errCode:%d errMsg:%s ", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            cxw cxw = (cxw) ((d) sVar).iLL.iLR;
            cxz cxz = cxw.MCM;
            Log.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "node is no empty. try to process");
            g gVar2 = new g();
            if (cxz != null) {
                if (cxz.MCT != null) {
                    gVar2.pkL = cxz.MCT.MD5;
                    gVar2.pkK = cxz.MCT.Url;
                    gVar2.fileSize = cxz.MCT.FileSize;
                }
                gVar2.pkH = Integer.valueOf(cxz.state);
                gVar2.pkJ = Integer.valueOf(cxz.MCS);
                gVar2.pkI = Integer.valueOf(cxz.MCR);
                gVar2.cri = cxz.APx;
                gVar2.appId = this.mAppId;
                if (cxz.MCV != null) {
                    Iterator<cxx> it = cxz.MCV.iterator();
                    while (it.hasNext()) {
                        cxx next = it.next();
                        if ("signature_key".equals(next.key)) {
                            gVar2.crh = next.value;
                        }
                    }
                }
            }
            gVar2.errorCode = cxw.MCO;
            gVar = gVar2;
        } else {
            Log.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "check tinker update failed.");
            gVar = new g();
            gVar.errorCode = -1;
        }
        this.ymY.a(gVar);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(196780);
    }
}
