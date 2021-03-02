package com.tencent.mm.plugin.finder.megavideo.ui;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.megavideo.ui.OverScrollVerticalBehavior;
import com.tencent.mm.plugin.finder.megavideo.ui.h;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u0013\u001a\u00020\u00142\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u0016\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "context", "Landroid/support/v7/app/AppCompatActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "parent", "Landroid/view/View;", "(Landroid/support/v7/app/AppCompatActivity;Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;Landroid/view/View;)V", "recyclerView", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollRecyclerView;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRootView", "getViewActionCallback", "", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBackPressed", "", "onViewPrepared", "refreshWhenEnter", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
public class g implements h.b {
    private OverScrollRecyclerView USr;
    private final View hVd;
    private final AppCompatActivity uMk;
    final h.a uMy;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "pos", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLViewCallback$initView$snapHelper$1$1"})
    static final class a extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ g uMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g gVar) {
            super(1);
            this.uMz = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(248593);
            num.intValue();
            x xVar = x.SXb;
            AppMethodBeat.o(248593);
            return xVar;
        }
    }

    public g(AppCompatActivity appCompatActivity, h.a aVar, View view) {
        p.h(appCompatActivity, "context");
        p.h(aVar, "presenter");
        p.h(view, "parent");
        AppMethodBeat.i(248598);
        this.uMk = appCompatActivity;
        this.uMy = aVar;
        this.hVd = view;
        AppMethodBeat.o(248598);
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.h.b
    public final void ab(ArrayList<bo> arrayList) {
        f d2;
        AppMethodBeat.i(248595);
        p.h(arrayList, "data");
        View findViewById = this.hVd.findViewById(R.id.et2);
        p.g(findViewById, "parent.findViewById(R.id.long_video_recycler_view)");
        this.USr = (OverScrollRecyclerView) findViewById;
        i iVar = new i();
        iVar.uMB = new a(this);
        OverScrollRecyclerView overScrollRecyclerView = this.USr;
        if (overScrollRecyclerView == null) {
            p.btv("recyclerView");
        }
        iVar.f(overScrollRecyclerView);
        WxRecyclerAdapter wxRecyclerAdapter = new WxRecyclerAdapter(this.uMy.dce(), arrayList);
        OverScrollRecyclerView overScrollRecyclerView2 = this.USr;
        if (overScrollRecyclerView2 == null) {
            p.btv("recyclerView");
        }
        overScrollRecyclerView2.setAdapter(wxRecyclerAdapter);
        OverScrollRecyclerView overScrollRecyclerView3 = this.USr;
        if (overScrollRecyclerView3 == null) {
            p.btv("recyclerView");
        }
        overScrollRecyclerView3.setLayoutManager(new FinderLinearLayoutManager(this.uMk));
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.uMk);
        if (!(fH == null || (d2 = FinderReporterUIC.d(fH)) == null)) {
            OverScrollRecyclerView overScrollRecyclerView4 = this.USr;
            if (overScrollRecyclerView4 == null) {
                p.btv("recyclerView");
            }
            d2.m(overScrollRecyclerView4);
        }
        d.a(d.aBx(), new b(this));
        OverScrollRecyclerView overScrollRecyclerView5 = this.USr;
        if (overScrollRecyclerView5 == null) {
            p.btv("recyclerView");
        }
        overScrollRecyclerView5.getOverScrollBehavior().USv = new c(this);
        AppMethodBeat.o(248595);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLViewCallback$initView$1", "Lcom/tencent/mm/plugin/finder/megavideo/ui/OverScrollVerticalBehavior$PullDownListener;", "onPullDown", "", "plugin-finder_release"})
    public static final class c implements OverScrollVerticalBehavior.b {
        final /* synthetic */ g uMz;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(g gVar) {
            this.uMz = gVar;
        }

        @Override // com.tencent.mm.plugin.finder.megavideo.ui.OverScrollVerticalBehavior.b
        public final void bQy() {
            AppMethodBeat.i(261241);
            this.uMz.dcl().onBackPressed();
            AppMethodBeat.o(261241);
        }
    }

    public boolean dct() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.h.b
    public final RecyclerView getRecyclerView() {
        AppMethodBeat.i(248596);
        OverScrollRecyclerView overScrollRecyclerView = this.USr;
        if (overScrollRecyclerView == null) {
            p.btv("recyclerView");
        }
        OverScrollRecyclerView overScrollRecyclerView2 = overScrollRecyclerView;
        AppMethodBeat.o(248596);
        return overScrollRecyclerView2;
    }

    @Override // com.tencent.mm.plugin.finder.megavideo.ui.h.b
    public final View getRootView() {
        return this.hVd;
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final MMFragmentActivity dcl() {
        AppMethodBeat.i(248597);
        AppCompatActivity appCompatActivity = this.uMk;
        if (appCompatActivity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
            AppMethodBeat.o(248597);
            throw tVar;
        }
        MMFragmentActivity mMFragmentActivity = (MMFragmentActivity) appCompatActivity;
        AppMethodBeat.o(248597);
        return mMFragmentActivity;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Void, x> {
        final /* synthetic */ g uMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(g gVar) {
            super(1);
            this.uMz = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Void r3) {
            AppMethodBeat.i(248594);
            this.uMz.uMy.dcp();
            if (this.uMz.dct()) {
                this.uMz.uMy.requestRefresh();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(248594);
            return xVar;
        }
    }
}
