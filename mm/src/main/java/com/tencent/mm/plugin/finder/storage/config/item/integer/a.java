package com.tencent.mm.plugin.finder.storage.config.item.integer;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BS\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012<\b\u0002\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016RE\u0010\u0006\u001a6\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/item/integer/FinderIntConfig;", "Lcom/tencent/mm/plugin/finder/storage/config/FinderFakeConfig;", "", "defValue", "_title", "", "onClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Landroid/content/Context;", "context", "", "(ILjava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "onItemClick", FirebaseAnalytics.b.INDEX, "plugin-finder_release"})
public class a extends b<Integer> {
    private final m<Integer, Context, x> vFO;

    public /* synthetic */ a(int i2, String str) {
        this(i2, str, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.g.a.m<? super java.lang.Integer, ? super android.content.Context, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(int i2, String str, m<? super Integer, ? super Context, x> mVar) {
        super(Integer.valueOf(i2), str);
        p.h(str, "_title");
        AppMethodBeat.i(251944);
        this.vFO = mVar;
        AppMethodBeat.o(251944);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.g.a.m<java.lang.Integer, android.content.Context, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.finder.storage.config.b, com.tencent.mm.plugin.finder.storage.config.e
    public final void Lc(int i2) {
        AppMethodBeat.i(251943);
        super.Lc(i2);
        m<Integer, Context, x> mVar = this.vFO;
        if (mVar != 0) {
            mVar.invoke(value(), this.dKq);
            AppMethodBeat.o(251943);
            return;
        }
        AppMethodBeat.o(251943);
    }
}
