package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.d;
import com.facebook.internal.CustomTab;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.a;

public class CustomTabMainActivity extends HellActivity {
    public static final String EXTRA_CHROME_PACKAGE = (CustomTabMainActivity.class.getSimpleName() + ".extra_chromePackage");
    public static final String EXTRA_PARAMS = (CustomTabMainActivity.class.getSimpleName() + ".extra_params");
    public static final String EXTRA_URL = (CustomTabMainActivity.class.getSimpleName() + ".extra_url");
    private static final String OAUTH_DIALOG = "oauth";
    public static final String REFRESH_ACTION = (CustomTabMainActivity.class.getSimpleName() + ".action_refresh");
    private BroadcastReceiver redirectReceiver;
    private boolean shouldCloseCustomTab = true;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(7611);
        AppMethodBeat.o(7611);
    }

    public static final String getRedirectUrl() {
        AppMethodBeat.i(7606);
        String str = "fb" + FacebookSdk.getApplicationId() + "://authorize";
        AppMethodBeat.o(7606);
        return str;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7607);
        super.onCreate(bundle);
        if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(getIntent().getAction())) {
            setResult(0);
            finish();
            AppMethodBeat.o(7607);
            return;
        }
        if (bundle == null) {
            Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
            new CustomTab(OAUTH_DIALOG, bundleExtra).openCustomTab(this, getIntent().getStringExtra(EXTRA_CHROME_PACKAGE));
            this.shouldCloseCustomTab = false;
            this.redirectReceiver = new BroadcastReceiver() {
                /* class com.facebook.CustomTabMainActivity.AnonymousClass1 */
                private byte _hellAccFlag_;

                public void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(7605);
                    Intent intent2 = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
                    intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
                    intent2.putExtra(CustomTabMainActivity.EXTRA_URL, intent.getStringExtra(CustomTabMainActivity.EXTRA_URL));
                    intent2.addFlags(603979776);
                    CustomTabMainActivity customTabMainActivity = CustomTabMainActivity.this;
                    a bl = new a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(customTabMainActivity, bl.axQ(), "com/facebook/CustomTabMainActivity$1", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    customTabMainActivity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(customTabMainActivity, "com/facebook/CustomTabMainActivity$1", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(7605);
                }
            };
            d.W(this).a(this.redirectReceiver, new IntentFilter(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION));
        }
        AppMethodBeat.o(7607);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(7608);
        super.onNewIntent(intent);
        if (REFRESH_ACTION.equals(intent.getAction())) {
            d.W(this).b(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
            AppMethodBeat.o(7608);
            return;
        }
        if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(intent.getAction())) {
            sendResult(-1, intent);
        }
        AppMethodBeat.o(7608);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(7609);
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, null);
        }
        this.shouldCloseCustomTab = true;
        AppMethodBeat.o(7609);
    }

    private void sendResult(int i2, Intent intent) {
        AppMethodBeat.i(7610);
        d.W(this).unregisterReceiver(this.redirectReceiver);
        if (intent != null) {
            setResult(i2, intent);
        } else {
            setResult(i2);
        }
        finish();
        AppMethodBeat.o(7610);
    }
}
