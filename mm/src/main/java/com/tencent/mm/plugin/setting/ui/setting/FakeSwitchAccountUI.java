package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.SystemProperty;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.e;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@a(19)
public class FakeSwitchAccountUI extends MMActivity {
    private SwitchAccountGridView CYW;
    private View CYX;
    private View CYY;
    private ArrayList<SwitchAccountModel> CYZ;
    private Map<String, SwitchAccountModel> CZa = new HashMap();
    private MTimerHandler CZb;
    private int count;
    private String country;
    private float fontScale;
    private int gmK;
    private String klw;
    private TextView titleView;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FakeSwitchAccountUI() {
        AppMethodBeat.i(73883);
        AppMethodBeat.o(73883);
    }

    static /* synthetic */ int a(FakeSwitchAccountUI fakeSwitchAccountUI) {
        AppMethodBeat.i(73891);
        int eSJ = fakeSwitchAccountUI.eSJ();
        AppMethodBeat.o(73891);
        return eSJ;
    }

    static /* synthetic */ int d(FakeSwitchAccountUI fakeSwitchAccountUI) {
        int i2 = fakeSwitchAccountUI.count;
        fakeSwitchAccountUI.count = i2 + 1;
        return i2;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.br_;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73884);
        super.onCreate(bundle);
        this.country = getIntent().getStringExtra("key_langauage_code");
        this.fontScale = getIntent().getFloatExtra("key_font_scale_size", 1.0f);
        if (!Util.isNullOrNil(this.country)) {
            Log.i("MicroMsg.FakeSwitchAccountUI", "country %s", this.country);
            SystemProperty.setProperty(LocaleUtil.LANGUAGE_KEY, this.country);
            MMActivity.initLanguage(MMApplicationContext.getContext(), this.country);
        }
        Log.i("MicroMsg.FakeSwitchAccountUI", "fontScale %f", Float.valueOf(this.fontScale));
        com.tencent.mm.cb.a.h(MMApplicationContext.getContext(), this.fontScale);
        initView();
        AppMethodBeat.o(73884);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(73885);
        Log.i("MicroMsg.FakeSwitchAccountUI", "FakeSwitchAccount onCreate");
        setMMTitle("");
        getSupportActionBar().hide();
        getController().p(this, getResources().getColor(R.color.afz));
        this.titleView = (TextView) findViewById(R.id.if6);
        this.CYW = (SwitchAccountGridView) findViewById(R.id.if4);
        this.CYW.setRowCount(1);
        this.CYW.setClickable(false);
        this.gmK = getIntent().getIntExtra("key_mm_process_pid", 0);
        this.klw = getIntent().getStringExtra("key_switch_from_wx_username");
        Log.i("MicroMsg.FakeSwitchAccountUI", "title %s", getResources().getString(R.string.gv2));
        this.titleView.setText(getResources().getString(R.string.gv2));
        this.CYZ = getIntent().getParcelableArrayListExtra("key_switch_account_users");
        if (this.CYZ != null) {
            Iterator<SwitchAccountModel> it = this.CYZ.iterator();
            while (it.hasNext()) {
                SwitchAccountModel next = it.next();
                this.CZa.put(next.CXS, next);
            }
        }
        this.CYX = findViewById(R.id.if2);
        this.CYX.setVisibility(8);
        this.CYY = findViewById(R.id.if0);
        this.CYY.setVisibility(8);
        Log.i("MicroMsg.FakeSwitchAccountUI", "account count %d", Integer.valueOf(this.CZa.size()));
        this.CYW.setUseSystemDecoder(true);
        this.CYW.aG(this.CZa);
        this.CYW.setLastLoginWxUsername(this.klw);
        this.CYW.setLogoutState(true);
        this.CYW.eTN();
        this.CZb = new MTimerHandler(Looper.myLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(73882);
                int a2 = FakeSwitchAccountUI.a(FakeSwitchAccountUI.this);
                Log.i("MicroMsg.FakeSwitchAccountUI", "oldPid %d, mm pid %d", Integer.valueOf(FakeSwitchAccountUI.this.gmK), Integer.valueOf(a2));
                if (FakeSwitchAccountUI.this.gmK == 0 || a2 == 0 || FakeSwitchAccountUI.this.gmK == a2) {
                    FakeSwitchAccountUI.d(FakeSwitchAccountUI.this);
                    if (FakeSwitchAccountUI.this.count <= 20) {
                        AppMethodBeat.o(73882);
                        return true;
                    }
                    FakeSwitchAccountUI.e(FakeSwitchAccountUI.this);
                    AppMethodBeat.o(73882);
                    return false;
                } else if (FakeSwitchAccountUI.this.count <= 0) {
                    FakeSwitchAccountUI.d(FakeSwitchAccountUI.this);
                    AppMethodBeat.o(73882);
                    return true;
                } else {
                    FakeSwitchAccountUI.e(FakeSwitchAccountUI.this);
                    AppMethodBeat.o(73882);
                    return false;
                }
            }
        }, true);
        if (this.CZb != null) {
            this.CZb.startTimer(1500, 500);
        }
        AppMethodBeat.o(73885);
    }

    private int eSJ() {
        AppMethodBeat.i(73886);
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId())) {
                    Log.i("MicroMsg.FakeSwitchAccountUI", "process %s, %s", runningAppProcessInfo.processName, Integer.valueOf(runningAppProcessInfo.pid));
                    int i2 = runningAppProcessInfo.pid;
                    AppMethodBeat.o(73886);
                    return i2;
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Exception: " + e2.toString());
        } catch (Error e3) {
            Log.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Error: " + e3.toString());
        }
        AppMethodBeat.o(73886);
        return 0;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(73887);
        if (i2 == 4) {
            AppMethodBeat.o(73887);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(73887);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(73888);
        super.onResume();
        Log.i("MicroMsg.FakeSwitchAccountUI", "fake switch account resume");
        Intent intent = new Intent("action_kill_mm_process");
        intent.setPackage(MMApplicationContext.getPackageName());
        sendBroadcast(intent);
        AppMethodBeat.o(73888);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(73889);
        super.onStop();
        Log.i("MicroMsg.FakeSwitchAccountUI", "fake switch account stop");
        AppMethodBeat.o(73889);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(73890);
        super.onDestroy();
        Log.i("MicroMsg.FakeSwitchAccountUI", "fake switch account destroy");
        AppMethodBeat.o(73890);
    }

    static /* synthetic */ void e(FakeSwitchAccountUI fakeSwitchAccountUI) {
        AppMethodBeat.i(73892);
        Log.i("MicroMsg.FakeSwitchAccountUI", "jump to launcher");
        fakeSwitchAccountUI.CZb.stopTimer();
        try {
            Bitmap bitmapFromView = BitmapUtil.getBitmapFromView(fakeSwitchAccountUI.getBodyView());
            s.deleteFile(e.g.Ozb);
            if (bitmapFromView != null) {
                BitmapUtil.saveBitmapToImage(bitmapFromView, 80, Bitmap.CompressFormat.JPEG, e.g.Ozb, true);
            } else {
                Log.e("MicroMsg.FakeSwitchAccountUI", "getBitmap from AccountGrid null!");
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.FakeSwitchAccountUI", "getBitmap from AccountGrid failed! %s", e2.getMessage());
        }
        Intent intent = new Intent();
        intent.setClassName(fakeSwitchAccountUI, "com.tencent.mm.ui.LauncherUI");
        intent.addFlags(268468224);
        intent.putExtra("LauncherUI.jump_switch_account", true);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(fakeSwitchAccountUI, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/FakeSwitchAccountUI", "jumpToLauncher", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        fakeSwitchAccountUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(fakeSwitchAccountUI, "com/tencent/mm/plugin/setting/ui/setting/FakeSwitchAccountUI", "jumpToLauncher", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        fakeSwitchAccountUI.finish();
        b.ke(fakeSwitchAccountUI);
        AppMethodBeat.o(73892);
    }
}
