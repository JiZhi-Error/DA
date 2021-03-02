package com.tencent.mm.plugin.finder.storage.config.item.longtype;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/item/longtype/FinderLongConfig;", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "defValue", "_title", "", "(JLjava/lang/String;)V", "javaClass", "Ljava/lang/Class;", "plugin-finder_release"})
public final class a extends b<Long> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(long j2, String str) {
        super(Long.valueOf(1 * j2), str);
        p.h(str, "_title");
        AppMethodBeat.i(251945);
        AppMethodBeat.o(251945);
    }
}
