package com.tencent.mm.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class b extends q implements m {
    private i heq;
    private a<b> hpe;
    private final d rr;

    public interface a<T extends q> {
        void a(int i2, int i3, String str, T t);
    }

    public b(String str, LinkedList<String> linkedList, int i2, int i3, int i4, a<b> aVar) {
        this(str, linkedList, i2, i3, i4);
        this.hpe = aVar;
    }

    public b(String str, LinkedList<String> linkedList, int i2, a<b> aVar) {
        this(str, linkedList, 0, i2, -1, aVar);
    }

    private b(String str, LinkedList<String> linkedList, int i2, int i3, int i4) {
        AppMethodBeat.i(150094);
        Log.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "NetSceneJSLogin doScene appId [%s], versionType [%d], opt [%d], extScene [%d]", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        d.a aVar = new d.a();
        aVar.iLN = new cem();
        aVar.iLO = new cen();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
        aVar.funcId = 1158;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cem cem = (cem) this.rr.iLK.iLR;
        if (i4 > 0) {
            cem.Mka = new fdg();
            cem.Mka.scene = i4;
        }
        cem.jfi = str;
        cem.MjX = linkedList;
        cem.MjZ = i2;
        cem.MjY = i3;
        AppMethodBeat.o(150094);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150095);
        Log.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.heq != null) {
            this.heq.onSceneEnd(i3, i4, str, this);
        }
        if (this.hpe != null) {
            this.hpe.a(i3, i4, str, this);
        }
        AppMethodBeat.o(150095);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1158;
    }

    public final cem ayJ() {
        if (this.rr == null) {
            return null;
        }
        return (cem) this.rr.iLK.iLR;
    }

    public final cen ayK() {
        return (cen) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150096);
        Log.i("MicroMsg.webview.NetSceneJSAuthorizeConfirm", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150096);
        return dispatch;
    }
}
