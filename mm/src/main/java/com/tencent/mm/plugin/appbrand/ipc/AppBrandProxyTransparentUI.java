package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.a;

@a(7)
public class AppBrandProxyTransparentUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45408);
        super.onCreate(bundle);
        Log.i("MicroMsg.AppBrandProxyTransparentUI", "onCreate");
        ao.e(getWindow());
        try {
            getIntent().getExtras().setClassLoader(Class.forName(getIntent().getStringExtra("task_class_name")).getClassLoader());
        } catch (ClassNotFoundException e2) {
            Log.e("MicroMsg.AppBrandProxyTransparentUI", "ClassNotFoundException");
            setResult(1);
            finish();
        }
        final AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask) getIntent().getParcelableExtra("task_object");
        final String stringExtra = getIntent().getStringExtra("task_id");
        if (appBrandProxyTransparentUIProcessTask != null) {
            appBrandProxyTransparentUIProcessTask.a(this, new AppBrandProxyTransparentUIProcessTask.a() {
                /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUI.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a
                public final void bDH() {
                    AppMethodBeat.i(45407);
                    Log.i("MicroMsg.AppBrandProxyTransparentUI", "onResult");
                    Intent intent = new Intent();
                    intent.putExtra("task_object", appBrandProxyTransparentUIProcessTask);
                    intent.putExtra("task_id", stringExtra);
                    AppBrandProxyTransparentUI.this.setResult(-1, intent);
                    AppBrandProxyTransparentUI.this.finish();
                    AppMethodBeat.o(45407);
                }
            });
            AppMethodBeat.o(45408);
            return;
        }
        setResult(1);
        finish();
        AppMethodBeat.o(45408);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(45409);
        super.onDestroy();
        Log.i("MicroMsg.AppBrandProxyTransparentUI", "onDestroy");
        AppMethodBeat.o(45409);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void setMMOrientation() {
        AppMethodBeat.i(45410);
        int intExtra = getIntent().getIntExtra("orientation", -1);
        if (intExtra != -1) {
            setRequestedOrientation(intExtra);
        }
        AppMethodBeat.o(45410);
    }
}
