package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveWecoinHotLoader;
import com.tencent.mm.plugin.finder.live.widget.v;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class FinderLiveWeCoinHotConstract {
    public static final FinderLiveWeCoinHotConstract uXL = new FinderLiveWeCoinHotConstract();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001dJ\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%J\u0006\u0010&\u001a\u00020\u001fJ\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020\u001fH\u0016J\u0006\u0010*\u001a\u00020\u001fR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader;", "newHeatValue", "", "getNewHeatValue", "()J", "setNewHeatValue", "(J)V", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback;)V", "getData", "Ljava/util/ArrayList;", "goToFinderProfileImpl", "", "context", "Landroid/content/Context;", "finderUsername", "", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "loadMore", "onAttach", "callback", "onDetach", "refresh", "Companion", "plugin-finder_release"})
    public static final class Presenter implements a<ViewCallback> {
        public static final Companion uXO = new Companion((byte) 0);
        public long USA;
        public WxRecyclerAdapter<bo> tFp;
        private j tMe = new j() {
            /* class com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract.Presenter.AnonymousClass1 */

            @Override // com.tencent.mm.view.i
            public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(249830);
                p.h(cVar, "reason");
                AppMethodBeat.o(249830);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(249831);
                p.h(cVar, "reason");
                AppMethodBeat.o(249831);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(249832);
                p.h(cVar, "reason");
                AppMethodBeat.o(249832);
            }

            @Override // com.tencent.mm.view.j
            public final void onChanged() {
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3) {
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3, Object obj) {
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeInserted(int i2, int i3) {
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeRemoved(int i2, int i3) {
            }
        };
        ViewCallback uXM;
        final FinderLiveWecoinHotLoader uXN;

        static {
            AppMethodBeat.i(249841);
            AppMethodBeat.o(249841);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(byte b2) {
                this();
            }
        }

        public Presenter(FinderLiveWecoinHotLoader finderLiveWecoinHotLoader) {
            p.h(finderLiveWecoinHotLoader, "loader");
            AppMethodBeat.i(249840);
            this.uXN = finderLiveWecoinHotLoader;
            AppMethodBeat.o(249840);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(ViewCallback viewCallback) {
            AppMethodBeat.i(249838);
            a(viewCallback);
            AppMethodBeat.o(249838);
        }

        public final WxRecyclerAdapter<bo> getAdapter() {
            AppMethodBeat.i(249836);
            WxRecyclerAdapter<bo> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter == null) {
                p.btv("adapter");
            }
            AppMethodBeat.o(249836);
            return wxRecyclerAdapter;
        }

        public final void a(ViewCallback viewCallback) {
            AppMethodBeat.i(249837);
            p.h(viewCallback, "callback");
            WxRecyclerAdapter<bo> wxRecyclerAdapter = new WxRecyclerAdapter<>(new FinderLiveWeCoinHotConstract$Presenter$onAttach$1(), this.uXN.getDataListJustForAdapter());
            wxRecyclerAdapter.RqP = new FinderLiveWeCoinHotConstract$Presenter$onAttach$$inlined$apply$lambda$1(this);
            this.tFp = wxRecyclerAdapter;
            this.uXN.fetchEndCallback = new FinderLiveWeCoinHotConstract$Presenter$onAttach$3(this);
            this.uXM = viewCallback;
            ViewCallback viewCallback2 = this.uXM;
            if (viewCallback2 != null) {
                View findViewById = viewCallback2.activity.findViewById(R.id.czr);
                p.g(findViewById, "activity.findViewById(R.…ive_wecoin_hot_top_group)");
                viewCallback2.uXR = (RelativeLayout) findViewById;
                View findViewById2 = viewCallback2.activity.findViewById(R.id.czs);
                p.g(findViewById2, "activity.findViewById(R.…_wecoin_hot_top_title_tv)");
                viewCallback2.uXS = (TextView) findViewById2;
                View findViewById3 = viewCallback2.activity.findViewById(R.id.czq);
                p.g(findViewById3, "activity.findViewById(R.…wecoin_hot_top_back_icon)");
                viewCallback2.uXT = findViewById3;
                View findViewById4 = viewCallback2.activity.findViewById(R.id.czp);
                p.g(findViewById4, "activity.findViewById(R.…wecoin_hot_top_action_tv)");
                viewCallback2.uXU = (TextView) findViewById4;
                View findViewById5 = viewCallback2.activity.findViewById(R.id.czm);
                p.g(findViewById5, "activity.findViewById(R.…e_wecoin_hot_title_group)");
                viewCallback2.uXV = (RelativeLayout) findViewById5;
                View findViewById6 = viewCallback2.activity.findViewById(R.id.czo);
                p.g(findViewById6, "activity.findViewById(R.…live_wecoin_hot_title_tv)");
                viewCallback2.titleTv = (TextView) findViewById6;
                View findViewById7 = viewCallback2.activity.findViewById(R.id.czn);
                p.g(findViewById7, "activity.findViewById(R.…ve_wecoin_hot_title_icon)");
                viewCallback2.uPW = (WeImageView) findViewById7;
                View findViewById8 = viewCallback2.activity.findViewById(R.id.czl);
                p.g(findViewById8, "activity.findViewById(R.…coin_hot_title_amount_tv)");
                viewCallback2.uXW = (TextView) findViewById8;
                View findViewById9 = viewCallback2.activity.findViewById(R.id.cza);
                p.g(findViewById9, "activity.findViewById(R.…ive_wecoin_hot_empty_tip)");
                viewCallback2.qqJ = (TextView) findViewById9;
                View findViewById10 = viewCallback2.activity.findViewById(R.id.czi);
                p.g(findViewById10, "activity.findViewById(R.…_live_wecoin_hot_loading)");
                viewCallback2.hSw = findViewById10;
                View findViewById11 = viewCallback2.activity.findViewById(R.id.czh);
                p.g(findViewById11, "activity.findViewById(R.…der_live_wecoin_hot_list)");
                viewCallback2.uXQ = (RecyclerView) findViewById11;
                RecyclerView recyclerView = viewCallback2.uXQ;
                if (recyclerView == null) {
                    p.btv("wecoinRecyclerView");
                }
                recyclerView.setLayoutManager(new LinearLayoutManager());
                RecyclerView recyclerView2 = viewCallback2.uXQ;
                if (recyclerView2 == null) {
                    p.btv("wecoinRecyclerView");
                }
                recyclerView2.setAdapter(viewCallback2.uXX.getAdapter());
                TextView textView = viewCallback2.uXS;
                if (textView == null) {
                    p.btv("topTitleTv");
                }
                ao.a(textView.getPaint(), 0.8f);
                RelativeLayout relativeLayout = viewCallback2.uXV;
                if (relativeLayout == null) {
                    p.btv("titleGroup");
                }
                relativeLayout.setVisibility(8);
                RecyclerView recyclerView3 = viewCallback2.uXQ;
                if (recyclerView3 == null) {
                    p.btv("wecoinRecyclerView");
                }
                recyclerView3.setVisibility(8);
                TextView textView2 = viewCallback2.qqJ;
                if (textView2 == null) {
                    p.btv("emptyTv");
                }
                textView2.setVisibility(8);
                View view = viewCallback2.hSw;
                if (view == null) {
                    p.btv("loadingView");
                }
                view.setVisibility(8);
                WeImageView weImageView = viewCallback2.uPW;
                if (weImageView == null) {
                    p.btv("titleIv");
                }
                weImageView.setOnClickListener(new FinderLiveWeCoinHotConstract$ViewCallback$initView$1(viewCallback2));
                RelativeLayout relativeLayout2 = viewCallback2.uXR;
                if (relativeLayout2 == null) {
                    p.btv("topGroup");
                }
                ViewGroup.LayoutParams layoutParams = relativeLayout2.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(249837);
                    throw tVar;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = au.getStatusBarHeight(viewCallback2.activity) + marginLayoutParams.topMargin;
                View view2 = viewCallback2.uXT;
                if (view2 == null) {
                    p.btv("topBackBtn");
                }
                view2.setOnClickListener(new FinderLiveWeCoinHotConstract$ViewCallback$initView$2(viewCallback2));
                TextView textView3 = viewCallback2.uXU;
                if (textView3 == null) {
                    p.btv("topActionTv");
                }
                textView3.setOnClickListener(new FinderLiveWeCoinHotConstract$ViewCallback$initView$3(viewCallback2));
                View findViewById12 = viewCallback2.activity.findViewById(R.id.cva);
                if (findViewById12 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(249837);
                    throw tVar2;
                }
                viewCallback2.UMS = new v((ViewGroup) findViewById12);
                v vVar = viewCallback2.UMS;
                if (vVar != null) {
                    vVar.hUn();
                    vVar.URo = new FinderLiveWeCoinHotConstract$ViewCallback$initView$4$1(vVar);
                    vVar.URp = new FinderLiveWeCoinHotConstract$ViewCallback$initView$$inlined$apply$lambda$1(vVar, viewCallback2);
                }
                viewCallback2.uXX.uXN.requestRefresh();
            }
            this.uXN.register(this.tMe);
            AppMethodBeat.o(249837);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            v vVar;
            AppMethodBeat.i(249839);
            this.uXN.unregister(this.tMe);
            ViewCallback viewCallback = this.uXM;
            if (viewCallback == null || (vVar = viewCallback.UMS) == null) {
                AppMethodBeat.o(249839);
                return;
            }
            vVar.hUo();
            AppMethodBeat.o(249839);
        }

        public static void bD(Context context, String str) {
            AppMethodBeat.i(261268);
            p.h(context, "context");
            p.h(str, "finderUsername");
            Intent intent = new Intent();
            intent.putExtra("key_from_profile_share_scene", 0);
            intent.putExtra("finder_username", str);
            intent.putExtra("key_enter_profile_type", 11);
            ((aj) g.ah(aj.class)).enterFinderProfileUI(context, intent);
            AppMethodBeat.o(261268);
        }
    }

    static {
        AppMethodBeat.i(249846);
        AppMethodBeat.o(249846);
    }

    private FinderLiveWeCoinHotConstract() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010=\u001a\u00020\u0004H\u0016J\b\u0010>\u001a\u00020\u0002H\u0016J\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020CJ\u000e\u0010D\u001a\u00020@2\u0006\u0010B\u001a\u00020CJ\u0006\u0010E\u001a\u00020@R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\fR\u001a\u0010+\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\fR\u001a\u0010.\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u001a\u00101\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\u001a\u00104\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\n\"\u0004\b6\u0010\fR\u001a\u00107\u001a\u000208X.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;)V", "emptyTv", "Landroid/widget/TextView;", "getEmptyTv", "()Landroid/widget/TextView;", "setEmptyTv", "(Landroid/widget/TextView;)V", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "profileWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;", "getProfileWidget", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;", "setProfileWidget", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMemebrProfileWidget;)V", "titleAmountTv", "getTitleAmountTv", "setTitleAmountTv", "titleGroup", "Landroid/widget/RelativeLayout;", "getTitleGroup", "()Landroid/widget/RelativeLayout;", "setTitleGroup", "(Landroid/widget/RelativeLayout;)V", "titleIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getTitleIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setTitleIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "topActionTv", "getTopActionTv", "setTopActionTv", "topBackBtn", "getTopBackBtn", "setTopBackBtn", "topGroup", "getTopGroup", "setTopGroup", "topTitleTv", "getTopTitleTv", "setTopTitleTv", "wecoinRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getWecoinRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setWecoinRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getActivity", "getPresenter", "initView", "", "showContentView", "wecoinHotResp", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveWecoinHotLoader$LiveWecoinHotResponse;", "showEmptyView", "showProgress", "plugin-finder_release"})
    public static final class ViewCallback implements c<Presenter> {
        v UMS;
        final MMActivity activity;
        public View hSw;
        public TextView qqJ;
        public TextView titleTv;
        public WeImageView uPW;
        public RecyclerView uXQ;
        public RelativeLayout uXR;
        public TextView uXS;
        public View uXT;
        public TextView uXU;
        public RelativeLayout uXV;
        public TextView uXW;
        final Presenter uXX;

        public ViewCallback(MMActivity mMActivity, Presenter presenter) {
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(presenter, "presenter");
            AppMethodBeat.i(249845);
            this.activity = mMActivity;
            this.uXX = presenter;
            AppMethodBeat.o(249845);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.activity;
        }
    }
}
