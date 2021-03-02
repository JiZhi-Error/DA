package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.se;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WcPayRealnameVerifyBindcardEntranceUI extends WalletBaseUI {
    private Button HRS;
    private Button HRT;
    private TextView jVn;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70071);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.f3048f));
        hideActionbarLine();
        setMMTitle("");
        initView();
        AppMethodBeat.o(70071);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70072);
        this.HRS = (Button) findViewById(R.id.jq5);
        this.HRT = (Button) findViewById(R.id.jq6);
        this.jVn = (TextView) findViewById(R.id.jqx);
        String string = getInput().getString("realname_verify_process_add_bank_word");
        if (!Util.isNullOrNil(string)) {
            this.jVn.setText(string);
        }
        this.HRS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyBindcardEntranceUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(70069);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyBindcardEntranceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WcPayRealnameVerifyBindcardEntranceUI.this.getInput().putBoolean("realname_verify_process_do_bind", true);
                com.tencent.mm.wallet_core.a.l(WcPayRealnameVerifyBindcardEntranceUI.this.getContext(), WcPayRealnameVerifyBindcardEntranceUI.this.getInput());
                a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyBindcardEntranceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70069);
            }
        });
        this.HRT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyBindcardEntranceUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(70070);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyBindcardEntranceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                boolean z = WcPayRealnameVerifyBindcardEntranceUI.this.getInput().getBoolean("realname_verify_process_need_face", false);
                Log.i("MicroMsg.WcPayRealnameVerifyBindcardEntranceUI", "need face : %s", Boolean.valueOf(z));
                if (z) {
                    WcPayRealnameVerifyBindcardEntranceUI.a(WcPayRealnameVerifyBindcardEntranceUI.this);
                } else {
                    WcPayRealnameVerifyBindcardEntranceUI.this.getInput().putBoolean("realname_verify_process_do_bind", false);
                    com.tencent.mm.wallet_core.a.l(WcPayRealnameVerifyBindcardEntranceUI.this.getContext(), WcPayRealnameVerifyBindcardEntranceUI.this.getInput());
                }
                a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyBindcardEntranceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(70070);
            }
        });
        AppMethodBeat.o(70072);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cb0;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(70073);
        Log.i("MicroMsg.WcPayRealnameVerifyBindcardEntranceUI", "onActivityResult: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 != 1) {
            super.onActivityResult(i2, i3, intent);
        } else if (!(i3 != -1 || intent == null || intent.getExtras() == null)) {
            getInput().putString("realname_verify_process_face_token", intent.getExtras().getString("token"));
            getProcess().a(this, 0, getInput());
            AppMethodBeat.o(70073);
            return;
        }
        AppMethodBeat.o(70073);
    }

    static /* synthetic */ void a(WcPayRealnameVerifyBindcardEntranceUI wcPayRealnameVerifyBindcardEntranceUI) {
        AppMethodBeat.i(70074);
        Log.i("MicroMsg.WcPayRealnameVerifyBindcardEntranceUI", "gotToFaceCheck");
        se seVar = new se();
        seVar.dYI.dKq = wcPayRealnameVerifyBindcardEntranceUI;
        seVar.dYI.scene = (int) wcPayRealnameVerifyBindcardEntranceUI.getInput().getLong("realname_verify_process_face_scene");
        seVar.dYI.packageName = wcPayRealnameVerifyBindcardEntranceUI.getInput().getString("realname_verify_process_face_package");
        seVar.dYI.dYK = wcPayRealnameVerifyBindcardEntranceUI.getInput().getString("realname_verify_process_face_package_sign");
        seVar.dYI.requestCode = 1;
        EventCenter.instance.publish(seVar);
        AppMethodBeat.o(70074);
    }
}
