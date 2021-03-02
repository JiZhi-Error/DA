package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class d extends com.tencent.pb.common.b.d {
    public String SuH;
    public boolean SwT = true;
    public int mType;

    public d(String str, String[] strArr, byte[] bArr, String str2, a.be beVar, int i2, int i3, long j2, String str3, boolean z, String str4) {
        AppMethodBeat.i(199660);
        b.d("MicroMsg.Voip", this.TAG2, "create");
        a.d dVar = new a.d();
        try {
            dVar.RDo = str;
            this.SuH = str;
            dVar.RDt = i2;
            this.RCJ = i2;
            if (beVar != null) {
                dVar.RDv = beVar;
            }
            a.az azVar = new a.az();
            azVar.name = str2;
            azVar.RFQ = str4;
            azVar.RFP = com.tencent.pb.a.a.a.hjq();
            azVar.dLt = i3;
            this.mType = i3;
            this.SwT = z;
            azVar.RFI = j2;
            dVar.RDq = azVar;
            dVar.RDx = strArr;
            dVar.RDw = str3 == null ? "" : str3;
            a.ap apVar = new a.ap();
            if (bArr != null) {
                apVar.buffer = bArr;
                apVar.iLen = bArr.length;
            } else {
                apVar.iLen = 0;
            }
            a.bg bgVar = new a.bg();
            bgVar.type = 3;
            bgVar.RGJ = apVar;
            dVar.RDs = bgVar;
            this.mNetType = 3;
            dVar.RDu = 2;
            dVar.netType = k.lx(c.Hhs);
        } catch (Exception e2) {
            b.w(this.TAG2, "NetSceneCreateVoiceGroup constructor", e2);
        }
        c(com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX, dVar);
        AppMethodBeat.o(199660);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 201;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.ab abVar;
        AppMethodBeat.i(62539);
        b.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                abVar = (a.ab) e.a(new a.ab(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                abVar = null;
            }
        } else {
            abVar = null;
        }
        AppMethodBeat.o(62539);
        return abVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
    }
}
