package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.exu;
import com.tencent.mm.protocal.protobuf.exv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import java.util.Locale;

public final class b extends q implements m {
    private i heq;
    private d iIu;
    private exv nhv;

    public b() {
        AppMethodBeat.i(47749);
        d.a aVar = new d.a();
        aVar.iLN = new exu();
        aVar.iLO = new exv();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iIu = aVar.aXF();
        AppMethodBeat.o(47749);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1170;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(47750);
        Log.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.iIu, this);
        AppMethodBeat.o(47750);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(47751);
        Log.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.nhv = (exv) this.iIu.iLL.iLR;
        if (this.heq != null) {
            this.heq.onSceneEnd(i3, i4, str, this);
        }
        if (this.nhv.Nvb == null) {
            AppMethodBeat.o(47751);
            return;
        }
        ao azQ = com.tencent.mm.kernel.g.aAh().azQ();
        azQ.set(ar.a.USERINFO_WXA_SEARCH_INPUT_HINT_LANG_STRING_SYNC, Locale.getDefault().getLanguage());
        azQ.set(ar.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_STRING_SYNC, this.nhv.Nvb.xJH);
        azQ.set(ar.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, this.nhv.Nvb.Nve);
        azQ.set(ar.a.USERINFO_WXA_SEARCH_INPUT_HINT_UPDATE_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
        azQ.set(ar.a.USERINFO_WXA_SEARCH_FROM_DESKTOP_INPUT_HINT_CONTENT_STRING_SYNC, this.nhv.Nvc.xJH);
        azQ.set(ar.a.USERINFO_WXA_SEARCH_FROM_DESKTOP_MORE_INPUT_HINT_CONTENT_STRING_SYNC, this.nhv.Nvd.xJH);
        AppMethodBeat.o(47751);
    }
}
