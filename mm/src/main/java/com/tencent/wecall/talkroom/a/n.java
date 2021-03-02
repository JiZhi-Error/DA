package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.wecall.talkroom.model.c;

public final class n extends d {
    public long HgX;
    public String xOr;
    public int yvK;

    public n(String str, int i2, long j2, int i3) {
        AppMethodBeat.i(62524);
        b.d("MicroMsg.Voip", this.TAG2, "NetSceneSwitchVideoGroup");
        a.k kVar = new a.k();
        try {
            kVar.groupId = str;
            this.xOr = str;
            kVar.roomId = i2;
            this.yvK = i2;
            kVar.ypH = j2;
            this.HgX = j2;
            kVar.action = i3;
            kVar.timestamp = System.currentTimeMillis();
            this.mNetType = 3;
            this.RCJ = c.hqY().brj(str);
        } catch (Exception e2) {
            b.w(this.TAG2, "NetSceneSwitchVideoGroup constructor", e2);
        }
        c(com.tencent.mm.plugin.appbrand.jsapi.o.b.d.CTRL_INDEX, kVar);
        AppMethodBeat.o(62524);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 214;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.aj ajVar;
        AppMethodBeat.i(62525);
        b.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                ajVar = (a.aj) e.a(new a.aj(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                ajVar = null;
            }
        } else {
            ajVar = null;
        }
        AppMethodBeat.o(62525);
        return ajVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSSwitchVideoGroupReq";
    }
}
