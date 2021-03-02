package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class RealnameDialogActivity extends WalletBaseUI {
    private int type = 1;
    private RealnameGuideHelper zhU;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70017);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("key_realname_guide_helper")) {
            finish();
            AppMethodBeat.o(70017);
            return;
        }
        this.zhU = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
        Bundle bundle2 = new Bundle();
        bundle2.putString("realname_verify_process_jump_plugin", "wallet_core");
        bundle2.putString("realname_verify_process_jump_activity", ".id_verify.RealnameDialogActivity");
        bundle2.putBoolean("process_finish_stay_orgpage", false);
        boolean a2 = this.zhU.a(this, bundle2, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.RealnameDialogActivity.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(70015);
                dialogInterface.dismiss();
                RealnameDialogActivity.this.finish();
                AppMethodBeat.o(70015);
            }
        }, null, true);
        boolean a3 = this.zhU.a(this, bundle2, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.RealnameDialogActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(70016);
                dialogInterface.dismiss();
                RealnameDialogActivity.this.finish();
                AppMethodBeat.o(70016);
            }
        });
        if (!a2 && !a3) {
            finish();
        }
        AppMethodBeat.o(70017);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
