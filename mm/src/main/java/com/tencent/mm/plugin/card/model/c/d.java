package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v4/CgiGetMemberCardHistoryRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "pageNum", "", "pageSize", "(JJ)V", "Companion", "plugin-card_release"})
public final class d extends j<bqi> {
    public static final a pVF = new a((byte) 0);

    static {
        AppMethodBeat.i(201387);
        AppMethodBeat.o(201387);
    }

    public d(long j2, long j3) {
        AppMethodBeat.i(201386);
        bqh bqh = new bqh();
        bqi bqi = new bqi();
        bqh.LUF = j2;
        bqh.LUG = j3;
        a(bqh, bqi, 4406, "/cgi-bin/mmpay-bin/mktgetmembercardhistory");
        Log.i("MicroMsg.CgiGetMemberCardHistoryRequest", "pageNum: " + j2 + ", pageSize: " + j3);
        AppMethodBeat.o(201386);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/card/model/v4/CgiGetMemberCardHistoryRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
