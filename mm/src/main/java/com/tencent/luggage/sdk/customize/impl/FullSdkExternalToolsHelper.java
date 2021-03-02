package com.tencent.luggage.sdk.customize.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.BaseActivity;

public final class FullSdkExternalToolsHelper implements ag {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag
    public final void a(Context context, String str, dyq dyq) {
        AppMethodBeat.i(146713);
        Log.d("Luggage.FullSdkExternalToolsHelper", "open webview activity url: %s", str);
        Intent intent = new Intent(context, SimpleWebViewActivity.class);
        intent.putExtra("_url_", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/luggage/sdk/customize/impl/FullSdkExternalToolsHelper", "openWebViewActivity", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/SimpleWebViewLaunchParams;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/luggage/sdk/customize/impl/FullSdkExternalToolsHelper", "openWebViewActivity", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/SimpleWebViewLaunchParams;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(146713);
    }

    public static class SimpleWebViewActivity extends BaseActivity {
        private WebView webView;

        @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.BaseActivity
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            AppMethodBeat.at(this, z);
        }

        @Override // android.support.v7.app.AppCompatActivity
        public Resources getResources() {
            AppMethodBeat.i(229830);
            Resources resources = MMApplicationContext.getResources();
            AppMethodBeat.o(229830);
            return resources;
        }

        @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.BaseActivity
        public void onCreate(Bundle bundle) {
            AppMethodBeat.i(146710);
            super.onCreate(bundle);
            this.webView = (WebView) findViewById(R.id.jkk);
            i(getIntent());
            AppMethodBeat.o(146710);
        }

        @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
        public void onNewIntent(Intent intent) {
            AppMethodBeat.i(146711);
            super.onNewIntent(intent);
            i(intent);
            AppMethodBeat.o(146711);
        }

        private void i(Intent intent) {
            AppMethodBeat.i(146712);
            String stringExtra = intent.getStringExtra("_url_");
            this.webView.stopLoading();
            this.webView.loadUrl(stringExtra);
            AppMethodBeat.o(146712);
        }

        @Override // com.tencent.mm.ui.BaseActivity
        public final int getLayoutId() {
            return R.layout.b4q;
        }
    }
}
