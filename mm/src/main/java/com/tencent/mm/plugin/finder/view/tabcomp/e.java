package com.tencent.mm.plugin.finder.view.tabcomp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabViewAction;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "()V", "onTabClick", "", "context", "Landroid/content/Context;", "tab", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "onTabDoubleClick", "onTabSelected", "onTabUnSelected", "Companion", "plugin-finder_release"})
public class e implements f {
    private static final String TAG = TAG;
    public static final a wtE = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabViewAction$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(255312);
        AppMethodBeat.o(255312);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.f
    public void a(Context context, a aVar) {
        AppMethodBeat.i(255308);
        p.h(context, "context");
        p.h(aVar, "tab");
        Log.i(TAG, "onTabSelected : " + aVar.index);
        AppMethodBeat.o(255308);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.f
    public void b(Context context, a aVar) {
        AppMethodBeat.i(255309);
        p.h(context, "context");
        p.h(aVar, "tab");
        Log.i(TAG, "onTabUnSelected : " + aVar.index);
        AppMethodBeat.o(255309);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.f
    public final void c(Context context, a aVar) {
        AppMethodBeat.i(255310);
        p.h(context, "context");
        p.h(aVar, "tab");
        Log.i(TAG, "onTabClick : " + aVar.index);
        AppMethodBeat.o(255310);
    }

    @Override // com.tencent.mm.plugin.finder.view.tabcomp.f
    public final void d(Context context, a aVar) {
        AppMethodBeat.i(255311);
        p.h(context, "context");
        p.h(aVar, "tab");
        Log.i(TAG, "onTabConTabDoubleClicklick : " + aVar.index);
        AppMethodBeat.o(255311);
    }
}
