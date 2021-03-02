package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.aab;
import com.tencent.mm.g.a.zp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet_index.c.k;
import com.tencent.mm.plugin.wallet_index.c.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.ui.h;

@com.tencent.mm.ui.base.a(7)
public class WalletBrandUI extends MMActivity implements i {
    private boolean IrJ = false;
    private b IrK;
    private WalletJsapiData IrL;
    private final int IrM = (hashCode() & 65535);
    public String IrN = "";
    private int IrO;
    public boolean IrP = false;
    private IListener IrQ = new IListener<aaa>() {
        /* class com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.AnonymousClass2 */

        {
            AppMethodBeat.i(160899);
            this.__eventId = aaa.class.getName().hashCode();
            AppMethodBeat.o(160899);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aaa aaa) {
            AppMethodBeat.i(71883);
            aaa aaa2 = aaa;
            if (aaa2.egJ.egL) {
                Log.f("MicroMsg.WalletBrandUI", "WalletPayResultEvent is from kinda, ScanQRCodePay");
                AppMethodBeat.o(71883);
                return false;
            }
            Log.i("MicroMsg.WalletBrandUI", "onPayEnd payResult:%s, reqKey:%s,  comeFrom:%s", Integer.valueOf(aaa2.egJ.result), aaa2.egJ.dDL, Integer.valueOf(aaa2.egJ.egM));
            if (WalletBrandUI.this.IrK != null) {
                Log.i("MicroMsg.WalletBrandUI", "onPayEnd getGenPrepayFuncId:%d, getGenPrepayReqKey:%s,appbrandScene:%s", Integer.valueOf(WalletBrandUI.this.IrK.fUv()), WalletBrandUI.this.IrK.fUx(), WalletBrandUI.this.IrN);
            }
            if (WalletBrandUI.this.IrK.fUv() != 398) {
                WalletBrandUI.this.setResult(aaa2.egJ.result, aaa2.egJ.intent);
                WalletBrandUI.this.o(aaa2.egJ.result, aaa2.egJ.intent);
                WalletBrandUI.this.finish();
                AppMethodBeat.o(71883);
                return true;
            } else if (aaa2.egJ == null || Util.isNullOrNil(aaa2.egJ.dDL) || !aaa2.egJ.dDL.equalsIgnoreCase(WalletBrandUI.this.IrK.fUx()) || aaa2.egJ.egM != 1) {
                Log.i("MicroMsg.WalletBrandUI", "FuncId %d,is not current request key || comeFrom:%s is not FINISH", Integer.valueOf(WalletBrandUI.this.IrK.fUv()), Integer.valueOf(aaa2.egJ.egM));
                if (aaa2.egJ != null && !Util.isNullOrNil(aaa2.egJ.dDL) && aaa2.egJ.dDL.equalsIgnoreCase(WalletBrandUI.this.IrK.fUx()) && aaa2.egJ.result == 0) {
                    WalletBrandUI.this.finish();
                }
                AppMethodBeat.o(71883);
                return true;
            } else {
                if (Util.isNullOrNil(WalletBrandUI.this.IrN) || !WalletBrandUI.this.IrN.equalsIgnoreCase("key_from_scene_appbrandgame")) {
                    WalletBrandUI.this.setResult(aaa2.egJ.result, aaa2.egJ.intent);
                    WalletBrandUI.this.o(aaa2.egJ.result, aaa2.egJ.intent);
                    WalletBrandUI.this.finish();
                } else {
                    WalletBrandUI.a(WalletBrandUI.this, aaa2.egJ.result, aaa2.egJ.intent);
                }
                AppMethodBeat.o(71883);
                return true;
            }
        }
    };
    private IListener IrR = new IListener<zp>() {
        /* class com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.AnonymousClass3 */

        {
            AppMethodBeat.i(160900);
            this.__eventId = zp.class.getName().hashCode();
            AppMethodBeat.o(160900);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zp zpVar) {
            AppMethodBeat.i(71884);
            if (WalletBrandUI.this.tipDialog != null) {
                WalletBrandUI.this.tipDialog.dismiss();
                WalletBrandUI.this.tipDialog = null;
            }
            AppMethodBeat.o(71884);
            return true;
        }
    };
    private int efQ;
    private q gNg = null;
    public VoidBoolStringI32StringCallback hgw = null;
    public VoidCallback hgx = null;
    private Dialog tipDialog = null;

    /* access modifiers changed from: package-private */
    public interface b {
        int fUv();

        q fUw();

        String fUx();

        void onSceneEnd(int i2, int i3, String str, q qVar);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBrandUI() {
        AppMethodBeat.i(71901);
        AppMethodBeat.o(71901);
    }

    static /* synthetic */ void a(WalletBrandUI walletBrandUI, int i2, Intent intent) {
        AppMethodBeat.i(214278);
        walletBrandUI.n(i2, intent);
        AppMethodBeat.o(214278);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71902);
        super.onCreate(bundle);
        this.IrL = (WalletJsapiData) getIntent().getParcelableExtra("WalletJsapiData");
        if (Build.VERSION.SDK_INT >= 21 && getWindow() != null) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        if (this.IrL == null) {
            Log.w("MicroMsg.WalletBrandUI", "no jsapi data");
            finish();
            AppMethodBeat.o(71902);
            return;
        }
        ((com.tencent.mm.plugin.wxpay.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
        com.tencent.soter.a.a.hlD();
        if (this.IrL.KxM != null) {
            this.IrN = this.IrL.KxM;
        }
        this.efQ = this.IrL.dVv;
        if (this.IrN.equalsIgnoreCase("key_from_scene_appbrandgame")) {
            this.IrO = this.IrL.dVw;
            this.IrL.dVw = 0;
        }
        ab.hht();
        int i2 = this.IrL.KxH;
        Log.i("MicroMsg.WalletBrandUI", "onCreate appbrandScene:%s,payScene:%d,requestCode:%d", this.IrN, Integer.valueOf(this.efQ), Integer.valueOf(this.IrO));
        if (z.aUo()) {
            Log.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
            this.IrK = new e();
        } else if (i2 == 2) {
            Log.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
            this.IrK = new a();
        } else if (i2 == 3) {
            Log.i("MicroMsg.WalletBrandUI", "do pay with mall");
            this.IrK = new g();
        } else if (i2 == 4) {
            Log.i("MicroMsg.WalletBrandUI", "do pay with component");
            this.IrK = new d();
        } else if (fUu()) {
            Log.i("MicroMsg.WalletBrandUI", "do pay with kinda");
            this.IrK = new c();
        } else {
            Log.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
            this.IrK = new f();
        }
        EventCenter.instance.addListener(this.IrQ);
        EventCenter.instance.addListener(this.IrR);
        if (this.IrK instanceof c) {
            Log.i("MicroMsg.WalletBrandUI", "onCreate: do pay with kinda");
            AppMethodBeat.o(71902);
            return;
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(this.IrK.fUv(), this);
        AppMethodBeat.o(71902);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(71903);
        Log.i("MicroMsg.WalletBrandUI", "onDestroy");
        super.onDestroy();
        if (this.IrK instanceof c) {
            Log.i("MicroMsg.WalletBrandUI", "onDestroy: do pay with kinda");
        } else {
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.b(this.IrK.fUv(), this);
        }
        EventCenter.instance.removeListener(this.IrQ);
        EventCenter.instance.removeListener(this.IrR);
        AppMethodBeat.o(71903);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(71904);
        Log.i("MicroMsg.WalletBrandUI", "onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.o(71904);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(71905);
        Log.i("MicroMsg.WalletBrandUI", "onResume");
        super.onResume();
        Log.i("MicroMsg.WalletBrandUI", "Handler jump intercept = %b,taskid = %d,parentName = %s", Boolean.valueOf(this.IrJ), Integer.valueOf(getTaskId()), getCallingActivity());
        if (!this.IrJ) {
            this.IrJ = true;
            this.gNg = this.IrK.fUw();
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (!fUu() && this.IrL.KxH != 4) {
                this.tipDialog = h.b(this, true, new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(71882);
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.kernel.g.aAg().hqi.a(WalletBrandUI.this.gNg);
                        WalletBrandUI.this.finish();
                        AppMethodBeat.o(71882);
                    }
                });
            }
        }
        AppMethodBeat.o(71905);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(71906);
        if (i2 == 4) {
            finish();
            AppMethodBeat.o(71906);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(71906);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(71907);
        super.onStop();
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        AppMethodBeat.o(71907);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71908);
        Log.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s scene %s _scene %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar, this.gNg);
        if (qVar.getType() == this.IrK.fUv() && qVar == this.gNg) {
            this.IrK.onSceneEnd(i2, i3, str, qVar);
            AppMethodBeat.o(71908);
            return;
        }
        AppMethodBeat.o(71908);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(71909);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.WalletBrandUI", "onActivityResultresultCode : " + i3 + " requestCode: " + i2);
        if (i3 == -1) {
            switch (i2) {
                case 1:
                    Log.i("MicroMsg.WalletBrandUI", "get result to callback? " + intent.getStringExtra(APMidasPayAPI.ENV_TEST));
                    break;
            }
        }
        if (!this.IrP || i2 != 4 || intent == null) {
            finish();
            AppMethodBeat.o(71909);
            return;
        }
        Log.i("MicroMsg.WalletBrandUI", "onActivityResult For Face Action,resultCode : ".concat(String.valueOf(i3)));
        int intExtra = intent.getIntExtra("err_code", 0);
        int intExtra2 = intent.getIntExtra("scene", 0);
        int intExtra3 = intent.getIntExtra("countFace", 0);
        long longExtra = intent.getLongExtra("totalTime", 0);
        int intExtra4 = intent.getIntExtra("err_type", 6);
        Log.i("MicroMsg.WalletBrandUI", "errCode： ".concat(String.valueOf(intExtra)));
        Log.i("MicroMsg.WalletBrandUI", "scene： ".concat(String.valueOf(intExtra2)));
        Log.i("MicroMsg.WalletBrandUI", "countFace： ".concat(String.valueOf(intExtra3)));
        Log.i("MicroMsg.WalletBrandUI", "totalTime： ".concat(String.valueOf(longExtra)));
        Log.i("MicroMsg.WalletBrandUI", "errorType： ".concat(String.valueOf(intExtra4)));
        if (i3 != -1) {
            if (!(this.hgw == null || intent.getExtras() == null)) {
                String string = intent.getExtras().getString("click_other_verify_btn");
                boolean z = !Util.isNullOrNil(string) && string.equalsIgnoreCase("yes");
                Log.i("MicroMsg.WalletBrandUI", "isClickOtherVerify: %s", string);
                if (z) {
                    Log.i("MicroMsg.WalletBrandUI", "check face failed, click other verify");
                    this.hgw.call(true, "", intExtra, "");
                    this.hgw = null;
                }
            }
            if (i3 == 0) {
                Log.i("MicroMsg.WalletBrandUI", "resultCode：RESULT_CANCELED");
                if (this.hgx != null) {
                    this.hgx.call();
                    this.hgx = null;
                }
                finish();
            }
        } else if (!(this.hgw == null || intent.getExtras() == null)) {
            this.hgw.call(false, intent.getExtras().getString("token"), intExtra, "");
            this.hgw = null;
            AppMethodBeat.o(71909);
            return;
        }
        AppMethodBeat.o(71909);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    public final void n(int i2, Intent intent) {
        AppMethodBeat.i(174530);
        Log.i("MicroMsg.WalletBrandUI", "sendMiniAppPayResult result:%d", Integer.valueOf(i2));
        aab aab = new aab();
        aab.egN.intent = intent;
        aab.egN.egM = 1;
        aab.egN.dDL = "key_from_scene_appbrandgame";
        aab.egN.result = i2;
        aab.egN.requestCode = this.IrO;
        EventCenter.instance.publish(aab);
        AppMethodBeat.o(174530);
    }

    public final void o(int i2, Intent intent) {
        AppMethodBeat.i(182530);
        Log.i("MicroMsg.WalletBrandUI", "sendPaySuccessAheadCallbackResult result:%d", Integer.valueOf(i2));
        if (!(this.IrL == null || this.IrL.KxQ == null)) {
            if (intent == null) {
                intent = new Intent();
            }
            if (intent.getExtras() == null) {
                intent.putExtras(new Bundle());
            }
            this.IrL.KxQ.send(i2, intent.getExtras());
        }
        AppMethodBeat.o(182530);
    }

    class f implements b {
        private String mReqKey = "";

        f() {
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final q fUw() {
            com.tencent.mm.plugin.wallet_index.c.f fVar;
            AppMethodBeat.i(71896);
            String str = WalletBrandUI.this.IrL.appId;
            String str2 = WalletBrandUI.this.IrL.signType;
            String str3 = WalletBrandUI.this.IrL.nonceStr;
            String str4 = WalletBrandUI.this.IrL.packageExt;
            String str5 = WalletBrandUI.this.IrL.dVt;
            String str6 = WalletBrandUI.this.IrL.timeStamp;
            String str7 = WalletBrandUI.this.IrL.url;
            String str8 = WalletBrandUI.this.IrL.dVu;
            int i2 = WalletBrandUI.this.IrL.payChannel;
            int i3 = WalletBrandUI.this.IrL.dVv;
            int i4 = WalletBrandUI.this.IrL.KxG;
            String str9 = WalletBrandUI.this.IrL.iDk;
            if (com.tencent.mm.plugin.wallet_index.c.a.lw(str4, "up_")) {
                fVar = new l(str, str2, str3, str4, str5, str6, str7, str8, i2, i3, i4, str9);
            } else if (com.tencent.mm.plugin.wallet_index.c.a.lw(str4, "tax_")) {
                fVar = new k(str, str2, str3, str4, str5, str6, str7, str8, i2, i3, i4, str9);
            } else if (com.tencent.mm.plugin.wallet_index.c.a.lw(str4, "dc_")) {
                fVar = new com.tencent.mm.plugin.wallet_index.c.d(str, str2, str3, str4, str5, str6, str7, str8, i2, i3, i4, str9);
            } else {
                fVar = new com.tencent.mm.plugin.wallet_index.c.f(str, str2, str3, str4, str5, str6, str7, str8, i2, i3, i4, str9);
            }
            fVar.setProcessSessionId(System.currentTimeMillis());
            fVar.setProcessName("PayProcess");
            fVar.setScene(WalletBrandUI.this.IrL.dVv);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(fVar, 0);
            AppMethodBeat.o(71896);
            return fVar;
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(71897);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.wallet_index.c.f fVar = (com.tencent.mm.plugin.wallet_index.c.f) qVar;
                String str2 = fVar.IqL;
                Log.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str2)));
                this.mReqKey = str2;
                EventCenter.instance.publish(new zp());
                exi exi = ((com.tencent.mm.plugin.wallet_index.c.f) qVar).IqN;
                if (exi == null || Util.isNullOrNil(exi.NuI)) {
                    Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand startPay");
                    PayInfo payInfo = new PayInfo();
                    payInfo.dDL = str2;
                    payInfo.appId = WalletBrandUI.this.IrL.appId;
                    payInfo.IqM = fVar.IqM;
                    payInfo.dVv = WalletBrandUI.this.IrL.dVv;
                    payInfo.errMsg = str;
                    payInfo.channel = WalletBrandUI.this.IrL.payChannel;
                    payInfo.Kxv = fVar.sessionId;
                    if (payInfo.iqp == null) {
                        payInfo.iqp = new Bundle();
                    }
                    payInfo.iqp.putString("extinfo_key_20", ((com.tencent.mm.plugin.wallet_index.c.f) qVar).IqO);
                    payInfo.iqp.putString("extinfo_key_21", WalletBrandUI.this.IrL.KxK);
                    payInfo.iqp.putString("extinfo_key_22", WalletBrandUI.this.IrL.KxL);
                    af.z(payInfo.dVv, str2, i3);
                    com.tencent.mm.pluginsdk.wallet.f.a(WalletBrandUI.this, payInfo, 1);
                    AppMethodBeat.o(71897);
                    return;
                }
                Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand start WalletMixOrderInfoUI");
                Intent intent = new Intent();
                intent.putExtra("prepayId", str2);
                intent.putExtra("is_jsapi_offline_pay", false);
                intent.putExtra("pay_gate_url", exi.NuI);
                intent.putExtra("need_dialog", exi.NuK);
                intent.putExtra("dialog_text", exi.NuL);
                intent.putExtra("max_count", exi.NuJ.LbT);
                intent.putExtra("inteval_time", exi.NuJ.LbS);
                intent.putExtra("default_wording", exi.NuJ.LbU);
                com.tencent.mm.br.c.c(WalletBrandUI.this, "wallet_core", ".ui.WalletMixOrderInfoUI", intent);
                AppMethodBeat.o(71897);
                return;
            }
            Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand dialog");
            af.z(WalletBrandUI.this.IrL.dVv, "", i3);
            if (WalletBrandUI.this.IrL.dVv == 3) {
                com.tencent.mm.ui.widget.a.d a2 = com.tencent.mm.ui.base.h.a((Context) WalletBrandUI.this, Util.isNullOrNil(str) ? WalletBrandUI.this.getString(R.string.ij2) : str, "", WalletBrandUI.this.getString(R.string.ic6), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.f.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(71895);
                        WalletBrandUI.this.finish();
                        AppMethodBeat.o(71895);
                    }
                });
                if (a2 != null) {
                    a2.setCancelable(false);
                }
                if (WalletBrandUI.this.tipDialog != null) {
                    WalletBrandUI.this.tipDialog.dismiss();
                    WalletBrandUI.this.tipDialog = null;
                }
                AppMethodBeat.o(71897);
                return;
            }
            Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand setResult ResultPayFailed");
            Intent intent2 = new Intent();
            if (i2 != 0) {
                i3 = -1;
            }
            intent2.putExtra("key_jsapi_pay_onActivityResult", "jsapi_pay_onActivityResult");
            intent2.putExtra("key_jsapi_pay_err_code", i3);
            if (Util.isNullOrNil(str)) {
                str = WalletBrandUI.this.getString(R.string.ij2);
            }
            intent2.putExtra("key_jsapi_pay_err_msg", str);
            intent2.putExtra("key_jsapi_pay_err_dialog_confirm", WalletBrandUI.this.getString(R.string.ic6));
            WalletBrandUI.this.setResult(5, intent2);
            WalletBrandUI.this.finish();
            AppMethodBeat.o(71897);
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final int fUv() {
            AppMethodBeat.i(71898);
            Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand getGenPrepayFuncId packageExt:%s", WalletBrandUI.this.IrL.packageExt);
            if (com.tencent.mm.plugin.wallet_index.c.a.lw(WalletBrandUI.this.IrL.packageExt, "up_")) {
                AppMethodBeat.o(71898);
                return 2519;
            } else if (com.tencent.mm.plugin.wallet_index.c.a.lw(WalletBrandUI.this.IrL.packageExt, "tax_")) {
                AppMethodBeat.o(71898);
                return 2923;
            } else if (com.tencent.mm.plugin.wallet_index.c.a.lw(WalletBrandUI.this.IrL.packageExt, "dc_")) {
                AppMethodBeat.o(71898);
                return 2798;
            } else {
                AppMethodBeat.o(71898);
                return 398;
            }
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final String fUx() {
            return this.mReqKey;
        }
    }

    class e implements b {
        private String mReqKey = "";

        e() {
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final q fUw() {
            AppMethodBeat.i(71893);
            com.tencent.mm.plugin.wallet_index.c.b.a aVar = new com.tencent.mm.plugin.wallet_index.c.b.a(WalletBrandUI.this.IrL.appId, WalletBrandUI.this.IrL.signType, WalletBrandUI.this.IrL.nonceStr, WalletBrandUI.this.IrL.packageExt, WalletBrandUI.this.IrL.dVt, WalletBrandUI.this.IrL.timeStamp, WalletBrandUI.this.IrL.url, WalletBrandUI.this.IrL.dVu, WalletBrandUI.this.IrL.payChannel);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(aVar, 0);
            AppMethodBeat.o(71893);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(71894);
            com.tencent.mm.plugin.wallet_index.c.b.a aVar = (com.tencent.mm.plugin.wallet_index.c.b.a) qVar;
            String str2 = aVar.IqL;
            Log.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str2)));
            this.mReqKey = str2;
            PayInfo payInfo = new PayInfo();
            payInfo.dDL = str2;
            payInfo.appId = WalletBrandUI.this.IrL.appId;
            payInfo.IqM = aVar.IqM;
            payInfo.dVv = WalletBrandUI.this.IrL.dVv;
            payInfo.errMsg = str;
            payInfo.channel = WalletBrandUI.this.IrL.payChannel;
            com.tencent.mm.pluginsdk.wallet.f.a(WalletBrandUI.this, payInfo, 1);
            AppMethodBeat.o(71894);
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final int fUv() {
            return 1521;
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final String fUx() {
            return this.mReqKey;
        }
    }

    public class a implements b {
        private int IrT = 0;
        private String mReqKey = "";

        public a() {
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final int fUv() {
            return 1563;
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final q fUw() {
            AppMethodBeat.i(71887);
            this.IrT = WalletBrandUI.this.IrL.KxJ;
            com.tencent.mm.plugin.wallet_index.c.a.a aVar = new com.tencent.mm.plugin.wallet_index.c.a.a(WalletBrandUI.this.IrL.appId, WalletBrandUI.this.IrL.nonceStr, WalletBrandUI.this.IrL.timeStamp, WalletBrandUI.this.IrL.packageExt, WalletBrandUI.this.IrL.dVt, WalletBrandUI.this.IrL.signType, WalletBrandUI.this.IrL.url, WalletBrandUI.this.IrL.dVu, WalletBrandUI.this.IrL.payChannel);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(aVar, 0);
            AppMethodBeat.o(71887);
            return aVar;
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(71888);
            if (i2 == 0 && i3 == 0 && (qVar instanceof com.tencent.mm.plugin.wallet_index.c.a.a)) {
                String str2 = ((com.tencent.mm.plugin.wallet_index.c.a.a) qVar).jumpUrl;
                Log.i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", str2);
                this.mReqKey = str2;
                String str3 = ((com.tencent.mm.plugin.wallet_index.c.a.a) qVar).Irb;
                if (this.IrT == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("url", str2);
                    intent.putExtra("jsInjectCode", str3);
                    WalletBrandUI.this.setResult(-1, intent);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", str2);
                    intent2.putExtra("showShare", true);
                    if (!Util.isNullOrNil(str3)) {
                        intent2.putExtra("shouldForceViewPort", true);
                        intent2.putExtra("view_port_code", str3);
                    }
                    com.tencent.mm.wallet_core.ui.f.aA(WalletBrandUI.this.getContext(), intent2);
                    WalletBrandUI.this.setResult(-1);
                }
                WalletBrandUI.this.finish();
                AppMethodBeat.o(71888);
                return;
            }
            Log.i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            com.tencent.mm.ui.base.h.a(WalletBrandUI.this, str, "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.a.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(71885);
                    WalletBrandUI.this.setResult(0);
                    WalletBrandUI.this.finish();
                    AppMethodBeat.o(71885);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.a.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(71886);
                    WalletBrandUI.this.setResult(0);
                    WalletBrandUI.this.finish();
                    AppMethodBeat.o(71886);
                }
            });
            AppMethodBeat.o(71888);
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final String fUx() {
            return this.mReqKey;
        }
    }

    class g implements b {
        private String mReqKey = "";

        g() {
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final int fUv() {
            return 2755;
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final q fUw() {
            AppMethodBeat.i(71899);
            com.tencent.mm.plugin.wallet_index.c.e eVar = new com.tencent.mm.plugin.wallet_index.c.e(WalletBrandUI.this.IrL.appId, WalletBrandUI.this.IrL.signType, WalletBrandUI.this.IrL.nonceStr, WalletBrandUI.this.IrL.packageExt, WalletBrandUI.this.IrL.dVt, WalletBrandUI.this.IrL.timeStamp, WalletBrandUI.this.IrL.url, WalletBrandUI.this.IrL.dVu, WalletBrandUI.this.IrL.payChannel, WalletBrandUI.this.IrL.dVv, WalletBrandUI.this.IrL.extInfo);
            eVar.setProcessSessionId(System.currentTimeMillis());
            eVar.setProcessName("PayProcess");
            eVar.setScene(WalletBrandUI.this.IrL.dVv);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(eVar, 0);
            AppMethodBeat.o(71899);
            return eVar;
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(71900);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.wallet_index.c.e eVar = (com.tencent.mm.plugin.wallet_index.c.e) qVar;
                String str2 = eVar.IqL;
                this.mReqKey = str2;
                Log.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str2)));
                PayInfo payInfo = new PayInfo();
                payInfo.dDL = str2;
                payInfo.appId = WalletBrandUI.this.IrL.appId;
                payInfo.IqM = eVar.IqM;
                payInfo.dVv = WalletBrandUI.this.IrL.dVv;
                payInfo.errMsg = str;
                payInfo.channel = WalletBrandUI.this.IrL.payChannel;
                payInfo.Kxv = eVar.sessionId;
                af.z(payInfo.dVv, str2, i3);
                com.tencent.mm.pluginsdk.wallet.f.a(WalletBrandUI.this, payInfo, 1);
                AppMethodBeat.o(71900);
                return;
            }
            WalletBrandUI.this.finish();
            AppMethodBeat.o(71900);
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final String fUx() {
            return this.mReqKey;
        }
    }

    private boolean fUu() {
        AppMethodBeat.i(71910);
        com.tencent.mm.wallet_core.b.hgC();
        if (!com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_open, true) || this.IrL.packageExt == null) {
            AppMethodBeat.o(71910);
            return false;
        }
        String aVZ = aVZ(this.IrL.packageExt);
        if (aVZ == null) {
            AppMethodBeat.o(71910);
            return true;
        }
        boolean aWa = aWa(aVZ);
        Log.i("MicroMsg.WalletBrandUI", "isPrefixDisableKinda :%s", Boolean.valueOf(aWa));
        if (aWa) {
            AppMethodBeat.o(71910);
            return false;
        } else if (this.IrL.dVv == 3 || this.IrL.dVv == 46) {
            AppMethodBeat.o(71910);
            return true;
        } else {
            AppMethodBeat.o(71910);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public class c implements b {
        c() {
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final int fUv() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public q fUw() {
            AppMethodBeat.i(71890);
            ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayJsApiPay(WalletBrandUI.this.getContext(), WalletBrandUI.this.IrL, new MMActivity.a() {
                /* class com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.c.AnonymousClass1 */
                private Intent IrV = new Intent();

                {
                    AppMethodBeat.i(174528);
                    AppMethodBeat.o(174528);
                }

                @Override // com.tencent.mm.ui.MMActivity.a
                public final void d(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(71889);
                    if (i2 != WalletBrandUI.this.IrM) {
                        AppMethodBeat.o(71889);
                    } else if (intent == null) {
                        Log.e("MicroMsg.WalletBrandUI", Util.stackTraceToString(new Throwable("KindaBrand Intent data null!")));
                        AppMethodBeat.o(71889);
                    } else if (i3 != -1) {
                        p(i3, intent);
                        AppMethodBeat.o(71889);
                    } else if (intent.hasExtra("key_jsapi_close_page_after_pay")) {
                        Log.i("MicroMsg.WalletBrandUI", "KindaBrand.mmOnActivityResult ClosePage data: %s", Integer.valueOf(i3), intent.toString());
                        this.IrV.putExtra("key_jsapi_close_page_after_pay", intent.getIntExtra("key_jsapi_close_page_after_pay", 0));
                        WalletBrandUI.this.setResult(i3, this.IrV);
                        AppMethodBeat.o(71889);
                    } else {
                        this.IrV.putExtras(intent);
                        p(i3, this.IrV);
                        AppMethodBeat.o(71889);
                    }
                }

                private void p(int i2, Intent intent) {
                    AppMethodBeat.i(174529);
                    Log.i("MicroMsg.WalletBrandUI", "KindaBrand.kindaEndWithResult resultCode: %d, data: %s", Integer.valueOf(i2), intent.toString());
                    WalletBrandUI.this.setResult(i2, intent);
                    AppMethodBeat.o(174529);
                }
            }, WalletBrandUI.this.IrM);
            AppMethodBeat.o(71890);
            return null;
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final String fUx() {
            return "";
        }
    }

    class d extends c {
        d() {
            super();
        }

        @Override // com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.c, com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.b
        public final q fUw() {
            AppMethodBeat.i(71892);
            ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startJsApiComponentUseCase(WalletBrandUI.this.getContext(), WalletBrandUI.this.IrL, new MMActivity.a() {
                /* class com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.d.AnonymousClass1 */

                @Override // com.tencent.mm.ui.MMActivity.a
                public final void d(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(71891);
                    if (i2 == WalletBrandUI.this.IrM) {
                        WalletBrandUI.this.setResult(i3, intent);
                        WalletBrandUI.this.finish();
                    }
                    AppMethodBeat.o(71891);
                }
            }, WalletBrandUI.this.IrM);
            AppMethodBeat.o(71892);
            return null;
        }
    }

    private static String aVZ(String str) {
        AppMethodBeat.i(71911);
        int indexOf = str.indexOf("prepay_id=");
        if (indexOf == -1) {
            AppMethodBeat.o(71911);
            return null;
        }
        String substring = str.substring(indexOf + 10);
        if (substring == null) {
            AppMethodBeat.o(71911);
            return null;
        }
        int indexOf2 = substring.indexOf("&");
        if (indexOf2 == -1) {
            AppMethodBeat.o(71911);
            return substring;
        }
        String substring2 = substring.substring(0, indexOf2);
        AppMethodBeat.o(71911);
        return substring2;
    }

    private static boolean aWa(String str) {
        AppMethodBeat.i(182531);
        Log.i("MicroMsg.WalletBrandUI", "isPrefixDisableKinda: %s", str);
        if (str.startsWith("tax_")) {
            Log.i("MicroMsg.WalletBrandUI", "prepay_id starts With tax_");
            com.tencent.mm.wallet_core.b.hgC();
            if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_tax_pay, false)) {
                Log.i("MicroMsg.WalletBrandUI", "open KindaTaxPaySwitch");
                AppMethodBeat.o(182531);
                return false;
            }
            AppMethodBeat.o(182531);
            return true;
        }
        AppMethodBeat.o(182531);
        return false;
    }
}
