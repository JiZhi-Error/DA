package com.tencent.mm.plugin.finder.megavideo.ui;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class a {
    public static final a uLD = new a();

    static {
        AppMethodBeat.i(248482);
        AppMethodBeat.o(248482);
    }

    private a() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u001dH&J\u0012\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u001dH&J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0002H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u001dH\u0016J\b\u0010'\u001a\u00020\u001dH\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020\u001dH&R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getIViewActionCallback", "initViewCallback", "", "keep", "p0", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC1222a implements com.tencent.mm.plugin.finder.presenter.base.a<b>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> {
        private final MMActivity gte;
        private j tMe = new j(this) {
            /* class com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a.AnonymousClass1 */
            final /* synthetic */ AbstractC1222a uLG;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.uLG = r1;
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                AppMethodBeat.i(248462);
                p.h(cVar, "reason");
                b bVar = this.uLG.uLE;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(248462);
                    return;
                }
                refreshLoadMoreLayout.onPreFinishRefresh(cVar);
                AppMethodBeat.o(248462);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                AppMethodBeat.i(248463);
                p.h(cVar, "reason");
                b bVar = this.uLG.uLE;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(248463);
                    return;
                }
                refreshLoadMoreLayout.onPreFinishLoadMore(cVar);
                AppMethodBeat.o(248463);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                AppMethodBeat.i(248464);
                p.h(cVar, "reason");
                b bVar = this.uLG.uLE;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(248464);
                    return;
                }
                refreshLoadMoreLayout.onPreFinishLoadMoreSmooth(cVar);
                AppMethodBeat.o(248464);
            }

            @Override // com.tencent.mm.view.j
            public final void onChanged() {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                AppMethodBeat.i(248465);
                b bVar = this.uLG.uLE;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(248465);
                    return;
                }
                refreshLoadMoreLayout.onChanged();
                AppMethodBeat.o(248465);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                int i4;
                WxRecyclerAdapter<?> adapter;
                AppMethodBeat.i(248466);
                b bVar = this.uLG.uLE;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(248466);
                    return;
                }
                b bVar2 = this.uLG.uLE;
                if (bVar2 == null || (adapter = bVar2.getAdapter()) == null) {
                    i4 = 0;
                } else {
                    i4 = adapter.RqM.size();
                }
                refreshLoadMoreLayout.onItemRangeChanged(i4 + i2, i3);
                AppMethodBeat.o(248466);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3, Object obj) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                int i4;
                WxRecyclerAdapter<?> adapter;
                AppMethodBeat.i(248467);
                b bVar = this.uLG.uLE;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(248467);
                    return;
                }
                b bVar2 = this.uLG.uLE;
                if (bVar2 == null || (adapter = bVar2.getAdapter()) == null) {
                    i4 = 0;
                } else {
                    i4 = adapter.RqM.size();
                }
                refreshLoadMoreLayout.onItemRangeChanged(i4 + i2, i3, obj);
                AppMethodBeat.o(248467);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeInserted(int i2, int i3) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                int i4;
                WxRecyclerAdapter<?> adapter;
                AppMethodBeat.i(248468);
                b bVar = this.uLG.uLE;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(248468);
                    return;
                }
                b bVar2 = this.uLG.uLE;
                if (bVar2 == null || (adapter = bVar2.getAdapter()) == null) {
                    i4 = 0;
                } else {
                    i4 = adapter.RqM.size();
                }
                refreshLoadMoreLayout.onItemRangeInserted(i4 + i2, i3);
                AppMethodBeat.o(248468);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeRemoved(int i2, int i3) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                int i4;
                WxRecyclerAdapter<?> adapter;
                AppMethodBeat.i(248469);
                b bVar = this.uLG.uLE;
                if (!(bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null)) {
                    b bVar2 = this.uLG.uLE;
                    if (bVar2 == null || (adapter = bVar2.getAdapter()) == null) {
                        i4 = 0;
                    } else {
                        i4 = adapter.RqM.size();
                    }
                    refreshLoadMoreLayout.onItemRangeRemoved(i4 + i2, i3);
                }
                b bVar3 = this.uLG.uLE;
                if (bVar3 != null) {
                    bVar3.dcv();
                    AppMethodBeat.o(248469);
                    return;
                }
                AppMethodBeat.o(248469);
            }
        };
        b uLE;
        final BaseMegaVideoLoader uLF;

        public abstract void boE();

        public abstract void dcb();

        public abstract f dce();

        public abstract void requestRefresh();

        public AbstractC1222a(MMActivity mMActivity, BaseMegaVideoLoader baseMegaVideoLoader) {
            p.h(mMActivity, "context");
            p.h(baseMegaVideoLoader, "feedLoader");
            this.gte = mMActivity;
            this.uLF = baseMegaVideoLoader;
        }

        /* renamed from: a */
        public void onAttach(b bVar) {
            p.h(bVar, "callback");
            this.uLE = bVar;
            this.uLF.register(this.tMe);
            dcb();
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public void onDetach() {
            this.uLF.unregister(this.tMe);
        }

        @Override // com.tencent.mm.vending.e.b
        public void keep(com.tencent.mm.vending.e.a aVar) {
        }

        public void dcp() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010&\u001a\u0006\u0012\u0002\b\u00030\fJ\n\u0010'\u001a\u0004\u0018\u00010\u0006H&J\n\u0010(\u001a\u0004\u0018\u00010\u0006H&J\b\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020/H\u0016J\u0006\u00100\u001a\u000201J\u001e\u00102\u001a\u0002032\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020605j\b\u0012\u0004\u0012\u000206`7J\u0018\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\tH\u0016J$\u0010<\u001a\u0002032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030=2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\tH&J\b\u0010?\u001a\u000203H&J\b\u0010@\u001a\u000203H\u0016J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u000203H\u0016J\u0010\u0010D\u001a\u0002032\u0006\u0010E\u001a\u00020\u0006H\u0002R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fX.¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "rootView", "Landroid/view/View;", "(Lcom/tencent/mm/ui/MMActivity;Landroid/view/View;)V", "VIEW_TYPE_FOOTER", "", "VIEW_TYPE_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "finderManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getFinderManager", "()Landroid/support/v7/widget/RecyclerView$LayoutManager;", "setFinderManager", "(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V", "headerview", "getHeaderview", "()Landroid/view/View;", "setHeaderview", "(Landroid/view/View;)V", "present", "getPresent", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "setPresent", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getRootView", "getAdapter", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/content/Context;", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onItemClick", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "onItemDelete", "onViewPrepared", "refreshWhenEnter", "", "showEmptyView", "showEmptyViewInternal", "emptyView", "plugin-finder_release"})
    public static abstract class b implements com.tencent.mm.plugin.finder.presenter.base.c<AbstractC1222a> {
        final MMActivity gte;
        final View lJI;
        private WxRecyclerAdapter<?> tFp;
        public RefreshLoadMoreLayout tLS;
        private final int tMh;
        private final int tMi = -1;
        public RecyclerView.LayoutManager tMk;
        private View tMl;
        public AbstractC1222a uLH;

        public abstract void b(RecyclerView.a<?> aVar, View view, int i2);

        public abstract void dcv();

        public abstract View getEmptyView();

        public b(MMActivity mMActivity, View view) {
            p.h(mMActivity, "context");
            p.h(view, "rootView");
            this.gte = mMActivity;
            this.lJI = view;
            View findViewById = this.lJI.findViewById(R.id.h7t);
            p.g(findViewById, "rootView.findViewById(R.id.rl_layout)");
            this.tLS = (RefreshLoadMoreLayout) findViewById;
        }

        public final void a(AbstractC1222a aVar) {
            p.h(aVar, "<set-?>");
            this.uLH = aVar;
        }

        public final AbstractC1222a dkm() {
            AbstractC1222a aVar = this.uLH;
            if (aVar == null) {
                p.btv("present");
            }
            return aVar;
        }

        public final AbstractC1222a dkn() {
            AbstractC1222a aVar = this.uLH;
            if (aVar == null) {
                p.btv("present");
            }
            return aVar;
        }

        public void dbY() {
            com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), new d(this));
        }

        public final void ab(ArrayList<bo> arrayList) {
            p.h(arrayList, "data");
            RecyclerView recyclerView = this.tLS.getRecyclerView();
            MMActivity mMActivity = this.gte;
            p.h(mMActivity, "context");
            this.tMk = new FinderLinearLayoutManager(mMActivity);
            RecyclerView.LayoutManager layoutManager = this.tMk;
            if (layoutManager == null) {
                p.btv("finderManager");
            }
            recyclerView.setLayoutManager(layoutManager);
            this.tFp = new C1223a(this, arrayList, dkn().dce(), arrayList);
            WxRecyclerAdapter<?> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter == null) {
                p.btv("adapter");
            }
            recyclerView.setAdapter(wxRecyclerAdapter);
            int[] iArr = new int[4];
            iArr[0] = c.a.a(this).getDimensionPixelOffset(R.dimen.ct);
            recyclerView.b(new com.tencent.mm.plugin.finder.view.decoration.b(new ColorDrawable(c.a.a(this).getColor(R.color.FG_3)), (int) c.a.a(this).getDimension(R.dimen.a4d), iArr));
            WxRecyclerAdapter<?> wxRecyclerAdapter2 = this.tFp;
            if (wxRecyclerAdapter2 == null) {
                p.btv("adapter");
            }
            wxRecyclerAdapter2.RqP = new C1224b(this);
            this.tMl = null;
            if (this.tMl != null) {
                WxRecyclerAdapter<?> wxRecyclerAdapter3 = this.tFp;
                if (wxRecyclerAdapter3 == null) {
                    p.btv("adapter");
                }
                if (wxRecyclerAdapter3 != null) {
                    View view = this.tMl;
                    if (view == null) {
                        p.hyc();
                    }
                    g.b unused = wxRecyclerAdapter3.f(view, this.tMh, true);
                }
            }
            this.tLS.setActionCallback(new c(this));
            dbY();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J&\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "payloads", "", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.a$b$a  reason: collision with other inner class name */
        public static final class C1223a extends WxRecyclerAdapter<bo> {
            final /* synthetic */ ArrayList tMn;
            final /* synthetic */ b uLI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1223a(b bVar, ArrayList arrayList, f fVar, ArrayList arrayList2) {
                super(fVar, arrayList2);
                this.uLI = bVar;
                this.tMn = arrayList;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
            @Override // com.tencent.mm.view.recyclerview.g, android.support.v7.widget.RecyclerView.a
            public final /* synthetic */ void a(h hVar, int i2, List list) {
                AppMethodBeat.i(248471);
                h hVar2 = hVar;
                p.h(hVar2, "holder");
                p.h(list, "payloads");
                super.a(hVar2, i2, list);
                p.h(hVar2, "holder");
                AppMethodBeat.o(248471);
            }

            @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter
            public final void n(RecyclerView recyclerView) {
                AppMethodBeat.i(248470);
                p.h(recyclerView, "recyclerView");
                AppMethodBeat.o(248470);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.a$b$b  reason: collision with other inner class name */
        public static final class C1224b implements g.c<h> {
            final /* synthetic */ b uLI;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C1224b(b bVar) {
                this.uLI = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
            @Override // com.tencent.mm.view.recyclerview.g.c
            public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
                AppMethodBeat.i(248472);
                p.h(aVar, "adapter");
                p.h(view, "view");
                p.h(hVar, "holder");
                this.uLI.b(aVar, view, i2);
                AppMethodBeat.o(248472);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0016\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
        public static final class c extends RefreshLoadMoreLayout.a {
            private boolean tMa = true;
            final /* synthetic */ b uLI;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            c(b bVar) {
                this.uLI = bVar;
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
                int i2;
                AppMethodBeat.i(248477);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                p.h(cVar, "reason");
                super.onRefreshEnd(cVar);
                View emptyView = this.uLI.getEmptyView();
                if (emptyView != null) {
                    RecyclerView.a adapter = this.uLI.tLS.getRecyclerView().getAdapter();
                    if (!(adapter instanceof WxRecyclerAdapter)) {
                        adapter = null;
                    }
                    WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
                    if (cVar.Rmh != -1) {
                        if (wxRecyclerAdapter != null) {
                            i2 = wxRecyclerAdapter.hgt();
                        } else {
                            i2 = 0;
                        }
                        if (i2 <= 0) {
                            this.uLI.bIo();
                        } else {
                            emptyView.setVisibility(8);
                            RefreshLoadMoreLayout refreshLoadMoreLayout = this.uLI.tLS;
                            if (refreshLoadMoreLayout != null) {
                                refreshLoadMoreLayout.setVisibility(0);
                            }
                        }
                    } else {
                        emptyView.setVisibility(0);
                        RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.uLI.tLS;
                        if (refreshLoadMoreLayout2 != null) {
                            refreshLoadMoreLayout2.setVisibility(8);
                        }
                        TextView textView = (TextView) emptyView.findViewById(R.id.c35);
                        if (textView != null) {
                            textView.setVisibility(8);
                        }
                        TextView textView2 = (TextView) emptyView.findViewById(R.id.h5w);
                        if (textView2 != null) {
                            textView2.setVisibility(0);
                        }
                        View findViewById = emptyView.findViewById(R.id.gl7);
                        if (findViewById != null) {
                            findViewById.setVisibility(8);
                        }
                        View findViewById2 = emptyView.findViewById(R.id.h5w);
                        if (findViewById2 != null) {
                            findViewById2.setOnClickListener(new View$OnClickListenerC1227c(emptyView, this, cVar));
                        }
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(248477);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4$onRefreshEnd$1$1"})
            /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.a$b$c$c  reason: collision with other inner class name */
            static final class View$OnClickListenerC1227c implements View.OnClickListener {
                final /* synthetic */ View tCl;
                final /* synthetic */ RefreshLoadMoreLayout.c tMp;
                final /* synthetic */ c uLJ;

                View$OnClickListenerC1227c(View view, c cVar, RefreshLoadMoreLayout.c cVar2) {
                    this.tCl = view;
                    this.uLJ = cVar;
                    this.tMp = cVar2;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(248476);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    p.g(view, LocaleUtil.ITALIAN);
                    view.setVisibility(8);
                    View findViewById = this.tCl.findViewById(R.id.gl7);
                    if (findViewById != null) {
                        findViewById.setVisibility(0);
                    }
                    com.tencent.f.h.RTc.aX(new Runnable(this) {
                        /* class com.tencent.mm.plugin.finder.megavideo.ui.a.b.c.View$OnClickListenerC1227c.AnonymousClass1 */
                        final /* synthetic */ View$OnClickListenerC1227c uLK;

                        {
                            this.uLK = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(248475);
                            this.uLK.uLJ.uLI.dkm().requestRefresh();
                            AppMethodBeat.o(248475);
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(248476);
                }
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void ED(int i2) {
                View emptyView;
                AppMethodBeat.i(248478);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
                super.ED(i2);
                if (this.uLI.dkn().uLF.getSize() == 0 && (emptyView = this.uLI.getEmptyView()) != null) {
                    emptyView.setVisibility(0);
                    RefreshLoadMoreLayout refreshLoadMoreLayout = this.uLI.tLS;
                    if (refreshLoadMoreLayout != null) {
                        refreshLoadMoreLayout.setVisibility(8);
                    }
                    View findViewById = emptyView.findViewById(R.id.gl7);
                    if (findViewById != null) {
                        findViewById.setVisibility(0);
                    }
                }
                com.tencent.f.h.RTc.aX(new RunnableC1226b(this));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
                AppMethodBeat.o(248478);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.a$b$c$b  reason: collision with other inner class name */
            static final class RunnableC1226b implements Runnable {
                final /* synthetic */ c uLJ;

                RunnableC1226b(c cVar) {
                    this.uLJ = cVar;
                }

                public final void run() {
                    AppMethodBeat.i(248474);
                    this.uLJ.uLI.dkm().requestRefresh();
                    AppMethodBeat.o(248474);
                }
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void cxo() {
                AppMethodBeat.i(248479);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
                super.cxo();
                com.tencent.f.h.RTc.aX(new RunnableC1225a(this));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
                AppMethodBeat.o(248479);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.finder.megavideo.ui.a$b$c$a  reason: collision with other inner class name */
            static final class RunnableC1225a implements Runnable {
                final /* synthetic */ c uLJ;

                RunnableC1225a(c cVar) {
                    this.uLJ = cVar;
                }

                public final void run() {
                    AppMethodBeat.i(248473);
                    this.uLJ.uLI.dkm().boE();
                    AppMethodBeat.o(248473);
                }
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(248480);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                p.h(cVar, "reason");
                super.a(cVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(248480);
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void IF(int i2) {
                if (this.tMa && i2 > 0) {
                    this.tMa = false;
                }
            }
        }

        public final WxRecyclerAdapter<?> getAdapter() {
            WxRecyclerAdapter<?> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter == null) {
                p.btv("adapter");
            }
            return wxRecyclerAdapter;
        }

        public void bIo() {
            View emptyView = getEmptyView();
            if (emptyView != null) {
                emptyView.setVisibility(0);
                RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
                if (refreshLoadMoreLayout != null) {
                    refreshLoadMoreLayout.setVisibility(8);
                }
                TextView textView = (TextView) emptyView.findViewById(R.id.c35);
                if (textView != null) {
                    textView.setVisibility(0);
                }
                View findViewById = emptyView.findViewById(R.id.gl7);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                View findViewById2 = emptyView.findViewById(R.id.h5w);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(8);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
        public static final class d extends q implements kotlin.g.a.b<Void, x> {
            final /* synthetic */ b uLI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(b bVar) {
                super(1);
                this.uLI = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Void r3) {
                AppMethodBeat.i(248481);
                this.uLI.dkn().dcp();
                RefreshLoadMoreLayout.d(this.uLI.tLS);
                x xVar = x.SXb;
                AppMethodBeat.o(248481);
                return xVar;
            }
        }
    }
}
