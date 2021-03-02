package com.tencent.mm.emoji.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackRequest;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackResponse;
import com.tencent.wxmm.v2helper;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/emoji/model/cgi/CgiExchangeEmotionPack;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ExchangeEmotionPackResponse;", "groupId", "", "scene", "", "(Ljava/lang/String;I)V", "Companion", "plugin-emojisdk_release"})
public final class a extends c<ExchangeEmotionPackResponse> {
    public static final C0320a gXU = new C0320a((byte) 0);

    static {
        AppMethodBeat.i(199915);
        AppMethodBeat.o(199915);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/emoji/model/cgi/CgiExchangeEmotionPack$Companion;", "", "()V", "MM_EXCHANGE_EMOTION_PACK", "", "MM_EXCHANGE_EMOTION_PIECE", "NOT_PAY_PRODUCT", "NOT_VALID_AREA", "NOT_VALID_WEAR", "NO_SUCH_PRODUCT", "PRODUCT_EXPIRED", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.b.a.a$a  reason: collision with other inner class name */
    public static final class C0320a {
        private C0320a() {
        }

        public /* synthetic */ C0320a(byte b2) {
            this();
        }
    }

    public a(String str) {
        p.h(str, "groupId");
        AppMethodBeat.i(199914);
        ExchangeEmotionPackRequest exchangeEmotionPackRequest = new ExchangeEmotionPackRequest();
        ExchangeEmotionPackResponse exchangeEmotionPackResponse = new ExchangeEmotionPackResponse();
        exchangeEmotionPackRequest.IsAutomatic = 1;
        exchangeEmotionPackRequest.ProductID = str;
        exchangeEmotionPackRequest.Scene = 1;
        exchangeEmotionPackRequest.SeriesID = null;
        d.a aVar = new d.a();
        aVar.c(exchangeEmotionPackRequest);
        aVar.d(exchangeEmotionPackResponse);
        aVar.MB("/cgi-bin/micromsg-bin/exchangeemotionpack");
        aVar.sG(v2helper.EMethodSetNgStrength);
        aVar.sI(213);
        aVar.sJ(1000000213);
        c(aVar.aXF());
        AppMethodBeat.o(199914);
    }
}
