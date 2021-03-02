package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ena;
import com.tencent.mm.protocal.protobuf.enb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.o;

public final class b extends q implements m {
    private int bNu;
    private i callback;
    private String clientId;
    private String dRr;
    private int iKP;
    public String jid;
    private d rr;
    private String username;

    public b(String str, String str2) {
        this(str);
        this.dRr = str2;
    }

    private b(String str) {
        AppMethodBeat.i(90688);
        this.username = str;
        this.iKP = 0;
        this.bNu = 0;
        StringBuilder sb = new StringBuilder();
        g.aAf();
        this.clientId = sb.append(a.getUin()).append(System.currentTimeMillis()).toString();
        AppMethodBeat.o(90688);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 575;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        AppMethodBeat.i(90689);
        if (this.dRr == null || this.dRr.length() == 0) {
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(90689);
            return bVar;
        }
        q.b bVar2 = q.b.EOk;
        AppMethodBeat.o(90689);
        return bVar2;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 100;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(90690);
        this.callback = iVar;
        if (this.dRr == null || this.dRr.length() == 0) {
            Log.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
            AppMethodBeat.o(90690);
            return -1;
        } else if (!com.tencent.mm.vfs.s.YS(this.dRr)) {
            Log.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.dRr);
            AppMethodBeat.o(90690);
            return -1;
        } else {
            if (this.iKP == 0) {
                this.iKP = (int) new o(this.dRr).length();
            }
            d.a aVar = new d.a();
            aVar.iLN = new ena();
            aVar.iLO = new enb();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
            aVar.funcId = 575;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            this.rr = aVar.aXF();
            byte[] aW = com.tencent.mm.vfs.s.aW(this.dRr, this.bNu, Math.min(this.iKP - this.bNu, 32768));
            if (aW == null) {
                Log.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
                AppMethodBeat.o(90690);
                return -1;
            }
            Log.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(aW.length), Integer.valueOf(this.iKP));
            ena ena = (ena) this.rr.iLK.iLR;
            ena.Lqx = this.username;
            ena.BsF = this.iKP;
            ena.BsG = this.bNu;
            ena.BsI = new SKBuiltinBuffer_t().setBuffer(aW);
            ena.BsH = ena.BsI.getILen();
            ena.izX = this.clientId;
            int dispatch = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(90690);
            return dispatch;
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        as Kn;
        AppMethodBeat.i(90691);
        Log.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            enb enb = (enb) ((d) sVar).iLL.iLR;
            this.jid = enb.Mvw;
            this.bNu = enb.BsG;
            if (this.bNu < this.iKP) {
                if (doScene(dispatcher(), this.callback) < 0) {
                    Log.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
                    this.callback.onSceneEnd(3, -1, "", this);
                }
                Log.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
                AppMethodBeat.o(90691);
                return;
            }
            if (!Util.isNullOrNil(this.jid) && (Kn = ((l) g.af(l.class)).aSN().Kn(this.username)) != null && ((int) Kn.gMZ) > 0 && c.oR(Kn.field_type)) {
                Kn.Cd(this.jid);
                ((l) g.af(l.class)).aSN().c(this.username, Kn);
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(90691);
            return;
        }
        Log.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(90691);
    }
}
