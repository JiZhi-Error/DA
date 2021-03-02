package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
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
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.b;
import com.tencent.mm.plugin.finder.feed.b.AbstractC1134b;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.h;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\r\u0010\t\u001a\u00028\u0001H&¢\u0006\u0002\u0010\nJ\r\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH&J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\"\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\bH\u0016J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\bH\u0014J\b\u0010!\u001a\u00020\bH\u0014J\b\u0010\"\u001a\u00020\bH\u0014J\b\u0010#\u001a\u00020\bH\u0002¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "fixActionBarStatus", "", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initAfterAttach", "initOnCreate", "isHideStatusBar", "", "isOtherEnableFullScreenEnjoy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "overlayStatusBar", "plugin-finder_release"})
public abstract class FinderBaseFeedUI<V extends b.AbstractC1134b, P extends b.a> extends MMFinderUI {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public abstract P ddQ();

    public abstract V ddR();

    public abstract void initOnCreate();

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y yVar = y.vXH;
        if (y.isOtherEnableFullScreenEnjoy()) {
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
                throw new t("null cannot be cast to non-null type android.view.ViewGroup");
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
            CharSequence mMTitle = getMMTitle();
            if (mMTitle == null || mMTitle.length() == 0) {
                TextView textView = (TextView) _$_findCachedViewById(R.id.dbg);
                p.g(textView, "full_action_bar_title");
                textView.setVisibility(8);
            } else {
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.dbg);
                p.g(textView2, "full_action_bar_title");
                textView2.setVisibility(0);
                TextView textView3 = (TextView) _$_findCachedViewById(R.id.dbg);
                p.g(textView3, "full_action_bar_title");
                textView3.setText(getMMTitle());
            }
            y yVar2 = y.vXH;
            Window window3 = getWindow();
            p.g(window3, "window");
            y.b(window3, false);
            setNavigationbarColor(getResources().getColor(R.color.fm));
            FrameLayout frameLayout3 = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            p.g(frameLayout3, "full_actionbar");
            frameLayout3.setVisibility(0);
            View findViewById = findViewById(R.id.h7t);
            if (findViewById != null) {
                findViewById.setLayoutParams(new CoordinatorLayout.d(-1, -1));
                findViewById.setBackgroundResource(R.color.rv);
            }
        } else {
            setBackBtn(new c(this));
        }
        initOnCreate();
        ddQ().onAttach(ddR());
        ddP();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderBaseFeedUI tZs;

        c(FinderBaseFeedUI finderBaseFeedUI) {
            this.tZs = finderBaseFeedUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(166127);
            this.tZs.onBackPressed();
            AppMethodBeat.o(166127);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u000e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ FinderBaseFeedUI tZs;

        a(FinderBaseFeedUI finderBaseFeedUI) {
            this.tZs = finderBaseFeedUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245116);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tZs.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderBaseFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245116);
        }
    }

    public void ddP() {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        ddQ().onBackPressed();
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        ddQ().onUIResume();
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        ddQ().onUIPause();
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        ddQ().onDetach();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        FinderVideoLayout finderVideoLayout;
        long j2;
        super.onActivityResult(i2, i3, intent);
        ddQ().dcg().d(i2, intent);
        y yVar = y.vXH;
        if (y.isOtherEnableFullScreenEnjoy() && -1 == i3 && i2 == 101) {
            RecyclerView recyclerView = ddR().tLS.getRecyclerView();
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                RecyclerView.v ch = recyclerView.ch(((LinearLayoutManager) layoutManager).ks());
                if (!(ch instanceof h)) {
                    ch = null;
                }
                h hVar = (h) ch;
                if (hVar != null && (finderVideoLayout = (FinderVideoLayout) hVar.Mn(R.id.ckd)) != null) {
                    long longExtra = intent != null ? intent.getLongExtra("KEY_CACHE_OBJECT_ID", -1) : -1;
                    if (intent != null) {
                        j2 = intent.getLongExtra("KEY_VIDEO_START_PLAY_TIME_MS", -1);
                    } else {
                        j2 = -1;
                    }
                    Log.i("FinderBaseFeedUI", "[onActivityResult] feedId=" + d.zs(longExtra) + " seekTime=" + j2);
                    if (j2 != -1) {
                        finderVideoLayout.setStartPlayTime(j2);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean isHideStatusBar() {
        y yVar = y.vXH;
        return y.isOtherEnableFullScreenEnjoy();
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public Set<Class<? extends UIComponent>> importUIComponents() {
        y yVar = y.vXH;
        if (y.isOtherEnableFullScreenEnjoy()) {
            return ak.setOf(FinderHorizontalVideoPreviewUIC.class);
        }
        return null;
    }
}
