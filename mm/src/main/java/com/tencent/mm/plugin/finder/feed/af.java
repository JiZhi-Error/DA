package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.ui.FinderSnsGridFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.q;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class af {
    public static final af tQM = new af();

    static {
        AppMethodBeat.i(244170);
        AppMethodBeat.o(244170);
    }

    private af() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"})
    public static final class a extends c.a {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MMActivity mMActivity, BaseFinderFeedLoader baseFinderFeedLoader) {
            super(mMActivity, baseFinderFeedLoader);
            p.h(mMActivity, "context");
            p.h(baseFinderFeedLoader, "loader");
            AppMethodBeat.i(244159);
            AppMethodBeat.o(244159);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcb() {
            RefreshLoadMoreLayout refreshLoadMoreLayout;
            TextView textView;
            AppMethodBeat.i(244154);
            c.b bVar = this.tMd;
            if (bVar != null) {
                bVar.ab(this.tFM.getDataListJustForAdapter());
            }
            c.b bVar2 = this.tMd;
            if (bVar2 == null || (refreshLoadMoreLayout = bVar2.tLS) == null || (textView = (TextView) refreshLoadMoreLayout.findViewById(R.id.ep1)) == null) {
                AppMethodBeat.o(244154);
                return;
            }
            textView.setTextColor(this.gte.getResources().getColor(R.color.BW_100_Alpha_0_3));
            AppMethodBeat.o(244154);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void requestRefresh() {
            AppMethodBeat.i(244155);
            this.tFM.requestRefresh();
            AppMethodBeat.o(244155);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void boE() {
            AppMethodBeat.i(244156);
            this.tFM.requestLoadMore();
            AppMethodBeat.o(244156);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final void dcp() {
            AppMethodBeat.i(244157);
            BaseFeedLoader.requestInit$default(this.tFM, false, 1, null);
            AppMethodBeat.o(244157);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.a
        public final f dce() {
            AppMethodBeat.i(244158);
            c.b bVar = this.tMd;
            al dcs = bVar != null ? bVar.dcs() : null;
            if (dcs == null) {
                p.hyc();
            }
            f dcK = dcs.dcK();
            AppMethodBeat.o(244158);
            return dcK;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\u0003H\u0016J\u0016\u0010\r\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0019H\u0016J\u0016\u0010\u001a\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J$\u0010 \u001a\u00020\u001c2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "getActivity", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "Landroid/view/View;", "getHeaderView", "", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onGridItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "onItemDelete", "showEmptyView", "plugin-finder_release"})
    public static final class b extends c.b {
        private final String TAG = "Finder.FinderSnsPostUIContract.ViewCallback";

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final /* bridge */ /* synthetic */ View getHeaderView() {
            return null;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MMActivity mMActivity) {
            super(mMActivity, 0, 0, false);
            p.h(mMActivity, "context");
            AppMethodBeat.i(244169);
            AppMethodBeat.o(244169);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.h getItemDecoration() {
            AppMethodBeat.i(244161);
            RecyclerView.h itemDecoration = dcs().getItemDecoration();
            AppMethodBeat.o(244161);
            return itemDecoration;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void bIo() {
            AppMethodBeat.i(244163);
            super.bIo();
            View emptyView = getEmptyView();
            View findViewById = emptyView != null ? emptyView.findViewById(R.id.c2x) : null;
            if (findViewById != null) {
                findViewById.setVisibility(0);
                findViewById.findViewById(R.id.c2m).setOnClickListener(new a(this, findViewById));
                View findViewById2 = this.gte.findViewById(R.id.cb);
                p.g(findViewById2, "context.findViewById<Vie….action_bar_middle_title)");
                findViewById2.setVisibility(8);
                AppMethodBeat.o(244163);
                return;
            }
            AppMethodBeat.o(244163);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$1$1"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ b tQN;
            final /* synthetic */ View tQO;

            a(b bVar, View view) {
                this.tQN = bVar;
                this.tQO = view;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(244160);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                MMActivity mMActivity = this.tQN.gte;
                if (!(mMActivity instanceof FinderSnsGridFeedUI)) {
                    mMActivity = null;
                }
                FinderSnsGridFeedUI finderSnsGridFeedUI = (FinderSnsGridFeedUI) mMActivity;
                if (finderSnsGridFeedUI != null) {
                    finderSnsGridFeedUI.nd(true);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$ViewCallback$showEmptyView$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(244160);
            }
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final RecyclerView.LayoutManager eS(Context context) {
            AppMethodBeat.i(244164);
            p.h(context, "context");
            RecyclerView.LayoutManager eS = dcs().eS(context);
            AppMethodBeat.o(244164);
            return eS;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void m(h hVar) {
            AppMethodBeat.i(244165);
            p.h(hVar, "holder");
            View Mn = hVar.Mn(R.id.cka);
            if (Mn != null) {
                Mn.setVisibility(8);
            }
            View Mn2 = hVar.Mn(R.id.d0q);
            if (Mn2 != null) {
                Mn2.setVisibility(8);
            }
            View Mn3 = hVar.Mn(R.id.w0);
            if (Mn3 != null) {
                Mn3.setVisibility(8);
            }
            View Mn4 = hVar.Mn(R.id.cml);
            if (Mn4 != null) {
                Mn4.setVisibility(8);
            }
            TextView textView = (TextView) hVar.Mn(R.id.cl2);
            if (textView == null || textView.getVisibility() != 8) {
                View Mn5 = hVar.Mn(R.id.d03);
                if (Mn5 != null) {
                    Mn5.setVisibility(0);
                    Context context = hVar.getContext();
                    p.g(context, "holder.context");
                    Mn5.setBackgroundColor(context.getResources().getColor(R.color.y));
                }
                TextView textView2 = (TextView) hVar.Mn(R.id.cl2);
                if (textView2 != null) {
                    textView2.setTextColor(-1);
                    AppMethodBeat.o(244165);
                    return;
                }
                AppMethodBeat.o(244165);
                return;
            }
            View Mn6 = hVar.Mn(R.id.d03);
            if (Mn6 != null) {
                Mn6.setVisibility(8);
                AppMethodBeat.o(244165);
                return;
            }
            AppMethodBeat.o(244165);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void a(RecyclerView.a<?> aVar, View view, int i2) {
            AppMethodBeat.i(244166);
            p.h(aVar, "adapter");
            p.h(view, "view");
            int size = i2 - ((g) aVar).RqM.size();
            if (size >= 0 && size < dcq().tFM.getSize()) {
                bo boVar = (bo) dcq().tFM.getDataListJustForAdapter().get(size);
                if (!(boVar instanceof BaseFinderFeed)) {
                    AppMethodBeat.o(244166);
                    return;
                }
                Log.i(this.TAG, "onClick " + size + " id:" + ((BaseFinderFeed) boVar).feedObject.getId() + ", pos:" + size);
                if (((BaseFinderFeed) boVar).feedObject.isPostFinish()) {
                    s.a aVar2 = s.vWt;
                    s.a.a(this.gte, (BaseFinderFeed) boVar, 5, 0, 20);
                    MMActivity mMActivity = this.gte;
                    if (!(mMActivity instanceof FinderSnsGridFeedUI)) {
                        mMActivity = null;
                    }
                    FinderSnsGridFeedUI finderSnsGridFeedUI = (FinderSnsGridFeedUI) mMActivity;
                    if (finderSnsGridFeedUI != null) {
                        finderSnsGridFeedUI.ucW = true;
                    }
                    q qVar = q.vgE;
                    com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                    String str = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).sessionId;
                    if (str == null) {
                        str = "";
                    }
                    q.a(str, 3, null, false, false, ((BaseFinderFeed) boVar).feedObject.getId(), 28);
                    AppMethodBeat.o(244166);
                    return;
                }
                u.makeText(this.gte, (int) R.string.co2, 0).show();
            }
            AppMethodBeat.o(244166);
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String b(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244167);
            p.h(cVar, "reason");
            AppMethodBeat.o(244167);
            return "";
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final String c(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244168);
            p.h(cVar, "reason");
            AppMethodBeat.o(244168);
            return "";
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final void dcv() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getEmptyView() {
            AppMethodBeat.i(244162);
            View findViewById = this.gte.findViewById(R.id.c3e);
            AppMethodBeat.o(244162);
            return findViewById;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.gte;
        }
    }
}
