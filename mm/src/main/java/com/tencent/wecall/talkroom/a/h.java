package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class h extends d {
    public String groupId;
    public int roomId;
    public long ypH;

    public h(String str, int i2, long j2, int i3, int i4) {
        AppMethodBeat.i(175625);
        b.d("MicroMsg.Voip", this.TAG2, "NetSceneRejectVoiceGroup");
        a.m mVar = new a.m();
        try {
            mVar.groupId = str;
            mVar.GXO = i2;
            mVar.GXP = j2;
            mVar.qrD = i3;
            mVar.RDu = 2;
            mVar.netType = k.lx(c.Hhs);
            if (i4 == 0) {
                mVar.RDG = 0;
            } else {
                mVar.RDG = 1;
            }
            b.w(this.TAG2, "NetSceneRedirect redirect type:", Integer.valueOf(mVar.RDG));
            this.mNetType = 3;
            this.RCJ = com.tencent.wecall.talkroom.model.c.hqY().brj(str);
        } catch (Exception e2) {
            b.w(this.TAG2, "NetSceneRedirect constructor", e2);
        }
        c(211, mVar);
        AppMethodBeat.o(175625);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 211;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.an anVar;
        AppMethodBeat.i(62546);
        b.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr != null) {
            try {
                anVar = (a.an) e.a(new a.an(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                anVar = null;
            }
        } else {
            anVar = null;
        }
        AppMethodBeat.o(62546);
        return anVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSVoiceRedirectReq";
    }
}
