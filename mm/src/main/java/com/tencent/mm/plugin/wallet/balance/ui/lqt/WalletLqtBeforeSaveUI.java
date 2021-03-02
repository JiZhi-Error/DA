package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ag;
import com.tencent.mm.plugin.wallet.balance.model.lqt.o;
import com.tencent.mm.plugin.wallet.balance.model.lqt.w;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.h;
import java.util.ArrayList;
import java.util.Iterator;

@a(7)
public class WalletLqtBeforeSaveUI extends WalletBaseUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68779);
        super.onCreate(bundle);
        final Dialog c2 = h.c(this, false, null);
        new o().aYI().b(new com.tencent.mm.vending.c.a<Void, c.a<dhn>>() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBeforeSaveUI.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(c.a<dhn> aVar) {
                boolean z;
                boolean z2 = true;
                AppMethodBeat.i(68778);
                c.a<dhn> aVar2 = aVar;
                Log.i("MicroMsg.WalletLqtBeforeSaveUI", "on qryusrfunddetail finish, errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                c2.dismiss();
                if (aVar2.errType == 0 && aVar2.errCode == 0) {
                    dhn dhn = (dhn) aVar2.iLC;
                    Log.i("MicroMsg.WalletLqtBeforeSaveUI", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", Integer.valueOf(dhn.pTZ), dhn.pUa);
                    if (dhn.pTZ == 0) {
                        ag.aUH(dhn.HuS);
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (dhn.MLV != null && dhn.MLV.size() > 0) {
                            Iterator<ahq> it = dhn.MLV.iterator();
                            while (it.hasNext()) {
                                ahq next = it.next();
                                if (!Util.isNullOrNil(next.title) && !Util.isNullOrNil(next.yUB)) {
                                    arrayList.add(String.format("%s||%s", next.title, next.yUB));
                                }
                            }
                        }
                        ((w) new com.tencent.mm.vending.app.c().a(WalletLqtBeforeSaveUI.this.getContext(), w.class)).HtX.jP(dhn.yba, 1);
                        Intent intent = new Intent(WalletLqtBeforeSaveUI.this.getContext(), WalletLqtSaveFetchUI.class);
                        intent.putExtra("lqt_save_fund_code", dhn != null ? dhn.Mnl : null);
                        intent.putExtra("lqt_save_fetch_mode", 1);
                        if (dhn.egj == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        intent.putExtra("lqt_is_show_protocol", z);
                        if (dhn.MLU != 1) {
                            z2 = false;
                        }
                        intent.putExtra("lqt_is_agree_protocol", z2);
                        intent.putStringArrayListExtra("lqt_protocol_list", arrayList);
                        intent.putExtra("lqt_profile_wording", dhn.MLJ);
                        intent.putExtra("lqt_account_type", dhn.yba);
                        intent.putExtra("lqt_fund_spid", dhn.Mnk);
                        WalletLqtBeforeSaveUI walletLqtBeforeSaveUI = WalletLqtBeforeSaveUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(walletLqtBeforeSaveUI, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtBeforeSaveUI$1", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        walletLqtBeforeSaveUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(walletLqtBeforeSaveUI, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtBeforeSaveUI$1", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        WalletLqtBeforeSaveUI.this.setResult(-1);
                    }
                }
                WalletLqtBeforeSaveUI.this.finish();
                Void r0 = QZL;
                AppMethodBeat.o(68778);
                return r0;
            }
        });
        AppMethodBeat.o(68779);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(68780);
        super.onDestroy();
        AppMethodBeat.o(68780);
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
