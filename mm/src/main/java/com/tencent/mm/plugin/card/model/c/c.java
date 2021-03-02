package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "pageNum", "", "pageSize", "scene", "", "(JJI)V", "Companion", "plugin-card_release"})
public final class c extends j<bly> {
    public static final a pVE = new a((byte) 0);

    static {
        AppMethodBeat.i(201385);
        AppMethodBeat.o(201385);
    }

    public c(long j2, long j3) {
        AppMethodBeat.i(201384);
        blx blx = new blx();
        bly bly = new bly();
        blx.LUF = j2;
        blx.LUG = j3;
        blx.scene = 1;
        a(blx, bly, 4796, "/cgi-bin/mmpay-bin/mktgetcouponandgiftlist");
        Log.i("MicroMsg.CgiGetCouponAndGiftList", "pageNum: " + j2 + ", pageSize: " + j3);
        AppMethodBeat.o(201384);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v4/CgiGetCouponAndGiftList$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
