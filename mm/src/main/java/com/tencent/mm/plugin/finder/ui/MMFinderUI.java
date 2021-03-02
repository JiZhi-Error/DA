package com.tencent.mm.plugin.finder.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.cx;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.v;
import com.tencent.mm.plugin.finder.utils.j;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\f\b&\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0018\u0010\u0016\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J \u0010\u001b\u001a\u00020\u00112\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u001dj\b\u0012\u0004\u0012\u00020\u0019`\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0011H\u0014J\b\u0010&\u001a\u00020\u0011H\u0014J\b\u0010'\u001a\u00020\u0011H\u0014J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0013H\u0017J\b\u0010*\u001a\u00020\u0011H\u0016J\b\u0010+\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "activeFinish", "", "callOnce", "needChangeOrientation", "getNeedChangeOrientation", "()Z", "setNeedChangeOrientation", "(Z)V", "screenShotCallback", "com/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1;", "unInitTask", "Ljava/lang/Runnable;", "finish", "", "getCommentScene", "", "getLayoutId", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initBusiness", "initializeUIC", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setRequestedOrientation", "requestedOrientation", "uninitBusiness", "uninitBusinessCheck", "Companion", "plugin-finder_release"})
public abstract class MMFinderUI extends MMActivity {
    private static final String TAG = TAG;
    public static final a vPX = new a((byte) 0);
    private HashMap _$_findViewCache;
    public boolean vPS;
    private Runnable vPT;
    private boolean vPU;
    private boolean vPV;
    private final c vPW = new c(this);

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
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

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public void deh() {
    }

    public void dei() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void dAn() {
        if (!this.vPV) {
            dei();
            this.vPV = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.HashSet<com.tencent.mm.ui.component.UIComponent> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void initializeUIC(HashSet<UIComponent> hashSet) {
        p.h(hashSet, "uiComponents");
        super.initializeUIC(hashSet);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        hashSet.add(com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class));
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        hashSet.add(com.tencent.mm.ui.component.a.b(this).get(SecDataUIC.class));
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public Set<Class<? extends UIComponent>> importUIComponents() {
        return null;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return 0;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + this.vPU);
        if (!this.vPU) {
            dAn();
        }
        j jVar = j.vVA;
        j.dBH();
        ((PluginFinder) g.ah(PluginFinder.class)).onExitFinder(this);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        ((PluginFinder) g.ah(PluginFinder.class)).getFinderSyncExtension().b(this);
        Log.i(TAG, "onPause " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + this.vPT);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dtI().value().intValue() == 1) {
            Log.i(TAG, "REPORT_WHEN_SCREEN_SHOT remove");
            ScreenShotUtil.setScreenShotCallback(this, null);
        }
        Runnable runnable = this.vPT;
        if (runnable != null) {
            runnable.run();
        }
        this.vPT = null;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.i(TAG, "onCreate " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + '}');
        ((PluginFinder) g.ah(PluginFinder.class)).onEnterFinder(this);
        v vVar = v.vGG;
        v.dyK();
        j jVar = j.vVA;
        j.dBG();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        ((PluginFinder) g.ah(PluginFinder.class)).getFinderSyncExtension().a(this);
        Log.i(TAG, "onResume " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (((Boolean) com.tencent.mm.plugin.finder.storage.c.dtk().value()).booleanValue()) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, Class.forName("com.tencent.testcrash")));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dtI().value().intValue() == 1) {
            Log.i(TAG, "REPORT_WHEN_SCREEN_SHOT register");
            ScreenShotUtil.setScreenShotCallback(this, this.vPW);
        }
        deh();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        super.finish();
        Log.i(TAG, "finish " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + isPaused());
        if (isPaused()) {
            dei();
        } else {
            this.vPT = new b(this);
        }
        this.vPU = true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ MMFinderUI vPY;

        b(MMFinderUI mMFinderUI) {
            this.vPY = mMFinderUI;
        }

        public final void run() {
            AppMethodBeat.i(252804);
            this.vPY.dAn();
            AppMethodBeat.o(252804);
        }
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void setRequestedOrientation(int i2) {
        if (!this.vPS) {
            super.setRequestedOrientation(1);
        } else {
            super.setRequestedOrientation(i2);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
    }

    public int getCommentScene() {
        return 0;
    }

    public int ddN() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1", "Lcom/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotCallback;", "onScreenShot", "", "path", "", "dateAdded", "", "plugin-finder_release"})
    public static final class c implements ScreenShotUtil.ScreenShotCallback {
        final /* synthetic */ MMFinderUI vPY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(MMFinderUI mMFinderUI) {
            this.vPY = mMFinderUI;
        }

        @Override // com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback
        public final void onScreenShot(String str, long j2) {
            String str2;
            AppMethodBeat.i(252805);
            try {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                e c2 = FinderReporterUIC.c((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vPY).get(FinderReporterUIC.class));
                if (c2 instanceof o) {
                    LinkedList linkedList = new LinkedList();
                    for (Map.Entry<Long, com.tencent.mm.plugin.finder.report.p> entry : ((o) c2).vfK.entrySet()) {
                        alc alc = new alc();
                        alc.hFK = entry.getValue().feedId;
                        FinderItem finderItem = entry.getValue().tHo;
                        if (finderItem == null || (str2 = finderItem.getUserName()) == null) {
                            str2 = "";
                        }
                        alc.finderUsername = str2;
                        k kVar = k.vfA;
                        String G = k.G(alc.hFK, c2.ttO.tCE);
                        if (G == null) {
                            G = "";
                        }
                        alc.sessionBuffer = G;
                        linkedList.add(alc);
                    }
                    g.azz().b(new cx(linkedList));
                    AppMethodBeat.o(252805);
                    return;
                }
                Log.i(MMFinderUI.TAG, "onScreenShot: not FinderSingleFeedFlowReporter");
                AppMethodBeat.o(252805);
            } catch (Throwable th) {
                Log.printErrStackTrace(MMFinderUI.TAG, th, "onScreenShot", new Object[0]);
                AppMethodBeat.o(252805);
            }
        }
    }
}
