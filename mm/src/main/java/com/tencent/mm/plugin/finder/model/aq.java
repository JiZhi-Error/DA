package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.awh;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderLotteryWinnerData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "winnerInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;)V", "getWinnerInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryContact;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class aq implements bo {
    public final awh uOC;

    public aq(awh awh) {
        p.h(awh, "winnerInfo");
        AppMethodBeat.i(248794);
        this.uOC = awh;
        AppMethodBeat.o(248794);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(248791);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(248791);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(248792);
        int hashCode = aq.class.hashCode();
        AppMethodBeat.o(248792);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        i iVar2;
        AppMethodBeat.i(248793);
        p.h(iVar, "obj");
        if (!(iVar instanceof awh)) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        awh awh = (awh) iVar2;
        if (awh == null || !p.j(awh.username, this.uOC.username) || !p.j(awh.nickname, this.uOC.nickname)) {
            AppMethodBeat.o(248793);
            return -1;
        }
        AppMethodBeat.o(248793);
        return 0;
    }
}
