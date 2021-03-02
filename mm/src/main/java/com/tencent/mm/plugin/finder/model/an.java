package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.awi;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderLotteryHistoryData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;)V", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class an implements bo {
    public final awi tWe;

    public an(awi awi) {
        p.h(awi, "lotteryInfo");
        AppMethodBeat.i(248783);
        this.tWe = awi;
        AppMethodBeat.o(248783);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(248780);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(248780);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(248781);
        int hashCode = an.class.hashCode();
        AppMethodBeat.o(248781);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        i iVar2;
        AppMethodBeat.i(248782);
        p.h(iVar, "obj");
        if (!(iVar instanceof an)) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        an anVar = (an) iVar2;
        if (anVar != null) {
            if (p.j(anVar.tWe.id, this.tWe.id)) {
                AppMethodBeat.o(248782);
                return 0;
            } else if (this.tWe.iqg > anVar.tWe.iqg) {
                AppMethodBeat.o(248782);
                return 1;
            }
        }
        AppMethodBeat.o(248782);
        return -1;
    }
}
