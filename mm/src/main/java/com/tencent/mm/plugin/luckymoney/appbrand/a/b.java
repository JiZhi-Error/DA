package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends a<cxf, cxg> {
    public b(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(64871);
        cxf cxf = new cxf();
        cxf.dNI = str;
        cxf.MBB = str2;
        cxf.MBC = com.tencent.mm.bw.b.cD(bArr);
        this.yPr = cxf;
        AppMethodBeat.o(64871);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final void eeD() {
        AppMethodBeat.i(64872);
        Log.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiStart ");
        AppMethodBeat.o(64872);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final void eeE() {
        AppMethodBeat.i(64873);
        Log.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiEnd ");
        AppMethodBeat.o(64873);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/openwxaapphb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final int getFuncId() {
        return 2701;
    }

    /* Return type fixed from 'com.tencent.mm.protocal.protobuf.dpc' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final /* synthetic */ cxg eeC() {
        AppMethodBeat.i(64874);
        cxg cxg = new cxg();
        AppMethodBeat.o(64874);
        return cxg;
    }
}
