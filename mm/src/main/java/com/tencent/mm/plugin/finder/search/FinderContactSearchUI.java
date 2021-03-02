package com.tencent.mm.plugin.finder.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.report.l;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;

public final class FinderContactSearchUI extends MMFinderUI implements com.tencent.mm.ak.i, FTSEditTextView.a, a.b {
    final String TAG = "Finder.FinderContactSearchUI";
    private HashMap _$_findViewCache;
    private int continueFlag;
    String dPI = "";
    private View hSw;
    private RecyclerView hak;
    private int jKy;
    private int offset;
    String query = "";
    private int requestType;
    private final com.tencent.mm.plugin.finder.event.base.c tId = new com.tencent.mm.plugin.finder.event.base.c();
    private RefreshLoadMoreLayout tLS;
    private com.tencent.mm.bw.b tVM;
    boolean twi;
    private ArrayList<bbz> uae = new ArrayList<>();
    private com.tencent.mm.ui.search.a ubO;
    private boolean vtF = true;
    boolean vtG;
    private HashMap<String, a> vtH = new HashMap<>();
    private TextView vtJ;
    private h vtK;
    private cf vtL;
    private final c vtR = new c(this);
    private final g vtS = new g();

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(251264);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(251264);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(251263);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(251263);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static final class f extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderContactSearchUI vtT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderContactSearchUI finderContactSearchUI) {
            super(1);
            this.vtT = finderContactSearchUI;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(166729);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            FinderContactSearchUI.b(this.vtT).getFtsEditText().O(str2, null);
            this.vtT.twi = true;
            FinderContactSearchUI.a(this.vtT, str2);
            x xVar = x.SXb;
            AppMethodBeat.o(166729);
            return xVar;
        }
    }

    public FinderContactSearchUI() {
        AppMethodBeat.i(166742);
        AppMethodBeat.o(166742);
    }

    public static final /* synthetic */ void a(FinderContactSearchUI finderContactSearchUI, String str) {
        AppMethodBeat.i(166744);
        finderContactSearchUI.auV(str);
        AppMethodBeat.o(166744);
    }

    public static final /* synthetic */ com.tencent.mm.ui.search.a b(FinderContactSearchUI finderContactSearchUI) {
        AppMethodBeat.i(166743);
        com.tencent.mm.ui.search.a aVar = finderContactSearchUI.ubO;
        if (aVar == null) {
            p.btv("searchView");
        }
        AppMethodBeat.o(166743);
        return aVar;
    }

    public static final /* synthetic */ RefreshLoadMoreLayout l(FinderContactSearchUI finderContactSearchUI) {
        AppMethodBeat.i(166745);
        RefreshLoadMoreLayout refreshLoadMoreLayout = finderContactSearchUI.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        AppMethodBeat.o(166745);
        return refreshLoadMoreLayout;
    }

    public static final /* synthetic */ RecyclerView m(FinderContactSearchUI finderContactSearchUI) {
        AppMethodBeat.i(251262);
        RecyclerView recyclerView = finderContactSearchUI.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        AppMethodBeat.o(251262);
        return recyclerView;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(166730);
        super.onCreate(bundle);
        this.ubO = new com.tencent.mm.ui.search.a(this);
        com.tencent.mm.ui.search.a aVar = this.ubO;
        if (aVar == null) {
            p.btv("searchView");
        }
        aVar.setSearchViewListener(this);
        com.tencent.mm.ui.search.a aVar2 = this.ubO;
        if (aVar2 == null) {
            p.btv("searchView");
        }
        aVar2.getFtsEditText().setHint(getString(R.string.yn));
        com.tencent.mm.ui.search.a aVar3 = this.ubO;
        if (aVar3 == null) {
            p.btv("searchView");
        }
        aVar3.getFtsEditText().setFtsEditTextListener(this);
        com.tencent.mm.ui.search.a aVar4 = this.ubO;
        if (aVar4 == null) {
            p.btv("searchView");
        }
        aVar4.getFtsEditText().setCanDeleteTag(false);
        com.tencent.mm.ui.search.a aVar5 = this.ubO;
        if (aVar5 == null) {
            p.btv("searchView");
        }
        aVar5.getFtsEditText().gWY();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            p.hyc();
        }
        p.g(supportActionBar, "supportActionBar!!");
        com.tencent.mm.ui.search.a aVar6 = this.ubO;
        if (aVar6 == null) {
            p.btv("searchView");
        }
        supportActionBar.setCustomView(aVar6);
        this.requestType = getIntent().getIntExtra("request_type", 2);
        this.vtG = getIntent().getBooleanExtra("from_at_contact", false);
        this.vtF = getIntent().getBooleanExtra("need_history", true);
        i iVar = i.vvu;
        if (i.dqa() != null) {
            i iVar2 = i.vvu;
            aqw dqa = i.dqa();
            if (dqa == null) {
                p.hyc();
            }
            i iVar3 = i.vvu;
            i.a(null);
            String str = dqa.dPI;
            if (str == null) {
                str = "";
            }
            this.dPI = str;
            String str2 = dqa.query;
            if (str2 == null) {
                str2 = "";
            }
            this.query = str2;
            this.offset = dqa.offset;
            this.continueFlag = dqa.continueFlag;
            this.tVM = dqa.tVM;
            this.jKy = dqa.LCH;
            LinkedList<bbz> linkedList = dqa.LCI;
            p.g(linkedList, "finderFeedObj.contactList");
            LinkedList<bbz> linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
            Iterator<T> it = linkedList2.iterator();
            while (it.hasNext()) {
                arrayList.add(Boolean.valueOf(this.uae.add(it.next())));
            }
        } else {
            String uuid = UUID.randomUUID().toString();
            p.g(uuid, "UUID.randomUUID().toString()");
            this.dPI = uuid;
            this.query = "";
            com.tencent.mm.ui.search.a aVar7 = this.ubO;
            if (aVar7 == null) {
                p.btv("searchView");
            }
            aVar7.getFtsEditText().awD();
            com.tencent.mm.ui.search.a aVar8 = this.ubO;
            if (aVar8 == null) {
                p.btv("searchView");
            }
            aVar8.getFtsEditText().awC();
        }
        if (this.vtF) {
            this.vtK = new h(this, new f(this));
        } else {
            View findViewById = findViewById(R.id.dpq);
            p.g(findViewById, "findViewById<View>(R.id.history_lv)");
            findViewById.setVisibility(8);
        }
        if (this.vtG) {
            setResult(0, getIntent());
        }
        Log.i(this.TAG, "fromAtContact:%s", Boolean.valueOf(this.vtG));
        View findViewById2 = getContext().findViewById(R.id.h7t);
        p.g(findViewById2, "context.findViewById(R.id.rl_layout)");
        this.tLS = (RefreshLoadMoreLayout) findViewById2;
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        this.hak = refreshLoadMoreLayout.getRecyclerView();
        View findViewById3 = getContext().findViewById(R.id.g01);
        p.g(findViewById3, "context.findViewById(R.id.no_result_tv)");
        this.vtJ = (TextView) findViewById3;
        View findViewById4 = getContext().findViewById(R.id.epl);
        p.g(findViewById4, "context.findViewById(R.id.loading_layout)");
        this.hSw = findViewById4;
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
        recyclerView2.setAdapter(new a());
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
        recyclerView5.setOnTouchListener(new d(this));
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
        refreshLoadMoreLayout4.setActionCallback(new e(this));
        String str3 = this.query;
        if (str3 != null) {
            com.tencent.mm.ui.search.a aVar9 = this.ubO;
            if (aVar9 == null) {
                p.btv("searchView");
            }
            aVar9.getFtsEditText().O(str3, null);
        }
        RecyclerView recyclerView6 = this.hak;
        if (recyclerView6 == null) {
            p.btv("recyclerView");
        }
        RecyclerView.a adapter = recyclerView6.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        RecyclerView recyclerView7 = this.hak;
        if (recyclerView7 == null) {
            p.btv("recyclerView");
        }
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.jKy, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView7, a2.axQ(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView7.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView7, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
        this.tId.a(new b());
        this.vtR.alive();
        RecyclerView recyclerView8 = this.hak;
        if (recyclerView8 == null) {
            p.btv("recyclerView");
        }
        recyclerView8.a(this.vtS);
        AppMethodBeat.o(166730);
    }

    static final class d implements View.OnTouchListener {
        final /* synthetic */ FinderContactSearchUI vtT;

        d(FinderContactSearchUI finderContactSearchUI) {
            this.vtT = finderContactSearchUI;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(166727);
            FinderContactSearchUI.b(this.vtT).getFtsEditText().gUA();
            this.vtT.hideVKB();
            AppMethodBeat.o(166727);
            return false;
        }
    }

    public static final class e extends RefreshLoadMoreLayout.a {
        final /* synthetic */ FinderContactSearchUI vtT;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(251250);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(251250);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(251252);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(251252);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(251251);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(251251);
        }

        e(FinderContactSearchUI finderContactSearchUI) {
            this.vtT = finderContactSearchUI;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            View findViewById;
            TextView textView;
            TextView textView2;
            View findViewById2;
            TextView textView3;
            TextView textView4;
            AppMethodBeat.i(166728);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            Log.i(this.vtT.TAG, "onLoadMoreBegin");
            String str = this.vtT.query;
            if (str != null) {
                if (this.vtT.continueFlag == 1) {
                    this.vtT.vtL = new cf(str, this.vtT.offset, this.vtT.dPI, this.vtT.tVM, this.vtT.requestType, (bbn) null, 96);
                    com.tencent.mm.kernel.g.azz().b(this.vtT.vtL);
                    com.tencent.mm.kernel.g.azz().a(3820, this.vtT);
                    View loadMoreFooter = FinderContactSearchUI.l(this.vtT).getLoadMoreFooter();
                    if (!(loadMoreFooter == null || (textView4 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                        textView4.setText(R.string.d0l);
                    }
                    View loadMoreFooter2 = FinderContactSearchUI.l(this.vtT).getLoadMoreFooter();
                    if (!(loadMoreFooter2 == null || (textView3 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                        textView3.setVisibility(0);
                    }
                    View loadMoreFooter3 = FinderContactSearchUI.l(this.vtT).getLoadMoreFooter();
                    if (!(loadMoreFooter3 == null || (findViewById2 = loadMoreFooter3.findViewById(R.id.ep0)) == null)) {
                        findViewById2.setVisibility(8);
                    }
                } else {
                    View loadMoreFooter4 = FinderContactSearchUI.l(this.vtT).getLoadMoreFooter();
                    if (!(loadMoreFooter4 == null || (textView2 = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                        textView2.setText(R.string.d0m);
                    }
                    View loadMoreFooter5 = FinderContactSearchUI.l(this.vtT).getLoadMoreFooter();
                    if (!(loadMoreFooter5 == null || (textView = (TextView) loadMoreFooter5.findViewById(R.id.ep1)) == null)) {
                        textView.setVisibility(8);
                    }
                    View loadMoreFooter6 = FinderContactSearchUI.l(this.vtT).getLoadMoreFooter();
                    if (!(loadMoreFooter6 == null || (findViewById = loadMoreFooter6.findViewById(R.id.ep0)) == null)) {
                        findViewById.setVisibility(0);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(166728);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a_2;
    }

    @Override // com.tencent.mm.ui.search.a.b
    public final void onClickBackBtn(View view) {
        AppMethodBeat.i(166731);
        hideVKB();
        finish();
        AppMethodBeat.o(166731);
    }

    public final void onClickCancelBtn(View view) {
        AppMethodBeat.i(166732);
        hideVKB();
        finish();
        AppMethodBeat.o(166732);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void dpw() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        if (r0 == null) goto L_0x0024;
     */
    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r6, java.lang.String r7, java.util.List<com.tencent.mm.ui.search.a.c> r8, com.tencent.mm.ui.search.FTSEditTextView.b r9) {
        /*
            r5 = this;
            r4 = 8
            r3 = 166733(0x28b4d, float:2.33643E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            if (r6 == 0) goto L_0x0024
            if (r6 != 0) goto L_0x0018
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r0
        L_0x0018:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.CharSequence r0 = kotlin.n.n.trim(r6)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0027
        L_0x0024:
            java.lang.String r0 = ""
        L_0x0027:
            boolean r1 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r1 == 0) goto L_0x0054
            android.view.View r1 = r5.hSw
            if (r1 != 0) goto L_0x0037
            java.lang.String r2 = "loadingView"
            kotlin.g.b.p.btv(r2)
        L_0x0037:
            r1.setVisibility(r4)
            android.widget.TextView r1 = r5.vtJ
            if (r1 != 0) goto L_0x0044
            java.lang.String r2 = "noResultView"
            kotlin.g.b.p.btv(r2)
        L_0x0044:
            r1.setVisibility(r4)
            com.tencent.mm.view.RefreshLoadMoreLayout r1 = r5.tLS
            if (r1 != 0) goto L_0x0051
            java.lang.String r2 = "rlLayout"
            kotlin.g.b.p.btv(r2)
        L_0x0051:
            r1.setVisibility(r4)
        L_0x0054:
            com.tencent.mm.plugin.finder.search.h r1 = r5.vtK
            if (r1 == 0) goto L_0x005f
            r1.auW(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x005e:
            return
        L_0x005f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x005e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.FinderContactSearchUI.a(java.lang.String, java.lang.String, java.util.List, com.tencent.mm.ui.search.FTSEditTextView$b):void");
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
        AppMethodBeat.i(166734);
        if (z) {
            l lVar = l.vfB;
            l.doe();
        }
        AppMethodBeat.o(166734);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void onClickClearTextBtn(View view) {
        AppMethodBeat.i(166735);
        com.tencent.mm.ui.search.a aVar = this.ubO;
        if (aVar == null) {
            p.btv("searchView");
        }
        aVar.getFtsEditText().awD();
        showVKB();
        AppMethodBeat.o(166735);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        if (r0 == null) goto L_0x003e;
     */
    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean awE() {
        /*
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.FinderContactSearchUI.awE():boolean");
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(251258);
        super.onResume();
        k kVar = k.vkd;
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_SEARCH_MORE_CONTACT.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        AppMethodBeat.o(251258);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(251259);
        super.onPause();
        k kVar = k.vkd;
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_SEARCH_MORE_CONTACT.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        AppMethodBeat.o(251259);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(166737);
        this.vtR.dead();
        h hVar = this.vtK;
        if (hVar != null) {
            hVar.onDestroy();
        }
        this.tId.onRelease();
        com.tencent.mm.kernel.g.azz().b(3820, this);
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        recyclerView.b(this.vtS);
        super.onDestroy();
        AppMethodBeat.o(166737);
    }

    private final void auV(String str) {
        AppMethodBeat.i(166738);
        this.query = str;
        this.offset = 0;
        this.continueFlag = 0;
        this.tVM = null;
        this.uae.clear();
        String uuid = UUID.randomUUID().toString();
        p.g(uuid, "UUID.randomUUID().toString()");
        this.dPI = uuid;
        if (this.vtL != null) {
            com.tencent.mm.kernel.g.azz().a(this.vtL);
        }
        this.vtL = new cf(str, this.offset, this.dPI, this.tVM, this.requestType, (bbn) null, 96);
        com.tencent.mm.kernel.g.azz().b(this.vtL);
        com.tencent.mm.kernel.g.azz().a(3820, this);
        View view = this.hSw;
        if (view == null) {
            p.btv("loadingView");
        }
        view.setVisibility(0);
        TextView textView = this.vtJ;
        if (textView == null) {
            p.btv("noResultView");
        }
        textView.setVisibility(8);
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout.setVisibility(8);
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(166738);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        RecyclerView.a adapter;
        bcb bcb;
        AppMethodBeat.i(166739);
        com.tencent.mm.kernel.g.azz().b(3820, this);
        int size = this.uae.size();
        int size2 = this.uae.size();
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 10, 1, false);
            cf cfVar = this.vtL;
            if (cfVar != null) {
                bcb = cfVar.twl;
            } else {
                bcb = null;
            }
            if (bcb == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
                AppMethodBeat.o(166739);
                throw tVar;
            }
            LinkedList<bbz> linkedList = bcb.zns;
            p.g(linkedList, "response.infoList");
            LinkedList<bbz> linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
            Iterator<T> it = linkedList2.iterator();
            while (it.hasNext()) {
                arrayList.add(Boolean.valueOf(this.uae.add(it.next())));
            }
            this.offset = bcb.offset;
            this.continueFlag = bcb.continueFlag;
            this.tVM = bcb.tVM;
            int size3 = this.uae.size();
            Log.i(this.TAG, "onSceneEnd " + bcb.offset + ' ' + bcb.continueFlag + ' ' + this.uae.size());
            String str2 = this.query;
            boolean isEmpty = bcb.zns.isEmpty();
            int i4 = this.twi ? 2 : 1;
            int i5 = isEmpty ? 1 : 2;
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
            String dob = com.tencent.mm.plugin.finder.report.k.dob();
            String str3 = this.dPI;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            AppCompatActivity context = getContext();
            p.g(context, "context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            com.tencent.mm.plugin.finder.report.k.a(dob, str3, str2, 2, i4, 2, i5, 1, fH != null ? fH.dIx() : null);
            size2 = size3;
        } else {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 11, 1, false);
        }
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout.apT(0);
        if (size2 == 0) {
            View view = this.hSw;
            if (view == null) {
                p.btv("loadingView");
            }
            view.setVisibility(8);
            TextView textView = this.vtJ;
            if (textView == null) {
                p.btv("noResultView");
            }
            textView.setVisibility(0);
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tLS;
            if (refreshLoadMoreLayout2 == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout2.setVisibility(8);
        } else {
            View view2 = this.hSw;
            if (view2 == null) {
                p.btv("loadingView");
            }
            view2.setVisibility(8);
            TextView textView2 = this.vtJ;
            if (textView2 == null) {
                p.btv("noResultView");
            }
            textView2.setVisibility(8);
            RefreshLoadMoreLayout refreshLoadMoreLayout3 = this.tLS;
            if (refreshLoadMoreLayout3 == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout3.setVisibility(0);
        }
        if (size == 0) {
            RecyclerView recyclerView = this.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            RecyclerView.a adapter2 = recyclerView.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyDataSetChanged();
                AppMethodBeat.o(166739);
                return;
            }
            AppMethodBeat.o(166739);
            return;
        }
        if (size < size2) {
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 == null) {
                p.btv("recyclerView");
            }
            if (!(recyclerView2 == null || (adapter = recyclerView2.getAdapter()) == null)) {
                adapter.as(size, size2 - size);
                AppMethodBeat.o(166739);
                return;
            }
        }
        AppMethodBeat.o(166739);
    }

    public final class b extends com.tencent.mm.plugin.finder.event.base.d {
        public b() {
            FinderContactSearchUI.this = r1;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean cZD() {
            return true;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
            int i2;
            int i3;
            AppMethodBeat.i(166726);
            p.h(bVar, "event");
            if ((bVar instanceof com.tencent.mm.plugin.finder.event.base.h) && (i2 = ((com.tencent.mm.plugin.finder.event.base.h) bVar).tIy) <= (i3 = ((com.tencent.mm.plugin.finder.event.base.h) bVar).tIA)) {
                while (true) {
                    FinderContactSearchUI finderContactSearchUI = FinderContactSearchUI.this;
                    FinderContact finderContact = ((bbz) FinderContactSearchUI.this.uae.get(i2)).contact;
                    FinderContactSearchUI.a(finderContactSearchUI, finderContact != null ? finderContact.username : null, i2);
                    if (i2 == i3) {
                        break;
                    }
                    i2++;
                }
            }
            AppMethodBeat.o(166726);
        }
    }

    public final class a extends RecyclerView.a<RecyclerView.v> {
        public a() {
            FinderContactSearchUI.this = r1;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(166721);
            int size = FinderContactSearchUI.this.uae.size();
            AppMethodBeat.o(166721);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(166722);
            p.h(viewGroup, "parent");
            AppCompatActivity context = FinderContactSearchUI.this.getContext();
            if (context == null) {
                p.hyc();
            }
            View inflate = context.getLayoutInflater().inflate(R.layout.a_1, viewGroup, false);
            p.g(inflate, "contactLayout");
            c cVar = new c(inflate);
            AppMethodBeat.o(166722);
            return cVar;
        }

        private final void i(RecyclerView.v vVar, int i2) {
            boolean z;
            AppMethodBeat.i(166724);
            Object obj = FinderContactSearchUI.this.uae.get(i2);
            p.g(obj, "contactList[position]");
            bbz bbz = (bbz) obj;
            FinderContactSearchUI finderContactSearchUI = FinderContactSearchUI.this;
            FinderContact finderContact = bbz.contact;
            FinderContactSearchUI.a(finderContactSearchUI, finderContact != null ? finderContact.username : null, i2);
            if (vVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
                AppMethodBeat.o(166724);
                throw tVar;
            }
            c cVar = (c) vVar;
            View$OnClickListenerC1270a aVar = new View$OnClickListenerC1270a(this, i2);
            b bVar = new b(this);
            if (i2 != 0) {
                z = true;
            } else {
                z = false;
            }
            cVar.a(bbz, aVar, bVar, z);
            AppMethodBeat.o(166724);
        }

        /* renamed from: com.tencent.mm.plugin.finder.search.FinderContactSearchUI$a$a */
        public static final class View$OnClickListenerC1270a implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ a vtU;

            View$OnClickListenerC1270a(a aVar, int i2) {
                this.vtU = aVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                String str;
                String str2;
                String str3;
                String str4;
                AppMethodBeat.i(166720);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                p.g(view, LocaleUtil.ITALIAN);
                Object tag = view.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
                    AppMethodBeat.o(166720);
                    throw tVar;
                }
                bbz bbz = (bbz) tag;
                FinderContactSearchUI finderContactSearchUI = FinderContactSearchUI.this;
                int i2 = this.gUj;
                p.h(bbz, "finderSearchInfo");
                if (finderContactSearchUI.vtG) {
                    Log.i(finderContactSearchUI.TAG, "onContactItemClick select atContact");
                    com.tencent.mm.plugin.finder.utils.d dVar = com.tencent.mm.plugin.finder.utils.d.vVg;
                    FinderContact finderContact = bbz.contact;
                    if (finderContact == null) {
                        finderContact = new FinderContact();
                    }
                    finderContactSearchUI.getIntent().putExtra("at_select_contact", com.tencent.mm.plugin.finder.utils.d.e(finderContact).toByteArray());
                    finderContactSearchUI.setResult(-1, finderContactSearchUI.getIntent());
                    finderContactSearchUI.finish();
                } else {
                    FinderContact finderContact2 = bbz.contact;
                    if (finderContact2 != null && finderContact2.liveStatus == 1) {
                        k kVar = k.vkd;
                        FinderContact finderContact3 = bbz.contact;
                        if (finderContact3 == null || (str4 = finderContact3.username) == null) {
                            str4 = "";
                        }
                        kVar.a(null, str4, (long) i2, s.p.LIVE_AUDIENCE_CLICK_SINGLE_AVATAR, s.j.COMMENT_SCENE_SEARCH_MORE_CONTACT.scene);
                    }
                    Intent intent = new Intent();
                    FinderContact finderContact4 = bbz.contact;
                    if (finderContact4 == null || (str = finderContact4.username) == null) {
                        str = "";
                    }
                    intent.putExtra("finder_username", str);
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    AppCompatActivity context = finderContactSearchUI.getContext();
                    p.g(context, "context");
                    FinderReporterUIC.a.a(context, intent, 0, 7, false, 64);
                    com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    AppCompatActivity context2 = finderContactSearchUI.getContext();
                    p.g(context2, "context");
                    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context2, intent);
                    int i3 = finderContactSearchUI.twi ? 2 : 1;
                    com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                    String str5 = finderContactSearchUI.dPI;
                    String str6 = finderContactSearchUI.query;
                    FinderContact finderContact5 = bbz.contact;
                    if (finderContact5 == null || (str2 = finderContact5.username) == null) {
                        str2 = "";
                    }
                    com.tencent.mm.plugin.finder.report.k kVar3 = com.tencent.mm.plugin.finder.report.k.vfA;
                    String dob = com.tencent.mm.plugin.finder.report.k.dob();
                    FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                    AppCompatActivity context3 = finderContactSearchUI.getContext();
                    p.g(context3, "context");
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(context3);
                    com.tencent.mm.plugin.finder.report.k.a(str5, str6, 1, 1, str2, i2, 2, dob, i3, fH != null ? fH.dIx() : null);
                    com.tencent.mm.plugin.finder.report.k kVar4 = com.tencent.mm.plugin.finder.report.k.vfA;
                    String str7 = finderContactSearchUI.dPI;
                    String str8 = finderContactSearchUI.query;
                    FinderContact finderContact6 = bbz.contact;
                    if (finderContact6 == null || (str3 = finderContact6.username) == null) {
                        str3 = "";
                    }
                    com.tencent.mm.plugin.finder.report.k kVar5 = com.tencent.mm.plugin.finder.report.k.vfA;
                    String dob2 = com.tencent.mm.plugin.finder.report.k.dob();
                    FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
                    AppCompatActivity context4 = finderContactSearchUI.getContext();
                    p.g(context4, "context");
                    FinderReporterUIC fH2 = FinderReporterUIC.a.fH(context4);
                    com.tencent.mm.plugin.finder.report.k.a(str7, str8, 1, 1, str3, i2, 2, dob2, 2, i3, fH2 != null ? fH2.dIx() : null);
                    FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                    AppCompatActivity context5 = finderContactSearchUI.getContext();
                    p.g(context5, "context");
                    FinderReporterUIC fH3 = FinderReporterUIC.a.fH(context5);
                    if (fH3 != null) {
                        com.tencent.mm.plugin.finder.report.k kVar6 = com.tencent.mm.plugin.finder.report.k.vfA;
                        int i4 = fH3.tCE;
                        FinderContact finderContact7 = bbz.contact;
                        com.tencent.mm.plugin.finder.report.k.a(6, 0, i4, 1, finderContact7 != null ? finderContact7.username : null);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(166720);
            }
        }

        public static final class b implements View.OnLongClickListener {
            final /* synthetic */ a vtU;

            b(a aVar) {
                this.vtU = aVar;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(251247);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                FinderContactSearchUI finderContactSearchUI = FinderContactSearchUI.this;
                p.g(view, LocaleUtil.ITALIAN);
                finderContactSearchUI.onContactItemLongClick(view);
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(251247);
                return true;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2, List<Object> list) {
            AppMethodBeat.i(166723);
            p.h(vVar, "holder");
            p.h(list, "payloads");
            i(vVar, i2);
            AppMethodBeat.o(166723);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(166725);
            p.h(vVar, "holder");
            i(vVar, i2);
            AppMethodBeat.o(166725);
        }
    }

    public final void onContactItemLongClick(View view) {
        AppMethodBeat.i(251261);
        p.h(view, "view");
        if (this.requestType == 8) {
            com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(getContext());
            if (this.hak == null) {
                p.btv("recyclerView");
            }
            int bw = RecyclerView.bw(view);
            z.d dVar = new z.d();
            dVar.SYE = 1;
            TouchableLayout.a aVar2 = TouchableLayout.Rni;
            int i2 = TouchableLayout.kuv;
            TouchableLayout.a aVar3 = TouchableLayout.Rni;
            aVar.a(view, bw, 0, new h(dVar), new i(this, bw), i2, TouchableLayout.kuw);
            aVar.gTx();
        }
        AppMethodBeat.o(251261);
    }

    public static final class h implements View.OnCreateContextMenuListener {
        final /* synthetic */ z.d vtW;

        h(z.d dVar) {
            this.vtW = dVar;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(251255);
            if (contextMenu != null) {
                contextMenu.add(0, this.vtW.SYE, 0, R.string.d1k);
                AppMethodBeat.o(251255);
                return;
            }
            AppMethodBeat.o(251255);
        }
    }

    public static final class i implements o.g {
        final /* synthetic */ int uWy;
        final /* synthetic */ FinderContactSearchUI vtT;

        i(FinderContactSearchUI finderContactSearchUI, int i2) {
            this.vtT = finderContactSearchUI;
            this.uWy = i2;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            bbz bbz;
            FinderContact finderContact;
            AppMethodBeat.i(251257);
            if (this.uWy < 0 || this.uWy >= this.vtT.uae.size() || (bbz = (bbz) this.vtT.uae.get(this.uWy)) == null || (finderContact = bbz.contact) == null) {
                AppMethodBeat.o(251257);
                return;
            }
            com.tencent.mm.plugin.finder.storage.b bVar = new com.tencent.mm.plugin.finder.storage.b();
            p.g(finderContact, LocaleUtil.ITALIAN);
            bVar.a(finderContact, new a(this));
            AppMethodBeat.o(251257);
        }

        public static final class a implements ak.a {
            final /* synthetic */ i vtX;

            a(i iVar) {
                this.vtX = iVar;
            }

            @Override // com.tencent.mm.plugin.finder.storage.ak.a
            public final void nN(boolean z) {
                AppMethodBeat.i(251256);
                if (z) {
                    this.vtX.vtT.uae.remove(this.vtX.uWy);
                    RecyclerView.a adapter = FinderContactSearchUI.m(this.vtX.vtT).getAdapter();
                    if (adapter != null) {
                        adapter.ck(this.vtX.uWy);
                        AppMethodBeat.o(251256);
                        return;
                    }
                    AppMethodBeat.o(251256);
                    return;
                }
                u.makeText(this.vtX.vtT.getContext(), StateEvent.ProcessResult.FAILED, 0).show();
                AppMethodBeat.o(251256);
            }
        }
    }

    public static final class c extends IListener<hf> {
        final /* synthetic */ FinderContactSearchUI vtT;

        c(FinderContactSearchUI finderContactSearchUI) {
            this.vtT = finderContactSearchUI;
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hf hfVar) {
            AppMethodBeat.i(251249);
            hf hfVar2 = hfVar;
            p.h(hfVar2, "event");
            com.tencent.mm.ac.d.a(0, new a(this, hfVar2));
            AppMethodBeat.o(251249);
            return false;
        }

        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ hf tAo;
            final /* synthetic */ c vtV;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, hf hfVar) {
                super(0);
                this.vtV = cVar;
                this.tAo = hfVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                RecyclerView.a adapter;
                AppMethodBeat.i(251248);
                if (!Util.isNullOrNil(this.tAo.dLI.username)) {
                    Log.d(this.vtV.vtT.TAG, "contactChangelistener " + this.tAo.dLI.username);
                    int i2 = 0;
                    for (Object obj : this.vtV.vtT.uae) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            j.hxH();
                        }
                        String str = this.tAo.dLI.username;
                        FinderContact finderContact = ((bbz) obj).contact;
                        if (!p.j(str, finderContact != null ? finderContact.username : null) || (adapter = FinderContactSearchUI.m(this.vtV.vtT).getAdapter()) == null) {
                            i2 = i3;
                        } else {
                            adapter.ci(i2);
                            i2 = i3;
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(251248);
                return xVar;
            }
        }
    }

    public static final class g extends RecyclerView.l {
        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(251254);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(251254);
        }

        g() {
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(251253);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            k kVar = k.vkd;
            k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_SEARCH_MORE_CONTACT.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(251253);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 6;
    }

    public static /* synthetic */ void a(FinderContactSearchUI finderContactSearchUI, String str, int i2) {
        boolean z = true;
        AppMethodBeat.i(251260);
        int i3 = finderContactSearchUI.twi ? 2 : 1;
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        String str2 = finderContactSearchUI.dPI;
        String str3 = finderContactSearchUI.query;
        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
        String dob = com.tencent.mm.plugin.finder.report.k.dob();
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(finderContactSearchUI);
        com.tencent.mm.plugin.finder.report.k.a(str2, str3, 1, 1, str, i2, 2, dob, 1, i3, fH != null ? fH.dIx() : null);
        if (str != null && !finderContactSearchUI.vtH.containsKey(str)) {
            Log.d(finderContactSearchUI.TAG, "addExposeItem " + str + ' ' + i2 + ' ' + 1);
            a aVar2 = new a();
            aVar2.setId(str);
            aVar2.position = i2;
            aVar2.type = 1;
            aVar2.timeStamp = System.currentTimeMillis();
            finderContactSearchUI.vtH.put(str, aVar2);
            if (finderContactSearchUI.vtH.size() % 30 == 0 && !Util.isNullOrNil(finderContactSearchUI.dPI)) {
                if (finderContactSearchUI.vtH.isEmpty()) {
                    z = false;
                }
                if (z) {
                    l lVar = l.vfB;
                    l.a(finderContactSearchUI.dPI, finderContactSearchUI.query, finderContactSearchUI.vtH, 2);
                }
            }
        }
        AppMethodBeat.o(251260);
    }
}
