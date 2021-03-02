package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.f;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.FinderTouchLayout;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u0006H\u0014J0\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=2\u0006\u0010*\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u0006H\u0002J\u0012\u0010?\u001a\u0002082\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u000208H\u0014J\b\u0010C\u001a\u000208H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R&\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020200X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderCommentUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "DRAG_CLOSE_THRESHOLD", "", "DRAG_START_X", "", "DRAG_START_Y", "DURATION", "", "TAG", "", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "getBuilder", "()Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "setBuilder", "(Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;)V", "containerView", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "getContainerView", "()Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;", "setContainerView", "(Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;)V", "fromMsg", "", "getFromMsg", "()Z", "setFromMsg", "(Z)V", "isFinish", "mentionCreateTime", "getMentionCreateTime", "()I", "setMentionCreateTime", "(I)V", "mentionId", "getMentionId", "()J", "setMentionId", "(J)V", "requestData", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerCreateData;", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent$Companion$DrawerOpenData;", "getRequestData", "()Lkotlin/Pair;", "setRequestData", "(Lkotlin/Pair;)V", "finish", "", "getLayoutId", "initBuilder", "showTopItem", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "scene", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "plugin-finder_release"})
public final class FinderCommentUI extends MMFinderUI {
    private final String TAG = "Finder.FinderCommentUI";
    private HashMap _$_findViewCache;
    private boolean iGD;
    private final long lZa = 300;
    public FinderCommentDrawer tNb;
    private boolean tZA;
    private long tZB;
    private int tZC;
    private final int tZu = 50;
    private final int tZv = 300;
    private final float tZw = 0.3f;
    public FinderTouchLayout tZx;
    public o<e.a.C1338a, e.a.b> tZy;
    public com.tencent.mm.plugin.finder.view.builder.b tZz;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245137);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245137);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245136);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245136);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Boolean> {
        public static final b tZJ = new b();

        static {
            AppMethodBeat.i(245121);
            AppMethodBeat.o(245121);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    public static final /* synthetic */ View c(FinderCommentUI finderCommentUI) {
        AppMethodBeat.i(245135);
        View contentView = finderCommentUI.getContentView();
        AppMethodBeat.o(245135);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a9x;
    }

    public final FinderTouchLayout ddT() {
        AppMethodBeat.i(245129);
        FinderTouchLayout finderTouchLayout = this.tZx;
        if (finderTouchLayout == null) {
            p.btv("containerView");
        }
        AppMethodBeat.o(245129);
        return finderTouchLayout;
    }

    public final FinderCommentDrawer ddU() {
        AppMethodBeat.i(245130);
        FinderCommentDrawer finderCommentDrawer = this.tNb;
        if (finderCommentDrawer == null) {
            p.btv("drawer");
        }
        AppMethodBeat.o(245130);
        return finderCommentDrawer;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245131);
        setTheme(R.style.q2);
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null) {
                p.hyc();
            }
            supportActionBar.setBackgroundDrawable(new ColorDrawable(0));
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 == null) {
                p.hyc();
            }
            supportActionBar2.hide();
        }
        e.a aVar = com.tencent.mm.plugin.finder.view.e.wky;
        Intent intent = getIntent();
        p.g(intent, "intent");
        p.h(intent, "intent");
        o<e.a.C1338a, e.a.b> oVar = (o) com.tencent.mm.plugin.finder.view.e.wkw.remove(Long.valueOf(intent.getLongExtra("COMMENT_REQUEST_KEY", 0)));
        if (oVar == null) {
            finish();
            AppMethodBeat.o(245131);
            return;
        }
        this.tZy = oVar;
        e.a aVar2 = com.tencent.mm.plugin.finder.view.e.wky;
        Intent intent2 = getIntent();
        p.g(intent2, "intent");
        p.h(intent2, "intent");
        this.tZA = intent2.getBooleanExtra("FROM_MSG", false);
        e.a aVar3 = com.tencent.mm.plugin.finder.view.e.wky;
        Intent intent3 = getIntent();
        p.g(intent3, "intent");
        p.h(intent3, "intent");
        this.tZB = intent3.getLongExtra("MENTION_ID", 0);
        e.a aVar4 = com.tencent.mm.plugin.finder.view.e.wky;
        Intent intent4 = getIntent();
        p.g(intent4, "intent");
        p.h(intent4, "intent");
        this.tZC = intent4.getIntExtra("MENTION_CREATE_TIME", 0);
        o<e.a.C1338a, e.a.b> oVar2 = this.tZy;
        if (oVar2 == null) {
            p.btv("requestData");
        }
        A a2 = oVar2.first;
        o<e.a.C1338a, e.a.b> oVar3 = this.tZy;
        if (oVar3 == null) {
            p.btv("requestData");
        }
        B b2 = oVar3.second;
        View findViewById = findViewById(R.id.b9l);
        p.g(findViewById, "findViewById(R.id.comment_ui_container)");
        this.tZx = (FinderTouchLayout) findViewById;
        this.tZz = new a(this, this.tZA, b2.tMO, this.tZB, this.tZC, a2.scene, new f(this));
        com.tencent.mm.ui.component.a aVar5 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a aVar6 = com.tencent.mm.ui.component.a.PRN;
        ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).tCE = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).tyh;
        FinderCommentDrawer.b bVar = FinderCommentDrawer.wkG;
        FinderCommentUI finderCommentUI = this;
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        int i2 = a2.scene;
        com.tencent.mm.plugin.finder.view.builder.b bVar2 = this.tZz;
        if (bVar2 == null) {
            p.btv("builder");
        }
        this.tNb = FinderCommentDrawer.b.a(finderCommentUI, decorView, i2, bVar2, a2.tAj, true, 0, 64);
        FinderCommentDrawer finderCommentDrawer = this.tNb;
        if (finderCommentDrawer == null) {
            p.btv("drawer");
        }
        finderCommentDrawer.setInterceptClose(b.tZJ);
        FinderCommentDrawer finderCommentDrawer2 = this.tNb;
        if (finderCommentDrawer2 == null) {
            p.btv("drawer");
        }
        finderCommentDrawer2.setOnCloseDrawerCallback(new c(this));
        FinderTouchLayout finderTouchLayout = this.tZx;
        if (finderTouchLayout == null) {
            p.btv("containerView");
        }
        finderTouchLayout.post(new d(this, b2));
        FinderTouchLayout finderTouchLayout2 = this.tZx;
        if (finderTouchLayout2 == null) {
            p.btv("containerView");
        }
        finderTouchLayout2.setTouchListener(new e(this));
        AppMethodBeat.o(245131);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$2", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
    public static final class c implements CommentDrawerContract.CloseDrawerCallback {
        final /* synthetic */ FinderCommentUI tZD;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FinderCommentUI finderCommentUI) {
            this.tZD = finderCommentUI;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback
        public final void g(int i2, List<? extends s> list) {
            AppMethodBeat.i(245123);
            p.h(list, "data");
            if (this.tZD.iGD) {
                AppMethodBeat.o(245123);
                return;
            }
            this.tZD.iGD = true;
            Intent intent = new Intent();
            e.a aVar = com.tencent.mm.plugin.finder.view.e.wky;
            e.a.c cVar = new e.a.c(i2, list);
            p.h(intent, "intent");
            p.h(cVar, "resultData");
            long currentTimeMillis = System.currentTimeMillis();
            intent.putExtra("COMMENT_RESULT_KEY", currentTimeMillis);
            com.tencent.mm.plugin.finder.view.e.wkx.put(Long.valueOf(currentTimeMillis), cVar);
            this.tZD.setResult(0, intent);
            FinderCommentUI.c(this.tZD).postDelayed(new a(this), this.tZD.lZa);
            AppMethodBeat.o(245123);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ c tZK;

            a(c cVar) {
                this.tZK = cVar;
            }

            public final void run() {
                AppMethodBeat.i(245122);
                this.tZK.tZD.finish();
                AppMethodBeat.o(245122);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ FinderCommentUI tZD;
        final /* synthetic */ e.a.b tZL;

        d(FinderCommentUI finderCommentUI, e.a.b bVar) {
            this.tZD = finderCommentUI;
            this.tZL = bVar;
        }

        public final void run() {
            AppMethodBeat.i(245124);
            FinderCommentDrawer.a(this.tZD.ddU(), this.tZL.tMO, this.tZL.tMV, this.tZL.tuj, this.tZL.tMW, this.tZL.wkz, this.tZL.wkA, false, 0, 384);
            AppMethodBeat.o(245124);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$onCreate$4", "Lcom/tencent/mm/plugin/finder/view/FinderTouchLayout$TouchListener;", "ratio", "", "getRatio", "()F", "setRatio", "(F)V", "interceptDown", "", "event", "Landroid/view/MotionEvent;", "onScrollX", "", "x", "onTouchUp", "plugin-finder_release"})
    public static final class e implements FinderTouchLayout.a {
        private float tEJ;
        final /* synthetic */ FinderCommentUI tZD;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderCommentUI finderCommentUI) {
            this.tZD = finderCommentUI;
            AppMethodBeat.i(245128);
            Resources resources = finderCommentUI.getResources();
            p.g(resources, "resources");
            Resources resources2 = finderCommentUI.getResources();
            p.g(resources2, "resources");
            this.tEJ = ((float) resources.getDisplayMetrics().heightPixels) / ((float) resources2.getDisplayMetrics().widthPixels);
            AppMethodBeat.o(245128);
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderTouchLayout.a
        public final boolean T(MotionEvent motionEvent) {
            AppMethodBeat.i(245125);
            p.h(motionEvent, "event");
            if (motionEvent.getRawX() > ((float) this.tZD.tZu) || motionEvent.getRawY() <= ((float) this.tZD.tZv)) {
                AppMethodBeat.o(245125);
                return false;
            }
            AppMethodBeat.o(245125);
            return true;
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderTouchLayout.a
        public final void bh(float f2) {
            AppMethodBeat.i(245126);
            this.tZD.ddT().setTranslationY(this.tEJ * f2);
            Log.i(this.tZD.TAG, "distanceX " + f2 + ", translationY " + this.tZD.ddT().getTranslationY());
            AppMethodBeat.o(245126);
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderTouchLayout.a
        public final void U(MotionEvent motionEvent) {
            AppMethodBeat.i(245127);
            p.h(motionEvent, "event");
            Log.i(this.tZD.TAG, "translationY " + this.tZD.ddT().getTranslationY() + ", height:" + this.tZD.ddT().getHeight());
            if (this.tZD.ddT().getTranslationY() > this.tZD.tZw * ((float) this.tZD.ddT().getHeight())) {
                this.tZD.ddU().dGr();
                AppMethodBeat.o(245127);
                return;
            }
            this.tZD.ddT().clearAnimation();
            this.tZD.ddT().animate().cancel();
            this.tZD.ddT().animate().setInterpolator(new DecelerateInterpolator(1.5f)).translationY(0.0f).setDuration(this.tZD.lZa).start();
            AppMethodBeat.o(245127);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "onBuildDrawerHeader", "", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "fullScreen", "", "plugin-finder_release"})
    public static final class a extends com.tencent.mm.plugin.finder.view.builder.b {
        final /* synthetic */ int $scene;
        final /* synthetic */ FinderCommentUI tZD;
        final /* synthetic */ boolean tZE;
        final /* synthetic */ FinderItem tZF;
        final /* synthetic */ long tZG;
        final /* synthetic */ int tZH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderCommentUI finderCommentUI, boolean z, FinderItem finderItem, long j2, int i2, int i3, CommentDrawerContract.NPresenter nPresenter) {
            super(nPresenter);
            this.tZD = finderCommentUI;
            this.tZE = z;
            this.tZF = finderItem;
            this.tZG = j2;
            this.tZH = i2;
            this.$scene = i3;
        }

        @Override // com.tencent.mm.plugin.finder.view.FinderCommentDrawer.a, com.tencent.mm.plugin.finder.view.builder.b
        public final void a(Context context, FrameLayout frameLayout, boolean z) {
            AppMethodBeat.i(245120);
            p.h(context, "context");
            p.h(frameLayout, "headerLayout");
            super.a(context, frameLayout, z);
            if (this.tZE) {
                View findViewById = frameLayout.findViewById(R.id.dbt);
                if (findViewById == null) {
                    AppMethodBeat.o(245120);
                    return;
                }
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new View$OnClickListenerC1167a(this, context));
                ImageView imageView = (ImageView) frameLayout.findViewById(R.id.dbv);
                cjl cjl = (cjl) j.kt(this.tZF.getMediaList());
                if (cjl != null) {
                    if (cjl.mediaType == 4) {
                        k kVar = new k(cjl, x.THUMB_IMAGE, null, null, 12);
                        m mVar = m.uJa;
                        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> djY = m.djY();
                        p.g(imageView, "thumbIv");
                        m mVar2 = m.uJa;
                        djY.a(kVar, imageView, m.a(m.a.TIMELINE));
                    } else {
                        m mVar3 = m.uJa;
                        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> djY2 = m.djY();
                        k kVar2 = new k(cjl, x.THUMB_IMAGE, null, null, 12);
                        p.g(imageView, "thumbIv");
                        m mVar4 = m.uJa;
                        djY2.a(kVar2, imageView, m.a(m.a.TIMELINE));
                    }
                }
                TextView textView = (TextView) frameLayout.findViewById(R.id.dbw);
                p.g(textView, "titleTv");
                ao.a(textView.getPaint(), 0.8f);
                textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, context.getString(R.string.cnk, this.tZF.getNickName())));
                TextView textView2 = (TextView) frameLayout.findViewById(R.id.dbu);
                if (!Util.isNullOrNil(this.tZF.getDescription())) {
                    p.g(textView2, "descTv");
                    textView2.setVisibility(0);
                    textView2.setText(Util.isNullOrNil(this.tZF.getDescription()) ? "" : com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), this.tZF.getDescription()));
                } else {
                    p.g(textView2, "descTv");
                    textView2.setVisibility(8);
                }
                dHw().hH(findViewById);
                AppMethodBeat.o(245120);
                return;
            }
            View findViewById2 = frameLayout.findViewById(R.id.dbt);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
                AppMethodBeat.o(245120);
                return;
            }
            AppMethodBeat.o(245120);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.ui.FinderCommentUI$a$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC1167a implements View.OnClickListener {
            final /* synthetic */ Context $context;
            final /* synthetic */ a tZI;

            View$OnClickListenerC1167a(a aVar, Context context) {
                this.tZI = aVar;
                this.$context = context;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(245119);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("feed_object_id", this.tZI.tZF.getId());
                intent.putExtra("mention_id", this.tZI.tZG);
                intent.putExtra("mention_create_time", this.tZI.tZH);
                intent.putExtra("from_scene", this.tZI.$scene);
                intent.putExtra("from_comment_ui", true);
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC.a.a(this.$context, intent, 0, 0, false, 124);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.I(this.tZI.tZD, intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderCommentUI$initBuilder$1$onBuildDrawerHeader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(245119);
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(245132);
        hideVKB();
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(245132);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(245133);
        super.onResume();
        AppMethodBeat.o(245133);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(245134);
        FinderCommentDrawer finderCommentDrawer = this.tNb;
        if (finderCommentDrawer == null) {
            p.btv("drawer");
        }
        finderCommentDrawer.dHu();
        super.onDestroy();
        AppMethodBeat.o(245134);
    }
}
