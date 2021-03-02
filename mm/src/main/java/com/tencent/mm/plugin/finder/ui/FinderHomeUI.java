package com.tencent.mm.plugin.finder.ui;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedFriendLikeDrawerUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeActionBarUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLikeGuideUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLocationUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderPostQualificationUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\u0019\u001a\u00020\u0004H\u0014¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "backToFindPage", "", "checkJumpFollow", "intent", "Landroid/content/Intent;", "checkJumpFriend", "checkJumpHot", "finish", "getCommentScene", "", "getLayoutId", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "isHideStatusBar", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "onResume", "Companion", "plugin-finder_release"})
public final class FinderHomeUI extends MMFinderUI {
    public static final a vKx = new a((byte) 0);
    private HashMap _$_findViewCache;

    static {
        AppMethodBeat.i(252431);
        AppMethodBeat.o(252431);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252433);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252433);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252432);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252432);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderHomeUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(252422);
        Set<Class<? extends UIComponent>> of = ak.setOf((Object[]) new Class[]{FinderHomeUIC.class, FinderHomeActionBarUIC.class, FinderCommentDrawerUIC.class, FinderFeedFriendLikeDrawerUIC.class, FinderLocationUIC.class, MediaPreloadCore.class, FinderReporterUIC.class, FinderPostQualificationUIC.class, FinderLikeGuideUIC.class});
        AppMethodBeat.o(252422);
        return of;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ac8;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        AppMethodBeat.i(252423);
        k kVar = k.vfA;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        int Kw = k.Kw(((FinderHomeUIC) com.tencent.mm.ui.component.a.b(this).get(FinderHomeUIC.class)).dIf());
        AppMethodBeat.o(252423);
        return Kw;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean isHideStatusBar() {
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(252424);
        super.onNewIntent(intent);
        ao(intent);
        an(intent);
        ap(intent);
        if (intent != null) {
            getIntent().putExtra("KEY_POST_DIRECTLY_FROM_SNS", intent.getBooleanExtra("KEY_POST_DIRECTLY_FROM_SNS", false));
            getIntent().putExtra("key_finder_post_local_id", intent.getLongExtra("key_finder_post_local_id", -1));
            AppMethodBeat.o(252424);
            return;
        }
        AppMethodBeat.o(252424);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(252425);
        super.onCreate(bundle);
        e.INSTANCE.idkeyStat(1279, 41, 1, false);
        if (getIntent().getBooleanExtra("key_form_sns", false)) {
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Intent intent = new Intent();
            FinderSelfUI.a aVar2 = FinderSelfUI.vOh;
            intent.putExtra(FinderSelfUI.vOg, true);
            com.tencent.mm.plugin.finder.utils.a.z(this, intent);
        }
        ao(getIntent());
        an(getIntent());
        ap(getIntent());
        AppMethodBeat.o(252425);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        com.tencent.mm.plugin.finder.report.e c2;
        AppMethodBeat.i(252426);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this);
        if (!(fH == null || (c2 = FinderReporterUIC.c(fH)) == null || !(c2 instanceof o))) {
            e.a aVar2 = com.tencent.mm.plugin.finder.report.e.vdS;
            ((o) c2).auL(e.a.ah(ae.b(s.U("feedActionType", 5))));
        }
        if (getIntent().getBooleanExtra("KEY_FROM_SHARE_REL", false)) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 2);
            c.f(this, ".ui.LauncherUI", intent);
            overridePendingTransition(R.anim.em, R.anim.er);
            AppMethodBeat.o(252426);
            return;
        }
        super.finish();
        AppMethodBeat.o(252426);
    }

    private final void an(Intent intent) {
        AppMethodBeat.i(252427);
        boolean booleanExtra = intent != null ? intent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", false) : false;
        Intent intent2 = getIntent();
        if (intent2 != null) {
            intent2.putExtra("KEY_FINDER_POST_FINISH_JUMP_FRIEND_TAB", booleanExtra);
        }
        if (booleanExtra) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderVideoRecycler) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).dIQ();
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.b(this).get(FinderHomeUIC.class);
            p.g(viewModel, "UICProvider.of(this).get…inderHomeUIC::class.java)");
            Bundle bundle = new Bundle();
            bundle.putInt("Source", 0);
            ((FinderHomeUIC) viewModel).p(1, bundle);
        }
        AppMethodBeat.o(252427);
    }

    private final void ao(Intent intent) {
        boolean z;
        AppMethodBeat.i(252428);
        if (intent != null) {
            z = intent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", false);
        } else {
            z = false;
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            intent2.putExtra("KEY_FINDER_POST_FINISH_JUMP_FOLLOW_TAB", z);
        }
        if (z) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderVideoRecycler) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).dIQ();
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.b(this).get(FinderHomeUIC.class);
            p.g(viewModel, "UICProvider.of(this).get…inderHomeUIC::class.java)");
            Bundle bundle = new Bundle();
            bundle.putInt("Source", 0);
            ((FinderHomeUIC) viewModel).p(3, bundle);
        }
        AppMethodBeat.o(252428);
    }

    private final void ap(Intent intent) {
        boolean z;
        boolean z2;
        int i2;
        AppMethodBeat.i(252429);
        if (intent != null) {
            z = intent.getBooleanExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", false);
        } else {
            z = false;
        }
        if (intent != null) {
            z2 = intent.getBooleanExtra("KEY_FINDER_JUMP_HOT_TAB_WITH_ANIM", true);
        } else {
            z2 = false;
        }
        if (intent != null) {
            i2 = intent.getIntExtra("Source", 0);
        } else {
            i2 = 0;
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            intent2.putExtra("KEY_FINDER_POST_FINISH_JUMP_HOT_TAB", z);
        }
        if (z) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderVideoRecycler) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).dIQ();
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.b(this).get(FinderHomeUIC.class);
            p.g(viewModel, "UICProvider.of(this).get…inderHomeUIC::class.java)");
            Bundle bundle = new Bundle();
            bundle.putInt("Source", i2);
            ((FinderHomeUIC) viewModel).a(z2, bundle);
        }
        AppMethodBeat.o(252429);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(252430);
        super.onResume();
        y yVar = y.vXH;
        if (!y.isAnyHomeTabEnableFullScreenEnjoy()) {
            y yVar2 = y.vXH;
            Window window = getWindow();
            p.g(window, "window");
            y.b(window, !ao.isDarkMode());
        }
        AppMethodBeat.o(252430);
    }
}
