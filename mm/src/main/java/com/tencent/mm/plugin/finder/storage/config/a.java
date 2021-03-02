package com.tencent.mm.plugin.finder.storage.config;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/FinderEmptyConfig;", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "title", "(Ljava/lang/String;)V", "onItemClick", "", FirebaseAnalytics.b.INDEX, "", "reset", "value", "plugin-finder_release"})
public final class a extends b<String> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(String str) {
        super("", str);
        p.h(str, "title");
        AppMethodBeat.i(251903);
        AppMethodBeat.o(251903);
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.b, com.tencent.mm.plugin.finder.storage.config.e
    public final void Lc(int i2) {
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.b
    public final void reset() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.finder.storage.config.b
    public final /* bridge */ /* synthetic */ String value() {
        return this.title;
    }
}
