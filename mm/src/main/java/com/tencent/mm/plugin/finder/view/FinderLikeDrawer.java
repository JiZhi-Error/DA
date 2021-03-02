package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.t;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.builder.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares;
import kotlin.g.b.p;
import kotlin.g.b.z;

public final class FinderLikeDrawer extends RecyclerViewDrawer implements RecyclerViewDrawerSquares.c {
    private static final int tvl = 1;
    private static final int tvm = 2;
    public static final a wnm = new a((byte) 0);
    private b likeBuffer;
    private int scene;
    private FinderItem tMO;
    private com.tencent.mm.plugin.finder.view.builder.a wnl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLikeDrawer(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(254852);
        AppMethodBeat.o(254852);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLikeDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(254853);
        AppMethodBeat.o(254853);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLikeDrawer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(254854);
        AppMethodBeat.o(254854);
    }

    public final int getScene() {
        return this.scene;
    }

    public final void setScene(int i2) {
        this.scene = i2;
    }

    public final com.tencent.mm.plugin.finder.view.builder.a getBuilder() {
        return this.wnl;
    }

    public final void setBuilder(com.tencent.mm.plugin.finder.view.builder.a aVar) {
        this.wnl = aVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static FinderLikeDrawer a(Context context, Window window, int i2) {
            AppMethodBeat.i(254849);
            p.h(context, "context");
            p.h(window, "window");
            Log.i("Finder.FinderLikeDrawer", "createDrawerToAttachWindow ");
            FinderLikeDrawer finderLikeDrawer = new FinderLikeDrawer(context);
            finderLikeDrawer.setScene(i2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            z.f fVar = new z.f();
            fVar.SYG = null;
            if (i2 == FinderLikeDrawer.tvl) {
                fVar.SYG = (T) new com.tencent.mm.plugin.finder.view.builder.a(new com.tencent.mm.plugin.finder.feed.p(context));
            } else if (i2 == FinderLikeDrawer.tvm) {
                fVar.SYG = (T) new com.tencent.mm.plugin.finder.view.builder.a(new t());
            } else {
                fVar.SYG = (T) new com.tencent.mm.plugin.finder.view.builder.a(new t());
            }
            fVar.SYG.a(finderLikeDrawer);
            finderLikeDrawer.setBuilder(fVar.SYG);
            window.getDecorView().post(new RunnableC1325a(context, layoutParams, window, finderLikeDrawer, fVar));
            if (context instanceof MMFragmentActivity) {
                ((MMFragmentActivity) context).getLifecycle().addObserver(new FinderLikeDrawer$Companion$createDrawerToAttachWindow$2(finderLikeDrawer, context));
            }
            AppMethodBeat.o(254849);
            return finderLikeDrawer;
        }

        /* renamed from: com.tencent.mm.plugin.finder.view.FinderLikeDrawer$a$a */
        public static final class RunnableC1325a implements Runnable {
            final /* synthetic */ Context $context;
            final /* synthetic */ FrameLayout.LayoutParams wkJ;
            final /* synthetic */ Window wnn;
            final /* synthetic */ FinderLikeDrawer wno;
            final /* synthetic */ z.f wnp;

            RunnableC1325a(Context context, FrameLayout.LayoutParams layoutParams, Window window, FinderLikeDrawer finderLikeDrawer, z.f fVar) {
                this.$context = context;
                this.wkJ = layoutParams;
                this.wnn = window;
                this.wno = finderLikeDrawer;
                this.wnp = fVar;
            }

            public final void run() {
                AppMethodBeat.i(254847);
                int aB = au.aB(this.$context);
                this.wkJ.bottomMargin = aB;
                Log.i("Finder.FinderLikeDrawer", "[initView] bottomMargin= ".concat(String.valueOf(aB)));
                View decorView = this.wnn.getDecorView();
                if (decorView == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout");
                    AppMethodBeat.o(254847);
                    throw tVar;
                }
                ((FrameLayout) decorView).addView(this.wno, this.wkJ);
                T t = this.wnp.SYG;
                Context context = this.$context;
                FrameLayout headerLayout = this.wno.getHeaderLayout();
                p.h(context, "context");
                p.h(headerLayout, "headerLayout");
                t.wrS = headerLayout;
                LayoutInflater jQ = aa.jQ(context);
                FinderLikeDrawer finderLikeDrawer = t.tLU;
                if (finderLikeDrawer == null) {
                    p.btv("likeDrawer");
                }
                View inflate = jQ.inflate(R.layout.azp, finderLikeDrawer.getHeaderLayout());
                View findViewById = inflate.findViewById(R.id.bv3);
                p.g(findViewById, "header.findViewById(R.id.drawer_header_tv)");
                t.wrR = (TextView) findViewById;
                TextView textView = t.wrR;
                if (textView == null) {
                    p.btv("headerTitleTv");
                }
                ao.a(textView.getPaint(), 0.8f);
                View findViewById2 = inflate.findViewById(R.id.b4c);
                View findViewById3 = inflate.findViewById(R.id.bv4);
                findViewById2.setOnClickListener(new a.b(t));
                t.wrX.a(context, headerLayout);
                FinderLikeDrawer finderLikeDrawer2 = t.tLU;
                if (finderLikeDrawer2 == null) {
                    p.btv("likeDrawer");
                }
                p.g(findViewById2, "closeBtn");
                finderLikeDrawer2.hH(findViewById2);
                FinderLikeDrawer finderLikeDrawer3 = t.tLU;
                if (finderLikeDrawer3 == null) {
                    p.btv("likeDrawer");
                }
                p.g(findViewById3, "moreBtn");
                finderLikeDrawer3.hH(findViewById3);
                T t2 = this.wnp.SYG;
                Context context2 = this.$context;
                RefreshLoadMoreLayout centerLayout = this.wno.getCenterLayout();
                p.h(context2, "context");
                p.h(centerLayout, "rlLayout");
                t2.tLS = centerLayout;
                t2.wrX.dV(centerLayout);
                View inflate2 = aa.jQ(context2).inflate(R.layout.b21, (ViewGroup) null);
                p.g(inflate2, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
                centerLayout.setLoadMoreFooter(inflate2);
                RecyclerView recyclerView = centerLayout.getRecyclerView();
                recyclerView.setHasFixedSize(true);
                RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
                if (itemAnimator != null) {
                    itemAnimator.lB();
                }
                recyclerView.setLayoutManager(t2.wrX.eS(context2));
                recyclerView.b(t2.wrX.fi(context2));
                recyclerView.setAdapter(t2.wrX.fm(context2));
                T t3 = this.wnp.SYG;
                Context context3 = this.$context;
                FrameLayout loadingLayout = this.wno.getLoadingLayout();
                p.h(context3, "context");
                p.h(loadingLayout, "loadingLayout");
                t3.wrT = loadingLayout;
                View inflate3 = LayoutInflater.from(context3).inflate(R.layout.aas, (ViewGroup) loadingLayout, true);
                View findViewById4 = inflate3.findViewById(R.id.ebm);
                p.g(findViewById4, "loadingContentLayout.fin…Id(R.id.like_loading_bar)");
                t3.hSw = findViewById4;
                View findViewById5 = inflate3.findViewById(R.id.fzs);
                p.g(findViewById5, "loadingContentLayout.fin…ewById(R.id.no_like_hint)");
                t3.wrU = findViewById5;
                View findViewById6 = inflate3.findViewById(R.id.h5v);
                p.g(findViewById6, "loadingContentLayout.fin…d(R.id.retry_like_layout)");
                t3.wrV = findViewById6;
                View view = t3.hSw;
                if (view == null) {
                    p.btv("loadingView");
                }
                view.setVisibility(0);
                View view2 = t3.wrU;
                if (view2 == null) {
                    p.btv("nothingView");
                }
                view2.setVisibility(8);
                View view3 = t3.wrV;
                if (view3 == null) {
                    p.btv("retryView");
                }
                view3.setVisibility(8);
                AppMethodBeat.o(254847);
            }
        }
    }

    static {
        AppMethodBeat.i(254855);
        AppMethodBeat.o(254855);
    }

    public final FinderItem getFeedObj() {
        return this.tMO;
    }

    public final void setFeedObj(FinderItem finderItem) {
        this.tMO = finderItem;
    }

    public final b getLikeBuffer() {
        return this.likeBuffer;
    }

    public final void setLikeBuffer(b bVar) {
        this.likeBuffer = bVar;
    }

    public final void a(FinderItem finderItem, b bVar) {
        AppMethodBeat.i(254850);
        p.h(finderItem, "feedObj");
        if (!dGs()) {
            this.tMO = finderItem;
            this.likeBuffer = bVar;
            super.bi(true, true);
        }
        AppMethodBeat.o(254850);
    }

    public final void dGr() {
        AppMethodBeat.i(254851);
        if (dGs()) {
            super.DG(true);
        }
        AppMethodBeat.o(254851);
    }
}
