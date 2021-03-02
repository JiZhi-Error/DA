package com.tencent.mm.plugin.finder.search;

import android.content.Intent;
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
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.bcb;
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
@l(hxD = {1, 1, 16}, hxE = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003\\]^B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000bJ\b\u00102\u001a\u00020\u0011H\u0016J\b\u00103\u001a\u00020.H\u0016J\b\u00104\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020\u000bH\u0014J\b\u00106\u001a\u00020\u0011H\u0002J\b\u00107\u001a\u00020.H\u0002J\b\u00108\u001a\u00020.H\u0002J\b\u00109\u001a\u00020.H\u0002J\b\u0010:\u001a\u00020\u0011H\u0002J\u0012\u0010;\u001a\u00020.2\b\u0010<\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010=\u001a\u00020.2\b\u0010<\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010>\u001a\u00020.2\b\u0010<\u001a\u0004\u0018\u00010\u0018H\u0016J\u0016\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\b2\u0006\u00100\u001a\u00020\u000bJ\u0012\u0010A\u001a\u00020.2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u00020.H\u0014J6\u0010E\u001a\u00020.2\b\u0010F\u001a\u0004\u0018\u00010\u000e2\b\u0010G\u001a\u0004\u0018\u00010\u000e2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010I2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020\u0011H\u0016J,\u0010O\u001a\u00020.2\u0006\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u000b2\b\u0010R\u001a\u0004\u0018\u00010\u000e2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\b\u0010U\u001a\u00020\u0011H\u0016J\u001a\u0010V\u001a\u00020.2\u0006\u0010W\u001a\u00020\u000b2\b\u0010X\u001a\u0004\u0018\u00010JH\u0016J\u0012\u0010Y\u001a\u00020.2\b\b\u0002\u0010Z\u001a\u00020\u0011H\u0002J\u0010\u0010[\u001a\u00020.2\u0006\u0010!\u001a\u00020\u000eH\u0002R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u0012\u0012\u0004\u0012\u00020,0\u0007j\b\u0012\u0004\u0012\u00020,`\tX\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroid/support/design/widget/CoordinatorLayout;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", SearchIntents.EXTRA_QUERY, "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "topicList", "Lcom/tencent/mm/protocal/protobuf/FinderTopicSearchInfo;", "addExposeItem", "", "id", "position", "type", "enableActivityAnimation", "finish", "getContactSize", "getLayoutId", "handleSearch", "initContentView", "initData", "initSearchView", "isTopicSearch", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", FirebaseAnalytics.b.INDEX, "tag", "reportSearchExpose", "needClear", "startSearch", "Companion", "ContactSearchProfileAdapter", "HeaderViewHolder", "plugin-finder_release"})
public final class FinderContactSearchIncludeFollowUI extends MMActivity implements i, FTSEditTextView.a, a.b {
    static final String TAG = TAG;
    public static final a vtM = new a((byte) 0);
    private HashMap _$_findViewCache;
    private int continueFlag;
    String dPI = "";
    private View hSw;
    private RecyclerView hak;
    private int jKy;
    private View lJI;
    private int offset;
    String query = "";
    private int requestType;
    private RefreshLoadMoreLayout tLS;
    private com.tencent.mm.bw.b tVM;
    private ArrayList<bbz> uae = new ArrayList<>();
    private com.tencent.mm.ui.search.a ubO;
    private ArrayList<bdu> vtE = new ArrayList<>();
    private boolean vtF = true;
    boolean vtG;
    HashMap<String, a> vtH = new HashMap<>();
    private CoordinatorLayout vtI;
    private TextView vtJ;
    private h vtK;
    private cf vtL;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(251246);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(251246);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(251245);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(251245);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class f extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderContactSearchIncludeFollowUI vtP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderContactSearchIncludeFollowUI finderContactSearchIncludeFollowUI) {
            super(1);
            this.vtP = finderContactSearchIncludeFollowUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(251225);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            FinderContactSearchIncludeFollowUI.b(this.vtP).getFtsEditText().O(str2, null);
            FinderContactSearchIncludeFollowUI.a(this.vtP, str2);
            x xVar = x.SXb;
            AppMethodBeat.o(251225);
            return xVar;
        }
    }

    public FinderContactSearchIncludeFollowUI() {
        AppMethodBeat.i(251240);
        AppMethodBeat.o(251240);
    }

    public static final /* synthetic */ void a(FinderContactSearchIncludeFollowUI finderContactSearchIncludeFollowUI, String str) {
        AppMethodBeat.i(251243);
        finderContactSearchIncludeFollowUI.auV(str);
        AppMethodBeat.o(251243);
    }

    public static final /* synthetic */ com.tencent.mm.ui.search.a b(FinderContactSearchIncludeFollowUI finderContactSearchIncludeFollowUI) {
        AppMethodBeat.i(251242);
        com.tencent.mm.ui.search.a aVar = finderContactSearchIncludeFollowUI.ubO;
        if (aVar == null) {
            p.btv("searchView");
        }
        AppMethodBeat.o(251242);
        return aVar;
    }

    public static final /* synthetic */ RefreshLoadMoreLayout j(FinderContactSearchIncludeFollowUI finderContactSearchIncludeFollowUI) {
        AppMethodBeat.i(251244);
        RefreshLoadMoreLayout refreshLoadMoreLayout = finderContactSearchIncludeFollowUI.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        AppMethodBeat.o(251244);
        return refreshLoadMoreLayout;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEW_TYPE_DEFAULT", "", "VIEW_TYPE_FOLLOW_HEADER", "VIEW_TYPE_UN_FOLLOW_HEADER", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251241);
        AppMethodBeat.o(251241);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(251226);
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
        this.requestType = getIntent().getIntExtra("request_type", 3);
        this.vtG = getIntent().getBooleanExtra("from_at_contact", false);
        this.vtF = getIntent().getBooleanExtra("need_history", false);
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
            View findViewById = getContext().findViewById(R.id.dpq);
            p.g(findViewById, "context.findViewById<View>(R.id.history_lv)");
            findViewById.setVisibility(0);
            this.vtK = new h(this, new f(this));
        } else {
            View findViewById2 = getContext().findViewById(R.id.dpq);
            p.g(findViewById2, "context.findViewById<View>(R.id.history_lv)");
            findViewById2.setVisibility(8);
        }
        if (this.vtG) {
            setResult(0, getIntent());
        }
        Log.i(TAG, "fromAtContact:%s", Boolean.valueOf(this.vtG));
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
        recyclerView2.setAdapter(new b(this, (byte) 0));
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
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView7, a2.axQ(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView7.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView7, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(251226);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
    static final class d implements View.OnTouchListener {
        final /* synthetic */ FinderContactSearchIncludeFollowUI vtP;

        d(FinderContactSearchIncludeFollowUI finderContactSearchIncludeFollowUI) {
            this.vtP = finderContactSearchIncludeFollowUI;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(251220);
            FinderContactSearchIncludeFollowUI.b(this.vtP).getFtsEditText().gUA();
            this.vtP.hideVKB();
            AppMethodBeat.o(251220);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
    public static final class e extends RefreshLoadMoreLayout.a {
        final /* synthetic */ FinderContactSearchIncludeFollowUI vtP;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(251222);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(251222);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(251224);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(251224);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(251223);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(251223);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderContactSearchIncludeFollowUI finderContactSearchIncludeFollowUI) {
            this.vtP = finderContactSearchIncludeFollowUI;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            View findViewById;
            TextView textView;
            TextView textView2;
            View findViewById2;
            TextView textView3;
            TextView textView4;
            AppMethodBeat.i(251221);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            a aVar = FinderContactSearchIncludeFollowUI.vtM;
            Log.i(FinderContactSearchIncludeFollowUI.TAG, "onLoadMoreBegin");
            String str = this.vtP.query;
            if (str != null) {
                if (this.vtP.continueFlag == 1) {
                    this.vtP.vtL = new cf(str, this.vtP.offset, this.vtP.dPI, this.vtP.tVM, this.vtP.requestType, (bbn) null, 96);
                    g.azz().b(this.vtP.vtL);
                    g.azz().a(3820, this.vtP);
                    View loadMoreFooter = FinderContactSearchIncludeFollowUI.j(this.vtP).getLoadMoreFooter();
                    if (!(loadMoreFooter == null || (textView4 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                        textView4.setText(R.string.d0l);
                    }
                    View loadMoreFooter2 = FinderContactSearchIncludeFollowUI.j(this.vtP).getLoadMoreFooter();
                    if (!(loadMoreFooter2 == null || (textView3 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                        textView3.setVisibility(0);
                    }
                    View loadMoreFooter3 = FinderContactSearchIncludeFollowUI.j(this.vtP).getLoadMoreFooter();
                    if (!(loadMoreFooter3 == null || (findViewById2 = loadMoreFooter3.findViewById(R.id.ep0)) == null)) {
                        findViewById2.setVisibility(8);
                    }
                } else {
                    View loadMoreFooter4 = FinderContactSearchIncludeFollowUI.j(this.vtP).getLoadMoreFooter();
                    if (!(loadMoreFooter4 == null || (textView2 = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                        textView2.setText(R.string.d0m);
                    }
                    View loadMoreFooter5 = FinderContactSearchIncludeFollowUI.j(this.vtP).getLoadMoreFooter();
                    if (!(loadMoreFooter5 == null || (textView = (TextView) loadMoreFooter5.findViewById(R.id.ep1)) == null)) {
                        textView.setVisibility(8);
                    }
                    View loadMoreFooter6 = FinderContactSearchIncludeFollowUI.j(this.vtP).getLoadMoreFooter();
                    if (!(loadMoreFooter6 == null || (findViewById = loadMoreFooter6.findViewById(R.id.ep0)) == null)) {
                        findViewById.setVisibility(0);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(251221);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a_0;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean enableActivityAnimation() {
        return false;
    }

    @Override // com.tencent.mm.ui.search.a.b
    public final void onClickBackBtn(View view) {
        AppMethodBeat.i(251227);
        hideVKB();
        finish();
        AppMethodBeat.o(251227);
    }

    public final void onClickCancelBtn(View view) {
        AppMethodBeat.i(251228);
        hideVKB();
        finish();
        AppMethodBeat.o(251228);
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
        // Method dump skipped, instructions count: 103
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI.a(java.lang.String, java.lang.String, java.util.List, com.tencent.mm.ui.search.FTSEditTextView$b):void");
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
        AppMethodBeat.i(251230);
        if (z) {
            com.tencent.mm.plugin.finder.report.l lVar = com.tencent.mm.plugin.finder.report.l.vfB;
            com.tencent.mm.plugin.finder.report.l.doe();
        }
        AppMethodBeat.o(251230);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void onClickClearTextBtn(View view) {
        AppMethodBeat.i(251231);
        com.tencent.mm.ui.search.a aVar = this.ubO;
        if (aVar == null) {
            p.btv("searchView");
        }
        aVar.getFtsEditText().awD();
        showVKB();
        AppMethodBeat.o(251231);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final boolean awE() {
        AppMethodBeat.i(251232);
        hideVKB();
        if (dpx()) {
            AppMethodBeat.o(251232);
            return true;
        }
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 9, 1, false);
        AppMethodBeat.o(251232);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        if (r0 == null) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean dpx() {
        /*
            r3 = this;
            r2 = 251233(0x3d561, float:3.52052E-40)
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI.dpx():boolean");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(251234);
        h hVar = this.vtK;
        if (hVar != null) {
            hVar.onDestroy();
        }
        ov(true);
        g.azz().b(3820, this);
        super.onDestroy();
        AppMethodBeat.o(251234);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(251235);
        super.finish();
        overridePendingTransition(R.anim.s, R.anim.s);
        AppMethodBeat.o(251235);
    }

    private final void auV(String str) {
        AppMethodBeat.i(251236);
        ov(true);
        this.query = str;
        this.offset = 0;
        this.continueFlag = 0;
        this.tVM = null;
        if (this.requestType == 4) {
            this.vtE.clear();
        } else {
            this.uae.clear();
        }
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
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
        View view2 = this.lJI;
        if (view2 == null) {
            p.btv("rootView");
        }
        AppCompatActivity context = getContext();
        p.g(context, "context");
        view2.setBackground(context.getResources().getDrawable(R.color.f3043a));
        AppMethodBeat.o(251236);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        RecyclerView.a adapter;
        bcb bcb;
        AppMethodBeat.i(251237);
        g.azz().b(3820, this);
        int dpy = dpy();
        int dpy2 = dpy();
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
                AppMethodBeat.o(251237);
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
            dpy2 = dpy();
            Log.i(TAG, "onSceneEnd " + bcb.offset + ' ' + bcb.continueFlag + ' ' + this.uae.size());
        } else {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 11, 1, false);
        }
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout.apT(0);
        if (dpy2 == 0) {
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
        if (dpy == 0) {
            RecyclerView recyclerView = this.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            RecyclerView.a adapter2 = recyclerView.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyDataSetChanged();
                AppMethodBeat.o(251237);
                return;
            }
            AppMethodBeat.o(251237);
            return;
        }
        if (dpy < dpy2) {
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 == null) {
                p.btv("recyclerView");
            }
            if (!(recyclerView2 == null || (adapter = recyclerView2.getAdapter()) == null)) {
                adapter.as(dpy, dpy2 - dpy);
                AppMethodBeat.o(251237);
                return;
            }
        }
        AppMethodBeat.o(251237);
    }

    private final int dpy() {
        RecyclerView.a adapter;
        AppMethodBeat.i(251238);
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
            int size = this.uae.size();
            AppMethodBeat.o(251238);
            return size;
        }
        int itemCount = adapter.getItemCount();
        AppMethodBeat.o(251238);
        return itemCount;
    }

    /* access modifiers changed from: package-private */
    public final void ov(boolean z) {
        AppMethodBeat.i(251239);
        if (!Util.isNullOrNil(this.dPI)) {
            if (!this.vtH.isEmpty()) {
                com.tencent.mm.plugin.finder.report.l lVar = com.tencent.mm.plugin.finder.report.l.vfB;
                com.tencent.mm.plugin.finder.report.l.a(this.dPI, this.query, this.vtH, 2);
                if (z) {
                    this.vtH.clear();
                }
            }
        }
        AppMethodBeat.o(251239);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J&\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "requestType", "", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;I)V", "existFollowContact", "", "getExistFollowContact", "()Z", "setExistFollowContact", "(Z)V", "getRequestType", "()I", "unFollowContactIndex", "getUnFollowContactIndex", "setUnFollowContactIndex", "(I)V", "bindData", "", "holder", "position", "bindImage", "getItemCount", "getItemViewType", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
    public final class b extends RecyclerView.a<RecyclerView.v> {
        private final int requestType;
        private boolean vtN;
        private int vtO;

        /* JADX WARN: Incorrect types in method signature: (I)V */
        private b() {
            this.requestType = 3;
        }

        public /* synthetic */ b(FinderContactSearchIncludeFollowUI finderContactSearchIncludeFollowUI, byte b2) {
            this();
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            String str;
            AppMethodBeat.i(251213);
            if (this.requestType == 3 && FinderContactSearchIncludeFollowUI.this.uae.size() != 0) {
                this.vtO = 0;
                this.vtN = false;
                Iterator it = FinderContactSearchIncludeFollowUI.this.uae.iterator();
                while (it.hasNext()) {
                    bbz bbz = (bbz) it.next();
                    a aVar = FinderContactSearchIncludeFollowUI.vtM;
                    String str2 = FinderContactSearchIncludeFollowUI.TAG;
                    StringBuilder sb = new StringBuilder("getItemCount isFollow:");
                    FinderContact finderContact = bbz.contact;
                    Log.i(str2, sb.append(finderContact != null ? finderContact.username : null).toString());
                    c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                    FinderContact finderContact2 = bbz.contact;
                    if (finderContact2 != null) {
                        str = finderContact2.username;
                    } else {
                        str = null;
                    }
                    if (!c.a.asJ(str)) {
                        break;
                    }
                    this.vtN = true;
                    this.vtO++;
                }
                if (this.vtN) {
                    if (this.vtO == FinderContactSearchIncludeFollowUI.this.uae.size()) {
                        int size = FinderContactSearchIncludeFollowUI.this.uae.size();
                        AppMethodBeat.o(251213);
                        return size;
                    }
                    int size2 = FinderContactSearchIncludeFollowUI.this.uae.size() + 2;
                    AppMethodBeat.o(251213);
                    return size2;
                }
            }
            int size3 = FinderContactSearchIncludeFollowUI.this.uae.size();
            AppMethodBeat.o(251213);
            return size3;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(251214);
            if (this.requestType == 3 && this.vtN) {
                if (this.vtO == FinderContactSearchIncludeFollowUI.this.uae.size()) {
                    AppMethodBeat.o(251214);
                    return 3;
                } else if (i2 == 0) {
                    AppMethodBeat.o(251214);
                    return 1;
                } else if (i2 == this.vtO + 1) {
                    AppMethodBeat.o(251214);
                    return 2;
                }
            }
            AppMethodBeat.o(251214);
            return 3;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(251215);
            p.h(viewGroup, "parent");
            switch (i2) {
                case 3:
                    AppCompatActivity context = FinderContactSearchIncludeFollowUI.this.getContext();
                    if (context == null) {
                        p.hyc();
                    }
                    View inflate = context.getLayoutInflater().inflate(R.layout.a_1, viewGroup, false);
                    p.g(inflate, "contactLayout");
                    c cVar = new c(inflate);
                    AppMethodBeat.o(251215);
                    return cVar;
                default:
                    FinderContactSearchIncludeFollowUI finderContactSearchIncludeFollowUI = FinderContactSearchIncludeFollowUI.this;
                    AppCompatActivity context2 = FinderContactSearchIncludeFollowUI.this.getContext();
                    if (context2 == null) {
                        p.hyc();
                    }
                    View inflate2 = context2.getLayoutInflater().inflate(R.layout.ai7, viewGroup, false);
                    p.g(inflate2, "context!!.layoutInflater…ader_item, parent, false)");
                    c cVar2 = new c(finderContactSearchIncludeFollowUI, inflate2);
                    AppMethodBeat.o(251215);
                    return cVar2;
            }
        }

        private final void i(RecyclerView.v vVar, int i2) {
            bbz bbz;
            String str;
            String str2;
            boolean z = true;
            AppMethodBeat.i(251217);
            if (!(vVar instanceof c)) {
                if (this.requestType != 3 || !this.vtN || this.vtO == FinderContactSearchIncludeFollowUI.this.uae.size()) {
                    bbz = (bbz) FinderContactSearchIncludeFollowUI.this.uae.get(i2);
                } else if (i2 < this.vtO + 1) {
                    bbz = (bbz) FinderContactSearchIncludeFollowUI.this.uae.get(i2 - 1);
                } else {
                    bbz = (bbz) FinderContactSearchIncludeFollowUI.this.uae.get(i2 - 2);
                }
                p.g(bbz, "if (requestType == Const…sition]\n                }");
                FinderContactSearchIncludeFollowUI finderContactSearchIncludeFollowUI = FinderContactSearchIncludeFollowUI.this;
                FinderContact finderContact = bbz.contact;
                if (finderContact == null || (str2 = finderContact.username) == null) {
                    str = "";
                } else {
                    str = str2;
                }
                p.h(str, "id");
                if (!finderContactSearchIncludeFollowUI.vtH.containsKey(str)) {
                    Log.d(FinderContactSearchIncludeFollowUI.TAG, "addExposeItem " + str + ' ' + i2 + ' ' + 1);
                    a aVar = new a();
                    aVar.setId(str);
                    aVar.position = i2;
                    aVar.type = 1;
                    aVar.timeStamp = System.currentTimeMillis();
                    finderContactSearchIncludeFollowUI.vtH.put(str, aVar);
                    if (finderContactSearchIncludeFollowUI.vtH.size() % 30 == 0) {
                        finderContactSearchIncludeFollowUI.ov(false);
                    }
                }
                if (vVar == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
                    AppMethodBeat.o(251217);
                    throw tVar;
                }
                c cVar = (c) vVar;
                a aVar2 = new a(this, i2);
                if (i2 == 0) {
                    z = false;
                }
                c.a(cVar, bbz, aVar2, z, 4);
                View findViewById = vVar.aus.findViewById(R.id.d88);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                    AppMethodBeat.o(251217);
                    return;
                }
                AppMethodBeat.o(251217);
            } else if (getItemViewType(i2) == 1) {
                ((c) vVar).titleTv.setText(FinderContactSearchIncludeFollowUI.this.getString(R.string.cju));
                AppMethodBeat.o(251217);
            } else {
                ((c) vVar).titleTv.setText(FinderContactSearchIncludeFollowUI.this.getString(R.string.cjw));
                AppMethodBeat.o(251217);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class a implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ b vtQ;

            a(b bVar, int i2) {
                this.vtQ = bVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                String str;
                String str2;
                String str3;
                AppMethodBeat.i(251212);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                p.g(view, LocaleUtil.ITALIAN);
                Object tag = view.getTag();
                if (tag == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
                    AppMethodBeat.o(251212);
                    throw tVar;
                }
                bbz bbz = (bbz) tag;
                FinderContactSearchIncludeFollowUI finderContactSearchIncludeFollowUI = FinderContactSearchIncludeFollowUI.this;
                int i2 = this.gUj;
                p.h(bbz, "finderSearchInfo");
                if (finderContactSearchIncludeFollowUI.vtG) {
                    Log.i(FinderContactSearchIncludeFollowUI.TAG, "onContactItemClick select atContact");
                    com.tencent.mm.plugin.finder.utils.d dVar = com.tencent.mm.plugin.finder.utils.d.vVg;
                    FinderContact finderContact = bbz.contact;
                    if (finderContact == null) {
                        finderContact = new FinderContact();
                    }
                    finderContactSearchIncludeFollowUI.getIntent().putExtra("at_select_contact", com.tencent.mm.plugin.finder.utils.d.e(finderContact).toByteArray());
                    Intent intent = finderContactSearchIncludeFollowUI.getIntent();
                    c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                    FinderContact finderContact2 = bbz.contact;
                    intent.putExtra("is_follow", c.a.asJ(finderContact2 != null ? finderContact2.username : null));
                    finderContactSearchIncludeFollowUI.setResult(-1, finderContactSearchIncludeFollowUI.getIntent());
                    finderContactSearchIncludeFollowUI.finish();
                } else {
                    Intent intent2 = new Intent();
                    FinderContact finderContact3 = bbz.contact;
                    if (finderContact3 == null || (str = finderContact3.username) == null) {
                        str = "";
                    }
                    intent2.putExtra("finder_username", str);
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    AppCompatActivity context = finderContactSearchIncludeFollowUI.getContext();
                    p.g(context, "context");
                    FinderReporterUIC.a.a(context, intent2, 0, 7, false, 64);
                    com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                    AppCompatActivity context2 = finderContactSearchIncludeFollowUI.getContext();
                    p.g(context2, "context");
                    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context2, intent2);
                    com.tencent.mm.plugin.finder.report.l lVar = com.tencent.mm.plugin.finder.report.l.vfB;
                    String str4 = finderContactSearchIncludeFollowUI.dPI;
                    String str5 = finderContactSearchIncludeFollowUI.query;
                    FinderContact finderContact4 = bbz.contact;
                    if (finderContact4 != null) {
                        str2 = finderContact4.username;
                    } else {
                        str2 = null;
                    }
                    com.tencent.mm.plugin.finder.report.l.e(str4, str5, str2, i2);
                    FinderReporterUIC.a aVar4 = FinderReporterUIC.wzC;
                    AppCompatActivity context3 = finderContactSearchIncludeFollowUI.getContext();
                    p.g(context3, "context");
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(context3);
                    if (fH != null) {
                        k kVar = k.vfA;
                        int i3 = fH.tCE;
                        FinderContact finderContact5 = bbz.contact;
                        if (finderContact5 != null) {
                            str3 = finderContact5.username;
                        } else {
                            str3 = null;
                        }
                        k.a(6, 0, i3, 1, str3);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(251212);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2, List<Object> list) {
            AppMethodBeat.i(251216);
            p.h(vVar, "holder");
            p.h(list, "payloads");
            i(vVar, i2);
            AppMethodBeat.o(251216);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            AppMethodBeat.i(251218);
            p.h(vVar, "holder");
            i(vVar, i2);
            AppMethodBeat.o(251218);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
    public final class c extends RecyclerView.v {
        TextView titleTv;
        final /* synthetic */ FinderContactSearchIncludeFollowUI vtP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(FinderContactSearchIncludeFollowUI finderContactSearchIncludeFollowUI, View view) {
            super(view);
            p.h(view, "itemView");
            this.vtP = finderContactSearchIncludeFollowUI;
            AppMethodBeat.i(251219);
            View findViewById = view.findViewById(R.id.ir3);
            p.g(findViewById, "itemView.findViewById(R.id.title_tv)");
            this.titleTv = (TextView) findViewById;
            AppMethodBeat.o(251219);
        }
    }
}
