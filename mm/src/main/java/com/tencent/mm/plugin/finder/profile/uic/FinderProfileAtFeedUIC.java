package com.tencent.mm.plugin.finder.profile.uic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001 \u0018\u0000 52\u00020\u0001:\u000256B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u000200H\u0016J\b\u00104\u001a\u000200H\u0016R\u001f\u0010\u0005\u001a\u00060\u0006R\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0004\n\u0002\u0010!R#\u0010\"\u001a\n $*\u0004\u0018\u00010#0#8BX\u0002¢\u0006\f\n\u0004\b'\u0010\n\u001a\u0004\b%\u0010&R#\u0010(\u001a\n $*\u0004\u0018\u00010)0)8BX\u0002¢\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b*\u0010+¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "feedLoader", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "feedLoader$delegate", "layoutConfig", "Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "layoutConfig$delegate", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/RecyclerView$LayoutManager;", "layoutManager$delegate", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "removeFeedEventListener", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$removeFeedEventListener$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$removeFeedEventListener$1;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "Landroid/widget/FrameLayout;", "getStateLayout", "()Landroid/widget/FrameLayout;", "stateLayout$delegate", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onUserVisibleFocused", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class FinderProfileAtFeedUIC extends FinderProfileFragmentUIC {
    public static final a vay = new a((byte) 0);
    private final kotlin.f tPy = kotlin.g.ah(new d(this));
    private final kotlin.f tSX;
    private final kotlin.f vas = kotlin.g.ah(new e(this));
    private final kotlin.f vat = kotlin.g.ah(new f(this));
    private final kotlin.f vau;
    private final kotlin.f vav;
    private final kotlin.f vaw;
    private final k vax;

    static {
        AppMethodBeat.i(250124);
        AppMethodBeat.o(250124);
    }

    private final FinderAtFeedLoader dmm() {
        AppMethodBeat.i(250115);
        FinderAtFeedLoader finderAtFeedLoader = (FinderAtFeedLoader) this.tPy.getValue();
        AppMethodBeat.o(250115);
        return finderAtFeedLoader;
    }

    private final af dmn() {
        AppMethodBeat.i(250116);
        af afVar = (af) this.vas.getValue();
        AppMethodBeat.o(250116);
        return afVar;
    }

    private final b dmo() {
        AppMethodBeat.i(250119);
        b bVar = (b) this.vaw.getValue();
        AppMethodBeat.o(250119);
        return bVar;
    }

    private final RecyclerView getRecyclerView() {
        AppMethodBeat.i(250118);
        RecyclerView recyclerView = (RecyclerView) this.vau.getValue();
        AppMethodBeat.o(250118);
        return recyclerView;
    }

    private final RefreshLoadMoreLayout getRlLayout() {
        AppMethodBeat.i(250117);
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.tSX.getValue();
        AppMethodBeat.o(250117);
        return refreshLoadMoreLayout;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProfileAtFeedUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(250123);
        this.tSX = kotlin.g.ah(new l(fragment));
        this.vau = kotlin.g.ah(new j(this));
        this.vav = kotlin.g.ah(new m(fragment));
        this.vaw = kotlin.g.ah(new c(this));
        this.vax = new k(this);
        AppMethodBeat.o(250123);
    }

    public static final /* synthetic */ FinderAtFeedLoader b(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
        AppMethodBeat.i(250126);
        FinderAtFeedLoader dmm = finderProfileAtFeedUIC.dmm();
        AppMethodBeat.o(250126);
        return dmm;
    }

    public static final /* synthetic */ RefreshLoadMoreLayout c(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
        AppMethodBeat.i(250127);
        RefreshLoadMoreLayout rlLayout = finderProfileAtFeedUIC.getRlLayout();
        AppMethodBeat.o(250127);
        return rlLayout;
    }

    public static final /* synthetic */ b d(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
        AppMethodBeat.i(250128);
        b dmo = finderProfileAtFeedUIC.dmo();
        AppMethodBeat.o(250128);
        return dmo;
    }

    public static final /* synthetic */ af e(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
        AppMethodBeat.i(250129);
        af dmn = finderProfileAtFeedUIC.dmn();
        AppMethodBeat.o(250129);
        return dmn;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.ais;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$removeFeedEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedRemoveEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class k extends IListener<hl> {
        final /* synthetic */ FinderProfileAtFeedUIC vaz;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
            this.vaz = finderProfileAtFeedUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hl hlVar) {
            AppMethodBeat.i(250112);
            hl hlVar2 = hlVar;
            p.h(hlVar2, "event");
            FinderProfileAtFeedUIC.b(this.vaz).remove(hlVar2.dLU.feedId, true);
            AppMethodBeat.o(250112);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.profile.uic.FinderProfileFragmentUIC, com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(250120);
        super.onCreate(bundle);
        dmm().register(dmo());
        getRlLayout().setSuperNestedScroll(true);
        getRlLayout().setEnableRefresh(false);
        getRlLayout().setActionCallback(new g(this));
        RefreshLoadMoreLayout rlLayout = getRlLayout();
        View inflate = aa.jQ(getActivity()).inflate(R.layout.b21, (ViewGroup) null);
        p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        rlLayout.setLoadMoreFooter(inflate);
        getRecyclerView().setLayoutManager((RecyclerView.LayoutManager) this.vat.getValue());
        getRecyclerView().b(dmn().getItemDecoration());
        RecyclerView recyclerView = getRecyclerView();
        af dmn = dmn();
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(250120);
            throw tVar;
        }
        recyclerView.setRecycledViewPool(dmn.f((MMActivity) activity));
        getRecyclerView().setAdapter(new WxRecyclerAdapter(dmn().dcK(), dmm().getDataListJustForAdapter()));
        dmm().setInitDone(new h(this));
        dmm().tTS = new i(this);
        BaseFeedLoader.requestInit$default(dmm(), false, 1, null);
        dmm().requestRefresh();
        this.vax.alive();
        AppMethodBeat.o(250120);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "plugin-finder_release"})
    public static final class g extends RefreshLoadMoreLayout.a {
        final /* synthetic */ FinderProfileAtFeedUIC vaz;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(250108);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(250108);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(250107);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(250107);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
            this.vaz = finderProfileAtFeedUIC;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(250105);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            FinderProfileAtFeedUIC.b(this.vaz).requestRefresh();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(250105);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(250106);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            super.cxo();
            FinderProfileAtFeedUIC.b(this.vaz).requestLoadMore();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(250106);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$onCreate$2", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class h implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ FinderProfileAtFeedUIC vaz;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
            this.vaz = finderProfileAtFeedUIC;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(250109);
            FinderProfileAtFeedUIC.d(this.vaz).dmp();
            AppMethodBeat.o(250109);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        int i2;
        AppMethodBeat.i(250121);
        super.onUserVisibleFocused();
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[2];
        if (p.j(getUsername(), z.aUg())) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = 1;
        hVar.a(21206, objArr);
        AppMethodBeat.o(250121);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(250122);
        super.onDestroy();
        dmm().unregister(dmo());
        dmm().onDead();
        this.vax.dead();
        AppMethodBeat.o(250122);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.view.b {
        final /* synthetic */ FinderProfileAtFeedUIC vaz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FinderProfileAtFeedUIC finderProfileAtFeedUIC, RefreshLoadMoreLayout refreshLoadMoreLayout) {
            super(refreshLoadMoreLayout);
            p.h(refreshLoadMoreLayout, "rlLayout");
            this.vaz = finderProfileAtFeedUIC;
            AppMethodBeat.i(250100);
            AppMethodBeat.o(250100);
        }

        @Override // com.tencent.mm.view.b
        public final void dmp() {
            AppMethodBeat.i(250099);
            com.tencent.mm.ac.d.a(0, new a(this));
            AppMethodBeat.o(250099);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b vaA;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(0);
                this.vaA = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(250098);
                try {
                    Fragment fragment = this.vaA.vaz.getFragment();
                    if ((fragment == null || !fragment.isDetached()) && FinderProfileAtFeedUIC.a(this.vaA.vaz) != null && !this.vaA.vaz.getActivity().isFinishing()) {
                        Log.i("Finder.ProfileAtFeedUIC", "[updateState] state=" + FinderProfileAtFeedUIC.b(this.vaA.vaz).uHR + " cachedState=" + FinderProfileAtFeedUIC.b(this.vaA.vaz).uHS);
                        FinderProfileAtFeedUIC.a(this.vaA.vaz).setOnClickListener(null);
                        FrameLayout a2 = FinderProfileAtFeedUIC.a(this.vaA.vaz);
                        p.g(a2, "stateLayout");
                        TextView textView = (TextView) a2.findViewById(R.id.ipb);
                        FrameLayout a3 = FinderProfileAtFeedUIC.a(this.vaA.vaz);
                        p.g(a3, "stateLayout");
                        TextView textView2 = (TextView) a3.findViewById(R.id.ipc);
                        FrameLayout a4 = FinderProfileAtFeedUIC.a(this.vaA.vaz);
                        p.g(a4, "stateLayout");
                        ProgressBar progressBar = (ProgressBar) a4.findViewById(R.id.ip_);
                        FrameLayout a5 = FinderProfileAtFeedUIC.a(this.vaA.vaz);
                        p.g(a5, "stateLayout");
                        LinearLayout linearLayout = (LinearLayout) a5.findViewById(R.id.d91);
                        FrameLayout a6 = FinderProfileAtFeedUIC.a(this.vaA.vaz);
                        p.g(a6, "stateLayout");
                        a6.setVisibility(8);
                        if (FinderProfileAtFeedUIC.b(this.vaA.vaz).uHS == FinderAtFeedLoader.b.NO_CACHE) {
                            FinderProfileAtFeedUIC.c(this.vaA.vaz).setSuperNestedScroll(false);
                            switch (a.$EnumSwitchMapping$0[FinderProfileAtFeedUIC.b(this.vaA.vaz).uHR.ordinal()]) {
                                case 1:
                                    FrameLayout a7 = FinderProfileAtFeedUIC.a(this.vaA.vaz);
                                    p.g(a7, "stateLayout");
                                    a7.setVisibility(0);
                                    p.g(textView, "noContentTipTv");
                                    textView.setVisibility(8);
                                    p.g(linearLayout, "privateTipsLayout");
                                    linearLayout.setVisibility(8);
                                    p.g(textView2, "retryTipTv");
                                    textView2.setVisibility(8);
                                    p.g(progressBar, "loadingBar");
                                    progressBar.setVisibility(0);
                                    break;
                                case 2:
                                    FrameLayout a8 = FinderProfileAtFeedUIC.a(this.vaA.vaz);
                                    p.g(a8, "stateLayout");
                                    a8.setVisibility(0);
                                    p.g(linearLayout, "privateTipsLayout");
                                    linearLayout.setVisibility(8);
                                    p.g(textView, "noContentTipTv");
                                    textView.setVisibility(0);
                                    p.g(textView2, "retryTipTv");
                                    textView2.setVisibility(8);
                                    p.g(progressBar, "loadingBar");
                                    progressBar.setVisibility(8);
                                    break;
                                case 3:
                                    FrameLayout a9 = FinderProfileAtFeedUIC.a(this.vaA.vaz);
                                    p.g(a9, "stateLayout");
                                    a9.setVisibility(0);
                                    p.g(textView, "noContentTipTv");
                                    textView.setVisibility(8);
                                    p.g(linearLayout, "privateTipsLayout");
                                    linearLayout.setVisibility(8);
                                    p.g(textView2, "retryTipTv");
                                    textView2.setVisibility(0);
                                    p.g(progressBar, "loadingBar");
                                    progressBar.setVisibility(8);
                                    FinderProfileAtFeedUIC.a(this.vaA.vaz).setOnClickListener(new View.OnClickListener(this) {
                                        /* class com.tencent.mm.plugin.finder.profile.uic.FinderProfileAtFeedUIC.b.a.AnonymousClass1 */
                                        final /* synthetic */ a vaB;

                                        {
                                            this.vaB = r1;
                                        }

                                        public final void onClick(View view) {
                                            AppMethodBeat.i(250097);
                                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                            bVar.bm(view);
                                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback$updateState$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                            RefreshLoadMoreLayout.d(FinderProfileAtFeedUIC.c(this.vaB.vaA.vaz));
                                            this.vaB.vaA.dmp();
                                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback$updateState$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(250097);
                                        }
                                    });
                                    break;
                            }
                        } else {
                            FinderProfileAtFeedUIC.c(this.vaA.vaz).setSuperNestedScroll(true);
                        }
                    }
                } catch (NullPointerException e2) {
                    Log.printErrStackTrace("Finder.ProfileAtFeedUIC", e2, "", new Object[0]);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(250098);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/loader/FinderAtFeedLoader;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<FinderAtFeedLoader> {
        final /* synthetic */ FinderProfileAtFeedUIC vaz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
            super(0);
            this.vaz = finderProfileAtFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderAtFeedLoader invoke() {
            AppMethodBeat.i(250102);
            com.tencent.mm.plugin.finder.feed.model.internal.e eVar = com.tencent.mm.plugin.finder.feed.model.internal.e.FEED_PROFILE;
            String username = this.vaz.getUsername();
            p.g(username, ch.COL_USERNAME);
            FinderAtFeedLoader finderAtFeedLoader = new FinderAtFeedLoader(eVar, username, this.vaz.getContextObj());
            AppMethodBeat.o(250102);
            return finderAtFeedLoader;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderProfileGridLayoutConfig;", "invoke"})
    static final class e extends q implements kotlin.g.a.a<af> {
        final /* synthetic */ FinderProfileAtFeedUIC vaz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
            super(0);
            this.vaz = finderProfileAtFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ af invoke() {
            AppMethodBeat.i(250103);
            boolean isSelfFlag = this.vaz.isSelfFlag();
            String username = this.vaz.getUsername();
            p.g(username, ch.COL_USERNAME);
            af afVar = new af(FinderProfileAtFeedUIC.b(this.vaz), isSelfFlag, username);
            AppMethodBeat.o(250103);
            return afVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "invoke"})
    static final class f extends q implements kotlin.g.a.a<RecyclerView.LayoutManager> {
        final /* synthetic */ FinderProfileAtFeedUIC vaz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
            super(0);
            this.vaz = finderProfileAtFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView.LayoutManager invoke() {
            AppMethodBeat.i(250104);
            RecyclerView.LayoutManager eS = FinderProfileAtFeedUIC.e(this.vaz).eS(this.vaz.getActivity());
            AppMethodBeat.o(250104);
            return eS;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class l extends q implements kotlin.g.a.a<RefreshLoadMoreLayout> {
        final /* synthetic */ Fragment uRC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(Fragment fragment) {
            super(0);
            this.uRC = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RefreshLoadMoreLayout invoke() {
            AppMethodBeat.i(250113);
            RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.uRC.getView().findViewById(R.id.h7t);
            AppMethodBeat.o(250113);
            return refreshLoadMoreLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
    static final class j extends q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ FinderProfileAtFeedUIC vaz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
            super(0);
            this.vaz = finderProfileAtFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(250111);
            RecyclerView recyclerView = FinderProfileAtFeedUIC.c(this.vaz).getRecyclerView();
            AppMethodBeat.o(250111);
            return recyclerView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m extends q implements kotlin.g.a.a<FrameLayout> {
        final /* synthetic */ Fragment uRC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(Fragment fragment) {
            super(0);
            this.uRC = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FrameLayout invoke() {
            AppMethodBeat.i(250114);
            FrameLayout frameLayout = (FrameLayout) this.uRC.getView().findViewById(R.id.gjf);
            AppMethodBeat.o(250114);
            return frameLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileAtFeedUIC;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<b> {
        final /* synthetic */ FinderProfileAtFeedUIC vaz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
            super(0);
            this.vaz = finderProfileAtFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ b invoke() {
            AppMethodBeat.i(250101);
            FinderProfileAtFeedUIC finderProfileAtFeedUIC = this.vaz;
            RefreshLoadMoreLayout c2 = FinderProfileAtFeedUIC.c(this.vaz);
            p.g(c2, "rlLayout");
            b bVar = new b(finderProfileAtFeedUIC, c2);
            AppMethodBeat.o(250101);
            return bVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderProfileAtFeedUIC vaz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
            super(0);
            this.vaz = finderProfileAtFeedUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250110);
            Log.i("Finder.ProfileAtFeedUIC", "[fetchEndCallback] totalSize=" + FinderProfileAtFeedUIC.b(this.vaz).getSize());
            FinderProfileAtFeedUIC.c(this.vaz).setHasBottomMore(false);
            View loadMoreFooter = FinderProfileAtFeedUIC.c(this.vaz).getLoadMoreFooter();
            if (loadMoreFooter != null) {
                TextView textView = (TextView) loadMoreFooter.findViewById(R.id.ep1);
                if (textView != null) {
                    textView.setText(R.string.d0m);
                }
                TextView textView2 = (TextView) loadMoreFooter.findViewById(R.id.ep1);
                if (textView2 != null) {
                    textView2.setTextColor(this.vaz.getActivity().getResources().getColor(R.color.FG_2));
                }
                TextView textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1);
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                View findViewById = loadMoreFooter.findViewById(R.id.ep0);
                if (findViewById != null) {
                    findViewById.setVisibility(0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(250110);
            return xVar;
        }
    }

    public static final /* synthetic */ FrameLayout a(FinderProfileAtFeedUIC finderProfileAtFeedUIC) {
        AppMethodBeat.i(250125);
        FrameLayout frameLayout = (FrameLayout) finderProfileAtFeedUIC.vav.getValue();
        AppMethodBeat.o(250125);
        return frameLayout;
    }
}
