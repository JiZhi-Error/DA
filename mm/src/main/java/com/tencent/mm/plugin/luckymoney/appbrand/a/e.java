package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dos;
import com.tencent.mm.protocal.protobuf.dot;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends a<dos, dot> {
    public e(dos dos) {
        this.yPr = dos;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final void eeD() {
        AppMethodBeat.i(64879);
        Log.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiStart ");
        AppMethodBeat.o(64879);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final void eeE() {
        AppMethodBeat.i(64880);
        Log.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiEnd ");
        AppMethodBeat.o(64880);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/requestwxaapphb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final int getFuncId() {
        return 2857;
    }

    /* Return type fixed from 'com.tencent.mm.protocal.protobuf.dpc' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final /* synthetic */ dot eeC() {
        AppMethodBeat.i(64881);
        dot dot = new dot();
        AppMethodBeat.o(64881);
        return dot;
    }
}
