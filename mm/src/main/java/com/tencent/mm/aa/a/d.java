package com.tencent.mm.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.LinkedList;

public final class d extends q implements m {
    private i heq;
    private a<d> hpg;
    private final com.tencent.mm.ak.d rr;

    public interface a<T extends q> {
        void a(int i2, int i3, String str, T t);
    }

    public d(String str, LinkedList<String> linkedList, String str2, int i2, a<d> aVar) {
        this(str, linkedList, 0, str2, 0, i2, -1, aVar);
    }

    public d(String str, LinkedList<String> linkedList, int i2, String str2, int i3, int i4, int i5, a<d> aVar) {
        this(str, linkedList, i2, str2, i3, i4, i5);
        this.hpg = aVar;
    }

    private d(String str, LinkedList<String> linkedList, int i2, String str2, int i3, int i4, int i5) {
        AppMethodBeat.i(150100);
        Log.i("MicroMsg.webview.NetSceneJSLoginConfirm", "NetSceneJSLogin doScene appId [%s], login_type [%d], state [%s], versionType [%d], opt [%d], extScene [%d]", str, Integer.valueOf(i2), str2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        d.a aVar = new d.a();
        aVar.iLN = new ceq();
        aVar.iLO = new cer();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
        aVar.funcId = FaceManager.FACE_WITH_EYES_CLOSED;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ceq ceq = (ceq) this.rr.iLK.iLR;
        if (i5 > 0) {
            ceq.Mka = new fdg();
            ceq.Mka.scene = i5;
        }
        ceq.jfi = str;
        ceq.MjX = linkedList;
        ceq.Mkk = i2;
        ceq.Mkl = str2;
        ceq.MjZ = i3;
        ceq.MjY = i4;
        AppMethodBeat.o(150100);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150101);
        Log.i("MicroMsg.webview.NetSceneJSLoginConfirm", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.heq != null) {
            this.heq.onSceneEnd(i3, i4, str, this);
        }
        if (this.hpg != null) {
            this.hpg.a(i3, i4, str, this);
        }
        AppMethodBeat.o(150101);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return FaceManager.FACE_WITH_EYES_CLOSED;
    }

    public final ceq ayN() {
        if (this.rr == null) {
            return null;
        }
        return (ceq) this.rr.iLK.iLR;
    }

    public final cer ayO() {
        return (cer) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150102);
        Log.i("MicroMsg.webview.NetSceneJSLoginConfirm", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150102);
        return dispatch;
    }
}
