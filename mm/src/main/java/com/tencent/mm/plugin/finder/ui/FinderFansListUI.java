package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
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
import com.tencent.mm.g.a.hq;
import com.tencent.mm.plugin.finder.cgi.bg;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.view.TouchableLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\n\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020!H\u0014J\u0018\u0010%\u001a\u00020!2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010'H\u0002J\u0012\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020!H\u0014J\u0018\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u0010,\u001a\u00020!2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020#H\u0002J,\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020#2\b\u00105\u001a\u0004\u0018\u00010\u00072\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0018\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;H\u0002J\u0012\u0010<\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010=\u001a\u00020!H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderFansListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "FIRST_PAGE_FILE_NAME", "", "TAG", "addBlackListListener", "com/tencent/mm/plugin/finder/ui/FinderFansListUI$addBlackListListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderFansListUI$addBlackListListener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "finderBottomSheet", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "firstPageData", "Lcom/tencent/mm/plugin/finder/storage/data/FansContactPage;", "hasMore", "", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FansListAdapter;", "listView", "Landroid/widget/ListView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "doGetFansScene", "", "getLayoutId", "", "initView", "merge", "contacts", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "fansId", "retCode", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showPopupMenu", "fansContact", "anchor", "Landroid/view/View;", "updateListAfterOp", "updateTitle", "plugin-finder_release"})
public final class FinderFansListUI extends MMFinderUI implements com.tencent.mm.ak.i, ai<ayt> {
    private final String TAG = "Finder.FinderFansListUI";
    private HashMap _$_findViewCache;
    private TextView hRM;
    private boolean hasMore;
    private ListView krb;
    private com.tencent.mm.ui.widget.b.a pqr;
    private com.tencent.mm.bw.b tsO;
    private final String uWR = "fansList.fp";
    private final ArrayList<aqr> uae = new ArrayList<>();
    private final a vHn = new a(this);
    private final com.tencent.mm.plugin.finder.storage.data.b vJN = new com.tencent.mm.plugin.finder.storage.data.b(this.uWR);
    private final a vJO = new a(this);
    private com.tencent.mm.plugin.finder.view.d vJo;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252323);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252323);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252322);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252322);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.m<View, Integer, x> {
        final /* synthetic */ FinderFansListUI vJP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderFansListUI finderFansListUI) {
            super(2);
            this.vJP = finderFansListUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(View view, Integer num) {
            AppMethodBeat.i(167241);
            int intValue = num.intValue();
            p.h(view, "view");
            this.vJP.vJo = b.a(this.vJP.vHn.IR(intValue), this.vJP, new kotlin.g.a.b<String, x>(this) {
                /* class com.tencent.mm.plugin.finder.ui.FinderFansListUI.d.AnonymousClass1 */
                final /* synthetic */ d vJQ;

                {
                    this.vJQ = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(String str) {
                    AppMethodBeat.i(252314);
                    String str2 = str;
                    com.tencent.mm.plugin.finder.view.d dVar = this.vJQ.vJP.vJo;
                    if (dVar != null) {
                        dVar.bMo();
                    }
                    b.dzu().d(str2, this.vJQ.vJP, this.vJQ.vJP);
                    x xVar = x.SXb;
                    AppMethodBeat.o(252314);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(167241);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.m<View, Integer, x> {
        final /* synthetic */ FinderFansListUI vJP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderFansListUI finderFansListUI) {
            super(2);
            this.vJP = finderFansListUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(View view, Integer num) {
            AppMethodBeat.i(252315);
            View view2 = view;
            int intValue = num.intValue();
            p.h(view2, "view");
            if (!this.vJP.vHn.IR(intValue).dJM) {
                FinderFansListUI.a(this.vJP, this.vJP.vHn.IR(intValue), view2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252315);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "invoke"})
    static final class g extends q implements kotlin.g.a.b<LinkedList<aqr>, Object> {
        final /* synthetic */ FinderFansListUI vJP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderFansListUI finderFansListUI) {
            super(1);
            this.vJP = finderFansListUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Object invoke(LinkedList<aqr> linkedList) {
            AppMethodBeat.i(167243);
            LinkedList<aqr> linkedList2 = linkedList;
            com.tencent.mm.bw.b bVar = this.vJP.tsO;
            if (bVar == null) {
                if (linkedList2 != null) {
                    if (this.vJP.uae.isEmpty()) {
                        this.vJP.uae.addAll(linkedList2);
                        this.vJP.vHn.ev(this.vJP.uae);
                        this.vJP.vHn.notifyDataSetChanged();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(167243);
                    return xVar;
                }
                bVar = null;
            }
            AppMethodBeat.o(167243);
            return bVar;
        }
    }

    public FinderFansListUI() {
        AppMethodBeat.i(167257);
        AppMethodBeat.o(167257);
    }

    public static final /* synthetic */ void a(FinderFansListUI finderFansListUI, String str, int i2) {
        AppMethodBeat.i(252321);
        finderFansListUI.dJ(str, i2);
        AppMethodBeat.o(252321);
    }

    public static final /* synthetic */ void f(FinderFansListUI finderFansListUI) {
        AppMethodBeat.i(167258);
        finderFansListUI.dea();
        AppMethodBeat.o(167258);
    }

    public static final /* synthetic */ ListView g(FinderFansListUI finderFansListUI) {
        AppMethodBeat.i(167259);
        ListView listView = finderFansListUI.krb;
        if (listView == null) {
            p.btv("listView");
        }
        AppMethodBeat.o(167259);
        return listView;
    }

    public static final /* synthetic */ void j(FinderFansListUI finderFansListUI) {
        AppMethodBeat.i(167261);
        finderFansListUI.updateTitle();
        AppMethodBeat.o(167261);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
    @Override // com.tencent.mm.plugin.i.a.ai
    public final /* synthetic */ void a(ayt ayt, apg apg) {
        AppMethodBeat.i(167253);
        ayt ayt2 = ayt;
        p.h(ayt2, "req");
        p.h(apg, "ret");
        String str = ayt2.dMj;
        if (str == null) {
            str = "";
        }
        dJ(str, apg.retCode);
        AppMethodBeat.o(167253);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167250);
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.azz().a(3531, this);
        initView();
        com.tencent.mm.ac.d.b(com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), new f(this)), new g(this));
        dea();
        EventCenter.instance.addListener(this.vJO);
        AppMethodBeat.o(167250);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(167251);
        View findViewById = findViewById(R.id.bcd);
        p.g(findViewById, "findViewById<ListView>(R.id.contact_list)");
        this.krb = (ListView) findViewById;
        View findViewById2 = findViewById(R.id.c35);
        p.g(findViewById2, "findViewById<TextView>(R.id.empty_tip)");
        this.hRM = (TextView) findViewById2;
        updateTitle();
        setBackBtn(new b(this));
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
        listView2.setSelector(new ColorDrawable(0));
        ListView listView3 = this.krb;
        if (listView3 == null) {
            p.btv("listView");
        }
        listView3.setOnScrollListener(new c(this));
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dtG().value().intValue() > 0) {
            this.vHn.uAj = new d(this);
        }
        this.vHn.uAi = new e(this);
        AppMethodBeat.o(167251);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderFansListUI vJP;

        b(FinderFansListUI finderFansListUI) {
            this.vJP = finderFansListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167239);
            this.vJP.finish();
            AppMethodBeat.o(167239);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderFansListUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
    public static final class c implements AbsListView.OnScrollListener {
        final /* synthetic */ FinderFansListUI vJP;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderFansListUI finderFansListUI) {
            this.vJP = finderFansListUI;
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(167240);
            if (i2 == 0 && absListView != null && !absListView.canScrollVertically(1)) {
                if (this.vJP.hasMore) {
                    FinderFansListUI.f(this.vJP);
                    AppMethodBeat.o(167240);
                    return;
                } else if (FinderFansListUI.g(this.vJP).getFooterViewsCount() == 0) {
                    FinderFansListUI.g(this.vJP).addFooterView(View.inflate(this.vJP, R.layout.a_n, null));
                }
            }
            AppMethodBeat.o(167240);
        }
    }

    private final void updateTitle() {
        AppMethodBeat.i(167252);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_FANS_COUNT_INT_SYNC, 0);
        Log.i(this.TAG, "update title %s", Integer.valueOf(i2));
        setMMTitle(getString(R.string.d2r, new Object[]{Integer.valueOf(i2)}));
        if (i2 == 0) {
            TextView textView = this.hRM;
            if (textView == null) {
                p.btv("emptyTip");
            }
            textView.setVisibility(0);
            TextView textView2 = this.hRM;
            if (textView2 == null) {
                p.btv("emptyTip");
            }
            textView2.setText(getString(R.string.cmb));
            AppMethodBeat.o(167252);
            return;
        }
        TextView textView3 = this.hRM;
        if (textView3 == null) {
            p.btv("emptyTip");
        }
        textView3.setVisibility(8);
        addIconOptionMenu(0, R.raw.icons_outlined_search, new n(this));
        AppMethodBeat.o(167252);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class n implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderFansListUI vJP;

        n(FinderFansListUI finderFansListUI) {
            this.vJP = finderFansListUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(252318);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.ai(this.vJP, new Intent());
            AppMethodBeat.o(252318);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
    public static final class k implements View.OnCreateContextMenuListener {
        final /* synthetic */ FinderFansListUI vJP;

        k(FinderFansListUI finderFansListUI) {
            this.vJP = finderFansListUI;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(167247);
            contextMenu.add(0, 1001, 0, this.vJP.getString(R.string.cl8));
            AppMethodBeat.o(167247);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class l implements o.g {
        final /* synthetic */ aqr vHs;
        final /* synthetic */ FinderFansListUI vJP;

        l(FinderFansListUI finderFansListUI, aqr aqr) {
            this.vJP = finderFansListUI;
            this.vHs = aqr;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(167249);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 1001:
                    String str = this.vHs.dMj;
                    if (str != null) {
                        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                        Context context = MMApplicationContext.getContext();
                        p.g(context, "MMApplicationContext.getContext()");
                        com.tencent.mm.plugin.finder.report.k.b(context, 8, 3);
                        p.g(str, LocaleUtil.ITALIAN);
                        ((com.tencent.mm.plugin.i.a.o) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.o.class)).a(str, new a(this));
                        AppMethodBeat.o(167249);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(167249);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderFansListUI$showPopupMenu$2$1$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderRemoveFansSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
        public static final class a implements ai<bbm> {
            final /* synthetic */ l vJS;

            a(l lVar) {
                this.vJS = lVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
            @Override // com.tencent.mm.plugin.i.a.ai
            public final /* synthetic */ void a(bbm bbm, apg apg) {
                String str;
                AppMethodBeat.i(252316);
                bbm bbm2 = bbm;
                p.h(bbm2, "req");
                p.h(apg, "ret");
                if (apg.retCode != 0 || (str = bbm2.LKT) == null) {
                    AppMethodBeat.o(252316);
                    return;
                }
                FinderFansListUI.a(this.vJS.vJP, str);
                AppMethodBeat.o(252316);
            }
        }
    }

    private final void dJ(String str, int i2) {
        AppMethodBeat.i(252319);
        com.tencent.mm.ac.d.h(new h(this, i2, str));
        AppMethodBeat.o(252319);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderFansListUI$addBlackListListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderAddUserToBlackListEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class a extends IListener<hq> {
        final /* synthetic */ FinderFansListUI vJP;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(FinderFansListUI finderFansListUI) {
            this.vJP = finderFansListUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hq hqVar) {
            hq.a aVar;
            AppMethodBeat.i(252313);
            hq hqVar2 = hqVar;
            if (!(hqVar2 == null || (aVar = hqVar2.dMi) == null)) {
                FinderFansListUI finderFansListUI = this.vJP;
                String str = aVar.dMj;
                p.g(str, "fansId");
                FinderFansListUI.a(finderFansListUI, str, aVar.retCode);
            }
            AppMethodBeat.o(252313);
            return true;
        }
    }

    private final void dea() {
        AppMethodBeat.i(167254);
        com.tencent.mm.kernel.g.azz().b(new bg(this.tsO));
        AppMethodBeat.o(167254);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(167255);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(3531, this);
        EventCenter.instance.removeListener(this.vJO);
        AppMethodBeat.o(167255);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a_5;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(167256);
        Log.i(this.TAG, "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            if (qVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFansList");
                AppMethodBeat.o(167256);
                throw tVar;
            }
            if (!p.j(this.tsO, ((bg) qVar).cYn())) {
                Log.i(this.TAG, "not my buf, ignore!");
                AppMethodBeat.o(167256);
                return;
            }
            this.hasMore = ((bg) qVar).cYp();
            if (this.tsO == null) {
                this.uae.clear();
                com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), new i(this, qVar));
            }
            this.tsO = ((bg) qVar).cYm();
            com.tencent.mm.ac.d.h(new j(this, qVar));
        }
        AppMethodBeat.o(167256);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
    static final class f extends q implements kotlin.g.a.b<Void, LinkedList<aqr>> {
        final /* synthetic */ FinderFansListUI vJP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderFansListUI finderFansListUI) {
            super(1);
            this.vJP = finderFansListUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ LinkedList<aqr> invoke(Void r3) {
            AppMethodBeat.i(167242);
            LinkedList blq = this.vJP.vJN.blq();
            AppMethodBeat.o(167242);
            return blq;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderFansListUI vJP;
        final /* synthetic */ int vJR;
        final /* synthetic */ String vvZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(FinderFansListUI finderFansListUI, int i2, String str) {
            super(0);
            this.vJP = finderFansListUI;
            this.vJR = i2;
            this.vvZ = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            Object obj;
            AppMethodBeat.i(167244);
            if (this.vJR == 0) {
                Iterator it = this.vJP.uae.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it.next();
                    if (kotlin.n.n.I(((aqr) next).dMj, this.vvZ, false)) {
                        obj = next;
                        break;
                    }
                }
                aqr aqr = (aqr) obj;
                if (aqr != null) {
                    FinderFansListUI.a(this.vJP, aqr.dMj);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167244);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class m extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderFansListUI vJP;
        final /* synthetic */ String vvZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(FinderFansListUI finderFansListUI, String str) {
            super(0);
            this.vJP = finderFansListUI;
            this.vvZ = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            Object obj;
            AppMethodBeat.i(252317);
            Iterator it = this.vJP.uae.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (kotlin.n.n.I(((aqr) next).dMj, this.vvZ, false)) {
                    obj = next;
                    break;
                }
            }
            aqr aqr = (aqr) obj;
            if (aqr != null) {
                this.vJP.uae.remove(aqr);
                this.vJP.vHn.ev(this.vJP.uae);
                this.vJP.vHn.notifyDataSetChanged();
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                p.g(aAh, "MMKernel.storage()");
                int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_FANS_COUNT_INT_SYNC, 0);
                Log.i(this.vJP.TAG, "oldFansCnt %d", Integer.valueOf(i2));
                if (i2 > 0) {
                    com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                    p.g(aAh2, "MMKernel.storage()");
                    aAh2.azQ().set(ar.a.USERINFO_FINDER_FANS_COUNT_INT_SYNC, Integer.valueOf(i2 - 1));
                }
                FinderFansListUI.j(this.vJP);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252317);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke", "(Ljava/lang/Void;)Lkotlin/Unit;", "com/tencent/mm/plugin/finder/ui/FinderFansListUI$onSceneEnd$1$1"})
    static final class i extends q implements kotlin.g.a.b<Void, x> {
        final /* synthetic */ com.tencent.mm.ak.q uWG;
        final /* synthetic */ FinderFansListUI vJP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderFansListUI finderFansListUI, com.tencent.mm.ak.q qVar) {
            super(1);
            this.vJP = finderFansListUI;
            this.uWG = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Void r4) {
            AppMethodBeat.i(167245);
            LinkedList<aqr> cYo = ((bg) this.uWG).cYo();
            if (cYo != null) {
                this.vJP.vJN.blr();
                this.vJP.vJN.r(cYo);
                x xVar = x.SXb;
                AppMethodBeat.o(167245);
                return xVar;
            }
            AppMethodBeat.o(167245);
            return null;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.ak.q hvN;
        final /* synthetic */ FinderFansListUI vJP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderFansListUI finderFansListUI, com.tencent.mm.ak.q qVar) {
            super(0);
            this.vJP = finderFansListUI;
            this.hvN = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(167246);
            FinderFansListUI.a(this.vJP, ((bg) this.hvN).cYo());
            x xVar = x.SXb;
            AppMethodBeat.o(167246);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(FinderFansListUI finderFansListUI, aqr aqr, View view) {
        AppMethodBeat.i(167260);
        com.tencent.mm.ui.widget.b.a aVar = finderFansListUI.pqr;
        if (aVar == null) {
            p.btv("popupMenu");
        }
        aVar.gNq();
        com.tencent.mm.ui.widget.b.a aVar2 = finderFansListUI.pqr;
        if (aVar2 == null) {
            p.btv("popupMenu");
        }
        TouchableLayout.a aVar3 = TouchableLayout.Rni;
        int i2 = TouchableLayout.kuv;
        TouchableLayout.a aVar4 = TouchableLayout.Rni;
        aVar2.a(view, new k(finderFansListUI), new l(finderFansListUI, aqr), i2, TouchableLayout.kuw);
        AppMethodBeat.o(167260);
    }

    public static final /* synthetic */ void a(FinderFansListUI finderFansListUI, String str) {
        AppMethodBeat.i(252320);
        com.tencent.mm.ac.d.h(new m(finderFansListUI, str));
        AppMethodBeat.o(252320);
    }

    public static final /* synthetic */ void a(FinderFansListUI finderFansListUI, List list) {
        AppMethodBeat.i(167262);
        Log.i(finderFansListUI.TAG, "fans contact " + (list != null ? Integer.valueOf(list.size()) : null));
        if (list != null) {
            finderFansListUI.uae.addAll(list);
            finderFansListUI.vHn.ev(finderFansListUI.uae);
            finderFansListUI.vHn.notifyDataSetChanged();
        }
        AppMethodBeat.o(167262);
    }
}
