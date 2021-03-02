package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqq;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B'\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/PageFinderItem;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "id", "", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", ch.COL_SOURCEFLAG, "(IJLcom/tencent/mm/protocal/protobuf/FinderObject;I)V", "extract", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class r extends s {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(aqq aqq) {
        super(aqq);
        p.h(aqq, "source");
        AppMethodBeat.i(252039);
        AppMethodBeat.o(252039);
    }

    public r(int i2, long j2, FinderObject finderObject, int i3) {
        p.h(finderObject, ch.COL_FINDEROBJECT);
        AppMethodBeat.i(252040);
        aqq aqq = this.vGD;
        aqq.id = j2;
        aqq.type = i2;
        aqq.LCD = finderObject;
        aqq.LCE = i3;
        i iVar = i.vGl;
        aqq.dataType = 0;
        AppMethodBeat.o(252040);
    }

    @Override // com.tencent.mm.plugin.finder.storage.data.s
    public final bo dyH() {
        AppMethodBeat.i(252038);
        int i2 = this.vGD.dataType;
        i iVar = i.vGl;
        if (i2 == 0) {
            i iVar2 = i.vGl;
            FinderItem a2 = i.a(this.vGD);
            if (a2 != null) {
                k kVar = k.vGq;
                bo o = k.o(a2);
                AppMethodBeat.o(252038);
                return o;
            }
            AppMethodBeat.o(252038);
            return null;
        }
        AppMethodBeat.o(252038);
        return null;
    }
}
