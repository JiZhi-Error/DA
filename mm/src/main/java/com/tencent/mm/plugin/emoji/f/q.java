package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tavkit.component.TAVExporter;
import java.util.ArrayList;
import java.util.Iterator;

public final class q extends com.tencent.mm.ak.q implements m {
    private i callback;
    private int mScene;
    public byte[] rcY;
    private int rdk;
    private final d rr;

    public q(int i2, byte[] bArr) {
        this(i2, bArr, (byte) 0);
    }

    private q(int i2, byte[] bArr, byte b2) {
        AppMethodBeat.i(108715);
        this.rcY = null;
        d.a aVar = new d.a();
        aVar.iLN = new bso();
        aVar.iLO = new bsp();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
        aVar.funcId = TAVExporter.VIDEO_EXPORT_WIDTH;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.rdk = i2;
        this.rcY = bArr;
        this.mScene = 0;
        AppMethodBeat.o(108715);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108716);
        Log.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        bsp bsp = (bsp) ((d) sVar).iLL.iLR;
        if (bsp.ReqBuf != null) {
            this.rcY = z.a(bsp.ReqBuf);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108716);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TAVExporter.VIDEO_EXPORT_WIDTH;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(108717);
        this.callback = iVar;
        bso bso = (bso) this.rr.iLK.iLR;
        bso.DesignerUin = this.rdk;
        if (this.rcY != null) {
            bso.ReqBuf = z.aC(this.rcY);
        } else {
            bso.ReqBuf = new SKBuiltinBuffer_t();
        }
        bso.Scene = this.mScene;
        Log.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", bso.ReqBuf == null ? "Buf is NULL" : bso.ReqBuf.toString());
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108717);
        return dispatch;
    }

    public final bsp cGA() {
        if (this.rr == null) {
            return null;
        }
        return (bsp) this.rr.iLL.iLR;
    }

    public static com.tencent.mm.plugin.emoji.model.g a(bsp bsp) {
        AppMethodBeat.i(108718);
        Log.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
        if (bsp == null) {
            AppMethodBeat.o(108718);
            return null;
        }
        com.tencent.mm.plugin.emoji.model.g gVar = new com.tencent.mm.plugin.emoji.model.g();
        if (!(bsp == null || bsp.EmotionList == null)) {
            gVar.rbs = bsp.EmotionList.size();
            ArrayList arrayList = new ArrayList();
            Iterator<EmotionSummary> it = bsp.EmotionList.iterator();
            while (it.hasNext()) {
                EmotionSummary next = it.next();
                if (next.ProductID != null) {
                    arrayList.add(new f(next));
                }
            }
            gVar.rbt = arrayList;
        }
        AppMethodBeat.o(108718);
        return gVar;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 100;
    }
}
