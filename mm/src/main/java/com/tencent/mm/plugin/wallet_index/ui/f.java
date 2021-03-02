package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.c.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import java.util.ArrayList;

public final class f implements b {
    private final int IrM = (hashCode() & 65535);
    private c Irh;
    private d Isp = null;
    private IListener Isq;

    public f(c cVar, IListener iListener) {
        AppMethodBeat.i(71954);
        Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet create");
        this.Irh = cVar;
        this.Isq = iListener;
        EventCenter.instance.addListener(this.Isq);
        AppMethodBeat.o(71954);
    }

    @Override // com.tencent.mm.plugin.wallet_index.ui.b
    public final int fUr() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.wallet_index.ui.b
    public final int a(MMActivity mMActivity, d dVar) {
        AppMethodBeat.i(71955);
        Log.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay MiniProgram:%b,taskid:%d", Boolean.valueOf(this.Irh.Iru), Integer.valueOf(mMActivity.getTaskId()));
        ab.hht();
        this.Isp = dVar;
        if (!this.Irh.Iru) {
            boolean isSwitch2InWxAppPay = ((a) g.af(a.class)).isSwitch2InWxAppPay(this.Irh.IqQ.MiL);
            Log.i("MicroMsg.WeiXinWallet", "doEmojiReward, isSwitch2InWxAppPay:%b", Boolean.valueOf(isSwitch2InWxAppPay));
            if (isSwitch2InWxAppPay) {
                ((a) g.af(a.class)).startInWxAppPayUseCase(mMActivity, this.Irh.IqQ.MiL, "", "", 5, 0);
            } else {
                PayInfo payInfo = new PayInfo();
                payInfo.dDL = this.Irh.IqQ.MiL;
                payInfo.partnerId = this.Irh.IqQ.MiM;
                payInfo.dQk = this.Irh.IqQ.MiN;
                payInfo.dVv = 5;
                com.tencent.mm.pluginsdk.wallet.f.a(mMActivity, payInfo, this.IrM);
            }
        } else if (this.Irh.IqQ != null) {
            WalletJsapiData walletJsapiData = new WalletJsapiData();
            walletJsapiData.appId = this.Irh.IqQ.MiO.app_id;
            walletJsapiData.timeStamp = this.Irh.IqQ.MiO.HXc;
            walletJsapiData.nonceStr = this.Irh.IqQ.MiO.qcM;
            walletJsapiData.packageExt = this.Irh.IqQ.MiO.MDb;
            walletJsapiData.signType = this.Irh.IqQ.MiO.qcK;
            walletJsapiData.dVt = this.Irh.IqQ.MiN;
            walletJsapiData.dVv = this.Irh.IqQ.dVv;
            walletJsapiData.payChannel = 33;
            walletJsapiData.KxM = "key_from_scene_appbrandgame";
            walletJsapiData.dVw = this.IrM;
            com.tencent.mm.pluginsdk.wallet.f.a(mMActivity, walletJsapiData, this.IrM, (MMActivity.a) null);
        } else {
            Log.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
        }
        Log.e("MicroMsg.WeiXinWallet", "launchPay return SIMPLE_PAY:%d", Integer.valueOf(this.IrM));
        int i2 = this.IrM;
        AppMethodBeat.o(71955);
        return i2;
    }

    @Override // com.tencent.mm.plugin.wallet_index.ui.b
    public final boolean a(MMActivity mMActivity, int i2, int i3, Intent intent) {
        c cJ;
        AppMethodBeat.i(71956);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Integer.valueOf(this.IrM);
        objArr[3] = Boolean.valueOf(intent == null);
        Log.i("MicroMsg.WeiXinWallet", "onPayEnd requestCode : %d,payResult : %d,SIMPLE_PAY : %d, data is null : %b", objArr);
        if (i2 == this.IrM && this.Isp != null) {
            if (i3 == -1) {
                if (intent == null || intent.getIntExtra("key_jsapi_pay_err_code", 0) != 0) {
                    cJ = c.cJ(5, "");
                } else {
                    cJ = c.cJ(0, "");
                }
            } else if (i3 == 0) {
                cJ = c.cJ(1, "");
            } else {
                cJ = c.cJ(6, "");
            }
            Log.i("MicroMsg.WeiXinWallet", "wxpay result : %s", cJ);
            this.Isp.a(cJ, new com.tencent.mm.plugin.wallet_index.b.a.c(this.Irh.rcD, this.Irh.Irm, this.Irh.IqF, this.Irh.IqG));
            this.Isp = null;
        }
        AppMethodBeat.o(71956);
        return true;
    }

    @Override // com.tencent.mm.plugin.wallet_index.ui.b
    public final void p(MMActivity mMActivity) {
        AppMethodBeat.i(71957);
        Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet onDestroy");
        EventCenter.instance.removeListener(this.Isq);
        AppMethodBeat.o(71957);
    }

    @Override // com.tencent.mm.plugin.wallet_index.ui.b
    public final void c(MMActivity mMActivity, boolean z) {
        AppMethodBeat.i(71958);
        Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
        Intent intent = new Intent();
        intent.putExtra("key_err_code", 0);
        intent.putExtra("key_err_msg", "");
        mMActivity.setResult(-1, intent);
        mMActivity.finish();
        AppMethodBeat.o(71958);
    }

    @Override // com.tencent.mm.plugin.wallet_index.ui.b
    public final void a(MMActivity mMActivity, ArrayList<String> arrayList, d dVar, boolean z) {
        AppMethodBeat.i(71959);
        Log.i("MicroMsg.WeiXinWallet", "WeiXinWallet restorePurchase");
        if (dVar != null) {
            dVar.a(c.cJ(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.c(this.Irh.rcD, this.Irh.Irm, this.Irh.IqF, this.Irh.IqG));
        }
        AppMethodBeat.o(71959);
    }
}
