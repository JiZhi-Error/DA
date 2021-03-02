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
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.v;
import com.tencent.mm.plugin.finder.feed.v.a;
import com.tencent.mm.plugin.finder.feed.v.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLikeGuideUIC;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u0007B\u0005¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\r\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\fJ\r\u0010\r\u001a\u00028\u0002H&¢\u0006\u0002\u0010\u000eJ\r\u0010\u000f\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\"\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\nH\u0016J\u0012\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\nH\u0014J\b\u0010$\u001a\u00020\nH\u0014J\b\u0010%\u001a\u00020\nH\u0014J\u0012\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010(\u001a\u00020\nH\u0002J\u0012\u0010)\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010)\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0012\u0010)\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010-H\u0016¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "fixActionBarStatus", "", "getModel", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initOnCreate", "isHideStatusBar", "", "isOtherEnableFullScreenEnjoy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "overlayStatusBar", "setMMTitle", "text", "", "resId", "", "plugin-finder_release"})
public abstract class FinderLoaderFeedUI<M extends BaseFinderFeedLoader, V extends v.b, P extends v.a> extends MMFinderUI {
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

    public abstract P ddK();

    public abstract V ddL();

    public abstract M ddM();

    public abstract void initOnCreate();

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
            y yVar = y.vXH;
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
                findViewById.setBackgroundColor(getResources().getColor(R.color.rv));
            }
        } else {
            setBackBtn(new c(this));
        }
        initOnCreate();
        P ddK = ddK();
        V ddL = ddL();
        ddK.a(ddM(), ddL);
        if (!isOtherEnableFullScreenEnjoy()) {
            setTitleBarClickListener(new d(ddL), e.ubL);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\u0006*\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderLoaderFeedUI ubJ;

        c(FinderLoaderFeedUI finderLoaderFeedUI) {
            this.ubJ = finderLoaderFeedUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(166128);
            this.ubJ.onBackPressed();
            AppMethodBeat.o(166128);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ v.b ubK;

        d(v.b bVar) {
            this.ubK = bVar;
        }

        public final void run() {
            AppMethodBeat.i(166129);
            RecyclerView recyclerView = this.ubK.tLS.getRecyclerView();
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$onCreate$2", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$onCreate$2", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            AppMethodBeat.o(166129);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0007H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "run"})
    public static final class e implements Runnable {
        public static final e ubL = new e();

        static {
            AppMethodBeat.i(166130);
            AppMethodBeat.o(166130);
        }

        e() {
        }

        public final void run() {
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public Set<Class<? extends UIComponent>> importUIComponents() {
        if (!isOtherEnableFullScreenEnjoy()) {
            return null;
        }
        return ak.setOf((Object[]) new Class[]{FinderHorizontalVideoPreviewUIC.class, FinderLikeGuideUIC.class});
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void setMMTitle(CharSequence charSequence) {
        super.setMMTitle(charSequence);
        if (isOtherEnableFullScreenEnjoy()) {
            CharSequence mMTitle = getMMTitle();
            if (mMTitle == null || mMTitle.length() == 0) {
                TextView textView = (TextView) _$_findCachedViewById(R.id.dbg);
                p.g(textView, "full_action_bar_title");
                textView.setVisibility(8);
                return;
            }
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.dbg);
            p.g(textView2, "full_action_bar_title");
            textView2.setVisibility(0);
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.dbg);
            p.g(textView3, "full_action_bar_title");
            textView3.setText(getMMTitle());
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void setMMTitle(int i2) {
        super.setMMTitle(i2);
        if (isOtherEnableFullScreenEnjoy()) {
            CharSequence mMTitle = getMMTitle();
            if (mMTitle == null || mMTitle.length() == 0) {
                TextView textView = (TextView) _$_findCachedViewById(R.id.dbg);
                p.g(textView, "full_action_bar_title");
                textView.setVisibility(8);
                return;
            }
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.dbg);
            p.g(textView2, "full_action_bar_title");
            textView2.setVisibility(0);
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.dbg);
            p.g(textView3, "full_action_bar_title");
            textView3.setText(getMMTitle());
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void setMMTitle(String str) {
        super.setMMTitle(str);
        if (isOtherEnableFullScreenEnjoy()) {
            CharSequence mMTitle = getMMTitle();
            if (mMTitle == null || mMTitle.length() == 0) {
                TextView textView = (TextView) _$_findCachedViewById(R.id.dbg);
                p.g(textView, "full_action_bar_title");
                textView.setVisibility(8);
                return;
            }
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.dbg);
            p.g(textView2, "full_action_bar_title");
            textView2.setVisibility(0);
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.dbg);
            p.g(textView3, "full_action_bar_title");
            textView3.setText(getMMTitle());
        }
    }

    public boolean isOtherEnableFullScreenEnjoy() {
        y yVar = y.vXH;
        return y.isOtherEnableFullScreenEnjoy();
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public boolean isHideStatusBar() {
        return isOtherEnableFullScreenEnjoy();
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\u0006*\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "M", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ FinderLoaderFeedUI ubJ;

        a(FinderLoaderFeedUI finderLoaderFeedUI) {
            this.ubJ = finderLoaderFeedUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245410);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.ubJ.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI$fixActionBarStatus$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245410);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        M ddM = ddM();
        Intent intent = getIntent();
        p.g(intent, "intent");
        BaseFeedLoader.saveCache$default(ddM, intent, ddM().getInitPos(), null, 4, null);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        ddK().onBackPressed();
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        ddK().onUIResume();
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        ddK().onUIPause();
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        ddK().onDetach();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        FinderVideoLayout finderVideoLayout;
        long j2;
        super.onActivityResult(i2, i3, intent);
        if (isOtherEnableFullScreenEnjoy() && -1 == i3 && i2 == 101) {
            RecyclerView recyclerView = ddL().tLS.getRecyclerView();
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
                    Log.i("FinderLoaderFeedUI", "[onActivityResult] feedId=" + com.tencent.mm.ac.d.zs(longExtra) + " seekTime=" + j2);
                    if (j2 != -1) {
                        finderVideoLayout.setStartPlayTime(j2);
                    }
                }
            }
        }
    }
}
