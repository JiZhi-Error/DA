package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.axt;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveLocationMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveTextMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "loc", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "getLoc", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "setLoc", "(Lcom/tencent/mm/protocal/protobuf/FinderLocation;)V", "plugin-finder_release"})
public final class y extends r {
    public axt UKp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(awq awq, axt axt) {
        super(awq);
        p.h(awq, "msg");
        p.h(axt, "loc");
        AppMethodBeat.i(260453);
        this.UKp = axt;
        AppMethodBeat.o(260453);
    }
}
