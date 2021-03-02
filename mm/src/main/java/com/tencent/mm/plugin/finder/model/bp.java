package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.protocal.protobuf.ays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/RVFeedUtil;", "", "()V", "genBaseLocalFeed", "Lcom/tencent/mm/plugin/finder/model/BaseLocalFeed;", "localType", "", "genLocalItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixLocalItem;", "wording", "", "plugin-finder_release"})
public final class bp {
    public static final bp uOZ = new bp();

    static {
        AppMethodBeat.i(248870);
        AppMethodBeat.o(248870);
    }

    private bp() {
    }

    public static b Ju(int i2) {
        AppMethodBeat.i(248869);
        p.h("", "wording");
        ays ays = new ays();
        ays.LIS = i2;
        ays.dQx = "";
        b bVar = new b(new aa(ays));
        AppMethodBeat.o(248869);
        return bVar;
    }
}
