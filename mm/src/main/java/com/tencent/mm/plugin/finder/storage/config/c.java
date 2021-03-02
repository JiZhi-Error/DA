package com.tencent.mm.plugin.finder.storage.config;

import android.app.Activity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u001f\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/FinderSimpleClickConfig;", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "title", "onClick", "Lkotlin/Function1;", "Landroid/app/Activity;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "onItemClick", FirebaseAnalytics.b.INDEX, "", "reset", "value", "plugin-finder_release"})
public final class c extends b<String> {
    private final b<Activity, x> uzi;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.b<? super android.app.Activity, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(String str, b<? super Activity, x> bVar) {
        super("", str);
        p.h(str, "title");
        p.h(bVar, "onClick");
        AppMethodBeat.i(251924);
        this.uzi = bVar;
        AppMethodBeat.o(251924);
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.b, com.tencent.mm.plugin.finder.storage.config.e
    public final void Lc(int i2) {
        AppMethodBeat.i(251923);
        this.uzi.invoke(this.dKq);
        AppMethodBeat.o(251923);
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.b
    public final void reset() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.finder.storage.config.b
    public final /* bridge */ /* synthetic */ String value() {
        return "";
    }
}
