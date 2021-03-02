package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex;
import com.tencent.mm.plugin.wallet.balance.model.lqt.q;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.tavkit.component.TAVExporter;

public class WalletLqtPlanBeforeHomeUI extends AppCompatActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v7.app.AppCompatActivity
    public Resources getResources() {
        AppMethodBeat.i(213965);
        Resources resources = MMApplicationContext.getResources();
        AppMethodBeat.o(213965);
        return resources;
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68899);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        ao.q(this, getResources().getColor(R.color.ac_));
        fNN();
        AppMethodBeat.o(68899);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        AppMethodBeat.i(68900);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(68900);
    }

    private void fNN() {
        AppMethodBeat.i(68901);
        q qVar = new q();
        qVar.b(new CgiLqtPlanIndex());
        qVar.a(new a.AbstractC2168a<dbs>() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanBeforeHomeUI.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
            @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
            public final /* synthetic */ void d(dbs dbs, int i2, int i3) {
                AppMethodBeat.i(258732);
                dbs dbs2 = dbs;
                Log.i("MicroMsg.WalletLqtPlanBeforeHomeUI", "on index response callback");
                if (dbs2 == null) {
                    m.jU(-1, -1).G(WalletLqtPlanBeforeHomeUI.this, true);
                } else if (dbs2.pTZ != 0) {
                    m.a(true, dbs2.pTZ, 0, dbs2.pUa).G(WalletLqtPlanBeforeHomeUI.this, true);
                } else if (dbs2.MGC == null || dbs2.MGC.isEmpty()) {
                    Log.i("MicroMsg.WalletLqtPlanBeforeHomeUI", "go to WalletLqtPlanAddUI");
                    Intent intent = new Intent(WalletLqtPlanBeforeHomeUI.this, WalletLqtPlanHomeUI.class);
                    if (dbs2.MGE == 1) {
                        intent.putExtra("key_plan_go_scene_ui", 1);
                    } else {
                        intent.putExtra("key_plan_go_scene_ui", 2);
                    }
                    WalletLqtPlanBeforeHomeUI walletLqtPlanBeforeHomeUI = WalletLqtPlanBeforeHomeUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(walletLqtPlanBeforeHomeUI, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanBeforeHomeUI$1", "netCallback", "(Lcom/tencent/mm/protocal/protobuf/PlanIndexResp;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    walletLqtPlanBeforeHomeUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(walletLqtPlanBeforeHomeUI, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanBeforeHomeUI$1", "netCallback", "(Lcom/tencent/mm/protocal/protobuf/PlanIndexResp;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else {
                    Log.i("MicroMsg.WalletLqtPlanBeforeHomeUI", "go to WalletLqtPlanHomeUI");
                    Intent intent2 = new Intent(WalletLqtPlanBeforeHomeUI.this, WalletLqtPlanHomeUI.class);
                    intent2.putExtra("key_plan_go_scene_ui", 3);
                    intent2.putExtra("key_plan_index_resp", CgiLqtPlanIndex.a(dbs2));
                    WalletLqtPlanBeforeHomeUI walletLqtPlanBeforeHomeUI2 = WalletLqtPlanBeforeHomeUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(walletLqtPlanBeforeHomeUI2, bl2.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanBeforeHomeUI$1", "netCallback", "(Lcom/tencent/mm/protocal/protobuf/PlanIndexResp;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    walletLqtPlanBeforeHomeUI2.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(walletLqtPlanBeforeHomeUI2, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtPlanBeforeHomeUI$1", "netCallback", "(Lcom/tencent/mm/protocal/protobuf/PlanIndexResp;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                WalletLqtPlanBeforeHomeUI.this.finish();
                AppMethodBeat.o(258732);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.wallet_core.c.a.AbstractC2168a
            public final /* synthetic */ void dx(dbs dbs) {
                AppMethodBeat.i(68898);
                Log.i("MicroMsg.WalletLqtPlanBeforeHomeUI", "on index cache callback");
                AppMethodBeat.o(68898);
            }
        }, 0);
        AppMethodBeat.o(68901);
    }

    @Override // android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(68902);
        Log.i("MicroMsg.WalletLqtPlanBeforeHomeUI", "activity result: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 65281) {
            if (i3 == -1) {
                fNN();
                AppMethodBeat.o(68902);
                return;
            }
            finish();
        }
        AppMethodBeat.o(68902);
    }
}
