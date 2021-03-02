package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.feed.ab;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0014J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020(H\u0002J\u0018\u0010-\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002000/\u0018\u00010.H\u0016J\b\u00101\u001a\u00020(H\u0014J\b\u00102\u001a\u00020\u0013H\u0016J\"\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u000107H\u0014J\b\u00108\u001a\u00020(H\u0016J\u0012\u00109\u001a\u00020(2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020(H\u0014J\b\u0010=\u001a\u00020(H\u0014J\b\u0010>\u001a\u00020(H\u0014J,\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010\u000b2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u00020(H\u0002J\b\u0010F\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_EXPOSE", "", "MENU_ID_MORE_INFO", "MENU_ID_RECOMMEND", "MENU_ID_SETTING", "MENU_ID_UNFOLLOW", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "isSelf", "", "likeDrawer", "mHellOnScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1;", "nickTv", "Landroid/widget/TextView;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelinePresenter;", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "selfFlag", "signatureTv", "subscribeBtn", "Landroid/widget/Button;", "topicId", "", ch.COL_USERNAME, "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderProfileTimelineContract$ProfileTimelineViewCallback;", "fixActionBarStatus", "", "getCommentScene", "getLayoutId", "getReportType", "goBack", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initView", "isHideStatusBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "overlayStatusBar", "refreshProfile", "plugin-finder_release"})
public final class FinderProfileTimeLineUI extends MMFinderUI implements i {
    private final String TAG = "Finder.FinderProfileTimeLineUI";
    private HashMap _$_findViewCache;
    private boolean dJM;
    private ImageView gyr;
    private TextView kib;
    private final int pMa = ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL;
    private RefreshLoadMoreLayout tLS;
    private com.tencent.mm.plugin.finder.view.e tLT;
    private FinderLikeDrawer tLU;
    private FinderLikeDrawer tLV;
    private boolean tPH;
    private ab.b tPU;
    private ab.c tPx;
    private long twp;
    private final int tzW = 10001;
    private TextView ucr;
    private Button ucs;
    private final int uct = 10000;
    private final int ucu = 10002;
    private final int ucv = ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL;
    private final c ucw = new c();
    private String username;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245488);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245488);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245487);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245487);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderProfileTimeLineUI() {
        AppMethodBeat.i(245486);
        AppMethodBeat.o(245486);
    }

    public static final /* synthetic */ void a(FinderProfileTimeLineUI finderProfileTimeLineUI) {
        AppMethodBeat.i(166151);
        finderProfileTimeLineUI.goBack();
        AppMethodBeat.o(166151);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        boolean z;
        RecyclerView recyclerView;
        boolean z2 = false;
        AppMethodBeat.i(166142);
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("finder_username");
        this.tPH = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
        this.twp = getIntent().getLongExtra("KEY_FROM_TOPIC_ID", 0);
        Log.i(this.TAG, "username " + this.username + ", selfFlag " + this.tPH + ", topicId " + this.twp);
        if (Util.isNullOrNil(this.username)) {
            finish();
            AppMethodBeat.o(166142);
            return;
        }
        String str = this.username;
        if (str != null) {
            z = str.equals(z.aUg());
        } else {
            z = false;
        }
        if (z && this.tPH) {
            z2 = true;
        }
        this.dJM = z2;
        initView();
        ab.c cVar = this.tPx;
        if (cVar == null || (recyclerView = cVar.getRecyclerView()) == null) {
            AppMethodBeat.o(166142);
            return;
        }
        recyclerView.a(this.ucw);
        AppMethodBeat.o(166142);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        String str;
        String str2;
        String str3;
        String nickname;
        AppMethodBeat.i(166143);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        String str4 = this.username;
        if (str4 == null) {
            p.hyc();
        }
        g asG = c.a.asG(str4);
        if (asG == null || (str = asG.getNickname()) == null) {
            str = "";
        }
        setMMTitle(str);
        View inflate = getLayoutInflater().inflate(R.layout.al0, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.x1);
        p.g(findViewById, "header.findViewById(R.id.avatar_iv)");
        this.gyr = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.fza);
        p.g(findViewById2, "header.findViewById(R.id.nick_tv)");
        this.kib = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.hs4);
        p.g(findViewById3, "header.findViewById(R.id.signature_tv)");
        this.ucr = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.idj);
        p.g(findViewById4, "header.findViewById(R.id.subscribe_btn)");
        this.ucs = (Button) findViewById4;
        View findViewById5 = findViewById(R.id.h7t);
        p.g(findViewById5, "findViewById(R.id.rl_layout)");
        this.tLS = (RefreshLoadMoreLayout) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.bsg);
        p.g(findViewById6, "header.findViewById<ImageView>(R.id.divider_item)");
        ((ImageView) findViewById6).setVisibility(0);
        setBackBtn(new a(this));
        m mVar = m.uJa;
        com.tencent.mm.loader.d<o> dka = m.dka();
        if (asG == null || (str2 = asG.cXH()) == null) {
            str2 = "";
        }
        com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(str2);
        ImageView imageView = this.gyr;
        if (imageView == null) {
            p.btv("avatarIv");
        }
        m mVar2 = m.uJa;
        dka.a(aVar2, imageView, m.a(m.a.AVATAR));
        e.a aVar3 = com.tencent.mm.plugin.finder.view.e.wky;
        FinderProfileTimeLineUI finderProfileTimeLineUI = this;
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        this.tLT = e.a.a(finderProfileTimeLineUI, decorView, this.dJM ? 1 : 2, false, 0, 24);
        FinderProfileTimeLineUI finderProfileTimeLineUI2 = this;
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            p.btv("drawer");
        }
        String str5 = this.username;
        if (str5 == null) {
            p.hyc();
        }
        this.tPU = new ab.b(finderProfileTimeLineUI2, eVar, str5, this.tPH, this.twp);
        FinderProfileTimeLineUI finderProfileTimeLineUI3 = this;
        ab.b bVar = this.tPU;
        if (bVar == null) {
            p.btv("presenter");
        }
        ab.c cVar = new ab.c(finderProfileTimeLineUI3, bVar);
        ab.b bVar2 = this.tPU;
        if (bVar2 == null) {
            p.btv("presenter");
        }
        bVar2.a(cVar);
        RefreshLoadMoreLayout refreshLoadMoreLayout = cVar.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout.setActionCallback(new ab.c.b(cVar));
        if (!cVar.tPW) {
            RecyclerView recyclerView = cVar.hak;
            if (recyclerView == null) {
                p.btv("recyclerView");
            }
            recyclerView.b(new com.tencent.mm.plugin.finder.view.decoration.b(new ColorDrawable(c.a.a(cVar).getColor(R.color.BW_93)), (int) c.a.a(cVar).getDimension(R.dimen.a4f)));
        }
        com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), new ab.c.C1122c(cVar));
        com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
        f d2 = FinderReporterUIC.d((FinderReporterUIC) com.tencent.mm.ui.component.a.b(cVar.gte).get(FinderReporterUIC.class));
        if (d2 != null) {
            RecyclerView recyclerView2 = cVar.hak;
            if (recyclerView2 == null) {
                p.btv("recyclerView");
            }
            d2.m(recyclerView2);
        }
        cVar.tPU.getFeedLoader().register(cVar.tMe);
        this.tPx = cVar;
        FinderLikeDrawer.a aVar5 = FinderLikeDrawer.wnm;
        Window window2 = getWindow();
        p.g(window2, "window");
        FinderLikeDrawer.a aVar6 = FinderLikeDrawer.wnm;
        this.tLU = FinderLikeDrawer.a.a(this, window2, FinderLikeDrawer.tvm);
        FinderLikeDrawer.a aVar7 = FinderLikeDrawer.wnm;
        AppCompatActivity context = getContext();
        p.g(context, "context");
        Window window3 = getWindow();
        p.g(window3, "this@FinderProfileTimeLineUI.window");
        FinderLikeDrawer.a aVar8 = FinderLikeDrawer.wnm;
        this.tLV = FinderLikeDrawer.a.a(context, window3, FinderLikeDrawer.tvl);
        y yVar = y.vXH;
        if (y.isOtherEnableFullScreenEnjoy()) {
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            p.g(frameLayout, "full_actionbar");
            frameLayout.setVisibility(0);
            ((LinearLayout) _$_findCachedViewById(R.id.xu)).setOnClickListener(new b(this));
            TextView textView = (TextView) _$_findCachedViewById(R.id.dbg);
            p.g(textView, "full_action_bar_title");
            AppCompatActivity context2 = getContext();
            if (asG != null && (nickname = asG.getNickname()) != null) {
                str3 = nickname;
            }
            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context2, str3));
            Window window4 = getWindow();
            p.g(window4, "window");
            View decorView2 = window4.getDecorView();
            p.g(decorView2, "window.decorView");
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 1024 | 256);
            Window window5 = getWindow();
            p.g(window5, "window");
            window5.setStatusBarColor(0);
            getController().p(this, getResources().getColor(R.color.ac_));
            com.tencent.mm.ui.b.e(this, false);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setBackgroundDrawable(new ColorDrawable(0));
                supportActionBar.hide();
            }
            int statusBarHeight = au.getStatusBarHeight(this);
            FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            p.g(frameLayout2, "full_actionbar");
            ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
            layoutParams.height += statusBarHeight;
            FrameLayout frameLayout3 = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            p.g(frameLayout3, "full_actionbar");
            frameLayout3.setLayoutParams(layoutParams);
            ((FrameLayout) _$_findCachedViewById(R.id.dbh)).setPadding(0, statusBarHeight, 0, 0);
            getController().updataStatusBarIcon(true);
            setNavigationbarColor(WebView.NIGHT_MODE_COLOR);
            ((CoordinatorLayout) _$_findCachedViewById(R.id.h7s)).setBackgroundColor(getResources().getColor(R.color.rv));
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tLS;
            if (refreshLoadMoreLayout2 == null) {
                p.btv("rlLayout");
            }
            View inflate2 = aa.jQ(getContext()).inflate(R.layout.b22, (ViewGroup) null);
            p.g(inflate2, "MMLayoutInflater.getInfl…d_more_footer_dark, null)");
            refreshLoadMoreLayout2.setLoadMoreFooter(inflate2);
        }
        AppMethodBeat.o(166143);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderProfileTimeLineUI ucx;

        a(FinderProfileTimeLineUI finderProfileTimeLineUI) {
            this.ucx = finderProfileTimeLineUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(166131);
            FinderProfileTimeLineUI.a(this.ucx);
            AppMethodBeat.o(166131);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ FinderProfileTimeLineUI ucx;

        b(FinderProfileTimeLineUI finderProfileTimeLineUI) {
            this.ucx = finderProfileTimeLineUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245475);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.ucx.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245475);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(245482);
        y yVar = y.vXH;
        if (y.isOtherEnableFullScreenEnjoy()) {
            Set<Class<? extends UIComponent>> of = ak.setOf(FinderHorizontalVideoPreviewUIC.class);
            AppMethodBeat.o(245482);
            return of;
        }
        AppMethodBeat.o(245482);
        return null;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean isHideStatusBar() {
        AppMethodBeat.i(245483);
        y yVar = y.vXH;
        boolean isOtherEnableFullScreenEnjoy = y.isOtherEnableFullScreenEnjoy();
        AppMethodBeat.o(245483);
        return isOtherEnableFullScreenEnjoy;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        public static final d ucy = new d();

        static {
            AppMethodBeat.i(245479);
            AppMethodBeat.o(245479);
        }

        d() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245478);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$refreshProfile$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$refreshProfile$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245478);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        public static final e ucz = new e();

        static {
            AppMethodBeat.i(245481);
            AppMethodBeat.o(245481);
        }

        e() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245480);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$refreshProfile$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$refreshProfile$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245480);
        }
    }

    private final void goBack() {
        AppMethodBeat.i(166145);
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
            AppMethodBeat.o(166145);
            return;
        }
        FinderLikeDrawer finderLikeDrawer = this.tLU;
        if (finderLikeDrawer == null) {
            p.btv("likeDrawer");
        }
        if (finderLikeDrawer.dGs()) {
            FinderLikeDrawer finderLikeDrawer2 = this.tLU;
            if (finderLikeDrawer2 == null) {
                p.btv("likeDrawer");
            }
            finderLikeDrawer2.dGr();
            AppMethodBeat.o(166145);
            return;
        }
        FinderLikeDrawer finderLikeDrawer3 = this.tLV;
        if (finderLikeDrawer3 == null) {
            p.btv("friendLikeDrawer");
        }
        if (finderLikeDrawer3.dGs()) {
            FinderLikeDrawer finderLikeDrawer4 = this.tLV;
            if (finderLikeDrawer4 == null) {
                p.btv("friendLikeDrawer");
            }
            finderLikeDrawer4.dGr();
            AppMethodBeat.o(166145);
            return;
        }
        finish();
        AppMethodBeat.o(166145);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(166146);
        goBack();
        AppMethodBeat.o(166146);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(166147);
        Log.i(this.TAG, "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        AppMethodBeat.o(166147);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(166148);
        super.onResume();
        com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
        String str = this.username;
        if (str == null) {
            str = "";
        }
        com.tencent.mm.plugin.finder.convert.d.asR(str);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        String str2 = this.username;
        if (str2 == null) {
            p.hyc();
        }
        g asG = c.a.asG(str2);
        if (asG != null) {
            TextView textView = this.kib;
            if (textView == null) {
                p.btv("nickTv");
            }
            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, asG.getNickname()));
            TextView textView2 = this.ucr;
            if (textView2 == null) {
                p.btv("signatureTv");
            }
            textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, asG.field_signature));
            c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
            if (c.a.asJ(asG.getUsername())) {
                Button button = this.ucs;
                if (button == null) {
                    p.btv("subscribeBtn");
                }
                button.setText(R.string.dzl);
                Button button2 = this.ucs;
                if (button2 == null) {
                    p.btv("subscribeBtn");
                }
                button2.setBackgroundResource(R.drawable.b0w);
                Button button3 = this.ucs;
                if (button3 == null) {
                    p.btv("subscribeBtn");
                }
                button3.setTextColor(getResources().getColor(R.color.x3));
                Button button4 = this.ucs;
                if (button4 == null) {
                    p.btv("subscribeBtn");
                }
                button4.setOnClickListener(d.ucy);
            } else {
                Button button5 = this.ucs;
                if (button5 == null) {
                    p.btv("subscribeBtn");
                }
                button5.setText(R.string.co_);
                Button button6 = this.ucs;
                if (button6 == null) {
                    p.btv("subscribeBtn");
                }
                button6.setTextColor(getResources().getColor(R.color.ag2));
                Button button7 = this.ucs;
                if (button7 == null) {
                    p.btv("subscribeBtn");
                }
                button7.setBackgroundResource(R.drawable.k8);
                Button button8 = this.ucs;
                if (button8 == null) {
                    p.btv("subscribeBtn");
                }
                button8.setOnClickListener(e.ucz);
            }
        }
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            p.btv("drawer");
        }
        eVar.onUIResume();
        k kVar = k.vkd;
        ab.c cVar = this.tPx;
        k.b(cVar != null ? cVar.getRecyclerView() : null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "1", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        AppMethodBeat.o(166148);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(166149);
        super.onPause();
        k kVar = k.vkd;
        ab.c cVar = this.tPx;
        k.b(cVar != null ? cVar.getRecyclerView() : null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "1", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        if (this.tLT == null) {
            p.btv("drawer");
        }
        AppMethodBeat.o(166149);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        RecyclerView recyclerView;
        AppMethodBeat.i(166150);
        ab.c cVar = this.tPx;
        if (!(cVar == null || (recyclerView = cVar.getRecyclerView()) == null)) {
            recyclerView.b(this.ucw);
        }
        if (this.tLT != null) {
            com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
            if (eVar == null) {
                p.btv("drawer");
            }
            eVar.onDetach();
        }
        super.onDestroy();
        ab.c cVar2 = this.tPx;
        if (cVar2 != null) {
            cVar2.tPU.getFeedLoader().unregister(cVar2.tMe);
            cVar2.tPU.onDetach();
            cVar2.getRecyclerView().setAdapter(null);
            AppMethodBeat.o(166150);
            return;
        }
        AppMethodBeat.o(166150);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.aj4;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(245484);
        super.onActivityResult(i2, i3, intent);
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            p.btv("drawer");
        }
        eVar.d(i2, intent);
        AppMethodBeat.o(245484);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        boolean z = false;
        AppMethodBeat.i(245485);
        String stringExtra = getIntent().getStringExtra("finder_username");
        boolean booleanExtra = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
        if (p.j(stringExtra, z.aUg()) && booleanExtra) {
            z = true;
        }
        if (z) {
            AppMethodBeat.o(245485);
            return 8;
        }
        AppMethodBeat.o(245485);
        return 1;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class c extends RecyclerView.l {
        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(245477);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(245477);
        }

        c() {
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(245476);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            k kVar = k.vkd;
            k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "1", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderProfileTimeLineUI$mHellOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(245476);
        }
    }
}
