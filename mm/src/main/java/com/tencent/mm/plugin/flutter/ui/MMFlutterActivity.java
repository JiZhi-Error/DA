package com.tencent.mm.plugin.flutter.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tavkit.component.TAVExporter;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.a;
import io.flutter.plugin.platform.b;

public class MMFlutterActivity extends HellActivity implements LifecycleOwner, a {
    private LifecycleRegistry crq = new LifecycleRegistry(this);
    private boolean qMl;
    private a wJi;
    boolean wKL;
    private FlutterView wKM;
    private b wKN;
    boolean wKO;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MMFlutterActivity() {
        AppMethodBeat.i(240964);
        AppMethodBeat.o(240964);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(148876);
        super.onCreate(bundle);
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        getWindow().setStatusBarColor(WebView.NIGHT_MODE_COLOR);
        getWindow().setNavigationBarColor(WebView.NIGHT_MODE_COLOR);
        this.qMl = getIntent().getBooleanExtra("first_create", false);
        ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr().a(this);
        ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr();
        this.wJi = ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr().wJi;
        FrameLayout frameLayout = new FrameLayout(this);
        this.wKO = getIntent().getBooleanExtra("videoEditor", false);
        if (this.wKO) {
            com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF.cMT();
            com.tencent.mm.plugin.recordvideo.res.g.BYp.bbA();
            this.wKM = new FlutterView(this, FlutterView.c.transparent);
            setResult(0);
        } else {
            this.wKM = new FlutterView(this);
        }
        frameLayout.addView(this.wKM);
        setContentView(frameLayout);
        this.wKL = true;
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        }
        AppMethodBeat.o(148876);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(148877);
        super.onDestroy();
        Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onDestroy %s", Integer.valueOf(hashCode()));
        if (this.wKN != null) {
            this.wKN.destroy();
        }
        this.wKN = null;
        ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr().onDestroy();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        AppMethodBeat.o(148877);
    }

    public void onStart() {
        AppMethodBeat.i(148878);
        super.onStart();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_START);
        Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onStart %s", Integer.valueOf(hashCode()));
        try {
            this.wKN = new b(this, this.wJi.SOe);
            this.wKM.d(this.wJi);
            this.wJi.SNX.a(this, getLifecycle());
            ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr().c(this);
            AppMethodBeat.o(148878);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Flutter.MMBaseFlutterActivity", e2, "onStart", new Object[0]);
            AppMethodBeat.o(148878);
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onStop() {
        AppMethodBeat.i(148879);
        super.onStop();
        Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onStop %s", Integer.valueOf(hashCode()));
        try {
            this.wJi.SNX.hwK();
            ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr().d(this);
            ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr();
            this.wKM.hwy();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Flutter.MMBaseFlutterActivity", e2, "onStop", new Object[0]);
        }
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        AppMethodBeat.o(148879);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(148880);
        super.onResume();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onResume %s", Integer.valueOf(hashCode()));
        ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr().b(this);
        AppMethodBeat.o(148880);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(148881);
        if (!this.wKO) {
            overridePendingTransition(0, 0);
        }
        super.onPause();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onPause %s", Integer.valueOf(hashCode()));
        ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr();
        AppMethodBeat.o(148881);
    }

    @Override // com.tencent.mm.plugin.flutter.ui.a
    public final Activity getActivity() {
        return this;
    }

    public void onBackPressed() {
        AppMethodBeat.i(148885);
        ((PluginFlutter) g.ah(PluginFlutter.class)).getFlutterEngineMgr().fP(this);
        AppMethodBeat.o(148885);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(148887);
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(148887);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(240965);
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(240965);
    }

    @Override // android.arch.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.crq;
    }
}
