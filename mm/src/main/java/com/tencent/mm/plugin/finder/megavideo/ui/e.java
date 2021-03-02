package com.tencent.mm.plugin.finder.megavideo.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.megavideo.ui.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoSubTLViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLViewCallback;", "context", "Landroid/support/v7/app/AppCompatActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "parent", "Landroid/view/View;", "(Landroid/support/v7/app/AppCompatActivity;Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;Landroid/view/View;)V", "refreshWhenEnter", "", "plugin-finder_release"})
public final class e extends g {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(AppCompatActivity appCompatActivity, h.a aVar, View view) {
        super(appCompatActivity, aVar, view);
        p.h(appCompatActivity, "context");
        p.h(aVar, "presenter");
        p.h(view, "parent");
        AppMethodBeat.i(248531);
        AppMethodBeat.o(248531);
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.g
    public final boolean dct() {
        return false;
    }
}
