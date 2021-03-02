package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.aaw;
import com.tencent.mm.g.a.zu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@a(3)
public class WalletMixOrderInfoUI extends WalletBaseUI {
    private boolean Ihf;
    public boolean Ihg;
    private th Ihh;
    private int Ihi;
    private IListener Ihj = new IListener<zu>() {
        /* class com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI.AnonymousClass3 */

        {
            AppMethodBeat.i(160884);
            this.__eventId = zu.class.getName().hashCode();
            AppMethodBeat.o(160884);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zu zuVar) {
            boolean z = false;
            AppMethodBeat.i(70977);
            zu zuVar2 = zuVar;
            if (zuVar2 instanceof zu) {
                EventCenter.instance.removeListener(this);
                WalletMixOrderInfoUI.this.appId = zuVar2.efP.appId;
                WalletMixOrderInfoUI.this.timeStamp = zuVar2.efP.timeStamp;
                WalletMixOrderInfoUI.this.nonceStr = zuVar2.efP.nonceStr;
                WalletMixOrderInfoUI.this.packageExt = zuVar2.efP.packageExt;
                WalletMixOrderInfoUI.this.dDL = zuVar2.efP.dDL;
                WalletMixOrderInfoUI.this.efQ = zuVar2.efP.efQ;
                WalletMixOrderInfoUI.this.signType = zuVar2.efP.signType;
                WalletMixOrderInfoUI.this.dQk = zuVar2.efP.dQk;
                Log.i("MicroMsg.WalletMixOrderInfoUI", "WalletGetPaidOrderDetailEvent callback：prepayId:%s, payScene：%s, reqKey:%s", WalletMixOrderInfoUI.this.prepayId, Integer.valueOf(WalletMixOrderInfoUI.this.efQ), WalletMixOrderInfoUI.this.dDL);
                if (WalletMixOrderInfoUI.d(WalletMixOrderInfoUI.this)) {
                    Log.i("MicroMsg.WalletMixOrderInfoUI", "startOverseaWalletSuccPageUseCase is true, go kinda");
                    AppMethodBeat.o(70977);
                    return true;
                }
                if (WalletMixOrderInfoUI.this.efQ != 1 || Util.isNullOrNil(WalletMixOrderInfoUI.this.prepayId) || (!Util.isNullOrNil(WalletMixOrderInfoUI.this.dDL) && !WalletMixOrderInfoUI.this.dDL.equals(WalletMixOrderInfoUI.this.prepayId))) {
                    z = true;
                } else {
                    WalletMixOrderInfoUI.this.doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(WalletMixOrderInfoUI.this.appId, WalletMixOrderInfoUI.this.timeStamp, WalletMixOrderInfoUI.this.nonceStr, WalletMixOrderInfoUI.this.packageExt, WalletMixOrderInfoUI.this.dDL, WalletMixOrderInfoUI.this.efQ, WalletMixOrderInfoUI.this.signType, WalletMixOrderInfoUI.this.dQk));
                }
                if (z) {
                    WalletMixOrderInfoUI.this.Ihg = false;
                    WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this, WalletMixOrderInfoUI.this, WalletMixOrderInfoUI.this.getString(R.string.ikx));
                }
                AppMethodBeat.o(70977);
                return true;
            }
            AppMethodBeat.o(70977);
            return false;
        }
    };
    private String appId = null;
    private String dDL = null;
    private String dQk = null;
    public int efQ;
    private String nonceStr = null;
    private String packageExt = null;
    public String prepayId = null;
    private String signType = null;
    private String timeStamp = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletMixOrderInfoUI() {
        AppMethodBeat.i(70979);
        AppMethodBeat.o(70979);
    }

    static /* synthetic */ void a(WalletMixOrderInfoUI walletMixOrderInfoUI, Context context, String str) {
        AppMethodBeat.i(214244);
        walletMixOrderInfoUI.bQ(context, str);
        AppMethodBeat.o(214244);
    }

    static /* synthetic */ void a(WalletMixOrderInfoUI walletMixOrderInfoUI, String str) {
        AppMethodBeat.i(70986);
        walletMixOrderInfoUI.aVP(str);
        AppMethodBeat.o(70986);
    }

    static /* synthetic */ boolean d(WalletMixOrderInfoUI walletMixOrderInfoUI) {
        AppMethodBeat.i(214243);
        boolean aeR = walletMixOrderInfoUI.aeR(1);
        AppMethodBeat.o(214243);
        return aeR;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70980);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.Ihh = new th();
        this.Ihh.LbT = intent.getIntExtra("max_count", 3);
        this.Ihh.LbS = intent.getIntExtra("inteval_time", 4);
        this.Ihh.LbU = intent.getStringExtra("default_wording");
        if (Util.isNullOrNil(this.Ihh.LbU)) {
            this.Ihh.LbU = getString(R.string.ibn);
        }
        this.Ihi = this.Ihh.LbT;
        this.Ihf = intent.getBooleanExtra("is_jsapi_offline_pay", false);
        this.Ihg = true;
        if (!this.Ihf) {
            final String stringExtra = intent.getStringExtra("pay_gate_url");
            boolean booleanExtra = intent.getBooleanExtra("need_dialog", false);
            String stringExtra2 = intent.getStringExtra("dialog_text");
            this.prepayId = intent.getStringExtra("prepayId");
            Log.i("MicroMsg.WalletMixOrderInfoUI", " prepayId:%s ，need_dialog:%s", this.prepayId, Boolean.valueOf(booleanExtra));
            if (booleanExtra) {
                h.a(this, stringExtra2, "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(70975);
                        dialogInterface.dismiss();
                        WalletMixOrderInfoUI.a(WalletMixOrderInfoUI.this, stringExtra);
                        AppMethodBeat.o(70975);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(70976);
                        dialogInterface.dismiss();
                        aaa aaa = new aaa();
                        aaa.egJ.dDL = WalletMixOrderInfoUI.this.prepayId;
                        aaa.egJ.result = 0;
                        EventCenter.instance.publish(aaa);
                        WalletMixOrderInfoUI.this.finish();
                        AppMethodBeat.o(70976);
                    }
                }).setCancelable(false);
            } else {
                aVP(stringExtra);
            }
            EventCenter.instance.addListener(this.Ihj);
            AppMethodBeat.o(70980);
            return;
        }
        this.appId = getIntent().getStringExtra("appId");
        this.timeStamp = getIntent().getStringExtra("timeStamp");
        this.nonceStr = getIntent().getStringExtra("nonceStr");
        this.packageExt = getIntent().getStringExtra("packageExt");
        this.dDL = getIntent().getStringExtra("reqKey");
        this.efQ = getIntent().getIntExtra("payScene", -1);
        this.signType = getIntent().getStringExtra("signtype");
        this.dQk = getIntent().getStringExtra("paySignature");
        Log.i("MicroMsg.WalletMixOrderInfoUI", "start query offline walletmix succ page, prepayId:%s, payScene：%s, reqKey:%s", this.prepayId, Integer.valueOf(this.efQ), this.dDL);
        if (aeR(2)) {
            Log.i("MicroMsg.WalletMixOrderInfoUI", "startOverseaWalletSuccPageUseCase is true, go kinda");
            AppMethodBeat.o(70980);
        } else if (this.efQ != 2 || !Util.isNullOrNil(this.prepayId)) {
            bQ(this, getString(R.string.ikx));
            AppMethodBeat.o(70980);
        } else {
            doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.dDL, this.efQ, this.signType, this.dQk));
            AppMethodBeat.o(70980);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(70981);
        super.onResume();
        AppMethodBeat.o(70981);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c4n;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(70982);
        if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.c.a) {
            if (i2 == 0 && i3 == 0) {
                this.Ihg = false;
                aaw aaw = new aaw();
                aaw.ehM.result = -1;
                EventCenter.instance.publish(aaw);
                Orders orders = ((com.tencent.mm.plugin.wallet_core.c.c.a) qVar).HQL;
                Log.i("MicroMsg.WalletMixOrderInfoUI", " go to WalletMixOrderInfoProxyUI");
                Intent intent = new Intent(this, WalletMixOrderInfoProxyUI.class);
                intent.putExtra("key_orders", orders);
                intent.putExtra("prepayId", this.prepayId);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletMixOrderInfoUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                setResult(-1);
                finish();
            } else {
                if (this.Ihi == 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    Log.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain again");
                    Log.d("MicroMsg.WalletMixOrderInfoUI", "retryGetPaidOrderDetailAgain：m_currentRetryCount: %d", Integer.valueOf(this.Ihi));
                    this.Ihi--;
                    doSceneForceProgress(new com.tencent.mm.plugin.wallet_core.c.c.a(this.appId, this.timeStamp, this.nonceStr, this.packageExt, this.prepayId, this.efQ, this.signType, this.dQk), this.Ihh.LbS);
                } else {
                    this.Ihg = false;
                    if (str.isEmpty()) {
                        str = this.Ihh.LbU;
                    }
                    bQ(this, str);
                }
            }
            AppMethodBeat.o(70982);
            return true;
        }
        AppMethodBeat.o(70982);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(70983);
        if (i2 == 1 && i3 == 0) {
            Log.d("MicroMsg.WalletMixOrderInfoUI", "requestCode: %d, resultCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (this.Ihg) {
                EventCenter.instance.removeListener(this.Ihj);
                aaa aaa = new aaa();
                aaa.egJ.dDL = this.prepayId;
                aaa.egJ.result = 0;
                EventCenter.instance.publish(aaa);
                finish();
            }
        }
        AppMethodBeat.o(70983);
    }

    private void aVP(String str) {
        AppMethodBeat.i(70984);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(70984);
            return;
        }
        Log.d("MicroMsg.WalletMixOrderInfoUI", "H5 wallet url: %s", str);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        f.b(getContext(), intent, 1);
        AppMethodBeat.o(70984);
    }

    private boolean aeR(int i2) {
        AppMethodBeat.i(214241);
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.appId);
        bundle.putString(AppMeasurement.Param.TIMESTAMP, this.timeStamp);
        bundle.putString("nonce_str", this.nonceStr);
        bundle.putString("package", this.packageExt);
        bundle.putInt("input_pay_scene", this.efQ);
        bundle.putString("sign_type", this.signType);
        bundle.putString("pay_sign", this.dQk);
        bundle.putString("req_key", this.dDL);
        bundle.putInt("origin_pay_scene", i2);
        bundle.putString("order_id", this.prepayId);
        bundle.putInt("retry_max_count", this.Ihh.LbT);
        bundle.putInt("retry_interval_seconds", this.Ihh.LbS);
        bundle.putString("retry_default_wording", this.Ihh.LbU);
        if (((com.tencent.mm.pluginsdk.wallet.a) g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startOverseaWalletSuccPageUseCase(this, bundle)) {
            AppMethodBeat.o(214241);
            return true;
        }
        AppMethodBeat.o(214241);
        return false;
    }

    public static void aeS(int i2) {
        AppMethodBeat.i(214242);
        aaw aaw = new aaw();
        aaw.ehM.result = i2;
        EventCenter.instance.publish(aaw);
        AppMethodBeat.o(214242);
    }

    private void bQ(Context context, String str) {
        AppMethodBeat.i(70985);
        Log.i("MicroMsg.WalletMixOrderInfoUI", "showErrorAlert");
        if (!this.Ihf) {
            aaw aaw = new aaw();
            aaw.ehM.result = 0;
            EventCenter.instance.publish(aaw);
        }
        d a2 = h.a(context, str, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(0) {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI.AnonymousClass4 */
            final /* synthetic */ int Ihm = 0;

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(70978);
                dialogInterface.dismiss();
                if (WalletMixOrderInfoUI.this.Ihf) {
                    aaw aaw = new aaw();
                    aaw.ehM.result = this.Ihm;
                    EventCenter.instance.publish(aaw);
                }
                aaa aaa = new aaa();
                aaa.egJ.dDL = WalletMixOrderInfoUI.this.prepayId;
                aaa.egJ.result = this.Ihm;
                EventCenter.instance.publish(aaa);
                WalletMixOrderInfoUI.this.setResult(this.Ihm);
                WalletMixOrderInfoUI.this.finish();
                AppMethodBeat.o(70978);
            }
        });
        if (a2 != null) {
            a2.setCancelable(false);
        }
        AppMethodBeat.o(70985);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void finish() {
        AppMethodBeat.i(182529);
        super.finish();
        Log.i("MicroMsg.WalletMixOrderInfoUI", "finish");
        AppMethodBeat.o(182529);
    }
}
