package com.tencent.mm.plugin.finder.search;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import java.util.HashMap;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001\f\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010\"\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0014J6\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\u001bH\u0014J\b\u00103\u001a\u00020\u001bH\u0014J\b\u00104\u001a\u00020\nH\u0016J\b\u00105\u001a\u00020\u001bH\u0016J\u001a\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010-H\u0016J\b\u00109\u001a\u00020\u001bH\u0002J\b\u0010:\u001a\u00020\u001bH\u0002J\b\u0010;\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "isHotSearchEnable", "", "mOnScrollListener", "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1;", "popularListLogic", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "getCommentScene", "", "getLayoutId", "getReportType", "initData", "", "initPopularList", "initSearchView", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onPause", "onResume", "onSearchKeyDown", "onSwipeBack", "onTagClick", FirebaseAnalytics.b.INDEX, "tag", "reportStartSearch", "requestSearch", "showPopularList", "Companion", "plugin-finder_release"})
public final class FinderMixSearchUI extends MMFinderUI implements FTSEditTextView.a, a.b {
    public static final a vuA = new a((byte) 0);
    private HashMap _$_findViewCache;
    private FinderMixSearchPresenter presenter;
    private com.tencent.mm.ui.search.a ubO;
    private g ubP;
    private h vtK;
    private f vux;
    private boolean vuy;
    private final e vuz = new e();

    static {
        AppMethodBeat.i(251322);
        AppMethodBeat.o(251322);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(251325);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(251325);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(251324);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(251324);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", SearchIntents.EXTRA_QUERY, "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderMixSearchUI vuB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderMixSearchUI finderMixSearchUI) {
            super(1);
            this.vuB = finderMixSearchUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(166816);
            String str2 = str;
            p.h(str2, SearchIntents.EXTRA_QUERY);
            FinderMixSearchUI.a(this.vuB).getFtsEditText().O(str2, null);
            FinderMixSearchUI.b(this.vuB).br(str2, true);
            g gVar = this.vuB.ubP;
            if (gVar != null) {
                gVar.dpJ();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(166816);
            return xVar;
        }
    }

    public FinderMixSearchUI() {
        AppMethodBeat.i(251321);
        AppMethodBeat.o(251321);
    }

    public static final /* synthetic */ com.tencent.mm.ui.search.a a(FinderMixSearchUI finderMixSearchUI) {
        AppMethodBeat.i(166826);
        com.tencent.mm.ui.search.a aVar = finderMixSearchUI.ubO;
        if (aVar == null) {
            p.btv("searchView");
        }
        AppMethodBeat.o(166826);
        return aVar;
    }

    public static final /* synthetic */ FinderMixSearchPresenter b(FinderMixSearchUI finderMixSearchUI) {
        AppMethodBeat.i(166827);
        FinderMixSearchPresenter finderMixSearchPresenter = finderMixSearchUI.presenter;
        if (finderMixSearchPresenter == null) {
            p.btv("presenter");
        }
        AppMethodBeat.o(166827);
        return finderMixSearchPresenter;
    }

    public static final /* synthetic */ boolean d(FinderMixSearchUI finderMixSearchUI) {
        AppMethodBeat.i(251323);
        boolean dpD = finderMixSearchUI.dpD();
        AppMethodBeat.o(251323);
        return dpD;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI$Companion;", "", "()V", "KEY_SEARCH_QUERY", "", "KEY_SEARCH_SESSION_BUFFER", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        boolean z;
        bbn bbn;
        AppMethodBeat.i(166818);
        super.onCreate(bundle);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dwL().value().intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.vuy = z;
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
        if (this.vuy) {
            com.tencent.mm.ui.search.a aVar5 = this.ubO;
            if (aVar5 == null) {
                p.btv("searchView");
            }
            aVar5.gXh();
        }
        com.tencent.mm.ui.search.a aVar6 = this.ubO;
        if (aVar6 == null) {
            p.btv("searchView");
        }
        aVar6.getFtsEditText().awD();
        com.tencent.mm.ui.search.a aVar7 = this.ubO;
        if (aVar7 == null) {
            p.btv("searchView");
        }
        aVar7.getFtsEditText().awC();
        com.tencent.mm.ui.search.a aVar8 = this.ubO;
        if (aVar8 == null) {
            p.btv("searchView");
        }
        aVar8.getFtsEditText().gWY();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            p.hyc();
        }
        p.g(supportActionBar, "supportActionBar!!");
        com.tencent.mm.ui.search.a aVar9 = this.ubO;
        if (aVar9 == null) {
            p.btv("searchView");
        }
        supportActionBar.setCustomView(aVar9);
        this.vtK = new h(this, false, new b(this), new c(this));
        this.presenter = new FinderMixSearchPresenter(this);
        FinderMixSearchUI finderMixSearchUI = this;
        FinderMixSearchPresenter finderMixSearchPresenter = this.presenter;
        if (finderMixSearchPresenter == null) {
            p.btv("presenter");
        }
        this.vux = new f(finderMixSearchUI, finderMixSearchPresenter);
        FinderMixSearchPresenter finderMixSearchPresenter2 = this.presenter;
        if (finderMixSearchPresenter2 == null) {
            p.btv("presenter");
        }
        f fVar = this.vux;
        if (fVar == null) {
            p.btv("viewCallback");
        }
        finderMixSearchPresenter2.a(fVar);
        f fVar2 = this.vux;
        if (fVar2 == null) {
            p.btv("viewCallback");
        }
        fVar2.hak.setOnTouchListener(new d(this));
        h hVar = this.vtK;
        if (hVar == null) {
            p.btv("historyLogic");
        }
        hVar.dpT();
        f fVar3 = this.vux;
        if (fVar3 == null) {
            p.btv("viewCallback");
        }
        fVar3.hak.a(this.vuz);
        if (!this.vuy) {
            k kVar = k.vfA;
            k.auJ(String.valueOf(cl.aWA()));
            String uuid = UUID.randomUUID().toString();
            p.g(uuid, "UUID.randomUUID().toString()");
            k kVar2 = k.vfA;
            k kVar3 = k.vfA;
            String dob = k.dob();
            FinderReporterUIC.a aVar10 = FinderReporterUIC.wzC;
            AppCompatActivity context = getContext();
            p.g(context, "context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH != null) {
                bbn = fH.dIx();
            } else {
                bbn = null;
            }
            k.a(dob, uuid, "", 1, 1, 1, 0, 0, bbn);
        }
        AppMethodBeat.o(166818);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/search/FinderMixSearchUI$initData$2", "Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;", "onClear", "", "plugin-finder_release"})
    public static final class c implements j {
        final /* synthetic */ FinderMixSearchUI vuB;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderMixSearchUI finderMixSearchUI) {
            this.vuB = finderMixSearchUI;
        }

        @Override // com.tencent.mm.plugin.finder.search.j
        public final void cwc() {
            AppMethodBeat.i(251313);
            FinderMixSearchUI.d(this.vuB);
            AppMethodBeat.o(251313);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
    static final class d implements View.OnTouchListener {
        final /* synthetic */ FinderMixSearchUI vuB;

        d(FinderMixSearchUI finderMixSearchUI) {
            this.vuB = finderMixSearchUI;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(251314);
            FinderMixSearchUI.a(this.vuB).getFtsEditText().gUA();
            this.vuB.hideVKB();
            AppMethodBeat.o(251314);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(166819);
        h hVar = this.vtK;
        if (hVar == null) {
            p.btv("historyLogic");
        }
        hVar.onDestroy();
        g gVar = this.ubP;
        if (gVar != null) {
            gVar.onDestroy();
        }
        FinderMixSearchPresenter finderMixSearchPresenter = this.presenter;
        if (finderMixSearchPresenter == null) {
            p.btv("presenter");
        }
        finderMixSearchPresenter.onDetach();
        hideVKB();
        f fVar = this.vux;
        if (fVar == null) {
            p.btv("viewCallback");
        }
        fVar.hak.b(this.vuz);
        if (!this.vuy) {
            k kVar = k.vfA;
            k.auJ("");
        }
        super.onDestroy();
        AppMethodBeat.o(166819);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.agu;
    }

    @Override // com.tencent.mm.ui.search.a.b
    public final void onClickBackBtn(View view) {
        AppMethodBeat.i(166820);
        hideVKB();
        if (dpD()) {
            finish();
        }
        AppMethodBeat.o(166820);
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public final void onSwipeBack() {
        AppMethodBeat.i(251317);
        super.onSwipeBack();
        hideVKB();
        AppMethodBeat.o(251317);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r2.isShowing() != false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean dpD() {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.FinderMixSearchUI.dpD():boolean");
    }

    public final void onClickCancelBtn(View view) {
        AppMethodBeat.i(166821);
        hideVKB();
        finish();
        AppMethodBeat.o(166821);
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
            r4 = 166822(0x28ba6, float:2.33767E-40)
            r3 = 8
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r6 == 0) goto L_0x0024
            if (r6 != 0) goto L_0x0018
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x0018:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            java.lang.CharSequence r0 = kotlin.n.n.trim(r6)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0027
        L_0x0024:
            java.lang.String r0 = ""
        L_0x0027:
            com.tencent.mm.plugin.finder.search.h r1 = r5.vtK
            if (r1 != 0) goto L_0x0031
            java.lang.String r2 = "historyLogic"
            kotlin.g.b.p.btv(r2)
        L_0x0031:
            r1.auW(r0)
            com.tencent.mm.plugin.finder.search.f r1 = r5.vux
            if (r1 != 0) goto L_0x003e
            java.lang.String r2 = "viewCallback"
            kotlin.g.b.p.btv(r2)
        L_0x003e:
            boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r0 == 0) goto L_0x0053
            android.widget.TextView r0 = r1.vtJ
            r0.setVisibility(r3)
            android.view.View r0 = r1.hSw
            r0.setVisibility(r3)
            android.support.v7.widget.RecyclerView r0 = r1.hak
            r0.setVisibility(r3)
        L_0x0053:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.FinderMixSearchUI.a(java.lang.String, java.lang.String, java.util.List, com.tencent.mm.ui.search.FTSEditTextView$b):void");
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
        boolean z2;
        String str;
        AppMethodBeat.i(166823);
        if (z) {
            g gVar = this.ubP;
            if (gVar != null) {
                if (gVar.tmh.getVisibility() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    com.tencent.mm.ui.search.a aVar = this.ubO;
                    if (aVar == null) {
                        p.btv("searchView");
                    }
                    FTSEditTextView ftsEditText = aVar.getFtsEditText();
                    p.g(ftsEditText, "searchView.ftsEditText");
                    String totalQuery = ftsEditText.getTotalQuery();
                    if (totalQuery == null) {
                        str = null;
                    } else if (totalQuery == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                        AppMethodBeat.o(166823);
                        throw tVar;
                    } else {
                        str = n.trim(totalQuery).toString();
                    }
                    if (Util.isNullOrNil(str)) {
                        gVar.dpJ();
                        h hVar = this.vtK;
                        if (hVar == null) {
                            p.btv("historyLogic");
                        }
                        hVar.dpT();
                    }
                }
            }
            com.tencent.mm.plugin.finder.report.l lVar = com.tencent.mm.plugin.finder.report.l.vfB;
            com.tencent.mm.plugin.finder.report.l.doe();
        }
        AppMethodBeat.o(166823);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void onClickClearTextBtn(View view) {
        AppMethodBeat.i(166824);
        com.tencent.mm.ui.search.a aVar = this.ubO;
        if (aVar == null) {
            p.btv("searchView");
        }
        aVar.getFtsEditText().awD();
        showVKB();
        AppMethodBeat.o(166824);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        if (r0 == null) goto L_0x003e;
     */
    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean awE() {
        /*
        // Method dump skipped, instructions count: 113
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.FinderMixSearchUI.awE():boolean");
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 23;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(251319);
        super.onResume();
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, s.j.COMMENT_SCENE_SEARCH_RESULT_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        AppMethodBeat.o(251319);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(251320);
        super.onPause();
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, s.j.COMMENT_SCENE_SEARCH_RESULT_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        AppMethodBeat.o(251320);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class e extends RecyclerView.l {
        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(251316);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(251316);
        }

        e() {
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(251315);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, s.j.COMMENT_SCENE_SEARCH_RESULT_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(251315);
        }
    }
}
