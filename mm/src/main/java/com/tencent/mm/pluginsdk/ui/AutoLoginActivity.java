package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public abstract class AutoLoginActivity extends MMActivity {
    /* access modifiers changed from: protected */
    public abstract void a(a aVar, Intent intent);

    /* access modifiers changed from: protected */
    public abstract boolean ab(Intent intent);

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public enum a {
        LOGIN_OK,
        LOGIN_FAIL,
        LOGIN_CANCEL;

        public static a valueOf(String str) {
            AppMethodBeat.i(155388);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(155388);
            return aVar;
        }

        static {
            AppMethodBeat.i(155389);
            AppMethodBeat.o(155389);
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(8);
        Intent intent = getIntent();
        if (intent == null) {
            Log.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
            finish();
            return;
        }
        c.gsX();
        Log.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + intent.getAction());
        int intExtra = IntentUtil.getIntExtra(intent, "wizard_activity_result_code", -2);
        Log.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = ".concat(String.valueOf(intExtra)));
        if (intExtra != -2) {
            aia(intExtra);
        } else if (!ab(intent)) {
            Log.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
            finish();
        } else if (exA()) {
            finish();
            Log.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
        } else {
            a(a.LOGIN_OK, intent);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        if (intent != null) {
            super.onNewIntent(intent);
            setIntent(intent);
            int intExtra = IntentUtil.getIntExtra(intent, "wizard_activity_result_code", 0);
            Log.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = ".concat(String.valueOf(intExtra)));
            aia(intExtra);
        }
    }

    private void aia(int i2) {
        switch (i2) {
            case -1:
                a(a.LOGIN_OK, getIntent());
                return;
            case 0:
                exA();
                return;
            case 1:
                a(a.LOGIN_CANCEL, getIntent());
                return;
            default:
                Log.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = ".concat(String.valueOf(i2)));
                a(a.LOGIN_FAIL, getIntent());
                return;
        }
    }

    /* access modifiers changed from: protected */
    public boolean exA() {
        g.aAf();
        if (com.tencent.mm.kernel.a.azo() && !com.tencent.mm.kernel.a.azj()) {
            return false;
        }
        Log.w("MicroMsg.AutoLoginActivity", "not login");
        Intent intent = new Intent(this, getClass());
        intent.putExtras(getIntent());
        intent.addFlags(67108864);
        intent.setDataAndType(getIntent().getData(), getIntent().getType());
        intent.setAction(getIntent().getAction());
        Intent intent2 = new Intent();
        intent2.putExtras(getIntent());
        c.a(this, "account", "com.tencent.mm.plugin.account.ui.SimpleLoginUI", intent2, intent);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
