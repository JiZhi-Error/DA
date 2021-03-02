package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract$LikedTimelinePresenter$buildItemCoverts$1;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract$LikedTimelineViewCallback$initView$2;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract$LikedTimelineViewCallback$initView$3;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0018\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0014J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0014J\b\u0010(\u001a\u00020\u0013H\u0016J\"\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020\"H\u0016J\u0012\u0010/\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\"H\u0014J\b\u00103\u001a\u00020\"H\u0014J\b\u00104\u001a\u00020\"H\u0014J\u0012\u00105\u001a\u00020\"2\b\u00106\u001a\u0004\u0018\u000101H\u0014J\b\u00107\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0012\u0010\u0014R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderLikedFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "MENU_ID_WX_MSG", "", "TAG", "", "cacheId", "", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "initPos", "isOtherEnableFullScreenEnjoy", "", "()Z", "isOtherEnableFullScreenEnjoy$delegate", "Lkotlin/Lazy;", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", ch.COL_USERNAME, "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback;", "fixActionBarStatus", "", "getCommentScene", "getLayoutId", "getReportType", "goBack", "initView", "isHideStatusBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "overlayStatusBar", "plugin-finder_release"})
public final class FinderLikedFeedUI extends MMFinderUI {
    private final String TAG = "Finder.FinderLikedFeedUI";
    private HashMap _$_findViewCache;
    private RefreshLoadMoreLayout tLS;
    private com.tencent.mm.plugin.finder.view.e tLT;
    public FinderLikeDrawer tLV;
    private long tZj;
    private int uCt;
    private final f uXa = g.ah(d.vKK);
    private FinderLikedFeedContract.LikedTimelineViewCallback uXf;
    private FinderLikedFeedContract.LikedTimelinePresenter uXl;
    private String username;
    private final int vKH = 1;
    private final e vKI = new e();

    private final boolean isOtherEnableFullScreenEnjoy() {
        AppMethodBeat.i(252443);
        boolean booleanValue = ((Boolean) this.uXa.getValue()).booleanValue();
        AppMethodBeat.o(252443);
        return booleanValue;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252450);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252450);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252449);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252449);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderLikedFeedUI() {
        AppMethodBeat.i(252447);
        AppMethodBeat.o(252447);
    }

    public static final /* synthetic */ void a(FinderLikedFeedUI finderLikedFeedUI) {
        AppMethodBeat.i(167325);
        finderLikedFeedUI.goBack();
        AppMethodBeat.o(167325);
    }

    public static final /* synthetic */ FinderLikedFeedContract.LikedTimelineViewCallback b(FinderLikedFeedUI finderLikedFeedUI) {
        AppMethodBeat.i(252448);
        FinderLikedFeedContract.LikedTimelineViewCallback likedTimelineViewCallback = finderLikedFeedUI.uXf;
        if (likedTimelineViewCallback == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(252448);
        return likedTimelineViewCallback;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.acn;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167320);
        super.onCreate(bundle);
        this.username = z.aTY();
        Log.i(this.TAG, "username %s", this.username);
        initView();
        if (isOtherEnableFullScreenEnjoy()) {
            Window window = getWindow();
            p.g(window, "window");
            View decorView = window.getDecorView();
            p.g(decorView, "window.decorView");
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1024 | 256);
            Window window2 = getWindow();
            p.g(window2, "window");
            window2.setStatusBarColor(0);
            getController().p(this, getResources().getColor(R.color.ac_));
            com.tencent.mm.ui.b.e(this, false);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setBackgroundDrawable(new ColorDrawable(0));
                supportActionBar.hide();
            }
            LayoutInflater jQ = aa.jQ(getContext());
            View bodyView = getBodyView();
            if (bodyView == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(167320);
                throw tVar;
            }
            jQ.inflate(R.layout.abw, (ViewGroup) bodyView, true);
            int statusBarHeight = au.getStatusBarHeight(this);
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            p.g(frameLayout, "full_actionbar");
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            layoutParams.height += statusBarHeight;
            FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            p.g(frameLayout2, "full_actionbar");
            frameLayout2.setLayoutParams(layoutParams);
            ((FrameLayout) _$_findCachedViewById(R.id.dbh)).setPadding(0, statusBarHeight, 0, 0);
            ((LinearLayout) _$_findCachedViewById(R.id.xu)).setOnClickListener(new a(this));
            ((FrameLayout) _$_findCachedViewById(R.id.dbh)).setOnClickListener(new b(this));
            TextView textView = (TextView) _$_findCachedViewById(R.id.dbg);
            p.g(textView, "full_action_bar_title");
            textView.setVisibility(8);
            y yVar = y.vXH;
            Window window3 = getWindow();
            p.g(window3, "window");
            y.b(window3, false);
            setNavigationbarColor(getResources().getColor(R.color.fm));
            FrameLayout frameLayout3 = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            p.g(frameLayout3, "full_actionbar");
            frameLayout3.setVisibility(0);
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            refreshLoadMoreLayout.setBackgroundColor(getResources().getColor(R.color.rv));
        }
        FinderLikedFeedContract.LikedTimelineViewCallback likedTimelineViewCallback = this.uXf;
        if (likedTimelineViewCallback == null) {
            p.btv("viewCallback");
        }
        likedTimelineViewCallback.getRecyclerView().a(this.vKI);
        AppMethodBeat.o(167320);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(167321);
        setMMTitle(R.string.d2x);
        View findViewById = findViewById(R.id.h7t);
        p.g(findViewById, "findViewById(R.id.rl_layout)");
        this.tLS = (RefreshLoadMoreLayout) findViewById;
        setBackBtn(new c(this));
        this.tZj = getIntent().getLongExtra("KEY_CACHE_ID", 0);
        this.uCt = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
        e.a aVar = com.tencent.mm.plugin.finder.view.e.wky;
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        this.tLT = e.a.a(this, decorView, 2, false, 0, 24);
        FinderLikeDrawer.a aVar2 = FinderLikeDrawer.wnm;
        AppCompatActivity context = getContext();
        p.g(context, "context");
        AppCompatActivity context2 = getContext();
        p.g(context2, "context");
        Window window2 = context2.getWindow();
        p.g(window2, "context.window");
        FinderLikeDrawer.a aVar3 = FinderLikeDrawer.wnm;
        this.tLV = FinderLikeDrawer.a.a(context, window2, FinderLikeDrawer.tvl);
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        View inflate = aa.jQ(getContext()).inflate(isOtherEnableFullScreenEnjoy() ? R.layout.b22 : R.layout.b21, (ViewGroup) null);
        p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        refreshLoadMoreLayout.setLoadMoreFooter(inflate);
        FinderLikedFeedUI finderLikedFeedUI = this;
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            p.btv("drawer");
        }
        this.uXl = new FinderLikedFeedContract.LikedTimelinePresenter(finderLikedFeedUI, eVar);
        FinderLikedFeedUI finderLikedFeedUI2 = this;
        FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter = this.uXl;
        if (likedTimelinePresenter == null) {
            p.btv("presenter");
        }
        this.uXf = new FinderLikedFeedContract.LikedTimelineViewCallback(finderLikedFeedUI2, likedTimelinePresenter);
        FinderLikedFeedContract.LikedTimelineViewCallback likedTimelineViewCallback = this.uXf;
        if (likedTimelineViewCallback == null) {
            p.btv("viewCallback");
        }
        View findViewById2 = likedTimelineViewCallback.gte.findViewById(R.id.c3e);
        p.g(findViewById2, "context.findViewById(R.id.empty_view)");
        likedTimelineViewCallback.GQ = findViewById2;
        View view = likedTimelineViewCallback.GQ;
        if (view == null) {
            p.btv("mEmptyView");
        }
        view.setVisibility(8);
        View findViewById3 = likedTimelineViewCallback.gte.findViewById(R.id.h7t);
        p.g(findViewById3, "context.findViewById(R.id.rl_layout)");
        likedTimelineViewCallback.tLS = (RefreshLoadMoreLayout) findViewById3;
        RefreshLoadMoreLayout refreshLoadMoreLayout2 = likedTimelineViewCallback.tLS;
        if (refreshLoadMoreLayout2 == null) {
            p.btv("rlLayout");
        }
        likedTimelineViewCallback.hak = refreshLoadMoreLayout2.getRecyclerView();
        RecyclerView recyclerView = likedTimelineViewCallback.hak;
        if (recyclerView == null) {
            p.btv("recyclerView");
        }
        FinderLinearLayoutManager finderLinearLayoutManager = new FinderLinearLayoutManager(likedTimelineViewCallback.gte);
        FinderLikedFeedContract finderLikedFeedContract = FinderLikedFeedContract.uXb;
        if (FinderLikedFeedContract.dlU()) {
            finderLinearLayoutManager.wsx = 25.0f;
            finderLinearLayoutManager.qOi = 100;
        }
        recyclerView.setLayoutManager(finderLinearLayoutManager);
        RecyclerView recyclerView2 = likedTimelineViewCallback.hak;
        if (recyclerView2 == null) {
            p.btv("recyclerView");
        }
        recyclerView2.setAdapter(new WxRecyclerAdapter(new FinderLikedFeedContract$LikedTimelinePresenter$buildItemCoverts$1(likedTimelineViewCallback.uXl), likedTimelineViewCallback.ddM().getDataList()));
        View findViewById4 = likedTimelineViewCallback.gte.findViewById(R.id.bfi);
        RefreshLoadMoreLayout refreshLoadMoreLayout3 = likedTimelineViewCallback.tLS;
        if (refreshLoadMoreLayout3 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout3.setActionCallback(new FinderLikedFeedContract$LikedTimelineViewCallback$initView$2(likedTimelineViewCallback, findViewById4));
        FinderLikedFeedContract finderLikedFeedContract2 = FinderLikedFeedContract.uXb;
        if (!FinderLikedFeedContract.dlU()) {
            RecyclerView recyclerView3 = likedTimelineViewCallback.hak;
            if (recyclerView3 == null) {
                p.btv("recyclerView");
            }
            recyclerView3.b(new com.tencent.mm.plugin.finder.view.decoration.b(new ColorDrawable(c.a.a(likedTimelineViewCallback).getColor(R.color.f3043a)), (int) c.a.a(likedTimelineViewCallback).getDimension(R.dimen.a4f)));
        } else {
            e eVar2 = new e();
            RecyclerView recyclerView4 = likedTimelineViewCallback.hak;
            if (recyclerView4 == null) {
                p.btv("recyclerView");
            }
            eVar2.f(recyclerView4);
        }
        com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), new FinderLikedFeedContract$LikedTimelineViewCallback$initView$3(likedTimelineViewCallback));
        com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.f d2 = FinderReporterUIC.d((FinderReporterUIC) com.tencent.mm.ui.component.a.b(likedTimelineViewCallback.gte).get(FinderReporterUIC.class));
        if (d2 != null) {
            RecyclerView recyclerView5 = likedTimelineViewCallback.hak;
            if (recyclerView5 == null) {
                p.btv("recyclerView");
            }
            d2.m(recyclerView5);
        }
        FinderLikedFeedContract.LikedTimelineViewCallback likedTimelineViewCallback2 = this.uXf;
        if (likedTimelineViewCallback2 == null) {
            p.btv("viewCallback");
        }
        FinderLikedFeedLoader finderLikedFeedLoader = likedTimelineViewCallback2.uXl.uXc;
        RefreshLoadMoreLayout refreshLoadMoreLayout4 = likedTimelineViewCallback2.tLS;
        if (refreshLoadMoreLayout4 == null) {
            p.btv("rlLayout");
        }
        finderLikedFeedLoader.register(refreshLoadMoreLayout4);
        FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter2 = this.uXl;
        if (likedTimelinePresenter2 == null) {
            p.btv("presenter");
        }
        FinderLikedFeedContract.LikedTimelineViewCallback likedTimelineViewCallback3 = this.uXf;
        if (likedTimelineViewCallback3 == null) {
            p.btv("viewCallback");
        }
        likedTimelinePresenter2.a(likedTimelineViewCallback3);
        AppMethodBeat.o(167321);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderLikedFeedUI vKJ;

        c(FinderLikedFeedUI finderLikedFeedUI) {
            this.vKJ = finderLikedFeedUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(167316);
            FinderLikedFeedUI.a(this.vKJ);
            AppMethodBeat.o(167316);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean isHideStatusBar() {
        AppMethodBeat.i(252444);
        boolean isOtherEnableFullScreenEnjoy = isOtherEnableFullScreenEnjoy();
        AppMethodBeat.o(252444);
        return isOtherEnableFullScreenEnjoy;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ FinderLikedFeedUI vKJ;

        a(FinderLikedFeedUI finderLikedFeedUI) {
            this.vKJ = finderLikedFeedUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252437);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.vKJ.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252437);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ FinderLikedFeedUI vKJ;

        b(FinderLikedFeedUI finderLikedFeedUI) {
            this.vKJ = finderLikedFeedUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252438);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            RecyclerView recyclerView = FinderLikedFeedUI.b(this.vKJ).getRecyclerView();
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$2", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
            recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$2", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$fixActionBarStatus$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252438);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(252445);
        super.onSaveInstanceState(bundle);
        FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter = this.uXl;
        if (likedTimelinePresenter == null) {
            p.btv("presenter");
        }
        FinderLikedFeedLoader finderLikedFeedLoader = likedTimelinePresenter.uXc;
        Intent intent = getIntent();
        p.g(intent, "intent");
        FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter2 = this.uXl;
        if (likedTimelinePresenter2 == null) {
            p.btv("presenter");
        }
        BaseFeedLoader.saveCache$default(finderLikedFeedLoader, intent, likedTimelinePresenter2.uXc.getInitPos(), null, 4, null);
        AppMethodBeat.o(252445);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(167322);
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            p.btv("drawer");
        }
        eVar.onDetach();
        super.onDestroy();
        FinderLikedFeedContract.LikedTimelineViewCallback likedTimelineViewCallback = this.uXf;
        if (likedTimelineViewCallback == null) {
            p.btv("viewCallback");
        }
        likedTimelineViewCallback.getRecyclerView().b(this.vKI);
        FinderLikedFeedContract.LikedTimelineViewCallback likedTimelineViewCallback2 = this.uXf;
        if (likedTimelineViewCallback2 == null) {
            p.btv("viewCallback");
        }
        FinderLikedFeedLoader finderLikedFeedLoader = likedTimelineViewCallback2.uXl.uXc;
        RefreshLoadMoreLayout refreshLoadMoreLayout = likedTimelineViewCallback2.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        finderLikedFeedLoader.unregister(refreshLoadMoreLayout);
        likedTimelineViewCallback2.uXl.onDetach();
        AppMethodBeat.o(167322);
    }

    private final void goBack() {
        AppMethodBeat.i(167323);
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            p.btv("drawer");
        }
        if (eVar.dGs()) {
            com.tencent.mm.plugin.finder.view.e eVar2 = this.tLT;
            if (eVar2 == null) {
                p.btv("drawer");
            }
            eVar2.dGr();
            AppMethodBeat.o(167323);
            return;
        }
        FinderLikeDrawer finderLikeDrawer = this.tLV;
        if (finderLikeDrawer == null) {
            p.btv("friendLikeDrawer");
        }
        if (finderLikeDrawer.dGs()) {
            FinderLikeDrawer finderLikeDrawer2 = this.tLV;
            if (finderLikeDrawer2 == null) {
                p.btv("friendLikeDrawer");
            }
            finderLikeDrawer2.dGr();
            AppMethodBeat.o(167323);
            return;
        }
        finish();
        AppMethodBeat.o(167323);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(167324);
        goBack();
        AppMethodBeat.o(167324);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(178432);
        super.onResume();
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            p.btv("drawer");
        }
        eVar.onUIResume();
        k kVar = k.vkd;
        FinderLikedFeedContract.LikedTimelineViewCallback likedTimelineViewCallback = this.uXf;
        if (likedTimelineViewCallback == null) {
            p.btv("viewCallback");
        }
        k.b(likedTimelineViewCallback.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, "2", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        AppMethodBeat.o(178432);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(178433);
        super.onPause();
        if (this.tLT == null) {
            p.btv("drawer");
        }
        k kVar = k.vkd;
        FinderLikedFeedContract.LikedTimelineViewCallback likedTimelineViewCallback = this.uXf;
        if (likedTimelineViewCallback == null) {
            p.btv("viewCallback");
        }
        k.b(likedTimelineViewCallback.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, "2", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        AppMethodBeat.o(178433);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(252446);
        super.onActivityResult(i2, i3, intent);
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            p.btv("drawer");
        }
        eVar.d(i2, intent);
        AppMethodBeat.o(252446);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class e extends RecyclerView.l {
        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(252442);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(252442);
        }

        e() {
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(252441);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            k kVar = k.vkd;
            k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, "2", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderLikedFeedUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(252441);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Boolean> {
        public static final d vKK = new d();

        static {
            AppMethodBeat.i(252440);
            AppMethodBeat.o(252440);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(252439);
            y yVar = y.vXH;
            Boolean valueOf = Boolean.valueOf(y.isOtherEnableFullScreenEnjoy());
            AppMethodBeat.o(252439);
            return valueOf;
        }
    }
}
