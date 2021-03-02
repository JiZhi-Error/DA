package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.hq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ba;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aqr;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.UUID;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@l(hxD = {1, 1, 16}, hxE = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0002VWB\u0005¢\u0006\u0002\u0010\u0007J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0014J\b\u0010.\u001a\u00020(H\u0002J\b\u0010/\u001a\u00020*H\u0002J\b\u00100\u001a\u00020*H\u0002J\b\u00101\u001a\u00020*H\u0002J\u0012\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u00104\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u00105\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u00106\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020*H\u0014J\b\u0010:\u001a\u00020*H\u0014J6\u0010;\u001a\u00020*2\b\u0010<\u001a\u0004\u0018\u00010\u001d2\b\u0010=\u001a\u0004\u0018\u00010\u001d2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020(H\u0016J\u0018\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020\u00062\u0006\u0010G\u001a\u00020HH\u0016J,\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000b2\b\u0010L\u001a\u0004\u0018\u00010\u001d2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010O\u001a\u00020(H\u0016J\u001a\u0010P\u001a\u00020*2\u0006\u0010Q\u001a\u00020\u000b2\b\u0010R\u001a\u0004\u0018\u00010@H\u0016J\u0018\u0010S\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020(H\u0002J\u0010\u0010U\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000¨\u0006X"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderCreateGuideUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$FansSearchAdapter;", "continueFlag", "", "fansList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "finderBottomSheet", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroid/support/design/widget/CoordinatorLayout;", "netSceneFinderFansSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFansSearch;", "noResultView", "Landroid/widget/TextView;", SearchIntents.EXTRA_QUERY, "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchSessionId", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "enableActivityAnimation", "", "finish", "", "getCommentScene", "getFansListSize", "getLayoutId", "handleSearch", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", FirebaseAnalytics.b.INDEX, "tag", "reportSearch", "isAccountEmpty", "startSearch", "ContactViewHolder", "FansSearchAdapter", "plugin-finder_release"})
public final class FinderCreateGuideUI extends MMFinderUI implements i, ai<ayt>, FTSEditTextView.a, a.b {
    private HashMap _$_findViewCache;
    private int continueFlag;
    private String dPI = "";
    private View hSw;
    private RecyclerView hak;
    private View lJI;
    private String query = "";
    private RefreshLoadMoreLayout tLS;
    private com.tencent.mm.bw.b tVM;
    private com.tencent.mm.ui.search.a ubO;
    private ArrayList<aqr> vJl = new ArrayList<>();
    private b vJm;
    private ba vJn;
    private com.tencent.mm.plugin.finder.view.d vJo;
    private String vfu = "";
    private CoordinatorLayout vtI;
    private TextView vtJ;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252303);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252303);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252302);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252302);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderCreateGuideUI() {
        AppMethodBeat.i(252298);
        AppMethodBeat.o(252298);
    }

    public static final /* synthetic */ com.tencent.mm.ui.search.a c(FinderCreateGuideUI finderCreateGuideUI) {
        AppMethodBeat.i(252299);
        com.tencent.mm.ui.search.a aVar = finderCreateGuideUI.ubO;
        if (aVar == null) {
            p.btv("searchView");
        }
        AppMethodBeat.o(252299);
        return aVar;
    }

    public static final /* synthetic */ RefreshLoadMoreLayout h(FinderCreateGuideUI finderCreateGuideUI) {
        AppMethodBeat.i(252300);
        RefreshLoadMoreLayout refreshLoadMoreLayout = finderCreateGuideUI.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        AppMethodBeat.o(252300);
        return refreshLoadMoreLayout;
    }

    public static final /* synthetic */ b i(FinderCreateGuideUI finderCreateGuideUI) {
        AppMethodBeat.i(252301);
        b bVar = finderCreateGuideUI.vJm;
        if (bVar == null) {
            p.btv("adapter");
        }
        AppMethodBeat.o(252301);
        return bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
    @Override // com.tencent.mm.plugin.i.a.ai
    public final /* synthetic */ void a(ayt ayt, apg apg) {
        AppMethodBeat.i(252297);
        ayt ayt2 = ayt;
        p.h(ayt2, "req");
        p.h(apg, "ret");
        com.tencent.mm.ac.d.h(new e(this, apg, ayt2));
        AppMethodBeat.o(252297);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(252284);
        super.onCreateBeforeSetContentView();
        setTheme(R.style.q2);
        AppMethodBeat.o(252284);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(252285);
        fixStatusbar(true);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            p.g(window, "window");
            window.setStatusBarColor(getResources().getColor(R.color.ac_));
        }
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
        aVar2.getFtsEditText().setHint(getString(R.string.yp));
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
        String uuid = UUID.randomUUID().toString();
        p.g(uuid, "UUID.randomUUID().toString()");
        this.vfu = uuid;
        this.vJm = new b();
        View findViewById = findViewById(R.id.h8v);
        p.g(findViewById, "findViewById(R.id.root)");
        this.lJI = findViewById;
        View findViewById2 = findViewById(R.id.f6f);
        p.g(findViewById2, "findViewById(R.id.main_rv)");
        this.vtI = (CoordinatorLayout) findViewById2;
        View findViewById3 = findViewById(R.id.h7t);
        p.g(findViewById3, "findViewById(R.id.rl_layout)");
        this.tLS = (RefreshLoadMoreLayout) findViewById3;
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        this.hak = refreshLoadMoreLayout.getRecyclerView();
        View findViewById4 = findViewById(R.id.g01);
        p.g(findViewById4, "findViewById(R.id.no_result_tv)");
        this.vtJ = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.epl);
        p.g(findViewById5, "findViewById(R.id.loading_layout)");
        this.hSw = findViewById5;
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
        b bVar = this.vJm;
        if (bVar == null) {
            p.btv("adapter");
        }
        recyclerView2.setAdapter(bVar);
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
        recyclerView5.setOnTouchListener(new c(this));
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
        refreshLoadMoreLayout4.setActionCallback(new d(this));
        String str = this.query;
        if (str != null) {
            com.tencent.mm.ui.search.a aVar9 = this.ubO;
            if (aVar9 == null) {
                p.btv("searchView");
            }
            aVar9.getFtsEditText().O(str, null);
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
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView7, a2.axQ(), "com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView7.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView7, "com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(252285);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
    static final class c implements View.OnTouchListener {
        final /* synthetic */ FinderCreateGuideUI vJq;

        c(FinderCreateGuideUI finderCreateGuideUI) {
            this.vJq = finderCreateGuideUI;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(252278);
            FinderCreateGuideUI.c(this.vJq).getFtsEditText().gUA();
            this.vJq.hideVKB();
            AppMethodBeat.o(252278);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
    public static final class d extends RefreshLoadMoreLayout.a {
        final /* synthetic */ FinderCreateGuideUI vJq;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(252280);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(252280);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(252282);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(252282);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(252281);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(252281);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderCreateGuideUI finderCreateGuideUI) {
            this.vJq = finderCreateGuideUI;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            View findViewById;
            TextView textView;
            TextView textView2;
            View findViewById2;
            TextView textView3;
            TextView textView4;
            AppMethodBeat.i(252279);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            Log.i("Finder.FinderFansSearchUI", "onLoadMoreBegin");
            String str = this.vJq.query;
            if (str != null) {
                if (this.vJq.continueFlag == 1) {
                    this.vJq.vJn = new ba(str, this.vJq.tVM, (byte) 0);
                    g.azz().b(this.vJq.vJn);
                    g.azz().a(6665, this.vJq);
                    View loadMoreFooter = FinderCreateGuideUI.h(this.vJq).getLoadMoreFooter();
                    if (!(loadMoreFooter == null || (textView4 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                        textView4.setText(R.string.d0l);
                    }
                    View loadMoreFooter2 = FinderCreateGuideUI.h(this.vJq).getLoadMoreFooter();
                    if (!(loadMoreFooter2 == null || (textView3 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                        textView3.setVisibility(0);
                    }
                    View loadMoreFooter3 = FinderCreateGuideUI.h(this.vJq).getLoadMoreFooter();
                    if (!(loadMoreFooter3 == null || (findViewById2 = loadMoreFooter3.findViewById(R.id.ep0)) == null)) {
                        findViewById2.setVisibility(8);
                    }
                } else {
                    View loadMoreFooter4 = FinderCreateGuideUI.h(this.vJq).getLoadMoreFooter();
                    if (!(loadMoreFooter4 == null || (textView2 = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                        textView2.setText(R.string.d0m);
                    }
                    View loadMoreFooter5 = FinderCreateGuideUI.h(this.vJq).getLoadMoreFooter();
                    if (!(loadMoreFooter5 == null || (textView = (TextView) loadMoreFooter5.findViewById(R.id.ep1)) == null)) {
                        textView.setVisibility(8);
                    }
                    View loadMoreFooter6 = FinderCreateGuideUI.h(this.vJq).getLoadMoreFooter();
                    if (!(loadMoreFooter6 == null || (findViewById = loadMoreFooter6.findViewById(R.id.ep0)) == null)) {
                        findViewById.setVisibility(0);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(252279);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a_o;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean enableActivityAnimation() {
        return false;
    }

    @Override // com.tencent.mm.ui.search.a.b
    public final void onClickBackBtn(View view) {
        AppMethodBeat.i(252286);
        hideVKB();
        finish();
        AppMethodBeat.o(252286);
    }

    public final void onClickCancelBtn(View view) {
        AppMethodBeat.i(252287);
        hideVKB();
        finish();
        AppMethodBeat.o(252287);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void dpw() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        if (r0 == null) goto L_0x0024;
     */
    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r5, java.lang.String r6, java.util.List<com.tencent.mm.ui.search.a.c> r7, com.tencent.mm.ui.search.FTSEditTextView.b r8) {
        /*
            r4 = this;
            r3 = 8
            r2 = 252288(0x3d980, float:3.53531E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r5 == 0) goto L_0x0024
            if (r5 != 0) goto L_0x0018
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0018:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.CharSequence r0 = kotlin.n.n.trim(r5)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0027
        L_0x0024:
            java.lang.String r0 = ""
        L_0x0027:
            boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r0 == 0) goto L_0x0058
            android.view.View r0 = r4.hSw
            if (r0 != 0) goto L_0x0037
            java.lang.String r1 = "loadingView"
            kotlin.g.b.p.btv(r1)
        L_0x0037:
            r0.setVisibility(r3)
            android.widget.TextView r0 = r4.vtJ
            if (r0 != 0) goto L_0x0044
            java.lang.String r1 = "noResultView"
            kotlin.g.b.p.btv(r1)
        L_0x0044:
            r0.setVisibility(r3)
            com.tencent.mm.view.RefreshLoadMoreLayout r0 = r4.tLS
            if (r0 != 0) goto L_0x0051
            java.lang.String r1 = "rlLayout"
            kotlin.g.b.p.btv(r1)
        L_0x0051:
            r0.setVisibility(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0057:
            return
        L_0x0058:
            r4.dpx()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.FinderCreateGuideUI.a(java.lang.String, java.lang.String, java.util.List, com.tencent.mm.ui.search.FTSEditTextView$b):void");
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void onClickClearTextBtn(View view) {
        AppMethodBeat.i(252289);
        com.tencent.mm.ui.search.a aVar = this.ubO;
        if (aVar == null) {
            p.btv("searchView");
        }
        aVar.getFtsEditText().awD();
        showVKB();
        AppMethodBeat.o(252289);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final boolean awE() {
        AppMethodBeat.i(252290);
        hideVKB();
        if (dpx()) {
            AppMethodBeat.o(252290);
            return true;
        }
        AppMethodBeat.o(252290);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        if (r0 == null) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean dpx() {
        /*
            r3 = this;
            r2 = 252291(0x3d983, float:3.53535E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.mm.ui.search.a r0 = r3.ubO
            if (r0 != 0) goto L_0x0010
            java.lang.String r1 = "searchView"
            kotlin.g.b.p.btv(r1)
        L_0x0010:
            com.tencent.mm.ui.search.FTSEditTextView r0 = r0.getFtsEditText()
            java.lang.String r1 = "searchView.ftsEditText"
            kotlin.g.b.p.g(r0, r1)
            java.lang.String r0 = r0.getTotalQuery()
            if (r0 == 0) goto L_0x003a
            if (r0 != 0) goto L_0x002e
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x002e:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.n.n.trim(r0)
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x003d
        L_0x003a:
            java.lang.String r0 = ""
        L_0x003d:
            boolean r1 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r1 == 0) goto L_0x0048
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0047:
            return r0
        L_0x0048:
            r3.auV(r0)
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.ui.FinderCreateGuideUI.dpx():boolean");
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(252292);
        g.azz().b(6665, this);
        super.onDestroy();
        AppMethodBeat.o(252292);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(252293);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.s);
        AppMethodBeat.o(252293);
    }

    private final void auV(String str) {
        AppMethodBeat.i(252294);
        this.query = str;
        this.continueFlag = 0;
        this.tVM = null;
        this.vJl.clear();
        String uuid = UUID.randomUUID().toString();
        p.g(uuid, "UUID.randomUUID().toString()");
        this.dPI = uuid;
        ba baVar = this.vJn;
        if (baVar != null) {
            g.azz().a(baVar);
        }
        this.vJn = new ba(str, this.tVM, (byte) 0);
        g.azz().b(this.vJn);
        g.azz().a(6665, this);
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
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
        View view2 = this.lJI;
        if (view2 == null) {
            p.btv("rootView");
        }
        AppCompatActivity context = getContext();
        p.g(context, "context");
        view2.setBackground(context.getResources().getDrawable(R.color.f3043a));
        AppMethodBeat.o(252294);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        bbt bbt;
        AppMethodBeat.i(252295);
        g.azz().b(6665, this);
        int dzp = dzp();
        if (i2 == 0 && i3 == 0) {
            ba baVar = this.vJn;
            if (baVar != null) {
                bbt = baVar.tva;
            } else {
                bbt = null;
            }
            if (bbt == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchFansResponse");
                AppMethodBeat.o(252295);
                throw tVar;
            }
            LinkedList<aqr> linkedList = bbt.LDm;
            p.g(linkedList, "response.fansContactList");
            LinkedList<aqr> linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
            Iterator<T> it = linkedList2.iterator();
            while (it.hasNext()) {
                arrayList.add(Boolean.valueOf(this.vJl.add(it.next())));
            }
            this.continueFlag = bbt.continueFlag;
            this.tVM = bbt.tVM;
            int dzp2 = dzp();
            Log.i("Finder.FinderFansSearchUI", "onSceneEnd " + bbt.continueFlag + ' ' + this.vJl.size());
            String str2 = this.query;
            int i4 = bbt.LDm.isEmpty() ? 1 : 2;
            k kVar = k.vfA;
            String str3 = this.vfu;
            String str4 = this.dPI;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            AppCompatActivity context = getContext();
            p.g(context, "context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            k.a(str3, str4, str2, 2, 1, 2, i4, 0, fH != null ? fH.dIx() : null);
            dzp = dzp2;
        }
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout.apT(0);
        if (dzp == 0) {
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
            CoordinatorLayout coordinatorLayout = this.vtI;
            if (coordinatorLayout == null) {
                p.btv("mainContainer");
            }
            coordinatorLayout.setVisibility(0);
        }
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
            AppMethodBeat.o(252295);
            return;
        }
        AppMethodBeat.o(252295);
    }

    private final int dzp() {
        RecyclerView.a adapter;
        AppMethodBeat.i(252296);
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
            int size = this.vJl.size();
            AppMethodBeat.o(252296);
            return size;
        }
        int itemCount = adapter.getItemCount();
        AppMethodBeat.o(252296);
        return itemCount;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 75;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$FansSearchAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/ui/FinderCreateGuideUI;)V", "getItemCount", "", "getShowBefore", "makeHighlightString", "", FirebaseAnalytics.b.ORIGIN, "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
    public final class b extends RecyclerView.a<RecyclerView.v> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(252274);
            int size = FinderCreateGuideUI.this.vJl.size();
            AppMethodBeat.o(252274);
            return size;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(252275);
            p.h(viewGroup, "parent");
            AppCompatActivity context = FinderCreateGuideUI.this.getContext();
            if (context == null) {
                p.hyc();
            }
            View inflate = context.getLayoutInflater().inflate(R.layout.a_m, viewGroup, false);
            FinderCreateGuideUI finderCreateGuideUI = FinderCreateGuideUI.this;
            p.g(inflate, "contactLayout");
            a aVar = new a(finderCreateGuideUI, inflate);
            AppMethodBeat.o(252275);
            return aVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            String str;
            String str2;
            CharSequence fromHtml;
            AppMethodBeat.i(252276);
            p.h(vVar, "holder");
            if (!(vVar instanceof a)) {
                AppMethodBeat.o(252276);
                return;
            }
            Object obj = FinderCreateGuideUI.this.vJl.get(i2);
            p.g(obj, "fansList[position]");
            aqr aqr = (aqr) obj;
            FinderContact finderContact = aqr.contact;
            if (finderContact == null || (str = finderContact.headUrl) == null) {
                str = "";
            }
            String nullAsNil = Util.nullAsNil(str);
            if (aqr.displayFlag == 0) {
                m mVar = m.uJa;
                com.tencent.mm.loader.d<o> dkb = m.dkb();
                com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(nullAsNil);
                ImageView imageView = ((a) vVar).gyr;
                m mVar2 = m.uJa;
                dkb.a(aVar, imageView, m.a(m.a.WX_AVATAR));
            } else {
                m mVar3 = m.uJa;
                com.tencent.mm.loader.d<o> dka = m.dka();
                com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(nullAsNil);
                ImageView imageView2 = ((a) vVar).gyr;
                m mVar4 = m.uJa;
                dka.a(aVar2, imageView2, m.a(m.a.AVATAR));
            }
            TextView textView = ((a) vVar).pIN;
            Context context = MMApplicationContext.getContext();
            FinderContact finderContact2 = aqr.contact;
            if (finderContact2 == null || (str2 = finderContact2.nickname) == null) {
                str2 = "";
            }
            if (!Util.isNullOrNil(str2)) {
                StringBuilder append = new StringBuilder("<font color=\"#06AD56\">").append(str2).append("</font>");
                p.g(append, "StringBuilder().append(\"…origin).append(\"</font>\")");
                fromHtml = Html.fromHtml(append.toString());
            }
            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.d(context, fromHtml, ((a) vVar).pIN.getTextSize()));
            if (dzq() != i2 || i2 == getItemCount() - 1) {
                ((a) vVar).vGX.setVisibility(8);
            } else {
                ((a) vVar).vGX.setVisibility(0);
            }
            if (aqr.dJM) {
                ((a) vVar).vJp.setOnClickListener(null);
                AppMethodBeat.o(252276);
                return;
            }
            ((a) vVar).vJp.setOnClickListener(new a(this, aqr));
            AppMethodBeat.o(252276);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ b vJr;
            final /* synthetic */ aqr vJs;

            a(b bVar, aqr aqr) {
                this.vJr = bVar;
                this.vJs = aqr;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(252273);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$FansSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FinderCreateGuideUI.this.vJo = b.a(this.vJs, FinderCreateGuideUI.this, new kotlin.g.a.b<String, x>(this) {
                    /* class com.tencent.mm.plugin.finder.ui.FinderCreateGuideUI.b.a.AnonymousClass1 */
                    final /* synthetic */ a vJt;

                    {
                        this.vJt = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(String str) {
                        AppMethodBeat.i(252272);
                        String str2 = str;
                        com.tencent.mm.plugin.finder.view.d dVar = FinderCreateGuideUI.this.vJo;
                        if (dVar != null) {
                            dVar.bMo();
                        }
                        b.dzu().d(str2, FinderCreateGuideUI.this, FinderCreateGuideUI.this);
                        x xVar = x.SXb;
                        AppMethodBeat.o(252272);
                        return xVar;
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$FansSearchAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(252273);
            }
        }

        private final int dzq() {
            boolean z;
            AppMethodBeat.i(252277);
            ArrayList arrayList = FinderCreateGuideUI.this.vJl;
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                if (((aqr) listIterator.previous()).cSx == 1) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    int nextIndex = listIterator.nextIndex();
                    AppMethodBeat.o(252277);
                    return nextIndex;
                }
            }
            AppMethodBeat.o(252277);
            return -1;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderCreateGuideUI$ContactViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/ui/FinderCreateGuideUI;Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "beforeTip", "Landroid/widget/TextView;", "getBeforeTip", "()Landroid/widget/TextView;", "clickArea", "Landroid/widget/RelativeLayout;", "getClickArea", "()Landroid/widget/RelativeLayout;", "nicknameTv", "getNicknameTv", "plugin-finder_release"})
    final class a extends RecyclerView.v {
        final ImageView gyr;
        final TextView pIN;
        final TextView vGX;
        final RelativeLayout vJp;
        final /* synthetic */ FinderCreateGuideUI vJq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FinderCreateGuideUI finderCreateGuideUI, View view) {
            super(view);
            p.h(view, "itemView");
            this.vJq = finderCreateGuideUI;
            AppMethodBeat.i(252271);
            View findViewById = view.findViewById(R.id.x1);
            p.g(findViewById, "itemView.findViewById(R.id.avatar_iv)");
            this.gyr = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.fzg);
            p.g(findViewById2, "itemView.findViewById(R.id.nickname_tv)");
            this.pIN = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.a2r);
            p.g(findViewById3, "itemView.findViewById(R.id.before_split_tv)");
            this.vGX = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.cb0);
            p.g(findViewById4, "itemView.findViewById(R.id.fans_main_layout)");
            this.vJp = (RelativeLayout) findViewById4;
            AppMethodBeat.o(252271);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ apg vHq;
        final /* synthetic */ ayt vHr;
        final /* synthetic */ FinderCreateGuideUI vJq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderCreateGuideUI finderCreateGuideUI, apg apg, ayt ayt) {
            super(0);
            this.vJq = finderCreateGuideUI;
            this.vHq = apg;
            this.vHr = ayt;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            Object obj;
            AppMethodBeat.i(252283);
            if (this.vHq.retCode == 0) {
                Iterator it = this.vJq.vJl.iterator();
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
                    this.vJq.vJl.remove(aqr);
                    FinderCreateGuideUI.i(this.vJq).notifyDataSetChanged();
                    EventCenter eventCenter = EventCenter.instance;
                    hq hqVar = new hq();
                    hqVar.dMi.dMj = this.vHr.dMj;
                    hqVar.dMi.retCode = this.vHq.retCode;
                    eventCenter.publish(hqVar);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252283);
            return xVar;
        }
    }
}
