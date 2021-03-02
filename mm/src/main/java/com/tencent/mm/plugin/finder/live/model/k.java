package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avc;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRewardRankingMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getPayLoadContent", "", "plugin-finder_release"})
public final class k extends c {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(aut aut) {
        super(aut);
        p.h(aut, "msg");
        AppMethodBeat.i(246176);
        AppMethodBeat.o(246176);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final Object dft() {
        byte[] bArr = null;
        AppMethodBeat.i(246175);
        switch (this.uio.ybm) {
            case 20014:
                avc avc = new avc();
                b bVar = this.uio.LFB;
                if (bVar != null) {
                    bArr = bVar.toByteArray();
                }
                avc.parseFrom(bArr);
                AppMethodBeat.o(246175);
                return avc;
            default:
                AppMethodBeat.o(246175);
                return null;
        }
    }
}
