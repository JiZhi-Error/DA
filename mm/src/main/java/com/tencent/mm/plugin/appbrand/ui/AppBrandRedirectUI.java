package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class AppBrandRedirectUI extends MMActivity {
    private int fromScene = -1;
    private boolean nWq = false;
    private int result = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        b.a bs;
        AppMethodBeat.i(48770);
        super.onCreate(bundle);
        y.e(getWindow());
        Log.i("AppBrandRedirectUI", "onCreate");
        setResult(0);
        this.fromScene = getIntent().getIntExtra("key_from_scene", -1);
        if (this.fromScene == 0) {
            Log.i("AppBrandRedirectUI", "start to bind phone number");
            Intent intent = new Intent();
            intent.setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMContactUI");
            intent.putExtra("WizardRootClass", getClass().getName());
            intent.putExtra("bind_scene", 5);
            String simCountryIso = ((TelephonyManager) getContext().getSystemService("phone")).getSimCountryIso();
            if (!Util.isNullOrNil(simCountryIso) && (bs = b.bs(simCountryIso, getContext().getString(R.string.bj8))) != null) {
                intent.putExtra("country_name", bs.jbZ);
                intent.putExtra("couttry_code", bs.jbY);
            }
            MMWizardActivity.ay(this, intent);
            AppMethodBeat.o(48770);
            return;
        }
        Log.e("AppBrandRedirectUI", "from scene is illegal, finish activity");
        finish();
        AppMethodBeat.o(48770);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(48771);
        super.onResume();
        Log.i("AppBrandRedirectUI", "onResume");
        if (!this.nWq) {
            this.nWq = true;
            AppMethodBeat.o(48771);
            return;
        }
        Log.i("AppBrandRedirectUI", "onResume, RESULT_CANCELED  finish activity");
        setResult(0);
        finish();
        AppMethodBeat.o(48771);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(48772);
        if (i2 == 4) {
            Log.e("AppBrandRedirectUI", "onKeyDown KEYCODE_BACK, result cancel, finishUI");
            setResult(0);
            finish();
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(48772);
        return onKeyUp;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(48773);
        Log.i("AppBrandRedirectUI", "onNewIntent");
        super.onNewIntent(intent);
        if (intent != null) {
            this.result = intent.getIntExtra("wizard_activity_result_code", 0);
            setResult(this.result);
            Log.i("AppBrandRedirectUI", "result:%d, finish activity", Integer.valueOf(this.result));
        } else {
            Log.i("AppBrandRedirectUI", "intent is null");
            setResult(0);
        }
        finish();
        AppMethodBeat.o(48773);
    }
}
