package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.plugin.remittance.model.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceResendMsgUI extends WalletBaseUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68275);
        super.onCreate(bundle);
        getContentView().setVisibility(8);
        setTitleVisibility(8);
        String stringExtra = getIntent().getStringExtra(FirebaseAnalytics.b.TRANSACTION_ID);
        String stringExtra2 = getIntent().getStringExtra("transfer_id");
        String stringExtra3 = getIntent().getStringExtra("receiver_name");
        int intExtra = getIntent().getIntExtra("resend_msg_from_flag", 1);
        int intExtra2 = getIntent().getIntExtra("invalid_time", 0);
        if (!Util.isNullOrNil(stringExtra3)) {
            f(stringExtra, stringExtra2, stringExtra3, intExtra2, intExtra);
            AppMethodBeat.o(68275);
            return;
        }
        Log.i("MicroMsg.RemittanceResendMsgUI", "onCreate() receiverName == null");
        AppMethodBeat.o(68275);
    }

    /* access modifiers changed from: protected */
    public void f(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(68276);
        z zVar = new z(str, str2, str3, i2, i3);
        zVar.setProcessName("RemittanceProcess");
        doSceneProgress(zVar);
        AppMethodBeat.o(68276);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(68277);
        Log.i("MicroMsg.RemittanceResendMsgUI", "onSceneEnd() errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " netsceneType:" + qVar.getType());
        if (!(qVar instanceof z)) {
            AppMethodBeat.o(68277);
            return false;
        } else if (i2 == 0 && i3 == 0) {
            t.a(getContext().getResources().getString(R.string.dzo), getContext(), 0, null);
            finish();
            EventCenter.instance.publish(new ro());
            AppMethodBeat.o(68277);
            return true;
        } else {
            h.a(this, str, "", getContext().getString(R.string.w1), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(213842);
                    Log.i("MicroMsg.RemittanceResendMsgUI", "click AlertDialog");
                    RemittanceResendMsgUI.this.finish();
                    AppMethodBeat.o(213842);
                }
            });
            AppMethodBeat.o(68277);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }
}
