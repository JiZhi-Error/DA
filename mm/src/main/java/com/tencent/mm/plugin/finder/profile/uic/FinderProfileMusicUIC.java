package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.convert.ca;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileMusicLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bf;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u0001:\u000278B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002J\u0010\u0010/\u001a\u00020-2\u0006\u00100\u001a\u000201H\u0002J\u0012\u00102\u001a\u00020-2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020-H\u0016J\b\u00106\u001a\u00020-H\u0002R\u001f\u0010\u0005\u001a\u00060\u0006R\u00020\u00008BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\n\u001a\u0004\b \u0010!R#\u0010#\u001a\n %*\u0004\u0018\u00010$0$8BX\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u0010\u0010)\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileFragmentUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "actionCallback", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "actionCallback$delegate", "Lkotlin/Lazy;", "layoutConfig", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "getLayoutConfig", "()Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "layoutConfig$delegate", "mainFlowLayout", "Landroid/widget/FrameLayout;", "musicAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "musicLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "getMusicLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "musicLoader$delegate", "musicSongInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicThumbUrl", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "stateLayout", "getLayoutId", "", "initLayout", "", "initLoading", "initPlayParam", "musicObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFetchEnd", "Companion", "ViewActionCallback", "plugin-finder_release"})
public final class FinderProfileMusicUIC extends FinderProfileFragmentUIC {
    public static final a vcy = new a((byte) 0);
    private final kotlin.f tSX;
    private FrameLayout vaG;
    private FrameLayout vaH;
    private final kotlin.f vas = kotlin.g.ah(new h(this));
    private final kotlin.f vau;
    private final kotlin.f vaw;
    private WxRecyclerAdapter<bo> vcu;
    private final kotlin.f vcv;
    private String vcw;
    private axy vcx;

    static {
        AppMethodBeat.i(250449);
        AppMethodBeat.o(250449);
    }

    private final FinderProfileMusicLoader dnq() {
        AppMethodBeat.i(250444);
        FinderProfileMusicLoader finderProfileMusicLoader = (FinderProfileMusicLoader) this.vcv.getValue();
        AppMethodBeat.o(250444);
        return finderProfileMusicLoader;
    }

    private final b dnr() {
        AppMethodBeat.i(250445);
        b bVar = (b) this.vaw.getValue();
        AppMethodBeat.o(250445);
        return bVar;
    }

    private final RefreshLoadMoreLayout getRlLayout() {
        AppMethodBeat.i(250443);
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.tSX.getValue();
        AppMethodBeat.o(250443);
        return refreshLoadMoreLayout;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProfileMusicUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(250448);
        this.tSX = kotlin.g.ah(new k(fragment));
        this.vau = kotlin.g.ah(new j(this));
        this.vcv = kotlin.g.ah(new i(this));
        this.vaw = kotlin.g.ah(new c(this));
        AppMethodBeat.o(250448);
    }

    public static final /* synthetic */ FinderProfileMusicLoader a(FinderProfileMusicUIC finderProfileMusicUIC) {
        AppMethodBeat.i(250450);
        FinderProfileMusicLoader dnq = finderProfileMusicUIC.dnq();
        AppMethodBeat.o(250450);
        return dnq;
    }

    public static final /* synthetic */ RefreshLoadMoreLayout c(FinderProfileMusicUIC finderProfileMusicUIC) {
        AppMethodBeat.i(250451);
        RefreshLoadMoreLayout rlLayout = finderProfileMusicUIC.getRlLayout();
        AppMethodBeat.o(250451);
        return rlLayout;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.profile.uic.FinderProfileFragmentUIC, com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(250446);
        super.onCreate(bundle);
        ac acVar = ac.vER;
        ac.dxV();
        dnq().register(dnr());
        this.vaG = (FrameLayout) findViewById(R.id.f69);
        getRlLayout().setEnableRefresh(false);
        getRlLayout().setSuperNestedScroll(true);
        getRlLayout().setActionCallback(new e(this));
        RefreshLoadMoreLayout rlLayout = getRlLayout();
        View inflate = aa.jQ(getActivity()).inflate(R.layout.b21, (ViewGroup) null);
        p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        rlLayout.setLoadMoreFooter(inflate);
        WxRecyclerAdapter<bo> wxRecyclerAdapter = new WxRecyclerAdapter<>(new f(this), dnq().getDataListJustForAdapter(), true);
        wxRecyclerAdapter.RqP = new d(wxRecyclerAdapter, this);
        this.vcu = wxRecyclerAdapter;
        RecyclerView recyclerView = (RecyclerView) this.vau.getValue();
        getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        recyclerView.setAdapter(this.vcu);
        dnq().tTS = new g(this);
        this.vaH = (FrameLayout) findViewById(R.id.gjf);
        FrameLayout frameLayout = this.vaH;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(R.drawable.a3_);
        }
        FrameLayout frameLayout2 = this.vaH;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        BaseFeedLoader.requestInit$default(dnq(), false, 1, null);
        dnq().requestRefresh();
        AppMethodBeat.o(250446);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(250447);
        super.onDestroy();
        dnq().unregister(dnr());
        AppMethodBeat.o(250447);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
    public static final class e extends RefreshLoadMoreLayout.a {
        final /* synthetic */ FinderProfileMusicUIC vcz;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(250436);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(250436);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderProfileMusicUIC finderProfileMusicUIC) {
            this.vcz = finderProfileMusicUIC;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(250433);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(250433);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(250434);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(250434);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(250435);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            super.cxo();
            FinderProfileMusicUIC.a(this.vcz).requestLoadMore();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(250435);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class f implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ FinderProfileMusicUIC vcz;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(FinderProfileMusicUIC finderProfileMusicUIC) {
            this.vcz = finderProfileMusicUIC;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(250437);
            if (i2 == bf.class.getName().hashCode()) {
                ca caVar = new ca();
                caVar.tFI = Boolean.valueOf(this.vcz.isSelfFlag());
                ca caVar2 = caVar;
                AppMethodBeat.o(250437);
                return caVar2;
            }
            p.hyc();
            AppMethodBeat.o(250437);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$initLayout$3$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
    public static final class d implements g.c<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ WxRecyclerAdapter vcC;
        final /* synthetic */ FinderProfileMusicUIC vcz;

        d(WxRecyclerAdapter wxRecyclerAdapter, FinderProfileMusicUIC finderProfileMusicUIC) {
            this.vcC = wxRecyclerAdapter;
            this.vcz = finderProfileMusicUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
            String str;
            String str2;
            x xVar;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            axw axw;
            axy axy;
            axw axw2;
            axy axy2;
            axw axw3;
            axy axy3;
            axw axw4;
            axy axy4;
            axw axw5;
            axy axy5;
            axw axw6;
            axy axy6;
            axw axw7;
            axy axy7;
            axw axw8;
            axy axy8;
            axw axw9;
            axy axy9;
            axw axw10;
            axy axy10;
            FinderObjectDesc finderObjectDesc;
            axw axw11;
            axy axy11;
            FinderObjectDesc finderObjectDesc2;
            axw axw12;
            axy axy12;
            FinderObjectDesc finderObjectDesc3;
            axw axw13;
            axy axy13;
            FinderObjectDesc finderObjectDesc4;
            axw axw14;
            axy axy14;
            FinderObjectDesc finderObjectDesc5;
            axw axw15;
            axy axy15;
            FinderObjectDesc finderObjectDesc6;
            axw axw16;
            axy axy16;
            FinderObjectDesc finderObjectDesc7;
            axw axw17;
            axy axy17;
            FinderObjectDesc finderObjectDesc8;
            axw axw18;
            axy axy18;
            FinderObjectDesc finderObjectDesc9;
            axw axw19;
            axy axy19;
            FinderObjectDesc finderObjectDesc10;
            axw axw20;
            axy axy20;
            FinderObjectDesc finderObjectDesc11;
            axw axw21;
            axy axy21;
            LinkedList<FinderMedia> linkedList;
            FinderMedia finderMedia;
            FinderObjectDesc finderObjectDesc12;
            axw axw22;
            axy axy22;
            FinderObjectDesc finderObjectDesc13;
            axw axw23;
            axy axy23;
            FinderObjectDesc finderObjectDesc14;
            axw axw24;
            axy axy24;
            FinderObjectDesc finderObjectDesc15;
            axw axw25;
            axy axy25;
            FinderObjectDesc finderObjectDesc16;
            axw axw26;
            axy axy26;
            FinderObjectDesc finderObjectDesc17;
            axw axw27;
            axy axy27;
            FinderObjectDesc finderObjectDesc18;
            axw axw28;
            axy axy28;
            FinderObjectDesc finderObjectDesc19;
            axw axw29;
            axy axy29;
            FinderObjectDesc finderObjectDesc20;
            axw axw30;
            axy axy30;
            FinderObjectDesc finderObjectDesc21;
            axw axw31;
            axy axy31;
            AppMethodBeat.i(250432);
            com.tencent.mm.view.recyclerview.h hVar2 = hVar;
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar2, "holder");
            bo boVar = (bo) hVar2.hgv();
            if (boVar instanceof bf) {
                this.vcC.RqM.size();
                Log.i("Finder.FinderProfileMusicUIC", "onItemClick position:" + i2 + " isLocal: " + ((bf) boVar).dkS() + ", imageUrl: " + ((bf) boVar).dkR());
                Intent intent = new Intent();
                if (((bf) boVar).dkS()) {
                    css css = new css();
                    FinderObject feedObject = ((bf) boVar).uOO.getFeedObject();
                    com.tencent.mm.plugin.finder.api.g gVar = ((bf) boVar).contact;
                    css.Ktq = gVar != null ? gVar.getNickname() : null;
                    css.singerName = (feedObject == null || (finderObjectDesc21 = feedObject.objectDesc) == null || (axw31 = finderObjectDesc21.mvInfo) == null || (axy31 = axw31.Aqo) == null) ? null : axy31.lDR;
                    css.albumName = (feedObject == null || (finderObjectDesc20 = feedObject.objectDesc) == null || (axw30 = finderObjectDesc20.mvInfo) == null || (axy30 = axw30.Aqo) == null) ? null : axy30.albumName;
                    css.extraInfo = (feedObject == null || (finderObjectDesc19 = feedObject.objectDesc) == null || (axw29 = finderObjectDesc19.mvInfo) == null || (axy29 = axw29.Aqo) == null) ? null : axy29.extraInfo;
                    css.musicGenre = (feedObject == null || (finderObjectDesc18 = feedObject.objectDesc) == null || (axw28 = finderObjectDesc18.mvInfo) == null || (axy28 = axw28.Aqo) == null) ? null : axy28.LIi;
                    css.issueDate = (feedObject == null || (finderObjectDesc17 = feedObject.objectDesc) == null || (axw27 = finderObjectDesc17.mvInfo) == null || (axy27 = axw27.Aqo) == null) ? 0 : axy27.LIk;
                    css.identification = (feedObject == null || (finderObjectDesc16 = feedObject.objectDesc) == null || (axw26 = finderObjectDesc16.mvInfo) == null || (axy26 = axw26.Aqo) == null) ? null : axy26.identification;
                    css.Alz = (feedObject == null || (finderObjectDesc15 = feedObject.objectDesc) == null || (axw25 = finderObjectDesc15.mvInfo) == null || (axy25 = axw25.Aqo) == null) ? 0 : axy25.duration;
                    css.BPc = (feedObject == null || (finderObjectDesc14 = feedObject.objectDesc) == null || (axw24 = finderObjectDesc14.mvInfo) == null || (axy24 = axw24.Aqo) == null) ? null : axy24.BPc;
                    css.songLyric = (feedObject == null || (finderObjectDesc13 = feedObject.objectDesc) == null || (axw23 = finderObjectDesc13.mvInfo) == null || (axy23 = axw23.Aqo) == null) ? null : axy23.LIh;
                    css.EsK = (feedObject == null || (finderObjectDesc12 = feedObject.objectDesc) == null || (axw22 = finderObjectDesc12.mvInfo) == null || (axy22 = axw22.Aqo) == null) ? null : axy22.Djf;
                    css.jfz = ((bf) boVar).dkR();
                    x xVar2 = x.SXb;
                    String str12 = css.BPc;
                    if (str12 == null) {
                        str12 = "";
                    }
                    intent.putExtra("key_mv_song_name", str12);
                    String str13 = css.songLyric;
                    if (str13 == null) {
                        str13 = "";
                    }
                    intent.putExtra("key_mv_song_lyric", str13);
                    String str14 = css.singerName;
                    if (str14 == null) {
                        str14 = "";
                    }
                    intent.putExtra("key_mv_singer_name", str14);
                    String str15 = css.albumName;
                    if (str15 == null) {
                        str15 = "";
                    }
                    intent.putExtra("key_mv_album_name", str15);
                    String str16 = css.musicGenre;
                    if (str16 == null) {
                        str16 = "";
                    }
                    intent.putExtra("key_mv_music_genre", str16);
                    intent.putExtra("key_mv_issue_date", String.valueOf(css.issueDate));
                    String str17 = css.EsK;
                    if (str17 == null) {
                        str17 = "";
                    }
                    intent.putExtra("key_mv_album_cover_url", str17);
                    String str18 = css.identification;
                    if (str18 == null) {
                        str18 = "";
                    }
                    intent.putExtra("key_mv_identification", str18);
                    String str19 = css.extraInfo;
                    if (str19 == null) {
                        str19 = "";
                    }
                    intent.putExtra("key_mv_extra_info", str19);
                    intent.putExtra("key_mv_music_duration", css.Alz);
                    SecDataUIC.a aVar2 = SecDataUIC.CWq;
                    cst cst = (cst) SecDataUIC.a.a(this.vcz.getActivity(), "MusicMvMainUI", 7, cst.class);
                    if (cst != null) {
                        com.tencent.mm.plugin.comm.a aVar3 = com.tencent.mm.plugin.comm.a.qCo;
                        cst.sGQ = com.tencent.mm.plugin.comm.a.cAK();
                        cst.MxI = 86;
                        cst.MxJ = com.tencent.mm.ac.d.zs(((bf) boVar).uOO.getId());
                        cst.scene = 8;
                        com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                        cst.Vkb = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vcz.getActivity()).get(FinderReporterUIC.class)).sGQ;
                        x xVar3 = x.SXb;
                    }
                    FinderObject feedObject2 = ((bf) boVar).uOO.getFeedObject();
                    if (feedObject2 != null) {
                        FinderProfileMusicUIC.a(this.vcz, feedObject2);
                        axy axy32 = this.vcz.vcx;
                        if (axy32 != null) {
                            ac acVar = ac.vER;
                            StringBuilder sb = new StringBuilder("finder_local_");
                            Object obj = axy32.AqO;
                            if (obj == null) {
                                obj = Long.valueOf(((bf) boVar).uOO.getLocalId());
                            }
                            ac.a(axy32, sb.append(obj).toString(), css);
                            x xVar4 = x.SXb;
                        }
                        this.vcz.vcx = null;
                        this.vcz.vcw = "";
                        x xVar5 = x.SXb;
                    }
                    com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
                    ((FinderProfileFloatBallUIC) com.tencent.mm.ui.component.a.b(this.vcz.getActivity()).get(FinderProfileFloatBallUIC.class)).USD = false;
                    g.a aVar6 = com.tencent.mm.plugin.finder.storage.g.vDm;
                    FinderItem finderItem = ((bf) boVar).uOO;
                    p.h(finderItem, "finderItem");
                    intent.putExtra("key_track_data", g.a.a(g.a.j(finderItem)).toByteArray());
                    com.tencent.mm.plugin.finder.utils.a aVar7 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    com.tencent.mm.plugin.finder.utils.a.K(this.vcz.getActivity(), intent);
                } else {
                    FinderObject feedObject3 = ((bf) boVar).uOO.getFeedObject();
                    String str20 = null;
                    FinderObjectDesc finderObjectDesc22 = feedObject3.objectDesc;
                    if (!(finderObjectDesc22 == null || (linkedList = finderObjectDesc22.media) == null || (finderMedia = (FinderMedia) kotlin.a.j.kt(linkedList)) == null)) {
                        str20 = finderMedia.thumbUrl + finderMedia.thumb_url_token;
                        x xVar6 = x.SXb;
                    }
                    String str21 = str20;
                    if (!(str21 == null || str21.length() == 0) || (finderObjectDesc11 = feedObject3.objectDesc) == null || (axw21 = finderObjectDesc11.mvInfo) == null || (axy21 = axw21.Aqo) == null) {
                        str = str20;
                    } else {
                        String str22 = axy21.Djf;
                        if (str22 == null) {
                            str22 = "";
                        }
                        x xVar7 = x.SXb;
                        str = str22;
                    }
                    FinderContact finderContact = feedObject3.contact;
                    if (finderContact != null) {
                        str2 = finderContact.nickname;
                    } else {
                        str2 = null;
                    }
                    css css2 = null;
                    long j2 = feedObject3.id;
                    String str23 = feedObject3.objectNonceId;
                    if (str == null || str2 == null || str23 == null) {
                        xVar = null;
                    } else {
                        SecDataUIC.a aVar8 = SecDataUIC.CWq;
                        cst cst2 = (cst) SecDataUIC.a.a(this.vcz.getActivity(), "MusicMvMainUI", 7, cst.class);
                        if (cst2 != null) {
                            com.tencent.mm.plugin.comm.a aVar9 = com.tencent.mm.plugin.comm.a.qCo;
                            cst2.sGQ = com.tencent.mm.plugin.comm.a.cAK();
                            cst2.MxI = 86;
                            cst2.MxJ = com.tencent.mm.ac.d.zs(feedObject3.id);
                            cst2.scene = 8;
                            com.tencent.mm.ui.component.a aVar10 = com.tencent.mm.ui.component.a.PRN;
                            cst2.Vkb = ((FinderReporterUIC) com.tencent.mm.ui.component.a.ko(this.vcz.getContext()).get(FinderReporterUIC.class)).sGQ;
                            x xVar8 = x.SXb;
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_mv_cover_url", str);
                        intent2.putExtra("key_mv_feed_id", com.tencent.mm.ac.d.zs(j2));
                        intent2.putExtra("key_mv_nonce_id", str23);
                        intent2.putExtra("key_mv_poster", str2);
                        intent2.putExtra("key_need_update_music_ball_url", true);
                        FinderObject feedObject4 = ((bf) boVar).uOO.getFeedObject();
                        if (feedObject4 == null || (finderObjectDesc10 = feedObject4.objectDesc) == null || (axw20 = finderObjectDesc10.mvInfo) == null || (axy20 = axw20.Aqo) == null || (str3 = axy20.BPc) == null) {
                            str3 = "";
                        }
                        intent2.putExtra("key_mv_song_name", str3);
                        FinderObject feedObject5 = ((bf) boVar).uOO.getFeedObject();
                        if (feedObject5 == null || (finderObjectDesc9 = feedObject5.objectDesc) == null || (axw19 = finderObjectDesc9.mvInfo) == null || (axy19 = axw19.Aqo) == null || (str4 = axy19.LIh) == null) {
                            str4 = "";
                        }
                        intent2.putExtra("key_mv_song_lyric", str4);
                        FinderObject feedObject6 = ((bf) boVar).uOO.getFeedObject();
                        if (feedObject6 == null || (finderObjectDesc8 = feedObject6.objectDesc) == null || (axw18 = finderObjectDesc8.mvInfo) == null || (axy18 = axw18.Aqo) == null || (str5 = axy18.lDR) == null) {
                            str5 = "";
                        }
                        intent2.putExtra("key_mv_singer_name", str5);
                        FinderObject feedObject7 = ((bf) boVar).uOO.getFeedObject();
                        if (feedObject7 == null || (finderObjectDesc7 = feedObject7.objectDesc) == null || (axw17 = finderObjectDesc7.mvInfo) == null || (axy17 = axw17.Aqo) == null || (str6 = axy17.albumName) == null) {
                            str6 = "";
                        }
                        intent2.putExtra("key_mv_album_name", str6);
                        FinderObject feedObject8 = ((bf) boVar).uOO.getFeedObject();
                        if (feedObject8 == null || (finderObjectDesc6 = feedObject8.objectDesc) == null || (axw16 = finderObjectDesc6.mvInfo) == null || (axy16 = axw16.Aqo) == null || (str7 = axy16.LIi) == null) {
                            str7 = "";
                        }
                        intent2.putExtra("key_mv_music_genre", str7);
                        FinderObject feedObject9 = ((bf) boVar).uOO.getFeedObject();
                        if (feedObject9 == null || (finderObjectDesc5 = feedObject9.objectDesc) == null || (axw15 = finderObjectDesc5.mvInfo) == null || (axy15 = axw15.Aqo) == null || (str8 = String.valueOf(axy15.LIk)) == null) {
                            str8 = "";
                        }
                        intent2.putExtra("key_mv_issue_date", str8);
                        FinderObject feedObject10 = ((bf) boVar).uOO.getFeedObject();
                        if (feedObject10 == null || (finderObjectDesc4 = feedObject10.objectDesc) == null || (axw14 = finderObjectDesc4.mvInfo) == null || (axy14 = axw14.Aqo) == null || (str9 = axy14.Djf) == null) {
                            str9 = "";
                        }
                        intent2.putExtra("key_mv_album_cover_url", str9);
                        FinderObject feedObject11 = ((bf) boVar).uOO.getFeedObject();
                        if (feedObject11 == null || (finderObjectDesc3 = feedObject11.objectDesc) == null || (axw13 = finderObjectDesc3.mvInfo) == null || (axy13 = axw13.Aqo) == null || (str10 = axy13.extraInfo) == null) {
                            str10 = "";
                        }
                        intent2.putExtra("key_mv_extra_info", str10);
                        FinderObject feedObject12 = ((bf) boVar).uOO.getFeedObject();
                        if (feedObject12 == null || (finderObjectDesc2 = feedObject12.objectDesc) == null || (axw12 = finderObjectDesc2.mvInfo) == null || (axy12 = axw12.Aqo) == null || (str11 = axy12.identification) == null) {
                            str11 = "";
                        }
                        intent2.putExtra("key_mv_identification", str11);
                        FinderObject feedObject13 = ((bf) boVar).uOO.getFeedObject();
                        intent2.putExtra("key_mv_music_duration", (feedObject13 == null || (finderObjectDesc = feedObject13.objectDesc) == null || (axw11 = finderObjectDesc.mvInfo) == null || (axy11 = axw11.Aqo) == null) ? 0 : axy11.duration);
                        x xVar9 = x.SXb;
                        css2 = new css();
                        css2.Ktn = com.tencent.mm.ac.d.zs(j2);
                        css2.Kto = feedObject3.objectNonceId;
                        css2.Ktp = str;
                        com.tencent.mm.plugin.finder.api.g gVar2 = ((bf) boVar).contact;
                        css2.Ktq = gVar2 != null ? gVar2.getNickname() : null;
                        FinderObjectDesc finderObjectDesc23 = feedObject3.objectDesc;
                        css2.singerName = (finderObjectDesc23 == null || (axw10 = finderObjectDesc23.mvInfo) == null || (axy10 = axw10.Aqo) == null) ? null : axy10.lDR;
                        FinderObjectDesc finderObjectDesc24 = feedObject3.objectDesc;
                        css2.albumName = (finderObjectDesc24 == null || (axw9 = finderObjectDesc24.mvInfo) == null || (axy9 = axw9.Aqo) == null) ? null : axy9.albumName;
                        FinderObjectDesc finderObjectDesc25 = feedObject3.objectDesc;
                        css2.extraInfo = (finderObjectDesc25 == null || (axw8 = finderObjectDesc25.mvInfo) == null || (axy8 = axw8.Aqo) == null) ? null : axy8.extraInfo;
                        FinderObjectDesc finderObjectDesc26 = feedObject3.objectDesc;
                        css2.musicGenre = (finderObjectDesc26 == null || (axw7 = finderObjectDesc26.mvInfo) == null || (axy7 = axw7.Aqo) == null) ? null : axy7.LIi;
                        FinderObjectDesc finderObjectDesc27 = feedObject3.objectDesc;
                        css2.issueDate = (finderObjectDesc27 == null || (axw6 = finderObjectDesc27.mvInfo) == null || (axy6 = axw6.Aqo) == null) ? 0 : axy6.LIk;
                        FinderObjectDesc finderObjectDesc28 = feedObject3.objectDesc;
                        css2.identification = (finderObjectDesc28 == null || (axw5 = finderObjectDesc28.mvInfo) == null || (axy5 = axw5.Aqo) == null) ? null : axy5.identification;
                        FinderObjectDesc finderObjectDesc29 = feedObject3.objectDesc;
                        css2.Alz = (finderObjectDesc29 == null || (axw4 = finderObjectDesc29.mvInfo) == null || (axy4 = axw4.Aqo) == null) ? 0 : axy4.duration;
                        FinderObjectDesc finderObjectDesc30 = feedObject3.objectDesc;
                        css2.BPc = (finderObjectDesc30 == null || (axw3 = finderObjectDesc30.mvInfo) == null || (axy3 = axw3.Aqo) == null) ? null : axy3.BPc;
                        FinderObjectDesc finderObjectDesc31 = feedObject3.objectDesc;
                        css2.songLyric = (finderObjectDesc31 == null || (axw2 = finderObjectDesc31.mvInfo) == null || (axy2 = axw2.Aqo) == null) ? null : axy2.LIh;
                        FinderObjectDesc finderObjectDesc32 = feedObject3.objectDesc;
                        css2.EsK = (finderObjectDesc32 == null || (axw = finderObjectDesc32.mvInfo) == null || (axy = axw.Aqo) == null) ? null : axy.Djf;
                        css2.jfz = str;
                        x xVar10 = x.SXb;
                        Log.i("Finder.FinderProfileMusicUIC", "jump to musicMvMainUI");
                        com.tencent.mm.ui.component.a aVar11 = com.tencent.mm.ui.component.a.PRN;
                        ((FinderProfileFloatBallUIC) com.tencent.mm.ui.component.a.b(this.vcz.getActivity()).get(FinderProfileFloatBallUIC.class)).USD = false;
                        com.tencent.mm.plugin.finder.utils.a aVar12 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        com.tencent.mm.plugin.finder.utils.a.K(this.vcz.getContext(), intent2);
                        xVar = x.SXb;
                    }
                    if (xVar == null) {
                        Log.i("Finder.FinderProfileMusicUIC", "jump to musicMvMainUI error " + str + ' ' + str2 + ' ' + feedObject3.id + ' ' + feedObject3.objectNonceId);
                        x xVar11 = x.SXb;
                    }
                    FinderObject feedObject14 = ((bf) boVar).uOO.getFeedObject();
                    if (feedObject14 != null) {
                        FinderProfileMusicUIC.a(this.vcz, feedObject14);
                        axy axy33 = this.vcz.vcx;
                        if (axy33 != null) {
                            ac acVar2 = ac.vER;
                            ac.a(axy33, com.tencent.mm.ac.d.zs(feedObject14.id), css2);
                            x xVar12 = x.SXb;
                        }
                        this.vcz.vcx = null;
                        this.vcz.vcw = "";
                        x xVar13 = x.SXb;
                    }
                }
                x xVar14 = x.SXb;
            }
            AppMethodBeat.o(250432);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.aiy;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "Lcom/tencent/mm/view/BaseViewActionCallback;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "updateState", "", "plugin-finder_release"})
    public final class b extends com.tencent.mm.view.b {
        final /* synthetic */ FinderProfileMusicUIC vcz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FinderProfileMusicUIC finderProfileMusicUIC, RefreshLoadMoreLayout refreshLoadMoreLayout) {
            super(refreshLoadMoreLayout);
            p.h(refreshLoadMoreLayout, "rlLayout");
            this.vcz = finderProfileMusicUIC;
            AppMethodBeat.i(250430);
            AppMethodBeat.o(250430);
        }

        @Override // com.tencent.mm.view.b
        public final void dmp() {
            AppMethodBeat.i(250429);
            com.tencent.mm.ac.d.a(0, new a(this));
            AppMethodBeat.o(250429);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b vcA;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(0);
                this.vcA = bVar;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback$updateState$1$4$1"})
            /* renamed from: com.tencent.mm.plugin.finder.profile.uic.FinderProfileMusicUIC$b$a$a  reason: collision with other inner class name */
            static final class View$OnClickListenerC1264a implements View.OnClickListener {
                final /* synthetic */ a vcB;

                View$OnClickListenerC1264a(a aVar) {
                    this.vcB = aVar;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(250427);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback$updateState$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    RefreshLoadMoreLayout.d(FinderProfileMusicUIC.c(this.vcB.vcA.vcz));
                    this.vcB.vcA.dmp();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback$updateState$1$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(250427);
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(250428);
                Fragment fragment = this.vcA.vcz.getFragment();
                if (fragment == null || !fragment.isDetached()) {
                    Log.i("Finder.FinderProfileMusicUIC", "[updateState] state=" + FinderProfileMusicUIC.a(this.vcA.vcz).tWS + " cachedState=" + FinderProfileMusicUIC.a(this.vcA.vcz).tWT);
                    FrameLayout frameLayout = this.vcA.vcz.vaH;
                    if (frameLayout != null) {
                        frameLayout.setOnClickListener(null);
                        frameLayout.setVisibility(8);
                    }
                    FinderProfileMusicUIC.c(this.vcA.vcz).setBackgroundResource(R.color.f3048f);
                    FrameLayout frameLayout2 = this.vcA.vcz.vaG;
                    if (frameLayout2 != null) {
                        frameLayout2.setBackgroundResource(R.color.f3048f);
                    }
                    if (FinderProfileMusicUIC.a(this.vcA.vcz).tWT == FinderProfileMusicLoader.a.NO_CACHE) {
                        FinderProfileMusicUIC.c(this.vcA.vcz).setSuperNestedScroll(false);
                        switch (d.$EnumSwitchMapping$0[FinderProfileMusicUIC.a(this.vcA.vcz).tWS.ordinal()]) {
                            case 1:
                                FrameLayout frameLayout3 = this.vcA.vcz.vaH;
                                if (frameLayout3 != null) {
                                    frameLayout3.setVisibility(0);
                                    TextView textView = (TextView) frameLayout3.findViewById(R.id.ipb);
                                    p.g(textView, "it.tips_no_content");
                                    textView.setVisibility(8);
                                    LinearLayout linearLayout = (LinearLayout) frameLayout3.findViewById(R.id.d91);
                                    if (linearLayout != null) {
                                        linearLayout.setVisibility(8);
                                    }
                                    TextView textView2 = (TextView) frameLayout3.findViewById(R.id.ipc);
                                    p.g(textView2, "it.tips_retry");
                                    textView2.setVisibility(8);
                                    ProgressBar progressBar = (ProgressBar) frameLayout3.findViewById(R.id.ip_);
                                    p.g(progressBar, "it.tips_loading");
                                    progressBar.setVisibility(0);
                                    break;
                                }
                                break;
                            case 2:
                                FrameLayout frameLayout4 = this.vcA.vcz.vaH;
                                if (frameLayout4 != null) {
                                    frameLayout4.setVisibility(0);
                                    TextView textView3 = (TextView) frameLayout4.findViewById(R.id.ipb);
                                    p.g(textView3, "it.tips_no_content");
                                    textView3.setVisibility(0);
                                    LinearLayout linearLayout2 = (LinearLayout) frameLayout4.findViewById(R.id.d91);
                                    if (linearLayout2 != null) {
                                        linearLayout2.setVisibility(8);
                                    }
                                    TextView textView4 = (TextView) frameLayout4.findViewById(R.id.ipc);
                                    p.g(textView4, "it.tips_retry");
                                    textView4.setVisibility(8);
                                    ProgressBar progressBar2 = (ProgressBar) frameLayout4.findViewById(R.id.ip_);
                                    p.g(progressBar2, "it.tips_loading");
                                    progressBar2.setVisibility(8);
                                    break;
                                }
                                break;
                            case 3:
                                FrameLayout frameLayout5 = this.vcA.vcz.vaH;
                                if (frameLayout5 != null) {
                                    frameLayout5.setVisibility(0);
                                    TextView textView5 = (TextView) frameLayout5.findViewById(R.id.ipb);
                                    if (textView5 != null) {
                                        textView5.setVisibility(8);
                                    }
                                    LinearLayout linearLayout3 = (LinearLayout) frameLayout5.findViewById(R.id.d91);
                                    p.g(linearLayout3, "it.forbidden_tips");
                                    linearLayout3.setVisibility(8);
                                    TextView textView6 = (TextView) frameLayout5.findViewById(R.id.ipc);
                                    p.g(textView6, "it.tips_retry");
                                    textView6.setVisibility(0);
                                    ProgressBar progressBar3 = (ProgressBar) frameLayout5.findViewById(R.id.ip_);
                                    p.g(progressBar3, "it.tips_loading");
                                    progressBar3.setVisibility(8);
                                    frameLayout5.setOnClickListener(new View$OnClickListenerC1264a(this));
                                    break;
                                }
                                break;
                        }
                        FinderProfileMusicUIC.c(this.vcA.vcz).setBackgroundResource(R.color.f3045c);
                        FrameLayout frameLayout6 = this.vcA.vcz.vaG;
                        if (frameLayout6 != null) {
                            frameLayout6.setBackgroundResource(R.color.f3045c);
                        }
                    } else {
                        FinderProfileMusicUIC.c(this.vcA.vcz).setSuperNestedScroll(true);
                    }
                    switch (d.haE[FinderProfileMusicUIC.a(this.vcA.vcz).tWS.ordinal()]) {
                        case 1:
                            FrameLayout frameLayout7 = this.vcA.vcz.vaH;
                            if (frameLayout7 != null) {
                                frameLayout7.setVisibility(0);
                                TextView textView7 = (TextView) frameLayout7.findViewById(R.id.ipb);
                                p.g(textView7, "it.tips_no_content");
                                textView7.setVisibility(8);
                                LinearLayout linearLayout4 = (LinearLayout) frameLayout7.findViewById(R.id.d91);
                                p.g(linearLayout4, "it.forbidden_tips");
                                linearLayout4.setVisibility(0);
                                TextView textView8 = (TextView) frameLayout7.findViewById(R.id.ipc);
                                p.g(textView8, "it.tips_retry");
                                textView8.setVisibility(8);
                                ProgressBar progressBar4 = (ProgressBar) frameLayout7.findViewById(R.id.ip_);
                                p.g(progressBar4, "it.tips_loading");
                                progressBar4.setVisibility(8);
                            }
                            FinderProfileMusicUIC.c(this.vcA.vcz).setBackgroundResource(R.color.f3045c);
                            FrameLayout frameLayout8 = this.vcA.vcz.vaG;
                            if (frameLayout8 != null) {
                                frameLayout8.setBackgroundResource(R.color.f3045c);
                                break;
                            }
                            break;
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(250428);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/FinderProfileLayoutConfig;", "invoke"})
    static final class h extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.profile.a> {
        final /* synthetic */ FinderProfileMusicUIC vcz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(FinderProfileMusicUIC finderProfileMusicUIC) {
            super(0);
            this.vcz = finderProfileMusicUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.profile.a invoke() {
            AppMethodBeat.i(250439);
            com.tencent.mm.plugin.finder.profile.a aVar = new com.tencent.mm.plugin.finder.profile.a(this.vcz.getActivity(), this.vcz.isSelfFlag());
            AppMethodBeat.o(250439);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k extends q implements kotlin.g.a.a<RefreshLoadMoreLayout> {
        final /* synthetic */ Fragment uRC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(Fragment fragment) {
            super(0);
            this.uRC = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RefreshLoadMoreLayout invoke() {
            AppMethodBeat.i(250442);
            RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.uRC.getView().findViewById(R.id.h7t);
            AppMethodBeat.o(250442);
            return refreshLoadMoreLayout;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
    static final class j extends q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ FinderProfileMusicUIC vcz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderProfileMusicUIC finderProfileMusicUIC) {
            super(0);
            this.vcz = finderProfileMusicUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(250441);
            RecyclerView recyclerView = FinderProfileMusicUIC.c(this.vcz).getRecyclerView();
            AppMethodBeat.o(250441);
            return recyclerView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileMusicLoader;", "invoke"})
    static final class i extends q implements kotlin.g.a.a<FinderProfileMusicLoader> {
        final /* synthetic */ FinderProfileMusicUIC vcz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderProfileMusicUIC finderProfileMusicUIC) {
            super(0);
            this.vcz = finderProfileMusicUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderProfileMusicLoader invoke() {
            bbn bbn;
            AppMethodBeat.i(250440);
            String username = this.vcz.getUsername();
            String aUg = z.aUg();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.vcz.getActivity());
            if (fH != null) {
                bbn = fH.dIx();
            } else {
                bbn = null;
            }
            FinderProfileMusicLoader finderProfileMusicLoader = new FinderProfileMusicLoader(username, aUg, bbn);
            AppMethodBeat.o(250440);
            return finderProfileMusicLoader;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC$ViewActionCallback;", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileMusicUIC;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<b> {
        final /* synthetic */ FinderProfileMusicUIC vcz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderProfileMusicUIC finderProfileMusicUIC) {
            super(0);
            this.vcz = finderProfileMusicUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ b invoke() {
            AppMethodBeat.i(250431);
            FinderProfileMusicUIC finderProfileMusicUIC = this.vcz;
            RefreshLoadMoreLayout c2 = FinderProfileMusicUIC.c(this.vcz);
            p.g(c2, "rlLayout");
            b bVar = new b(finderProfileMusicUIC, c2);
            AppMethodBeat.o(250431);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderProfileMusicUIC vcz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderProfileMusicUIC finderProfileMusicUIC) {
            super(0);
            this.vcz = finderProfileMusicUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250438);
            FinderProfileMusicUIC.c(this.vcz).setHasBottomMore(false);
            FinderProfileMusicUIC.g(this.vcz);
            x xVar = x.SXb;
            AppMethodBeat.o(250438);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(FinderProfileMusicUIC finderProfileMusicUIC, FinderObject finderObject) {
        LinkedList<FinderMedia> linkedList;
        FinderMedia finderMedia;
        axw axw;
        AppMethodBeat.i(250452);
        FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
        finderProfileMusicUIC.vcx = (finderObjectDesc == null || (axw = finderObjectDesc.mvInfo) == null) ? null : axw.Aqo;
        FinderObjectDesc finderObjectDesc2 = finderObject.objectDesc;
        if (finderObjectDesc2 == null || (linkedList = finderObjectDesc2.media) == null || (finderMedia = (FinderMedia) kotlin.a.j.kt(linkedList)) == null) {
            AppMethodBeat.o(250452);
            return;
        }
        finderProfileMusicUIC.vcw = p.I(finderMedia.thumbUrl, finderMedia.thumb_url_token);
        AppMethodBeat.o(250452);
    }

    public static final /* synthetic */ void g(FinderProfileMusicUIC finderProfileMusicUIC) {
        View findViewById;
        View findViewById2;
        TextView textView;
        TextView textView2;
        AppMethodBeat.i(250453);
        View loadMoreFooter = finderProfileMusicUIC.getRlLayout().getLoadMoreFooter();
        if (!(loadMoreFooter == null || (textView2 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
            textView2.setText(R.string.d0m);
        }
        View loadMoreFooter2 = finderProfileMusicUIC.getRlLayout().getLoadMoreFooter();
        if (!(loadMoreFooter2 == null || (textView = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
            textView.setVisibility(8);
        }
        View loadMoreFooter3 = finderProfileMusicUIC.getRlLayout().getLoadMoreFooter();
        if (!(loadMoreFooter3 == null || (findViewById2 = loadMoreFooter3.findViewById(R.id.ep0)) == null)) {
            findViewById2.setVisibility(0);
        }
        View loadMoreFooter4 = finderProfileMusicUIC.getRlLayout().getLoadMoreFooter();
        if (loadMoreFooter4 == null || (findViewById = loadMoreFooter4.findViewById(R.id.ep0)) == null) {
            AppMethodBeat.o(250453);
            return;
        }
        findViewById.setBackgroundColor(finderProfileMusicUIC.getResources().getColor(R.color.afz));
        AppMethodBeat.o(250453);
    }
}
