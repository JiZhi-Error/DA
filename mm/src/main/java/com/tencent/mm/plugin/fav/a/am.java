package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpt;
import com.tencent.mm.protocal.protobuf.cpu;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;

public final class am extends q implements m {
    private i callback;
    private final d rr;
    private int scene;
    public int tbB;
    public f tbC;
    private LinkedList<cpv> tbD;
    private LinkedList<cps> tbE;
    public String tbF;
    public int type;

    private am(int i2, LinkedList<cps> linkedList, LinkedList<cpv> linkedList2, int i3) {
        AppMethodBeat.i(103483);
        this.callback = null;
        d.a aVar = new d.a();
        aVar.iLN = new cpt();
        aVar.iLO = new cpu();
        aVar.uri = "/cgi-bin/micromsg-bin/modfavitem";
        aVar.funcId = v2helper.EMethodSetAgcRxOn;
        aVar.iLP = 216;
        aVar.respCmdId = 1000000216;
        this.rr = aVar.aXF();
        this.tbD = linkedList2;
        this.tbE = linkedList;
        this.tbB = i2;
        this.type = i3;
        AppMethodBeat.o(103483);
    }

    public am(int i2, LinkedList<cps> linkedList, LinkedList<cpv> linkedList2) {
        this(i2, linkedList, linkedList2, 0);
    }

    public am(int i2, f fVar) {
        this(i2, fVar.field_modItem.tbE, fVar.field_modItem.LxK, 1);
        this.tbC = fVar;
    }

    public am(int i2, LinkedList<cps> linkedList, LinkedList<cpv> linkedList2, String str) {
        this(i2, linkedList, linkedList2, 0);
        this.tbF = str;
    }

    public am(int i2, LinkedList<cps> linkedList, LinkedList<cpv> linkedList2, String str, byte b2) {
        this(i2, linkedList, linkedList2, 0);
        this.tbF = str;
        this.scene = 1;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103484);
        if (this.scene == 0 && (this.tbE == null || this.tbE.size() == 0)) {
            AppMethodBeat.o(103484);
            return -1;
        }
        cpt cpt = (cpt) this.rr.iLK.iLR;
        cpt.MvK = this.tbE.size();
        if (this.tbD != null) {
            cpt.MvM = this.tbD.size();
            cpt.KOH = this.tbD;
        } else {
            cpt.MvM = 0;
            cpt.KOH = new LinkedList<>();
        }
        if (!Util.isNullOrNil(this.tbF)) {
            cpt.MvN = this.tbF;
        }
        cpt.MvK = this.tbE.size();
        cpt.MvL = this.tbE;
        cpt.KGZ = this.tbB;
        cpt.Scene = this.scene;
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103484);
        return dispatch;
    }

    public final long cVe() {
        if (this.tbC == null) {
            return -1;
        }
        return this.tbC.field_localId;
    }

    public final int cVf() {
        if (this.tbC == null) {
            return -1;
        }
        return this.tbC.field_type;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103485);
        Log.d("MicroMsg.Fav.NetSceneModFavItem", "favId: " + this.tbB + ", netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        b.d(((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ((long) this.tbB));
        AppMethodBeat.o(103485);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return v2helper.EMethodSetAgcRxOn;
    }
}
