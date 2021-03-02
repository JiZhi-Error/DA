package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.x.b;
import com.tencent.mm.plugin.x.c;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;

public class WXShortcutEntryActivity extends AutoLoginActivity {
    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22326);
        super.onCreate(bundle);
        AppMethodBeat.o(22326);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final boolean ab(Intent intent) {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final void a(AutoLoginActivity.a aVar, Intent intent) {
        b bVar;
        AppMethodBeat.i(22327);
        if (intent == null) {
            Log.e("MicroMsg.WXShortcutEntryActivity", "intent is null");
            finish();
            AppMethodBeat.o(22327);
            return;
        }
        c cVar = c.INSTANCE;
        int intExtra = IntentUtil.getIntExtra(intent, "type", 0);
        if (!c.XE(intExtra) || WeChatBrands.Business.Entries.GlobalAppbrand.checkAvailable(this, new android.support.v4.e.c<Integer>() {
            /* class com.tencent.mm.plugin.base.stub.WXShortcutEntryActivity.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.support.v4.e.c
            public final /* synthetic */ void accept(Integer num) {
                AppMethodBeat.i(231629);
                WXShortcutEntryActivity.this.finish();
                AppMethodBeat.o(231629);
            }
        })) {
            AppCompatActivity context = getContext();
            if (!(intent == null || (bVar = cVar.DlT.get(intExtra)) == null)) {
                bVar.k(context, intent);
            }
            finish();
            AppMethodBeat.o(22327);
            return;
        }
        AppMethodBeat.o(22327);
    }
}
