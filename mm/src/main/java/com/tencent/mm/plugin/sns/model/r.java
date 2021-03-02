package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.eac;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.Vector;

public final class r extends q implements m {
    public static List<Long> DIc = new Vector();
    public boolean DIr = false;
    public h DIs = null;
    public i callback;
    private long ece;
    public d rr;

    static {
        AppMethodBeat.i(95600);
        AppMethodBeat.o(95600);
    }

    public static boolean Jk(long j2) {
        AppMethodBeat.i(95595);
        if (DIc.contains(Long.valueOf(j2))) {
            AppMethodBeat.o(95595);
            return false;
        }
        DIc.add(Long.valueOf(j2));
        AppMethodBeat.o(95595);
        return true;
    }

    private static boolean Jj(long j2) {
        AppMethodBeat.i(95596);
        DIc.remove(Long.valueOf(j2));
        AppMethodBeat.o(95596);
        return true;
    }

    public r(long j2) {
        AppMethodBeat.i(95597);
        this.ece = j2;
        d.a aVar = new d.a();
        aVar.iLN = new eac();
        aVar.iLO = new ead();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
        aVar.funcId = 210;
        aVar.iLP = 101;
        aVar.respCmdId = 1000000101;
        this.rr = aVar.aXF();
        ((eac) this.rr.iLK.iLR).Id = j2;
        Log.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId ".concat(String.valueOf(j2)));
        AppMethodBeat.o(95597);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(95598);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95598);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 210;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(95599);
        if (i3 == 0 && i4 == 0) {
            SnsObject snsObject = ((ead) this.rr.iLL.iLR).MZy;
            if (snsObject != null) {
                Log.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + z.b(snsObject.ObjectDesc));
            }
            an.e(snsObject);
            this.callback.onSceneEnd(i3, i4, str, this);
            Jj(this.ece);
            AppMethodBeat.o(95599);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        Jj(this.ece);
        AppMethodBeat.o(95599);
    }
}
