package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileDraftLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.q;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\u00020\u0001:\u000278B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0002J\u0012\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020*H\u0016J\b\u0010/\u001a\u00020*H\u0002J\b\u00100\u001a\u00020*H\u0016J\b\u00101\u001a\u00020*H\u0002J\u0018\u00102\u001a\u00020*2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002R\u001f\u0010\u0005\u001a\u00060\u0006R\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001d\u0010\u001eR#\u0010 \u001a\n \"*\u0004\u0018\u00010!0!8BX\u0002¢\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "draftAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getDraftAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setDraftAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "draftLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "getDraftLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "draftLoader$delegate", "mainFlowLayout", "Landroid/widget/FrameLayout;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "getLayoutId", "", "initStatusView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFetchEnd", "onUserVisibleFocused", "showFooter", "showPopupMenu", "draftInfoData", "Lcom/tencent/mm/plugin/finder/model/FinderDraftInfoData;", "anchor", "Landroid/view/View;", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class FinderProfileDraftUIC extends FinderProfileFragmentUIC {
    public static final a vaK = new a((byte) 0);
    private com.tencent.mm.ui.widget.b.a pqr;
    private final kotlin.f tSX;
    private FrameLayout vaG;
    private FrameLayout vaH;
    private WxRecyclerAdapter<bo> vaI;
    private final kotlin.f vaJ = kotlin.g.ah(new d(this));
    private final kotlin.f vau = kotlin.g.ah(new j(this));
    private final kotlin.f vaw = kotlin.g.ah(new c(this));

    static {
        AppMethodBeat.i(250168);
        AppMethodBeat.o(250168);
    }

    private final b dmq() {
        AppMethodBeat.i(250162);
        b bVar = (b) this.vaw.getValue();
        AppMethodBeat.o(250162);
        return bVar;
    }

    private final RecyclerView getRecyclerView() {
        AppMethodBeat.i(250161);
        RecyclerView recyclerView = (RecyclerView) this.vau.getValue();
        AppMethodBeat.o(250161);
        return recyclerView;
    }

    private final RefreshLoadMoreLayout getRlLayout() {
        AppMethodBeat.i(250160);
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.tSX.getValue();
        AppMethodBeat.o(250160);
        return refreshLoadMoreLayout;
    }

    public final FinderProfileDraftLoader dmr() {
        AppMethodBeat.i(250163);
        FinderProfileDraftLoader finderProfileDraftLoader = (FinderProfileDraftLoader) this.vaJ.getValue();
        AppMethodBeat.o(250163);
        return finderProfileDraftLoader;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$Companion;", "", "()V", "MENU_ID_REMOVE_LIST", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProfileDraftUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(250167);
        this.tSX = kotlin.g.ah(new k(fragment));
        AppMethodBeat.o(250167);
    }

    public static final /* synthetic */ RefreshLoadMoreLayout b(FinderProfileDraftUIC finderProfileDraftUIC) {
        AppMethodBeat.i(250169);
        RefreshLoadMoreLayout rlLayout = finderProfileDraftUIC.getRlLayout();
        AppMethodBeat.o(250169);
        return rlLayout;
    }

    public static final /* synthetic */ void e(FinderProfileDraftUIC finderProfileDraftUIC) {
        AppMethodBeat.i(261273);
        finderProfileDraftUIC.hUu();
        AppMethodBeat.o(261273);
    }

    @Override // com.tencent.mm.plugin.finder.profile.uic.FinderProfileFragmentUIC, com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(250164);
        super.onCreate(bundle);
        dmr().register(dmq());
        this.vaG = (FrameLayout) findViewById(R.id.f69);
        this.vaH = (FrameLayout) findViewById(R.id.gjf);
        FrameLayout frameLayout = this.vaH;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(R.drawable.a3_);
        }
        FrameLayout frameLayout2 = this.vaH;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        this.pqr = new com.tencent.mm.ui.widget.b.a(getActivity());
        getRlLayout().setSuperNestedScroll(true);
        getRlLayout().setEnableRefresh(false);
        getRlLayout().setEnableLoadMore(false);
        getRlLayout().setActionCallback(new e(this));
        RefreshLoadMoreLayout rlLayout = getRlLayout();
        View inflate = aa.jQ(getActivity()).inflate(R.layout.a_b, (ViewGroup) null);
        p.g(inflate, "MMLayoutInflater.getInfl…inder_draft_footer, null)");
        rlLayout.setLoadMoreFooter(inflate);
        RecyclerView recyclerView = getRecyclerView();
        getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.vaI = new WxRecyclerAdapter<>(new f(), dmr().getDataListJustForAdapter(), true);
        getRecyclerView().setAdapter(this.vaI);
        WxRecyclerAdapter<bo> wxRecyclerAdapter = this.vaI;
        if (wxRecyclerAdapter != null) {
            wxRecyclerAdapter.RqP = new g(this);
        }
        WxRecyclerAdapter<bo> wxRecyclerAdapter2 = this.vaI;
        if (wxRecyclerAdapter2 != null) {
            wxRecyclerAdapter2.RqO = new h(this);
        }
        dmr().tTS = new i(this);
        dmr().requestInit(false);
        AppMethodBeat.o(250164);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
    public static final class e extends RefreshLoadMoreLayout.a {
        final /* synthetic */ FinderProfileDraftUIC vaL;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(250150);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(250150);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderProfileDraftUIC finderProfileDraftUIC) {
            this.vaL = finderProfileDraftUIC;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(250147);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            this.vaL.dmr().requestRefresh();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(250147);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(250148);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            super.onRefreshEnd(cVar);
            RecyclerView recyclerView = FinderProfileDraftUIC.b(this.vaL).getRecyclerView();
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
            recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(250148);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(250149);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            super.cxo();
            this.vaL.dmr().requestLoadMore();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(250149);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class f implements com.tencent.mm.view.recyclerview.f {
        f() {
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(250151);
            if (i2 == q.class.getName().hashCode()) {
                com.tencent.mm.plugin.finder.convert.e eVar = new com.tencent.mm.plugin.finder.convert.e();
                AppMethodBeat.o(250151);
                return eVar;
            }
            p.hyc();
            AppMethodBeat.o(250151);
            return null;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
    public static final class g implements g.c<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ FinderProfileDraftUIC vaL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(FinderProfileDraftUIC finderProfileDraftUIC) {
            this.vaL = finderProfileDraftUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
            axw axw;
            axy axy;
            String str;
            AppMethodBeat.i(250152);
            com.tencent.mm.view.recyclerview.h hVar2 = hVar;
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar2, "holder");
            bo boVar = (bo) hVar2.hgv();
            if (boVar instanceof q) {
                Log.i("Finder.FinderProfileDraftUIC", "onItemClick position:" + i2 + "},objectType:" + ((q) boVar).uNV.field_objectType);
                if (((q) boVar).uNV.field_objectType == 1 || ((q) boVar).uNV.field_objectType == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("key_finder_post_from", 1);
                    intent.putExtra("KEY_FINDER_POST_DRAFT_LOCAL_ID", ((q) boVar).uNV.field_localId);
                    com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    String str2 = ((q) boVar).uNV.field_postIntent;
                    p.g(str2, "feed.draftItem.field_postIntent");
                    com.tencent.mm.plugin.finder.utils.a.c(this.vaL.getActivity(), str2, intent);
                    com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
                    com.tencent.mm.plugin.finder.report.i.as(2, true);
                    com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
                    com.tencent.mm.plugin.finder.report.i.Kq(1);
                    StringBuilder sb = new StringBuilder();
                    p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
                    String sb2 = sb.append(com.tencent.mm.kernel.a.ayV()).append('_').append(Util.nowMilliSecond()).toString();
                    com.tencent.mm.plugin.finder.report.i iVar3 = com.tencent.mm.plugin.finder.report.i.vfo;
                    com.tencent.mm.plugin.finder.report.i.auI(sb2);
                    AppMethodBeat.o(250152);
                    return;
                }
                SecDataUIC.a aVar3 = SecDataUIC.CWq;
                cst cst = (cst) SecDataUIC.a.a(this.vaL.getActivity(), "MusicMvMainUI", 7, cst.class);
                if (cst != null) {
                    com.tencent.mm.plugin.comm.a aVar4 = com.tencent.mm.plugin.comm.a.qCo;
                    cst.sGQ = com.tencent.mm.plugin.comm.a.cAK();
                    cst.MxI = 86;
                    cst.scene = 10;
                    com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
                    cst.Vkb = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vaL.getActivity()).get(FinderReporterUIC.class)).sGQ;
                }
                FinderObjectDesc finderObjectDesc = ((q) boVar).uNV.dxn().getFinderObject().objectDesc;
                if (!(finderObjectDesc == null || (axw = finderObjectDesc.mvInfo) == null || (axy = axw.Aqo) == null)) {
                    ac acVar = ac.vER;
                    p.g(axy, LocaleUtil.ITALIAN);
                    StringBuilder sb3 = new StringBuilder("finder_local_");
                    Object obj = axy.AqO;
                    if (obj == null) {
                        obj = Long.valueOf(((q) boVar).uNV.field_localId);
                    }
                    String sb4 = sb3.append(obj).toString();
                    cjl cjl = (cjl) kotlin.a.j.kt(((q) boVar).uNV.dxn().getMediaList());
                    if (cjl == null || (str = cjl.url) == null) {
                        str = "";
                    }
                    ac.a(axy, sb4, 0, str);
                }
                Intent intent2 = new Intent();
                g.a aVar6 = com.tencent.mm.plugin.finder.storage.g.vDm;
                intent2.putExtra("key_track_data", g.a.a(((q) boVar).uNV).toByteArray());
                intent2.putExtra("key_mv_from_scene", 1);
                SecDataUIC.a aVar7 = SecDataUIC.CWq;
                cst cst2 = (cst) SecDataUIC.a.a(this.vaL.getActivity(), "MusicMvRouterUI", 7, cst.class);
                if (cst2 != null) {
                    com.tencent.mm.plugin.comm.a aVar8 = com.tencent.mm.plugin.comm.a.qCo;
                    cst2.sGQ = com.tencent.mm.plugin.comm.a.cAK();
                    cst2.MxI = 86;
                }
                com.tencent.mm.plugin.finder.utils.a aVar9 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.L(this.vaL.getActivity(), intent2);
            }
            AppMethodBeat.o(250152);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$onCreate$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
    public static final class h implements g.d<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ FinderProfileDraftUIC vaL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(FinderProfileDraftUIC finderProfileDraftUIC) {
            this.vaL = finderProfileDraftUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.d
        public final /* synthetic */ boolean b(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
            AppMethodBeat.i(250153);
            com.tencent.mm.view.recyclerview.h hVar2 = hVar;
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar2, "holder");
            bo boVar = (bo) hVar2.hgv();
            if (boVar instanceof q) {
                Log.i("Finder.FinderProfileDraftUIC", "onItemClick position:" + i2 + '}');
                FinderProfileDraftUIC.a(this.vaL, (q) boVar, view);
            }
            AppMethodBeat.o(250153);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
    public static final class l implements View.OnCreateContextMenuListener {
        final /* synthetic */ FinderProfileDraftUIC vaL;

        l(FinderProfileDraftUIC finderProfileDraftUIC) {
            this.vaL = finderProfileDraftUIC;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(250158);
            contextMenu.add(0, 1001, 0, this.vaL.getString(R.string.cl8));
            AppMethodBeat.o(250158);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class m implements o.g {
        final /* synthetic */ FinderProfileDraftUIC vaL;
        final /* synthetic */ q vaO;

        m(FinderProfileDraftUIC finderProfileDraftUIC, q qVar) {
            this.vaL = finderProfileDraftUIC;
            this.vaO = qVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(250159);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 1001:
                    long j2 = this.vaO.uNV.field_localId;
                    com.tencent.mm.plugin.finder.storage.h hVar = com.tencent.mm.plugin.finder.storage.h.vDp;
                    com.tencent.mm.plugin.finder.storage.h.Fx(j2);
                    String zs = com.tencent.mm.ac.d.zs(j2);
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    ((FinderProfileEduUIC) com.tencent.mm.ui.component.a.b(this.vaL.getActivity()).get(FinderProfileEduUIC.class)).R("draftdelete", 1, zs);
                    break;
            }
            AppMethodBeat.o(250159);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onUserVisibleFocused() {
        AppMethodBeat.i(250165);
        super.onUserVisibleFocused();
        AppMethodBeat.o(250165);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(250166);
        super.onDestroy();
        dmr().unregister(dmq());
        AppMethodBeat.o(250166);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.aiw;
    }

    private final void hUu() {
        AppMethodBeat.i(261272);
        View loadMoreFooter = getRlLayout().getLoadMoreFooter();
        if (loadMoreFooter != null) {
            loadMoreFooter.setVisibility(0);
            loadMoreFooter.setBackgroundColor(loadMoreFooter.getResources().getColor(R.color.afz));
            View findViewById = loadMoreFooter.findViewById(R.id.ep1);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            TextView textView = (TextView) loadMoreFooter.findViewById(R.id.buy);
            if (textView != null) {
                textView.setText(loadMoreFooter.getResources().getString(R.string.clk));
            }
            View findViewById2 = loadMoreFooter.findViewById(R.id.ep0);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
                AppMethodBeat.o(261272);
                return;
            }
            AppMethodBeat.o(261272);
            return;
        }
        AppMethodBeat.o(261272);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.view.b {
        final /* synthetic */ FinderProfileDraftUIC vaL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FinderProfileDraftUIC finderProfileDraftUIC, RefreshLoadMoreLayout refreshLoadMoreLayout) {
            super(refreshLoadMoreLayout);
            p.h(refreshLoadMoreLayout, "rlLayout");
            this.vaL = finderProfileDraftUIC;
            AppMethodBeat.i(250144);
            AppMethodBeat.o(250144);
        }

        @Override // com.tencent.mm.view.b
        public final void dmp() {
            AppMethodBeat.i(250143);
            com.tencent.mm.ac.d.a(0, new a(this));
            AppMethodBeat.o(250143);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ b vaM;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(0);
                this.vaM = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(250142);
                Fragment fragment = this.vaM.vaL.getFragment();
                if (fragment == null || !fragment.isDetached()) {
                    Log.i("Finder.FinderProfileDraftUIC", "[updateState] state=" + this.vaM.vaL.dmr().tWG + " cachedState=" + this.vaM.vaL.dmr().tWH);
                    FrameLayout frameLayout = this.vaM.vaL.vaH;
                    if (frameLayout != null) {
                        frameLayout.setOnClickListener(null);
                        frameLayout.setVisibility(8);
                    }
                    FinderProfileDraftUIC.b(this.vaM.vaL).setBackgroundResource(R.color.f3048f);
                    FrameLayout frameLayout2 = this.vaM.vaL.vaG;
                    if (frameLayout2 != null) {
                        frameLayout2.setBackgroundResource(R.color.f3048f);
                    }
                    if (this.vaM.vaL.dmr().tWH == FinderProfileDraftLoader.a.NO_CACHE && this.vaM.vaL.dmr().getDataListJustForAdapter().size() == 0) {
                        FrameLayout frameLayout3 = this.vaM.vaL.vaH;
                        if (frameLayout3 != null) {
                            frameLayout3.setVisibility(0);
                            TextView textView = (TextView) frameLayout3.findViewById(R.id.ipb);
                            p.g(textView, "it.tips_no_content");
                            textView.setVisibility(0);
                            LinearLayout linearLayout = (LinearLayout) frameLayout3.findViewById(R.id.d91);
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                            TextView textView2 = (TextView) frameLayout3.findViewById(R.id.ipc);
                            p.g(textView2, "it.tips_retry");
                            textView2.setVisibility(8);
                            ProgressBar progressBar = (ProgressBar) frameLayout3.findViewById(R.id.ip_);
                            p.g(progressBar, "it.tips_loading");
                            progressBar.setVisibility(8);
                        }
                        FinderProfileDraftUIC.b(this.vaM.vaL).setBackgroundResource(R.color.f3045c);
                        FrameLayout frameLayout4 = this.vaM.vaL.vaG;
                        if (frameLayout4 != null) {
                            frameLayout4.setBackgroundResource(R.color.f3045c);
                        }
                    } else if (this.vaM.vaL.dmr().getDataListJustForAdapter().size() > 0) {
                        FinderProfileDraftUIC.e(this.vaM.vaL);
                    }
                    Log.i("Finder.FinderProfileDraftUIC", "[updateState] state=" + this.vaM.vaL.dmr().tWG + " cachedState=" + this.vaM.vaL.dmr().tWH);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(250142);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<RefreshLoadMoreLayout> {
        final /* synthetic */ Fragment uRC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(Fragment fragment) {
            super(0);
            this.uRC = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RefreshLoadMoreLayout invoke() {
            AppMethodBeat.i(250157);
            RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.uRC.getView().findViewById(R.id.h7t);
            AppMethodBeat.o(250157);
            return refreshLoadMoreLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ FinderProfileDraftUIC vaL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderProfileDraftUIC finderProfileDraftUIC) {
            super(0);
            this.vaL = finderProfileDraftUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(250156);
            RecyclerView recyclerView = FinderProfileDraftUIC.b(this.vaL).getRecyclerView();
            AppMethodBeat.o(250156);
            return recyclerView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileDraftUIC;", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<b> {
        final /* synthetic */ FinderProfileDraftUIC vaL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderProfileDraftUIC finderProfileDraftUIC) {
            super(0);
            this.vaL = finderProfileDraftUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ b invoke() {
            AppMethodBeat.i(250145);
            FinderProfileDraftUIC finderProfileDraftUIC = this.vaL;
            RefreshLoadMoreLayout b2 = FinderProfileDraftUIC.b(this.vaL);
            p.g(b2, "rlLayout");
            b bVar = new b(finderProfileDraftUIC, b2);
            AppMethodBeat.o(250145);
            return bVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileDraftLoader;", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<FinderProfileDraftLoader> {
        final /* synthetic */ FinderProfileDraftUIC vaL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderProfileDraftUIC finderProfileDraftUIC) {
            super(0);
            this.vaL = finderProfileDraftUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderProfileDraftLoader invoke() {
            AppMethodBeat.i(250146);
            FinderProfileDraftLoader finderProfileDraftLoader = new FinderProfileDraftLoader(this.vaL.getUsername(), this.vaL.getContextObj());
            AppMethodBeat.o(250146);
            return finderProfileDraftLoader;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderProfileDraftUIC vaL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderProfileDraftUIC finderProfileDraftUIC) {
            super(0);
            this.vaL = finderProfileDraftUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250155);
            FinderProfileDraftUIC.b(this.vaL).setHasBottomMore(false);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.profile.uic.FinderProfileDraftUIC.i.AnonymousClass1 */
                final /* synthetic */ i vaN;

                {
                    this.vaN = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(250154);
                    FinderProfileDraftUIC.d(this.vaN.vaL);
                    x xVar = x.SXb;
                    AppMethodBeat.o(250154);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(250155);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(FinderProfileDraftUIC finderProfileDraftUIC, q qVar, View view) {
        AppMethodBeat.i(250170);
        com.tencent.mm.ui.widget.b.a aVar = finderProfileDraftUIC.pqr;
        if (aVar == null) {
            p.btv("popupMenu");
        }
        aVar.gNq();
        com.tencent.mm.ui.widget.b.a aVar2 = finderProfileDraftUIC.pqr;
        if (aVar2 == null) {
            p.btv("popupMenu");
        }
        HardTouchableLayout.a aVar3 = HardTouchableLayout.Rjl;
        int i2 = HardTouchableLayout.kuv;
        HardTouchableLayout.a aVar4 = HardTouchableLayout.Rjl;
        aVar2.a(view, new l(finderProfileDraftUIC), new m(finderProfileDraftUIC, qVar), i2, HardTouchableLayout.kuw);
        AppMethodBeat.o(250170);
    }

    public static final /* synthetic */ void d(FinderProfileDraftUIC finderProfileDraftUIC) {
        AppMethodBeat.i(250171);
        Log.i("Finder.FinderProfileDraftUIC", "onFetchEnd : " + finderProfileDraftUIC.dmr().getDataListJustForAdapter().size());
        if (finderProfileDraftUIC.dmr().tWH == FinderProfileDraftLoader.a.WITH_CACHED) {
            finderProfileDraftUIC.hUu();
            AppMethodBeat.o(250171);
            return;
        }
        View loadMoreFooter = finderProfileDraftUIC.getRlLayout().getLoadMoreFooter();
        if (loadMoreFooter != null) {
            loadMoreFooter.setVisibility(8);
            View findViewById = loadMoreFooter.findViewById(R.id.ep1);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            View findViewById2 = loadMoreFooter.findViewById(R.id.ep0);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
                AppMethodBeat.o(250171);
                return;
            }
            AppMethodBeat.o(250171);
            return;
        }
        AppMethodBeat.o(250171);
    }
}
