package com.tencent.mm.plugin.finder.feed.ui;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.cgi.bl;
import com.tencent.mm.plugin.finder.cgi.r;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMProcessBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 E2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001EB\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020\u0007H\u0014J\b\u0010+\u001a\u00020'H\u0014J\u001e\u0010,\u001a\u00020'2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0.2\u0006\u0010/\u001a\u00020\u001aH\u0002J\b\u00100\u001a\u00020'H\u0016J\u0012\u00101\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020'H\u0014J\u0018\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u000208H\u0016J,\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0006\u0010@\u001a\u00020'J\u0006\u0010A\u001a\u00020'J\u0006\u0010B\u001a\u00020'J\u0006\u0010C\u001a\u00020'J\b\u0010D\u001a\u00020'H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "MENU_BLACK_LIST", "", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "listView", "Landroid/widget/ListView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "totalCount", "addNoMoreView", "", "checkFinish", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderFriendRecommendUI extends MMFinderUI implements com.tencent.mm.ak.i, ai<ayt> {
    private static final String TAG = TAG;
    public static final a uaU = new a((byte) 0);
    private HashMap _$_findViewCache;
    private long feedId;
    private int gAZ;
    private TextView hRM;
    private boolean hasMore;
    private ListView krb;
    private IListener<hh> tOh;
    private com.tencent.mm.bw.b tsO;
    private MMProcessBar uaO;
    private TextView uaP;
    private final com.tencent.mm.plugin.finder.ui.d uaQ = new com.tencent.mm.plugin.finder.ui.d(this);
    private bfp uaR;
    private boolean uaS;
    private final int uaT = 2;
    private final ArrayList<aul> uae = new ArrayList<>();

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245288);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245288);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245287);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245287);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<aul, x> {
        final /* synthetic */ FinderFriendRecommendUI uaV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderFriendRecommendUI finderFriendRecommendUI) {
            super(1);
            this.uaV = finderFriendRecommendUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(aul aul) {
            AppMethodBeat.i(245265);
            aul aul2 = aul;
            p.h(aul2, "likeInfo");
            new r(FinderFriendRecommendUI.d(this.uaV), aul2, FinderFriendRecommendUI.d(this.uaV).ttO).aYI();
            x xVar = x.SXb;
            AppMethodBeat.o(245265);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<aul, x> {
        final /* synthetic */ FinderFriendRecommendUI uaV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderFriendRecommendUI finderFriendRecommendUI) {
            super(1);
            this.uaV = finderFriendRecommendUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(aul aul) {
            ay ayVar;
            AppMethodBeat.i(245266);
            aul aul2 = aul;
            p.h(aul2, "likeInfo");
            if (aul2.LFn == 1) {
                String str = aul2.dMW;
                ay.a aVar = ay.tuW;
                ayVar = new ay(str, ay.tuU, FinderFriendRecommendUI.d(this.uaV).scene);
            } else {
                String str2 = aul2.dMW;
                ay.a aVar2 = ay.tuW;
                ayVar = new ay(str2, ay.tuV, FinderFriendRecommendUI.d(this.uaV).scene);
            }
            ayVar.ttq = aul2;
            com.tencent.mm.kernel.g.azz().b(ayVar);
            x xVar = x.SXb;
            AppMethodBeat.o(245266);
            return xVar;
        }
    }

    public FinderFriendRecommendUI() {
        AppMethodBeat.i(245281);
        AppMethodBeat.o(245281);
    }

    public static final /* synthetic */ void a(FinderFriendRecommendUI finderFriendRecommendUI) {
        AppMethodBeat.i(245283);
        finderFriendRecommendUI.ddW();
        AppMethodBeat.o(245283);
    }

    public static final /* synthetic */ void c(FinderFriendRecommendUI finderFriendRecommendUI) {
        AppMethodBeat.i(245284);
        finderFriendRecommendUI.ddX();
        AppMethodBeat.o(245284);
    }

    public static final /* synthetic */ bfp d(FinderFriendRecommendUI finderFriendRecommendUI) {
        AppMethodBeat.i(245285);
        bfp bfp = finderFriendRecommendUI.uaR;
        if (bfp == null) {
            p.btv("actionInfo");
        }
        AppMethodBeat.o(245285);
        return bfp;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
    @Override // com.tencent.mm.plugin.i.a.ai
    public final /* synthetic */ void a(ayt ayt, apg apg) {
        AppMethodBeat.i(245276);
        p.h(ayt, "req");
        p.h(apg, "ret");
        AppMethodBeat.o(245276);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(245282);
        AppMethodBeat.o(245282);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245271);
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.azz().a(3593, this);
        com.tencent.mm.kernel.g.azz().a(3638, this);
        try {
            com.tencent.mm.bw.a parseFrom = new bfp().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
            if (parseFrom == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
                AppMethodBeat.o(245271);
                throw tVar;
            }
            this.uaR = (bfp) parseFrom;
            this.feedId = getIntent().getLongExtra("FEED_ID", 0);
            if (this.feedId == 0) {
                finish();
                Log.w(TAG, "feedId is 0, invalid!");
                AppMethodBeat.o(245271);
                return;
            }
            this.gAZ = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
            this.uaS = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
            initView();
            ddX();
            AppMethodBeat.o(245271);
        } catch (Throwable th) {
            finish();
            Log.w(TAG, "actionInfo invalid!");
            AppMethodBeat.o(245271);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(245272);
        View findViewById = findViewById(R.id.cmp);
        p.g(findViewById, "findViewById(R.id.finder_liked_list)");
        this.krb = (ListView) findViewById;
        View findViewById2 = findViewById(R.id.c35);
        p.g(findViewById2, "findViewById(R.id.empty_tip)");
        this.hRM = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.ep_);
        p.g(findViewById3, "findViewById(R.id.loading_bar)");
        this.uaO = (MMProcessBar) findViewById3;
        View findViewById4 = findViewById(R.id.h5x);
        p.g(findViewById4, "findViewById(R.id.retry_tips)");
        this.uaP = (TextView) findViewById4;
        updateTitle();
        setBackBtn(new b(this));
        ListView listView = this.krb;
        if (listView == null) {
            p.btv("listView");
        }
        listView.setAdapter((ListAdapter) this.uaQ);
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
        TextView textView = this.uaP;
        if (textView == null) {
            p.btv("retryTips");
        }
        textView.setOnClickListener(new d(this));
        this.uaQ.tBx = new e(this);
        this.uaQ.tBy = new f(this);
        addIconOptionMenu(this.uaT, -1, R.raw.actionbar_icon_dark_more, new g(this));
        this.tOh = new h(this);
        EventCenter.instance.add(this.tOh);
        TextView textView2 = this.hRM;
        if (textView2 == null) {
            p.btv("emptyTip");
        }
        textView2.setVisibility(8);
        ListView listView4 = this.krb;
        if (listView4 == null) {
            p.btv("listView");
        }
        listView4.setVisibility(8);
        MMProcessBar mMProcessBar = this.uaO;
        if (mMProcessBar == null) {
            p.btv("loadingBar");
        }
        mMProcessBar.setVisibility(0);
        TextView textView3 = this.uaP;
        if (textView3 == null) {
            p.btv("retryTips");
        }
        textView3.setVisibility(8);
        AppMethodBeat.o(245272);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderFriendRecommendUI uaV;

        b(FinderFriendRecommendUI finderFriendRecommendUI) {
            this.uaV = finderFriendRecommendUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245262);
            FinderFriendRecommendUI.a(this.uaV);
            this.uaV.finish();
            AppMethodBeat.o(245262);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
    public static final class c implements AbsListView.OnScrollListener {
        final /* synthetic */ FinderFriendRecommendUI uaV;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderFriendRecommendUI finderFriendRecommendUI) {
            this.uaV = finderFriendRecommendUI;
        }

        public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i2) {
            AppMethodBeat.i(245263);
            if (i2 == 0 && absListView != null && !absListView.canScrollVertically(1)) {
                if (this.uaV.hasMore) {
                    FinderFriendRecommendUI.c(this.uaV);
                    AppMethodBeat.o(245263);
                    return;
                }
                this.uaV.ddY();
            }
            AppMethodBeat.o(245263);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ FinderFriendRecommendUI uaV;

        d(FinderFriendRecommendUI finderFriendRecommendUI) {
            this.uaV = finderFriendRecommendUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245264);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderFriendRecommendUI.c(this.uaV);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245264);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class g implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderFriendRecommendUI uaV;

        g(FinderFriendRecommendUI finderFriendRecommendUI) {
            this.uaV = finderFriendRecommendUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245267);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            AppCompatActivity context = this.uaV.getContext();
            p.g(context, "context");
            com.tencent.mm.plugin.finder.utils.a.fx(context);
            AppMethodBeat.o(245267);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class h extends IListener<hh> {
        final /* synthetic */ FinderFriendRecommendUI uaV;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(FinderFriendRecommendUI finderFriendRecommendUI) {
            this.uaV = finderFriendRecommendUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hh hhVar) {
            AppMethodBeat.i(245269);
            hh hhVar2 = hhVar;
            if (hhVar2 != null) {
                com.tencent.mm.ac.d.h(new a(this, hhVar2));
            }
            AppMethodBeat.o(245269);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7$callback$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ h uaW;
            final /* synthetic */ hh uaX;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(h hVar, hh hhVar) {
                super(0);
                this.uaW = hVar;
                this.uaX = hhVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                aul aul;
                AppMethodBeat.i(245268);
                com.tencent.mm.plugin.finder.ui.d dVar = this.uaW.uaV.uaQ;
                hh hhVar = this.uaX;
                p.h(hhVar, "likeEvent");
                int size = dVar.kgc.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        aul = null;
                        break;
                    } else if (p.j(hhVar.dLL.dLN, dVar.kgc.get(i2).dMW)) {
                        aul = dVar.kgc.get(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (aul != null) {
                    aul.LFn = hhVar.dLL.dLM;
                    dVar.notifyDataSetChanged();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(245268);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(245273);
        ddW();
        super.onBackPressed();
        AppMethodBeat.o(245273);
    }

    private final void ddW() {
        AppMethodBeat.i(245274);
        if (this.gAZ == 1 && this.uae.size() == 1) {
            aul aul = this.uae.get(0);
            p.g(aul, "contactList[0]");
            aul aul2 = aul;
            if (aul2.LFn == 1) {
                ii iiVar = new ii();
                iiVar.dMV.dMW = aul2.dMW;
                EventCenter.instance.publish(iiVar);
            }
        }
        AppMethodBeat.o(245274);
    }

    private final void updateTitle() {
        AppMethodBeat.i(245275);
        setMMTitle(getString(R.string.cqe, new Object[]{Integer.valueOf(this.gAZ)}));
        AppMethodBeat.o(245275);
    }

    private final void ddX() {
        AppMethodBeat.i(245277);
        com.tencent.mm.kernel.g.azz().b(new bl(this.tsO, this.feedId, this.uaS));
        AppMethodBeat.o(245277);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245278);
        super.onDestroy();
        com.tencent.mm.kernel.g.azz().b(3593, this);
        com.tencent.mm.kernel.g.azz().b(3638, this);
        EventCenter.instance.removeListener(this.tOh);
        AppMethodBeat.o(245278);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.acp;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z = false;
        AppMethodBeat.i(245279);
        if (qVar instanceof bl) {
            Log.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
            if (i2 != 0 || i3 != 0) {
                if (this.tsO == null) {
                    TextView textView = this.hRM;
                    if (textView == null) {
                        p.btv("emptyTip");
                    }
                    textView.setVisibility(8);
                    ListView listView = this.krb;
                    if (listView == null) {
                        p.btv("listView");
                    }
                    listView.setVisibility(8);
                    MMProcessBar mMProcessBar = this.uaO;
                    if (mMProcessBar == null) {
                        p.btv("loadingBar");
                    }
                    mMProcessBar.setVisibility(8);
                    TextView textView2 = this.uaP;
                    if (textView2 == null) {
                        p.btv("retryTips");
                    }
                    textView2.setVisibility(0);
                }
                AppMethodBeat.o(245279);
            } else if (qVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
                AppMethodBeat.o(245279);
                throw tVar;
            } else {
                if (!p.j(this.tsO, ((bl) qVar).cYn())) {
                    Log.i(TAG, "not my buf, ignore!");
                    AppMethodBeat.o(245279);
                    return;
                }
                if (this.tsO == null) {
                    z = true;
                }
                if (z) {
                    this.gAZ = ((bl) qVar).cYx().gAZ;
                    updateTitle();
                }
                this.hasMore = ((bl) qVar).cYp();
                this.tsO = ((bl) qVar).cYm();
                com.tencent.mm.ac.d.h(new i(this, qVar, z));
                AppMethodBeat.o(245279);
            }
        } else {
            if (qVar instanceof ay) {
                Log.i(TAG, "NetSceneFinderContactTag errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
                if (i2 != 0 || i3 != 0) {
                    u.makeText(this, (int) R.string.u4, 0).show();
                } else if (((ay) qVar).ttq == null) {
                    AppMethodBeat.o(245279);
                    return;
                }
            }
            AppMethodBeat.o(245279);
        }
    }

    public final void ddY() {
        AppMethodBeat.i(245280);
        ListView listView = this.krb;
        if (listView == null) {
            p.btv("listView");
        }
        if (listView.getFooterViewsCount() == 0) {
            ListView listView2 = this.krb;
            if (listView2 == null) {
                p.btv("listView");
            }
            listView2.addFooterView(View.inflate(this, R.layout.ag7, null));
        }
        AppMethodBeat.o(245280);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.ak.q hvN;
        final /* synthetic */ FinderFriendRecommendUI uaV;
        final /* synthetic */ boolean uaY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderFriendRecommendUI finderFriendRecommendUI, com.tencent.mm.ak.q qVar, boolean z) {
            super(0);
            this.uaV = finderFriendRecommendUI;
            this.hvN = qVar;
            this.uaY = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245270);
            if (!this.uaV.hasMore) {
                this.uaV.ddY();
            }
            FinderFriendRecommendUI.a(this.uaV, ((bl) this.hvN).cYw(), this.uaY);
            x xVar = x.SXb;
            AppMethodBeat.o(245270);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(FinderFriendRecommendUI finderFriendRecommendUI, List list, boolean z) {
        AppMethodBeat.i(245286);
        Log.i(TAG, "friend list: " + list.size());
        if (!z || list.size() != 0) {
            TextView textView = finderFriendRecommendUI.hRM;
            if (textView == null) {
                p.btv("emptyTip");
            }
            textView.setVisibility(8);
            ListView listView = finderFriendRecommendUI.krb;
            if (listView == null) {
                p.btv("listView");
            }
            listView.setVisibility(0);
            MMProcessBar mMProcessBar = finderFriendRecommendUI.uaO;
            if (mMProcessBar == null) {
                p.btv("loadingBar");
            }
            mMProcessBar.setVisibility(8);
            TextView textView2 = finderFriendRecommendUI.uaP;
            if (textView2 == null) {
                p.btv("retryTips");
            }
            textView2.setVisibility(8);
            finderFriendRecommendUI.uae.addAll(list);
            com.tencent.mm.plugin.finder.ui.d dVar = finderFriendRecommendUI.uaQ;
            ArrayList<aul> arrayList = finderFriendRecommendUI.uae;
            p.h(arrayList, "contacts");
            dVar.kgc.clear();
            dVar.kgc.addAll(arrayList);
            finderFriendRecommendUI.uaQ.notifyDataSetChanged();
            AppMethodBeat.o(245286);
            return;
        }
        TextView textView3 = finderFriendRecommendUI.hRM;
        if (textView3 == null) {
            p.btv("emptyTip");
        }
        textView3.setVisibility(0);
        ListView listView2 = finderFriendRecommendUI.krb;
        if (listView2 == null) {
            p.btv("listView");
        }
        listView2.setVisibility(8);
        MMProcessBar mMProcessBar2 = finderFriendRecommendUI.uaO;
        if (mMProcessBar2 == null) {
            p.btv("loadingBar");
        }
        mMProcessBar2.setVisibility(8);
        TextView textView4 = finderFriendRecommendUI.uaP;
        if (textView4 == null) {
            p.btv("retryTips");
        }
        textView4.setVisibility(8);
        AppMethodBeat.o(245286);
    }
}
