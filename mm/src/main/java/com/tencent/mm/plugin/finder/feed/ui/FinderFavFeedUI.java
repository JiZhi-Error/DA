package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.c;
import com.tencent.mm.plugin.finder.feed.g;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavFeedFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavMegaVideoFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFavListTabUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0018\u00010\u0007H\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class FinderFavFeedUI extends MMFinderUI {
    public static final a tZM = new a((byte) 0);
    private HashMap _$_findViewCache;

    static {
        AppMethodBeat.i(245143);
        AppMethodBeat.o(245143);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245145);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245145);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245144);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245144);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245139);
        super.onCreate(bundle);
        setBackBtn(new b(this));
        AppMethodBeat.o(245139);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderFavFeedUI tZN;

        b(FinderFavFeedUI finderFavFeedUI) {
            this.tZN = finderFavFeedUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245138);
            this.tZN.onBackPressed();
            AppMethodBeat.o(245138);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(245140);
        Set<Class<? extends UIComponent>> of = ak.setOf(FinderFavListTabUIC.class);
        AppMethodBeat.o(245140);
        return of;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        FinderFavMegaVideoLoader finderFavMegaVideoLoader = null;
        FinderFavFeedLoader finderFavFeedLoader = null;
        AppMethodBeat.i(245141);
        Intent intent = new Intent();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderHomeTabFragment activeFragment = ((FinderFavListTabUIC) com.tencent.mm.ui.component.a.b(this).get(FinderFavListTabUIC.class)).getActiveFragment();
        switch (activeFragment.dLS) {
            case 100:
                if (!(activeFragment instanceof FinderFavFeedFragment)) {
                    activeFragment = null;
                }
                FinderFavFeedFragment finderFavFeedFragment = (FinderFavFeedFragment) activeFragment;
                if (finderFavFeedFragment != null) {
                    finderFavFeedLoader = finderFavFeedFragment.dAr();
                }
                if (finderFavFeedLoader != null) {
                    FinderSelfUI.a aVar2 = FinderSelfUI.vOh;
                    intent.putExtra(FinderSelfUI.vOe, finderFavFeedLoader.gAZ);
                    break;
                }
                break;
            case 101:
                if (!(activeFragment instanceof FinderFavMegaVideoFragment)) {
                    activeFragment = null;
                }
                FinderFavMegaVideoFragment finderFavMegaVideoFragment = (FinderFavMegaVideoFragment) activeFragment;
                if (finderFavMegaVideoFragment != null) {
                    finderFavMegaVideoLoader = finderFavMegaVideoFragment.dAt();
                }
                if (finderFavMegaVideoLoader != null) {
                    FinderSelfUI.a aVar3 = FinderSelfUI.vOh;
                    intent.putExtra(FinderSelfUI.vOe, finderFavMegaVideoLoader.gAZ);
                    break;
                }
                break;
        }
        setResult(-1, intent);
        super.onBackPressed();
        AppMethodBeat.o(245141);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 24;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 3;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        T t;
        g.a dAs;
        RecyclerView recyclerView;
        AppMethodBeat.i(245142);
        if (i2 == 10001 && i3 == -1 && intent != null) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            List<? extends FinderHomeTabFragment> list = ((FinderFavListTabUIC) com.tencent.mm.ui.component.a.b(this).get(FinderFavListTabUIC.class)).fragments;
            if (list == null) {
                p.btv("fragments");
            }
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (t.dLS == 100 && t.isVisible()) {
                    break;
                }
            }
            if (!(t instanceof FinderFavFeedFragment)) {
                t = null;
            }
            T t2 = t;
            if (t2 == null || (dAs = t2.dAs()) == null) {
                AppMethodBeat.o(245142);
                return;
            }
            p.h(intent, "data");
            c.b bVar = dAs.tMd;
            if (bVar == null || (recyclerView = bVar.tLS.getRecyclerView()) == null) {
                AppMethodBeat.o(245142);
                return;
            }
            y yVar = y.vXH;
            y.a(intent, recyclerView, dAs.tFM);
            AppMethodBeat.o(245142);
            return;
        }
        AppMethodBeat.o(245142);
    }
}
