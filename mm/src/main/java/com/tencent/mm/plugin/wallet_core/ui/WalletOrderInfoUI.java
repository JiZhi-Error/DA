package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLEncoder;

@a(3)
public class WalletOrderInfoUI extends WalletBaseUI {
    private String AJn;
    private Orders HFH;
    protected ay.b.a Iip = new ay.b.a() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI.AnonymousClass1 */

        @Override // com.tencent.mm.model.ay.b.a
        public final void p(String str, boolean z) {
            AppMethodBeat.i(71092);
            g.aAi();
            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
            Log.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer " + str + " succ: " + z);
            WalletOrderInfoUI.this.ai(Kn);
            AppMethodBeat.o(71092);
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletOrderInfoUI() {
        AppMethodBeat.i(71094);
        AppMethodBeat.o(71094);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71095);
        super.onCreate(bundle);
        if (eOn()) {
            this.HFH = fSS();
            this.AJn = getInput().getString("key_trans_id");
            int i2 = getInput().getInt("key_pay_type", -1);
            Log.i("MicroMsg.WalletOrderInfoUI", "mTransId %s", this.AJn);
            if (this.AJn != null) {
                if (i2 == -1) {
                    aVQ(this.AJn);
                    AppMethodBeat.o(71095);
                    return;
                }
                ga(this.AJn, i2);
                AppMethodBeat.o(71095);
                return;
            } else if (this.HFH != null) {
                e(this.HFH);
            }
        }
        AppMethodBeat.o(71095);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(71096);
        super.onDestroy();
        if (this.HFH != null && !Util.isNullOrNil(this.HFH.username)) {
            ay.a.iDq.JZ(this.HFH.username);
        }
        AppMethodBeat.o(71096);
    }

    /* access modifiers changed from: protected */
    public boolean eOn() {
        return true;
    }

    /* access modifiers changed from: protected */
    public Orders fSS() {
        AppMethodBeat.i(71097);
        Orders orders = (Orders) getInput().getParcelable("key_orders");
        AppMethodBeat.o(71097);
        return orders;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c4n;
    }

    /* access modifiers changed from: protected */
    public void aVQ(String str) {
        AppMethodBeat.i(71098);
        doSceneProgress(new ae(str));
        AppMethodBeat.o(71098);
    }

    /* access modifiers changed from: protected */
    public void ga(String str, int i2) {
        AppMethodBeat.i(71099);
        doSceneProgress(new ae(str, i2));
        AppMethodBeat.o(71099);
    }

    private void e(Orders orders) {
        AppMethodBeat.i(71100);
        Log.printInfoStack("MicroMsg.WalletOrderInfoUI", "goToOrderInfoUI, is_use_new_paid_succ_page: %d", Integer.valueOf(orders.HZn));
        if (orders.HZn == 1) {
            getProcess().b(this, WalletOrderInfoNewUI.class, getInput());
        } else {
            getProcess().b(this, WalletOrderInfoOldUI.class, getInput());
        }
        finish();
        AppMethodBeat.o(71100);
    }

    /* access modifiers changed from: protected */
    public void ai(as asVar) {
        AppMethodBeat.i(71101);
        if (!(asVar == null || ((int) asVar.gMZ) == 0)) {
            String arI = asVar.arI();
            Log.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer nickName " + arI + " username: " + asVar.field_username);
            if (this.HFH.HZd != null && this.HFH.HZd.size() > 0) {
                for (Orders.Commodity commodity : this.HFH.HZd) {
                    commodity.dCu = arI;
                }
            }
        }
        AppMethodBeat.o(71101);
    }

    protected static String i(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(71102);
        try {
            String encode = URLEncoder.encode(URLEncoder.encode(str5, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.indexOf("%7Breqkey%7D") > 0 || str.indexOf("%7Btransid%7D") > 0 || str.indexOf("%7Bphone%7D") > 0 || str.indexOf("%7Bremark%7D") > 0) {
                Log.i("MicroMsg.WalletOrderInfoUI", "concat url 1: ");
                str = str.replace("%7Breqkey%7D", str2).replace("%7Btransid%7D", str3).replace("%7Bphone%7D", str4).replace("%7Bremark%7D", encode);
                AppMethodBeat.o(71102);
                return str;
            }
            if (str.indexOf("{reqkey}") > 0 || str.indexOf("{transid}") > 0 || str.indexOf("{phone}") > 0 || str.indexOf("{remark}") > 0) {
                Log.i("MicroMsg.WalletOrderInfoUI", "concat url 2: ");
                str = str.replace("{reqkey}", str2).replace("{transid}", str3).replace("{phone}", str4).replace("{remark}", encode);
            } else {
                Log.i("MicroMsg.WalletOrderInfoUI", "concat url 3: ");
                str = str + String.format("?reqkey=%s&transid=%s&phone=%s&remark=%s", str2, str3, str4, encode);
            }
            AppMethodBeat.o(71102);
            return str;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WalletOrderInfoUI", e2, "", new Object[0]);
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71103);
        if ((qVar instanceof ae) && i2 == 0 && i3 == 0) {
            this.HFH = ((ae) qVar).HQs;
            if (this.HFH != null) {
                if (!(this.HFH.HZd == null || this.HFH.HZd.size() == 0)) {
                    Orders.Commodity commodity = this.HFH.HZd.get(0);
                    this.AJn = commodity.dDM;
                    Log.d("MicroMsg.WalletOrderInfoUI", "Coomdity:" + commodity.toString());
                    g.aAi();
                    as Kn = ((l) g.af(l.class)).aSN().Kn(commodity.dCu);
                    if (Kn == null || ((int) Kn.gMZ) == 0) {
                        ay.a.iDq.a(commodity.dCu, "", this.Iip);
                    } else {
                        ai(Kn);
                    }
                }
                e(this.HFH);
            } else {
                Log.e("MicroMsg.WalletOrderInfoUI", "cannot get orders");
                h.a(getContext(), (int) R.string.ijv, 0, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(71093);
                        WalletOrderInfoUI.this.finish();
                        AppMethodBeat.o(71093);
                    }
                });
            }
            AppMethodBeat.o(71103);
            return true;
        }
        AppMethodBeat.o(71103);
        return false;
    }
}
