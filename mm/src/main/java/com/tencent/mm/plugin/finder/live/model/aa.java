package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.fgn;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveLuckyMoneySendMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getPayLoadContent", "", "plugin-finder_release"})
public final class aa extends c {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aa(aut aut) {
        super(aut);
        p.h(aut, "msg");
        AppMethodBeat.i(260457);
        AppMethodBeat.o(260457);
    }

    @Override // com.tencent.mm.plugin.finder.live.model.t
    public final Object dft() {
        byte[] bArr = null;
        AppMethodBeat.i(260456);
        switch (this.uio.ybm) {
            case 20019:
                fgn fgn = new fgn();
                b bVar = this.uio.LFB;
                if (bVar != null) {
                    bArr = bVar.toByteArray();
                }
                fgn.parseFrom(bArr);
                AppMethodBeat.o(260456);
                return fgn;
            default:
                AppMethodBeat.o(260456);
                return null;
        }
    }
}
