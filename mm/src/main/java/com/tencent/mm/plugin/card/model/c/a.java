package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.agm;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0006B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v4/CgiDeleteCouponRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteCouponResponse;", "cardId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class a extends j<ago> {
    public static final C0906a pVC = new C0906a((byte) 0);

    static {
        AppMethodBeat.i(201381);
        AppMethodBeat.o(201381);
    }

    public a(String str) {
        p.h(str, "cardId");
        AppMethodBeat.i(201380);
        agm agm = new agm();
        ago ago = new ago();
        agm.KDM = str;
        a(agm, ago, 5027, "/cgi-bin/mmpay-bin/mktdeletecoupon");
        Log.i("MicroMsg.CgiDeleteCouponRequest", "cardid: %s", str);
        AppMethodBeat.o(201380);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v4/CgiDeleteCouponRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.c.a$a  reason: collision with other inner class name */
    public static final class C0906a {
        private C0906a() {
        }

        public /* synthetic */ C0906a(byte b2) {
            this();
        }
    }
}
