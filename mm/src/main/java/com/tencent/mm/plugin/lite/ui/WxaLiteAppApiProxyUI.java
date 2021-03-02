package com.tencent.mm.plugin.lite.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.d;
import java.util.HashMap;

@a(7)
@d.b
public class WxaLiteAppApiProxyUI extends MMActivity {
    private static String TAG = "MicroMsg.WxaLiteAppApiProxyUI";

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
    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(198906);
        super.onCreate(bundle);
        if (com.tencent.mm.compatible.util.d.oD(21)) {
            getWindow().setStatusBarColor(0);
        }
        Intent intent = getIntent();
        if (intent.getIntExtra("proxyui_action_code_key", 0) == 0) {
            final int intExtra = intent.getIntExtra("callback_id", 0);
            Intent intent2 = new Intent();
            intent2.putExtra("Select_Conv_Type", 3);
            intent2.putExtra("scene_from", 2);
            intent2.putExtra("mutil_select_is_ret", true);
            intent2.putExtra("webview_params", (HashMap) intent.getSerializableExtra("webview_params"));
            intent2.putExtra("Retr_Msg_Type", 2);
            Log.i(TAG, "start SelectConversationUI");
            c.a(this, ".ui.transmit.SelectConversationUI", intent2, 1, new MMFragmentActivity.b() {
                /* class com.tencent.mm.plugin.lite.ui.WxaLiteAppApiProxyUI.AnonymousClass1 */

                @Override // com.tencent.mm.ui.MMFragmentActivity.b
                public final void d(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(198905);
                    Log.i(WxaLiteAppApiProxyUI.TAG, "startAppActivityForResult %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    com.tencent.mm.plugin.lite.c.a(intExtra, i2, i3, intent);
                    WxaLiteAppApiProxyUI.this.finish();
                    AppMethodBeat.o(198905);
                }
            });
        }
        AppMethodBeat.o(198906);
    }
}
