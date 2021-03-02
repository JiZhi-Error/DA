package com.tencent.mm.plugin.finder.convert;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ@\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "type", "isHotPatch", "payloads", "", "", "plugin-finder_release"})
public class ai extends u {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.plugin.finder.convert.u
    public /* bridge */ /* synthetic */ void a(h hVar, u uVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(165421);
        a(hVar, uVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(165421);
    }

    @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.u
    public /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(165420);
        a(hVar, (u) aVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(165420);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ai(i iVar, boolean z, int i2, int i3) {
        this(iVar, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? 0 : i2);
        AppMethodBeat.i(243108);
        AppMethodBeat.o(243108);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ai(i iVar, boolean z, int i2) {
        super(iVar, z, i2);
        p.h(iVar, "contract");
        AppMethodBeat.i(165422);
        AppMethodBeat.o(165422);
    }

    @Override // com.tencent.mm.plugin.finder.convert.u
    public void a(h hVar, u uVar, int i2, int i3, boolean z, List<Object> list) {
        AppMethodBeat.i(165419);
        p.h(hVar, "holder");
        p.h(uVar, "item");
        super.a(hVar, uVar, i2, i3, z, list);
        hVar.aus.setOnLongClickListener(new a(uVar));
        AppMethodBeat.o(165419);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class a implements View.OnLongClickListener {
        final /* synthetic */ u tDY;

        a(u uVar) {
            this.tDY = uVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(165418);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            Log.i("Finder.FeedConvert", "text=" + this.tDY.feedObject.getDescription());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert$onBindViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(165418);
            return true;
        }
    }
}
