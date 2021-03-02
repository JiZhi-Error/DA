package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class IpcProxyUI extends MMActivity {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(78490);
        super.onCreate(bundle);
        Log.i("MicroMsg.IpcProxyUI", "onCreate");
        if (d.oD(21)) {
            getWindow().setStatusBarColor(0);
        }
        c cVar = (c) o.b(getIntent().getStringExtra("task_class_name"), c.class);
        if (cVar != null) {
            cVar.a(this, getIntent().getBundleExtra("input_data"), new a() {
                /* class com.tencent.mm.plugin.webview.luggage.ipc.IpcProxyUI.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.webview.luggage.ipc.a
                public final void v(Bundle bundle) {
                    AppMethodBeat.i(78489);
                    Intent intent = new Intent();
                    intent.putExtra("input_data", bundle);
                    IpcProxyUI.this.setResult(-1, intent);
                    IpcProxyUI.this.finish();
                    AppMethodBeat.o(78489);
                }
            });
            AppMethodBeat.o(78490);
            return;
        }
        setResult(-1, new Intent());
        finish();
        AppMethodBeat.o(78490);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(78491);
        super.onDestroy();
        Log.i("MicroMsg.IpcProxyUI", "onDestroy");
        AppMethodBeat.o(78491);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void setMMOrientation() {
        AppMethodBeat.i(78492);
        int intExtra = getIntent().getIntExtra("orientation", -1);
        if (intExtra != -1) {
            setRequestedOrientation(intExtra);
        }
        AppMethodBeat.o(78492);
    }
}
