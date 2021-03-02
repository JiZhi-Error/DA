package com.tencent.mm.plugin.finder.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0019\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderHistoryDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "divider", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;)V", "getDivider", "()Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "id", "", "getId", "()J", "id$delegate", "Lkotlin/Lazy;", "tip", "Landroid/text/SpannableString;", "kotlin.jvm.PlatformType", "getTip", "()Landroid/text/SpannableString;", "tipStyle", "", "getTipStyle", "()I", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"})
public final class ai implements bo {
    private final f tON = g.ah(new a(this));
    final bcw tOP;
    public final SpannableString uOt = com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), this.tOP.dQx);
    public final int uOu = this.tOP.LLE;

    public ai(bcw bcw) {
        p.h(bcw, "divider");
        AppMethodBeat.i(248766);
        this.tOP = bcw;
        AppMethodBeat.o(248766);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 2011;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(248764);
        p.h(iVar, "obj");
        if (!(iVar instanceof ai) || ((ai) iVar).tOP.uOx != this.tOP.uOx || ((ai) iVar).tOP.LLE != this.tOP.LLE || !p.j(((ai) iVar).tOP.dQx, this.tOP.dQx)) {
            AppMethodBeat.o(248764);
            return -1;
        }
        AppMethodBeat.o(248764);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(248765);
        String str = "ItemId=" + lT() + ",ItemType=2011 tipStyle=" + this.uOu + " tip=" + ((Object) this.uOt);
        AppMethodBeat.o(248765);
        return str;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(248763);
        long longValue = ((Number) this.tON.getValue()).longValue();
        AppMethodBeat.o(248763);
        return longValue;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Long> {
        final /* synthetic */ ai uOv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ai aiVar) {
            super(0);
            this.uOv = aiVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(248762);
            Long valueOf = Long.valueOf((long) MD5Util.getMD5String("FinderHistoryButtonDivider" + this.uOv.tOP.uOx).hashCode());
            AppMethodBeat.o(248762);
            return valueOf;
        }
    }
}
