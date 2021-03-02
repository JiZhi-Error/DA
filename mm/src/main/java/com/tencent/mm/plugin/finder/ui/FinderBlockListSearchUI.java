package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.p;
import com.tencent.mm.plugin.finder.storage.ad;
import com.tencent.mm.plugin.finder.storage.ae;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001DB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010&\u001a\u00020\u0006H\u0014J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020(H\u0014J\u0012\u0010+\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010/\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00100\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u000102H\u0016J6\u00103\u001a\u00020(2\b\u00104\u001a\u0004\u0018\u00010\n2\b\u00105\u001a\u0004\u0018\u00010\n2\u000e\u00106\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001072\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020=H\u0016J\u001a\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u00062\b\u0010A\u001a\u0004\u0018\u000108H\u0016J\u0010\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\nH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R!\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0019j\b\u0012\u0004\u0012\u00020\r`\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "DEL_MENU_ID", "", "getDEL_MENU_ID", "()I", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/FinderContactConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;)V", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "fillType", "getFillType", "()Ljava/lang/String;", "setFillType", "(Ljava/lang/String;)V", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getLayoutId", "initData", "", "initSearchView", "initView", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onSearchKeyDown", "onTagClick", FirebaseAnalytics.b.INDEX, "tag", "startSearch", SearchIntents.EXTRA_QUERY, "Companion", "plugin-finder_release"})
public final class FinderBlockListSearchUI extends MMFinderUI implements FTSEditTextView.a, a.b {
    private static final String vHu = vHu;
    public static final a vHv = new a((byte) 0);
    private final String TAG = "Finder.FinderBlockListSearchUI";
    private HashMap _$_findViewCache;
    final ArrayList<p> data = new ArrayList<>();
    private WxRecyclerAdapter<p> tFp;
    ak uWp;
    final int uWt;
    private com.tencent.mm.ui.search.a ubO;
    private String vHt = "";

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252153);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252153);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252152);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252152);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderBlockListSearchUI() {
        AppMethodBeat.i(252150);
        AppMethodBeat.o(252150);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$Companion;", "", "()V", FinderBlockListSearchUI.vHu, "", "getBLOCK_LIST_SEARCH_TYPE", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(252151);
        AppMethodBeat.o(252151);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a9i;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        ad adVar;
        AppMethodBeat.i(252142);
        super.onCreate(bundle);
        this.ubO = new com.tencent.mm.ui.search.a(this);
        com.tencent.mm.ui.search.a aVar = this.ubO;
        if (aVar == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar.setSearchViewListener(this);
        com.tencent.mm.ui.search.a aVar2 = this.ubO;
        if (aVar2 == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar2.getFtsEditText().setHint(getString(R.string.yn));
        com.tencent.mm.ui.search.a aVar3 = this.ubO;
        if (aVar3 == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar3.getFtsEditText().setFtsEditTextListener(this);
        com.tencent.mm.ui.search.a aVar4 = this.ubO;
        if (aVar4 == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar4.getFtsEditText().setCanDeleteTag(false);
        com.tencent.mm.ui.search.a aVar5 = this.ubO;
        if (aVar5 == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar5.getFtsEditText().gWY();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            kotlin.g.b.p.hyc();
        }
        kotlin.g.b.p.g(supportActionBar, "supportActionBar!!");
        com.tencent.mm.ui.search.a aVar6 = this.ubO;
        if (aVar6 == null) {
            kotlin.g.b.p.btv("searchView");
        }
        supportActionBar.setCustomView(aVar6);
        com.tencent.mm.ui.search.a aVar7 = this.ubO;
        if (aVar7 == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar7.getFtsEditText().awD();
        com.tencent.mm.ui.search.a aVar8 = this.ubO;
        if (aVar8 == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar8.getFtsEditText().awC();
        initView();
        String stringExtra = getIntent().getStringExtra(vHu);
        kotlin.g.b.p.g(stringExtra, "intent.getStringExtra(BLOCK_LIST_SEARCH_TYPE)");
        this.vHt = stringExtra;
        String str = this.vHt;
        switch (str.hashCode()) {
            case -1420651735:
                if (str.equals("@finder.block.his.liked.android")) {
                    adVar = new ad();
                    break;
                }
                adVar = null;
                break;
            case -1012936139:
                if (str.equals("@finder.block.my.liked.android")) {
                    adVar = new ae();
                    break;
                }
                adVar = null;
                break;
            default:
                adVar = null;
                break;
        }
        this.uWp = adVar;
        auV("");
        AppMethodBeat.o(252142);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class b implements f {
        b() {
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final e<?> EC(int i2) {
            AppMethodBeat.i(252136);
            if (i2 == p.class.getName().hashCode()) {
                com.tencent.mm.plugin.finder.convert.a aVar = new com.tencent.mm.plugin.finder.convert.a();
                AppMethodBeat.o(252136);
                return aVar;
            }
            kotlin.g.b.p.hyc();
            AppMethodBeat.o(252136);
            return null;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(252143);
        WxRecyclerView wxRecyclerView = (WxRecyclerView) _$_findCachedViewById(R.id.ckh);
        kotlin.g.b.p.g(wxRecyclerView, "finder_block_list_search");
        getContext();
        wxRecyclerView.setLayoutManager(new LinearLayoutManager());
        this.tFp = new WxRecyclerAdapter<>(new b(), this.data, true);
        WxRecyclerView wxRecyclerView2 = (WxRecyclerView) _$_findCachedViewById(R.id.ckh);
        kotlin.g.b.p.g(wxRecyclerView2, "finder_block_list_search");
        wxRecyclerView2.setAdapter(this.tFp);
        WxRecyclerAdapter<p> wxRecyclerAdapter = this.tFp;
        if (wxRecyclerAdapter != null) {
            wxRecyclerAdapter.RqO = new c(this);
        }
        WxRecyclerAdapter<p> wxRecyclerAdapter2 = this.tFp;
        if (wxRecyclerAdapter2 != null) {
            wxRecyclerAdapter2.RqP = new d(this);
            AppMethodBeat.o(252143);
            return;
        }
        AppMethodBeat.o(252143);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
    public static final class c implements g.d<h> {
        final /* synthetic */ FinderBlockListSearchUI vHw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderBlockListSearchUI finderBlockListSearchUI) {
            this.vHw = finderBlockListSearchUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.d
        public final /* synthetic */ boolean b(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
            AppMethodBeat.i(252140);
            kotlin.g.b.p.h(aVar, "adapter");
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(hVar, "holder");
            com.tencent.mm.ui.widget.b.a aVar2 = new com.tencent.mm.ui.widget.b.a(this.vHw.getContext());
            int size = i2 - ((g) aVar).RqM.size();
            TouchableLayout.a aVar3 = TouchableLayout.Rni;
            int i3 = TouchableLayout.kuv;
            TouchableLayout.a aVar4 = TouchableLayout.Rni;
            aVar2.a(view, size, 0, new a(this), new b(this, size, aVar), i3, TouchableLayout.kuw);
            aVar2.gTx();
            AppMethodBeat.o(252140);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2$onItemLongClick$1", "Landroid/view/View$OnCreateContextMenuListener;", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
        public static final class a implements View.OnCreateContextMenuListener {
            final /* synthetic */ c vHx;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(c cVar) {
                this.vHx = cVar;
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(252137);
                if (contextMenu != null) {
                    contextMenu.add(0, this.vHx.vHw.uWt, 0, R.string.d1k);
                    AppMethodBeat.o(252137);
                    return;
                }
                AppMethodBeat.o(252137);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2$onItemLongClick$2", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "", "plugin-finder_release"})
        public static final class b implements o.g {
            final /* synthetic */ RecyclerView.a tPP;
            final /* synthetic */ int uWy;
            final /* synthetic */ c vHx;

            b(c cVar, int i2, RecyclerView.a aVar) {
                this.vHx = cVar;
                this.uWy = i2;
                this.tPP = aVar;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$2$onItemLongClick$2$onMMMenuItemSelected$1", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onDel", "", "success", "", "plugin-finder_release"})
            public static final class a implements ak.a {
                final /* synthetic */ b vHy;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                a(b bVar) {
                    this.vHy = bVar;
                }

                @Override // com.tencent.mm.plugin.finder.storage.ak.a
                public final void nN(boolean z) {
                    AppMethodBeat.i(252138);
                    if (z) {
                        this.vHy.vHx.vHw.data.remove(this.vHy.uWy);
                        this.vHy.tPP.ck(((g) this.vHy.tPP).RqM.size() + this.vHy.uWy);
                        AppMethodBeat.o(252138);
                        return;
                    }
                    u.makeText(this.vHy.vHx.vHw.getContext(), StateEvent.ProcessResult.FAILED, 0).show();
                    AppMethodBeat.o(252138);
                }
            }

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                ak akVar;
                AppMethodBeat.i(252139);
                if (this.uWy < 0 || this.uWy >= this.vHx.vHw.data.size() || (akVar = this.vHx.vHw.uWp) == null) {
                    AppMethodBeat.o(252139);
                    return;
                }
                akVar.a(this.vHx.vHw.data.get(this.uWy).contact, new a(this));
                AppMethodBeat.o(252139);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderBlockListSearchUI$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
    public static final class d implements g.c<h> {
        final /* synthetic */ FinderBlockListSearchUI vHw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderBlockListSearchUI finderBlockListSearchUI) {
            this.vHw = finderBlockListSearchUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
            AppMethodBeat.i(252141);
            h hVar2 = hVar;
            kotlin.g.b.p.h(aVar, "adapter");
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(hVar2, "holder");
            int size = i2 - ((g) aVar).RqM.size();
            if (size >= 0 && size < this.vHw.data.size()) {
                FinderContact finderContact = this.vHw.data.get(size).contact;
                if (as.bjt(finderContact.username)) {
                    Intent intent = new Intent();
                    intent.putExtra("finder_username", finderContact.username);
                    com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Context context = hVar2.getContext();
                    kotlin.g.b.p.g(context, "holder.context");
                    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context, intent);
                    AppMethodBeat.o(252141);
                    return;
                }
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                String str = finderContact.username;
                AppCompatActivity context2 = this.vHw.getContext();
                kotlin.g.b.p.g(context2, "context");
                com.tencent.mm.plugin.finder.utils.a.d(str, context2);
            }
            AppMethodBeat.o(252141);
        }
    }

    public final void onClickCancelBtn(View view) {
        AppMethodBeat.i(252144);
        hideVKB();
        finish();
        AppMethodBeat.o(252144);
    }

    @Override // com.tencent.mm.ui.search.a.b
    public final void onClickBackBtn(View view) {
        AppMethodBeat.i(252145);
        hideVKB();
        finish();
        AppMethodBeat.o(252145);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (r0 == null) goto L_0x003d;
     */
    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean awE() {
        /*
            r3 = this;
            r2 = 252146(0x3d8f2, float:3.53332E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            r3.hideVKB()
            com.tencent.mm.ui.search.a r0 = r3.ubO
            if (r0 != 0) goto L_0x0013
            java.lang.String r1 = "searchView"
            kotlin.g.b.p.btv(r1)
        L_0x0013:
            com.tencent.mm.ui.search.FTSEditTextView r0 = r0.getFtsEditText()
            java.lang.String r1 = "searchView.ftsEditText"
            kotlin.g.b.p.g(r0, r1)
            java.lang.String r0 = r0.getTotalQuery()
            if (r0 == 0) goto L_0x003d
            if (r0 != 0) goto L_0x0031
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0031:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.n.n.trim(r0)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0040
        L_0x003d:
            java.lang.String r0 = ""
        L_0x0040:
            boolean r1 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r1 == 0) goto L_0x004b
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x004a:
            return r0
        L_0x004b:
            r3.auV(r0)
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.FinderBlockListSearchUI.awE():boolean");
    }

    private final void auV(String str) {
        AppMethodBeat.i(252147);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        Cursor d2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().d(null, str, this.vHt, "", null);
        LinkedList linkedList = new LinkedList();
        while (d2.moveToNext()) {
            as asVar = new as();
            asVar.convertFrom(d2);
            FinderContact finderContact = new FinderContact();
            finderContact.username = asVar.getUsername();
            linkedList.add(finderContact);
        }
        LinkedList<FinderContact> linkedList2 = linkedList;
        ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
        for (FinderContact finderContact2 : linkedList2) {
            arrayList.add(new p(finderContact2));
        }
        this.data.clear();
        this.data.addAll(arrayList);
        WxRecyclerAdapter<p> wxRecyclerAdapter = this.tFp;
        if (wxRecyclerAdapter != null) {
            wxRecyclerAdapter.notifyDataSetChanged();
        }
        WxRecyclerView wxRecyclerView = (WxRecyclerView) _$_findCachedViewById(R.id.ckh);
        kotlin.g.b.p.g(wxRecyclerView, "finder_block_list_search");
        wxRecyclerView.setVisibility(0);
        AppMethodBeat.o(252147);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        if (r0 == null) goto L_0x0022;
     */
    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r4, java.lang.String r5, java.util.List<com.tencent.mm.ui.search.a.c> r6, com.tencent.mm.ui.search.FTSEditTextView.b r7) {
        /*
            r3 = this;
            r2 = 252148(0x3d8f4, float:3.53335E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r4 == 0) goto L_0x0022
            if (r4 != 0) goto L_0x0016
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0016:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.CharSequence r0 = kotlin.n.n.trim(r4)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0025
        L_0x0022:
            java.lang.String r0 = ""
        L_0x0025:
            boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = ""
            r3.auV(r0)
        L_0x0031:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.FinderBlockListSearchUI.a(java.lang.String, java.lang.String, java.util.List, com.tencent.mm.ui.search.FTSEditTextView$b):void");
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void onClickClearTextBtn(View view) {
        AppMethodBeat.i(252149);
        com.tencent.mm.ui.search.a aVar = this.ubO;
        if (aVar == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar.getFtsEditText().awD();
        showVKB();
        AppMethodBeat.o(252149);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void dpw() {
    }
}
