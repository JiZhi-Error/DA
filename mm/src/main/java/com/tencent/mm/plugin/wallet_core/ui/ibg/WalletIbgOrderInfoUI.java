package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.le;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.c;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class WalletIbgOrderInfoUI extends WalletBaseUI {
    public static Orders HFH;
    private String HDU = null;
    private String Ims = null;
    private String Imt = null;
    private String Imu = null;
    private String Imv = null;
    private final int Imw = 1;
    private final int Imx = 2;
    private String mAppId = null;
    private String mTimeStamp = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71448);
        super.onCreate(bundle);
        addSceneEndListener(1565);
        this.mAppId = getIntent().getStringExtra("appId");
        this.Ims = getIntent().getStringExtra("nonceStr");
        this.mTimeStamp = getIntent().getStringExtra("timeStamp");
        this.HDU = getIntent().getStringExtra("packageExt");
        this.Imt = getIntent().getStringExtra("paySignature");
        this.Imu = getIntent().getStringExtra("signtype");
        this.Imv = getIntent().getStringExtra("url");
        Bundle bundle2 = new Bundle();
        bundle2.putString("appid", this.mAppId);
        bundle2.putString(AppMeasurement.Param.TIMESTAMP, this.mTimeStamp);
        bundle2.putString("nonce_str", this.Ims);
        bundle2.putString("package", this.HDU);
        bundle2.putString("sign_type", this.Imu);
        bundle2.putString("pay_sign", this.Imt);
        bundle2.putString("webview_url", this.Imv);
        if (((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startPayIBGJsGetSuccPageUseCase(this, bundle2)) {
            AppMethodBeat.o(71448);
            return;
        }
        doSceneForceProgress(new c(this.mAppId, this.Ims, this.mTimeStamp, this.HDU, this.Imt, this.Imu, this.Imv));
        AppMethodBeat.o(71448);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c4n;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(71449);
        if (i3 == -1) {
            if (i2 == 1) {
                le leVar = new le();
                leVar.dQr.requestCode = 25;
                leVar.dQr.resultCode = -1;
                leVar.dQr.dQs = new Intent();
                EventCenter.instance.publish(leVar);
            }
            setResult(-1);
            finish();
        }
        AppMethodBeat.o(71449);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71450);
        Log.i("MicroMsg.WalletIbgOrderInfoUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
        if (qVar instanceof c) {
            removeSceneEndListener(1565);
            if (i2 == 0 && i3 == 0) {
                c cVar = (c) qVar;
                HFH = cVar.HQs;
                Orders orders = HFH;
                int i4 = cVar.HQI;
                Log.i("MicroMsg.WalletIbgOrderInfoUI", "gotoIbgOrderInfoUI, useNewPage: %s, orders: %s", Integer.valueOf(i4), orders);
                if (i4 == 1) {
                    Intent intent = new Intent(this, WalletIbgOrderInfoNewUI.class);
                    intent.putExtra("key_orders", orders);
                    startActivityForResult(intent, 1);
                } else {
                    Intent intent2 = new Intent(this, WalletIbgOrderInfoOldUI.class);
                    intent2.putExtra("key_orders", orders);
                    startActivityForResult(intent2, 2);
                }
                AppMethodBeat.o(71450);
                return true;
            }
            setResult(0);
            finish();
        }
        setResult(0);
        finish();
        AppMethodBeat.o(71450);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(71451);
        super.onDestroy();
        removeSceneEndListener(1565);
        AppMethodBeat.o(71451);
    }
}
