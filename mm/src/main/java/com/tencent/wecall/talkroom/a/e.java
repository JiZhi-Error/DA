package com.tencent.wecall.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class e extends d {
    public long HgX = 0;
    public String SuG = null;
    public int SwU = 0;
    public String xOr = null;
    public int yvK = 0;

    public e(e eVar) {
        AppMethodBeat.i(62542);
        this.xOr = eVar.xOr;
        this.yvK = eVar.yvK;
        this.HgX = eVar.HgX;
        this.SwU = eVar.SwU;
        this.SuG = eVar.SuG;
        this.RCG = eVar.RCG;
        this.RCI = eVar.RCI;
        this.RCJ = eVar.RCJ;
        this.mNetType = 1;
        AppMethodBeat.o(62542);
    }

    public e(String str, int i2, long j2, byte[] bArr, int i3, int i4, String str2) {
        AppMethodBeat.i(62543);
        b.d("MicroMsg.Voip", this.TAG2, "enter2", str, Integer.valueOf(i2), Long.valueOf(j2), str2);
        a.e eVar = new a.e();
        try {
            eVar.groupId = str;
            this.xOr = str;
            eVar.GXO = i2;
            this.yvK = i2;
            eVar.GXP = j2;
            this.HgX = j2;
            eVar.vkj = i4;
            this.SwU = i4;
            a.az azVar = new a.az();
            azVar.RFQ = str2;
            eVar.RDq = azVar;
            this.SuG = str2;
            b.d("MicroMsg.Voip", this.TAG2, "wXgroupId", eVar.RDq.RFQ);
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
            eVar.RDs = bgVar;
            this.mNetType = 2;
            this.RCJ = i3;
            eVar.RDu = 2;
            eVar.netType = k.lx(c.Hhs);
        } catch (Exception e2) {
            b.w(this.TAG2, "NetSceneEnterVoiceRoom constructor", e2);
        }
        c(141, eVar);
        AppMethodBeat.o(62543);
    }

    @Override // com.tencent.pb.common.b.d
    public final int getType() {
        return 202;
    }

    @Override // com.tencent.pb.common.b.d
    public final Object cO(byte[] bArr) {
        a.ac acVar;
        AppMethodBeat.i(62544);
        if (bArr != null) {
            try {
                acVar = (a.ac) com.google.a.a.e.a(new a.ac(), bArr, bArr.length);
            } catch (Exception e2) {
                b.w(this.TAG2, "data2Resp", e2.getMessage());
                acVar = null;
            }
        } else {
            acVar = null;
        }
        AppMethodBeat.o(62544);
        return acVar;
    }

    @Override // com.tencent.pb.common.b.d
    public final String hiV() {
        return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
    }
}
