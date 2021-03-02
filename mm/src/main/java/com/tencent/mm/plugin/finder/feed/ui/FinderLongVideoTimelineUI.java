package com.tencent.mm.plugin.finder.feed.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoFavTLUIC;
import com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoLikeTLUIC;
import com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoNormalTLUIC;
import com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoProfileTLUIC;
import com.tencent.mm.plugin.finder.megavideo.uic.FinderMegaVideoShareTLUIC;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.statusbar.d;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "router", "", "getRouter", "()I", "setRouter", "(I)V", "getCommentScene", "getForceOrientation", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public class FinderLongVideoTimelineUI extends MMFinderUI {
    public static final a ubS = new a((byte) 0);
    private HashMap _$_findViewCache;
    private int ubR;

    static {
        AppMethodBeat.i(245432);
        AppMethodBeat.o(245432);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245434);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245434);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245433);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245433);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI$Companion;", "", "()V", "TAG", "", "getMegaVideoCommentScene", "", "router", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static int IS(int i2) {
            switch (i2) {
                case 0:
                case 5:
                    return 45;
                case 1:
                    return 47;
                case 2:
                    return 46;
                case 3:
                    return 48;
                case 4:
                    return 53;
                default:
                    return 0;
            }
        }
    }

    public FinderLongVideoTimelineUI() {
        this.vPS = true;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public Set<Class<? extends UIComponent>> importUIComponents() {
        Class cls;
        AppMethodBeat.i(245429);
        this.ubR = getIntent().getIntExtra("KEY_ROUTER_UI", 0);
        switch (this.ubR) {
            case 0:
                cls = FinderMegaVideoNormalTLUIC.class;
                break;
            case 1:
                cls = FinderMegaVideoFavTLUIC.class;
                break;
            case 2:
                cls = FinderMegaVideoLikeTLUIC.class;
                break;
            case 3:
                cls = FinderMegaVideoProfileTLUIC.class;
                break;
            case 4:
                cls = FinderMegaVideoShareTLUIC.class;
                break;
            case 5:
                cls = FinderMegaVideoNormalTLUIC.class;
                break;
            default:
                cls = FinderMegaVideoNormalTLUIC.class;
                break;
        }
        Set<Class<? extends UIComponent>> of = ak.setOf((Object[]) new Class[]{cls, FinderCommentDrawerUIC.class});
        AppMethodBeat.o(245429);
        return of;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(245430);
        super.onCreate(bundle);
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(1792);
        d.e(getWindow());
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        setNavigationbarColor(getResources().getColor(R.color.ac_));
        AppMethodBeat.o(245430);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(260260);
        super.onBackPressed();
        overridePendingTransition(R.anim.s, R.anim.ej);
        AppMethodBeat.o(260260);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 4;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(245431);
        int IS = a.IS(this.ubR);
        AppMethodBeat.o(245431);
        return IS;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }
}
