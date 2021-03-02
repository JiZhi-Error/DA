package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/emoji/model/CgiGetEmotionDetail;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "productId", "", "(Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "plugin-emojisdk_release"})
public final class d extends c<GetEmotionDetailResponse> {
    private final String productId;

    public d(String str) {
        p.h(str, "productId");
        AppMethodBeat.i(183954);
        this.productId = str;
        GetEmotionDetailRequest getEmotionDetailRequest = new GetEmotionDetailRequest();
        GetEmotionDetailResponse getEmotionDetailResponse = new GetEmotionDetailResponse();
        getEmotionDetailRequest.ProductID = this.productId;
        getEmotionDetailRequest.Version = -1;
        getEmotionDetailRequest.Scene = 3;
        d.a aVar = new d.a();
        aVar.c(getEmotionDetailRequest);
        aVar.d(getEmotionDetailResponse);
        aVar.MB("/cgi-bin/micromsg-bin/getemotiondetail");
        aVar.sG(412);
        c(aVar.aXF());
        AppMethodBeat.o(183954);
    }
}
