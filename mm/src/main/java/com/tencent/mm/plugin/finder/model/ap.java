package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.awj;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderLotteryRecordData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lotteryRecord", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;)V", "getLotteryRecord", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class ap implements bo {
    public final awj uOB;

    public ap(awj awj) {
        p.h(awj, "lotteryRecord");
        AppMethodBeat.i(248790);
        this.uOB = awj;
        AppMethodBeat.o(248790);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(248787);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(248787);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(248788);
        int hashCode = ap.class.hashCode();
        AppMethodBeat.o(248788);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        i iVar2;
        AppMethodBeat.i(248789);
        p.h(iVar, "obj");
        if (!(iVar instanceof ap)) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        ap apVar = (ap) iVar2;
        if (apVar != null) {
            if (apVar.uOB.liveId == this.uOB.liveId && apVar.uOB.hFK == this.uOB.hFK && p.j(apVar.uOB.objectNonceId, this.uOB.objectNonceId)) {
                AppMethodBeat.o(248789);
                return 0;
            } else if (this.uOB.LHd > apVar.uOB.LHd) {
                AppMethodBeat.o(248789);
                return 1;
            }
        }
        AppMethodBeat.o(248789);
        return -1;
    }
}
