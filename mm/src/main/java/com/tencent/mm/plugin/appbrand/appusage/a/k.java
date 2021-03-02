package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dko;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appusage/recommend/MockData;", "", "()V", "fakeRecommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "getFakeRecommendCard", "()Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "setFakeRecommendCard", "(Lcom/tencent/mm/protocal/protobuf/RecommendCard;)V", "copyMockData", "", "mockData", "mock", "Ljava/util/LinkedList;", "pageNum", "", "plugin-appbrand-integration_release"})
public final class k {
    dko kXH = new dko();

    public k() {
        AppMethodBeat.i(50332);
        AppMethodBeat.o(50332);
    }

    /* access modifiers changed from: package-private */
    public final void a(dko dko) {
        dko.gTT = this.kXH.gTT;
        dko.nHd = this.kXH.nHd;
        dko.nHf = this.kXH.nHf;
        dko.MOw = this.kXH.MOw;
        dko.qGI = "####客户端mock数据####商品";
        dko.nHg = this.kXH.nHg;
        dko.MOy = this.kXH.MOy;
        dko.MOx = this.kXH.MOx;
        dko.MOu = this.kXH.MOu;
        dko.score = this.kXH.score;
        dko.nHh = this.kXH.nHh;
        dko.MOz = this.kXH.MOz;
    }
}
