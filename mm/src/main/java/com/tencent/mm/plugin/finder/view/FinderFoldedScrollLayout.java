package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.convert.aq;
import com.tencent.mm.plugin.finder.convert.cf;
import com.tencent.mm.plugin.finder.convert.cn;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

public final class FinderFoldedScrollLayout extends FrameLayout {
    private static long wmM;
    private static long wmN;
    private static long wmO;
    private static long wmP;
    public static final a wmQ = new a((byte) 0);
    private ArrayList<com.tencent.mm.view.recyclerview.a> kgc = new ArrayList<>();
    public WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> tFp;
    public WxRecyclerView ufR;
    private final int wmH = 1;
    private final e wmI = new e();
    private int wmJ;
    private p wmK;
    private final d wmL = new d(this);

    public interface b {
        ConstraintLayout.LayoutParams cZE();

        boolean cZF();

        int cZG();

        void h(h hVar);
    }

    static {
        AppMethodBeat.i(254842);
        AppMethodBeat.o(254842);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFoldedScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(254840);
        initView();
        AppMethodBeat.o(254840);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFoldedScrollLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(254841);
        initView();
        AppMethodBeat.o(254841);
    }

    public final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> getAdapter() {
        AppMethodBeat.i(254833);
        WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> wxRecyclerAdapter = this.tFp;
        if (wxRecyclerAdapter == null) {
            p.btv("adapter");
        }
        AppMethodBeat.o(254833);
        return wxRecyclerAdapter;
    }

    public final void setAdapter(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> wxRecyclerAdapter) {
        AppMethodBeat.i(254834);
        p.h(wxRecyclerAdapter, "<set-?>");
        this.tFp = wxRecyclerAdapter;
        AppMethodBeat.o(254834);
    }

    public final WxRecyclerView getRecyclerView() {
        AppMethodBeat.i(254835);
        WxRecyclerView wxRecyclerView = this.ufR;
        if (wxRecyclerView == null) {
            p.btv("recyclerView");
        }
        AppMethodBeat.o(254835);
        return wxRecyclerView;
    }

    public final void setRecyclerView(WxRecyclerView wxRecyclerView) {
        AppMethodBeat.i(254836);
        p.h(wxRecyclerView, "<set-?>");
        this.ufR = wxRecyclerView;
        AppMethodBeat.o(254836);
    }

    public static final class e implements com.tencent.mm.view.recyclerview.a {
        e() {
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            AppMethodBeat.i(254831);
            long hashCode = (long) hashCode();
            AppMethodBeat.o(254831);
            return hashCode;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return -100;
        }
    }

    private final void initView() {
        AppMethodBeat.i(254837);
        Context context = getContext();
        p.g(context, "context");
        this.ufR = new WxRecyclerView(context);
        WxRecyclerView wxRecyclerView = this.ufR;
        if (wxRecyclerView == null) {
            p.btv("recyclerView");
        }
        wxRecyclerView.setBackgroundResource(R.drawable.a4r);
        WxRecyclerView wxRecyclerView2 = this.ufR;
        if (wxRecyclerView2 == null) {
            p.btv("recyclerView");
        }
        addView(wxRecyclerView2, new FrameLayout.LayoutParams(-1, -1));
        WxRecyclerView wxRecyclerView3 = this.ufR;
        if (wxRecyclerView3 == null) {
            p.btv("recyclerView");
        }
        Context context2 = getContext();
        p.g(context2, "context");
        wxRecyclerView3.setLayoutManager(new FinderLinearLayoutManager(context2, (byte) 0));
        this.tFp = new WxRecyclerAdapter<>(new c(this), this.kgc, true);
        WxRecyclerView wxRecyclerView4 = this.ufR;
        if (wxRecyclerView4 == null) {
            p.btv("recyclerView");
        }
        WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> wxRecyclerAdapter = this.tFp;
        if (wxRecyclerAdapter == null) {
            p.btv("adapter");
        }
        wxRecyclerView4.setAdapter(wxRecyclerAdapter);
        WxRecyclerView wxRecyclerView5 = this.ufR;
        if (wxRecyclerView5 == null) {
            p.btv("recyclerView");
        }
        wxRecyclerView5.b(getItemDecoration());
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        Context context3 = getContext();
        p.g(context3, "context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context3);
        if (fH != null) {
            WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> wxRecyclerAdapter2 = this.tFp;
            if (wxRecyclerAdapter2 == null) {
                p.btv("adapter");
            }
            p.h(wxRecyclerAdapter2, "adapter");
            com.tencent.mm.ac.d.h(new FinderReporterUIC.b(fH, wxRecyclerAdapter2));
            AppMethodBeat.o(254837);
            return;
        }
        AppMethodBeat.o(254837);
    }

    public final void setup(p pVar) {
        String str;
        FinderItem finderItem;
        FinderItem finderItem2;
        FinderItem finderItem3;
        String str2 = null;
        AppMethodBeat.i(254838);
        p.h(pVar, "presenter");
        this.wmK = pVar;
        this.wmJ = pVar.cZG();
        this.kgc.clear();
        List<BaseFinderFeed> GW = pVar.GW();
        StringBuilder sb = new StringBuilder("steup foldedlayout ");
        BaseFinderFeed dGI = pVar.dGI();
        if (dGI == null || (finderItem3 = dGI.feedObject) == null) {
            str = null;
        } else {
            str = finderItem3.getDebugDescription();
        }
        StringBuilder append = sb.append(str).append(' ');
        BaseFinderFeed dGI2 = pVar.dGI();
        if (dGI2 != null) {
            finderItem = dGI2.feedObject;
        } else {
            finderItem = null;
        }
        StringBuilder append2 = append.append(finderItem).append(' ');
        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) j.L(GW, 0);
        if (!(baseFinderFeed == null || (finderItem2 = baseFinderFeed.feedObject) == null)) {
            str2 = finderItem2.getDebugDescription();
        }
        Log.i("Finder.FinderFoldedScrollLayout", append2.append(str2).toString());
        this.kgc.addAll(GW);
        if (pVar.dGJ()) {
            this.kgc.add(this.wmI);
        }
        WxRecyclerView wxRecyclerView = this.ufR;
        if (wxRecyclerView == null) {
            p.btv("recyclerView");
        }
        RecyclerView.LayoutManager layoutManager = wxRecyclerView.getLayoutManager();
        if (layoutManager == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
            AppMethodBeat.o(254838);
            throw tVar;
        }
        ((FinderLinearLayoutManager) layoutManager).ah(0, 0);
        WxRecyclerView wxRecyclerView2 = this.ufR;
        if (wxRecyclerView2 == null) {
            p.btv("recyclerView");
        }
        RecyclerView.a adapter = wxRecyclerView2.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
            AppMethodBeat.o(254838);
            return;
        }
        AppMethodBeat.o(254838);
    }

    public static final class c implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ FinderFoldedScrollLayout wmR;

        c(FinderFoldedScrollLayout finderFoldedScrollLayout) {
            this.wmR = finderFoldedScrollLayout;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(254826);
            switch (i2) {
                case -100:
                    cf cfVar = new cf(new a(this));
                    AppMethodBeat.o(254826);
                    return cfVar;
                case 2:
                    aq aqVar = new aq(this.wmR.wmL);
                    AppMethodBeat.o(254826);
                    return aqVar;
                case 4:
                    cn cnVar = new cn(this.wmR.wmL);
                    AppMethodBeat.o(254826);
                    return cnVar;
                default:
                    com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                    AppMethodBeat.o(254826);
                    return fVar;
            }
        }

        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ c wmS;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar) {
                super(0);
                this.wmS = cVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(254825);
                a aVar = FinderFoldedScrollLayout.wmQ;
                FinderFoldedScrollLayout.wmN = cl.aWA();
                p pVar = this.wmS.wmR.wmK;
                if (pVar != null) {
                    Context context = this.wmS.wmR.getContext();
                    p.g(context, "context");
                    pVar.ag(context, (this.wmS.wmR.kgc.size() - 1) - this.wmS.wmR.wmH);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(254825);
                return xVar;
            }
        }
    }

    public static final class f extends RecyclerView.h {
        final /* synthetic */ FinderFoldedScrollLayout wmR;

        f(FinderFoldedScrollLayout finderFoldedScrollLayout) {
            this.wmR = finderFoldedScrollLayout;
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(254832);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            Context context = view.getContext();
            p.g(context, "view.context");
            int dimension = (int) context.getResources().getDimension(R.dimen.c5);
            Context context2 = view.getContext();
            p.g(context2, "view.context");
            p unused = this.wmR.wmK;
            int max = Math.max((int) context2.getResources().getDimension(R.dimen.a4l), 0);
            int bw = RecyclerView.bw(view);
            if (bw == 0) {
                rect.left = dimension;
                rect.right = max;
                rect.bottom = 0;
                rect.top = 0;
                AppMethodBeat.o(254832);
            } else if (bw == this.wmR.kgc.size() - 1) {
                rect.left = max;
                rect.right = dimension;
                rect.bottom = 0;
                rect.top = 0;
                AppMethodBeat.o(254832);
            } else {
                rect.left = max;
                rect.right = max;
                rect.bottom = 0;
                rect.top = 0;
                AppMethodBeat.o(254832);
            }
        }
    }

    public final RecyclerView.h getItemDecoration() {
        AppMethodBeat.i(254839);
        f fVar = new f(this);
        AppMethodBeat.o(254839);
        return fVar;
    }

    public static final class d implements b {
        final /* synthetic */ FinderFoldedScrollLayout wmR;

        d(FinderFoldedScrollLayout finderFoldedScrollLayout) {
            this.wmR = finderFoldedScrollLayout;
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b
        public final void h(h hVar) {
            AppMethodBeat.i(254827);
            p.h(hVar, "holder");
            int lQ = hVar.lQ();
            p pVar = this.wmR.wmK;
            if (pVar != null) {
                Context context = this.wmR.getContext();
                p.g(context, "context");
                pVar.ag(context, lQ);
                AppMethodBeat.o(254827);
                return;
            }
            AppMethodBeat.o(254827);
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b
        public final ConstraintLayout.LayoutParams cZE() {
            AppMethodBeat.i(254828);
            p unused = this.wmR.wmK;
            AppMethodBeat.o(254828);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b
        public final boolean cZF() {
            AppMethodBeat.i(254829);
            p unused = this.wmR.wmK;
            AppMethodBeat.o(254829);
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b
        public final int cZG() {
            AppMethodBeat.i(254830);
            p pVar = this.wmR.wmK;
            if (pVar != null) {
                int cZG = pVar.cZG();
                AppMethodBeat.o(254830);
                return cZG;
            }
            AppMethodBeat.o(254830);
            return 1;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
