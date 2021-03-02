package com.tencent.mm.plugin.finder.view.builder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.dq;
import com.tencent.mm.plugin.finder.feed.aw;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.drawer.RecyclerViewDrawer;
import com.tencent.mm.view.drawer.RecyclerViewDrawerSquares;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0019J\u0006\u0010:\u001a\u000208J\u0006\u0010;\u001a\u000208J\u0018\u0010<\u001a\u0002082\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00101\u001a\u000202H\u0016J\u0018\u0010=\u001a\u0002082\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010>\u001a\u0002082\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\rH\u0016J\u0010\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u000208H\u0016J\u0018\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\u0019H\u0016J\u0010\u0010F\u001a\u0002082\u0006\u0010G\u001a\u00020HH\u0016J\u0006\u0010I\u001a\u000208J\u0006\u0010J\u001a\u000208J\u0014\u0010K\u001a\u0002082\f\u0010L\u001a\b\u0012\u0004\u0012\u0002080MR\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u001a\u0010#\u001a\u00020$X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020$X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020$X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u001a\u00101\u001a\u000202X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006O"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer$Builder;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "(Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "headerLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "()Landroid/widget/FrameLayout;", "setHeaderLayout", "(Landroid/widget/FrameLayout;)V", "headerTitleTv", "Landroid/widget/TextView;", "getHeaderTitleTv", "()Landroid/widget/TextView;", "setHeaderTitleTv", "(Landroid/widget/TextView;)V", "isReportExpose", "", "likeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "nothingView", "getNothingView", "setNothingView", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "retryView", "getRetryView", "setRetryView", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "enableRefresh", "", "enable", "hideAllTips", "hideLoading", "onBuildDrawerBody", "onBuildDrawerHeader", "onBuildLoading", "onDrawerCreated", "drawer", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "", "showLoading", "showNothingTips", "showRetryView", "onClick", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class a implements RecyclerViewDrawerSquares.c {
    public static final C1334a wrY = new C1334a((byte) 0);
    public Context context;
    public View hSw;
    public RefreshLoadMoreLayout tLS;
    public FinderLikeDrawer tLU;
    public TextView wrR;
    public FrameLayout wrS;
    public FrameLayout wrT;
    public View wrU;
    public View wrV;
    private boolean wrW;
    public final aw wrX;

    static {
        AppMethodBeat.i(255202);
        AppMethodBeat.o(255202);
    }

    public a(aw awVar) {
        p.h(awVar, "presenter");
        AppMethodBeat.i(255201);
        this.wrX = awVar;
        AppMethodBeat.o(255201);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.view.builder.a$a  reason: collision with other inner class name */
    public static final class C1334a {
        private C1334a() {
        }

        public /* synthetic */ C1334a(byte b2) {
            this();
        }
    }

    public final TextView dHs() {
        AppMethodBeat.i(255191);
        TextView textView = this.wrR;
        if (textView == null) {
            p.btv("headerTitleTv");
        }
        AppMethodBeat.o(255191);
        return textView;
    }

    public final RefreshLoadMoreLayout getRlLayout() {
        AppMethodBeat.i(255192);
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        AppMethodBeat.o(255192);
        return refreshLoadMoreLayout;
    }

    public final FinderLikeDrawer dcn() {
        AppMethodBeat.i(255193);
        FinderLikeDrawer finderLikeDrawer = this.tLU;
        if (finderLikeDrawer == null) {
            p.btv("likeDrawer");
        }
        AppMethodBeat.o(255193);
        return finderLikeDrawer;
    }

    public final Context getContext() {
        AppMethodBeat.i(255194);
        Context context2 = this.context;
        if (context2 == null) {
            p.btv("context");
        }
        AppMethodBeat.o(255194);
        return context2;
    }

    public final void a(RecyclerViewDrawer recyclerViewDrawer) {
        AppMethodBeat.i(255195);
        p.h(recyclerViewDrawer, "drawer");
        Context context2 = recyclerViewDrawer.getContext();
        p.g(context2, "drawer.context");
        this.context = context2;
        int scene = this.wrX.getScene();
        FinderLikeDrawer.a aVar = FinderLikeDrawer.wnm;
        if (scene == FinderLikeDrawer.tvl) {
            recyclerViewDrawer.setId(R.id.clq);
        } else {
            FinderLikeDrawer.a aVar2 = FinderLikeDrawer.wnm;
            if (scene == FinderLikeDrawer.tvm) {
                recyclerViewDrawer.setId(R.id.cln);
            }
        }
        this.tLU = (FinderLikeDrawer) recyclerViewDrawer;
        recyclerViewDrawer.setSquaresBackgroundResource(R.drawable.xf);
        recyclerViewDrawer.setEnableClickBackgroundToCloseDrawer(true);
        recyclerViewDrawer.setOnOpenDrawerListener(this);
        AppMethodBeat.o(255195);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ a wrZ;

        public b(a aVar) {
            this.wrZ = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255189);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.wrZ.dcn().dGr();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255189);
        }
    }

    public final void dHt() {
        AppMethodBeat.i(255196);
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout.setEnableRefresh(false);
        AppMethodBeat.o(255196);
    }

    @Override // com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c
    public final void S(boolean z, boolean z2) {
        bbn bbn;
        String str;
        AppMethodBeat.i(255197);
        if (z && z2) {
            aw awVar = this.wrX;
            FinderLikeDrawer finderLikeDrawer = this.tLU;
            if (finderLikeDrawer == null) {
                p.btv("likeDrawer");
            }
            FinderItem feedObj = finderLikeDrawer.getFeedObj();
            if (feedObj == null) {
                p.hyc();
            }
            FinderLikeDrawer finderLikeDrawer2 = this.tLU;
            if (finderLikeDrawer2 == null) {
                p.btv("likeDrawer");
            }
            awVar.a(this, feedObj, finderLikeDrawer2.getLikeBuffer());
        } else if (!z && z2) {
            this.wrX.onDetach();
        }
        if (!z) {
            int scene = this.wrX.getScene();
            FinderLikeDrawer.a aVar = FinderLikeDrawer.wnm;
            if (scene == FinderLikeDrawer.tvl && !this.wrW) {
                this.wrW = true;
                RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
                if (refreshLoadMoreLayout == null) {
                    p.btv("rlLayout");
                }
                RecyclerView.a adapter = refreshLoadMoreLayout.getRecyclerView().getAdapter();
                if (adapter != null) {
                    if (adapter instanceof WxRecyclerAdapter) {
                        k kVar = k.vfA;
                        String doc = k.doc();
                        int dcL = this.wrX.dcL();
                        String str2 = "";
                        int size = ((WxRecyclerAdapter) adapter).Rrx.size();
                        int i2 = 0;
                        while (i2 < size) {
                            com.tencent.mm.view.recyclerview.k valueAt = ((WxRecyclerAdapter) adapter).Rrx.valueAt(i2);
                            com.tencent.mm.view.recyclerview.a aVar2 = valueAt.Rrp;
                            if (aVar2 instanceof v) {
                                str = str2 + ((v) aVar2).uOk.dMW + ';' + valueAt.tIv + ';' + ((v) aVar2).uOk.likeFlag + '#';
                            } else {
                                str = str2;
                            }
                            i2++;
                            str2 = str;
                        }
                        y yVar = y.vXH;
                        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                        Context context2 = this.context;
                        if (context2 == null) {
                            p.btv("context");
                        }
                        FinderReporterUIC fH = FinderReporterUIC.a.fH(context2);
                        if (fH != null) {
                            bbn = fH.dIx();
                        } else {
                            bbn = null;
                        }
                        FinderLikeDrawer finderLikeDrawer3 = this.tLU;
                        if (finderLikeDrawer3 == null) {
                            p.btv("likeDrawer");
                        }
                        FinderItem feedObj2 = finderLikeDrawer3.getFeedObj();
                        if (!(bbn == null || feedObj2 == null)) {
                            k kVar2 = k.vfA;
                            long id = feedObj2.getId();
                            p.h(bbn, "contextObj");
                            p.h(str2, "exposeItems");
                            p.h(doc, "enterContextId");
                            if (k.Fc(id) != null) {
                                dq dqVar = new dq();
                                dqVar.ks((long) bbn.tCE);
                                dqVar.pv(bbn.sGQ);
                                dqVar.pw(bbn.sGE);
                                dqVar.pz(doc);
                                dqVar.pu(bbn.sessionId);
                                dqVar.py(d.zs(id));
                                dqVar.kr(dcL > 0 ? 1 : 0);
                                dqVar.px(str2);
                                dqVar.kt((long) dcL);
                                dqVar.bfK();
                                k.a(dqVar);
                            }
                        }
                    }
                    AppMethodBeat.o(255197);
                    return;
                }
                AppMethodBeat.o(255197);
                return;
            }
        } else {
            this.wrW = false;
        }
        AppMethodBeat.o(255197);
    }

    @Override // com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c
    public final void bo(float f2) {
    }

    @Override // com.tencent.mm.view.drawer.RecyclerViewDrawerSquares.c
    public final void dHu() {
        AppMethodBeat.i(255198);
        this.wrX.onDetach();
        AppMethodBeat.o(255198);
    }

    public final void showLoading() {
        AppMethodBeat.i(255199);
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
        AppMethodBeat.o(255199);
    }

    public final void hideLoading() {
        AppMethodBeat.i(255200);
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
        AppMethodBeat.o(255200);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.a tPo;

        public c(kotlin.g.a.a aVar) {
            this.tPo = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(255190);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tPo.invoke();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder$showRetryView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(255190);
        }
    }
}
