package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqq;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B'\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/PageMegaVideoItem;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", ch.COL_SOURCEFLAG, "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(IJILcom/tencent/mm/protocal/protobuf/FinderObject;)V", "extract", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "targetDataType", "toRVFeed", "plugin-finder_release"})
public final class u extends s {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(aqq aqq) {
        super(aqq);
        p.h(aqq, "source");
        AppMethodBeat.i(252045);
        AppMethodBeat.o(252045);
    }

    public u(long j2, int i2, FinderObject finderObject) {
        p.h(finderObject, "feedObject");
        AppMethodBeat.i(252046);
        aqq aqq = this.vGD;
        aqq.id = j2;
        aqq.type = 0;
        aqq.LCD = finderObject;
        aqq.LCE = i2;
        p pVar = p.vGB;
        aqq.dataType = 2;
        aqq.LCG = null;
        AppMethodBeat.o(252046);
    }

    @Override // com.tencent.mm.plugin.finder.storage.data.s
    public final /* synthetic */ bo dyH() {
        boolean z;
        bm bmVar;
        AppMethodBeat.i(252044);
        p pVar = p.vGB;
        aqq aqq = this.vGD;
        p.h(aqq, "data");
        if (aqq.dataType == 2) {
            z = true;
        } else {
            z = false;
        }
        if (!z || aqq.LCD == null || aqq.LCG != null) {
            bmVar = null;
        } else {
            FinderObject finderObject = aqq.LCD;
            if (finderObject == null) {
                p.hyc();
            }
            p.g(finderObject, "data.`object`!!");
            bmVar = new bm(finderObject);
        }
        bm bmVar2 = bmVar;
        AppMethodBeat.o(252044);
        return bmVar2;
    }
}
