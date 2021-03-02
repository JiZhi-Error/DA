package com.tencent.mm.plugin.finder.ui;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.finder.cgi.be;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.view.TouchableLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\u001bH\u0014J\u0018\u0010\u001e\u001a\u00020\u001b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010 H\u0002J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0014J\u0018\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(H\u0016J,\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010\t2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0018\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u001bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderBlackListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "MENU_ID_UNSET_BLACK_LIST", "", "TAG", "", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetBlackListScene", "", "getLayoutId", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showPopupMenu", "fansContact", "anchor", "Landroid/view/View;", "update", "plugin-finder_release"})
public final class FinderBlackListUI extends MMFinderUI implements i, ai<ayt> {
    private final String TAG = "Finder.FinderBlackListUI";
    private HashMap _$_findViewCache;
    private TextView hRM;
    private boolean hasMore;
    private ListView krb;
    private com.tencent.mm.ui.widget.b.a pqr;
    private com.tencent.mm.bw.b tsO;
    private final ArrayList<aqr> uae = new ArrayList<>();
    private final a vHn = new a(this);
    private final int vHo = 1001;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252135);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252135);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252134);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252134);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
    public static final class c extends q implements m<View, Integer, x> {
        final /* synthetic */ FinderBlackListUI vHp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderBlackListUI finderBlackListUI) {
            super(2);
            this.vHp = finderBlackListUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(View view, Integer num) {
            AppMethodBeat.i(167142);
            View view2 = view;
            int intValue = num.intValue();
            p.h(view2, "view");
            FinderBlackListUI.a(this.vHp, this.vHp.vHn.IR(intValue), view2);
            x xVar = x.SXb;
            AppMethodBeat.o(167142);
            return xVar;
        }
    }

    public FinderBlackListUI() {
        AppMethodBeat.i(167154);
        AppMethodBeat.o(167154);
    }

    public static final /* synthetic */ void b(FinderBlackListUI finderBlackListUI) {
        AppMethodBeat.i(167155);
        finderBlackListUI.dyU();
        AppMethodBeat.o(167155);
    }

    public static final /* synthetic */ ListView c(FinderBlackListUI finderBlackListUI) {
        AppMethodBeat.i(167156);
        ListView listView = finderBlackListUI.krb;
        if (listView == null) {
            p.btv("listView");
        }
        AppMethodBeat.o(167156);
        return listView;
    }

    public static final /* synthetic */ void g(FinderBlackListUI finderBlackListUI) {
        AppMethodBeat.i(167158);
        finderBlackListUI.update();
        AppMethodBeat.o(167158);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
    @Override // com.tencent.mm.plugin.i.a.ai
    public final /* synthetic */ void a(ayt ayt, apg apg) {
        AppMethodBeat.i(167150);
        ayt ayt2 = ayt;
        p.h(ayt2, "req");
        p.h(apg, "ret");
        com.tencent.mm.ac.d.h(new d(this, apg, ayt2));
        AppMethodBeat.o(167150);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167147);
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.azz().a(3717, this);
        initView();
        dyU();
        AppMethodBeat.o(167147);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(167148);
        setMMTitle(getString(R.string.d2q));
        View findViewById = findViewById(R.id.bcd);
        p.g(findViewById, "findViewById<ListView>(R.id.contact_list)");
        this.krb = (ListView) findViewById;
        View findViewById2 = findViewById(R.id.c35);
        p.g(findViewById2, "findViewById<TextView>(R.id.empty_tip)");
        this.hRM = (TextView) findViewById2;
        setBackBtn(new a(this));
        this.pqr = new com.tencent.mm.ui.widget.b.a(this);
        ListView listView = this.krb;
        if (listView == null) {
            p.btv("listView");
        }
        listView.setAdapter((ListAdapter) this.vHn);
        ListView listView2 = this.krb;
        if (listView2 == null) {
            p.btv("listView");
        }
        listView2.setOnScrollListener(new b(this));
        this.vHn.uAi = new c(this);
        update();
        AppMethodBeat.o(167148);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderBlackListUI vHp;

        a(FinderBlackListUI finderBlackListUI) {
            this.vHp = finderBlackListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167140);
            this.vHp.finish();
            AppMethodBeat.o(167140);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderBlackListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
    public static final class b implements AbsListView.OnScrollListener {
        final /* synthetic */ FinderBlackListUI vHp;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderBlackListUI finderBlackListUI) {
            this.vHp = finderBlackListUI;
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(167141);
            if (i2 == 0 && absListView != null && !absListView.canScrollVertically(1)) {
                if (this.vHp.hasMore) {
                    FinderBlackListUI.b(this.vHp);
                    AppMethodBeat.o(167141);
                    return;
                } else if (FinderBlackListUI.c(this.vHp).getFooterViewsCount() == 0) {
                    FinderBlackListUI.c(this.vHp).addFooterView(View.inflate(this.vHp, R.layout.ag7, null));
                }
            }
            AppMethodBeat.o(167141);
        }
    }

    private final void update() {
        AppMethodBeat.i(167149);
        if (this.uae.isEmpty()) {
            TextView textView = this.hRM;
            if (textView == null) {
                p.btv("emptyTip");
            }
            textView.setVisibility(0);
            TextView textView2 = this.hRM;
            if (textView2 == null) {
                p.btv("emptyTip");
            }
            textView2.setText(getString(R.string.cig));
            AppMethodBeat.o(167149);
            return;
        }
        TextView textView3 = this.hRM;
        if (textView3 == null) {
            p.btv("emptyTip");
        }
        textView3.setVisibility(8);
        AppMethodBeat.o(167149);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
    public static final class f implements View.OnCreateContextMenuListener {
        final /* synthetic */ FinderBlackListUI vHp;

        f(FinderBlackListUI finderBlackListUI) {
            this.vHp = finderBlackListUI;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(167145);
            contextMenu.add(0, this.vHp.vHo, 0, this.vHp.getString(R.string.bda));
            AppMethodBeat.o(167145);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class g implements o.g {
        final /* synthetic */ FinderBlackListUI vHp;
        final /* synthetic */ aqr vHs;

        g(FinderBlackListUI finderBlackListUI, aqr aqr) {
            this.vHp = finderBlackListUI;
            this.vHs = aqr;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            String str;
            AppMethodBeat.i(167146);
            p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == this.vHp.vHo) {
                t tVar = (t) com.tencent.mm.kernel.g.af(t.class);
                String str2 = this.vHs.dMj;
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                tVar.b(str, false, this.vHp);
            }
            AppMethodBeat.o(167146);
        }
    }

    private final void dyU() {
        AppMethodBeat.i(167151);
        com.tencent.mm.kernel.g.azz().b(new be(this.tsO));
        AppMethodBeat.o(167151);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(167152);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(3717, this);
        AppMethodBeat.o(167152);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a_5;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        AppMethodBeat.i(167153);
        Log.i(this.TAG, "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            if (qVar == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetBlackList");
                AppMethodBeat.o(167153);
                throw tVar;
            }
            com.tencent.mm.bw.a aYK = ((be) qVar).rr.aYK();
            if (aYK == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
                AppMethodBeat.o(167153);
                throw tVar2;
            }
            if (((aro) aYK).continueFlag != 0) {
                z = true;
            } else {
                z = false;
            }
            this.hasMore = z;
            com.tencent.mm.bw.a aYK2 = ((be) qVar).rr.aYK();
            if (aYK2 == null) {
                kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
                AppMethodBeat.o(167153);
                throw tVar3;
            }
            this.tsO = ((aro) aYK2).tVM;
            com.tencent.mm.ac.d.h(new e(this, qVar));
        }
        AppMethodBeat.o(167153);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderBlackListUI vHp;
        final /* synthetic */ apg vHq;
        final /* synthetic */ ayt vHr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderBlackListUI finderBlackListUI, apg apg, ayt ayt) {
            super(0);
            this.vHp = finderBlackListUI;
            this.vHq = apg;
            this.vHr = ayt;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            Object obj;
            AppMethodBeat.i(167143);
            if (this.vHq.retCode == 0) {
                Iterator it = this.vHp.uae.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it.next();
                    if (n.I(((aqr) next).dMj, this.vHr.dMj, false)) {
                        obj = next;
                        break;
                    }
                }
                aqr aqr = (aqr) obj;
                if (aqr != null) {
                    this.vHp.uae.remove(aqr);
                    this.vHp.vHn.ev(this.vHp.uae);
                    this.vHp.vHn.notifyDataSetChanged();
                    FinderBlackListUI.g(this.vHp);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167143);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.ak.q hvN;
        final /* synthetic */ FinderBlackListUI vHp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderBlackListUI finderBlackListUI, com.tencent.mm.ak.q qVar) {
            super(0);
            this.vHp = finderBlackListUI;
            this.hvN = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(167144);
            FinderBlackListUI finderBlackListUI = this.vHp;
            com.tencent.mm.bw.a aYK = ((be) this.hvN).rr.aYK();
            if (aYK == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetBlackListResponse");
                AppMethodBeat.o(167144);
                throw tVar;
            }
            FinderBlackListUI.a(finderBlackListUI, ((aro) aYK).LCI);
            x xVar = x.SXb;
            AppMethodBeat.o(167144);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(FinderBlackListUI finderBlackListUI, aqr aqr, View view) {
        AppMethodBeat.i(167157);
        com.tencent.mm.ui.widget.b.a aVar = finderBlackListUI.pqr;
        if (aVar == null) {
            p.btv("popupMenu");
        }
        aVar.gNq();
        com.tencent.mm.ui.widget.b.a aVar2 = finderBlackListUI.pqr;
        if (aVar2 == null) {
            p.btv("popupMenu");
        }
        TouchableLayout.a aVar3 = TouchableLayout.Rni;
        int i2 = TouchableLayout.kuv;
        TouchableLayout.a aVar4 = TouchableLayout.Rni;
        aVar2.a(view, new f(finderBlackListUI), new g(finderBlackListUI, aqr), i2, TouchableLayout.kuw);
        AppMethodBeat.o(167157);
    }

    public static final /* synthetic */ void a(FinderBlackListUI finderBlackListUI, List list) {
        AppMethodBeat.i(167159);
        Log.i(finderBlackListUI.TAG, "black contact " + (list != null ? Integer.valueOf(list.size()) : null));
        if (list != null) {
            finderBlackListUI.uae.addAll(list);
            finderBlackListUI.update();
            finderBlackListUI.vHn.ev(finderBlackListUI.uae);
            finderBlackListUI.vHn.notifyDataSetChanged();
        }
        AppMethodBeat.o(167159);
    }
}
