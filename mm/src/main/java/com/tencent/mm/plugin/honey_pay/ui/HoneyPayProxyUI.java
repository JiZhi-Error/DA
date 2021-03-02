package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.plugin.honey_pay.a.m;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.r;
import java.io.IOException;

@a(3)
public class HoneyPayProxyUI extends HoneyPayBaseUI {
    private String yjY;
    private boolean ylG;

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64818);
        super.onCreate(bundle);
        addSceneEndListener(2876);
        addSceneEndListener(2613);
        this.ylG = getIntent().getBooleanExtra("key_is_payer", false);
        this.yjY = getIntent().getStringExtra("key_card_no");
        Log.i(this.TAG, "is payer: %s", Boolean.valueOf(this.ylG));
        if (this.ylG) {
            Log.i(this.TAG, "do qry payer detail");
            l lVar = new l(this.yjY);
            lVar.t(this);
            doSceneProgress(lVar, true);
            AppMethodBeat.o(64818);
            return;
        }
        m mVar = new m(this.yjY);
        mVar.t(this);
        doSceneProgress(mVar, true);
        AppMethodBeat.o(64818);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI
    public final void dYP() {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64819);
        super.onDestroy();
        removeSceneEndListener(2876);
        removeSceneEndListener(2613);
        AppMethodBeat.o(64819);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64820);
        if (qVar instanceof l) {
            final l lVar = (l) qVar;
            lVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64815);
                    if (lVar.yjJ.LpE != null) {
                        Log.i(HoneyPayProxyUI.this.TAG, "state: %s", Integer.valueOf(lVar.yjJ.LpE.state));
                    }
                    HoneyPayProxyUI.a(HoneyPayProxyUI.this, lVar.yjJ);
                    HoneyPayProxyUI.this.finish();
                    AppMethodBeat.o(64815);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64814);
                    HoneyPayProxyUI.this.finish();
                    AppMethodBeat.o(64814);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI.AnonymousClass1 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            });
        } else if (qVar instanceof m) {
            final m mVar = (m) qVar;
            mVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI.AnonymousClass6 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64817);
                    Log.i(HoneyPayProxyUI.this.TAG, "state: %s", Integer.valueOf(mVar.yjK.LWG.state));
                    if (mVar.yjK.LWG.state == 1) {
                        HoneyPayProxyUI.a(HoneyPayProxyUI.this, mVar.yjK);
                    } else {
                        HoneyPayProxyUI.b(HoneyPayProxyUI.this, mVar.yjK);
                    }
                    HoneyPayProxyUI.this.finish();
                    AppMethodBeat.o(64817);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64816);
                    HoneyPayProxyUI.this.finish();
                    AppMethodBeat.o(64816);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                }
            });
        }
        AppMethodBeat.o(64820);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onProgressFinish() {
        return true;
    }

    static /* synthetic */ void a(HoneyPayProxyUI honeyPayProxyUI, dhf dhf) {
        AppMethodBeat.i(64821);
        Log.i(honeyPayProxyUI.TAG, "go to manager ui");
        Intent intent = new Intent(honeyPayProxyUI, HoneyPayCardManagerUI.class);
        intent.putExtra("key_card_no", honeyPayProxyUI.yjY);
        try {
            byte[] byteArray = dhf.toByteArray();
            intent.putExtra("key_scene", 1);
            intent.putExtra("key_qry_response", byteArray);
        } catch (IOException e2) {
            Log.printErrStackTrace(honeyPayProxyUI.TAG, e2, "", new Object[0]);
            intent.putExtra("key_scene", 0);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(honeyPayProxyUI, bl.axQ(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayProxyUI", "gotoManagerUI", "(Lcom/tencent/mm/protocal/protobuf/QryHoneyPayerDetailResp;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        honeyPayProxyUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(honeyPayProxyUI, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayProxyUI", "gotoManagerUI", "(Lcom/tencent/mm/protocal/protobuf/QryHoneyPayerDetailResp;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(64821);
    }

    static /* synthetic */ void a(HoneyPayProxyUI honeyPayProxyUI, dhh dhh) {
        AppMethodBeat.i(64822);
        Log.i(honeyPayProxyUI.TAG, "go to receive card ui");
        Intent intent = new Intent(honeyPayProxyUI, HoneyPayReceiveCardUI.class);
        intent.putExtra("key_card_no", honeyPayProxyUI.yjY);
        try {
            byte[] byteArray = dhh.toByteArray();
            intent.putExtra("key_scene", 1);
            intent.putExtra("key_qry_response", byteArray);
        } catch (IOException e2) {
            Log.printErrStackTrace(honeyPayProxyUI.TAG, e2, "", new Object[0]);
            intent.putExtra("key_scene", 0);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(honeyPayProxyUI, bl.axQ(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayProxyUI", "gotoReceiveCardUI", "(Lcom/tencent/mm/protocal/protobuf/QryHoneyUserDetailResp;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        honeyPayProxyUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(honeyPayProxyUI, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayProxyUI", "gotoReceiveCardUI", "(Lcom/tencent/mm/protocal/protobuf/QryHoneyUserDetailResp;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(64822);
    }

    static /* synthetic */ void b(HoneyPayProxyUI honeyPayProxyUI, dhh dhh) {
        AppMethodBeat.i(64823);
        Log.i(honeyPayProxyUI.TAG, "go to card detail");
        Intent intent = new Intent(honeyPayProxyUI, HoneyPayCardDetailUI.class);
        intent.putExtra("key_card_no", honeyPayProxyUI.yjY);
        intent.putExtra("key_scene", 1);
        try {
            intent.putExtra("key_qry_response", dhh.toByteArray());
        } catch (IOException e2) {
            Log.printErrStackTrace(honeyPayProxyUI.TAG, e2, "", new Object[0]);
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(honeyPayProxyUI, bl.axQ(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayProxyUI", "gotoCardDetailUI", "(Lcom/tencent/mm/protocal/protobuf/QryHoneyUserDetailResp;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        honeyPayProxyUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(honeyPayProxyUI, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayProxyUI", "gotoCardDetailUI", "(Lcom/tencent/mm/protocal/protobuf/QryHoneyUserDetailResp;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(64823);
    }
}
