package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.model.g;
import com.tencent.mm.plugin.finder.view.FinderSnsHeaderView;
import com.tencent.mm.plugin.i.a.ab;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.view.recyclerview.HorizontalRecyclerView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\u0012\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderSnsHeader;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "getContext", "()Landroid/app/Activity;", "headerView", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;", "getHeaderView", "()Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;", "setHeaderView", "(Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderView;)V", "presenter", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;)V", "stateListener", "Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader$StateChangeListener;", "getStateListener", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader$StateChangeListener;", "setStateListener", "(Lcom/tencent/mm/plugin/findersdk/api/IFinderSnsHeader$StateChangeListener;)V", "checkVisibility", "", "genSnsHeader", "Landroid/view/View;", "getRecyclerView", "refresh", "release", "setListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "plugin-finder_release"})
public final class j implements ab {
    private final String TAG = "Finder.FinderSnsHeader";
    private final Activity dKq;
    private FinderSnsHeaderView woF;
    private k woG;
    ab.a woH;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class a extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ j woI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(j jVar) {
            super(1);
            this.woI = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(254907);
            boolean booleanValue = bool.booleanValue();
            ab.a aVar = this.woI.woH;
            if (aVar != null) {
                aVar.pi(booleanValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254907);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ j woI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(j jVar) {
            super(1);
            this.woI = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(254908);
            int intValue = num.intValue();
            ab.a aVar = this.woI.woH;
            if (aVar != null) {
                aVar.hJ(intValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254908);
            return xVar;
        }
    }

    public j(Activity activity) {
        p.h(activity, "context");
        AppMethodBeat.i(254914);
        this.dKq = activity;
        AppMethodBeat.o(254914);
    }

    @Override // com.tencent.mm.plugin.i.a.ab
    public final View dHb() {
        AppMethodBeat.i(254909);
        release();
        FinderSnsHeaderView finderSnsHeaderView = new FinderSnsHeaderView(this.dKq);
        k kVar = new k(this.dKq, finderSnsHeaderView.getViewCallback());
        p.h(kVar, "presenter");
        finderSnsHeaderView.woG = kVar;
        LayoutInflater.from(finderSnsHeaderView.getContext()).inflate(R.layout.ak3, (ViewGroup) finderSnsHeaderView, true);
        View findViewById = finderSnsHeaderView.findViewById(R.id.bfi);
        p.g(findViewById, "findViewById(R.id.content_view)");
        finderSnsHeaderView.contentView = findViewById;
        View view = finderSnsHeaderView.contentView;
        if (view == null) {
            p.btv("contentView");
        }
        View findViewById2 = view.findViewById(R.id.d3r);
        p.g(findViewById2, "contentView.findViewById…sns_header_recycler_view)");
        finderSnsHeaderView.woN = (HorizontalRecyclerView) findViewById2;
        WxRecyclerAdapter wxRecyclerAdapter = new WxRecyclerAdapter(new FinderSnsHeaderView.a(finderSnsHeaderView), kVar.kgc, false);
        wxRecyclerAdapter.RqP = new FinderSnsHeaderView.c(wxRecyclerAdapter, finderSnsHeaderView, kVar);
        HorizontalRecyclerView horizontalRecyclerView = finderSnsHeaderView.woN;
        if (horizontalRecyclerView == null) {
            p.btv("recyclerView");
        }
        horizontalRecyclerView.setAdapter(wxRecyclerAdapter);
        HorizontalRecyclerView horizontalRecyclerView2 = finderSnsHeaderView.woN;
        if (horizontalRecyclerView2 == null) {
            p.btv("recyclerView");
        }
        horizontalRecyclerView2.b(finderSnsHeaderView.getItemDecoration());
        finderSnsHeaderView.getContext();
        finderSnsHeaderView.vKp = new LinearLayoutManager(0, false);
        HorizontalRecyclerView horizontalRecyclerView3 = finderSnsHeaderView.woN;
        if (horizontalRecyclerView3 == null) {
            p.btv("recyclerView");
        }
        LinearLayoutManager linearLayoutManager = finderSnsHeaderView.vKp;
        if (linearLayoutManager == null) {
            p.btv("layoutManager");
        }
        horizontalRecyclerView3.setLayoutManager(linearLayoutManager);
        HorizontalRecyclerView horizontalRecyclerView4 = finderSnsHeaderView.woN;
        if (horizontalRecyclerView4 == null) {
            p.btv("recyclerView");
        }
        horizontalRecyclerView4.a(new FinderSnsHeaderView.d(kVar));
        HorizontalRecyclerView horizontalRecyclerView5 = finderSnsHeaderView.woN;
        if (horizontalRecyclerView5 == null) {
            p.btv("recyclerView");
        }
        horizontalRecyclerView5.a(finderSnsHeaderView.woR);
        View findViewById3 = finderSnsHeaderView.findViewById(R.id.b3g);
        p.g(findViewById3, "findViewById(R.id.clear_btn)");
        finderSnsHeaderView.woP = findViewById3;
        finderSnsHeaderView.dHe();
        g gVar = kVar.woJ;
        com.tencent.mm.kernel.g.azz().a(6847, gVar);
        gVar.kgc.addAll(g.tXm);
        g.tXm = gVar.kgc;
        gVar.tXl.onChanged();
        gVar.tXk.alive();
        kVar.woK.alive();
        this.woF = finderSnsHeaderView;
        this.woG = kVar;
        FinderSnsHeaderView finderSnsHeaderView2 = finderSnsHeaderView;
        AppMethodBeat.o(254909);
        return finderSnsHeaderView2;
    }

    @Override // com.tencent.mm.plugin.i.a.ab
    public final void release() {
        AppMethodBeat.i(254910);
        k kVar = this.woG;
        if (kVar != null) {
            kVar.release();
            AppMethodBeat.o(254910);
            return;
        }
        AppMethodBeat.o(254910);
    }

    @Override // com.tencent.mm.plugin.i.a.ab
    public final void a(ab.a aVar) {
        AppMethodBeat.i(254911);
        this.woH = aVar;
        FinderSnsHeaderView finderSnsHeaderView = this.woF;
        if (finderSnsHeaderView != null) {
            finderSnsHeaderView.setOnInterceptListener(new a(this));
        }
        FinderSnsHeaderView finderSnsHeaderView2 = this.woF;
        if (finderSnsHeaderView2 != null) {
            finderSnsHeaderView2.setVisibilityChangedListener(new b(this));
            AppMethodBeat.o(254911);
            return;
        }
        AppMethodBeat.o(254911);
    }

    @Override // com.tencent.mm.plugin.i.a.ab
    public final View dHc() {
        AppMethodBeat.i(254912);
        FinderSnsHeaderView finderSnsHeaderView = this.woF;
        HorizontalRecyclerView recyclerView = finderSnsHeaderView != null ? finderSnsHeaderView.getRecyclerView() : null;
        AppMethodBeat.o(254912);
        return recyclerView;
    }

    @Override // com.tencent.mm.plugin.i.a.ab
    public final void dHd() {
        AppMethodBeat.i(254913);
        FinderSnsHeaderView finderSnsHeaderView = this.woF;
        if (finderSnsHeaderView != null) {
            finderSnsHeaderView.dHd();
            AppMethodBeat.o(254913);
            return;
        }
        AppMethodBeat.o(254913);
    }
}
