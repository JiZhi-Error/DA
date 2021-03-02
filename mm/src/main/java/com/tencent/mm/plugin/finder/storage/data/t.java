package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.azm;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B'\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/PageLbsSection;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", ch.COL_SOURCEFLAG, "lbsSection", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "(IJILcom/tencent/mm/protocal/protobuf/FinderNearbySection;)V", "extract", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class t extends s {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(aqq aqq) {
        super(aqq);
        p.h(aqq, "source");
        AppMethodBeat.i(252042);
        AppMethodBeat.o(252042);
    }

    public t(long j2, azm azm) {
        p.h(azm, "lbsSection");
        AppMethodBeat.i(252043);
        aqq aqq = this.vGD;
        aqq.id = j2;
        aqq.type = 0;
        aqq.LCD = new FinderObject();
        aqq.LCE = 1;
        aqq.LCF = azm;
        n nVar = n.vGA;
        aqq.dataType = 1;
        AppMethodBeat.o(252043);
    }

    @Override // com.tencent.mm.plugin.finder.storage.data.s
    public final bo dyH() {
        AppMethodBeat.i(252041);
        n nVar = n.vGA;
        c b2 = n.b(this.vGD);
        AppMethodBeat.o(252041);
        return b2;
    }
}
