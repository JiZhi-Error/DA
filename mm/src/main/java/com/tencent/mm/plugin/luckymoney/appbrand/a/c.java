package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dim;
import com.tencent.mm.protocal.protobuf.din;

public final class c extends a<dim, din> {
    public c(String str, String str2, int i2) {
        AppMethodBeat.i(64875);
        dim dim = new dim();
        dim.dNI = str;
        dim.MBB = str2;
        dim.offset = i2;
        this.yPr = dim;
        AppMethodBeat.o(64875);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/querywxaapphbdetail";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final int getFuncId() {
        return 2949;
    }

    /* Return type fixed from 'com.tencent.mm.protocal.protobuf.dpc' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a.a
    public final /* synthetic */ din eeC() {
        AppMethodBeat.i(64876);
        din din = new din();
        AppMethodBeat.o(64876);
        return din;
    }
}
