package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.protocal.protobuf.dkk;

public final class d extends a<dkj, dkk> {
    public d(String str, String str2) {
        AppMethodBeat.i(64877);
        dkj dkj = new dkj();
        dkj.dNI = str;
        dkj.MBB = str2;
        this.yPr = dkj;
        AppMethodBeat.o(64877);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/receivewxaapphb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final int getFuncId() {
        return 1828;
    }

    /* Return type fixed from 'com.tencent.mm.protocal.protobuf.dpc' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final /* synthetic */ dkk eeC() {
        AppMethodBeat.i(64878);
        dkk dkk = new dkk();
        AppMethodBeat.o(64878);
        return dkk;
    }
}
