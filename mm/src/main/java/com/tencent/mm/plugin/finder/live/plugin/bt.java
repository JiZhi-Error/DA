package com.tencent.mm.plugin.finder.live.plugin;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.widget.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorExceptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "exceptionWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "initWidget", "", "anchorUserName", "showKickedMemberTip", "showPrivateCount", "plugin-finder_release"})
public final class bt extends d {
    public final String TAG = "Finder.LiveVisitorExceptionPlugin";
    final com.tencent.mm.live.c.b hOp;
    public f umS;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ok", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ bt uvf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(bt btVar) {
            super(1);
            this.uvf = btVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(247135);
            bool.booleanValue();
            b.C0376b.a(this.uvf.hOp, b.c.hLD);
            x xVar = x.SXb;
            AppMethodBeat.o(247135);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ok", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ bt uvf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(bt btVar) {
            super(1);
            this.uvf = btVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(247136);
            bool.booleanValue();
            b.C0376b.a(this.uvf.hOp, b.c.hLD);
            x xVar = x.SXb;
            AppMethodBeat.o(247136);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bt(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(247138);
        this.hOp = bVar;
        AppMethodBeat.o(247138);
    }

    public final void atI(String str) {
        AppMethodBeat.i(247137);
        if (this.umS == null) {
            this.umS = new f(this.hwr, str, getLiveData().uEu);
        }
        AppMethodBeat.o(247137);
    }
}
