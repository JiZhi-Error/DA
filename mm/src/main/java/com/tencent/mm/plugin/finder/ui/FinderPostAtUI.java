package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.cgi.bj;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFollowListUIC;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u00012\u00020\u0002:\u000501234B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0014J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\"\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0014J\b\u0010#\u001a\u00020\u0016H\u0014J,\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001e\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\r2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "Lkotlin/collections/ArrayList;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "fromType", "", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "recentAtContactList", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "doGetFollowScene", "", "getLayoutId", "initContentView", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "firstPage", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "Companion", "ContactViewHolder", "HeaderViewHolder", "SearchViewHolder", "SelectAtContactAdapter", "plugin-finder_release"})
public final class FinderPostAtUI extends MMFinderUI implements com.tencent.mm.ak.i {
    private static final String TAG = TAG;
    public static final a vME = new a((byte) 0);
    private HashMap _$_findViewCache;
    private int fromType;
    private RecyclerView hak;
    private boolean hasMore;
    private RefreshLoadMoreLayout tLS;
    private com.tencent.mm.bw.b tsO;
    private final com.tencent.mm.plugin.finder.storage.data.g uWD;
    private ArrayList<com.tencent.mm.plugin.finder.api.g> uae = new ArrayList<>();
    private ArrayList<com.tencent.mm.plugin.finder.api.g> vMD = new ArrayList<>();

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252588);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252588);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252587);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252587);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "o1", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "kotlin.jvm.PlatformType", "o2", "compare"})
    static final class h<T> implements Comparator<cjj> {
        public static final h vMK = new h();

        static {
            AppMethodBeat.i(252570);
            AppMethodBeat.o(252570);
        }

        h() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(cjj cjj, cjj cjj2) {
            AppMethodBeat.i(252569);
            int compare = Long.compare(cjj2.wal, cjj.wal);
            AppMethodBeat.o(252569);
            return compare;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "invoke"})
    static final class j extends q implements kotlin.g.a.b<LinkedList<FinderContact>, Object> {
        final /* synthetic */ FinderPostAtUI vMH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderPostAtUI finderPostAtUI) {
            super(1);
            this.vMH = finderPostAtUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Object invoke(LinkedList<FinderContact> linkedList) {
            AppMethodBeat.i(252572);
            LinkedList<FinderContact> linkedList2 = linkedList;
            com.tencent.mm.bw.b bVar = this.vMH.tsO;
            if (bVar == null) {
                if (linkedList2 != null) {
                    if (this.vMH.uae.isEmpty()) {
                        ArrayList arrayList = this.vMH.uae;
                        LinkedList<FinderContact> linkedList3 = linkedList2;
                        ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(linkedList3, 10));
                        Iterator<T> it = linkedList3.iterator();
                        while (it.hasNext()) {
                            FinderFollowListUIC.a aVar = FinderFollowListUIC.wwp;
                            arrayList2.add(FinderFollowListUIC.a.f(it.next()));
                        }
                        arrayList.addAll(arrayList2);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(252572);
                    return xVar;
                }
                bVar = null;
            }
            AppMethodBeat.o(252572);
            return bVar;
        }
    }

    public FinderPostAtUI() {
        AppMethodBeat.i(252582);
        FinderFollowListUIC.a aVar = FinderFollowListUIC.wwp;
        this.uWD = new com.tencent.mm.plugin.finder.storage.data.g(FinderFollowListUIC.dIb());
        this.hasMore = true;
        AppMethodBeat.o(252582);
    }

    public static final /* synthetic */ RecyclerView e(FinderPostAtUI finderPostAtUI) {
        AppMethodBeat.i(252584);
        RecyclerView recyclerView = finderPostAtUI.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        AppMethodBeat.o(252584);
        return recyclerView;
    }

    public static final /* synthetic */ void g(FinderPostAtUI finderPostAtUI) {
        AppMethodBeat.i(252585);
        finderPostAtUI.dzW();
        AppMethodBeat.o(252585);
    }

    public static final /* synthetic */ RefreshLoadMoreLayout h(FinderPostAtUI finderPostAtUI) {
        AppMethodBeat.i(252586);
        RefreshLoadMoreLayout refreshLoadMoreLayout = finderPostAtUI.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        AppMethodBeat.o(252586);
        return refreshLoadMoreLayout;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$Companion;", "", "()V", "ENTER_FROM_SIGNATURE", "", "REQUEST_CODE_SELECT_AT_CONTACT", "TAG", "", "getTAG", "()Ljava/lang/String;", "followContactViewType", "followHeaderViewType", "recentAtContactViewType", "recentAtHeaderViewType", "searchViewType", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(252583);
        AppMethodBeat.o(252583);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ai8;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(252575);
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.azz().a(713, this);
        this.fromType = getIntent().getIntExtra("KEY_ENTER_SCENE", 0);
        com.tencent.mm.plugin.finder.utils.d dVar = com.tencent.mm.plugin.finder.utils.d.vVg;
        LinkedList<cjj> dBy = com.tencent.mm.plugin.finder.utils.d.dBy();
        if (dBy != null) {
            Collections.sort(dBy, h.vMK);
            Iterator<cjj> it = dBy.iterator();
            while (it.hasNext()) {
                cjj next = it.next();
                com.tencent.mm.plugin.finder.utils.d dVar2 = com.tencent.mm.plugin.finder.utils.d.vVg;
                p.g(next, "contact");
                this.vMD.add(com.tencent.mm.plugin.finder.utils.d.a(next));
            }
        }
        com.tencent.mm.ac.d.b(com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), new i(this)), new j(this));
        dzW();
        setResult(0, getIntent());
        if (this.fromType == 1) {
            setMMTitle(getResources().getString(R.string.d5b));
        } else {
            setMMTitle(getResources().getString(R.string.d5a));
        }
        setBackBtn(new f(this));
        View findViewById = getContext().findViewById(R.id.h7t);
        p.g(findViewById, "context.findViewById(R.id.rl_layout)");
        this.tLS = (RefreshLoadMoreLayout) findViewById;
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        this.hak = refreshLoadMoreLayout.getRecyclerView();
        FinderLinearLayoutManager finderLinearLayoutManager = new FinderLinearLayoutManager(this);
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        recyclerView.setLayoutManager(finderLinearLayoutManager);
        RecyclerView recyclerView2 = this.hak;
        if (recyclerView2 == null) {
            p.btv("recyclerView");
        }
        recyclerView2.setAdapter(new e());
        RecyclerView recyclerView3 = this.hak;
        if (recyclerView3 == null) {
            p.btv("recyclerView");
        }
        recyclerView3.setHasFixedSize(true);
        RecyclerView recyclerView4 = this.hak;
        if (recyclerView4 == null) {
            p.btv("recyclerView");
        }
        recyclerView4.setItemViewCacheSize(5);
        RecyclerView recyclerView5 = this.hak;
        if (recyclerView5 == null) {
            p.btv("recyclerView");
        }
        RecyclerView.a adapter = recyclerView5.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
            AppMethodBeat.o(252575);
            throw tVar;
        }
        ((e) adapter).notifyDataSetChanged();
        RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tLS;
        if (refreshLoadMoreLayout2 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout2.setEnablePullDownHeader(false);
        RefreshLoadMoreLayout refreshLoadMoreLayout3 = this.tLS;
        if (refreshLoadMoreLayout3 == null) {
            p.btv("rlLayout");
        }
        View inflate = aa.jQ(getContext()).inflate(R.layout.b21, (ViewGroup) null);
        p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        refreshLoadMoreLayout3.setLoadMoreFooter(inflate);
        RefreshLoadMoreLayout refreshLoadMoreLayout4 = this.tLS;
        if (refreshLoadMoreLayout4 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout4.setActionCallback(new g(this));
        AppMethodBeat.o(252575);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class f implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderPostAtUI vMH;

        f(FinderPostAtUI finderPostAtUI) {
            this.vMH = finderPostAtUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252564);
            this.vMH.finish();
            AppMethodBeat.o(252564);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
    public static final class g extends RefreshLoadMoreLayout.a {
        final /* synthetic */ FinderPostAtUI vMH;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(252566);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(252566);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(252568);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(252568);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(252567);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(252567);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(FinderPostAtUI finderPostAtUI) {
            this.vMH = finderPostAtUI;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            View findViewById;
            TextView textView;
            TextView textView2;
            View findViewById2;
            TextView textView3;
            TextView textView4;
            AppMethodBeat.i(252565);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            a aVar = FinderPostAtUI.vME;
            Log.i(FinderPostAtUI.TAG, "onLoadMoreBegin");
            if (FinderPostAtUI.e(this.vMH) != null) {
                if (this.vMH.hasMore) {
                    FinderPostAtUI.g(this.vMH);
                    View loadMoreFooter = FinderPostAtUI.h(this.vMH).getLoadMoreFooter();
                    if (!(loadMoreFooter == null || (textView4 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                        textView4.setText(R.string.d0l);
                    }
                    View loadMoreFooter2 = FinderPostAtUI.h(this.vMH).getLoadMoreFooter();
                    if (!(loadMoreFooter2 == null || (textView3 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                        textView3.setVisibility(0);
                    }
                    View loadMoreFooter3 = FinderPostAtUI.h(this.vMH).getLoadMoreFooter();
                    if (!(loadMoreFooter3 == null || (findViewById2 = loadMoreFooter3.findViewById(R.id.ep0)) == null)) {
                        findViewById2.setVisibility(8);
                    }
                } else {
                    View loadMoreFooter4 = FinderPostAtUI.h(this.vMH).getLoadMoreFooter();
                    if (!(loadMoreFooter4 == null || (textView2 = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                        textView2.setText(R.string.d0m);
                    }
                    View loadMoreFooter5 = FinderPostAtUI.h(this.vMH).getLoadMoreFooter();
                    if (!(loadMoreFooter5 == null || (textView = (TextView) loadMoreFooter5.findViewById(R.id.ep1)) == null)) {
                        textView.setVisibility(8);
                    }
                    View loadMoreFooter6 = FinderPostAtUI.h(this.vMH).getLoadMoreFooter();
                    if (!(loadMoreFooter6 == null || (findViewById = loadMoreFooter6.findViewById(R.id.ep0)) == null)) {
                        findViewById.setVisibility(0);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(252565);
        }
    }

    private final void dzW() {
        AppMethodBeat.i(252576);
        com.tencent.mm.kernel.g.azz().b(new bj(this.tsO));
        AppMethodBeat.o(252576);
    }

    private final void d(boolean z, List<? extends FinderContact> list) {
        AppMethodBeat.i(252577);
        Log.i(TAG, "firstPage " + z + ", get follow contact " + list.size());
        if (z) {
            this.uae.clear();
        }
        ArrayList<com.tencent.mm.plugin.finder.api.g> arrayList = this.uae;
        List<? extends FinderContact> list2 = list;
        ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            FinderFollowListUIC.a aVar = FinderFollowListUIC.wwp;
            arrayList2.add(FinderFollowListUIC.a.f(it.next()));
        }
        arrayList.addAll(arrayList2);
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
            AppMethodBeat.o(252577);
            throw tVar;
        }
        ((e) adapter).notifyDataSetChanged();
        AppMethodBeat.o(252577);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(252578);
        super.onResume();
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
            AppMethodBeat.o(252578);
            throw tVar;
        }
        if (!((e) adapter).vMI) {
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 == null) {
                p.btv("recyclerView");
            }
            RecyclerView.a adapter2 = recyclerView2.getAdapter();
            if (adapter2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
                AppMethodBeat.o(252578);
                throw tVar2;
            }
            ((e) adapter2).vMI = true;
            RecyclerView recyclerView3 = this.hak;
            if (recyclerView3 == null) {
                p.btv("recyclerView");
            }
            RecyclerView.a adapter3 = recyclerView3.getAdapter();
            if (adapter3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
                AppMethodBeat.o(252578);
                throw tVar3;
            }
            ((e) adapter3).cj(0);
            com.tencent.f.h.RTc.n(new k(this), 300);
        }
        AppMethodBeat.o(252578);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class k implements Runnable {
        final /* synthetic */ FinderPostAtUI vMH;

        k(FinderPostAtUI finderPostAtUI) {
            this.vMH = finderPostAtUI;
        }

        public final void run() {
            AppMethodBeat.i(252573);
            RecyclerView.a adapter = FinderPostAtUI.e(this.vMH).getAdapter();
            if (adapter == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderPostAtUI.SelectAtContactAdapter");
                AppMethodBeat.o(252573);
                throw tVar;
            }
            ((e) adapter).notifyDataSetChanged();
            AppMethodBeat.o(252573);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(252579);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(713, this);
        AppMethodBeat.o(252579);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        Integer num = null;
        AppMethodBeat.i(252580);
        Log.i(TAG, "errType " + i2 + ", errCode " + i3 + ", errMsg " + str + " scene type " + (qVar != null ? Integer.valueOf(qVar.getType()) : null));
        if (qVar != null) {
            num = Integer.valueOf(qVar.getType());
        }
        if (num == null) {
            AppMethodBeat.o(252580);
            return;
        }
        if (num.intValue() == 713 && i2 == 0 && i3 == 0) {
            z.a aVar = new z.a();
            aVar.SYB = false;
            if (qVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFollowList");
                AppMethodBeat.o(252580);
                throw tVar;
            }
            if (!p.j(this.tsO, ((bj) qVar).cYn())) {
                Log.i(TAG, "not my buf, ignore!");
                AppMethodBeat.o(252580);
                return;
            }
            if (this.tsO == null) {
                aVar.SYB = true;
                com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), new l(this, aVar, qVar));
            }
            this.hasMore = ((bj) qVar).cYp();
            this.tsO = ((bj) qVar).cYm();
            d(aVar.SYB, ((bj) qVar).cYt());
        }
        AppMethodBeat.o(252580);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(252581);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT:
                if (intent != null && i3 == -1) {
                    getIntent().putExtra("key_select_contact", intent.getByteArrayExtra("at_select_contact"));
                    getIntent().putExtra("key_source", intent.getBooleanExtra("is_follow", false) ? 3 : 4);
                    setResult(-1, getIntent());
                    finish();
                    break;
                }
        }
        AppMethodBeat.o(252581);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;)V", "hasSearchView", "", "getHasSearchView", "()Z", "setHasSearchView", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
    public final class e extends RecyclerView.a<RecyclerView.v> {
        boolean vMI = true;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public e() {
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(252562);
            p.h(viewGroup, "parent");
            switch (i2) {
                case 1:
                    FinderPostAtUI finderPostAtUI = FinderPostAtUI.this;
                    AppCompatActivity context = FinderPostAtUI.this.getContext();
                    if (context == null) {
                        p.hyc();
                    }
                    View inflate = context.getLayoutInflater().inflate(R.layout.l, viewGroup, false);
                    p.g(inflate, "context!!.layoutInflater…arch_item, parent, false)");
                    d dVar = new d(finderPostAtUI, inflate);
                    AppMethodBeat.o(252562);
                    return dVar;
                case 2:
                    FinderPostAtUI finderPostAtUI2 = FinderPostAtUI.this;
                    AppCompatActivity context2 = FinderPostAtUI.this.getContext();
                    if (context2 == null) {
                        p.hyc();
                    }
                    View inflate2 = context2.getLayoutInflater().inflate(R.layout.ai7, viewGroup, false);
                    p.g(inflate2, "context!!.layoutInflater…ader_item, parent, false)");
                    c cVar = new c(finderPostAtUI2, inflate2);
                    AppMethodBeat.o(252562);
                    return cVar;
                case 3:
                default:
                    FinderPostAtUI finderPostAtUI3 = FinderPostAtUI.this;
                    AppCompatActivity context3 = FinderPostAtUI.this.getContext();
                    if (context3 == null) {
                        p.hyc();
                    }
                    View inflate3 = context3.getLayoutInflater().inflate(R.layout.a9y, viewGroup, false);
                    p.g(inflate3, "context!!.layoutInflater…list_item, parent, false)");
                    b bVar = new b(finderPostAtUI3, inflate3);
                    AppMethodBeat.o(252562);
                    return bVar;
                case 4:
                    FinderPostAtUI finderPostAtUI4 = FinderPostAtUI.this;
                    AppCompatActivity context4 = FinderPostAtUI.this.getContext();
                    if (context4 == null) {
                        p.hyc();
                    }
                    View inflate4 = context4.getLayoutInflater().inflate(R.layout.ai7, viewGroup, false);
                    p.g(inflate4, "context!!.layoutInflater…ader_item, parent, false)");
                    c cVar2 = new c(finderPostAtUI4, inflate4);
                    AppMethodBeat.o(252562);
                    return cVar2;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            com.tencent.mm.plugin.finder.api.g gVar;
            int i3;
            String str;
            int i4 = 2;
            AppMethodBeat.i(252563);
            p.h(vVar, "viewHolder");
            if (vVar instanceof b) {
                if (!this.vMI) {
                    i4 = 1;
                }
                if (FinderPostAtUI.this.vMD.size() == 0) {
                    gVar = (com.tencent.mm.plugin.finder.api.g) FinderPostAtUI.this.uae.get(i2 - i4);
                } else if (i2 < FinderPostAtUI.this.vMD.size() + i4) {
                    gVar = (com.tencent.mm.plugin.finder.api.g) FinderPostAtUI.this.vMD.get(i2 - i4);
                } else {
                    gVar = (com.tencent.mm.plugin.finder.api.g) FinderPostAtUI.this.uae.get(((i2 - FinderPostAtUI.this.vMD.size()) - i4) - 1);
                }
                p.g(gVar, "if (recentAtContactList.…      }\n                }");
                m mVar = m.uJa;
                com.tencent.mm.loader.d<o> dka = m.dka();
                com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(gVar.cXH());
                ImageView imageView = ((b) vVar).gyr;
                m mVar2 = m.uJa;
                dka.a(aVar, imageView, m.a(m.a.AVATAR));
                ((b) vVar).pIN.setText(com.tencent.mm.pluginsdk.ui.span.l.c(FinderPostAtUI.this.getContext(), gVar.getNickname()));
                FinderAuthInfo finderAuthInfo = gVar.field_authInfo;
                if (finderAuthInfo != null) {
                    i3 = finderAuthInfo.authIconType;
                } else {
                    i3 = 0;
                }
                ((b) vVar).vMG.setVisibility(8);
                y yVar = y.vXH;
                y.a(((b) vVar).vMF, gVar.field_authInfo);
                if (i3 > 0) {
                    switch (i3) {
                        case 1:
                            ((b) vVar).vMG.setVisibility(0);
                            TextView textView = ((b) vVar).vMG;
                            FinderAuthInfo finderAuthInfo2 = gVar.field_authInfo;
                            textView.setText((finderAuthInfo2 == null || (str = finderAuthInfo2.authProfession) == null) ? "" : str);
                            break;
                        case 100:
                            ((b) vVar).vMG.setVisibility(8);
                            break;
                    }
                } else {
                    ((b) vVar).vMG.setVisibility(8);
                }
                View view = vVar.aus;
                p.g(view, "viewHolder.itemView");
                view.setTag(gVar);
                vVar.aus.setOnClickListener(new a(this, vVar, i2));
                AppMethodBeat.o(252563);
            } else if (vVar instanceof d) {
                vVar.aus.setOnClickListener(new b(this));
                AppMethodBeat.o(252563);
            } else {
                if (vVar instanceof c) {
                    if (getItemViewType(i2) == 2) {
                        ((c) vVar).titleTv.setText(FinderPostAtUI.this.getString(R.string.d5_));
                        AppMethodBeat.o(252563);
                        return;
                    }
                    ((c) vVar).titleTv.setText(FinderPostAtUI.this.getString(R.string.d59));
                }
                AppMethodBeat.o(252563);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ RecyclerView.v vLC;
            final /* synthetic */ e vMJ;

            a(e eVar, RecyclerView.v vVar, int i2) {
                this.vMJ = eVar;
                this.vLC = vVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(252558);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.finder.utils.d dVar = com.tencent.mm.plugin.finder.utils.d.vVg;
                View view2 = this.vLC.aus;
                p.g(view2, "viewHolder.itemView");
                Object tag = view2.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
                    AppMethodBeat.o(252558);
                    throw tVar;
                }
                FinderPostAtUI.this.getIntent().putExtra("key_select_contact", com.tencent.mm.plugin.finder.utils.d.h((com.tencent.mm.plugin.finder.api.g) tag).toByteArray());
                if (this.vMJ.getItemViewType(this.gUj) == 5) {
                    FinderPostAtUI.this.getIntent().putExtra("key_source", 2);
                } else {
                    FinderPostAtUI.this.getIntent().putExtra("key_source", 1);
                }
                FinderPostAtUI.this.setResult(-1, FinderPostAtUI.this.getIntent());
                FinderPostAtUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(252558);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class b implements View.OnClickListener {
            final /* synthetic */ e vMJ;

            b(e eVar) {
                this.vMJ = eVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(252559);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FinderPostAtUI.this.getIntent().putExtra("from_at_contact", true);
                FinderPostAtUI.this.getIntent().putExtra("request_type", 6);
                FinderPostAtUI.this.getIntent().putExtra("need_history", false);
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                Intent intent = FinderPostAtUI.this.getIntent();
                p.g(intent, "intent");
                com.tencent.mm.plugin.finder.utils.a.a((MMActivity) FinderPostAtUI.this, intent);
                this.vMJ.vMI = false;
                this.vMJ.ck(0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$SelectAtContactAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(252559);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(252560);
            if (!this.vMI) {
                i2++;
            }
            if (i2 == 0) {
                AppMethodBeat.o(252560);
                return 1;
            } else if (FinderPostAtUI.this.vMD.size() > 0) {
                if (i2 == 1) {
                    AppMethodBeat.o(252560);
                    return 2;
                } else if (i2 == FinderPostAtUI.this.vMD.size() + 2) {
                    AppMethodBeat.o(252560);
                    return 4;
                } else if (i2 > FinderPostAtUI.this.vMD.size() + 2) {
                    AppMethodBeat.o(252560);
                    return 5;
                } else {
                    AppMethodBeat.o(252560);
                    return 3;
                }
            } else if (i2 == 1) {
                AppMethodBeat.o(252560);
                return 4;
            } else {
                AppMethodBeat.o(252560);
                return 5;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            int i2 = 0;
            AppMethodBeat.i(252561);
            int size = (this.vMI ? 1 : 0) + (FinderPostAtUI.this.vMD.size() == 0 ? 0 : FinderPostAtUI.this.vMD.size() + 1);
            if (FinderPostAtUI.this.uae.size() != 0) {
                i2 = FinderPostAtUI.this.uae.size() + 1;
            }
            int i3 = size + i2;
            AppMethodBeat.o(252561);
            return i3;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$ContactViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "authIcon", "Landroid/widget/ImageView;", "getAuthIcon", "()Landroid/widget/ImageView;", "setAuthIcon", "(Landroid/widget/ImageView;)V", "authJob", "Landroid/widget/TextView;", "getAuthJob", "()Landroid/widget/TextView;", "setAuthJob", "(Landroid/widget/TextView;)V", "avatarIv", "getAvatarIv", "setAvatarIv", "nicknameTv", "getNicknameTv", "setNicknameTv", "plugin-finder_release"})
    public final class b extends RecyclerView.v {
        ImageView gyr;
        TextView pIN;
        ImageView vMF;
        TextView vMG;
        final /* synthetic */ FinderPostAtUI vMH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FinderPostAtUI finderPostAtUI, View view) {
            super(view);
            p.h(view, "itemView");
            this.vMH = finderPostAtUI;
            AppMethodBeat.i(252555);
            View findViewById = view.findViewById(R.id.x1);
            p.g(findViewById, "itemView.findViewById(R.id.avatar_iv)");
            this.gyr = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.fzg);
            p.g(findViewById2, "itemView.findViewById(R.id.nickname_tv)");
            this.pIN = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.w0);
            p.g(findViewById3, "itemView.findViewById(R.id.auth_icon)");
            this.vMF = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(R.id.w2);
            p.g(findViewById4, "itemView.findViewById(R.id.auth_job)");
            this.vMG = (TextView) findViewById4;
            AppMethodBeat.o(252555);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$SearchViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "plugin-finder_release"})
    public final class d extends RecyclerView.v {
        final /* synthetic */ FinderPostAtUI vMH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(FinderPostAtUI finderPostAtUI, View view) {
            super(view);
            p.h(view, "itemView");
            this.vMH = finderPostAtUI;
            AppMethodBeat.i(252557);
            AppMethodBeat.o(252557);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderPostAtUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
    public final class c extends RecyclerView.v {
        TextView titleTv;
        final /* synthetic */ FinderPostAtUI vMH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(FinderPostAtUI finderPostAtUI, View view) {
            super(view);
            p.h(view, "itemView");
            this.vMH = finderPostAtUI;
            AppMethodBeat.i(252556);
            View findViewById = view.findViewById(R.id.ir3);
            p.g(findViewById, "itemView.findViewById(R.id.title_tv)");
            this.titleTv = (TextView) findViewById;
            AppMethodBeat.o(252556);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
    static final class i extends q implements kotlin.g.a.b<Void, LinkedList<FinderContact>> {
        final /* synthetic */ FinderPostAtUI vMH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderPostAtUI finderPostAtUI) {
            super(1);
            this.vMH = finderPostAtUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ LinkedList<FinderContact> invoke(Void r3) {
            AppMethodBeat.i(252571);
            LinkedList blq = this.vMH.uWD.blq();
            AppMethodBeat.o(252571);
            return blq;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderPostAtUI$onSceneEnd$1$1"})
    static final class l extends q implements kotlin.g.a.b<Void, x> {
        final /* synthetic */ z.a uWF;
        final /* synthetic */ com.tencent.mm.ak.q uWG;
        final /* synthetic */ FinderPostAtUI vMH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(FinderPostAtUI finderPostAtUI, z.a aVar, com.tencent.mm.ak.q qVar) {
            super(1);
            this.vMH = finderPostAtUI;
            this.uWF = aVar;
            this.uWG = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Void r4) {
            AppMethodBeat.i(252574);
            this.vMH.uWD.blr();
            this.vMH.uWD.r(((bj) this.uWG).cYt());
            x xVar = x.SXb;
            AppMethodBeat.o(252574);
            return xVar;
        }
    }
}
