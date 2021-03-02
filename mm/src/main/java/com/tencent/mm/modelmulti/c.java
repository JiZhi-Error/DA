package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends q implements m {
    private List<String> aZK;
    private i callback;
    private int index;
    private final int jcn = 1000;
    private final int jco = 0;
    private final int jcp = 1;
    private final int jcq = 2;
    private final int jcr = 3;
    public List<String> jcs = new LinkedList();
    private int jct;
    public int jcu;
    public int op;
    private d rr;
    private int type;

    public c(List<String> list, int i2, int i3, int i4) {
        AppMethodBeat.i(187474);
        this.aZK = list;
        this.type = i2;
        this.op = i3;
        this.index = 0;
        this.jcu = list.size();
        this.jct = i4;
        AppMethodBeat.o(187474);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3990;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 10;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(187475);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.uri = "/cgi-bin/micromsg-bin/batchmodcontacttype";
        aVar.funcId = 3990;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.iLN = new kw();
        aVar.iLO = new kx();
        this.rr = aVar.aXF();
        kw kwVar = (kw) this.rr.iLK.iLR;
        kwVar.KON = new LinkedList<>();
        for (int i2 = 0; i2 < this.jct && this.aZK.size() > 0; i2++) {
            cpm cpm = new cpm();
            cpm.UserName = this.aZK.remove(0);
            cpm.MvC = this.type;
            cpm.MvD = this.op;
            kwVar.KON.add(cpm);
        }
        kwVar.KOM = kwVar.KON.size();
        if (this.type == 134217728 || this.type == 33554432) {
            kwVar.scene = 1;
        }
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(187475);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        int i5;
        AppMethodBeat.i(187476);
        Log.i("MicroMsg.NetSceneBatchModContactType", "errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            Iterator<cpn> it = ((kx) this.rr.iLL.iLR).KOP.iterator();
            i5 = 0;
            while (it.hasNext()) {
                cpn next = it.next();
                if (next.Ret == 0) {
                    com.tencent.mm.kernel.g.aAi();
                    as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(next.MvE.UserName);
                    if (Kn != null && com.tencent.mm.contact.c.oR(Kn.field_type)) {
                        switch (next.MvE.MvC) {
                            case TPMediaCodecProfileLevel.HEVCHighTierLevel61 /*{ENCODED_INT: 8388608}*/:
                                if (next.MvE.MvD == 1) {
                                    Kn.arh();
                                } else {
                                    Kn.ari();
                                }
                            case TPMediaCodecProfileLevel.HEVCHighTierLevel62 /*{ENCODED_INT: 33554432}*/:
                                if (next.MvE.MvD == 1) {
                                    Kn.arj();
                                } else {
                                    Kn.ark();
                                }
                            case 134217728:
                                if (next.MvE.MvD != 1) {
                                    Kn.arm();
                                    break;
                                } else {
                                    Kn.arl();
                                    break;
                                }
                        }
                        com.tencent.mm.kernel.g.aAi();
                        ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().c(Kn.field_username, Kn);
                        this.jcs.add(Kn.field_username);
                    }
                } else {
                    i5++;
                }
            }
            if (i5 == 0 && this.aZK.size() > 0) {
                if (doScene(dispatcher(), this.callback) < 0) {
                    Log.e("MicroMsg.NetSceneBatchModContactType", "onGYNetEnd : doScene fail");
                    this.callback.onSceneEnd(3, -1, "", this);
                }
                AppMethodBeat.o(187476);
                return;
            }
        } else {
            i5 = 0;
        }
        i iVar = this.callback;
        if (i5 > 0) {
            i4 = -3500;
        }
        iVar.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(187476);
    }

    public final List<String> bdH() {
        return this.jcs;
    }

    public final kx bdI() {
        return (kx) this.rr.iLL.iLR;
    }
}
