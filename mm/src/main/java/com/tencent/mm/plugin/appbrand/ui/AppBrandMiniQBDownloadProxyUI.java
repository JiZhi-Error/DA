package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.impl.common.ConfigurationKeys;
import java.io.File;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandMiniQBDownloadProxyUI extends MMActivity {
    private static boolean nUg = false;
    private Handler mHandler;
    private a nUh = null;
    private q nUi;
    private volatile boolean nUj;
    private Runnable nUk;

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
        AppMethodBeat.i(227617);
        super.onCreate(bundle);
        Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onCreate");
        y.e(getWindow());
        Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "is foreground download");
        AppCompatActivity context = getContext();
        getContext().getString(R.string.zb);
        this.nUi = h.a((Context) context, getContext().getString(R.string.nm), true, (DialogInterface.OnCancelListener) null);
        if (this.nUi.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.nUi.getWindow().getAttributes();
            attributes.dimAmount = 0.0f;
            this.nUi.getWindow().setAttributes(attributes);
        }
        this.nUi.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandMiniQBDownloadProxyUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(227612);
                Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "user cancel download");
                AppBrandMiniQBDownloadProxyUI.this.setResult(2, new Intent());
                AppBrandMiniQBDownloadProxyUI.this.finish();
                AppMethodBeat.o(227612);
            }
        });
        TBSOneManager defaultInstance = TBSOneManager.getDefaultInstance(getContext());
        if (!(!defaultInstance.isComponentInstalled("file"))) {
            Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "file component has already installed");
            setResult(0, new Intent());
            finish();
        }
        if (this.nUh == null) {
            this.nUh = new a(this, (byte) 0);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(ConfigurationKeys.IS_IGNORE_WIFI_STATE, true);
        bundle2.putBoolean(ConfigurationKeys.IS_IGNORE_FREQUENCY_LIMITATION, true);
        bundle2.putBoolean(ConfigurationKeys.IS_IGNORE_FLOW_CONTROL, true);
        defaultInstance.installComponent("file", bundle2, this.nUh);
        this.nUj = true;
        this.mHandler = new Handler();
        this.nUk = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandMiniQBDownloadProxyUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(227611);
                boolean unused = AppBrandMiniQBDownloadProxyUI.nUg = true;
                AppBrandMiniQBDownloadProxyUI.this.setResult(0, new Intent());
                AppBrandMiniQBDownloadProxyUI.this.finish();
                AppMethodBeat.o(227611);
            }
        };
        this.mHandler.postDelayed(this.nUk, 20000);
        AppMethodBeat.o(227617);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(227618);
        super.onNewIntent(intent);
        if (nUg || this.nUj) {
            setResult(0, intent);
            finish();
        }
        AppMethodBeat.o(227618);
    }

    final class a extends TBSOneCallback<File> {
        private a() {
        }

        /* synthetic */ a(AppBrandMiniQBDownloadProxyUI appBrandMiniQBDownloadProxyUI, byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.tbs.one.TBSOneCallback
        public final /* synthetic */ void onCompleted(File file) {
            AppMethodBeat.i(227616);
            super.onCompleted(file);
            AppBrandMiniQBDownloadProxyUI.this.nUj = false;
            AppBrandMiniQBDownloadProxyUI.this.setResult(-1, new Intent());
            AppBrandMiniQBDownloadProxyUI.this.finish();
            AppMethodBeat.o(227616);
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        public final void onProgressChanged(int i2, final int i3) {
            AppMethodBeat.i(227614);
            super.onProgressChanged(i2, i3);
            Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDownloadProgress, percent = %d", Integer.valueOf(i3));
            if (AppBrandMiniQBDownloadProxyUI.this.nUi != null) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandMiniQBDownloadProxyUI.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(227613);
                        AppBrandMiniQBDownloadProxyUI.this.nUj = true;
                        AppBrandMiniQBDownloadProxyUI.this.nUi.setMessage(AppBrandMiniQBDownloadProxyUI.this.getContext().getString(R.string.nn, new Object[]{String.valueOf(i3)}));
                        AppMethodBeat.o(227613);
                    }
                });
            }
            AppMethodBeat.o(227614);
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        public final void onError(int i2, String str) {
            AppMethodBeat.i(227615);
            super.onError(i2, str);
            Log.e("MicroMsg.AppBrandMiniQBDownloadProxyUI", "download miniqb fail, reason: %s", str);
            AppBrandMiniQBDownloadProxyUI.this.nUj = false;
            AppBrandMiniQBDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandMiniQBDownloadProxyUI.this.finish();
            AppMethodBeat.o(227615);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(227619);
        Log.i("MicroMsg.AppBrandMiniQBDownloadProxyUI", "onDestroy");
        this.nUh = null;
        if (!(this.mHandler == null || this.nUk == null)) {
            this.mHandler.removeCallbacks(this.nUk);
        }
        if (this.nUi != null) {
            this.nUi.dismiss();
            this.nUi = null;
        }
        super.onDestroy();
        AppMethodBeat.o(227619);
    }
}
