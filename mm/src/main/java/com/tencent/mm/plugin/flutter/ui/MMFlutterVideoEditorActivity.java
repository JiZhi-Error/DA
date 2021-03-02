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
import com.tencent.mm.plugin.flutter.PluginFlutter;
import com.tencent.mm.plugin.recordvideo.res.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tavkit.component.TAVExporter;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.a;
import io.flutter.plugin.platform.b;

public class MMFlutterVideoEditorActivity extends HellActivity implements LifecycleOwner, a {
    private LifecycleRegistry crq = new LifecycleRegistry(this);
    private boolean qMl;
    private a wJi;
    boolean wKL;
    private FlutterView wKM;
    private b wKN;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MMFlutterVideoEditorActivity() {
        AppMethodBeat.i(240966);
        AppMethodBeat.o(240966);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(240967);
        super.onCreate(bundle);
        com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF.cMT();
        g.BYp.bbA();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        getWindow().setStatusBarColor(WebView.NIGHT_MODE_COLOR);
        getWindow().setNavigationBarColor(WebView.NIGHT_MODE_COLOR);
        this.qMl = getIntent().getBooleanExtra("first_create", false);
        ((PluginFlutter) com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().a(this);
        ((PluginFlutter) com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr();
        this.wJi = ((PluginFlutter) com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().wJi;
        FrameLayout frameLayout = new FrameLayout(this);
        this.wKM = new FlutterView(this, FlutterView.c.transparent);
        frameLayout.addView(this.wKM);
        setContentView(frameLayout);
        this.wKL = true;
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        }
        setResult(0);
        AppMethodBeat.o(240967);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(240968);
        super.onDestroy();
        Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onDestroy %s", Integer.valueOf(hashCode()));
        if (this.wKN != null) {
            this.wKN.destroy();
        }
        this.wKN = null;
        ((PluginFlutter) com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().onDestroy();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        AppMethodBeat.o(240968);
    }

    public void onStart() {
        AppMethodBeat.i(240969);
        super.onStart();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_START);
        Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onStart %s", Integer.valueOf(hashCode()));
        try {
            this.wKN = new b(this, this.wJi.SOe);
            this.wKM.d(this.wJi);
            this.wJi.SNX.a(this, getLifecycle());
            ((PluginFlutter) com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().c(this);
            AppMethodBeat.o(240969);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Flutter.MMBaseFlutterActivity", e2, "onStart", new Object[0]);
            AppMethodBeat.o(240969);
        }
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onStop() {
        AppMethodBeat.i(240970);
        super.onStop();
        Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onStop %s", Integer.valueOf(hashCode()));
        try {
            this.wJi.SNX.hwK();
            ((PluginFlutter) com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().d(this);
            ((PluginFlutter) com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr();
            this.wKM.hwy();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Flutter.MMBaseFlutterActivity", e2, "onStop", new Object[0]);
        }
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        AppMethodBeat.o(240970);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(240971);
        super.onResume();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onResume %s", Integer.valueOf(hashCode()));
        ((PluginFlutter) com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().b(this);
        AppMethodBeat.o(240971);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(240972);
        super.onPause();
        this.crq.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        Log.i("MicroMsg.Flutter.MMBaseFlutterActivity", "onPause %s", Integer.valueOf(hashCode()));
        ((PluginFlutter) com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr();
        AppMethodBeat.o(240972);
    }

    @Override // com.tencent.mm.plugin.flutter.ui.a
    public final Activity getActivity() {
        return this;
    }

    public void onBackPressed() {
        AppMethodBeat.i(240973);
        ((PluginFlutter) com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().fP(this);
        AppMethodBeat.o(240973);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(240974);
        super.onActivityResult(i2, i3, intent);
        ((PluginFlutter) com.tencent.mm.kernel.g.ah(PluginFlutter.class)).getFlutterEngineMgr().gA(i2, i3);
        AppMethodBeat.o(240974);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(240975);
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(240975);
    }

    @Override // android.arch.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.crq;
    }
}
