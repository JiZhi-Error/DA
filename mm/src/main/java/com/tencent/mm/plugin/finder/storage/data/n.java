package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.w;
import com.tencent.mm.plugin.finder.model.c;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.azm;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/LbsSectionOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "targetDataType", "plugin-finder_release"})
public final class n {
    public static final n vGA = new n();

    static {
        AppMethodBeat.i(252026);
        AppMethodBeat.o(252026);
    }

    private n() {
    }

    public static c b(aqq aqq) {
        boolean z = true;
        AppMethodBeat.i(252025);
        p.h(aqq, "data");
        if (aqq.dataType != 1) {
            z = false;
        }
        if (z) {
            azm azm = aqq.LCF;
            if (azm != null) {
                w wVar = w.tOM;
                p.g(azm, LocaleUtil.ITALIAN);
                c a2 = w.a(azm);
                AppMethodBeat.o(252025);
                return a2;
            }
            AppMethodBeat.o(252025);
            return null;
        }
        AppMethodBeat.o(252025);
        return null;
    }
}
