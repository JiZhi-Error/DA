package com.tencent.mm.plugin.finder.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedPlainTextConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedPlainText;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "plugin-finder_release"})
public class ad extends l<ab> {
    private final i tAi;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int] */
    @Override // com.tencent.mm.plugin.finder.convert.l
    public final /* synthetic */ void a(h hVar, ab abVar, int i2) {
        AppMethodBeat.i(243082);
        p.h(hVar, "holder");
        p.h(abVar, "item");
        AppMethodBeat.o(243082);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ad(i iVar, boolean z, int i2, int i3) {
        this(iVar, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? 0 : i2);
        AppMethodBeat.i(243083);
        AppMethodBeat.o(243083);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ad(i iVar, boolean z, int i2) {
        super(iVar, z, i2);
        p.h(iVar, "contract");
        AppMethodBeat.i(165412);
        this.tAi = iVar;
        AppMethodBeat.o(165412);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.x;
    }
}
