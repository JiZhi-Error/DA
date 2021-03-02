package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.d;

@a(19)
public class WalletECardFinishUI extends WalletECardBaseUI {
    private TextView jVn;
    private Button nAa;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBaseUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71780);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        setMMTitle("");
        enableBackMenu(false);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(71778);
                Log.i("MicroMsg.WalletECardFinishUI", "press back btn");
                WalletECardFinishUI.this.nAa.performClick();
                AppMethodBeat.o(71778);
                return false;
            }
        });
        showHomeBtn(false);
        initView();
        AppMethodBeat.o(71780);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        cxc cxc;
        AppMethodBeat.i(71781);
        this.jVn = (TextView) findViewById(R.id.bn6);
        byte[] byteArray = getInput().getByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.IpJ);
        if (byteArray != null) {
            try {
                if (!(byteArray.length == 0 || (cxc = (cxc) new cxc().parseFrom(byteArray)) == null || Util.isNullOrNil(cxc.desc))) {
                    this.jVn.setText(cxc.desc);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WalletECardFinishUI", e2, "", new Object[0]);
            }
        }
        this.nAa = (Button) findViewById(R.id.d4y);
        this.nAa.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(71779);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardFinishUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.WalletECardFinishUI", "click finish");
                EventCenter.instance.publish(new ov());
                d process = WalletECardFinishUI.this.getProcess();
                if (process != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_process_result_code", -1);
                    process.b(WalletECardFinishUI.this.getContext(), bundle);
                } else {
                    Log.w("MicroMsg.WalletECardFinishUI", "process is null");
                    WalletECardFinishUI.this.finish();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardFinishUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71779);
            }
        });
        AppMethodBeat.o(71781);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a0f;
    }
}
