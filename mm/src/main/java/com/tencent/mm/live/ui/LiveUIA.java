package com.tencent.mm.live.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.live.a.a;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.w;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.view.BaseLivePluginLayout;
import com.tencent.mm.plugin.ball.a.e;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.xwalk.core.XWalkEnvironment;

@com.tencent.mm.ui.base.a(35)
@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\"\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0014J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0018\u001a\u00020\bH\u0014J\b\u0010\u0019\u001a\u00020\bH\u0014J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0014J\b\u0010\u001c\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/live/ui/LiveUIA;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "roomLivePageFloatBallHelper", "Lcom/tencent/mm/live/model/RoomLivePageFloatBallHelper;", "uiRouter", "Lcom/tencent/mm/live/controller/LiveUIRouter;", "addKeyBoardListener", "", "getForceOrientation", "", "getLayoutId", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "onPause", "onResume", "onStart", "onStop", "setWindowStyle", "Companion", "plugin-logic_release"})
public class LiveUIA extends MMActivity {
    public static final a hTT = new a((byte) 0);
    private com.tencent.mm.live.a.a hTR;
    private w hTS;

    static {
        AppMethodBeat.i(208376);
        AppMethodBeat.o(208376);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/ui/LiveUIA$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b1g;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(208366);
        Log.i("MicroMsg.LiveUI", "onCreate (" + hashCode() + ')');
        super.onCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        setSelfNavigationBarVisible(8);
        getWindow().addFlags(2097280);
        getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(67108864);
            Window window = getWindow();
            p.g(window, "window");
            View decorView = window.getDecorView();
            p.g(decorView, "window.decorView");
            decorView.setSystemUiVisibility(1792);
            getWindow().addFlags(Integer.MIN_VALUE);
            Window window2 = getWindow();
            p.g(window2, "window");
            window2.setStatusBarColor(0);
            Window window3 = getWindow();
            p.g(window3, "window");
            window3.setNavigationBarColor(0);
        }
        getWindow().setFormat(-3);
        getWindow().setSoftInputMode(51);
        View findViewById = findViewById(R.id.emr);
        p.g(findViewById, "findViewById(R.id.live_ui_root)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        LiveConfig liveConfig = (LiveConfig) getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
        boolean booleanExtra = getIntent().getBooleanExtra("key_is_live_finished", false);
        LiveUIA liveUIA = this;
        if (frameLayout == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(208366);
            throw tVar;
        }
        this.hTR = new com.tencent.mm.live.a.a(liveUIA, frameLayout, liveConfig, booleanExtra);
        com.tencent.mm.live.a.a aVar = this.hTR;
        if (aVar != null) {
            Object systemService = aVar.context.getSystemService("phone");
            if (systemService == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
                AppMethodBeat.o(208366);
                throw tVar2;
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            com.tencent.mm.hellhoundlib.b.a bl = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(aVar.phoneStatelistener);
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/live/controller/LiveUIRouter", "onCreate", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/live/controller/LiveUIRouter", "onCreate", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        }
        x xVar = x.hJf;
        x.rc(liveConfig != null ? liveConfig.getFromScene() : LiveConfig.hvY);
        Integer valueOf = liveConfig != null ? Integer.valueOf(liveConfig.aBC()) : null;
        int i2 = LiveConfig.hvT;
        if (valueOf != null && valueOf.intValue() == i2) {
            x xVar2 = x.hJf;
            x.u(this, true);
            com.tencent.mm.live.a.a aVar2 = this.hTR;
            if (aVar2 != null) {
                o.k kVar = o.k.hHn;
                aVar2.qp(o.k.aFM());
            }
        } else {
            int i3 = LiveConfig.hvU;
            if (valueOf != null && valueOf.intValue() == i3) {
                x xVar3 = x.hJf;
                x.u(this, false);
                com.tencent.mm.live.a.a aVar3 = this.hTR;
                if (aVar3 != null) {
                    o.k kVar2 = o.k.hHn;
                    aVar3.qp(o.k.aFN());
                }
            }
        }
        this.hTS = new w(new e(this));
        w wVar = this.hTS;
        if (wVar != null) {
            wVar.G(21, b.cjf());
            AppMethodBeat.o(208366);
            return;
        }
        AppMethodBeat.o(208366);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(208367);
        Log.i("MicroMsg.LiveUI", "onResume (" + hashCode() + ')');
        super.onResume();
        com.tencent.mm.live.a.a aVar = this.hTR;
        if (aVar != null) {
            Log.i(aVar.TAG, "onResume " + aVar.hwp);
            BaseLivePluginLayout baseLivePluginLayout = aVar.hwp;
            if (baseLivePluginLayout != null) {
                baseLivePluginLayout.resume();
            }
            BaseLivePluginLayout baseLivePluginLayout2 = aVar.hwp;
            if (baseLivePluginLayout2 != null) {
                baseLivePluginLayout2.post(new a.b(aVar));
            }
        }
        w wVar = this.hTS;
        if (wVar != null) {
            wVar.aGf();
        }
        f.cjk();
        AppMethodBeat.o(208367);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(208368);
        Log.i("MicroMsg.LiveUI", "onStart (" + hashCode() + ')');
        super.onStart();
        com.tencent.mm.live.a.a aVar = this.hTR;
        if (aVar != null) {
            Log.i(aVar.TAG, "onStart " + aVar.hwp);
            try {
                z = Settings.System.getInt(XWalkEnvironment.getContentResolver(), "accelerometer_rotation") == 1;
            } catch (Settings.SettingNotFoundException e2) {
                Log.printErrStackTrace(aVar.TAG, e2, "", new Object[0]);
                z = false;
            }
            BaseLivePluginLayout baseLivePluginLayout = aVar.hwp;
            if (baseLivePluginLayout != null) {
                if (!z || !aVar.sp.getBoolean("settings_landscape_mode", false)) {
                    z2 = false;
                }
                baseLivePluginLayout.onRotationSwitchChange(z2);
            }
            a.C0369a aVar2 = aVar.hwm;
            aVar2.hwt.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, aVar2);
            BaseLivePluginLayout baseLivePluginLayout2 = aVar.hwp;
            if (baseLivePluginLayout2 != null) {
                baseLivePluginLayout2.start();
                AppMethodBeat.o(208368);
                return;
            }
            AppMethodBeat.o(208368);
            return;
        }
        AppMethodBeat.o(208368);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(208369);
        Log.i("MicroMsg.LiveUI", "onPause (" + hashCode() + ')');
        super.onPause();
        com.tencent.mm.live.a.a aVar = this.hTR;
        if (aVar != null) {
            Log.i(aVar.TAG, "onPause " + aVar.hwp);
            BaseLivePluginLayout baseLivePluginLayout = aVar.hwp;
            if (baseLivePluginLayout != null) {
                baseLivePluginLayout.pause();
            }
        }
        w wVar = this.hTS;
        if (wVar != null) {
            wVar.aGj();
        }
        f.cji();
        AppMethodBeat.o(208369);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(208370);
        Log.i("MicroMsg.LiveUI", "onActivityResult (" + hashCode() + ')');
        super.onActivityResult(i2, i3, intent);
        com.tencent.mm.live.a.a aVar = this.hTR;
        if (aVar != null) {
            Log.i(aVar.TAG, "onActivityResult " + aVar.hwp);
            BaseLivePluginLayout baseLivePluginLayout = aVar.hwp;
            if (baseLivePluginLayout != null) {
                baseLivePluginLayout.onActivityResult(i2, i3, intent);
                AppMethodBeat.o(208370);
                return;
            }
            AppMethodBeat.o(208370);
            return;
        }
        AppMethodBeat.o(208370);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        AppMethodBeat.i(208371);
        x xVar = x.hJf;
        if (x.aGF().hJg) {
            Intent intent = getIntent();
            if (intent == null || !intent.getBooleanExtra("key_is_live_finished", false)) {
                AppMethodBeat.o(208371);
                return 14;
            }
            AppMethodBeat.o(208371);
            return 1;
        }
        AppMethodBeat.o(208371);
        return 1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(208372);
        Log.i("MicroMsg.LiveUI", "onStop (" + hashCode() + ')');
        super.onStop();
        com.tencent.mm.live.a.a aVar = this.hTR;
        if (aVar != null) {
            Log.i(aVar.TAG, "onStop " + aVar.hwp);
            a.C0369a aVar2 = aVar.hwm;
            aVar2.hwt.unregisterContentObserver(aVar2);
            h hVar = aVar.gyh;
            if (hVar != null) {
                hVar.close();
            }
            BaseLivePluginLayout baseLivePluginLayout = aVar.hwp;
            if (baseLivePluginLayout != null) {
                baseLivePluginLayout.stop();
                AppMethodBeat.o(208372);
                return;
            }
            AppMethodBeat.o(208372);
            return;
        }
        AppMethodBeat.o(208372);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(208373);
        Log.i("MicroMsg.LiveUI", "onDestroy (" + hashCode() + ')');
        super.onDestroy();
        com.tencent.mm.live.a.a aVar = this.hTR;
        if (aVar != null) {
            aVar.onDestroy();
        }
        w wVar = this.hTS;
        if (wVar != null) {
            wVar.onDestroy();
            AppMethodBeat.o(208373);
            return;
        }
        AppMethodBeat.o(208373);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        boolean z;
        AppMethodBeat.i(208374);
        com.tencent.mm.live.a.a aVar = this.hTR;
        if (aVar != null) {
            BaseLivePluginLayout baseLivePluginLayout = aVar.hwp;
            if (baseLivePluginLayout != null) {
                z = baseLivePluginLayout.onBackPress();
            } else {
                z = false;
            }
            if (!z) {
                super.onBackPressed();
            }
            AppMethodBeat.o(208374);
            return;
        }
        AppMethodBeat.o(208374);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        com.tencent.mm.live.a.a aVar;
        AppMethodBeat.i(208375);
        Log.i("MicroMsg.LiveUI", "onNewIntent (" + hashCode() + ')');
        super.onNewIntent(intent);
        if (intent == null) {
            AppMethodBeat.o(208375);
        } else if (!intent.getBooleanExtra("route_to_maximize", false) || (aVar = this.hTR) == null) {
            AppMethodBeat.o(208375);
        } else {
            BaseLivePluginLayout baseLivePluginLayout = aVar.hwp;
            if (baseLivePluginLayout != null) {
                b.C0376b.a(baseLivePluginLayout, b.c.hLR);
                AppMethodBeat.o(208375);
                return;
            }
            AppMethodBeat.o(208375);
        }
    }
}
