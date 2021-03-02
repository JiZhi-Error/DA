package com.tencent.mm.plugin.finder.view.builder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ed;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderCommentFooter;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0016\u0018\u0000 v2\u00020\u00012\u00020\u0002:\u0001vB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\\\u001a\u00020F2\u0006\u0010]\u001a\u000201J\u0006\u0010^\u001a\u00020FJ\u0006\u0010_\u001a\u00020FJ\u0018\u0010`\u001a\u00020F2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010V\u001a\u00020WH\u0016J \u0010a\u001a\u00020F2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010b\u001a\u00020(2\u0006\u0010c\u001a\u000201H\u0016J \u0010d\u001a\u00020F2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(2\u0006\u0010c\u001a\u000201H\u0016J\u0018\u0010e\u001a\u00020F2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010;\u001a\u00020(H\u0016J\u0018\u0010f\u001a\u00020F2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u000206H\u0016J\b\u0010j\u001a\u00020FH\u0016J\u0018\u0010k\u001a\u00020F2\u0006\u0010l\u001a\u0002012\u0006\u0010m\u001a\u000201H\u0016J\u0010\u0010n\u001a\u00020F2\u0006\u0010o\u001a\u00020pH\u0016J\u0006\u0010q\u001a\u00020FJ\u0006\u0010r\u001a\u00020FJ\u0006\u0010s\u001a\u00020FJ\u0014\u0010t\u001a\u00020F2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020F0ER\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020(X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010*\"\u0004\b=\u0010,R\u001a\u0010>\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010\u000bR\u001a\u0010A\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\t\"\u0004\bC\u0010\u000bR \u0010D\u001a\b\u0012\u0004\u0012\u00020F0EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR&\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020F0LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\t\"\u0004\bU\u0010\u000bR\u001a\u0010V\u001a\u00020WX.¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006w"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "closeCommentView", "Landroid/view/View;", "getCloseCommentView", "()Landroid/view/View;", "setCloseCommentView", "(Landroid/view/View;)V", "commentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getCommentDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setCommentDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "drawerFooter", "Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "getDrawerFooter", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;", "setDrawerFooter", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentFooter;)V", "headerErrTip", "getHeaderErrTip", "setHeaderErrTip", "headerErrTv", "Landroid/widget/TextView;", "getHeaderErrTv", "()Landroid/widget/TextView;", "setHeaderErrTv", "(Landroid/widget/TextView;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "getHeaderTitleTv", "setHeaderTitleTv", "isEnableFullScreenEnjoy", "", "()Z", "setEnableFullScreenEnjoy", "(Z)V", "lastHideVKBTime", "", "getLastHideVKBTime", "()I", "setLastHideVKBTime", "(I)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "getLoadingView", "setLoadingView", "nothingView", "getNothingView", "setNothingView", "onBackPressed", "Lkotlin/Function0;", "", "getOnBackPressed", "()Lkotlin/jvm/functions/Function0;", "setOnBackPressed", "(Lkotlin/jvm/functions/Function0;)V", "onCloseBtnClick", "Lkotlin/Function1;", "getOnCloseBtnClick", "()Lkotlin/jvm/functions/Function1;", "setOnCloseBtnClick", "(Lkotlin/jvm/functions/Function1;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "enable", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerFooter", "footerLayout", "fullScreen", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "scene", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showCommentClose", "showLoading", "showNothingTips", "showRetryView", "onClick", "Companion", "plugin-finder_release"})
public class b implements FinderCommentDrawer.a, RecyclerViewDrawerSquares.c {
    public static final a wsh = new a((byte) 0);
    public Context context;
    public View hSw;
    public RefreshLoadMoreLayout tLS;
    public final CommentDrawerContract.NPresenter tzm;
    private boolean wfg;
    public TextView wrR;
    public FrameLayout wrS;
    public FrameLayout wrT;
    public View wrU;
    public View wrV;
    public FinderCommentFooter wsa;
    public FinderCommentDrawer wsb;
    public View wsc;
    public View wsd;
    public TextView wse;
    kotlin.g.a.b<? super View, x> wsf = new h(this);
    kotlin.g.a.a<x> wsg = new C1335b(this);

    static {
        AppMethodBeat.i(168495);
        AppMethodBeat.o(168495);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "invoke"})
    static final class h extends q implements kotlin.g.a.b<View, x> {
        final /* synthetic */ b wsi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(b bVar) {
            super(1);
            this.wsi = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(View view) {
            AppMethodBeat.i(255205);
            p.h(view, LocaleUtil.ITALIAN);
            this.wsi.dHw().dGr();
            x xVar = x.SXb;
            AppMethodBeat.o(255205);
            return xVar;
        }
    }

    public b(CommentDrawerContract.NPresenter nPresenter) {
        p.h(nPresenter, "presenter");
        AppMethodBeat.i(168494);
        this.tzm = nPresenter;
        AppMethodBeat.o(168494);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final TextView dHs() {
        AppMethodBeat.i(168477);
        TextView textView = this.wrR;
        if (textView == null) {
            p.btv("headerTitleTv");
        }
        AppMethodBeat.o(168477);
        return textView;
    }

    public final RefreshLoadMoreLayout getRlLayout() {
        AppMethodBeat.i(168478);
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        AppMethodBeat.o(168478);
        return refreshLoadMoreLayout;
    }

    public final FinderCommentFooter dHv() {
        AppMethodBeat.i(168479);
        FinderCommentFooter finderCommentFooter = this.wsa;
        if (finderCommentFooter == null) {
            p.btv("drawerFooter");
        }
        AppMethodBeat.o(168479);
        return finderCommentFooter;
    }

    public final FinderCommentDrawer dHw() {
        AppMethodBeat.i(168480);
        FinderCommentDrawer finderCommentDrawer = this.wsb;
        if (finderCommentDrawer == null) {
            p.btv("commentDrawer");
        }
        AppMethodBeat.o(168480);
        return finderCommentDrawer;
    }

    public final FrameLayout getHeaderLayout() {
        AppMethodBeat.i(168481);
        FrameLayout frameLayout = this.wrS;
        if (frameLayout == null) {
            p.btv("headerLayout");
        }
        AppMethodBeat.o(168481);
        return frameLayout;
    }

    public final FrameLayout getLoadingLayout() {
        AppMethodBeat.i(255206);
        FrameLayout frameLayout = this.wrT;
        if (frameLayout == null) {
            p.btv("loadingLayout");
        }
        AppMethodBeat.o(255206);
        return frameLayout;
    }

    public final Context getContext() {
        AppMethodBeat.i(168482);
        Context context2 = this.context;
        if (context2 == null) {
            p.btv("context");
        }
        AppMethodBeat.o(168482);
        return context2;
    }

    public final View dHx() {
        AppMethodBeat.i(168483);
        View view = this.wsd;
        if (view == null) {
            p.btv("headerErrTip");
        }
        AppMethodBeat.o(168483);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a
    public final void a(RecyclerViewDrawer recyclerViewDrawer, int i2) {
        AppMethodBeat.i(255207);
        p.h(recyclerViewDrawer, "drawer");
        Context context2 = recyclerViewDrawer.getContext();
        p.g(context2, "drawer.context");
        this.context = context2;
        recyclerViewDrawer.setId(R.id.ckr);
        this.wsb = (FinderCommentDrawer) recyclerViewDrawer;
        recyclerViewDrawer.setSquaresBackgroundResource(R.drawable.xf);
        recyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
        recyclerViewDrawer.setOnOpenDrawerListener(this);
        FinderCommentDrawer finderCommentDrawer = this.wsb;
        if (finderCommentDrawer == null) {
            p.btv("commentDrawer");
        }
        finderCommentDrawer.setScene(i2);
        FinderCommentDrawer finderCommentDrawer2 = this.wsb;
        if (finderCommentDrawer2 == null) {
            p.btv("commentDrawer");
        }
        FinderCommentDrawer finderCommentDrawer3 = this.wsb;
        if (finderCommentDrawer3 == null) {
            p.btv("commentDrawer");
        }
        finderCommentDrawer2.setSelfProfile(finderCommentDrawer3.getScene() == 1);
        AppMethodBeat.o(255207);
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a
    public void a(Context context2, FrameLayout frameLayout, boolean z) {
        View inflate;
        AppMethodBeat.i(255208);
        p.h(context2, "context");
        p.h(frameLayout, "headerLayout");
        this.wrS = frameLayout;
        this.wfg = y.a(y.vXH, 0, this.tzm.getCommentScene(), 1);
        if (z) {
            inflate = aa.jQ(context2).inflate(R.layout.vo, frameLayout);
        } else {
            inflate = aa.jQ(context2).inflate(R.layout.vn, frameLayout);
        }
        View findViewById = inflate.findViewById(R.id.bv3);
        p.g(findViewById, "header.findViewById(R.id.drawer_header_tv)");
        this.wrR = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.ckv);
        p.g(findViewById2, "header.findViewById(R.id.finder_comment_error_tip)");
        this.wsd = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.ckt);
        p.g(findViewById3, "header.findViewById(R.id.finder_comment_error_msg)");
        this.wse = (TextView) findViewById3;
        TextView textView = this.wrR;
        if (textView == null) {
            p.btv("headerTitleTv");
        }
        ao.a(textView.getPaint(), 0.8f);
        View findViewById4 = inflate.findViewById(R.id.b4c);
        findViewById4.setOnClickListener(new g(this));
        FinderCommentDrawer finderCommentDrawer = this.wsb;
        if (finderCommentDrawer == null) {
            p.btv("commentDrawer");
        }
        p.g(findViewById4, "closeBtn");
        finderCommentDrawer.hH(findViewById4);
        AppMethodBeat.o(255208);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ b wsi;

        g(b bVar) {
            this.wsi = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168475);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.b<? super View, x> bVar2 = this.wsi.wsf;
            p.g(view, LocaleUtil.ITALIAN);
            bVar2.invoke(view);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168475);
        }
    }

    public final void pb(boolean z) {
        AppMethodBeat.i(168486);
        if (z) {
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout.setEnableRefresh(true);
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tLS;
            if (refreshLoadMoreLayout2 == null) {
                p.btv("rlLayout");
            }
            if (refreshLoadMoreLayout2.getRefreshHeader() == null) {
                RefreshLoadMoreLayout refreshLoadMoreLayout3 = this.tLS;
                if (refreshLoadMoreLayout3 == null) {
                    p.btv("rlLayout");
                }
                Context context2 = this.context;
                if (context2 == null) {
                    p.btv("context");
                }
                View inflate = aa.jQ(context2).inflate(R.layout.bm7, (ViewGroup) null);
                p.g(inflate, "MMLayoutInflater.getInfl…out.refresh_header, null)");
                refreshLoadMoreLayout3.setRefreshHeaderView(inflate);
                AppMethodBeat.o(168486);
                return;
            }
        } else {
            RefreshLoadMoreLayout refreshLoadMoreLayout4 = this.tLS;
            if (refreshLoadMoreLayout4 == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout4.setEnableRefresh(false);
        }
        AppMethodBeat.o(168486);
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a
    public final void a(Context context2, RefreshLoadMoreLayout refreshLoadMoreLayout) {
        AppMethodBeat.i(168487);
        p.h(context2, "context");
        p.h(refreshLoadMoreLayout, "rlLayout");
        this.tLS = refreshLoadMoreLayout;
        View inflate = aa.jQ(context2).inflate(R.layout.b21, (ViewGroup) null);
        p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        refreshLoadMoreLayout.setLoadMoreFooter(inflate);
        RecyclerView recyclerView = refreshLoadMoreLayout.getRecyclerView();
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(4);
        RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.lB();
        }
        recyclerView.setLayoutManager(new LinearLayoutManager());
        recyclerView.setAdapter(this.tzm.fm(context2));
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        recyclerView.setRecycledViewPool(((FinderRecyclerViewPool) com.tencent.mm.ui.component.a.b((MMFragmentActivity) context2).get(FinderRecyclerViewPool.class)).wuy);
        recyclerView.a(new c(this, context2));
        recyclerView.b(this.tzm.fi(context2));
        ViewParent parent = refreshLoadMoreLayout.getParent();
        if (parent == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(168487);
            throw tVar;
        }
        View view = (View) parent;
        FinderCommentDrawer finderCommentDrawer = this.wsb;
        if (finderCommentDrawer == null) {
            p.btv("commentDrawer");
        }
        finderCommentDrawer.getFooterLayout().addOnLayoutChangeListener(new d(this, view));
        AppMethodBeat.o(168487);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "lastState", "", "getLastState", "()I", "setLastState", "(I)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "plugin-finder_release"})
    public static final class c extends RecyclerView.l {
        final /* synthetic */ Context $context;
        private int tIj;
        final /* synthetic */ b wsi;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(255204);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(255204);
        }

        c(b bVar, Context context) {
            this.wsi = bVar;
            this.$context = context;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(178494);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            switch (i2) {
                case 0:
                case 4:
                case 5:
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager != null) {
                        this.wsi.tzm.IG(((LinearLayoutManager) layoutManager).ku());
                        break;
                    } else {
                        t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                        AppMethodBeat.o(178494);
                        throw tVar;
                    }
                case 1:
                case 3:
                    if (this.tIj != 3) {
                        Context context = this.$context;
                        if (context != null) {
                            ((MMFragmentActivity) context).hideVKB();
                            break;
                        } else {
                            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                            AppMethodBeat.o(178494);
                            throw tVar2;
                        }
                    }
                    break;
            }
            this.tIj = i2;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(178494);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$onBuildDrawerBody$3", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
    public static final class d implements View.OnLayoutChangeListener {
        final /* synthetic */ View wkH;
        final /* synthetic */ b wsi;

        d(b bVar, View view) {
            this.wsi = bVar;
            this.wkH = view;
        }

        public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            AppMethodBeat.i(178495);
            this.wsi.dHw().getFooterLayout().removeOnLayoutChangeListener(this);
            this.wkH.setPadding(this.wkH.getPaddingLeft(), this.wkH.getPaddingTop(), this.wkH.getPaddingRight(), this.wsi.dHv().getCommentEditTextLayout().getHeight());
            this.wkH.requestLayout();
            Log.i("Finder.TimelineDrawerBuilder", "bottomMargin=" + this.wsi.dHv().getCommentEditTextLayout().getHeight() + " paddingBottom=" + this.wkH.getPaddingBottom());
            AppMethodBeat.o(178495);
        }
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a
    public final void b(Context context2, FrameLayout frameLayout, boolean z) {
        AppMethodBeat.i(255209);
        p.h(context2, "context");
        p.h(frameLayout, "footerLayout");
        View findViewById = aa.jQ(context2).inflate(R.layout.vm, frameLayout).findViewById(R.id.ckw);
        p.g(findViewById, "view.findViewById(R.id.finder_comment_footer)");
        this.wsa = (FinderCommentFooter) findViewById;
        FinderCommentFooter finderCommentFooter = this.wsa;
        if (finderCommentFooter == null) {
            p.btv("drawerFooter");
        }
        finderCommentFooter.setBackClickListener(new e(this, z));
        FinderCommentFooter finderCommentFooter2 = this.wsa;
        if (finderCommentFooter2 == null) {
            p.btv("drawerFooter");
        }
        finderCommentFooter2.setSwitchSceneListener(new f(this));
        FinderCommentFooter finderCommentFooter3 = this.wsa;
        if (finderCommentFooter3 == null) {
            p.btv("drawerFooter");
        }
        FinderCommentDrawer finderCommentDrawer = this.wsb;
        if (finderCommentDrawer == null) {
            p.btv("commentDrawer");
        }
        finderCommentFooter3.setSelfProfile(finderCommentDrawer.uLZ);
        FinderCommentFooter finderCommentFooter4 = this.wsa;
        if (finderCommentFooter4 == null) {
            p.btv("drawerFooter");
        }
        FinderCommentDrawer finderCommentDrawer2 = this.wsb;
        if (finderCommentDrawer2 == null) {
            p.btv("commentDrawer");
        }
        finderCommentFooter4.setScene(finderCommentDrawer2.getSceneForReply());
        FinderCommentFooter finderCommentFooter5 = this.wsa;
        if (finderCommentFooter5 == null) {
            p.btv("drawerFooter");
        }
        FinderCommentDrawer finderCommentDrawer3 = this.wsb;
        if (finderCommentDrawer3 == null) {
            p.btv("commentDrawer");
        }
        finderCommentFooter5.setBanSwitchScene(finderCommentDrawer3.getBanSwitch());
        StringBuilder sb = new StringBuilder("drawerFooter.scene ");
        FinderCommentFooter finderCommentFooter6 = this.wsa;
        if (finderCommentFooter6 == null) {
            p.btv("drawerFooter");
        }
        Log.i("Finder.TimelineDrawerBuilder", sb.append(finderCommentFooter6.getScene()).toString());
        FinderCommentFooter finderCommentFooter7 = this.wsa;
        if (finderCommentFooter7 == null) {
            p.btv("drawerFooter");
        }
        finderCommentFooter7.dGx();
        FinderCommentFooter finderCommentFooter8 = this.wsa;
        if (finderCommentFooter8 == null) {
            p.btv("drawerFooter");
        }
        finderCommentFooter8.dGy();
        FinderCommentDrawer finderCommentDrawer4 = this.wsb;
        if (finderCommentDrawer4 == null) {
            p.btv("commentDrawer");
        }
        FinderCommentFooter finderCommentFooter9 = this.wsa;
        if (finderCommentFooter9 == null) {
            p.btv("drawerFooter");
        }
        finderCommentDrawer4.setKeyboardHeightObserver(finderCommentFooter9);
        FinderCommentDrawer finderCommentDrawer5 = this.wsb;
        if (finderCommentDrawer5 == null) {
            p.btv("commentDrawer");
        }
        FinderCommentFooter finderCommentFooter10 = this.wsa;
        if (finderCommentFooter10 == null) {
            p.btv("drawerFooter");
        }
        finderCommentDrawer5.setFooter(finderCommentFooter10);
        AppMethodBeat.o(255209);
    }

    @Override // com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a
    public final void b(Context context2, FrameLayout frameLayout) {
        AppMethodBeat.i(168489);
        p.h(context2, "context");
        p.h(frameLayout, "loadingLayout");
        this.wrT = frameLayout;
        View inflate = LayoutInflater.from(context2).inflate(R.layout.a9w, (ViewGroup) frameLayout, true);
        View findViewById = inflate.findViewById(R.id.b96);
        p.g(findViewById, "loadingContentLayout.fin…R.id.comment_loading_bar)");
        this.hSw = findViewById;
        View findViewById2 = inflate.findViewById(R.id.fzn);
        p.g(findViewById2, "loadingContentLayout.fin…yId(R.id.no_comment_hint)");
        this.wrU = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.h5s);
        p.g(findViewById3, "loadingContentLayout.fin….id.retry_comment_layout)");
        this.wrV = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.ckq);
        p.g(findViewById4, "loadingContentLayout.fin…nder_comment_closed_tips)");
        this.wsc = findViewById4;
        View view = this.hSw;
        if (view == null) {
            p.btv("loadingView");
        }
        view.setVisibility(0);
        View view2 = this.wrU;
        if (view2 == null) {
            p.btv("nothingView");
        }
        view2.setVisibility(8);
        View view3 = this.wrV;
        if (view3 == null) {
            p.btv("retryView");
        }
        view3.setVisibility(8);
        View view4 = this.wsc;
        if (view4 == null) {
            p.btv("closeCommentView");
        }
        view4.setVisibility(8);
        AppMethodBeat.o(168489);
    }

    @Override // com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c
    public final void S(boolean z, boolean z2) {
        AppMethodBeat.i(168490);
        if (!z || !z2) {
            if (!z && z2) {
                this.tzm.onDetach();
            }
            AppMethodBeat.o(168490);
            return;
        }
        FinderCommentDrawer finderCommentDrawer = this.wsb;
        if (finderCommentDrawer == null) {
            p.btv("commentDrawer");
        }
        if (finderCommentDrawer.getShowFooter()) {
            FinderCommentFooter finderCommentFooter = this.wsa;
            if (finderCommentFooter == null) {
                p.btv("drawerFooter");
            }
            finderCommentFooter.setVisibility(0);
            FrameLayout frameLayout = this.wrS;
            if (frameLayout == null) {
                p.btv("headerLayout");
            }
            View findViewById = frameLayout.findViewById(R.id.ckq);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else {
            FinderCommentFooter finderCommentFooter2 = this.wsa;
            if (finderCommentFooter2 == null) {
                p.btv("drawerFooter");
            }
            finderCommentFooter2.setVisibility(8);
            FinderCommentDrawer finderCommentDrawer2 = this.wsb;
            if (finderCommentDrawer2 == null) {
                p.btv("commentDrawer");
            }
            if (finderCommentDrawer2.getCloseComment()) {
                if (!this.wfg) {
                    FrameLayout frameLayout2 = this.wrS;
                    if (frameLayout2 == null) {
                        p.btv("headerLayout");
                    }
                    View findViewById2 = frameLayout2.findViewById(R.id.ckq);
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(0);
                    }
                } else {
                    FrameLayout frameLayout3 = this.wrS;
                    if (frameLayout3 == null) {
                        p.btv("headerLayout");
                    }
                    View findViewById3 = frameLayout3.findViewById(R.id.ckq);
                    if (findViewById3 != null) {
                        findViewById3.setVisibility(8);
                    }
                }
                View view = this.wrU;
                if (view == null) {
                    p.btv("nothingView");
                }
                view.setVisibility(8);
                View view2 = this.wrV;
                if (view2 == null) {
                    p.btv("retryView");
                }
                view2.setVisibility(8);
                FrameLayout frameLayout4 = this.wrT;
                if (frameLayout4 == null) {
                    p.btv("loadingLayout");
                }
                frameLayout4.setVisibility(0);
                View view3 = this.wsc;
                if (view3 == null) {
                    p.btv("closeCommentView");
                }
                view3.setVisibility(0);
            } else {
                View view4 = this.wsc;
                if (view4 == null) {
                    p.btv("closeCommentView");
                }
                view4.setVisibility(8);
                FrameLayout frameLayout5 = this.wrS;
                if (frameLayout5 == null) {
                    p.btv("headerLayout");
                }
                View findViewById4 = frameLayout5.findViewById(R.id.ckq);
                if (findViewById4 != null) {
                    findViewById4.setVisibility(8);
                }
            }
        }
        CommentDrawerContract.NPresenter nPresenter = this.tzm;
        FinderCommentDrawer finderCommentDrawer3 = this.wsb;
        if (finderCommentDrawer3 == null) {
            p.btv("commentDrawer");
        }
        FinderCommentDrawer finderCommentDrawer4 = this.wsb;
        if (finderCommentDrawer4 == null) {
            p.btv("commentDrawer");
        }
        FinderItem feedObj = finderCommentDrawer4.getFeedObj();
        if (feedObj == null) {
            p.hyc();
        }
        FinderCommentDrawer finderCommentDrawer5 = this.wsb;
        if (finderCommentDrawer5 == null) {
            p.btv("commentDrawer");
        }
        CommentDrawerContract.CloseDrawerCallback onCloseDrawerCallback = finderCommentDrawer5.getOnCloseDrawerCallback();
        FinderCommentDrawer finderCommentDrawer6 = this.wsb;
        if (finderCommentDrawer6 == null) {
            p.btv("commentDrawer");
        }
        int scene = finderCommentDrawer6.getScene();
        FinderCommentDrawer finderCommentDrawer7 = this.wsb;
        if (finderCommentDrawer7 == null) {
            p.btv("commentDrawer");
        }
        boolean z3 = finderCommentDrawer7.tMV;
        FinderCommentDrawer finderCommentDrawer8 = this.wsb;
        if (finderCommentDrawer8 == null) {
            p.btv("commentDrawer");
        }
        long refCommentId = finderCommentDrawer8.getRefCommentId();
        FinderCommentDrawer finderCommentDrawer9 = this.wsb;
        if (finderCommentDrawer9 == null) {
            p.btv("commentDrawer");
        }
        an replyCommentObj = finderCommentDrawer9.getReplyCommentObj();
        FinderCommentDrawer finderCommentDrawer10 = this.wsb;
        if (finderCommentDrawer10 == null) {
            p.btv("commentDrawer");
        }
        boolean useCache = finderCommentDrawer10.getUseCache();
        FinderCommentDrawer finderCommentDrawer11 = this.wsb;
        if (finderCommentDrawer11 == null) {
            p.btv("commentDrawer");
        }
        boolean blinkRefComment = finderCommentDrawer11.getBlinkRefComment();
        FinderCommentDrawer finderCommentDrawer12 = this.wsb;
        if (finderCommentDrawer12 == null) {
            p.btv("commentDrawer");
        }
        boolean closeComment = finderCommentDrawer12.getCloseComment();
        FinderCommentDrawer finderCommentDrawer13 = this.wsb;
        if (finderCommentDrawer13 == null) {
            p.btv("commentDrawer");
        }
        nPresenter.a(finderCommentDrawer3, this, feedObj, onCloseDrawerCallback, scene, z3, refCommentId, replyCommentObj, useCache, blinkRefComment, closeComment, finderCommentDrawer13.getOldVersion());
        AppMethodBeat.o(168490);
    }

    @Override // com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c
    public final void bo(float f2) {
        AppMethodBeat.i(168491);
        FinderCommentDrawer finderCommentDrawer = this.wsb;
        if (finderCommentDrawer == null) {
            p.btv("commentDrawer");
        }
        if (finderCommentDrawer.tMV) {
            FinderCommentFooter finderCommentFooter = this.wsa;
            if (finderCommentFooter == null) {
                p.btv("drawerFooter");
            }
            if (finderCommentFooter.getFooterMode() == 2) {
                Context context2 = this.context;
                if (context2 == null) {
                    p.btv("context");
                }
                if (context2 == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                    AppMethodBeat.o(168491);
                    throw tVar;
                }
                ((MMFragmentActivity) context2).hideVKB();
            }
        }
        AppMethodBeat.o(168491);
    }

    public final void showLoading() {
        AppMethodBeat.i(168492);
        FrameLayout frameLayout = this.wrT;
        if (frameLayout == null) {
            p.btv("loadingLayout");
        }
        frameLayout.setVisibility(0);
        View view = this.hSw;
        if (view == null) {
            p.btv("loadingView");
        }
        view.setVisibility(0);
        View view2 = this.wrU;
        if (view2 == null) {
            p.btv("nothingView");
        }
        view2.setVisibility(8);
        View view3 = this.wrV;
        if (view3 == null) {
            p.btv("retryView");
        }
        view3.setVisibility(8);
        AppMethodBeat.o(168492);
    }

    public final void hideLoading() {
        AppMethodBeat.i(168493);
        FrameLayout frameLayout = this.wrT;
        if (frameLayout == null) {
            p.btv("loadingLayout");
        }
        frameLayout.setVisibility(8);
        View view = this.wrV;
        if (view == null) {
            p.btv("retryView");
        }
        view.setOnClickListener(null);
        AppMethodBeat.o(168493);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class i implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.a tPo;

        public i(kotlin.g.a.a aVar) {
            this.tPo = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(168476);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tPo.invoke();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(168476);
        }
    }

    @Override // com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c
    public final void dHu() {
        AppMethodBeat.i(255210);
        this.tzm.onDetach();
        AppMethodBeat.o(255210);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.view.builder.b$b  reason: collision with other inner class name */
    static final class C1335b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b wsi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1335b(b bVar) {
            super(0);
            this.wsi = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(255203);
            this.wsi.dHw().dGr();
            x xVar = x.SXb;
            AppMethodBeat.o(255203);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean wkL;
        final /* synthetic */ b wsi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b bVar, boolean z) {
            super(0);
            this.wsi = bVar;
            this.wkL = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(168474);
            if (!this.wkL || this.wsi.dHv().getFooterMode() != 2) {
                this.wsi.wsg.invoke();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(168474);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b wsi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(b bVar) {
            super(0);
            this.wsi = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            int i2;
            AppMethodBeat.i(178496);
            FinderCommentDrawer dHw = this.wsi.dHw();
            FinderCommentFooter finderCommentFooter = dHw.wkD;
            int scene = finderCommentFooter != null ? finderCommentFooter.getScene() : 0;
            y yVar = y.vXH;
            dHw.wkB = y.LF(dHw.wkB);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            com.tencent.mm.plugin.finder.storage.c.KQ(dHw.wkB);
            FinderItem finderItem = dHw.tMO;
            if (finderItem != null) {
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                Context context = dHw.getContext();
                p.g(context, "context");
                FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
                if (fH != null) {
                    i2 = fH.tCE;
                } else {
                    i2 = 0;
                }
                k kVar = k.vfA;
                long id = finderItem.getId();
                FinderItem Fc = k.Fc(id);
                if (Fc != null) {
                    ed edVar = new ed();
                    String cMD = ((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
                    if (cMD == null) {
                        cMD = "";
                    }
                    edVar.qJ(cMD);
                    edVar.qK(k.Fg(id));
                    edVar.lE((long) Fc.getLikeCount());
                    edVar.lF((long) Fc.getCommentCount());
                    edVar.lG((long) Fc.getFriendLikeCount());
                    edVar.lD((long) i2);
                    edVar.lH((long) scene);
                    edVar.bfK();
                    k.a(edVar);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(178496);
            return xVar;
        }
    }
}
