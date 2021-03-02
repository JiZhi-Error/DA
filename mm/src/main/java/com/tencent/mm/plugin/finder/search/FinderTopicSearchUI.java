package com.tencent.mm.plugin.finder.search;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@l(hxD = {1, 1, 16}, hxE = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 V2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003VWXB\u0005¢\u0006\u0002\u0010\u0005J \u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\u0016H\u0016J\b\u00100\u001a\u00020+H\u0016J\b\u00101\u001a\u00020\u0007H\u0014J\b\u00102\u001a\u00020\u0007H\u0002J\b\u00103\u001a\u00020\u0016H\u0002J\b\u00104\u001a\u00020+H\u0002J\b\u00105\u001a\u00020+H\u0002J\b\u00106\u001a\u00020+H\u0002J\u0012\u00107\u001a\u00020+2\b\u00108\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u00109\u001a\u00020+2\b\u00108\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010:\u001a\u00020+2\b\u00108\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010;\u001a\u00020+2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020+H\u0014J6\u0010?\u001a\u00020+2\b\u0010@\u001a\u0004\u0018\u00010\n2\b\u0010A\u001a\u0004\u0018\u00010\n2\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010C2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010G\u001a\u00020+2\u0006\u0010H\u001a\u00020\u0016H\u0016J,\u0010I\u001a\u00020+2\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u00072\b\u0010L\u001a\u0004\u0018\u00010\n2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010O\u001a\u00020\u0016H\u0016J\u001a\u0010P\u001a\u00020+2\u0006\u0010Q\u001a\u00020\u00072\b\u0010R\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010S\u001a\u00020+2\b\b\u0002\u0010T\u001a\u00020\u0016H\u0002J\u0010\u0010U\u001a\u00020+2\u0006\u0010\u001c\u001a\u00020\nH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)X\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroid/support/design/widget/CoordinatorLayout;", "needHistory", "", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", SearchIntents.EXTRA_QUERY, "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "topicList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicSearchInfo;", "Lkotlin/collections/ArrayList;", "addExposeItem", "", "id", "position", "type", "enableActivityAnimation", "finish", "getLayoutId", "getTopicSize", "handleSearch", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", FirebaseAnalytics.b.INDEX, "tag", "reportSearchExpose", "needClear", "startSearch", "Companion", "HeaderViewHolder", "TopicSearchAdapter", "plugin-finder_release"})
public final class FinderTopicSearchUI extends MMActivity implements i, FTSEditTextView.a, a.b {
    private static final String TAG = TAG;
    public static final a vvv = new a((byte) 0);
    private HashMap _$_findViewCache;
    private int continueFlag;
    private String dPI = "";
    private View hSw;
    private RecyclerView hak;
    private int jKy;
    private View lJI;
    private int offset;
    private String query = "";
    private int requestType;
    private RefreshLoadMoreLayout tLS;
    private com.tencent.mm.bw.b tVM;
    private com.tencent.mm.ui.search.a ubO;
    private ArrayList<bdu> vtE = new ArrayList<>();
    private boolean vtF = true;
    private HashMap<String, a> vtH = new HashMap<>();
    private CoordinatorLayout vtI;
    private TextView vtJ;
    private h vtK;
    private cf vtL;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(251404);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(251404);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(251403);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(251403);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class f extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderTopicSearchUI vvw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderTopicSearchUI finderTopicSearchUI) {
            super(1);
            this.vvw = finderTopicSearchUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(251382);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            FinderTopicSearchUI.b(this.vvw).getFtsEditText().O(str2, null);
            FinderTopicSearchUI.a(this.vvw, str2);
            x xVar = x.SXb;
            AppMethodBeat.o(251382);
            return xVar;
        }
    }

    public FinderTopicSearchUI() {
        AppMethodBeat.i(251397);
        AppMethodBeat.o(251397);
    }

    public static final /* synthetic */ void a(FinderTopicSearchUI finderTopicSearchUI, String str) {
        AppMethodBeat.i(251401);
        finderTopicSearchUI.auV(str);
        AppMethodBeat.o(251401);
    }

    public static final /* synthetic */ com.tencent.mm.ui.search.a b(FinderTopicSearchUI finderTopicSearchUI) {
        AppMethodBeat.i(251400);
        com.tencent.mm.ui.search.a aVar = finderTopicSearchUI.ubO;
        if (aVar == null) {
            p.btv("searchView");
        }
        AppMethodBeat.o(251400);
        return aVar;
    }

    public static final /* synthetic */ RefreshLoadMoreLayout j(FinderTopicSearchUI finderTopicSearchUI) {
        AppMethodBeat.i(251402);
        RefreshLoadMoreLayout refreshLoadMoreLayout = finderTopicSearchUI.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        AppMethodBeat.o(251402);
        return refreshLoadMoreLayout;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEW_TYPE_DEFAULT", "", "VIEW_TYPE_FOLLOW_HEADER", "VIEW_TYPE_UN_FOLLOW_HEADER", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251398);
        AppMethodBeat.o(251398);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(251383);
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
        this.requestType = getIntent().getIntExtra("request_type", 4);
        this.vtF = getIntent().getBooleanExtra("need_history", false);
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
        if (this.vtF) {
            View findViewById = getContext().findViewById(R.id.dpq);
            p.g(findViewById, "context.findViewById<View>(R.id.history_lv)");
            findViewById.setVisibility(0);
            this.vtK = new h(this, new f(this));
        } else {
            View findViewById2 = getContext().findViewById(R.id.dpq);
            p.g(findViewById2, "context.findViewById<View>(R.id.history_lv)");
            findViewById2.setVisibility(8);
        }
        Log.i(TAG, "initData");
        View findViewById3 = getContext().findViewById(R.id.h8v);
        p.g(findViewById3, "context.findViewById(R.id.root)");
        this.lJI = findViewById3;
        View findViewById4 = getContext().findViewById(R.id.f6f);
        p.g(findViewById4, "context.findViewById(R.id.main_rv)");
        this.vtI = (CoordinatorLayout) findViewById4;
        View findViewById5 = getContext().findViewById(R.id.h7t);
        p.g(findViewById5, "context.findViewById(R.id.rl_layout)");
        this.tLS = (RefreshLoadMoreLayout) findViewById5;
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        this.hak = refreshLoadMoreLayout.getRecyclerView();
        View findViewById6 = getContext().findViewById(R.id.g01);
        p.g(findViewById6, "context.findViewById(R.id.no_result_tv)");
        this.vtJ = (TextView) findViewById6;
        View findViewById7 = getContext().findViewById(R.id.epl);
        p.g(findViewById7, "context.findViewById(R.id.loading_layout)");
        this.hSw = findViewById7;
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
        recyclerView2.setAdapter(new c(this, (byte) 0));
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
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.jKy, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView7, a2.axQ(), "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView7.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView7, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(251383);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.aks;
    }

    public final void onClickCancelBtn(View view) {
        AppMethodBeat.i(251384);
        hideVKB();
        finish();
        AppMethodBeat.o(251384);
    }

    @Override // com.tencent.mm.ui.search.a.b
    public final void onClickBackBtn(View view) {
        AppMethodBeat.i(251385);
        hideVKB();
        finish();
        AppMethodBeat.o(251385);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final boolean awE() {
        AppMethodBeat.i(251386);
        hideVKB();
        if (dpx()) {
            AppMethodBeat.o(251386);
            return true;
        }
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 9, 1, false);
        AppMethodBeat.o(251386);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        if (r0 == null) goto L_0x0024;
     */
    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r6, java.lang.String r7, java.util.List<com.tencent.mm.ui.search.a.c> r8, com.tencent.mm.ui.search.FTSEditTextView.b r9) {
        /*
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.FinderTopicSearchUI.a(java.lang.String, java.lang.String, java.util.List, com.tencent.mm.ui.search.FTSEditTextView$b):void");
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
        AppMethodBeat.i(251388);
        if (z) {
            com.tencent.mm.plugin.finder.report.l lVar = com.tencent.mm.plugin.finder.report.l.vfB;
            com.tencent.mm.plugin.finder.report.l.doe();
        }
        AppMethodBeat.o(251388);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void onClickClearTextBtn(View view) {
        AppMethodBeat.i(251389);
        com.tencent.mm.ui.search.a aVar = this.ubO;
        if (aVar == null) {
            p.btv("searchView");
        }
        aVar.getFtsEditText().awD();
        showVKB();
        AppMethodBeat.o(251389);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void dpw() {
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        RecyclerView.a adapter;
        bcb bcb;
        AppMethodBeat.i(251390);
        g.azz().b(3820, this);
        int dqc = dqc();
        int dqc2 = dqc();
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
                AppMethodBeat.o(251390);
                throw tVar;
            }
            LinkedList<bdu> linkedList = bcb.LLh;
            p.g(linkedList, "response.topicInfoList");
            LinkedList<bdu> linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
            Iterator<T> it = linkedList2.iterator();
            while (it.hasNext()) {
                arrayList.add(Boolean.valueOf(this.vtE.add(it.next())));
            }
            this.offset = bcb.offset;
            this.continueFlag = bcb.LLj;
            this.tVM = bcb.tVM;
            dqc2 = dqc();
            Log.i(TAG, "onSceneEnd " + bcb.offset + ' ' + bcb.continueFlag + ' ' + this.vtE.size());
        } else {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 11, 1, false);
        }
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout.apT(0);
        if (dqc2 == 0) {
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
            View view3 = this.lJI;
            if (view3 == null) {
                p.btv("rootView");
            }
            AppCompatActivity context = getContext();
            p.g(context, "context");
            view3.setBackground(context.getResources().getDrawable(R.color.f3043a));
        }
        if (dqc == 0) {
            RecyclerView recyclerView = this.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            RecyclerView.a adapter2 = recyclerView.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyDataSetChanged();
                AppMethodBeat.o(251390);
                return;
            }
            AppMethodBeat.o(251390);
            return;
        }
        if (dqc < dqc2) {
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 == null) {
                p.btv("recyclerView");
            }
            if (!(recyclerView2 == null || (adapter = recyclerView2.getAdapter()) == null)) {
                adapter.as(dqc, dqc2 - dqc);
                AppMethodBeat.o(251390);
                return;
            }
        }
        AppMethodBeat.o(251390);
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean enableActivityAnimation() {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(251391);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.s);
        AppMethodBeat.o(251391);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(251392);
        h hVar = this.vtK;
        if (hVar != null) {
            hVar.onDestroy();
        }
        ov(true);
        g.azz().b(3820, this);
        super.onDestroy();
        AppMethodBeat.o(251392);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
    static final class d implements View.OnTouchListener {
        final /* synthetic */ FinderTopicSearchUI vvw;

        d(FinderTopicSearchUI finderTopicSearchUI) {
            this.vvw = finderTopicSearchUI;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(251377);
            FinderTopicSearchUI.b(this.vvw).getFtsEditText().gUA();
            this.vvw.hideVKB();
            AppMethodBeat.o(251377);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
    public static final class e extends RefreshLoadMoreLayout.a {
        final /* synthetic */ FinderTopicSearchUI vvw;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(251379);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(251379);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(251381);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(251381);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(251380);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(251380);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderTopicSearchUI finderTopicSearchUI) {
            this.vvw = finderTopicSearchUI;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            View findViewById;
            TextView textView;
            TextView textView2;
            View findViewById2;
            TextView textView3;
            TextView textView4;
            AppMethodBeat.i(251378);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            FinderContactSearchIncludeFollowUI.a aVar = FinderContactSearchIncludeFollowUI.vtM;
            Log.i(FinderContactSearchIncludeFollowUI.TAG, "onLoadMoreBegin");
            String str = this.vvw.query;
            if (str != null) {
                if (this.vvw.continueFlag == 1) {
                    this.vvw.vtL = new cf(str, this.vvw.offset, this.vvw.dPI, this.vvw.tVM, this.vvw.requestType, (bbn) null, 96);
                    g.azz().b(this.vvw.vtL);
                    g.azz().a(3820, this.vvw);
                    View loadMoreFooter = FinderTopicSearchUI.j(this.vvw).getLoadMoreFooter();
                    if (!(loadMoreFooter == null || (textView4 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                        textView4.setText(R.string.d0l);
                    }
                    View loadMoreFooter2 = FinderTopicSearchUI.j(this.vvw).getLoadMoreFooter();
                    if (!(loadMoreFooter2 == null || (textView3 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                        textView3.setVisibility(0);
                    }
                    View loadMoreFooter3 = FinderTopicSearchUI.j(this.vvw).getLoadMoreFooter();
                    if (!(loadMoreFooter3 == null || (findViewById2 = loadMoreFooter3.findViewById(R.id.ep0)) == null)) {
                        findViewById2.setVisibility(8);
                    }
                } else {
                    View loadMoreFooter4 = FinderTopicSearchUI.j(this.vvw).getLoadMoreFooter();
                    if (!(loadMoreFooter4 == null || (textView2 = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                        textView2.setText(R.string.d0m);
                    }
                    View loadMoreFooter5 = FinderTopicSearchUI.j(this.vvw).getLoadMoreFooter();
                    if (!(loadMoreFooter5 == null || (textView = (TextView) loadMoreFooter5.findViewById(R.id.ep1)) == null)) {
                        textView.setVisibility(8);
                    }
                    View loadMoreFooter6 = FinderTopicSearchUI.j(this.vvw).getLoadMoreFooter();
                    if (!(loadMoreFooter6 == null || (findViewById = loadMoreFooter6.findViewById(R.id.ep0)) == null)) {
                        findViewById.setVisibility(0);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(251378);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        if (r0 == null) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean dpx() {
        /*
            r3 = this;
            r2 = 251393(0x3d601, float:3.52277E-40)
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
            com.tencent.mm.plugin.finder.search.h r1 = r3.vtK
            if (r1 == 0) goto L_0x0052
            r1.auX(r0)
        L_0x0052:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.FinderTopicSearchUI.dpx():boolean");
    }

    private final void auV(String str) {
        AppMethodBeat.i(251394);
        ov(true);
        this.query = str;
        this.offset = 0;
        this.continueFlag = 0;
        this.tVM = null;
        this.vtE.clear();
        String uuid = UUID.randomUUID().toString();
        p.g(uuid, "UUID.randomUUID().toString()");
        this.dPI = uuid;
        if (this.vtL != null) {
            g.azz().a(this.vtL);
        }
        this.vtL = new cf(str, this.offset, this.dPI, this.tVM, this.requestType, (bbn) null, 96);
        g.azz().b(this.vtL);
        g.azz().a(3820, this);
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
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(251394);
    }

    private final void ov(boolean z) {
        AppMethodBeat.i(251395);
        if (!Util.isNullOrNil(this.dPI)) {
            if (!this.vtH.isEmpty()) {
                com.tencent.mm.plugin.finder.report.l lVar = com.tencent.mm.plugin.finder.report.l.vfB;
                com.tencent.mm.plugin.finder.report.l.a(this.dPI, this.query, this.vtH, 2);
                if (z) {
                    this.vtH.clear();
                }
            }
        }
        AppMethodBeat.o(251395);
    }

    private final int dqc() {
        RecyclerView.a adapter;
        AppMethodBeat.i(251396);
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
            int size = this.vtE.size();
            AppMethodBeat.o(251396);
            return size;
        }
        int itemCount = adapter.getItemCount();
        AppMethodBeat.o(251396);
        return itemCount;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J&\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI$TopicSearchAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "requestType", "", "(Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI;I)V", "existFollowTopic", "", "getExistFollowTopic", "()Z", "setExistFollowTopic", "(Z)V", "getRequestType", "()I", "unFollowTopicIndex", "getUnFollowTopicIndex", "setUnFollowTopicIndex", "(I)V", "bindData", "", "holder", "position", "getItemCount", "getItemViewType", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
    public final class c extends RecyclerView.a<RecyclerView.v> {
        private final int requestType;
        private boolean vvx;
        private int vvy;

        /* JADX WARN: Incorrect types in method signature: (I)V */
        private c() {
            this.requestType = 4;
        }

        public /* synthetic */ c(FinderTopicSearchUI finderTopicSearchUI, byte b2) {
            this();
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(251371);
            p.h(viewGroup, "parent");
            switch (i2) {
                case 3:
                    AppCompatActivity context = FinderTopicSearchUI.this.getContext();
                    if (context == null) {
                        p.hyc();
                    }
                    View inflate = context.getLayoutInflater().inflate(R.layout.abq, viewGroup, false);
                    p.g(inflate, "contactLayout");
                    c cVar = new c(inflate);
                    AppMethodBeat.o(251371);
                    return cVar;
                default:
                    FinderTopicSearchUI finderTopicSearchUI = FinderTopicSearchUI.this;
                    AppCompatActivity context2 = FinderTopicSearchUI.this.getContext();
                    if (context2 == null) {
                        p.hyc();
                    }
                    View inflate2 = context2.getLayoutInflater().inflate(R.layout.ai7, viewGroup, false);
                    p.g(inflate2, "context!!.layoutInflater…ader_item, parent, false)");
                    b bVar = new b(finderTopicSearchUI, inflate2);
                    AppMethodBeat.o(251371);
                    return bVar;
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            boolean z;
            c cVar;
            AppMethodBeat.i(251372);
            if (this.requestType == 3 && FinderTopicSearchUI.this.vtE.size() != 0) {
                this.vvy = 0;
                this.vvx = false;
                Iterator it = FinderTopicSearchUI.this.vtE.iterator();
                while (it.hasNext()) {
                    bds bds = ((bdu) it.next()).dMU;
                    if (bds != null) {
                        z = bds.followFlag > 0;
                        cVar = this;
                    } else {
                        z = false;
                        cVar = this;
                    }
                    cVar.vvx = z;
                    if (!this.vvx) {
                        break;
                    }
                    this.vvy++;
                }
                if (this.vvx) {
                    if (this.vvy == FinderTopicSearchUI.this.vtE.size()) {
                        int size = FinderTopicSearchUI.this.vtE.size();
                        AppMethodBeat.o(251372);
                        return size;
                    }
                    int size2 = FinderTopicSearchUI.this.vtE.size() + 2;
                    AppMethodBeat.o(251372);
                    return size2;
                }
            }
            int size3 = FinderTopicSearchUI.this.vtE.size();
            AppMethodBeat.o(251372);
            return size3;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(251373);
            if (this.requestType == 4 && this.vvx) {
                if (this.vvy == FinderTopicSearchUI.this.vtE.size()) {
                    AppMethodBeat.o(251373);
                    return 3;
                } else if (i2 == 0) {
                    AppMethodBeat.o(251373);
                    return 1;
                } else if (i2 == this.vvy + 1) {
                    AppMethodBeat.o(251373);
                    return 2;
                }
            }
            AppMethodBeat.o(251373);
            return 3;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(251374);
            p.h(vVar, "holder");
            j(vVar, i2);
            AppMethodBeat.o(251374);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2, List<Object> list) {
            AppMethodBeat.i(251375);
            p.h(vVar, "holder");
            p.h(list, "payloads");
            j(vVar, i2);
            AppMethodBeat.o(251375);
        }

        private final void j(RecyclerView.v vVar, int i2) {
            bdu bdu;
            String str;
            AppMethodBeat.i(251376);
            if (!(vVar instanceof b)) {
                if (this.requestType != 4 || !this.vvx || this.vvy == FinderTopicSearchUI.this.vtE.size()) {
                    bdu = (bdu) FinderTopicSearchUI.this.vtE.get(i2);
                } else if (i2 < this.vvy + 1) {
                    bdu = (bdu) FinderTopicSearchUI.this.vtE.get(i2 - 1);
                } else {
                    bdu = (bdu) FinderTopicSearchUI.this.vtE.get(i2 - 2);
                }
                p.g(bdu, "if (requestType == Const…sition]\n                }");
                FinderTopicSearchUI finderTopicSearchUI = FinderTopicSearchUI.this;
                bds bds = bdu.dMU;
                if (bds == null || (str = bds.dST) == null) {
                    str = "";
                }
                FinderTopicSearchUI.a(finderTopicSearchUI, str, i2);
                bds bds2 = bdu.dMU;
                if (bds2 != null) {
                    View findViewById = vVar.aus.findViewById(R.id.d87);
                    p.g(findViewById, "holder.itemView.findView….follow_topic_news_title)");
                    View view = vVar.aus;
                    p.g(view, "holder.itemView");
                    ((TextView) findViewById).setText(com.tencent.mm.pluginsdk.ui.span.l.c(view.getContext(), bds2.dST));
                    View findViewById2 = vVar.aus.findViewById(R.id.d86);
                    p.g(findViewById2, "holder.itemView.findView….follow_topic_news_count)");
                    View view2 = vVar.aus;
                    p.g(view2, "holder.itemView");
                    ((TextView) findViewById2).setText(view2.getContext().getString(R.string.d33, k.gm(2, bds2.LzC)));
                    AppMethodBeat.o(251376);
                    return;
                }
                AppMethodBeat.o(251376);
            } else if (getItemViewType(i2) == 1) {
                ((b) vVar).titleTv.setText(FinderTopicSearchUI.this.getString(R.string.cjv));
                AppMethodBeat.o(251376);
            } else {
                ((b) vVar).titleTv.setText(FinderTopicSearchUI.this.getString(R.string.cjx));
                AppMethodBeat.o(251376);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
    public final class b extends RecyclerView.v {
        TextView titleTv;
        final /* synthetic */ FinderTopicSearchUI vvw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FinderTopicSearchUI finderTopicSearchUI, View view) {
            super(view);
            p.h(view, "itemView");
            this.vvw = finderTopicSearchUI;
            AppMethodBeat.i(251370);
            View findViewById = view.findViewById(R.id.ir3);
            p.g(findViewById, "itemView.findViewById(R.id.title_tv)");
            this.titleTv = (TextView) findViewById;
            AppMethodBeat.o(251370);
        }
    }

    public static final /* synthetic */ void a(FinderTopicSearchUI finderTopicSearchUI, String str, int i2) {
        AppMethodBeat.i(251399);
        if (!finderTopicSearchUI.vtH.containsKey(str)) {
            Log.d(TAG, "addExposeItem " + str + ' ' + i2 + ' ' + 1);
            a aVar = new a();
            aVar.setId(str);
            aVar.position = i2;
            aVar.type = 1;
            aVar.timeStamp = System.currentTimeMillis();
            finderTopicSearchUI.vtH.put(str, aVar);
            if (finderTopicSearchUI.vtH.size() % 30 == 0) {
                finderTopicSearchUI.ov(false);
            }
        }
        AppMethodBeat.o(251399);
    }
}
