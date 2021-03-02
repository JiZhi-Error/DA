package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ctm;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.protocal.protobuf.ekt;
import java.util.List;

public final class m extends q implements com.tencent.mm.network.m {
    public List<ekt> CFD;
    public long CFE;
    public float angle;
    private i callback;
    public int dEb;
    public d rr;

    public m(int i2, int i3, String str, String str2) {
        this(0, i2, i3, str, str2);
    }

    public m(int i2, int i3, int i4, String str, String str2) {
        AppMethodBeat.i(120856);
        d.a aVar = new d.a();
        ctm ctm = new ctm();
        ctm.Myo = i3;
        ctm.Myp = i4;
        ctm.Myt = str;
        ctm.Myu = str2;
        ctm.Scene = i2;
        aVar.iLN = ctm;
        aVar.iLO = new ctn();
        aVar.uri = "/cgi-bin/micromsg-bin/newocrtranslation";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.dEb = i3;
        AppMethodBeat.o(120856);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 294;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(120857);
        this.callback = iVar;
        this.CFE = System.currentTimeMillis();
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(120857);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(120858);
        this.angle = ((ctn) ((d) sVar).iLL.iLR).Myv;
        this.CFD = ((ctn) ((d) sVar).iLL.iLR).LWt;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(120858);
    }

    public final float getAngle() {
        return this.angle;
    }

    public final List<ekt> ePQ() {
        return this.CFD;
    }

    public final int getSessionId() {
        return this.dEb;
    }

    public final String ePR() {
        return ((ctn) this.rr.iLL.iLR).Myx;
    }

    public final long ePS() {
        return this.CFE;
    }
}
