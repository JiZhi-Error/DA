package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.collection.CollectionFolderActivityContext;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@i
@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/IFolderActivityContext;", "()V", "mFolderContextImpl", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showListPage", "showList", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherFolderUI extends MMActivity implements com.tencent.mm.plugin.appbrand.ui.launcher.a {
    public static final a nTH = new a((byte) 0);
    private HashMap _$_findViewCache;
    private FolderActivityContextWithLifecycle nTG;

    static {
        AppMethodBeat.i(51114);
        AppMethodBeat.o(51114);
    }

    public static final void m(Context context, Intent intent) {
        AppMethodBeat.i(51115);
        a.m(context, intent);
        AppMethodBeat.o(51115);
    }

    public static final void n(Context context, Intent intent) {
        AppMethodBeat.i(51116);
        a.n(context, intent);
        AppMethodBeat.o(51116);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(229481);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(229481);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(229480);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(229480);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        CollectionFolderActivityContext collectionFolderActivityContext;
        AppMethodBeat.i(51110);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(51110);
            return;
        }
        overridePendingTransition(0, 0);
        if (com.tencent.mm.ui.base.b.bg(getClass()) && !ao.gJN()) {
            super.overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
        }
        int intExtra = getIntent().getIntExtra("KEY_MODE", 0);
        switch (intExtra) {
            case 1:
                collectionFolderActivityContext = new RecentsFolderActivityContext(this);
                this.nTG = collectionFolderActivityContext;
                break;
            case 2:
                collectionFolderActivityContext = new CollectionFolderActivityContext(this);
                this.nTG = collectionFolderActivityContext;
                break;
            default:
                Log.e("MicroMsg.AppBrandLauncherFolderUI", "onCreate with invalid mode(" + intExtra + ')');
                finish();
                break;
        }
        setActionbarColor(getContext().getResources().getColor(R.color.a2r));
        getContentView().setBackgroundColor(getActionbarColor());
        setBackBtn(new b(this));
        setTitleBarDoubleClickListener(new c(this));
        Lifecycle lifecycle = getLifecycle();
        FolderActivityContextWithLifecycle folderActivityContextWithLifecycle = this.nTG;
        if (folderActivityContextWithLifecycle == null) {
            p.hyc();
        }
        lifecycle.addObserver(folderActivityContextWithLifecycle);
        AppMethodBeat.o(51110);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ AppBrandLauncherFolderUI nTI;

        b(AppBrandLauncherFolderUI appBrandLauncherFolderUI) {
            this.nTI = appBrandLauncherFolderUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(51108);
            this.nTI.finish();
            AppMethodBeat.o(51108);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ AppBrandLauncherFolderUI nTI;

        c(AppBrandLauncherFolderUI appBrandLauncherFolderUI) {
            this.nTI = appBrandLauncherFolderUI;
        }

        public final void run() {
            AppMethodBeat.i(51109);
            Fragment findFragmentById = this.nTI.getSupportFragmentManager().findFragmentById(16908290);
            if (!(findFragmentById instanceof AppBrandLauncherUI.Fragment)) {
                findFragmentById = null;
            }
            AppBrandLauncherUI.Fragment fragment = (AppBrandLauncherUI.Fragment) findFragmentById;
            if (fragment != null) {
                fragment.bXb();
                AppMethodBeat.o(51109);
                return;
            }
            AppMethodBeat.o(51109);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.launcher.a
    public final void iI(boolean z) {
        AppMethodBeat.i(51111);
        FolderActivityContextWithLifecycle folderActivityContextWithLifecycle = this.nTG;
        if (folderActivityContextWithLifecycle != null) {
            folderActivityContextWithLifecycle.iI(z);
            AppMethodBeat.o(51111);
            return;
        }
        AppMethodBeat.o(51111);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(51112);
        if (isFinishing()) {
            AppMethodBeat.o(51112);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(51112);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(51113);
        if (isFinishing() || isDestroyed()) {
            AppMethodBeat.o(51113);
            return;
        }
        super.finish();
        AppMethodBeat.o(51113);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u001c\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion;", "", "()V", "KEY_MODE_INT", "", "MODE_COLLECTION", "", "MODE_RECENTS", "startCollectionList", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "startRecentsList", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void m(Context context, Intent intent) {
            Bundle bundle;
            AppMethodBeat.i(51106);
            p.h(context, "context");
            Intent intent2 = new Intent(context, AppBrandLauncherFolderUI.class);
            if (!(context instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            if (intent == null || (bundle = intent.getExtras()) == null) {
                bundle = Bundle.EMPTY;
            }
            intent2.putExtras(bundle);
            intent2.putExtra("KEY_MODE", 1);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion", "startRecentsList", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion", "startRecentsList", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(51106);
        }

        public static void n(Context context, Intent intent) {
            Bundle bundle;
            AppMethodBeat.i(51107);
            p.h(context, "context");
            Intent intent2 = new Intent(context, AppBrandLauncherFolderUI.class);
            if (!(context instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            if (intent == null || (bundle = intent.getExtras()) == null) {
                bundle = Bundle.EMPTY;
            }
            intent2.putExtras(bundle);
            intent2.putExtra("KEY_MODE", 2);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion", "startCollectionList", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion", "startCollectionList", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(51107);
        }
    }
}
