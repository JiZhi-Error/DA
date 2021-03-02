package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.wecall.talkroom.model.c;

public final class b extends d {
    public long HgX;
    public String xOr;
    public int yvK;

    public b(String str, int i2, long j2, String[] strArr) {
        AppMethodBeat.i(62533);
        com.tencent.pb.common.c.b.d("MicroMsg.Voip", this.TAG2, "addmember", str);
        a.C2179a aVar = new a.C2179a();
        try {
            aVar.groupId = str;
            this.xOr = str;
            aVar.GXO = i2;
            this.yvK = i2;
            aVar.GXP = j2;
            this.HgX = j2;
            aVar.RDn = strArr;
            aVar.GXO = i2;
            this.mNetType = 3;
            this.RCJ = c.hqY().brj(str);
        } catch (Exception e2) {
            com.tencent.pb.common.c.b.w(this.TAG2, "NetSceneAddVoiceGroupMember constructor", e2);
        }
        c(145, aVar);
        AppMethodBeat.o(62533);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 204;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.z zVar;
        AppMethodBeat.i(62534);
        if (bArr != null) {
            try {
                zVar = (a.z) e.a(new a.z(), bArr, bArr.length);
            } catch (Exception e2) {
                com.tencent.pb.common.c.b.w(this.TAG2, "data2Resp", e2.getMessage());
                zVar = null;
            }
        } else {
            zVar = null;
        }
        AppMethodBeat.o(62534);
        return zVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
    }
}
