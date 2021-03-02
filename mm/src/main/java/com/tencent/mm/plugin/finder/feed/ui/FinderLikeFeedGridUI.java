package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderLikeFeedGridFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderLikeMegaVideoFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLikeListTabUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLikeFeedGridUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderLikeFeedGridUI extends MMFinderUI {
    private final String TAG = "Finder.FinderLikeFeedGridUI";
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245320);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245320);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245319);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245319);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(245316);
        Set<Class<? extends UIComponent>> of = ak.setOf(FinderLikeListTabUIC.class);
        AppMethodBeat.o(245316);
        return of;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(245317);
        super.onCreate(bundle);
        setBackBtn(new a(this));
        AppMethodBeat.o(245317);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderLikeFeedGridUI ubk;

        a(FinderLikeFeedGridUI finderLikeFeedGridUI) {
            this.ubk = finderLikeFeedGridUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(245315);
            this.ubk.onBackPressed();
            AppMethodBeat.o(245315);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        FinderLikeMegaVideoLoader finderLikeMegaVideoLoader = null;
        FinderLikedFeedLoader finderLikedFeedLoader = null;
        AppMethodBeat.i(245318);
        Intent intent = new Intent();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderHomeTabFragment activeFragment = ((FinderLikeListTabUIC) com.tencent.mm.ui.component.a.b(this).get(FinderLikeListTabUIC.class)).getActiveFragment();
        switch (activeFragment.dLS) {
            case 102:
                if (!(activeFragment instanceof FinderLikeFeedGridFragment)) {
                    activeFragment = null;
                }
                FinderLikeFeedGridFragment finderLikeFeedGridFragment = (FinderLikeFeedGridFragment) activeFragment;
                if (finderLikeFeedGridFragment != null) {
                    finderLikedFeedLoader = finderLikeFeedGridFragment.dAv();
                }
                if (finderLikedFeedLoader != null) {
                    FinderSelfUI.a aVar2 = FinderSelfUI.vOh;
                    intent.putExtra(FinderSelfUI.vOe, finderLikedFeedLoader.gAZ);
                    break;
                }
                break;
            case 103:
                if (!(activeFragment instanceof FinderLikeMegaVideoFragment)) {
                    activeFragment = null;
                }
                FinderLikeMegaVideoFragment finderLikeMegaVideoFragment = (FinderLikeMegaVideoFragment) activeFragment;
                if (finderLikeMegaVideoFragment != null) {
                    finderLikeMegaVideoLoader = finderLikeMegaVideoFragment.dAw();
                }
                if (finderLikeMegaVideoLoader != null) {
                    FinderSelfUI.a aVar3 = FinderSelfUI.vOh;
                    intent.putExtra(FinderSelfUI.vOe, finderLikeMegaVideoLoader.gAZ);
                    break;
                }
                break;
        }
        setResult(-1, intent);
        super.onBackPressed();
        AppMethodBeat.o(245318);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 35;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 3;
    }
}
