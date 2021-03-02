package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "tipStr", "", "type", "", "tabType", "(Ljava/lang/CharSequence;II)V", "callback", "Lkotlin/Function0;", "", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "nearbyLiveSquareTabType", "getNearbyLiveSquareTabType", "()I", "setNearbyLiveSquareTabType", "(I)V", "getTabType", "setTabType", "getTipStr", "()Ljava/lang/CharSequence;", "setTipStr", "(Ljava/lang/CharSequence;)V", "getType", "setType", "compare", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class g extends g.b implements i {
    public int dLS;
    public int type;
    public a<x> uGD;
    public int uNP;
    public CharSequence uNQ;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ g() {
        /*
            r3 = this;
            r2 = 166370(0x289e2, float:2.33134E-40)
            android.content.Context r0 = com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()
            java.lang.String r1 = "MMApplicationContext.getContext()"
            kotlin.g.b.p.g(r0, r1)
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131760645(0x7f101605, float:1.9152316E38)
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r1 = "MMApplicationContext.get…ng.finder_touch_to_retry)"
            kotlin.g.b.p.g(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.<init>(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.model.g.<init>():void");
    }

    private g(CharSequence charSequence) {
        p.h(charSequence, "tipStr");
        AppMethodBeat.i(166369);
        this.uNQ = charSequence;
        this.type = 0;
        this.dLS = 0;
        AppMethodBeat.o(166369);
    }

    public final void P(CharSequence charSequence) {
        AppMethodBeat.i(248709);
        p.h(charSequence, "<set-?>");
        this.uNQ = charSequence;
        AppMethodBeat.o(248709);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(166367);
        p.h(iVar, "obj");
        AppMethodBeat.o(166367);
        return 0;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(261246);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(261246);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return -1;
    }
}
